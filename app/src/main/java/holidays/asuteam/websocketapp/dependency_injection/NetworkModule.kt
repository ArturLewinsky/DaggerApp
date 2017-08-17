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

    @Provides
    fun provideRxJava2CallAdapterFactory() : RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun provideGsonConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverterFactory : GsonConverterFactory, callAdapterFactory : RxJava2CallAdapterFactory) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }
}