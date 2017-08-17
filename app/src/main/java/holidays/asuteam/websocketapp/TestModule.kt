package holidays.asuteam.websocketapp

import dagger.Module
import javax.inject.Inject

@Module
class TestModule {
    @Inject
    constructor() {}

    fun getValue(): String {
        return "hello Error Message"
    }
}