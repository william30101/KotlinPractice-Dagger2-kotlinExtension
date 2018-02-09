package william.dagger2practice.ui

import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by fangru.wu on 2018/02/08.
 */
@Singleton
class UserViewModel @Inject constructor() {

    val loginUserId = MutableLiveData<String>()
}