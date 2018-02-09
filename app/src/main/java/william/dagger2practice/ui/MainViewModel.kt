package william.dagger2practice.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by fangru.wu on 2018/02/09.
 */
class MainViewModel @Inject constructor() : ViewModel() {

    val ownerId = MutableLiveData<String>()
    val repos: MutableLiveData<List<String>> = MutableLiveData()

    init {
        repos.value = listOf("a","b","c")
    }
}