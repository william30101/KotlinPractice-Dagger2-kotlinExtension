package william.dagger2practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import william.dagger2practice.Volley.APIController
import william.dagger2practice.Volley.ServiceVolley
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cloth : Cloth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val build = DaggerMainComponent.builder().mainModule(MainModule()).build()
        build.inject(this)
        display_text.text = cloth.color

        request_btn.setOnClickListener { view ->
            val service = ServiceVolley()
            val apiController = APIController(service)

            val path = "https://api.apps.global.rakuten.com/configurations/configurations/pandora/10.8.0/tw?subscription-key=8f91100420d248869505d978724761db"

            apiController.get(path) { response ->
                // Parse the result
                Log.v("william", "get response " + response)
            }
         }

    }


}
