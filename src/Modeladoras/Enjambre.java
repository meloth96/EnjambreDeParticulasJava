package Modeladoras;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Enjambre {

    final static int RANGO_NUMEROS_ALEATORIOS = 5;
    final static float ACELERACION_MINIMA = (float) 0.5;
    final static float ACELERACION_MAXIMA = (float) 2.5;
    final static float INERCIA_MINIMA = (float) 0.4;
    final static float INERCIA_MAXIMA = (float) 0.9;
    
    private float velocidadInercial;
    private float aceleracionMinima;
    private float aceleracionMaxima;
    final static int ALPHA = 1;
    private ArrayList<Particula> particulas;
    private int cantidadParticulas;
    private Particula lider;

    
    private int funcionObjetivo(int x, int y) {
        return (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Enjambre(int cantidadParticulas) {
        this.cantidadParticulas = cantidadParticulas;
        particulas = new ArrayList<>(cantidadParticulas);
        generarPosicionesAleatorias();
        lider = getParticulaMejorPosicion();
    }

    private void generarPosicionesAleatorias() {
        int posicionX, posicionY;
        for (int i = 0; i < cantidadParticulas; i++) {
            posicionX = ThreadLocalRandom.current().nextInt(40, 90+1);
            posicionY = ThreadLocalRandom.current().nextInt(40,90+1);
            
//            posicionX = ThreadLocalRandom.current().nextInt(-100, 100+1);
//            posicionY = ThreadLocalRandom.current().nextInt(-100,100+1);
            particulas.add(new Particula(posicionX,posicionY));
        }
    }

    public void funcionDeAdaptacion() {
        int posicionX, posicionY;
        for(Particula p: particulas){
            posicionX = p.getX();
            posicionY = p.getY();
            p.setValorMinimoFuncionObjetivo(funcionObjetivo(posicionX, posicionY));
        }
    }
    
    private Particula getParticulaMejorPosicion(){
        Particula particula = particulas.get(0);
        int valorParticula;
        int valorMinimo = particula.getValorMinimoFuncionObjetivo();
        for(Particula i : particulas){
            valorParticula = i.getValorMinimoFuncionObjetivo();
            if(valorParticula < valorMinimo){
                valorMinimo = valorParticula;
                particula = i;
            }
        }
        return particula;
    }
    
    public void actualizarMejoresPosiciones(){
        int valorMinimoActual;
        
        for(Particula i : particulas){
            valorMinimoActual = i.getValorMinimoFuncionObjetivo();
            if(funcionObjetivo(i.getX(),i.getY()) < valorMinimoActual){
                i.setMejorPosicionX(i.getX());
                i.setMejorPosicionY(i.getY());
            }
        }
    }
    
    public void actualizarPosicionesParticulas(){
        int nuevaPosicionX, nuevaPosicionY;
        for(Particula i : particulas){
            nuevaPosicionX = i.getX() + i.getVelocidadX();
            nuevaPosicionY = i.getY() + i.getVelocidadY();
            i.setX(nuevaPosicionX);
            i.setY(nuevaPosicionY);
        }
    }
    
    public void actualizarParticulaLider(){
        int resultadoParticulaLider = funcionObjetivo(lider.getX(), lider.getY());
        int resultado;
        for(Particula p : particulas){
            resultado = funcionObjetivo(p.getX(), p.getY());
            if(resultado < resultadoParticulaLider){
                lider = p;
            }
        }
    }
    
    public void actualizarVelocidadesParticulas(){
        Random random = new Random();
        for(Particula p : particulas){
            p.setVelocidadX((int) ((velocidadInercial*p.getVelocidadX())+(aceleracionMinima*random.nextFloat())*
                    (p.getMejorPosicionX()-p.getX()) + ((aceleracionMaxima*random.nextFloat())*
                            (lider.getX()-p.getX()))));
            p.setVelocidadY((int) ((velocidadInercial*p.getVelocidadY())+(aceleracionMinima*random.nextFloat())*
                    (p.getMejorPosicionY()-p.getY()) + ((aceleracionMaxima*random.nextFloat())*
                            (lider.getY()-p.getY()))));
            System.out.println("Velocidad X: "+p.getVelocidadX());
            System.out.println("Velocidad Y: "+p.getVelocidadY());
        }
    }
    
    public void calcularInerciaYVelocidades(int iteracionActual, int cantidadIteraciones){
		velocidadInercial = ((INERCIA_MINIMA-INERCIA_MAXIMA)/(cantidadIteraciones-1)) * (iteracionActual-1)+INERCIA_MAXIMA;
		aceleracionMinima = ((ACELERACION_MINIMA-ACELERACION_MAXIMA)/cantidadIteraciones)*iteracionActual+ACELERACION_MAXIMA;
		aceleracionMaxima = ((ACELERACION_MAXIMA-ACELERACION_MINIMA)/cantidadIteraciones)*iteracionActual+ACELERACION_MINIMA;
                System.out.println("C1: "+aceleracionMinima);
                System.out.println("C2: "+aceleracionMaxima);
                System.out.println("Velocidad Inercial: "+velocidadInercial);
	}

    public ArrayList<Particula> getEnjambre() {
        return particulas;
    }
}
