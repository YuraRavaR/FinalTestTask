package data;

public class Product {
    private String name;
    private String price;
    private String availability;
    private String code;

    public Product() {
    }

    public Product(String name, String price, String availability, String code) {
        this.name = name;
        this.price = price;
        this.availability = availability;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
