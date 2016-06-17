import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

driver = "firefox"
//reportsDir = "build/reports/geb"
baseUrl = "https://www.linkedin.com"
waiting {
    timeout = 2
}

environments {
    firefox {
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
            new FirefoxDriver(caps)
        }
    }
}