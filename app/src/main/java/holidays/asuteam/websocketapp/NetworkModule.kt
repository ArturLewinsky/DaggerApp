package holidays.asuteam.websocketapp

import com.squareup.okhttp.OkHttpClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient()
    }
}