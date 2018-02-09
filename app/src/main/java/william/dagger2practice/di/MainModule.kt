package william.dagger2practice.di

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import william.dagger2practice.ui.MainFragment
import william.dagger2practice.ui.MainViewModel

/**
 * Created by fangru.wu on 2018/02/09.
 */


@Module
internal abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

}