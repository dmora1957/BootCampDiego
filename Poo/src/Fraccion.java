public class Fraccion {

    public int dividendo;
    public int divisor;

    public Fraccion() {
    }

    public Fraccion(int dividendo) {
        this.dividendo = dividendo;
        this.divisor = 1;
    }

    public Fraccion(int dividendo, int divisor) {
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

    public Fraccion sumar(int num){
        return sumar(new Fraccion(num));
    }

    public Fraccion sumar(Fraccion fr){
        this.dividendo*=fr.divisor;
        fr.dividendo*=this.divisor;
        fr.divisor*=this.divisor;
        this.divisor*=fr.divisor;
        return new Fraccion(this.dividendo+fr.dividendo, this.divisor+fr.divisor);
    }

    public Fraccion restar(int num){
        return restar(new Fraccion(num));
    }
    public Fraccion restar(Fraccion fr){
        this.dividendo *= fr.divisor;
        fr.dividendo *= this.divisor;
        fr.divisor *= this.divisor;
        this.divisor *= fr.divisor;
        return new Fraccion(this.dividendo - fr.dividendo, this.divisor - fr.divisor);
    }

    public Fraccion dividir(int num){
        return dividir(new Fraccion(num));
    }
    public Fraccion dividir(Fraccion fr){
        return new Fraccion(this.dividendo * fr.divisor, this.divisor * fr.dividendo);
    }

    public Fraccion multiplicar(int num){
        return multiplicar(new Fraccion(num));
    }
    public Fraccion multiplicar(Fraccion fr){
        return new Fraccion(this.dividendo * fr.dividendo, this.divisor * fr.divisor);
    }
}
