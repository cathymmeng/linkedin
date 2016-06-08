package helper

class StringHelper {

    static String tidyText(String untidyText) {
        // collapse white space to single space and take out leading and trailing spaces
        return untidyText
                .replaceAll("\\s+", " ")
                .trim()
    }

}