package william.dagger2practice

import android.app.Application

/**
 * Created by fangru.wu on 2018/02/08.
 */
interface AppLifecycleCallbacks {

    fun onCreate(application: Application)

    fun onTerminate(application: Application)
}