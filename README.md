<h3>Cucumber JVM with Gradle and Geb Skeleton</h3>
<h4>This is to enable Geb Gradle using selenium ChromeDriver</h4>

This is a self exploratory example of automation framework build up on geb(selenium) & cucumber

Prerequisite to run:
1.Java and Firefox installed on your system and system path.
2.Compatible chromedriver.exe(for windows) against installed Chrome browser version, in my case
      Chrome browser Version 51.0.2704.84 m
      chromedriver version 2.53.0
chromedriver please download from http://chromedriver.storage.googleapis.com/index.html
3.Change credentials on login_steps.groovy >> test data to be relocated to login.groovy under src/test/resources/fixture

This practice reflects good practice of below:
1.Web application automation framework on Gradle Cucumber Geb thru Groovy on Chrome & Firefox browsers
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
