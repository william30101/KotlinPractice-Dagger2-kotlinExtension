package william.dagger2practice

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by williamwu on 29/01/2018.
 */
@Module
class MainModule {

    @Provides
    @Singleton
    fun getCloth() : Cloth = Cloth("Red")
}