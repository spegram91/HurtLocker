import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephenpegram on 6/1/17.
 */
public class Item {

    private String name;
    private String expirationDate;
    private String price;
    private int count;
    List<Info<String, Integer>> info;


    Item(String name, String expirationDate, String price){
        this.name = name;
        this.expirationDate = expirationDate;
        this.info.add(0, new Info(price, 0));
    }

    public String getName() {
        return name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }


}
