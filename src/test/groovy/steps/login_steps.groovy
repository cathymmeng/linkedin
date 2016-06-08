import page.*

import static cucumber.api.groovy.EN.*

Given(~/I am on the "Login" page/) { ->
    to LoginPage
}

When(~/I enter ID and password/) { ->
    at LoginPage
    page.loginID = "********"
    page.loginPwd = "********"
    waitFor { page.signInButton.isEnabled() }
    page.signInButton.click()
}

Then(~/I am taken to the "Home" page/) { ->
    at HomePage
}
