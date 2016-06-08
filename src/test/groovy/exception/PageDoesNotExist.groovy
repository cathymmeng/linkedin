package exception

import helper.PageElementHelper;

public class PageDoesNotExist extends RuntimeException{
    private final String ERROR_MESSAGE_PRINTF_TEMPLATE = """
                Tried to load "%s" class dynamically using meta programming but it does not exist yet! (Should it?)
                In order to dynamically get the page to be instantiated you must make sure of the following:
                1. The java package at %s must exist
                2. The java/groovy class %s must exist
                3. How come we are looking for %s?
                  3.1 We got the input from the step and camelised it (so 'hello there now' would become HelloWorldNow)
                  3.2 We then substitute that value into the printf template which is '%s' (so if the template were 'page.cover.%sCoverPage' it would look for the fully qualified package 'page.cover.HelloWorldNowCoverPage')
            """;

    public PageDoesNotExist(String message, String printfStringTemplate, String pageName) {
        def fullyQualifiedPath = sprintf(printfStringTemplate, [PageElementHelper.elementNameFromPhrase(pageName)])
        def fragments =  fullyQualifiedPath.tokenize(".")

        def designatedPackage = fragments.subList(0, fragments.size - 1).join(".")
        def designatedClass = fragments.last()
        System.err.println(sprintf(ERROR_MESSAGE_PRINTF_TEMPLATE, [fullyQualifiedPath, designatedPackage,
                                                                   designatedClass, designatedClass, printfStringTemplate, "%s"]));
    }
}
