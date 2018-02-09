package william.dagger2practice.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import kotlinx.coroutines.experimental.async
import william.dagger2practice.Volley.APIController
import william.dagger2practice.Volley.ServiceVolley
import javax.inject.Inject

/**
 * Created by fangru.wu on 2018/02/09.
 */
class MainViewModel @Inject constructor(private val apiController: APIController) : ViewModel() {

    val ownerId = MutableLiveData<String>()
    val repos: MutableLiveData<List<String>> = MutableLiveData()

    init {
        repos.value = listOf("a","b","c")
        val service = ServiceVolley()
        val apiController = APIController(service)
        val path = "https://www.google.com"
        async {

            apiController.get(path) { response ->
                // Parse the result
                Log.v("MainViewModel", "get response " + response)
            }
        }


//        val deferred = (1..1_000_000).map { n ->
//            async {
//                Log.v("williamn", "n : " + n);
//            }
//        }
    }
}