package holidays.asuteam.websocketapp.service

import holidays.asuteam.websocketapp.model.UsersModel
import io.reactivex.Observable


interface UserViewInterface  {
    fun onCompleted()

    fun onError(message: String)

    fun onUsers(usersModel: List<UsersModel>)

    fun getUsers(): Observable<List<UsersModel>>
}