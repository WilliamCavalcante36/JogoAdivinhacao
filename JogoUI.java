package jogoadivinhicao;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class JogoUI extends JFrame{
    private JTextField campo;
    private JLabel resultado;
    private JButton botao;
    private LogicaJogo logica;
    
    public JogoUI() {
    logica = new LogicaJogo();
    
    setTitle("Jogo da Adivinhação");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    resultado = new JLabel("Digite um número de 1 a 100", SwingConstants.CENTER);
    resultado.setFont(new Font("Segoe UI", Font.BOLD, 18));
    resultado.setForeground(Color.WHITE);
    
    campo = new JTextField(10);
    campo.setBackground(new Color(255, 255, 255, 230));
    campo.setForeground(Color.BLACK);
    campo.setCaretColor(Color.BLACK);
    campo.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 200), 1));
    campo.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    
    botao = new JButton("Enviar");
    
     JPanel fundo = new JPanel(){
      protected void paintComponent(Graphics g){
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;
          
          GradientPaint gp = new GradientPaint(
            0, 0, new Color(0, 180, 255),
            0, getHeight(), new Color(200, 255, 255)        
          );
          g2d.setPaint(gp);
          g2d.fillRect(0, 0, getWidth(), getHeight());
      }  
    };
     
    fundo.setLayout(new BorderLayout());
    setContentPane(fundo);
    
    JPanel centro = new JPanel();
    centro.add(campo);
    centro.setOpaque(false);
        
    JPanel baixo = new JPanel();
    baixo.add(botao);
    baixo.setOpaque(false);
     
    add(resultado, BorderLayout.NORTH);
    add(centro, BorderLayout.CENTER);
    add(baixo, BorderLayout.SOUTH);
    
    botao.setBackground(new Color(0, 150, 255));
    botao.setForeground(Color.WHITE);
    botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
    botao.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 150), 1));
    botao.setFocusPainted(false);
    botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    
    botao.addActionListener(e ->{
        try{
            int numero = Integer.parseInt(campo.getText());
            String resposta = logica.verificarTentativas(numero);
            resultado.setText(resposta);
        }catch(NumberFormatException ex){
            resultado.setText("Só pode número");
        }
        campo.setText("");
    });
    }
    
    
    
}
