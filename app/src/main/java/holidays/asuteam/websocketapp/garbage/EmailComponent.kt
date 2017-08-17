package holidays.asuteam.websocketapp.garbage

import com.squareup.okhttp.OkHttpClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    EmailModule::class,
    NetworkModule::class,
        TestModule::class
))
interface EmailComponent {
    fun email() : Email
    fun network() : OkHttpClient

}