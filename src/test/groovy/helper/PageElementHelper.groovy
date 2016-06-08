package helper

import exception.PageDoesNotExist
import geb.Page
import geb.Browser
import geb.content.SimplePageContent

class PageElementHelper {

    static String classNameFromPhrase(String phrase) {
        String className = ""
        phrase.split(" ").each { word ->
            className += word.toLowerCase().capitalize()
        }
        return className
    }

    static String elementNameFromPhrase(String phrase) {
        String elementName
        phrase.split(" ").eachWithIndex { word, i ->
            if (i == 0) {
                elementName = word.toLowerCase()
            } else {
                elementName += word.toLowerCase().capitalize()
            }
        }
        return elementName
    }

    static Class getPageClass(String pageName) {
        getGenericPageClass("page.%sPage", pageName)
    }

    private static Class getGenericPageClass(String printfStringTemplate, String pageNameAsPhrase) {
        try {
            def pageClassName = sprintf(printfStringTemplate, classNameFromPhrase(pageNameAsPhrase))
            return Class.forName(pageClassName)
        }
        catch (ClassNotFoundException me) {
            throw new PageDoesNotExist(me.message, printfStringTemplate, pageNameAsPhrase);
        }
    }

    static headingNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + 'Heading'
    }

    static moduleNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase)
    }


    static String sectionNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + "Section"
    }

    static linkNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + 'Link'
    }

    static buttonNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + 'Button'
    }

    static String inputNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + "Input"
    }

    static String iconsCollectionFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + "Icons"
    }

    static String fieldNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase) + "Field"
    }

    static String dropdownNameFromPhrase(String phrase){
        elementNameFromPhrase(phrase) + "Dropdown"
    }
    static String methodNameFromPhrase(String phrase) {
        elementNameFromPhrase(phrase)
    }

    static String getTextFromPageSection(SimplePageContent pageContent, separator = "") {
        StringBuilder builder = new StringBuilder();
        if (pageContent != null) {
            Iterator itr = pageContent.iterator();
            while (itr.hasNext()) {
                builder.append(StringHelper.tidyText(itr.next().text()));
                builder.append(separator);
            }
        }
        return builder.toString();
    }

    static String getSectionText(page, sectionNameAsPhrase) {
        def elementRef = sectionNameFromPhrase(sectionNameAsPhrase)
        getRawElementText(page, elementRef)
    }

    static getElementText(page, elementNameAsPhrase) {
        def elementRef = elementNameFromPhrase(elementNameAsPhrase)
        getRawElementText(page, elementRef)
    }

    private static String getRawElementText(page, elementRef) {
        waitForElement(page, elementRef)
        page."$elementRef".firstElement().getText()
    }

    static void waitForElement(page, elementRef) {
        Page pageObject = page
        Browser.drive {
            waitFor {
                def var = pageObject."$elementRef"
                var.isPresent() }
        }
    }

    static void waitForModuleElement(page, moduleRef, elementRef) {
        Browser.drive {
            waitFor { page."$moduleRef"."$elementRef".isPresent() }
        }
    }

    static String getModuleSectionText(page, moduleNameAsPhrase, sectionNameAsPhrase) {
        def moduleRef = elementNameFromPhrase(moduleNameAsPhrase)
        def elementRef = sectionNameFromPhrase(sectionNameAsPhrase)
        AnimationHelper.waitForAnimationsToComplete()
        waitForModuleElement(page, moduleRef, elementRef)
        page."$moduleRef"."$elementRef".firstElement().getText()
    }

}