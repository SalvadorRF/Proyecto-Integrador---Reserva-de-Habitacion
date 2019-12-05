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

public class DatosHabitacion extends JFrame {

    private JMenuBar menuBar;
    private JButton btnGuardar;
    private JLabel btnType;
    private JComboBox combobox1;
    private JLabel label2;
    private JLabel lblDescuento;
    private JLabel lblEstado;
    private JLabel lblFecha;
    private JLabel lblInfoRes;
    private JLabel lblNoches;
    private JLabel lblNombre;
    private JLabel lblNombreRes;
    private JLabel lblPrecioNoche;
    private JLabel lblPrecioResTXT;
    private JLabel lblStatus;
    private JPanel pnlDatos;
    private JTextField txtDescuento;
    private JTextField txtDetalles;
    private JTextField txtFecha;
    private JTextField txtNoches;
    private JTextField txtNombre;
    private JTextField txtNombreRes;
    private JFrame frame = this;

    //Constructor 
    public DatosHabitacion(Habitacion habitacion){

        this.setTitle("Hotel Estrellas - Habitacion/Reservacion");
        this.setSize(560,397);
        this.setJMenuBar(MenuBuilder.generateMenu(Main.getInstance().getHbtList()));


        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(560,397));
        contentPane.setBackground(new Color(192,192,192));


        btnGuardar = new JButton();
        btnGuardar.setBounds(406,298,90,35);
        btnGuardar.setBackground(new Color(102,186,55));
        btnGuardar.setForeground(new Color(0,0,0));
        btnGuardar.setEnabled(true);
        btnGuardar.setFont(new Font("SansSerif",1,15));
        btnGuardar.setText("Guardar");
        btnGuardar.setVisible(true);
        btnGuardar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        
                        if(!isEmpty(txtNombreRes)){
                            habitacion.getRes().setDescuento(Integer.parseInt(txtDescuento.getText()));
                            habitacion.getRes().setFecha(txtFecha.getText());
                            habitacion.getRes().setNoches(Integer.parseInt(txtNoches.getText()));
                            habitacion.getRes().setName(txtNombreRes.getText());
                            JOptionPane.showMessageDialog(null,"Se ha realizado la reservacion Correctamente.");
                        }else{
                            JOptionPane.showMessageDialog(null,"No se ha hecho la reservacion. Llena todos los campos de la reservacion.");
                        }
                        
                         
                        habitacion.setDesc(txtDetalles.getText());
                        habitacion.setName("Habitacion " + txtNombre.getText());
                        habitacion.setNumero(Integer.parseInt(txtNombre.getText()));
                        
                        Main.getInstance().getPnlPrincial().update();
                        
                        frame.dispose();
                    }
                });
    
        btnType = new JLabel();
        btnType.setBounds(192,15,41,32);
        btnType.setBackground(new Color(214,217,223));
        btnType.setForeground(new Color(0,0,0));
        btnType.setEnabled(true);
        btnType.setFont(new Font("SansSerif",1,15));
        btnType.setText("Tipo:");
        btnType.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(13,55,63,30);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",1,15));
        label2.setText("Detalles:");
        label2.setVisible(true);

        lblDescuento = new JLabel();
        lblDescuento.setBounds(351,223,90,35);
        lblDescuento.setBackground(new Color(214,217,223));
        lblDescuento.setForeground(new Color(0,0,0));
        lblDescuento.setEnabled(true);
        lblDescuento.setFont(new Font("SansSerif",1,15));
        lblDescuento.setText("Descuento");
        lblDescuento.setVisible(true);

        lblEstado = new JLabel();
        lblEstado.setBounds(352,13,57,36);
        lblEstado.setBackground(new Color(214,217,223));
        lblEstado.setForeground(new Color(0,0,0));
        lblEstado.setEnabled(true);
        lblEstado.setFont(new Font("SansSerif",1,15));
        lblEstado.setText("Estado:");
        lblEstado.setVisible(true);

        lblFecha = new JLabel();
        lblFecha.setBounds(198,224,90,35);
        lblFecha.setBackground(new Color(214,217,223));
        lblFecha.setForeground(new Color(0,0,0));
        lblFecha.setEnabled(true);
        lblFecha.setFont(new Font("SansSerif",1,15));
        lblFecha.setText("Fecha:");
        lblFecha.setVisible(true);

        lblInfoRes = new JLabel();
        lblInfoRes.setBounds(132,122,296,51);
        lblInfoRes.setBackground(new Color(214,217,223));
        lblInfoRes.setForeground(new Color(0,0,0));
        lblInfoRes.setEnabled(true);
        lblInfoRes.setFont(new Font("SansSerif",1,20));
        lblInfoRes.setText("Informacion de la Reservacion");
        lblInfoRes.setVisible(true);

        lblNoches = new JLabel();
        lblNoches.setBounds(31,226,90,35);
        lblNoches.setBackground(new Color(214,217,223));
        lblNoches.setForeground(new Color(0,0,0));
        lblNoches.setEnabled(true);
        lblNoches.setFont(new Font("SansSerif",1,15));
        lblNoches.setText("Noches:");
        lblNoches.setVisible(true);

        lblNombre = new JLabel();
        lblNombre.setBounds(14,15,61,37);
        lblNombre.setBackground(new Color(214,217,223));
        lblNombre.setForeground(new Color(0,0,0));
        lblNombre.setEnabled(true);
        lblNombre.setFont(new Font("SansSerif",1,15));
        lblNombre.setText("Nombre:");
        lblNombre.setVisible(true);

        lblNombreRes = new JLabel();
        lblNombreRes.setBounds(34,178,90,35);
        lblNombreRes.setBackground(new Color(214,217,223));
        lblNombreRes.setForeground(new Color(0,0,0));
        lblNombreRes.setEnabled(true);
        lblNombreRes.setFont(new Font("SansSerif",1,15));
        lblNombreRes.setText("Nombre:");
        lblNombreRes.setVisible(true);

        lblPrecioNoche = new JLabel();
        lblPrecioNoche.setBounds(297,179,107,31);
        lblPrecioNoche.setBackground(new Color(214,217,223));
        lblPrecioNoche.setForeground(new Color(0,0,0));
        lblPrecioNoche.setEnabled(true);
        lblPrecioNoche.setFont(new Font("SansSerif",1,15));
        lblPrecioNoche.setText("Precio/Noche:");
        lblPrecioNoche.setVisible(true);

        lblPrecioResTXT = new JLabel();
        lblPrecioResTXT.setBounds(406,177,90,35);
        lblPrecioResTXT.setBackground(new Color(214,217,223));
        lblPrecioResTXT.setForeground(new Color(0,0,0));
        lblPrecioResTXT.setEnabled(true);
        lblPrecioResTXT.setFont(new Font("SansSerif",0,15));
        lblPrecioResTXT.setText("$" + habitacion.getPrecio());
        lblPrecioResTXT.setVisible(true);

        lblStatus = new JLabel();
        lblStatus.setBounds(415,14,90,35);
        lblStatus.setBackground(new Color(255,255,255));
        lblStatus.setForeground(Habitacion.getStatusColor(habitacion.getStatus()));
        lblStatus.setEnabled(true);
        lblStatus.setFont(new Font("SansSerif",1,15));
        lblStatus.setText(habitacion.getStatus());
        lblStatus.setVisible(true);

        pnlDatos = new JPanel(null);
        pnlDatos.setBorder(BorderFactory.createEtchedBorder(1));
        pnlDatos.setBounds(13,13,528,108);
        pnlDatos.setBackground(new Color(255,255,255));
        pnlDatos.setForeground(new Color(0,0,0));
        pnlDatos.setEnabled(true);
        pnlDatos.setFont(new Font("sansserif",0,12));
        pnlDatos.setVisible(true);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(435,224,90,35);
        txtDescuento.setBackground(new Color(255,255,255));
        txtDescuento.setForeground(new Color(0,0,0));
        txtDescuento.setEnabled(true);
        txtDescuento.setFont(new Font("SansSerif",0,15));
        txtDescuento.setText(habitacion.getRes().getDescuento() + "");
        txtDescuento.setVisible(true);

        txtDetalles = new JTextField();
        txtDetalles.setBounds(85,52,422,35);
        txtDetalles.setBackground(new Color(255,255,255));
        txtDetalles.setForeground(new Color(0,0,0));
        txtDetalles.setEnabled(true);
        txtDetalles.setFont(new Font("SansSerif",0,15));
        txtDetalles.setText(habitacion.getDesc());
        txtDetalles.setVisible(true);

        txtFecha = new JTextField();
        txtFecha.setBounds(252,224,90,35);
        txtFecha.setBackground(new Color(255,255,255));
        txtFecha.setForeground(new Color(0,0,0));
        txtFecha.setEnabled(true);
        txtFecha.setFont(new Font("SansSerif",0,15));
        txtFecha.setText(habitacion.getRes().getFecha());
        txtFecha.setVisible(true);

        txtNoches = new JTextField();
        txtNoches.setBounds(101,224,90,35);
        txtNoches.setBackground(new Color(255,255,255));
        txtNoches.setForeground(new Color(0,0,0));
        txtNoches.setEnabled(true);
        txtNoches.setFont(new Font("SansSerif",0,15));
        txtNoches.setText(habitacion.getRes().getNoches()+ "");
        txtNoches.setVisible(true);

        txtNombre = new JTextField();
        txtNombre.setBounds(85,15,90,35);
        txtNombre.setBackground(new Color(255,255,255));
        txtNombre.setForeground(new Color(0,0,0));
        txtNombre.setEnabled(true);
        txtNombre.setFont(new Font("SansSerif",0,15));
        txtNombre.setText(habitacion.getNumero() + "");
        txtNombre.setVisible(true);

        txtNombreRes = new JTextField();
        txtNombreRes.setBounds(99,179,193,34);
        txtNombreRes.setBackground(new Color(255,255,255));
        txtNombreRes.setForeground(new Color(0,0,0));
        txtNombreRes.setEnabled(true);
        txtNombreRes.setFont(new Font("SansSerif",0,15));
        txtNombreRes.setText(habitacion.getRes().getName());
        txtNombreRes.setVisible(true);

        contentPane.add(btnGuardar);
        pnlDatos.add(label2);
        contentPane.add(lblDescuento);
        pnlDatos.add(lblEstado);
        contentPane.add(lblFecha);
        contentPane.add(lblInfoRes);
        contentPane.add(lblNoches);
        pnlDatos.add(lblNombre);
        contentPane.add(lblNombreRes);
        contentPane.add(lblPrecioNoche);
        contentPane.add(lblPrecioResTXT);
        pnlDatos.add(lblStatus);
        contentPane.add(pnlDatos);
        contentPane.add(txtDescuento);
        pnlDatos.add(txtDetalles);
        contentPane.add(txtFecha);
        contentPane.add(txtNoches);
        pnlDatos.add(txtNombre);
        contentPane.add(txtNombreRes);

        this.add(contentPane);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    public boolean isEmpty(JTextField txt){
        if(txt.getText().length() == 0){
            return true;
        }else {
            return false;
        }
    }
}