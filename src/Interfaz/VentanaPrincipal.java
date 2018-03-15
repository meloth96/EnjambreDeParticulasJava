package Interfaz;

import Modeladoras.Enjambre;
import Modeladoras.Particula;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;

public class VentanaPrincipal extends javax.swing.JFrame {

    final static int TAMANIO_PARTICULA = 7;
    final static int CANTIDAD_ITERACIONES = 100;
    private Enjambre enjambre;
    private int mitadAnchoTablero;
    private int mitadAltoTablero;
    private int contadorIteraciones;
    private Timer timer;

    public VentanaPrincipal() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else {
                    for (javax.swing.UIManager.LookAndFeelInfo i : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(i.getName())) {
                            javax.swing.UIManager.setLookAndFeel(i.getClassName());
                            break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBusqueda = new javax.swing.JPanel();
        panelAjustes = new javax.swing.JPanel();
        botonCreacionEnjambre = new javax.swing.JButton();
        botonOptimizar = new javax.swing.JButton();
        campoTextoCantidadParticulas = new javax.swing.JTextField();
        etiquetaCantidadParticulas = new javax.swing.JLabel();
        etiquetaVelocidadInicial = new javax.swing.JLabel();
        sliderAceleracionMinima = new javax.swing.JSlider();
        etiquetaAceleracionMinima = new javax.swing.JLabel();
        etiquetaAceleracionMaxima = new javax.swing.JLabel();
        sliderAceleracionMaxima = new javax.swing.JSlider();
        opcionVelocidadAleatoria = new javax.swing.JCheckBox();
        etiquetaInerciaMinima = new javax.swing.JLabel();
        sliderInerciaMinima = new javax.swing.JSlider();
        etiquetaInerciaMaxima = new javax.swing.JLabel();
        sliderInerciaMaxima = new javax.swing.JSlider();
        botonReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelBusqueda.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        panelAjustes.setBackground(new java.awt.Color(204, 204, 255));

        botonCreacionEnjambre.setText("Crear Enjambre");
        botonCreacionEnjambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCreacionEnjambreActionPerformed(evt);
            }
        });

        botonOptimizar.setText("Optimizar");
        botonOptimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOptimizarActionPerformed(evt);
            }
        });

        etiquetaCantidadParticulas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiquetaCantidadParticulas.setText("Cantidad de Particulas");

        etiquetaVelocidadInicial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiquetaVelocidadInicial.setText("Velocidad Inicial de Particulas");

        sliderAceleracionMinima.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        sliderAceleracionMinima.setMajorTickSpacing(10);
        sliderAceleracionMinima.setMaximum(50);
        sliderAceleracionMinima.setPaintLabels(true);
        sliderAceleracionMinima.setPaintTicks(true);
        sliderAceleracionMinima.setValue(0);

        etiquetaAceleracionMinima.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiquetaAceleracionMinima.setText("Aceleracion Minima de Particulas");

        etiquetaAceleracionMaxima.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiquetaAceleracionMaxima.setText("Aceleracion Maxima de Particulas");

        sliderAceleracionMaxima.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        sliderAceleracionMaxima.setMajorTickSpacing(10);
        sliderAceleracionMaxima.setMaximum(50);
        sliderAceleracionMaxima.setPaintLabels(true);
        sliderAceleracionMaxima.setPaintTicks(true);
        sliderAceleracionMaxima.setValue(0);

        opcionVelocidadAleatoria.setText("Aleatoria");
        opcionVelocidadAleatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionVelocidadAleatoriaActionPerformed(evt);
            }
        });

        etiquetaInerciaMinima.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiquetaInerciaMinima.setText("Inercia Minima de Particulas");

        sliderInerciaMinima.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        sliderInerciaMinima.setMajorTickSpacing(10);
        sliderInerciaMinima.setMaximum(50);
        sliderInerciaMinima.setPaintLabels(true);
        sliderInerciaMinima.setPaintTicks(true);
        sliderInerciaMinima.setValue(0);

        etiquetaInerciaMaxima.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiquetaInerciaMaxima.setText("Inercia Maxima de Particulas");

        sliderInerciaMaxima.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        sliderInerciaMaxima.setMajorTickSpacing(10);
        sliderInerciaMaxima.setMaximum(50);
        sliderInerciaMaxima.setPaintLabels(true);
        sliderInerciaMaxima.setPaintTicks(true);
        sliderInerciaMaxima.setValue(0);

        botonReiniciar.setText("Reiniciar");

        javax.swing.GroupLayout panelAjustesLayout = new javax.swing.GroupLayout(panelAjustes);
        panelAjustes.setLayout(panelAjustesLayout);
        panelAjustesLayout.setHorizontalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaInerciaMaxima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderInerciaMaxima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAjustesLayout.createSequentialGroup()
                        .addGroup(panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sliderAceleracionMinima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoTextoCantidadParticulas)
                                .addComponent(opcionVelocidadAleatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etiquetaCantidadParticulas)
                                .addComponent(etiquetaVelocidadInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etiquetaAceleracionMinima)
                                .addComponent(etiquetaAceleracionMaxima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sliderAceleracionMaxima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sliderInerciaMinima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etiquetaInerciaMinima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonOptimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCreacionEnjambre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(botonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAjustesLayout.setVerticalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(etiquetaCantidadParticulas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoCantidadParticulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(etiquetaVelocidadInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcionVelocidadAleatoria)
                .addGap(18, 18, 18)
                .addComponent(etiquetaAceleracionMinima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderAceleracionMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaAceleracionMaxima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderAceleracionMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaInerciaMinima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderInerciaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaInerciaMaxima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderInerciaMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCreacionEnjambre)
                .addGap(18, 18, 18)
                .addComponent(botonOptimizar)
                .addGap(18, 18, 18)
                .addComponent(botonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCreacionEnjambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCreacionEnjambreActionPerformed
        float aceleracionMinima,aceleracionMaxima,inerciaMinima,inerciaMaxima;
        int cantidadParticulas;
        boolean velocidadAleatoria;
        System.out.println(velocidadAleatoria = opcionVelocidadAleatoria.isSelected());
        System.out.println( cantidadParticulas = Integer.parseInt(campoTextoCantidadParticulas.getText()));
        System.out.println(aceleracionMinima = (float) (sliderAceleracionMinima.getValue())/10);
        System.out.println(aceleracionMaxima = ((float)sliderAceleracionMaxima.getValue())/10);
        System.out.println(inerciaMinima = ((float)sliderInerciaMinima.getValue())/10);
        System.out.println(inerciaMaxima = ((float)sliderInerciaMaxima.getValue())/10);
        velocidadAleatoria = opcionVelocidadAleatoria.isSelected();
        enjambre = new Enjambre(cantidadParticulas,aceleracionMinima,
                aceleracionMaxima,inerciaMinima,inerciaMaxima,velocidadAleatoria);
        imprimirParticulas();

    }//GEN-LAST:event_botonCreacionEnjambreActionPerformed

    private void botonOptimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOptimizarActionPerformed

        contadorIteraciones = 0;
        ActionListener action;
        action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (contadorIteraciones < CANTIDAD_ITERACIONES) {
                    enjambre.calcularInerciaYVelocidades(contadorIteraciones, CANTIDAD_ITERACIONES);
                    enjambre.actualizarVelocidadesParticulas();
                    enjambre.actualizarPosicionesParticulas();
                    enjambre.actualizarMejoresPosiciones();
                    enjambre.funcionDeAdaptacion();
                    enjambre.actualizarParticulaLider();
                    contadorIteraciones++;
                } else {
                    timer.stop();
                }
                imprimirParticulas();
            }
        };

        timer = new Timer(100, action);
        timer.start();
    }//GEN-LAST:event_botonOptimizarActionPerformed

    private void opcionVelocidadAleatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionVelocidadAleatoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionVelocidadAleatoriaActionPerformed

    private int mapearValores(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public void imprimirParticulas() {

        ArrayList<Particula> particulas = enjambre.getEnjambre();
        Graphics g2 = panelBusqueda.getGraphics();
        panelBusqueda.paint(g2);
        mitadAnchoTablero = panelBusqueda.getWidth() / 2;
        mitadAltoTablero = panelBusqueda.getHeight() / 2;
        for (int i = 0; i < particulas.size(); i++) {
            //System.out.println("X: "+particulas.get(i).getX()+" Y: "+particulas.get(i).getY());
            g2.fillOval(getPosicionX(particulas.get(i).getX()),
                    getPosicionY(particulas.get(i).getY()),
                    TAMANIO_PARTICULA, TAMANIO_PARTICULA);
        }
//        g2.fillOval(getPosicionX(-100), getPosicionY(100), TAMANIO_PARTICULA, TAMANIO_PARTICULA);
    }

    public int getPosicionX(int posicion) {
        int posicionNueva;
        if (posicion <= 0) {
            posicionNueva = mapearValores(posicion, -100, 0, 0, mitadAnchoTablero);
        } else {
            posicionNueva = mapearValores(posicion, 0, 100, mitadAnchoTablero, panelBusqueda.getWidth()) - TAMANIO_PARTICULA;
        }
        return posicionNueva;
    }

    public int getPosicionY(int posicion) {
        int posicionNueva;
        if (posicion <= 0) {
            posicionNueva = mapearValores(posicion, -100, 0, panelBusqueda.getHeight(), mitadAltoTablero) - TAMANIO_PARTICULA;
        } else {
            posicionNueva = mapearValores(posicion, 0, 100, mitadAltoTablero, 0);
        }
        return posicionNueva;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCreacionEnjambre;
    private javax.swing.JButton botonOptimizar;
    private javax.swing.JButton botonReiniciar;
    private javax.swing.JTextField campoTextoCantidadParticulas;
    private javax.swing.JLabel etiquetaAceleracionMaxima;
    private javax.swing.JLabel etiquetaAceleracionMinima;
    private javax.swing.JLabel etiquetaCantidadParticulas;
    private javax.swing.JLabel etiquetaInerciaMaxima;
    private javax.swing.JLabel etiquetaInerciaMinima;
    private javax.swing.JLabel etiquetaVelocidadInicial;
    private javax.swing.JCheckBox opcionVelocidadAleatoria;
    private javax.swing.JPanel panelAjustes;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JSlider sliderAceleracionMaxima;
    private javax.swing.JSlider sliderAceleracionMinima;
    private javax.swing.JSlider sliderInerciaMaxima;
    private javax.swing.JSlider sliderInerciaMinima;
    // End of variables declaration//GEN-END:variables
}
