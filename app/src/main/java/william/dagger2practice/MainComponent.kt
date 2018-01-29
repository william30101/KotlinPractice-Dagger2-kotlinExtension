package william.dagger2practice

import dagger.Component
import javax.inject.Singleton

/**
 * Created by williamwu on 29/01/2018.
 */
@Singleton
@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}