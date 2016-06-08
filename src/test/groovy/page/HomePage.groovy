package page

import geb.Page

class HomePage extends Page {
	static url = "/nhome/"
	static at = { waitFor { title.contains("Welcome") } }
	static content = {
		headings { $('#main h1') }
		firstHeading { headings[0] }
	}
}
