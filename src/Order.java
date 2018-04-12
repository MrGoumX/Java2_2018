public class Order {
    private static int orders = 0;
    private int order_number;
    private Sale sale;
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

    public Order(Sale sale, String fullname, String phone, String order_date, String arrive_date, double cost, String status){
        this.order_number = orders;
        this.sale = sale;
        this.fullname = fullname;
        this.phone = phone;
        this.order_date = order_date;
        this.arrive_date = arrive_date;
        this.cost = cost;
        this.status = "Expected";
        orders++;
    }

    public void setSale(Sale sale){
        this.sale = sale;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setOrder_date(String order_date){
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

    public Sale getSale() {
        return sale;
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

    public String toString(){
        return "Sale with ID: " + getOrder_number() + " initiated by " + getFullname() + " with phone number " + getPhone() + " for sale " + getSale().toString() + " with cost " + getCost() + " created on " + getOrder_date() + " expected to be delivered by " + getArrive_date();
    }
}
