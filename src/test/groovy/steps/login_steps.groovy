import page.*

import static cucumber.api.groovy.EN.*

Given(~/I am on the "Login" page/) { ->
	to LoginPage
}

When(~/I enter ID and password/){ ->
	page.loginID = "******@gmail.com"
	page.loginPwd = "********"
}

When(~/the link to the "Cross Browser" page is clicked/) { ->
	page.crossBrowserLink.click()
}

Then(~/I am taken to the "Home" page/) { ->
	at HomePage
}
