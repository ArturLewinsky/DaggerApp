package holidays.asuteam.websocketapp.dependency_injection

import dagger.Module
import dagger.Provides
import holidays.asuteam.websocketapp.service.UsersService
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @CustomScope
    fun usersService(retrofit : Retrofit) : UsersService {
        return retrofit.create(UsersService::class.java)
    }

}
