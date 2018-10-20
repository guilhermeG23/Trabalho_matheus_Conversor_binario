package trabalho_mateus;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class metodo extends JFrame{
    
    operacoes opera = new operacoes();
    
    // Criação de Botões, Area de Texto
    private JLabel titulo = new JLabel("Entre com Valor Decimal");
    private JLabel inteiro = new JLabel("Entrada decimal:");
    private JLabel flutu = new JLabel("Float:");
    private JLabel bina = new JLabel("Binario:");
    private JLabel hexa = new JLabel("Hexa:");
    private JLabel octa = new JLabel("Octa:");
    private JButton calc = new JButton("Calcular");
    private JButton limpar = new JButton("Limpar");
    private JTextField text1 = new JTextField();
    private JTextField text2 = new JTextField();
    private JTextField text3 = new JTextField();
    private JTextField text4 = new JTextField();
    
    public metodo(){
        // Arrumar o Layout
        setLayout(null);
        
        // Acão dos Botões
        limpar.addActionListener(new limpar());
        calc.addActionListener(new calcular());
        
        //Titulo & inicio e entrada de valor
        titulo.setBounds(40, 10, 220, 20);

        //Entrada
        inteiro.setBounds(40, 60, 120, 20);
        text1.setBounds(150, 60, 120, 20); // entrada
        
        //Binario
        bina.setBounds(40, 100, 120, 20);
        text2.setBounds(150, 100, 120, 20);
        text2.setEditable(false);
        
        // octa
        octa.setBounds(40, 140, 120, 20);;
        text4.setBounds(150, 140, 120, 20);
        text4.setEditable(false);
        
        //hexa
        hexa.setBounds(40, 180, 120, 20);
        text3.setBounds(150, 180, 120, 20);
        text3.setEditable(false);
        
        //Botoes
        calc.setBounds(20, 220, 120, 20);
        limpar.setBounds(150, 220, 120, 20);

        // Adiciona Botõs e Textos e labels
        add(titulo);
        add(inteiro);
        add(flutu);
        add(bina);
        add(hexa);
        add(octa);
        add(limpar);
        add(calc);
        add(text1);
        add(text2);
        add(text3);
        add(text4);
    }    
    
    // Ira limpar os TextaArea
    class limpar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
        }    
    }
    
    class calcular implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            float entrada = Float.parseFloat(text1.getText());
            
            String valor_ope = "" + entrada;
            String[] valores = null;
            
            valores = valor_ope.split(Pattern.quote("."));
            
            text2.setText(opera.binario(valores[0], "0." + valores[1]));
            text4.setText(opera.octal(valores[0], "0." + valores[1]));
            text3.setText(opera.hexadecimal(valores[0], "0." + valores[1]));
        }    

    }
}