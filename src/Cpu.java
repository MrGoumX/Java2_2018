public class Cpu extends Hardware{
    private double frequency;
    private int cores;
    private Boolean integrated_gfx;

    public Cpu(){
        super();
        info = "HARDWARE";
    }

    public Cpu(String model_name, int year, String manufacturer, double price, double frequency, int cores, boolean integrated_gfx){
        super(model_name, year, manufacturer, price);
        if(frequency == 3 || frequency == 3.6 || frequency == 4){
            this.frequency = frequency;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid frequency");
            }
        }
        if(cores == 6 || cores == 8 || cores == 16){
            this.cores = cores;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid number of cores");
            }
        }
        this.integrated_gfx = integrated_gfx;
        info = "HARDWARE";
    }

    public void setFrequency(double frequency){
        if(frequency == 3 || frequency == 3.6 || frequency == 4){
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

    public void setCores(int cores){
        if(cores == 6 || cores == 8 || cores == 16){
            this.cores = cores;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid number of cores");
            }
        }
    }

    public void setIntegrated_gfx(boolean integrated_gfx){
        this.integrated_gfx = integrated_gfx;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCores() {
        return cores;
    }

    public Boolean getIntegrated_gfx(){
        return integrated_gfx;
    }

    @Override
    public String toString(){
        return super.toString() + " CPU with " + getCores() + " cores at " + getFrequency() + " MHz" + (getIntegrated_gfx() ? " with " : " without ") + "integrated graphics";
    }
}
