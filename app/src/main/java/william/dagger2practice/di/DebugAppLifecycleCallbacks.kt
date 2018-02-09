package william.dagger2practice.di

import android.app.Application
import william.dagger2practice.AppLifecycleCallbacks

/**
 * Created by fangru.wu on 2018/02/09.
 */

class DebugAppLifecycleCallbacks : AppLifecycleCallbacks {

    override fun onCreate(application: Application) {
        //Timber.plant(Timber.DebugTree())
    }

    override fun onTerminate(application: Application) {

    }
}
