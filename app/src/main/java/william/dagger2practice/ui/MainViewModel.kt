package william.dagger2practice.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.json.JSONArray
import org.json.JSONException
import william.dagger2practice.Volley.APIController
import william.dagger2practice.data.Bus
import javax.inject.Inject

/**
 * Created by fangru.wu on 2018/02/09.
 */
class MainViewModel @Inject constructor(private val apiController: APIController) : ViewModel() {

    @Inject lateinit var gson: Gson

    val ownerId = MutableLiveData<String>()
    val repos: MutableLiveData<List<String>> = MutableLiveData()
    val buses: MutableLiveData<List<Bus>> = MutableLiveData()

    val mBuses: MutableList<Bus> = ArrayList()

    init {
        repos.value = listOf("a","b","c")
        val path = "http://data.taipei/opendata/datalist/apiAccess?scope=datasetMetadataSearch&q=id:7996eec3-e88a-4abc-b602-42c81932a9f6"
        async {

            apiController.get(path) { response ->
                // Parse the result
                Log.v("MainViewModel", "get response " + response)
                try {
                    val results: JSONArray = response!!.getJSONObject("result").getJSONArray("results")
                    for (i in 0..results.length() - 1) {
                        mBuses.add(gson.fromJson<Bus>(results.getJSONObject(i).toString()))
                        Log.v("MainViewModel", "test : " + mBuses[i])
                    }

                    if (!mBuses.isEmpty()) {
                        buses.value = mBuses
                    }

                } catch (e: JSONException) {
                    Log.v("MainViewModel", e.toString())
                }

            }
        }
    }
}