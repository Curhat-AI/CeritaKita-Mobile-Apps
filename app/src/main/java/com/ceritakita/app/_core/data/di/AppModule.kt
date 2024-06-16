//package com.ceritakita.app._core.data.di
//
//import com.ceritakita.app.history.data.repository.EmotionDetectionHistoryRepository
//import com.google.firebase.firestore.FirebaseFirestore
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    fun provideFirebaseFirestore(): FirebaseFirestore {
//        return FirebaseFirestore.getInstance()
//    }
//
//    @Provides
//    fun provideEmotionDetectionHistoryRepository(firestore: FirebaseFirestore): EmotionDetectionHistoryRepository {
//        return EmotionDetectionHistoryRepository(firestore)
//    }
//}
