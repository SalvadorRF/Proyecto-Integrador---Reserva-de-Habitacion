import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class PanelPrincipal extends JFrame {
    
    
    private JPanel contentPane;
    
    //Constructor 
    public PanelPrincipal(){

        this.setTitle("Hotel Estrellas - Recepcion");
       
        this.setJMenuBar(MenuBuilder.generateMenu(Main.getInstance().getHbtList()));
        
        contentPane = new JPanel(null);
        
        contentPane.setBackground(new Color(192,192,192));
        
        buildPane();
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
    public void buildPane(){

        
        int x = 40,y = 50, xP = 230, yP = 180;
        for(int i = 0; i < Main.getInstance().getHbtList().size(); i++){

            if((i%3 == 0) && (i != 0)){
                x = 40;
                y = y + 140;
                yP = yP + 140;
            }
            
            JPanel tarPanel = new HabitacionPanel(Main.getInstance().getHbtList().get(i));
            tarPanel.setBounds(x,y,150,100);
            contentPane.add(tarPanel);
            
            x = x +190;
            
            if(i <= 3 && i >=2){ xP = xP + 190;}
            
        }
        
        contentPane.setPreferredSize(new Dimension(xP,yP));
        
        
    }
    
    public void update(){
        contentPane.removeAll();
        buildPane();
        this.repaint();
        this.validate();
    }
}