package william.dagger2practice.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import william.dagger2practice.R
import william.dagger2practice.Volley.APIController
import william.dagger2practice.utils.ext.setContentFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var apiController: APIController

    override fun supportFragmentInjector() = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentFragment(R.id.containerLayout) { MainFragment.newInstance() }
//
//        val path = "http://data.taipei/opendata/datalist/apiAccess?scope=datasetMetadataSearch&q=id:7996eec3-e88a-4abc-b602-42c81932a9f6"
//        request_btn.setOnClickListener { view ->
//                apiController.get(path) { response ->
//                    // Parse the result
//                    Log.v("MainViewModel", "get response " + response)
//                }
//        }

    }
}
