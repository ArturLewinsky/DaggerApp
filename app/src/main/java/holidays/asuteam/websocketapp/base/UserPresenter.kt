package holidays.asuteam.websocketapp.base

import holidays.asuteam.websocketapp.model.UsersModel
import holidays.asuteam.websocketapp.service.UserViewInterface
import io.reactivex.observers.DisposableObserver


class UserPresenter : BasePresenter{

    private var mViewInterface : UserViewInterface

    constructor(userViewInterface: UserViewInterface) {
        this.mViewInterface = userViewInterface
    }

    fun fetchUsers() {
        unSubscribeAll()
        subscribe(mViewInterface.getUsers(), object : DisposableObserver<List<UsersModel>>() {
            override fun onComplete() {
                mViewInterface.onCompleted()
            }

            override fun onError(e: Throwable) {
                mViewInterface.onError(e.toString())

            }

            override fun onNext(userModel : List<UsersModel> ) {
                mViewInterface.onUsers(userModel)
            }
        })

    }
}