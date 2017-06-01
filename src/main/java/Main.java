import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Matcher;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

        String regexPattern = "([Nn]\\w{2}[Ee])(\\W+)(\\w+)(\\W+)?(\\D\\w+:)(\\d+.\\d\\d)*(;type:Food.expiration:)(\\d+\\/\\d+\\/\\d+)";
        String refinedRegexPattern = "(\\w+)(;)(\\d+.\\d+)(;)(\\d+\\/\\d+\\/\\d+)";
        Matcher matcher = Parser.matcherYielder(regexPattern, output);

        String regexResult = Parser.regexYielder(matcher);
        Matcher refinedMatcher = Parser.matcherYielder(refinedRegexPattern, regexResult);
        Parser.regexSeparator(refinedMatcher);


    }
}