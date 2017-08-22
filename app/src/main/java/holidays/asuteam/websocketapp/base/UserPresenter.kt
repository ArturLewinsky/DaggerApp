package holidays.asuteam.websocketapp.base

import holidays.asuteam.websocketapp.model.UsersModel
import holidays.asuteam.websocketapp.service.UserViewInterface
import io.reactivex.Observer
import io.reactivex.disposables.Disposable




class UserPresenter : BasePresenter, Observer<List<UsersModel>>{


    private var mViewInterface : UserViewInterface

    constructor(userViewInterface: UserViewInterface) {
        this.mViewInterface = userViewInterface
    }


    override fun onNext(usersModel: List<UsersModel>) {
        mViewInterface.onUsers(usersModel)
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onComplete() {
        mViewInterface.onCompleted()
    }

    override fun onError(e: Throwable) {
        mViewInterface.onError(e.toString())
    }


    fun fetchUsers() {
        unSubscribeAll()
        subscribe(mViewInterface.getUsers(), this@UserPresenter  )
    }
}