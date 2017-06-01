/**
 * Created by stephenpegram on 6/1/17.
 */
public class Item {

    private String name;
    private String price;
    private String expirationDate;
    private int count;


    Item(String name, String price,  String expirationDate, int count){
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }


    public int getCount() {
        return count;
    }


    public void increment(){
        this.count++;
    }
}
