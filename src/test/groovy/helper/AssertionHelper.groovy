package helper

import geb.Browser
import geb.error.RequiredPageContentNotPresent
import geb.waiting.WaitTimeoutException


class AssertionHelper {

    static elementNotPresent(page, elementName) {
        def Boolean result
        try {
            result = !(getElementFromElementPhrase(page, elementName).isPresent())
        } catch (RequiredPageContentNotPresent e) {
            result = true
        }
        return result
    }

    static elementNotDisplayed(page, elementName) {
        def Boolean result
        try {
            result = !(getElementFromElementPhrase(page, elementName).isDisplayed())
        } catch (RequiredPageContentNotPresent e) {
            result = true
        }
        return result
    }

    static elementDisplayed(page, elementPhrase) {
        try {
            page."$elementPhrase".isDisplayed()
        } catch (WaitTimeoutException wte) {
            throw wte
        }
    }
    private static getElementFromElementPhrase(page, elementPhrase) {
        def elementName=PageElementHelper.elementNameFromPhrase(elementPhrase)
        def result = page."$elementName"
        return result
    }

    static waitForCondition(elementName, text){
        def anotherValue
        Browser.drive {
            waitFor {
                elementName.text() != text
            }
        }
        Browser.drive {
            if(elementName.text() != text){

                waitFor {anotherValue = elementName.text();
                    elementName.text() == anotherValue}
            }
        }
    }

    static waitForElementNotDisplayedOrNotPresent(page, elementName) {
        def Boolean result
        try {
            wait()
            result = !(getElementFromElementPhrase(page, elementName).isDisplayed())
            result = result || !(getElementFromElementPhrase(page, elementName).isPresent())
        } catch (RequiredPageContentNotPresent e) {
            result = true
        }
        return result
    }

    static moduleElementDisplayed(page, moduleName, elementPhrase) {
        try {
            def method1 = PageElementHelper.elementNameFromPhrase(elementPhrase)
            page."$moduleName"."$method1".isDisplayed()
        } catch (WaitTimeoutException wte) {
            System.out.println("Could not find: page.$moduleName.$elementPhrase")
            throw wte
        }
    }

    static moduleElementNotDisplayed(page, moduleName, elementPhrase) {
        def Boolean result
        try {
            def method1 = PageElementHelper.elementNameFromPhrase(elementPhrase)
            result = !(page."$moduleName"."$method1".isDisplayed())
        } catch (RequiredPageContentNotPresent e) {
            result = true
        }
        return result
    }

    static elementDisabled(page, elementName){
        def Boolean result
        try {
            result = (getElementFromElementPhrase(page, elementName).attr('disabled', true))
        }catch (RequiredPageContentNotPresent e) {
            result = false
        }
        return result
    }

    static elementEnabled(page, elementName){
        def Boolean result
        try {
            result = (getElementFromElementPhrase(page, elementName).attr('disabled', false))
        }catch (RequiredPageContentNotPresent e) {
            result = true
        }
        return result
    }
}
