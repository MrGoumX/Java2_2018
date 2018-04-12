public class Monitor extends Hardware{
    private String monitor_type;
    private double inches;
    private String resolution;
    private String ports;
    private static final String LCD = "LCD";
    private static final String LED = "LED";
    private static final String DP = "DISPLAY PORT";
    private static final String HDMI = "HDMI";
    private static final String DVI = "DVI";

    public Monitor(){
        super();
        info = "PERIPHERALS";
    }

    public Monitor(String model_name, int year, String manufacturer, double price, String monitor_type, double inches, String resolution, String ports){
        super(model_name, year, manufacturer, price);
        if(monitor_type.equalsIgnoreCase(LCD)){
            this.monitor_type = LCD;
        }
        else if(monitor_type.equalsIgnoreCase(LED)){
            this.monitor_type = LED;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid Monitor Type");
            }
        }
        this.inches = inches;
        this.resolution = resolution;
        if(ports.equalsIgnoreCase(DP)){
            this.ports = DP;
        }
        else if(ports.equalsIgnoreCase(HDMI)){
            this.ports = HDMI;
        }
        else if(ports.equalsIgnoreCase(DVI)){
            this.ports = DVI;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid Port");
            }
        }
        info = "PERIPHERALS";
    }

    public void setMonitor_type(String monitor_type){
        if(monitor_type.equalsIgnoreCase(LCD)){
            this.monitor_type = LCD;
        }
        else if(monitor_type.equalsIgnoreCase(LED)){
            this.monitor_type = LED;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid Monitor Type");
            }
        }
    }

    public void setInches(double inches){
        this.inches = inches;
    }

    public void setResolution(String resolution){
        this.resolution = resolution;
    }

    public void setPorts(String ports){
        if(ports.equalsIgnoreCase(DP)){
            this.ports = DP;
        }
        else if(ports.equalsIgnoreCase(HDMI)){
            this.ports = HDMI;
        }
        else if(ports.equalsIgnoreCase(DVI)){
            this.ports = DVI;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid Port");
            }
        }
    }

    public String getMonitor_type() {
        return monitor_type;
    }

    public double getInches() {
        return inches;
    }

    public String getResolution() {
        return resolution;
    }

    public String getPorts(){
        return ports;
    }

    @Override
    public String toString(){
        return super.toString() + " Monitor type of " + getMonitor_type() + " with size of " + getInches() + " and resolution of " + getResolution() + " with " + getPorts() + " ports";
    }
}
