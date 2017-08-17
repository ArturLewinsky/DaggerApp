package holidays.asuteam.websocketapp

import com.squareup.okhttp.OkHttpClient

class EmailApi {
    var client: OkHttpClient

    constructor(client : OkHttpClient) {
        this.client = client
    }

    fun sendEmail(body : String, emailURL : String?) {
        println("Once:" + body)
        println("Twice:" + emailURL)
    }
}