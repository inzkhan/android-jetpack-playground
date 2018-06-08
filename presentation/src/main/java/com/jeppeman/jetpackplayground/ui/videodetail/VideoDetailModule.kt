package com.jeppeman.jetpackplayground.ui.videodetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.transition.Fade
import androidx.transition.Transition
import com.jeppeman.jetpackplayground.di.ViewModelFactory
import com.jeppeman.jetpackplayground.di.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
object VideoDetailModule {
    @JvmStatic
    @Provides
    @IntoMap
    @ViewModelKey(VideoDetailViewModelImpl::class)
    fun provideVideoDetailViewModelIntoMap(videoDetailViewModelImpl: VideoDetailViewModelImpl): ViewModel =
            videoDetailViewModelImpl

    @JvmStatic
    @Provides
    fun provideVideoDetailViewModel(
            videoDetailFragment: VideoDetailFragment,
            viewModelFactory: ViewModelFactory): VideoDetailViewModel =
            ViewModelProviders.of(videoDetailFragment, viewModelFactory)[VideoDetailViewModelImpl::class.java]

    @JvmStatic
    @Provides
    fun provideVideoDetailParameter(videoDetailFragment: VideoDetailFragment): VideoDetailParameter =
            VideoDetailFragmentArgs.fromBundle(videoDetailFragment.arguments).videoDetailParameter

    @JvmStatic
    @Provides
    fun provideTransition(): Transition = Fade()

    @JvmStatic
    @Provides
    fun provideVideoDetailPlayer(videoDetailPlayerImpl: VideoDetailPlayerImpl): VideoDetailPlayer =
            videoDetailPlayerImpl
}