package holidays.asuteam.websocketapp.dependency_injection

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    private var mBaseUrl : String

    constructor(baseUrl : String) {
        this.mBaseUrl = baseUrl
    }

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverterFactory : GsonConverterFactory, ) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .build()
        make(GsonConverterFactory.create())
        makee(RxJava2CallAdapterFactory.create())
    }

    private fun  makee(callAdapterFactory : RxJava2CallAdapterFactory) {}

    private fun  make(gsonConverterFactory : GsonConverterFactory) {}
}