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


public class CotizacionPanel extends JFrame {

    private JMenuBar menuBar;
    private JLabel lblFecha;
    private JLabel lblNoches;
    private JLabel lblNombreHabt;
    private JLabel lblNombreRes;
    private JLabel lblPrecioNoche;
    private JLabel lblDescuento;
    private JLabel lblIVA;
    private JLabel lblPrecioTotal;
    private JButton btnPrint;
    
    //Constructor 
    public CotizacionPanel(Habitacion habitacion){
        
        Reservacion res = habitacion.getRes();
        
        this.setTitle("CotizacionPanel");
        this.setSize(421,384);
        this.setJMenuBar(MenuBuilder.generateMenu(Main.getInstance().getHbtList()));

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(421,384));
        contentPane.setBackground(new Color(192,192,192));


        lblFecha = new JLabel();
        lblFecha.setBounds(114,111,143,36);
        lblFecha.setBackground(new Color(214,217,223));
        lblFecha.setForeground(new Color(0,0,0));
        lblFecha.setEnabled(true);
        lblFecha.setFont(new Font("SansSerif",1,15));
        lblFecha.setText("Fecha: "+ res.getFecha());
        lblFecha.setVisible(true);

        lblNoches = new JLabel();
        lblNoches.setBounds(25,111,90,35);
        lblNoches.setBackground(new Color(214,217,223));
        lblNoches.setForeground(new Color(0,0,0));
        lblNoches.setEnabled(true);
        lblNoches.setFont(new Font("SansSerif",1,15));
        lblNoches.setText("Noches: " + res.getNoches());
        lblNoches.setVisible(true);

        lblNombreHabt = new JLabel();
        lblNombreHabt.setBounds(40,24,342,33);
        lblNombreHabt.setBackground(new Color(214,217,223));
        lblNombreHabt.setForeground(new Color(255,255,255));
        lblNombreHabt.setEnabled(true);
        lblNombreHabt.setFont(new Font("SansSerif",1,20));
        lblNombreHabt.setText("Reservacion de la " + habitacion.getName());
        lblNombreHabt.setVisible(true);

        lblNombreRes = new JLabel();
        lblNombreRes.setBounds(23,75,350,38);
        lblNombreRes.setBackground(new Color(214,217,223));
        lblNombreRes.setForeground(new Color(0,0,0));
        lblNombreRes.setEnabled(true);
        lblNombreRes.setFont(new Font("SansSerif",1,15));
        lblNombreRes.setText("Nombre del Reservante: " + res.getName());
        lblNombreRes.setVisible(true);

        lblPrecioNoche = new JLabel();
        lblPrecioNoche.setBounds(262,112,146,33);
        lblPrecioNoche.setBackground(new Color(214,217,223));
        lblPrecioNoche.setForeground(new Color(0,0,0));
        lblPrecioNoche.setEnabled(true);
        lblPrecioNoche.setFont(new Font("SansSerif",1,15));
        lblPrecioNoche.setText("Precio/Noche: $" + habitacion.getPrecio());
        lblPrecioNoche.setVisible(true);
        
        lblDescuento= new JLabel();
        lblDescuento.setBounds(25,150,146,33);
        lblDescuento.setBackground(new Color(214,217,223));
        lblDescuento.setForeground(new Color(0,0,0));
        lblDescuento.setEnabled(true);
        lblDescuento.setFont(new Font("SansSerif",1,15));
        lblDescuento.setText("Descuento: "+ res.getDescuento() + "%");
        lblDescuento.setVisible(true);
        
        lblIVA= new JLabel();
        lblIVA.setBounds(172,150,146,33);
        lblIVA.setBackground(new Color(214,217,223));
        lblIVA.setForeground(new Color(0,0,0));
        lblIVA.setEnabled(true);
        lblIVA.setFont(new Font("SansSerif",1,15));
        lblIVA.setText("IVA: 16%");
        lblIVA.setVisible(true);
        
        //int precio = (habitacion.getPrecio() * res.getNoches())  + ((habitacion.getPrecio() * res.getNoches() * 16) /100) - ((habitacion.getPrecio() * res.getNoches() * res.getDescuento()) /100);
        int precio = (habitacion.getPrecio() * res.getNoches() /100) * (116-res.getDescuento());
        lblPrecioTotal= new JLabel();
        lblPrecioTotal.setBounds(172,200,146,33);
        lblPrecioTotal.setBackground(new Color(214,217,223));
        lblPrecioTotal.setForeground(Utils.COLOR_SUCCESS);
        lblPrecioTotal.setEnabled(true);
        lblPrecioTotal.setFont(new Font("SansSerif",1,15));
        lblPrecioTotal.setText("Total: $" + precio);
        lblPrecioTotal.setVisible(true);
        
        btnPrint = new JButton();
        btnPrint.setBounds(25,200,60,28);
        btnPrint.setBackground(Utils.COLOR_INFO);
        btnPrint.setForeground(new Color(0,0,0));
        btnPrint.setEnabled(true);
        btnPrint.setFont(new Font("sansserif",0,12));
        btnPrint.setText("Print");
        btnPrint.setVisible(true);
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Utils.takeSnapShot(contentPane, habitacion);
            }
        });

        contentPane.add(btnPrint);
        contentPane.add(lblPrecioTotal);
        contentPane.add(lblIVA);
        contentPane.add(lblDescuento);
        contentPane.add(lblFecha);
        contentPane.add(lblNoches);
        contentPane.add(lblNombreHabt);
        contentPane.add(lblNombreRes);
        contentPane.add(lblPrecioNoche);

        this.add(contentPane);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        
        
    }



}