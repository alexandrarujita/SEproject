package Patient;

/**
 * Created by Dan on 10.01.2017.
 */
public class Drug {
    private String name;
    private int price;

    public Drug(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public  Drug(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
