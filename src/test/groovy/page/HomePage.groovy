package page

import geb.Page

class HomePage extends Page {
	static at = { headings[0].text() == "Cross Browser Automation" }
	static content = {
		headings { $('#main h1') }
		firstHeading { headings[0] }
	}
}
