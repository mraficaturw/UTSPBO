import java.util.ArrayList;

public class Perpustakaan {
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();

    // Inisialisasi buku di perpustakaan
    static {
        daftarBuku.add(new Buku("Fiksi", "To Kill a Mockingbird"));
        daftarBuku.add(new Buku("Non-Fiksi", "Educated"));
        daftarBuku.add(new Buku("Sains", "A Brief History of Time"));
    }

    // Menambahkan buku ke perpustakaan
    public static void tambahBuku(Buku book) {
        daftarBuku.add(book);
    }

    // Menghapus buku dari perpustakaan
    public static void hapusBuku(String judul) {
        for (Buku book : daftarBuku) {
            if (book.getJudul().equals(judul)) {
                daftarBuku.remove(book);
                break;
            }
        }
    }

    // Menampilkan keseluruhan buku di perpustakaan
    public static void tampilkanBuku() {
        for (int i = 0; i < daftarBuku.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBuku.get(i).getGenre() + " - " + daftarBuku.get(i).getJudul());
        }
        System.out.println();
    }

    // Mendapatkan jumlah buku di perpustakaan
    public static int getJumlahBuku() {
        return daftarBuku.size();
    }

    // Mendapatkan judul buku berdasarkan nomor urut
    public static String getJudulBukuByNomor(int nomor) {
        if (nomor >= 1 && nomor <= daftarBuku.size()) {
            return daftarBuku.get(nomor - 1).getJudul();
        } else {
            return null;
        }
    }
}
