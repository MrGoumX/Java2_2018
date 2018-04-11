public class Hdd extends Hardware{
    private String ram_type;
    private double size;
    private int capacity;
    private static final String SSD = "SSD";
    private static final String HDD = "HDD";

    public Hdd(){
        super();
        info = "HARDWARE";
    }

    public Hdd(String model_name, int year, String manufacturer, double price, String ram_type, double size, int capacity){
        super(model_name, year, manufacturer, price);
        if(ram_type.equalsIgnoreCase(SSD)){
            this.ram_type = SSD;
        }
        else if(ram_type.equalsIgnoreCase(HDD)){
            this.ram_type = HDD;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type");
            }
        }
        if(size == 1.8 || size == 2.5 || size == 3.5){
            this.size = size;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid size");
            }
        }
        if(capacity == 256 || capacity == 500 || capacity == 750 || capacity == 1000){
            this.capacity = capacity;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid capacity");
            }
        }
        info = "HARDWARE";
    }

    public void setRam_type(String ram_type){
        if(ram_type.equalsIgnoreCase(SSD)){
            this.ram_type = SSD;
        }
        else if(ram_type.equalsIgnoreCase(HDD)){
            this.ram_type = HDD;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type");
            }
        }
    }

    public void setSize(double size){
        if(size == 1.8 || size == 2.5 || size == 3.5){
            this.size = size;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid size");
            }
        }
    }

    public void setCapacity(int capacity){
        if(capacity == 256 || capacity == 500 || capacity == 750 || capacity == 1000){
            this.capacity = capacity;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid capacity");
            }
        }
    }

    public String getRam_type(){
        return ram_type;
    }

    public double getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
