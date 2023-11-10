import java.util.ArrayList;

public class Admin extends Pengguna {
    private String kataSandi;

    // Konstruktor Admin
    public Admin(String namaPengguna, String kataSandi) {
        super(namaPengguna);
        this.kataSandi = kataSandi;
    }

    // Menambahkan buku ke perpustakaan
    public void tambahBuku(String genre, String judul) {
        super.tambahBuku(genre, judul);
    }

    // Menghapus buku dari perpustakaan
    public void hapusBuku(String judul) {
        Perpustakaan.hapusBuku(judul);
    }
}
