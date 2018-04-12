public class Gpu extends Hardware{
    private String chipset;
    private int gpu_ram;
    private static final String nVidia = "nVidia";
    private static final String AMD = "AMD";

    public Gpu(){
        super();
        info = "HARDWARE";
    }

    public Gpu(String model_name, int year, String manufacturer, double price, String chipset, int gpu_ram){
        super(model_name, year, manufacturer, price);
        if(chipset.equalsIgnoreCase(nVidia)){
            this.chipset = nVidia;
        }
        else if(chipset.equalsIgnoreCase(AMD)){
            this.chipset = AMD;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid chipset type");
            }
        }
        if(gpu_ram == 2 || gpu_ram == 4 || gpu_ram == 6){
            this.gpu_ram = gpu_ram;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid ram capacity");
            }
        }
        info = "HARDWARE";
    }

    public void setChipset(String chipset){
        if(chipset.equalsIgnoreCase(nVidia)){
            this.chipset = nVidia;
        }
        else if(chipset.equalsIgnoreCase(AMD)){
            this.chipset = AMD;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid chipset type");
            }
        }
    }

    public void setGpu_ram(int gpu_ram){
        if(gpu_ram == 2 || gpu_ram == 4 || gpu_ram == 6){
            this.gpu_ram = gpu_ram;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid ram capacity");
            }
        }
    }

    public String getChipset() {
        return chipset;
    }

    public int getGpu_ram(){
        return gpu_ram;
    }

    @Override
    public String toString(){
        return super.toString() + " GPU created by " + getChipset() + " with " + getGpu_ram() + " GB ram";
    }
}
