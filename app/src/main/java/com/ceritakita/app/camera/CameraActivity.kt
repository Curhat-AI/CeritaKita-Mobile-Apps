package com.ceritakita.app.camera


import androidx.activity.compose.setContent
import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

import java.text.SimpleDateFormat
import java.util.*
@Composable
fun CameraCaptureScreen(navController: NavController) {
    val context = LocalContext.current
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var previewView: PreviewView? by remember { mutableStateOf(null) }
    var capturedImageUri by remember { mutableStateOf<Uri?>(null) }
    val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            // Start camera
            Log.d("CameraCaptureScreen", "Permission granted")
            startCamera(context, previewView) { capture ->
                imageCapture = capture
            }
        } else {
            // Permission denied
            Log.e("CameraCaptureScreen", "Permission denied")
        }
    }

    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.CAMERA)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.weight(1f)) {
            AndroidView(
                factory = { ctx ->
                    val view = PreviewView(ctx)
                    previewView = view
                    view
                },
                modifier = Modifier.fillMaxSize()
            )
        }
        Button(onClick = {
            val uri = createImageFileUri(context)
            capturedImageUri = uri
            val outputOptions = ImageCapture.OutputFileOptions.Builder(
                context.contentResolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                createImageContentValues()
            ).build()
            imageCapture?.takePicture(outputOptions, ContextCompat.getMainExecutor(context), object : ImageCapture.OnImageSavedCallback {
                override fun onError(exception: ImageCaptureException) {
                    // Handle error
                    Log.e("CameraCaptureScreen", "Image capture failed: ${exception.message}", exception)
                }
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    // Handle success
                    Log.d("CameraCaptureScreen", "Image saved successfully: ${uri?.path}")
                    uri?.let {
                        // Lakukan sesuatu dengan uri, misalnya mengirim ke server
                    }
                }
            })
        }) {
            Text(text = "Capture Image")
        }

        capturedImageUri?.let { uri ->
            Text(text = "Image saved at: $uri")
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            cameraExecutor.shutdown()
        }
    }
}

fun startCamera(context: android.content.Context, previewView: PreviewView?, onImageCapture: (ImageCapture) -> Unit) {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
    cameraProviderFuture.addListener({
        val cameraProvider = cameraProviderFuture.get()
        val preview = Preview.Builder().build()
        val imageCapture = ImageCapture.Builder().build()

        val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA

        previewView?.let {
            preview.setSurfaceProvider(it.surfaceProvider)
        } ?: run {
            Log.e("startCamera", "PreviewView is null")
            return@addListener
        }

        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(context as ComponentActivity, cameraSelector, preview, imageCapture)
            onImageCapture(imageCapture)
            Log.d("startCamera", "Camera started successfully")
        } catch (exc: Exception) {
            Log.e("startCamera", "Failed to bind camera use cases", exc)
        }

    }, ContextCompat.getMainExecutor(context))
}

fun createImageContentValues(): ContentValues {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val imageFileName = "JPEG_${timeStamp}_"
    return ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, "$imageFileName.jpg")
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
    }
}

fun createImageFileUri(context: android.content.Context): Uri? {
    val contentResolver = context.contentResolver
    val contentValues = createImageContentValues()
    return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
}


