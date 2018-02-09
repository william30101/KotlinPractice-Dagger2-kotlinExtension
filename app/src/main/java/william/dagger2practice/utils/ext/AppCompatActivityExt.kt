package william.dagger2practice.utils.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by fangru.wu on 2018/02/09.
 */
inline fun FragmentActivity.setContentFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    val manager = supportFragmentManager
    val fragment = manager?.findFragmentById(containerViewId)
    fragment?.let { return it }
    return f().apply { manager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}