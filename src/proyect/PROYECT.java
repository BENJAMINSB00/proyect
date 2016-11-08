/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author SOTO
 */
public class PROYECT {
// SE MUESTRAN LOS ICONOS DE ERRORES Y DEL AH0RCADO Y SE GUARDAN LAS PALABRAS

    JTextField txtPalabra;
    JLabel Errors;
    JLabel Dibujs;

    private boolean play = false;

    private String[] palabrs = {"ABIDE", "BURN", "CAMP", "DRIVE", "EXILE"};
    private char[] palabra;
    private char[] palabra_secreta;
    int intentos = 0;
    boolean cambios = false;

    public PROYECT() {
    }

    public PROYECT(JTextField texto, JLabel dibujo, JLabel errores) {
        this.palabra_secreta = Random().toCharArray();
        String s = "";
        for (int i = 0; i <= this.palabra_secreta.length - 1; i++) {
            s = s + "_";
        }
        this.palabra = s.toCharArray();

        this.txtPalabra = texto;
        this.Dibujs = dibujo;
        this.Errors = errores;

        txtPalabra.setText(s);
        Dibujs.setIcon(new javax.swing.ImageIcon(getClass().getResource("Ahorcado0.png")));
        Errors.setIcon(new javax.swing.ImageIcon(getClass().getResource("FF.png")));
        Errors.setToolTipText("No tienes errores!!");
        this.play = true;

    }

    void EVA(char c) {
        if (play) {
            String p = "";
            //controla que aun se pueda jugar
            if (this.intentos == 7) {
                JOptionPane.showMessageDialog(null, "Ya has perdido!!");
            } else {
                //evalua caracter por caracter
                for (int j = 0; j <= this.palabra_secreta.length - 1; j++) {
                    //si el caracter se encuentra en la palabra secreta            
                    if (this.palabra_secreta[j] == c) {
                        this.palabra[j] = c;//se asigna para que se pueda ver en pantalla
                        this.cambios = true;
                    }
                    p = p + this.palabra[j];
                }//fin for
                //si no se produjo ningun cambio, quiere decir que el jugador se equivoco
                if (this.cambios == false) {
                    this.intentos += 1; //se incrementa            
                    Dibujs.setIcon(new javax.swing.ImageIcon(getClass().getResource("Ahorcado" + this.intentos + ".png")));
                    Errors.setIcon(new javax.swing.ImageIcon(getClass().getResource("FF" + this.intentos + ".png")));
                    if (this.intentos == 1) {
                        Errors.setToolTipText("Tienes " + this.intentos + " error!! Te quedan " + (7 - this.intentos) + " intentos más");
                    } else {
                        Errors.setToolTipText("Tienes " + this.intentos + " errores!! Te quedan " + (7 - this.intentos) + " intentos más");
                    }
                    if (this.intentos < 7) {
                        JOptionPane.showMessageDialog(null, "Has Fallado!! Te quedan " + (7 - this.intentos) + " intentos más");
                    }
                } else {
                    this.cambios = false;
                }
                this.txtPalabra.setText(p);
                //comprobamos el estado del juego
                
            }

        }
    }



private String Random() {
        int num = (int) (Math.random() * (palabrs.length));
        return palabrs[num];
    }
}

