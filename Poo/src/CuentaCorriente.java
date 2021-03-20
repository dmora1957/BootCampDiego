public class CuentaCorriente {

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    private double saldo;
    private int numero;
    private int idCliente;

    public CuentaCorriente(){}

    public CuentaCorriente(int nro, int idCliente){
        this.numero = nro;
        this.idCliente = idCliente;
    }
    
    public CuentaCorriente(CuentaCorriente cc){
        this.idCliente = cc.idCliente;
        this.numero = cc.numero;
        this.saldo = cc.saldo;
    }
    
    public void ingreso(double cantidad){
        this.saldo += cantidad;
    }

    public void egreso(double cantidad){
        this.saldo -= cantidad;
    }

    public void reintegro(double cantidad){
        this.ingreso(cantidad);
    }

    public void transferencia(CuentaCorriente cc, double monto){
        this.egreso(monto);
        cc.ingreso(monto);
    }
}
