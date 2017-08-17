package holidays.asuteam.websocketapp.application

import android.app.Application
import holidays.asuteam.websocketapp.dependency_injection.*
import holidays.asuteam.websocketapp.model.Constant


class UsersApplication : Application() {

    private lateinit var mApiComponent : ApiComponent

    override fun onCreate() {
        super.onCreate()
        resolveDependency()
    }

    private fun resolveDependency() {
        var component : ApiComponent = DaggerApiComponent
                .builder()
                .networkComponent(getNetworkCOmponent())
                .build()
    }

    fun getNetworkCOmponent() : NetworkComponent{
        return DaggerNetworkComponent
                .builder()
                .networkModule(NetworkModule(Constant.BASE_URL))
                .build()
    }

    fun getApiComponent() : ApiComponent {
        return mApiComponent
    }
}