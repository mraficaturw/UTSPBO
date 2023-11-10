public class Buku {
    private String genre;
    private String judul;

    // Konstruktor
    public Buku(String genre, String judul) {
        this.genre = genre;
        this.judul = judul;
    }

    // Getter untuk genre
    public String getGenre() {
        return genre;
    }

    // Getter untuk judul buku
    public String getJudul() {
        return judul;
    }
}
