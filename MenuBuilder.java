import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;


public class MenuBuilder
{
        
    private static JMenuBar  menuBar ;
    public MenuBuilder(List<Habitacion> Habitaciones){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu habitaciones = new JMenu("Habitaciones");


        JMenuItem reset = new JMenuItem("Reset   ");
        tools.add(reset);

        
        for(Habitacion hbt : Habitaciones){
            JMenuItem tarHbt = new JMenuItem(hbt.getName() + "   ");
            //Solo trabaja para este ejemplo de 4
            tarHbt.setAccelerator(KeyStroke.getKeyStroke(hbt.getNumero() + 48,Event.CTRL_MASK));
            tarHbt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    new DatosHabitacion(hbt);
                    
                }
            });
            
            habitaciones.add(tarHbt);
        }
        
        
        


        reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,Event.CTRL_MASK));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for(Habitacion hbt : Habitaciones){
                    hbt.setRes(new Reservacion());
                    hbt.setStatus(Habitacion.STATUS_DISP);
                    Main.getInstance().getPnlPrincial().update();
                }
            }
        });


        menuBar.add(tools);
        menuBar.add(habitaciones);
    }

    public static JMenuBar generateMenu(List<Habitacion> Habitaciones){
        new MenuBuilder(Habitaciones);
       return menuBar;
       }
    
}
