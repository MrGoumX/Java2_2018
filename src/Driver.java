import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Hardware> products = new ArrayList<Hardware>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Sale> sales = new ArrayList<Sale>();
    private boolean done = true;
    private String answer, prod_type, ans2, temp, temp2;
    private void initiateProducts() {
        Hardware MB1 = new Motherboard("P1", 2018, "ASUS", 80, "Intel", 32, 8);
        Hardware MB2 = new Motherboard("P2", 2018, "GIGABYTE", 90, "AMD", 128, 8);
        Hardware CPU1 = new Cpu("P3", 2018, "INTEL", 340, 3.6, 8, true);
        Hardware CPU2 = new Cpu("P4", 2018, "AMD", 160, 3, 8, false);
        Hardware RAM1 = new Ram("P5", 2018, "CORSAIR", 160, "DDR4", 16, 2666);
        Hardware RAM2 = new Ram("P6", 2018, "KINGSTON", 80, "DDR3", 8, 1600);
        Hardware GPU1 = new Gpu("P7", 2018, "nVidia", 480, "nVidia", 6);
        Hardware GPU2 = new Gpu("P8", 2018, "AMD", 260, "AMD", 4);
        Hardware SSD = new Hdd("P9", 2018, "SAMSUNG", 140, "SSD", 2.5, 256);
        Hardware HDD = new Hdd("P10", 2018, "WESTERN DIGITAL", 40, "HDD", 3.5, 1000);
        Hardware MON1 = new Monitor("P11", 2018, "SAMSUNG", 180, "LED", 26, "1920x1080", "HDMI");
        Hardware MON2 = new Monitor("P12", 2018, "LG", 140, "LCD", 23.8, "1920x1080", "DISPLAY PORT");
        Hardware KEY1 = new Keyboard("P13", 2018, "DELL", 20, "Wired");
        Hardware KEY2 = new Keyboard("P14", 2018, "CORSAIR", 140, "Wired");
        Hardware MOU1 = new Mouse("P15", 2018, "MICROSOFT", 15, "Laser", "Wired");
        Hardware MOU2 = new Mouse("P16", 2018, "COOLERMASTER", 25, "Optical", "Wired");
        Hardware PRI1 = new Printer("P17", 2018, "LEXMARK", 50, "Laser", "Coloured");
        Hardware PRI2 = new Printer("P18", 2018, "HP", 30, "Inkjet", "baw");
        products.add(MB1);
        products.add(MB2);
        products.add(CPU1);
        products.add(CPU2);
        products.add(RAM1);
        products.add(RAM2);
        products.add(GPU1);
        products.add(GPU2);
        products.add(SSD);
        products.add(HDD);
        products.add(MON1);
        products.add(MON2);
        products.add(KEY1);
        products.add(KEY2);
        products.add(MOU1);
        products.add(MOU2);
        products.add(PRI1);
        products.add(PRI2);
    }

    public void start(){
        initiateProducts();
        while(done){
            System.out.println("Please choose an option");
            System.out.println("1. List products");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("1")){
                while(true) {
                    System.out.println("What do you want to see? 1. Hardware or 2. Peripherals?");
                    prod_type = scanner.nextLine();
                    if (prod_type.equalsIgnoreCase("1")){
                        temp2 = "HARDWARE";
                        break;
                    }
                    else if (prod_type.equalsIgnoreCase("2")){
                        temp2 = "PERIPHERALS";
                        break;
                    }
                    else{
                        System.out.println("Try again");
                    }
                }
                if(prod_type.equalsIgnoreCase("1")){
                    System.out.println("What kind of hardware do you want to see?");
                    System.out.println("1. Motherboard");
                    System.out.println("2. CPU");
                    System.out.println("3. RAM");
                    System.out.println("4. GPU");
                    System.out.println("5. HDD");
                    ans2 = scanner.nextLine();
                    switch (ans2) {
                        case "1":
                            temp = "Motherboard";
                            break;
                        case "2":
                            temp = "CPU";
                            break;
                        case "3":
                            temp = "RAM";
                            break;
                        case "4":
                            temp = "GPU";
                            break;
                        case "5":
                            temp = "HDD";
                            break;
                        default:
                            System.out.println("Try again");
                    }
                }
                else{
                    System.out.println("What kind of peripherals do you want to see?");
                    System.out.println("1. Monitors");
                    System.out.println("2. Keyboards");
                    System.out.println("3. Mice");
                    System.out.println("4. Printers");
                    ans2 = scanner.nextLine();
                    switch (ans2) {
                        case "1":
                            temp = "Monitor";
                            break;
                        case "2":
                            temp = "Keyboard";
                            break;
                        case "3":
                            temp = "Mouse";
                            break;
                        case "4":
                            temp = "Printer";
                            break;
                        default:
                            System.out.println("Try again");
                    }
                }
                for(Hardware i : products){
                    if(i.getClass().getName().equalsIgnoreCase(temp) && i.getInfo().equalsIgnoreCase(temp2)){
                        System.out.println(i.getManufacturer());
                    }
                }
            }
        }
    }
}