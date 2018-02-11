package william.dagger2practice.Volley

import android.content.Context
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by fangru.wu on 2018/02/08.
 */
class BackendVolley{

    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(context)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>, tag: String) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue?.add(request)
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        if (requestQueue != null) {
            requestQueue!!.cancelAll(tag)
        }
    }


    companion object {
        private lateinit var context: Context

        private val TAG = BackendVolley::class.java.simpleName
        @get:Synchronized var instance: BackendVolley? = null
        private set


        fun initialize(context: Context) {
            this.context = context.applicationContext
            instance = BackendVolley()
        }
    }

}