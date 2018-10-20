package trabalho_mateus;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Trabalho_Mateus {

    public static void main(String[] args) {
        
        // Referenciando a Classe
        metodo op = new metodo();
        
        op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        op.setTitle("Conversor");
        op.setVisible(true);
        op.setSize(300,300);
        op.setLocationRelativeTo(null);

    }
}