package holidays.asuteam.websocketapp.ui


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import holidays.asuteam.websocketapp.R

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
