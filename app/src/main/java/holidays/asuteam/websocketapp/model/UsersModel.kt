package holidays.asuteam.websocketapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class UsersModel {

    @SerializedName("userId")
    @Expose
    var userId: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("body")
    @Expose
    var body: String? = null
}
