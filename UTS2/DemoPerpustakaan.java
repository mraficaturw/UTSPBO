import java.util.Scanner;

public class DemoPerpustakaan {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exitProgram = false;

        do {
            System.out.println("Selamat datang di Perpustakaan!");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. List Buku");
            System.out.println("0. Exit");
            System.out.print("Pilih peran Anda (1/2/3/0): ");
            int peran = readInt();

            switch (peran) {
                case 1:
                    menuUser();
                    break;

                case 2:
                    System.out.print("Masukkan password admin: ");
                    String password = scanner.nextLine();

                    if (password.equals("admin123")) {
                        menuAdmin();
                    } else {
                        System.out.println("Password admin tidak valid.");
                    }
                    break;

                case 3:
                    System.out.println("Buku yang tersedia:");
                    Perpustakaan.tampilkanBuku();
                    break;

                case 0:
                    exitProgram = true;
                    break;

                default:
                    System.out.println("Peran tidak valid.");
                    break;
            }
        } while (!exitProgram);

        System.out.println("Terima kasih telah menggunakan sistem pengelolaan perpustakaan.");
        // Menutup Scanner
        scanner.close();
    }

    private static void menuAdmin() {
        Admin admin = new Admin("Admin1", "admin123");
        boolean returnToMain = false;

        do {
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("0. Return to Main Menu");
            System.out.print("Pilih tindakan admin: ");

            try {
                int tindakan = readInt();

                switch (tindakan) {
                    case 1:
                        System.out.println("Buku yang tersedia:");
                        Perpustakaan.tampilkanBuku();
                        System.out.print("Masukkan genre buku baru: ");
                        String genreBaru = scanner.nextLine();
                        System.out.print("Masukkan judul buku baru: ");
                        String judulBaru = scanner.nextLine();
                        admin.tambahBuku(genreBaru, judulBaru);
                        System.out.println("Buku berhasil ditambahkan.");
                        Perpustakaan.tampilkanBuku(); // Updated book list
                        break;

                    case 2:
                        System.out.println("Buku yang tersedia:");
                        Perpustakaan.tampilkanBuku();
                        System.out.print("Masukkan nomor urut buku yang akan dihapus: ");
                        int nomorHapus = readInt();
                        if (nomorHapus >= 1 && nomorHapus <= Perpustakaan.getJumlahBuku()) {
                            String judulHapus = Perpustakaan.getJudulBukuByNomor(nomorHapus);
                            admin.hapusBuku(judulHapus);
                            System.out.println("Buku '" + judulHapus + "' berhasil dihapus.");
                            Perpustakaan.tampilkanBuku(); // Updated book list
                        } else {
                            System.out.println("Nomor urut buku tidak valid.");
                        }
                        break;

                    case 0:
                        returnToMain = true;
                        break;

                    default:
                        System.out.println("Tindakan tidak valid.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Masukkan angka yang valid.");
                scanner.nextLine(); // Membersihkan buffer
            } catch (java.util.NoSuchElementException e) {
                System.out.println("Masukkan tidak valid. Silakan coba lagi.");
                scanner.nextLine(); // Membersihkan buffer
            }
        } while (!returnToMain);
    }

    private static void menuUser() {
        User user = new User("User1");
        boolean returnToMain = false;

        do {
            System.out.println("Menu User:");
            System.out.println("1. Pinjam Buku");
            System.out.println("0. Return to Main Menu");
            System.out.print("Pilih tindakan user: ");

            try {
                int tindakan = readInt();

                switch (tindakan) {
                    case 1:
                        System.out.println("Buku yang tersedia:");
                        Perpustakaan.tampilkanBuku();
                        int jumlahBuku;
                        do {
                            System.out.print("Masukkan jumlah buku yang ingin Anda pinjam: ");
                            jumlahBuku = readInt();
                            if (jumlahBuku <= 0) {
                                System.out.println("Masukkan jumlah buku yang valid (minimal 1).");
                            }
                        } while (jumlahBuku <= 0);

                        StringBuilder bukuDipinjam = new StringBuilder("Buku yang Anda pinjam:\n");

                        for (int i = 0; i < jumlahBuku; i++) {
                            System.out.print("Masukkan nomor urut buku yang ingin Anda pinjam: ");
                            int nomorBuku = readInt();
                            if (nomorBuku >= 1 && nomorBuku <= Perpustakaan.getJumlahBuku()) {
                                String judulPinjam = Perpustakaan.getJudulBukuByNomor(nomorBuku);
                                user.pinjamBuku(judulPinjam);
                                bukuDipinjam.append("- ").append(judulPinjam).append("\n");
                                System.out.println("Buku '" + judulPinjam + "' berhasil dipinjam.");
                            } else {
                                System.out.println("Nomor urut buku tidak valid.");
                                i--; // Mengulang iterasi agar user memilih ulang buku yang valid
                            }
                        }

                        System.out.println(bukuDipinjam);
                        break;

                    case 0:
                        returnToMain = true;
                        break;

                    default:
                        System.out.println("Tindakan tidak valid.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Masukkan angka yang valid.");
                scanner.nextLine(); // Membersihkan buffer
            } catch (java.util.NoSuchElementException e) {
                System.out.println("Masukkan tidak valid. Silakan coba lagi.");
                scanner.nextLine(); // Membersihkan buffer
            }
        } while (!returnToMain);
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Masukkan angka yang valid.");
            scanner.nextLine(); // Membersihkan buffer
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
        return input;
    }
}
