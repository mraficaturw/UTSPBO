import java.util.Scanner;

public class DemoHewan {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jenis hewan (Kucing/Anjing): ");
        String jenisHewan = scanner.nextLine().trim();

        Hewan hewan;
        if (jenisHewan.equalsIgnoreCase("Kucing")) {
            hewan = new Kucing();
        } else if (jenisHewan.equalsIgnoreCase("Anjing")) {
            hewan = new Anjing();
        } else {
            System.out.println("Jenis hewan tidak dikenali.");
            return;
        }

        hewan.bersuara();

        if (hewan instanceof Kucing) {
            System.out.println(jenisHewan + " adalah hewan " + ((Kucing) hewan).jenis() + ".");
        }  else if (hewan instanceof Anjing) {
            System.out.println(jenisHewan + " adalah hewan " + ((Anjing) hewan).jenis() + ".");
        }
        scanner.close();
    }
}
