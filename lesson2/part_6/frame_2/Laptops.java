package lesson2.part_6.frame_2;

public class Laptops {

    private String catalogNumber;
    private String model;
    private String briefDescription;
    private String screenSize;
    private String cpu;
    private int ram;
    private int hdd;
    private boolean opticalDrive;
    private OperatingSystem operatingSystem;
    private Color color;
    private int warranty;
    private int price;

    public Laptops() {
        this(null,null,null,null,0,0,false,null,null,0,0);
    }

    public Laptops(String catalogNumber, String model, String screenSize, String cpu, int ram, int hdd,
                  boolean opticalDrive, OperatingSystem operatingSystem, Color color, int warranty, int price) {
        this.catalogNumber = catalogNumber;
        this.model = model;
        this.screenSize = screenSize;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.opticalDrive = opticalDrive;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.warranty = warranty;
        this.price = price;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public boolean isOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(boolean opticalDrive) {
        this.opticalDrive = opticalDrive;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printLaptops(){
        System.out.print("Catalog number: " + getCatalogNumber() + ", ");
        System.out.print("Brief description: " + getBriefDescription() + ", ");
        System.out.println("Price: " + getPrice());
    }
}
