public class Printer extends Hardware{
    private String tech;
    private String printer_type;
    private static final String laser = "LASER";
    private static final String inkjet = "INKJET";
    private static final String baw = "BAW";
    private static final String coloured = "COLOURED";

    public Printer(){
        super();
        info = "PERIPHERALS";
    }

    public Printer(String model_name, int year, String manufacturer, double price, String tech, String printer_type){
        super(model_name, year, manufacturer, price);
        if(tech.equalsIgnoreCase(laser)){
            this.tech = laser;
        }
        else if(tech.equalsIgnoreCase(inkjet)){
            this.tech = inkjet;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid technology");
            }
        }
        if(printer_type.equalsIgnoreCase(baw)){
            this.printer_type = baw;
        }
        else if(printer_type.equalsIgnoreCase(coloured)){
            this.printer_type = coloured;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type");
            }
        }
        info = "PERIPHERALS";
    }

    public void setTech(String tech){
        if(tech.equalsIgnoreCase(laser)){
            this.tech = laser;
        }
        else if(tech.equalsIgnoreCase(inkjet)){
            this.tech = inkjet;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid technology");
            }
        }
    }

    public void setPrinter_type(String printer_type){
        if(printer_type.equalsIgnoreCase(baw)){
            this.printer_type = baw;
        }
        else if(printer_type.equalsIgnoreCase(coloured)){
            this.printer_type = coloured;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type");
            }
        }
    }

    public String getTech(){
        return tech;
    }

    public String getPrinter_type(){
        return printer_type;
    }
}
