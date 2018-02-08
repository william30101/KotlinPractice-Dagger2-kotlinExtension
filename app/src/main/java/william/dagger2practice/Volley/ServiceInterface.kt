package william.dagger2practice.Volley

import org.json.JSONObject

/**
 * Created by fangru.wu on 2018/02/08.
 */
interface ServiceInterface {
    fun post(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)

    fun get(path: String, completionHandler: (response: JSONObject?) -> Unit)

}