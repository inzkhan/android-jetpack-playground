package com.jeppeman.jetpackplayground.ui

import androidx.lifecycle.ViewModelProviders
import com.jeppeman.jetpackplayground.di.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module
object ContainerModule {
    @JvmStatic
    @Provides
    @PerActivity
    fun provideContainerViewModel(containerActivity: ContainerActivity): ContainerViewModel =
            ViewModelProviders.of(containerActivity)[ContainerViewModel::class.java]
}