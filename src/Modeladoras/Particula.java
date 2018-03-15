package Modeladoras;


public class Particula {
    
    private int x;
    private int y;
    private int velocidadX;
    private int velocidadY;
    private int mejorPosicionX;
    private int mejorPosicionY;
    private int valorMinimoFuncionObjetivo;
    
    public Particula(int x, int y){
        setX(x);
        setY(y);
        setMejorPosicionX(x);
        setMejorPosicionY(y);
        setVelocidadX(0);
        setVelocidadY(0);
    }
    
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setVelocidadX(int Vx){
        this.velocidadX=Vx;
    }
    public void setVelocidadY(int Vy){
        this.velocidadY=Vy;
    }
    public void setMejorPosicionX(int posicion){
        this.mejorPosicionX = posicion;
    }
    public void setMejorPosicionY(int posicion){
        this.mejorPosicionY = posicion;
    }
    public void setValorMinimoFuncionObjetivo(int valor){
        this.valorMinimoFuncionObjetivo = valor;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getVelocidadX(){
        return velocidadX;
    }
    public int getVelocidadY(){
        return velocidadY;
    }
    public int getMejorPosicionX(){
        return mejorPosicionX;
    }
    public int getMejorPosicionY(){
        return mejorPosicionY;
    }
    public int getValorMinimoFuncionObjetivo(){
        return valorMinimoFuncionObjetivo;
    }
}
