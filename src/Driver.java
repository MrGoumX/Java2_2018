import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Driver {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Hardware> products = new ArrayList<Hardware>();
    private Map<Hardware, Integer> available = new HashMap<Hardware, Integer>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Sale> sales = new ArrayList<Sale>();
    private ArrayList<Sale> comp_sales = new ArrayList<Sale>();
    private boolean done = true;
    private String answer, prod_type, ans2, temp, temp2, name, phone, kind, mn, man, cpu_type;
    private int year, ram, sata, cores, size, sn;
    private double cost, price, freq;

    public void start(){
        initiateProducts();
        while(done){
            System.out.println("Please choose an option");
            System.out.println("1. List products");
            System.out.println("2. Add a product");
            System.out.println("3. Order");
            System.out.println("0. Exit");
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
                for(Hardware i : products) {
                    if (i.getClass().getName().equalsIgnoreCase(temp) && i.getInfo().equalsIgnoreCase(temp2)) {
                        System.out.println(i.toString());
                    }
                }
                while(true){
                    System.out.println("Would you like to order a product?");
                    System.out.println("1. Order by product name");
                    System.out.println("0. Exit");
                    answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("1")){
                        System.out.println("Please give name of product");
                        answer = scanner.nextLine();
                        Hardware toSell = null;
                        for(Hardware j : products){
                            if(j.getClass().getName().equalsIgnoreCase(temp) && j.getInfo().equalsIgnoreCase(temp2) && j.getModel_name().equalsIgnoreCase(answer)){
                                toSell = j;
                            }
                        }
                        if(toSell != null) {
                            if (available.get(toSell) > 0) {
                                System.out.println("You can order that product. Please provide the rest information needed");
                                cost = calcCost(toSell);
                                Sale sale = new Sale();
                                sale.setProduct(toSell);
                                while (true) {
                                    System.out.println("Give fullname");
                                    name = scanner.nextLine();
                                    if (name.matches("[A-Za-z]+")) {
                                        sale.setFullname(name);
                                        break;
                                    } else {
                                        System.out.println("Not valid name. Try again");
                                    }
                                }
                                while (true) {
                                    System.out.println("Give phone");
                                    phone = scanner.nextLine();
                                    if (phone.matches("\\d{10}+")) {
                                        sale.setPhone(phone);
                                        break;
                                    } else {
                                        System.out.println("Invalid phone number. Try again");
                                    }
                                }
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date date = new Date();
                                sale.setDate(dateFormat.format(date).toString());
                                sale.setCost(cost);
                                available.replace(toSell, available.get(toSell) - 1);
                                sales.add(sale);
                                break;
                            }
                            else {
                                System.out.println("Product is out of stock");
                                break;
                            }
                        }
                        else{
                            System.out.println("Invalid product given try again");
                        }
                    }
                    else if (answer.equalsIgnoreCase("0")) {
                        break;
                    }
                }
            }
            else if(answer.equalsIgnoreCase("2")){
                System.out.println("What kind of product would you like to add?");
                System.out.println("1. Hardware");
                System.out.println("2. Peripheral");
                System.out.println("0. Exit");
                kind = scanner.nextLine();
                if(kind.equalsIgnoreCase("1")){
                    System.out.println("What kind of hardware do you want to add?");
                    System.out.println("1. Motherboard");
                    System.out.println("2. CPU");
                    System.out.println("3. RAM");
                    System.out.println("4. GPU");
                    System.out.println("5. HDD");
                    System.out.println("0. Exit");
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
                        case "0":
                            temp = "Exit";
                            break;
                        default:
                            System.out.println("Try again");
                    }
                    if(temp.equalsIgnoreCase("Motherboard")){
                        Motherboard MB = new Motherboard();
                        baseInfo(MB);
                        while(true) {
                            System.out.println("Please give type of CPU supported");
                            cpu_type = scanner.nextLine();
                            MB.setCpu_type(cpu_type);
                            if(MB.getCpu_type()!=null){
                                break;
                            }
                        }
                        while (true){
                            System.out.println("Give maximum supported ram");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                ram = Integer.parseInt(temp2);
                                MB.setRam(ram);
                                if(MB.getRam()!=0) {
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Give maximum SATA ports");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                sata = Integer.parseInt(temp2);
                                MB.setNos(sata);
                                if(MB.getNos()!=0) {
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(MB);
                        available.put(MB, 0);
                    }
                    else if(temp.equalsIgnoreCase("CPU")){
                        Cpu cpu = new Cpu();
                        baseInfo(cpu);
                        while(true) {
                            System.out.println("Please give CPU frequency");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                freq = Double.parseDouble(temp2);
                                cpu.setFrequency(freq);
                                if(cpu.getFrequency()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give CPU cores");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                cores = Integer.parseInt(temp2);
                                cpu.setCores(cores);
                                if(cpu.getCores()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give if cpu has integrated graphics. Answer by True or False");
                            temp2 = scanner.nextLine();
                            if(temp2.equalsIgnoreCase("true") || temp2.equalsIgnoreCase("false")){
                                cpu.setIntegrated_gfx(Boolean.parseBoolean(temp2));
                                if(cpu.getIntegrated_gfx()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(cpu);
                        available.put(cpu, 0);
                    }
                    else if(temp.equalsIgnoreCase("RAM")){
                        Ram ram = new Ram();
                        baseInfo(ram);
                        while(true){
                            System.out.println("Please give RAM type");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                ram.setType(temp2);
                                if(ram.getType()!=null) {
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give RAM capacity");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                size = Integer.parseInt(temp2);
                                ram.setSize(size);
                                if(ram.getSize()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give RAM frequency");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                ram.setFrequency(Integer.parseInt(temp2));
                                if(ram.getFrequency()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                    }
                    else if(temp.equalsIgnoreCase("GPU")){
                        Gpu gpu = new Gpu();
                        baseInfo(gpu);
                        while(true){
                            System.out.println("Please give GPU chipset");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                gpu.setChipset(temp2);
                                if(gpu.getChipset()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while (true){
                            System.out.println("Please give GPU ram");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                gpu.setGpu_ram(Integer.parseInt(temp2));
                                if(gpu.getGpu_ram()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(gpu);
                        available.put(gpu, 0);
                    }
                    else if(temp.equalsIgnoreCase("HDD")){
                        Hdd hdd = new Hdd();
                        baseInfo(hdd);
                        while(true){
                            System.out.println("Please give HDD type");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                hdd.setHdd_type(temp2);
                                if(hdd.getHdd_type()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give HDD size");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                hdd.setSize(Double.parseDouble(temp2));
                                if(hdd.getSize()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give HDD capacity");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                hdd.setCapacity(Integer.parseInt(temp2));
                                if(hdd.getCapacity()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(hdd);
                        available.put(hdd, 0);
                    }
                    else if(temp.equalsIgnoreCase("Exit")){
                        break;
                    }
                    else{
                        System.out.println("Invalid option. Try again");
                    }
                }
                else if(kind.equalsIgnoreCase("2")){
                    System.out.println("What kind of peripheral do you want to add?");
                    System.out.println("1. Monitors");
                    System.out.println("2. Keyboards");
                    System.out.println("3. Mice");
                    System.out.println("4. Printers");
                    System.out.println("0. Exit");
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
                        case "0":
                            temp = "Exit";
                            break;
                        default:
                            System.out.println("Try again");
                    }
                    if(temp.equalsIgnoreCase("Monitor")){
                        Monitor mon = new Monitor();
                        baseInfo(mon);
                        while(true){
                            System.out.println("Please give Monitor type");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                mon.setMonitor_type(temp2);
                                if(mon.getMonitor_type()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give size of Monitor");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("\\d+")){
                                mon.setInches(Double.parseDouble(temp2));
                                if(mon.getInches()!=0){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give resolution of Monitor");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z0-9]+")){
                                mon.setResolution(temp2);
                                if(mon.getResolution()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give port of Monitor");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                mon.setPorts(temp2);
                                if(mon.getPorts()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(mon);
                        available.put(mon, 0);
                    }
                    else if(temp.equalsIgnoreCase("Keyboard")){
                        Keyboard key = new Keyboard();
                        baseInfo(key);
                        while(true){
                            System.out.println("Please give keyboard connection");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                key.setConnection(temp2);
                                if(key.getConnection()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(key);
                        available.put(key, 0);
                    }
                    else if(temp.equalsIgnoreCase("Mouse")){
                        Mouse mou = new Mouse();
                        baseInfo(mou);
                        while(true){
                            System.out.println("Please give mouse technology");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                mou.setTech(temp2);
                                if(mou.getTech()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give mouse connection");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                mou.setConnection(temp2);
                                if(mou.getConnection()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(mou);
                        available.put(mou, 0);
                    }
                    else if(temp.equalsIgnoreCase("Printer")){
                        Printer pri = new Printer();
                        baseInfo(pri);
                        while(true){
                            System.out.println("Please give Printer technology");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                pri.setTech(temp2);
                                if(pri.getTech()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        while(true){
                            System.out.println("Please give Printer type");
                            temp2 = scanner.nextLine();
                            if(temp2.matches("[A-Za-z]+")){
                                pri.setPrinter_type(temp2);
                                if(pri.getPrinter_type()!=null){
                                    break;
                                }
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        products.add(pri);
                        available.put(pri, 0);
                    }
                    else if(temp.equalsIgnoreCase("Exit")){
                        break;
                    }
                    else{
                        System.out.println("Invalid option. Try again");
                    }
                }
                else if(kind.equalsIgnoreCase("0")){
                    break;
                }
                else{
                    System.out.println("Invalid option. Try again");
                }
            }
            else if(answer.equalsIgnoreCase("3")){
                Sale sale = null;
                Order order = new Order();
                while(true){
                    System.out.println("Please choose Sale by name");
                    for(Sale i : sales){
                        System.out.println(i.toString());
                    }
                    while(true){
                        temp = scanner.nextLine();
                        if(temp.matches("\\d+")){
                            sn = Integer.parseInt(temp);
                            break;
                        }
                        else{
                            System.out.println("Invalid data. Try again");
                        }
                    }
                    for(Sale i : sales){
                        if(i.getSale_number() == sn){
                            sale = i;
                        }
                    }
                    if(sale == null){
                        System.out.println("Sale does not exist");
                        break;
                    }
                    else {
                        order.setSale(sale);
                        while (true) {
                            System.out.println("Give fullname");
                            name = scanner.nextLine();
                            if (name.matches("[A-Za-z]+")) {
                                order.setFullname(name);
                                break;
                            } else {
                                System.out.println("Not valid name. Try again");
                            }
                        }
                        while (true) {
                            System.out.println("Give phone");
                            phone = scanner.nextLine();
                            if (phone.matches("\\d{10}+")) {
                                order.setPhone(phone);
                                break;
                            } else {
                                System.out.println("Invalid phone number. Try again");
                            }
                        }
                        while (true) {
                            System.out.println("Give date of arrival");
                            temp = scanner.nextLine();
                            if (temp.matches("\\d{2}/\\d{2}/\\d{4}")) {
                                order.setArrive_date(temp);
                                break;
                            }
                            else{
                                System.out.println("Invalid data. Try again");
                            }
                        }
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new Date();
                        order.setOrder_date(dateFormat.format(date).toString());
                        order.setCost(sale.getCost());
                        orders.add(order);
                        break;
                    }
                }
            }
            else if(answer.equalsIgnoreCase("0")){
                System.out.println("Thank you");
                done = false;
            }
            else{
                System.out.println("Not a valid option. Try again");
            }
        }
    }

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
        available.put(MB1, 2);
        available.put(MB2, 2);
        available.put(CPU1, 2);
        available.put(CPU2, 2);
        available.put(RAM1, 2);
        available.put(RAM2, 2);
        available.put(GPU1, 2);
        available.put(GPU2, 2);
        available.put(SSD, 2);
        available.put(HDD, 2);
        available.put(MON1, 2);
        available.put(MON2, 2);
        available.put(KEY1, 2);
        available.put(KEY2, 2);
        available.put(MOU1, 2);
        available.put(MOU2, 2);
        available.put(PRI1, 2);
        available.put(PRI2, 2);
    }

    private double calcCost(Hardware toSell) {
        if(toSell.getInfo().equalsIgnoreCase("HARDWARE")){
            return toSell.getPrice()*.75;
        }
        else{
            return toSell.getPrice()*.90;
        }
    }

    private void baseInfo(Hardware HW){
        while(true){
            System.out.println("Please give a model name");
            boolean found = false;
            mn = scanner.nextLine();
            for(Hardware i : products){
                if(i.getModel_name().equalsIgnoreCase(mn)){
                    found = true;
                }
            }
            if(!found){
                HW.setModel_name(mn);
                break;
            }
            else{
                System.out.println("Product already exists. Try again");
            }
        }
        while(true){
            System.out.println("Please give year of creation.");
            temp2 = scanner.nextLine();
            if(temp2.matches("\\d+")){
                year = Integer.parseInt(temp2);
                HW.setYear(year);
                break;
            }
            else{
                System.out.println("Invalid data. Try again");
            }
        }
        System.out.println("Please give name of manufacturer");
        man = scanner.nextLine();
        HW.setManufacturer(man);
        while(true){
            System.out.println("Please give price.");
            temp2 = scanner.nextLine();
            if(temp2.matches("\\d+")){
                price = Double.parseDouble(temp2);
                HW.setPrice(price);
                break;
            }
            else{
                System.out.println("Invalid data. Try again");
            }
        }
    }
}