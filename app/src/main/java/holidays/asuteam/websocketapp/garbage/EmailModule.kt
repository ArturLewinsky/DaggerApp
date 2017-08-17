package holidays.asuteam.websocketapp.garbage

import com.squareup.okhttp.OkHttpClient
import dagger.Module
import dagger.Provides
import holidays.asuteam.websocketapp.garbage.Email
import holidays.asuteam.websocketapp.garbage.EmailApi
import javax.inject.Singleton

@Module
class EmailModule {
    var emailURL : String

    constructor(emailURL : String) {
        this.emailURL = emailURL
    }

    @Provides @Singleton
    fun providesEmail(client : EmailApi) : Email {
        return Email(client, emailURL)
    }

    @Provides @Singleton
    fun providesEmailApi(client : OkHttpClient) : EmailApi {
        return EmailApi(client)
    }
}