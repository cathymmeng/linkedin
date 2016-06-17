package page
import geb.Page

class LoginPage extends Page {
	static url = "/"
    static at = { waitFor { title.contains("LinkedIn") } }
	static content = {
		loginID { $('input#login-email') }
		loginPwd { $('input#login-password') }
        signInButton { $("input[name='submit']") }
	}

//    def enableSignInButton() {
//        page.loginID = "***"
//        page.loginPwd = "***"
//        waitFor { signInButton.isEnabled() }
//    }
}