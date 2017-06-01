import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by stephenpegram on 5/31/17.
 */

public class Parser {

    static List<Item> groceries = new ArrayList<Item>();


    public static Matcher matcherYielder(String theRegex, String checkThis) {
        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(checkThis);
        return regexMatcher;
    }


    public static String regexYielder(Matcher regexMatcher) {
        String result = "";

        while (regexMatcher.find()) {
            try {
                if ((regexMatcher.group(6).equals(null)) || ("price".contains(regexMatcher.group(3).toLowerCase()))) {
                    throw new NullPointerException();
                } else {
                    result += regexMatcher.group(3).substring(0, 1).toUpperCase() +
                            regexMatcher.group(3).replace("0", "o").substring(1, regexMatcher.group(3).length()).toLowerCase() +
                            ";" + regexMatcher.group(6) + ";" + regexMatcher.group(8) + ";";
                }
            } catch (NullPointerException e) {
                System.out.println("Had a null pointer");
            }
        }
        return result;
    }


    @SuppressWarnings("unchecked")
    public static void regexSeparator(Matcher regexMatcher) {
        while (regexMatcher.find()) {
            //System.out.println(regexMatcher.group(1) + "---" + regexMatcher.group(3) + "---" + regexMatcher.group(5));
            for (int i = 0; i < groceries.size(); i++) {
                if (regexMatcher.group(1).equals(groceries.get(i).getName())) {
                    for (int j = 0; i < groceries.get(j).info.size(); j++) {
                        if (regexMatcher.group(3).equals(groceries.get(i).info.get(j).getPrice())) {
                            groceries.get(i).info.set(j, new Info(groceries.get(i).info.get(j).getPrice(), groceries.get(i).info.get(j).getCount() + 1));
                        } else {
                            groceries.get(i).info.add(new Info(regexMatcher.group(3), 0));
                        }
                    }
                } else {
                    groceries.add(new Item((regexMatcher.group(1)), regexMatcher.group(5), regexMatcher.group(3)));
                }

            }
        }
        for(int i = 0; i < groceries.size(); i++){
            System.out.println("Name : " + groceries.get(i).getName());
            for(int j = 0; j < groceries.get(i).info.size(); j++){
                System.out.println("Price : " + groceries.get(i).info.get(j).getPrice());
                System.out.println("Count : " + groceries.get(i).info.get(j).getCount());
            }
        }
    }
}




