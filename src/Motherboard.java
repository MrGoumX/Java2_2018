public class Motherboard extends Hardware {
    private String cpu_type;
    private int ram;
    private int nos;
    private static final String INTEL = "INTEL";
    private static final String AMD = "AMD";

    public Motherboard(){
        super();
        info = "HARDWARE";
    }

    public Motherboard(String model_name, int year, String manufacturer, double price, String cpu_type, int ram, int nos){
        super(model_name, year, manufacturer, price);
        if(cpu_type.equalsIgnoreCase(INTEL)){
            this.cpu_type = INTEL;
        }
        else if(cpu_type.equalsIgnoreCase(AMD)){
            this.cpu_type = AMD;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Not compatible CPU type");
            }
        }
        if(ram == 32 || ram == 64 || ram == 128){
            this.ram = ram;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid ram size");
            }
        }
        if(nos == 4 || nos == 6 || nos == 8){
            this.nos = nos;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid number of SATA ports");
            }
        }
        info = "HARDWARE";
    }

    public void setCpu_type(String cpu_type){
        if(cpu_type.equalsIgnoreCase(INTEL)){
            this.cpu_type = INTEL;
        }
        else if(cpu_type.equalsIgnoreCase(AMD)){
            this.cpu_type = AMD;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Not compatible CPU type");
            }
        }
    }

    public void setRam(int ram) {
        if(ram == 32 || ram == 64 || ram == 128){
            this.ram = ram;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid ram size");
            }
        }
    }

    public void setNos(int nos) {
        if(nos == 4 || nos == 6 || nos == 8){
            this.nos = nos;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid number of SATA ports");
            }
        }
    }

    public String getCpu_type() {
        return cpu_type;
    }

    public int getRam() {
        return ram;
    }

    public int getNos() {
        return nos;
    }
}
