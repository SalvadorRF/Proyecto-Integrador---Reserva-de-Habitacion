public class Reservacion
{
    private String name;
    private int noches;
    private String fecha;
    private int descuento;
    
    public Reservacion(){
        this.name = "";
        this.noches = 0;
        this.fecha = "00/mes/0000";
        this.descuento = 0;
    }
    
    public Reservacion(String Nombre, int Noches, String Fecha){
        this.name = Nombre;
        this.noches = Noches;
        this.fecha = Fecha;
        this.descuento = 0;
    }
    
    public Reservacion(String Nombre, int Noches, String Fecha, int Descuento){
        this.name = Nombre;
        this.noches = Noches;
        this.fecha = Fecha;
        this.descuento = Descuento;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNoches(){
        return this.noches;
    }

    public void setNoches(int noches){
        this.noches = noches;
    }

    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public int getDescuento(){
        return this.descuento;
    }

    public void setDescuento(int descuento){
        this.descuento = descuento;
    }
}
