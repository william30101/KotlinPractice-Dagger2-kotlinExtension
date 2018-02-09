package william.dagger2practice

import dagger.android.support.DaggerApplication
import william.dagger2practice.Volley.BackendVolley
import william.dagger2practice.di.DaggerAppComponent
import william.dagger2practice.di.applyAutoInjector
import william.dagger2practice.ui.UserViewModel
import javax.inject.Inject

/**
 * Created by fangru.wu on 2018/02/08.
 */
class App : DaggerApplication() {

    @Inject lateinit var appLifecycleCallbacks: AppLifecycleCallbacks
    @Inject lateinit var userViewModel: UserViewModel

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
        BackendVolley.onCreate(this)
        appLifecycleCallbacks.onCreate(this)
        userViewModel.loginUserId.value = "williamwu"
    }

    override fun onTerminate() {
        appLifecycleCallbacks.onTerminate(this)
        super.onTerminate()
    }

}