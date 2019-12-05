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

public class HabitacionPanel extends JPanel {

    private JButton btnEdit;
    private JButton btnCoti;
    private JLabel lblHabitacion;
    private JLabel lblStatus;
    private Habitacion hbt;
    private List<Habitacion> hbtList;
    //Constructor 
    public HabitacionPanel(Habitacion habitacion){
        this.hbtList = Main.getInstance().getHbtList();
        this.hbt = habitacion;
        
        btnEdit = new JButton();
        btnEdit.setBounds(17,67,51,28);
        btnEdit.setBackground(new Color(255,204,0));
        btnEdit.setForeground(new Color(0,0,0));
        btnEdit.setEnabled(true);
        btnEdit.setFont(new Font("sansserif",0,12));
        btnEdit.setText("Edit");
        btnEdit.setVisible(true);
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onClikBtnEdit(evt);
            }
        });
        
        btnCoti = new JButton();
        btnCoti.setBounds(84,67,51,28);
        btnCoti.setBackground(Utils.COLOR_PRIMARY);
        btnCoti.setForeground(new Color(0,0,0));
        btnCoti.setEnabled(true);
        btnCoti.setFont(new Font("sansserif",0,12));
        btnCoti.setText("$$$");
        btnCoti.setVisible(true);
        btnCoti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onClikBtnCoti(evt);
            }
        });



        lblHabitacion = new JLabel();
        lblHabitacion.setBounds(13,10,128,20);
        lblHabitacion.setBackground(new Color(61,185,255));
        lblHabitacion.setForeground(new Color(255,255,255));
        lblHabitacion.setEnabled(true);
        lblHabitacion.setFont(new Font("SansSerif",1,20));
        lblHabitacion.setText(hbt.getName());
        lblHabitacion.setVisible(true);

        lblStatus = new JLabel();
        lblStatus.setBounds(47,40,54,22);
        lblStatus.setBackground(new Color(214,217,223));
        lblStatus.setForeground(new Color(255,255,255));
        lblStatus.setEnabled(true);
        lblStatus.setFont(new Font("SansSerif",1,20));
        lblStatus.setText(hbt.getStatus());
        lblStatus.setVisible(true);

        this.setBorder(BorderFactory.createEtchedBorder(1));
        //this.setBounds(42,62,150,100);

        this.setBackground(Habitacion.getStatusColor(hbt.getStatus()));

        
        this.setForeground(new Color(0,0,0));
        this.setEnabled(true);
        this.setFont(new Font("sansserif",0,12));
        this.setVisible(true);

        this.add(btnCoti);
        this.add(btnEdit);
        this.add(lblHabitacion);
        this.add(lblStatus);
    }
    
    private void onClikBtnCoti (ActionEvent evt) {
       if(hbt.getStatus() == Habitacion.STATUS_OCUP){
           new CotizacionPanel(hbt);
       }else{
           JOptionPane.showMessageDialog(null,"No puedes realizar una cotizacion porque no hay una reservacion");
       }
        
    }

    private void onClikBtnEdit (ActionEvent evt) {
       if(hbt.getStatus() == Habitacion.STATUS_MANT){
           JOptionPane.showMessageDialog(null,"No puedes realizar reservaciones por Mantenimiento");
       }else{
           new DatosHabitacion(hbt);
       }
        
    }
    
    
}