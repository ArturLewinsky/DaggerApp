package holidays.asuteam.websocketapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import holidays.asuteam.websocketapp.*
import holidays.asuteam.websocketapp.application.UsersApplication
import holidays.asuteam.websocketapp.base.UserPresenter
import holidays.asuteam.websocketapp.model.UsersModel
import holidays.asuteam.websocketapp.service.UserViewInterface
import io.reactivex.Observable
import holidays.asuteam.websocketapp.service.UsersService
import javax.inject.Inject
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import butterknife.ButterKnife
import holidays.asuteam.websocketapp.model.UserAdapter
import android.app.ProgressDialog

import android.widget.Toast

class MainActivity : AppCompatActivity(), UserViewInterface, UserAdapter.UserClickListener {


    @Inject
    lateinit var mService : UsersService // pobranie danych

    @BindView(R.id.recyclerView)
    lateinit var mRecyclerView: RecyclerView

    private lateinit var  mAdapter: UserAdapter // Holder
    private lateinit var mDialog: ProgressDialog
    private lateinit var mPresenter: UserPresenter // DI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resolveDependency()
        ButterKnife.bind(MainActivity@this)
        configViews()
        mPresenter = UserPresenter(MainActivity@this)

        mPresenter.onCreate()
    }

    fun resolveDependency() {
        (application as UsersApplication)
                .getApiComponent()
                .inject(this@MainActivity)
    }

    override fun getUsers(): Observable<List<UsersModel>> {
        return this.mService.getUsers()
    }

    override fun onUsers(usersModel: List<UsersModel>) {
        mAdapter.addUsers(usersModel)
    }

    override fun onError(message: String) {
        mDialog.dismiss()
        Toast.makeText(getApplicationContext(), message + "This is fucking error", Toast.LENGTH_LONG).show()
    }

    override fun onCompleted() {
        mDialog.dismiss()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
        mPresenter.fetchUsers()
        mDialog = ProgressDialog(MainActivity@this)
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        mDialog.setTitle("Downloading List")
        mDialog.setMessage("Please wait...")
        mDialog.show()

    }

    private fun configViews() {
        this.mRecyclerView.recycledViewPool = RecyclerView.RecycledViewPool()
        this.mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        this.mRecyclerView.setHasFixedSize(true)
        this.mRecyclerView.itemAnimator = DefaultItemAnimator()
        this.
        mAdapter = UserAdapter(this, layoutInflater)
        this.mRecyclerView.adapter = mAdapter
    }

    override fun onClick(position: Int, name: String) {
        Toast.makeText(getApplicationContext(), "You clicked on " + name, Toast.LENGTH_SHORT).show()
    }
}

