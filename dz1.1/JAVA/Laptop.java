import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Laptop {
    private int id;
    private String brand;
    private double ram; // ОЗУ в гигабайтах
    private double hdd; // Объём ЖД в терабайтах
    private String cpu;
    private String opSys;
    private String color;
    private double price; // Цена в долларах

    public Laptop(int id, String brand, double ram, double hdd, String cpu, String opSys, String color, double price) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
        this.opSys = opSys;
        this.color = color;
        this.price = price;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public double getRam() { return ram; }
    public double getHdd() { return hdd; }
    public String getCpu() { return cpu; }
    public String getOpSys() { return opSys; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setRam(double ram) { this.ram = ram; }
    public void setHdd(double hdd) { this.hdd = hdd; }
    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setOpSys(String opSys) { this.opSys = opSys; }
    public void setColor(String color) { this.color = color; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Brand: %s, RAM: %.1f GB, HDD: %.1f TB, CPU: %s, Operating System: %s, Color: %s, Price: %.2f USD",
                id, brand, ram, hdd, cpu, opSys, color, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Laptop lap = (Laptop) obj;
        return id == lap.id &&
               Double.compare(lap.ram, ram) == 0 &&
               Double.compare(lap.hdd, hdd) == 0 &&
               brand.equals(lap.brand) &&
               color.equals(lap.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, ram, hdd, color);
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filterCriteria) {
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean matchesCriteria = true;
            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String fieldName = entry.getKey();
                Object expectedValue = entry.getValue();
                Object actualValue = getFieldValue(laptop, fieldName);
                if (expectedValue instanceof Number && actualValue instanceof Number) {
                    // Для чисел сравниваем
                    if (((Number) actualValue).doubleValue() < ((Number) expectedValue).doubleValue()) {
                        matchesCriteria = false;
                        break;
                    }
                } else if (expectedValue instanceof String && actualValue instanceof String) {
                    // Для строк сравниваем без учёта регистра
                    if (!actualValue.toString().equalsIgnoreCase(expectedValue.toString())) {
                        matchesCriteria = false;
                        break;
                    }
                }
            }
            if (matchesCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

    public static Map<String, Object> getFilterCriteria() {
        Map<String, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String choiceFilterKeyName = "";
        int choiceFilterKeyNum = 0;

        while (choiceFilterKeyNum < 1 || choiceFilterKeyNum > 4) {
            System.out.print("Введите цифру, соответствующую необходимому критерию отсеивания:\r\n" +
                    "1 - ОЗУ\r\n" +
                    "2 - Объём ЖД\r\n" +
                    "3 - Цвет\r\n" +
                    "4 - Цена в долларах\r\n");
            choiceFilterKeyNum = scanner.nextInt();
            switch (choiceFilterKeyNum) {
                case 1:
                    choiceFilterKeyName = "ram";
                    break;
                case 2:
                    choiceFilterKeyName = "hdd";
                    break;
                case 3:
                    choiceFilterKeyName = "color";
                    break;
                case 4:
                    choiceFilterKeyName = "price";
                    break;
                default:
                    System.out.print("Введите только цифру, соответствующую критерию!");
                    continue;
            }
        }
        
        // Проверка на введённое значение
        System.out.print(String.format("Введите минимальные значения для %s: ", choiceFilterKeyName));
        Object choiceFilterValue = null;
        if (choiceFilterKeyName.equals("color")) {
            choiceFilterValue = scanner.next();
        } else if (scanner.hasNextDouble()) {
            choiceFilterValue = scanner.nextDouble();
        } else {
            System.out.println("Ошибка: введено некорректное значение. Попробуйте снова.");
            scanner.close();
            return getFilterCriteria(); // Рекурсивный вызов для повторного ввода
        }

        filterCriteria.put(choiceFilterKeyName, choiceFilterValue);
        return filterCriteria;
    }

    public static Object getFieldValue(Laptop lpt, String fieldName) {
        switch (fieldName) {
            case "ram":
                return lpt.getRam();
            case "hdd":
                return lpt.getHdd();
            case "color":
                return lpt.getColor();
            case "price":
                return lpt.getPrice();
            default:
                return null;
        }
    }
}