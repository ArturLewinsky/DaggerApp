package holidays.asuteam.websocketapp.dependency_injection

import dagger.Component
import holidays.asuteam.websocketapp.EmailModule
import holidays.asuteam.websocketapp.NetworkModule
import holidays.asuteam.websocketapp.TestModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        EmailModule::class,
        NetworkModule::class,
        TestModule::class
))
interface NewtworkCompoment {

}