package holidays.asuteam.websocketapp.application


import android.app.Application

import holidays.asuteam.websocketapp.dependency_injection.*
import holidays.asuteam.websocketapp.model.Constant


class UsersApplication : Application(){


    private lateinit var mApiComponent: ApiComponent

    override fun onCreate() {

        resolveDependency()
        super.onCreate()
    }

    private fun resolveDependency() {
        mApiComponent = DaggerApiComponent
                .builder()
                .networkComponent(getNetworkComponent())
                .build()
    }

    fun getNetworkComponent(): NetworkComponent{
        return DaggerNetworkComponent
                .builder()
                .networkModule(NetworkModule(Constant.BASE_URL))
                .build()
    }

    fun getApiComponent(): ApiComponent {
        return mApiComponent
    }
}