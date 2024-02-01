package praticando1;

public class Ponto {
    private int x,y;
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString(){
        return "Ponto{" + "x=" + x + ",y=" + y + '}';
    }

    @Override
    public boolean equals(Object o){
        Ponto p = (Ponto) o;
        return p.x==this.x && p.y==this.y;
    }

    public double distancia(Ponto p){
        double difX = p.x - this.x;
        double dixY = p.y - this.y;
        return Math.sqrt(difX * difX + dixY * dixY);
    }
}
