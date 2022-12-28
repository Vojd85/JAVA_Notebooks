package HomeWorks.Seminar6;

public class Notebook {
    String type; // Ultrabook Gamebook MacBook
    int price; // 20000 30000 45000 70000 90000 54000
    String chipset; // Intel AMD Apple
    String system; // Windows Linux macOS
    int chipsetValue; // 2 4 6 8
    int ram; // 4 8 16 32
    int hdd; // 240 512 1024 128
    public Notebook(String type, int price, String chipset, String system, int chipsetValue, int ram, int hdd){
        this.type = type;
        this.price = price;
        this.chipset = chipset;
        this.system = system;
        this.chipsetValue = chipsetValue;
        this.ram = ram;
        this.hdd = hdd;
    }
    @Override
    public String toString() {
        return String.format("%s {%s %dx, sys: %s, RAM: %d, HDD: %d, Price: %dp}", type, chipset, chipsetValue, system, ram, hdd, price);
    }
}
