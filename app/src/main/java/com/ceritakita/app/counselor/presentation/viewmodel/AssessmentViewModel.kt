package com.ceritakita.app.counselor.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class AssessmentViewModel : ViewModel() {
    var currentStep by mutableStateOf(1)
    var mentoring by mutableStateOf(false)
    var counseling by mutableStateOf(false)
    // Tambahkan lebih banyak state yang sesuai dengan kebutuhan Anda

    // Fungsi untuk berpindah ke step berikutnya
    fun onNextStep() {
        if (canProceedToNextStep()) {
            currentStep++
            prepareNextStep()
        }
    }

    // Fungsi untuk kembali ke step sebelumnya
    fun onPreviousStep() {
        if (currentStep > 1) {
            currentStep--
        }
        // Anda bisa menambahkan logika persiapan untuk kembali ke step sebelumnya jika perlu
    }

    // Fungsi untuk memeriksa apakah transisi ke step berikutnya adalah valid
    private fun canProceedToNextStep(): Boolean {
        // Contoh validasi sederhana
        when (currentStep) {
            1 -> return mentoring || counseling
            // Tambahkan lebih banyak kondisi untuk step-step berikutnya
            else -> return true
        }
    }

    // Fungsi untuk persiapan sebelum memasuki step berikutnya
    private fun prepareNextStep() {
        // Contoh persiapan data atau state
        when (currentStep) {
            // Misal jika step 1 selesai, siapkan data untuk step 2
            1 -> {
                // Misal, reset atau siapkan data yang diperlukan untuk step 2
            }
        }
    }
}