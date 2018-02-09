package william.dagger2practice.di

import dagger.Module
import dagger.Provides
import william.dagger2practice.Volley.APIController
import william.dagger2practice.Volley.BackendVolley
import william.dagger2practice.Volley.ServiceVolley
import javax.inject.Singleton

/**
 * Created by fangru.wu on 2018/02/09.
 */
@Module
internal object DataModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideServiceVolley() = ServiceVolley()

    @Singleton
    @Provides
    @JvmStatic
    fun provideApiController(serviceVolley: ServiceVolley) = APIController(serviceVolley)

    @Singleton
    @Provides
    @JvmStatic
    fun provideApiController(backendVolley: BackendVolley) = BackendVolley

//    @Singleton
//    @Provides
//    @JvmStatic
//    fun provideMoshi() = Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//            .build()
//
//    @Singleton
//    @Provides
//    @JvmStatic
//    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor()
//                    .apply { level = HttpLoggingInterceptor.Level.BODY })
//            .build()
//
//    @Singleton
//    @Provides
//    @JvmStatic
//    fun provideRetrofit(oktHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
//            .client(oktHttpClient)
//            .baseUrl("https://api.github.com")
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//    @Singleton
//    @Provides
//    @JvmStatic
//    fun provideGitHubService(retrofit: Retrofit): GitHubService = retrofit.create(GitHubService::class.java)

}