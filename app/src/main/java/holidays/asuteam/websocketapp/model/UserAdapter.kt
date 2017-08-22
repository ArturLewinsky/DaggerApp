package holidays.asuteam.websocketapp.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import holidays.asuteam.websocketapp.R
import android.widget.TextView




open class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder> {


    private val mInflater : LayoutInflater
    private var mUsersList : ArrayList<UsersModel>
    private var mListener : UserClickListener

    constructor(mListener : UserClickListener, inflater : LayoutInflater  ) {
        this.mInflater = inflater
        this.mUsersList = ArrayList<UsersModel>()
        this.mListener = mListener
    }


    override fun onCreateViewHolder(parent : ViewGroup ,viewType : Int): Holder {
        return Holder(mInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: Holder ,position: Int ) {

    }

    fun addUsers(usersModel: List<UsersModel>) {
        mUsersList.addAll(usersModel)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mUsersList.size
    }

    inner class Holder : RecyclerView.ViewHolder, View.OnClickListener {

        var mPhoto: ImageView
        var mName: TextView
        var mPrice: TextView

        constructor(itemView : View) : super(itemView) {
            mPhoto = itemView.findViewById<View>(R.id.flowerPhoto) as ImageView
            mName = itemView.findViewById<View>(R.id.flowerName) as TextView
            mPrice = itemView.findViewById<View>(R.id.flowerPrice) as TextView
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {

        }
    }

    interface UserClickListener {
        fun onClick(position: Int, name: String)
    }

}
