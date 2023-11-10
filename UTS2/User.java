import java.util.ArrayList;

public class User extends Pengguna {
    // Konstruktor User
    public User(String namaPengguna) {
        super(namaPengguna);
    }

    // Menampilkan buku yang dipinjam oleh user
    public void tampilkanBuku() {
        System.out.println("Buku yang Anda pinjam:");
        for (Buku book : getBuku()) {
            System.out.println(book.getGenre() + " - " + book.getJudul());
        }
        System.out.println();
    }

    // Meminjam buku oleh user
    public void pinjamBuku(String judul) {
        super.tambahBuku("Peminjaman", judul);
    }
}
