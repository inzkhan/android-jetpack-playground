package com.jeppeman.jetpackplayground.di

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.jeppeman.jetpackplayground.FakeApplication
import com.jeppeman.jetpackplayground.UIThread
import com.jeppeman.jetpackplayground.data.executor.JobExecutor
import com.jeppeman.jetpackplayground.domain.executor.PostExecutionThread
import com.jeppeman.jetpackplayground.domain.executor.ThreadExecutor
import com.jeppeman.jetpackplayground.domain.repository.VideoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FakeAppModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideContext(application: FakeApplication): Context = application

    @JvmStatic
    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @JvmStatic
    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread

    @JvmStatic
    @Provides
    @Singleton
    fun provideMainThreadHandler(): Handler = Handler(Looper.getMainLooper())

    @JvmStatic
    @Provides
    @Singleton
    fun provideFakeVideoRepository(fakeVideoRepository: FakeVideoRepository): VideoRepository = fakeVideoRepository
}