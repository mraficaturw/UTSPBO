import java.util.ArrayList;

public class Pengguna {
    private String namaPengguna;
    private ArrayList<Buku> buku;

    // Konstruktor
    public Pengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
        this.buku = new ArrayList<>();
    }

    // Menampilkan buku yang dimiliki pengguna
    public void tampilkanBuku() {
        System.out.println("Buku yang dimiliki oleh " + namaPengguna + ":");
        for (Buku book : buku) {
            System.out.println(book.getGenre() + " - " + book.getJudul());
        }
        System.out.println();
    }

    // Menambahkan buku ke koleksi pengguna
    public void tambahBuku(String genre, String judul) {
        Buku book = new Buku(genre, judul);
        Perpustakaan.tambahBuku(book);
        buku.add(book);
    }

    // Mendapatkan koleksi buku pengguna
    protected ArrayList<Buku> getBuku() {
        return buku;
    }
}
