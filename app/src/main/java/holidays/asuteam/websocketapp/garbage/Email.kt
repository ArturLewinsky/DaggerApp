package holidays.asuteam.websocketapp.garbage

class Email {
    var client : EmailApi
    var emailURL : String

    constructor(client: EmailApi, emailURL: String) {
        this.client = client
        this.emailURL = emailURL
    }

    fun send(body : String) : Boolean {
        client.sendEmail(body, emailURL)
        return true
    }
}