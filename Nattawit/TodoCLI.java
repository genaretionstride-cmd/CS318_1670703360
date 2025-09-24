import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        System.out.println("โปรแกรม To-Do List (พิมพ์ exit เพื่อออก)");
        System.out.println("คำสั่งที่รองรับ:");
        System.out.println("- add <งาน>     เช่น: add อ่านหนังสือบทที่ 5");
        System.out.println("- list          แสดงรายการงานทั้งหมด");
        System.out.println("- remove <เลข>  เช่น: remove 2");
        System.out.println("- exit          ออกจากโปรแกรม");

        while (true) {
            System.out.print("\n> ");
            String line = scanner.nextLine();
            if (line == null) {
                continue;
            }

            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+", 2); // แยกคำสั่งกับอาร์กิวเมนต์
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "add":
                    if (argument.isEmpty()) {
                        System.out.println("กรุณาระบุชื่อ งาน หลังคำสั่ง add");
                    } else {
                        tasks.add(argument);
                        System.out.println("เพิ่มงานแล้ว: " + argument);
                    }
                    break;

                case "list":
                    if (tasks.isEmpty()) {
                        System.out.println("ยังไม่มีงานในลิสต์");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case "remove":
                    if (argument.isEmpty()) {
                        System.out.println("กรุณาระบุหมายเลขงานที่จะลบ เช่น remove 2");
                        break;
                    }
                    try {
                        int index = Integer.parseInt(argument);
                        if (index < 1 || index > tasks.size()) {
                            System.out.println("หมายเลขไม่ถูกต้อง (ช่วงที่ถูกต้อง: 1 - " + tasks.size() + ")");
                        } else {
                            String removed = tasks.remove(index - 1);
                            System.out.println("ลบงานแล้ว: " + removed);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("กรุณาระบุตัวเลขถัดจากคำสั่ง remove");
                    }
                    break;

                case "exit":
                    System.out.println("ลาก่อน");
                    scanner.close();
                    return;

                default:
                    System.out.println("ไม่รู้จักคำสั่ง: " + command);
                    System.out.println("ลองใช้คำสั่ง: add, list, remove, exit");
            }
        }
    }
}


