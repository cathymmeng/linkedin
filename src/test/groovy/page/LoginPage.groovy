package page
import geb.Page

class LoginPage extends Page {
	static url = "https://www.linkedin.com/"
	static at = { title == "Sign In" }
	static content = {
		loginID { $('input#login-email') }
		loginPwd { $('input#login-password') }
//		crossBrowserLink(to: CrossBrowserPage) { $('li.crossbrowser a') }
	}
}