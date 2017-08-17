package holidays.asuteam.websocketapp.service

import holidays.asuteam.websocketapp.model.UsersModel
import io.reactivex.Observable
import retrofit2.http.GET

interface UsersService {
    @GET("/posts/1")
    fun getUsers() : Observable<List<UsersModel>>
}