public class Contador {

    private int contador;
    public int getContador() {
        return this.contador;
    }

    public Contador()
    {
        contador = 0;
    }

    public void incrementarContador() { contador++; }

    public void decrementarContador() {
        contador--;
    }
}
