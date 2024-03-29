public class Sale {
    private static int sales = 0;
    private static int compl_sales = 0;
    private int sale_number;
    private Hardware product;
    private Order order;
    private String fullname;
    private String phone;
    private String date;
    private double cost;

    public Sale(){
        this.sale_number = sales;
    }

    public Sale(Hardware product, String fullname, String phone, String date, double cost){
        this.sale_number = sales;
        this.product = product;
        this.fullname = fullname;
        this.phone = phone;
        this.date = date;
        this.cost = cost;
    }

    public Sale(Order order, String fullname, String phone, String date, double cost){
        this.sale_number = compl_sales;
        this.order = order;
        this.fullname = fullname;
        this.phone = phone;
        this.date = date;
        this.cost = cost;
    }

    public static void incrSales(){
        sales++;
    }

    public static void incrCompSales(){
        compl_sales++;
    }

    public void setProduct(Hardware product){
        this.product = product;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public Hardware getProduct() {
        return product;
    }

    public String getFullname(){
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public int getSale_number() {
        return sale_number;
    }

    public double getCost(){
        return cost;
    }

    public String toString(){
        return "Sale with ID: " + getSale_number() + " initiated by " + getFullname() + " with phone number " + getPhone() + " for product " + getProduct().getModel_name() + " with cost " + getCost() + " created on " + getDate();
    }
}
