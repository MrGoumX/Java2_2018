public class Order {
    private static int orders = 0;
    private int order_number;
    private Hardware product;
    private String fullname;
    private String phone;
    private String order_date;
    private String arrive_date;
    private double cost;
    private String status;

    public Order(){
        this.order_number = orders;
        this.status = "Expected";
        orders++;
    }

    public Order(Hardware product, String fullname, String phone, String order_date, String arrive_date, double cost, String status){
        this.order_number = orders;
        this.product = product;
        this.fullname = fullname;
        this.phone = phone;
        this.order_date = order_date;
        this.arrive_date = arrive_date;
        this.cost = cost;
        this.status = "Expected";
        orders++;
    }

    public void setProduct(Hardware product){
        this.product = product;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setOrder_number(String order_date){
        this.order_date = order_date;
    }

    public void setArrive_date(String arrive_date){
        this.arrive_date = arrive_date;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

   public void changeStatus(){
        if(status.equalsIgnoreCase("Expected")){
            status = "Arrived";
        }
   }

    public Hardware getProduct() {
        return product;
    }

    public int getOrder_number() {
        return order_number;
    }

    public double getCost() {
        return cost;
    }

    public String getArrive_date() {
        return arrive_date;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStatus() {
        return status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getPhone(){
        return phone;
    }

}
