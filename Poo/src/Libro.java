public class Libro {

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String titulo;
    public String isbn;
    public String autor;

    public Libro(){}

    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public void prestamo(){}
    public void devolucion(){}

    @Override
    public String toString() {
        return titulo + ", "+autor+", "+ isbn;
    }
}
