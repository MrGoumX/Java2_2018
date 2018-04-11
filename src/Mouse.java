public class Mouse extends Hardware{
    private String tech;
    private String connection;
    private static final String laser = "LASER";
    private static final String optical = "OPTICAL";
    private static final String wired = "WIRED";
    private static final String wireless = "WIRELESS";

    public Mouse(){
        super();
        info = "PERIPHERALS";
    }

    public Mouse(String model_name, int year, String manufacturer, double price, String tech, String connection){
        super(model_name, year, manufacturer, price);
        if(tech.equalsIgnoreCase(laser)){
            this.tech = laser;
        }
        else if(tech.equalsIgnoreCase(optical)){
            this.tech = optical;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid technology");
            }
        }
        if(connection.equalsIgnoreCase(wired)){
            this.connection = wired;
        }
        else if(connection.equalsIgnoreCase(wireless)){
            this.connection = wireless;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid connection");
            }
        }
        info = "PERIPHERALS";
    }

    public void setTech(String tech){
        if(tech.equalsIgnoreCase(laser)){
            this.tech = laser;
        }
        else if(tech.equalsIgnoreCase(optical)){
            this.tech = optical;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid technology");
            }
        }
    }

    public void setConnection(String connection){
        if(connection.equalsIgnoreCase(wired)){
            this.connection = wired;
        }
        else if(connection.equalsIgnoreCase(wireless)){
            this.connection = wireless;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid connection");
            }
        }
    }

    public String getTech(){
        return tech;
    }

    public String getConnection(){
        return connection;
    }
}
