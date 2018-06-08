package com.jeppeman.jetpackplayground.ui.videolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.jeppeman.jetpackplayground.di.ViewModelFactory
import com.jeppeman.jetpackplayground.di.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
object VideoListModule {
    @JvmStatic
    @Provides
    @IntoMap
    @ViewModelKey(VideoListViewModelImpl::class)
    fun provideVideoListViewModelIntoMap(videoListViewModelImpl: VideoListViewModelImpl): ViewModel =
            videoListViewModelImpl

    @JvmStatic
    @Provides
    fun provideVideoListViewModel(
            videoListFragment: VideoListFragment,
            viewModelFactory: ViewModelFactory): VideoListViewModel =
            ViewModelProviders.of(videoListFragment, viewModelFactory)[VideoListViewModelImpl::class.java]
}