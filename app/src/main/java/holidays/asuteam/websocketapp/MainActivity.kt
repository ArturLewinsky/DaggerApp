package holidays.asuteam.websocketapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var error: TestModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component: EmailComponent = DaggerEmailComponent
                .builder()
                .emailModule(EmailModule("devlanding@gmail.com"))
                .networkModule(NetworkModule())
                .build()

        var email : Email = component.email()
        email.send("body")

        var newEmail : Email = component.email()
        newEmail.send("newbody")



    }
}
