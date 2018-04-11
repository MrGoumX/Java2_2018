public class Keyboard extends Hardware{
    private String connection;
    private static final String wired = "WIRED";
    private static final String wireless = "WIRELESS";

    public Keyboard(){
        super();
        info = "PERIPHERALS";
    }

    public Keyboard(String model_name, int year, String manufacturer, double price, String connection){
        super(model_name, year, manufacturer, price);
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

    public String getConnection(){
        return connection;
    }
}
