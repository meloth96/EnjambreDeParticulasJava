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
    final static int CANTIDAD_ITERACIONES = 30;
    private final Enjambre enjambre;
    private int mitadAnchoTablero;
    private int mitadAltoTablero;
    private int contadorIteraciones;
    private Timer timer;

    public VentanaPrincipal() {
        System.out.println(System.getProperty("os.name"));
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
        enjambre = new Enjambre(500);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        imprimirParticulas();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

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
    }//GEN-LAST:event_jButton2ActionPerformed

    private int mapearValores(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public void imprimirParticulas() {

        ArrayList<Particula> particulas = enjambre.getEnjambre();
        Graphics g2 = jPanel1.getGraphics();
        jPanel1.paint(g2);
        mitadAnchoTablero = jPanel1.getWidth() / 2;
        mitadAltoTablero = jPanel1.getHeight() / 2;
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
            posicionNueva = mapearValores(posicion, 0, 100, mitadAnchoTablero, jPanel1.getWidth()) - TAMANIO_PARTICULA;
        }
        return posicionNueva;
    }

    public int getPosicionY(int posicion) {
        int posicionNueva;
        if (posicion <= 0) {
            posicionNueva = mapearValores(posicion, -100, 0, jPanel1.getHeight(), mitadAltoTablero) - TAMANIO_PARTICULA;
        } else {
            posicionNueva = mapearValores(posicion, 0, 100, mitadAltoTablero, 0);
        }
        return posicionNueva;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
