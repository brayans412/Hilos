// Grupo: 
// ELejalde Salgado Edgar David
// Lopez Rincon Braham Steveen
// Salgado Brayan Enrique

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class hilos{
    public static void main(String[] args) {
        Proceso1 proceso1 = new Proceso1();
        Proceso2 proceso2 = new Proceso2();

        Thread hilo1 = new Thread(proceso1);
        Thread hilo2 = new Thread(proceso2);

        hilo1.start();
        hilo2.start();

        JOptionPane.showMessageDialog(null, "Procesos en ejecución. Presiona OK para salir.");
        System.exit(0);
    }

    static class Proceso1 implements Runnable {
        public void run() {
            System.out.println("Proceso 1 en ejecución");

            String strNumero1 = JOptionPane.showInputDialog("Ingrese el primer número:");
            double numero1 = Double.parseDouble(strNumero1);

            String strNumero2 = JOptionPane.showInputDialog("Ingrese el segundo número:");
            double numero2 = Double.parseDouble(strNumero2);

            String[] operaciones = {"Suma", "Resta", "Multiplicación", "División"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la operación a realizar:", "Operación",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, operaciones, operaciones[0]);

            double resultado = 0;

            switch (seleccion) {
                case 0:
                    resultado = numero1 + numero2;
                    break;
                case 1:
                    resultado = numero1 - numero2;
                    break;
                case 2:
                    resultado = numero1 * numero2;
                    break;
                case 3:
                    resultado = numero1 / numero2;
                    break;
                default:
                    System.out.println("Operación no válida");
            }

            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
        }
}

    static class Proceso2 implements Runnable {
        public void run() {
            System.out.println("Proceso 2 en ejecución");
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(hilos.class.getResourceAsStream("speed.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Error al reproducir el sonido: " + ex.getMessage());
            }
            System.out.println("Proceso 2 completado");
        }
    }
}
