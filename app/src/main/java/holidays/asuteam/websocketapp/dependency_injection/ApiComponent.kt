package holidays.asuteam.websocketapp.dependency_injection

import dagger.Component
import holidays.asuteam.websocketapp.ui.MainActivity

@CustomScope
@Component(
        modules = arrayOf(ApiModule::class),
        dependencies = arrayOf (NetworkComponent::class))

interface ApiComponent {
    fun inject(activity: MainActivity)
}