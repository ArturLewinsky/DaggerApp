package holidays.asuteam.websocketapp.dependency_injection

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {
    fun retrofit(): Retrofit
}