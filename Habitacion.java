import java.awt.Color;
public class Habitacion
{
    private String name;
    private int numero;
    private String status;
    private String tipo;
    private String desc;
    private int precio;
    private Reservacion res;
   
    public static final String STATUS_DISP = "Disponible";
    public static final String STATUS_OCUP = "Ocupado";
    public static final String STATUS_MANT = "Mantenimiento";
    public static final String STATUS_LIMP = "Limpieza";
    
    public Habitacion(String Nombre, int Numero, String Tipo, int Precio){
        this.name = Nombre;
        this.numero = Numero;
        this.tipo = Tipo;
        this.precio = Precio;
        this.status = STATUS_DISP;
        this.desc = "";
        this.res = new Reservacion();
    }
    
    public Habitacion(String Nombre, int Numero, String Status, String Tipo, int Precio, String Descripcion, Reservacion Reservacion){
        this.name = Nombre;
        this.numero = Numero;
        this.tipo = Tipo;
        this.precio = Precio;
        this.desc = Descripcion;
        this.status = Status;
        this.res = Reservacion;
    }
   
    public static Color getStatusColor(String status){
        Color tarColor;
        
        switch (status){
            case Habitacion.STATUS_LIMP :
                tarColor = Utils.COLOR_INFO;
                break;
            case Habitacion.STATUS_DISP:
                tarColor = Utils.COLOR_SUCCESS;
                break;
            case Habitacion.STATUS_OCUP:
                tarColor = Utils.COLOR_DANGER ; 
                break;
            case Habitacion.STATUS_MANT:
                tarColor = Utils.COLOR_WARNING;
                break;
            default:
                tarColor = Utils.COLOR_PRIMARY;
        }
        
        return tarColor;
    }
    
  
    public String getName(){
        return this.name;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getStatus(){
        if(res.getName() != ""){
            this.status = STATUS_OCUP;
        }
        return this.status;
    }

 
    public void setStatus(String status){
        this.status = status;
    }

    
    public String getTipo(){
        return this.tipo;
    }

    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    
    public String getDesc(){
        return this.desc;
    }

    
    public void setDesc(String desc){
        this.desc = desc;
    }

    
    public int getPrecio(){
        return this.precio;
    }

    
    public void setPrecio(int precio){
        this.precio = precio;
    }

    
    public Reservacion getRes(){
        return this.res;
    }

    
    public void setRes(Reservacion res){
        this.res = res;
    }

}
