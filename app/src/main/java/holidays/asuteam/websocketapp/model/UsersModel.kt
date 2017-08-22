package holidays.asuteam.websocketapp.model

import com.google.gson.annotations.Expose

/**
 * Created by Artur on 17.08.2017.
 */
class UsersModel {
    @Expose
    var userId: Int? = null
    @Expose
    var id: Int? = null
    @Expose
    var title: String? = null
    @Expose
    var body: String? = null
}