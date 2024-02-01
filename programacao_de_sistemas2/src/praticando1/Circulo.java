package praticando1;

public class Circulo extends FiguraGeometrica implements Calcula{
    private Ponto p1;
    private double raio;
    public Circulo(int x, int y, double raio, String cor){
        super(cor);
        p1 = new Ponto(x,y);
        this.raio = raio;
    }

    public boolean compare(FiguraGeometrica o){
        Circulo c = (Circulo) o;
        return c.raio==this.raio 
            && this.getCor().equals(c.getCor())
            && c.p1 == p1;
    }

    public double Area(){
        return Math.PI * Math.pow(this.raio, 2);
    }

    public double Perimetro(){
        return 2 * Math.PI * this.raio;
    }

    public boolean interseccao(FiguraGeometrica o){
        Circulo c = (Circulo) o;

        double distanciaCentro = Math.sqrt(
            Math.pow(c.p1.getX() - p1.getX(), 2) +
            Math.pow(c.p1.getY() - p1.getY(), 2)
        );
        return distanciaCentro <= this.raio + c.raio;
    }
}


