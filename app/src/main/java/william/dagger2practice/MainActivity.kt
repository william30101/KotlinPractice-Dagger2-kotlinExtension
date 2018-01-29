package william.dagger2practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
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

    }


}
