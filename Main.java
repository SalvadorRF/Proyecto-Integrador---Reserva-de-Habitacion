import java.util.List;
import java.util.ArrayList;

public class Main
{
    
    private static Main instance;
    public Habitacion hbt1,hbt2,hbt3,hbt4;
    private List<Habitacion> habtList;
    private PanelPrincipal pnlPrincipal;
    
    public void onEnable(){
        
        instance = this;
        habtList = new ArrayList<>();
        hbt1 = new Habitacion("Habitacion 1", 1, "Matrimonial", 250);
        hbt1.setDesc("Aire Acondicionado, Servicio, Vista a la Playa");
        
        hbt2 = new Habitacion("Habitacion 2", 2, "Individual", 150);
        hbt2.setRes(new Reservacion("Salvador Rico", 2, "24/nov/2019"));
        
        hbt3 = new Habitacion("Habitacion 3", 3, "Individual", 150);
        hbt3.setStatus(Habitacion.STATUS_LIMP);
        
        hbt4 = new Habitacion("Habitacion 4", 4, "Matrimonial", 250);
        hbt4.setStatus(Habitacion.STATUS_MANT);
        
        habtList.add(hbt1);
        habtList.add(hbt2);
        habtList.add(hbt3);
        habtList.add(hbt4);
        
        for (int i = 0; i < 5; i++){
           Habitacion tarHbt = new Habitacion("Habitacion " + (i+5), (i+5), "Matrimonial", 250);
           habtList.add(tarHbt);        
        }
        
        
        
        
        pnlPrincipal = new PanelPrincipal();
    }
    
    public List<Habitacion> getHbtList(){return habtList;}
    public PanelPrincipal getPnlPrincial(){return pnlPrincipal;}
    
    public static Main getInstance() {return instance;}
    
    public static void main(String[] args){
        Main m = new Main();
        m.onEnable();
    }
    
}
