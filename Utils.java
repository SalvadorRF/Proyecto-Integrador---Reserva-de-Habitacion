import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;

public class Utils
{
    public static final Color COLOR_INFO = new Color(91,192,222);
    public static final Color COLOR_SUCCESS = new Color(92,184,92);
    public static final Color COLOR_DANGER = new Color(217,83,79);
    public static final Color COLOR_WARNING = new Color(240,173,78);
    public static final Color COLOR_PRIMARY = new Color(2,117,216);
    
    public static void takeSnapShot(JPanel panel, Habitacion hbt){
       BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height,BufferedImage.TYPE_INT_RGB);
       panel.paint(bufImage.createGraphics());
       String fecha = hbt.getRes().getFecha();
       String name = "habitacion_" + hbt.getNumero()+ "_" + hbt.getRes().getName()+"_" + fecha.replace("/","-") + ".jpg";
       File imageFile = new File("."+File.separator+ "Img" + File.separator + name);
        try{
            imageFile.createNewFile();
            ImageIO.write(bufImage, "jpg", imageFile);
        }catch(Exception ex){
        }
    }
}
