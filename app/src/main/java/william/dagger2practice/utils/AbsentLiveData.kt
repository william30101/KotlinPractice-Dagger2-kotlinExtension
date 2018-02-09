package william.dagger2practice.utils

import android.arch.lifecycle.LiveData

/**
 * Created by fangru.wu on 2018/02/09.
 */

class AbsentLiveData<T> private constructor() : LiveData<T>() {
    init {
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}
