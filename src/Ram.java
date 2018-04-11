public class Ram extends Hardware{
    private String type;
    private int size;
    private int frequency;
    private static final String DDR2 = "DDR2";
    private static final String DDR3 = "DDR3";
    private static final String DDR4 = "DDR4";

    public Ram(){
        super();
        info = "HARDWARE";
    }

    public Ram(String model_name, int year, String manufacturer, double price, String type, int size, int frequency) {
        super(model_name, year, manufacturer, price);
        if(type.equalsIgnoreCase(DDR2)){
            this.type = DDR2;
        }
        else if(type.equalsIgnoreCase(DDR3)){
            this.type = DDR3;
        }
        else if(type.equalsIgnoreCase(DDR4)){
            this.type = DDR4;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid ram type");
            }
        }
        if(size == 4 || size == 8 || size == 16){
            this.size = size;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid capacity");
            }
        }
        if(frequency == 1600 || frequency == 2666 || frequency == 4600){
            this.frequency = frequency;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid frequency");
            }
        }
        info = "HARDWARE";
    }

    public void setType(String type){
        if(type.equalsIgnoreCase(DDR2)){
            this.type = DDR2;
        }
        else if(type.equalsIgnoreCase(DDR3)){
            this.type = DDR3;
        }
        else if(type.equalsIgnoreCase(DDR4)){
            this.type = DDR4;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid ram type");
            }
        }
    }

    public void setSize(int size){
        if(size == 4 || size == 8 || size == 16){
            this.size = size;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid capacity");
            }
        }
    }

    public void setFrequency(int frequency){
        if(frequency == 1600 || frequency == 2666 || frequency == 4600){
            this.frequency = frequency;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid frequency");
            }
        }
    }

    public String getType(){
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getFrequency() {
        return frequency;
    }
}
