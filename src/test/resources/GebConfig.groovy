import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

driver = "chrome"
baseUrl = "https://www.linkedin.com"
waiting {
    timeout = 2
}

//Replace the absolute path pointing to the place where your chromedriver locates
System.setProperty("webdriver.chrome.driver", new File("C:/workspace/seleniumdrivers/chromedriver.exe").getAbsolutePath())

environments {
    chrome {
        driver = {
            caps = new DesiredCapabilities();

            caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            if (System.props.'http.proxyHost') {

                String PROXY = System.props.'http.proxyHost' + ":" + System.props.'http.proxyPort'

                proxy = new org.openqa.selenium.Proxy();
                proxy.setHttpProxy(PROXY)
                        .setFtpProxy(PROXY)
                        .setSslProxy(PROXY)
                        .setNoProxy("127.0.0.1, *.local, localhost");

                caps.setCapability(CapabilityType.PROXY, proxy);

            }
            new ChromeDriver(caps)
        }
    }
}

//Use the code below for testing on Firefox browser
//environments {
//    firefox {
//        driver = {
//            caps = new DesiredCapabilities();
//
//            caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//
//            if (System.props.'http.proxyHost') {
//
//                String PROXY = System.props.'http.proxyHost' + ":" + System.props.'http.proxyPort'
//
//                proxy = new org.openqa.selenium.Proxy();
//                proxy.setHttpProxy(PROXY)
//                        .setFtpProxy(PROXY)
//                        .setSslProxy(PROXY)
//                        .setNoProxy("127.0.0.1, *.local, localhost");
//
//                caps.setCapability(CapabilityType.PROXY, proxy);
//
//            }
//            new FirefoxDriver(caps)
//        }
//    }
//}