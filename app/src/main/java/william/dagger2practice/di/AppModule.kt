package william.dagger2practice.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import william.dagger2practice.AppLifecycleCallbacks
import javax.inject.Singleton

/**
 * Created by fangru.wu on 2018/02/09.
 */
@Module(includes = [DataModule::class])
internal object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application.applicationContext

}