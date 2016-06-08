<h3>Cucumber JVM with Gradle and Geb Skeleton</h3>

This is a self exploratory example of automation framework build up on geb(selenium) & cucumber

Prerequisite to run:
Java and Firefox installed on your system and system path.
Change credentials on login_steps.groovy >> test data to be relocated to login.groovy under src/test/resources/fixture

This practice reflects good practice of below:
1.Web application automation testing on Geb and Selenium, thru programming language of Groovy
2.Data driven
3.Page Object Model

From a command line run:
```
  ./gradlew cathyLinkedin
```
From windows run:
```
   gradlew.bat cathyLinkedin
```
