public abstract class Hardware {
    protected String model_name;
    protected int year;
    protected String manufacturer;
    protected double price;
    protected String info;

    public Hardware(){
    }

    public Hardware(String model_name, int year, String manufacturer, double price){
        this.model_name = model_name;
        this.year = year;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public void setModel_name(String model_name){
        this.model_name = model_name;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getModel_name() {
        return model_name;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo(){
        return info;
    }
}
