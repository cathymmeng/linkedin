package page

import geb.Page

class LoginPage extends Page {
	static at = { title == "Sign In" }
	static content = {
		loginID { $('input#session_key-login') }
		loginPwd { $('input#session_password-login.password') }
//		crossBrowserLink(to: CrossBrowserPage) { $('li.crossbrowser a') }
	}
}
