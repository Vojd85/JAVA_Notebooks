/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, 
отвечающие фильтру. Критерии фильтрации можно хранить в Map. 
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. */

package HomeWorks.Seminar6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Itogovoe {

    public static void main(String[] args) {
        Notebook n1 = new Notebook("Ultrabook", 54000, "Intel", "Windows", 6, 16, 512);
        Notebook n2 = new Notebook("Notebook", 20000, "AMD", "Linux", 2, 4, 128);
        Notebook n3 = new Notebook("MacBook", 45000, "Apple", "macOS", 4, 8, 512);
        Notebook n4 = new Notebook("Ultrabook", 30000, "Intel", "Windows", 4, 8, 240);
        Notebook n5 = new Notebook("MacBook", 70000, "Apple", "macOS", 6, 16, 1024);
        Notebook n6 = new Notebook("GameBook", 90000, "AMD", null, 8, 32, 1024);
        System.out.println(n1);
        HashSet<Notebook> nb = new HashSet<>();
        nb.add(n1);
        nb.add(n2);
        nb.add(n3);
        nb.add(n4);
        nb.add(n5);
        nb.add(n6);
        Scanner scan = new Scanner(System.in);
        printNotebooks(sortParams(scan), nb);
        scan.close();
    }
    
    static HashMap<String, String> sortParams(Scanner scan){
        System.out.println("Добро пожаловать в магазин ноутбуков!");
        System.out.println("Выберите критерий для поиска (введите цифру): ");
        System.out.println("1. Показать все 2. Тип ноутбука 3. ПО 4. RAM 5. HDD 6. Цена(руб)");
        HashMap<String, String> map = new HashMap<>(1);
        int input = scan.nextInt();
        scan.nextLine();
        if (input == 1){
            return map;
        }
        else if (input == 2){
            System.out.println("Введите тип: Ultrabook GameBook Notebook MacBook");
            String type = scan.nextLine();
            map.put("type", type);
        }
        else if (input == 3){
            System.out.println("Введите ПО: Windows macOS Linux");
            String system = scan.nextLine();
            map.put("sys", system);
        }
        else if (input == 4){
            System.out.println("Введите количество RAM: 4 и более");
            String ram = scan.nextLine();
            map.put("ram", ram);
        }
        else if (input == 5){
            System.out.println("Введите размер HDD: 128 и более");
            String hdd = scan.nextLine();
            map.put("hdd", hdd);
        }
        else if (input == 6){
            System.out.println("Цена от: ");
            String price = scan.nextLine();
            map.put("price", price);
        }
        return map;
    }
    static void printNotebooks(HashMap<String, String> map, HashSet<Notebook> nb){
        if (map.keySet().toArray()[0] == "type"){
            for(Notebook x: nb){
                if (x.type.equals(map.get(map.keySet().toArray()[0]))){
                    System.out.println(x);
                }
            }
        }
        else if (map.keySet().toArray()[0] == "sys"){
            for(Notebook x: nb){
                if (x.system.equals(map.get(map.keySet().toArray()[0]))){
                    System.out.println(x);
                }
            }
        }
        else if (map.keySet().toArray()[0] == "ram"){
            int intValue = Integer.parseInt(map.get(map.keySet().toArray()[0]));
            for(Notebook x: nb){
                if (x.ram >= intValue){
                    System.out.println(x);
                }
            }
        }
        else if (map.keySet().toArray()[0] == "hdd"){
            int intValue = Integer.parseInt(map.get(map.keySet().toArray()[0]));
            for(Notebook x: nb){
                if (x.hdd >= intValue){
                    System.out.println(x);
                }
            }
        }
        else if (map.keySet().toArray()[0] == "price"){
            int intValue = Integer.parseInt(map.get(map.keySet().toArray()[0]));
            for(Notebook x: nb){
                if (x.price >= intValue){
                    System.out.println(x);
                }
            }
        } else {System.out.println("Поиск не дал результатов");}
    }
}
