import java.util.Locale;

public class LearnStrings {
    public static void main(String[] args) {
        System.out.println("abc".contentEquals("abc"));
        String phoneNumber = "   (763) 872-6633".strip();
        String areaCode = parseAreaCode(phoneNumber);
        String exchange = parseExchange(phoneNumber);
        String lineNumber = parseLineNumber(phoneNumber);

        System.out.println(areaCode);
        System.out.println(exchange);
        System.out.println(lineNumber);
    }

    public static String parseAreaCode(String phoneNumber) {
        int openParens = phoneNumber.indexOf("(");
        int closeParens = phoneNumber.indexOf(")");
        String areaCode = phoneNumber.substring(openParens + 1, closeParens);
        return areaCode;
    }

    public static String parseExchange(String phoneNumber) {
        int spaceIdx = phoneNumber.indexOf(" ");
        int hyphenIdx = phoneNumber.indexOf("-");
        String exchange = phoneNumber.substring(spaceIdx + 1, hyphenIdx);
        return exchange;
    }

    public static String parseLineNumber(String phoneNumber) {
        int hyphenIdx = phoneNumber.indexOf("-");
        String lineNumber = phoneNumber.substring(hyphenIdx + 1);
        return lineNumber;
    }


}
