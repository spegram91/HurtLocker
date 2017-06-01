/**
 * Created by stephenpegram on 6/1/17.
 */
public class Info <T, U>{

    private T price;
    private U count;

    Info(T price, U count){
        this.price = price;
        this.count = count;
    }

    Info(){
        this.price = null;
        this.count = null;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public T getPrice() {
        return price;
    }

    public U getCount() {
        return count;
    }


    @Override
    public String toString(){
        return "$"+getPrice()+", "+getCount();
    }
}


