package holidays.asuteam.websocketapp.base


interface Presenter {

    fun onCreate()

    fun onPause()

    fun onResume()

    fun onDestroy()
}