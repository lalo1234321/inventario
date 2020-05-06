package alacenadigital.Store;

import java.util.Date;

public abstract class Tienda {
    protected  int ID;
    protected String ClasePertenencia;
    protected  String NombreProducto;
    protected  double Precio;
    protected int CantidadRequerida;
    protected String Marca;
    protected int limInf;
    protected String date;
    public Tienda(int ID, String ClasePertenencia, String NombreProducto, double Precio, int CantidadRequerida, String Marca,int limInf,String date) {
        this.ID = ID;
        this.ClasePertenencia = ClasePertenencia;
        this.NombreProducto = NombreProducto;
        this.Precio = Precio;
        this.CantidadRequerida = CantidadRequerida;
        this.Marca = Marca;
        this.limInf=limInf;
        this.date=date;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    

    public Tienda() {
    }

    public String getClasePertenencia() {
        return ClasePertenencia;
    }

    public void setClasePertenencia(String ClasePertenencia) {
        this.ClasePertenencia = ClasePertenencia;
    }

    public int getLimInf()
    {
        return limInf;
    }

    public void setLimInf(int limInf)
    {
        this.limInf = limInf;
    }
    

    

    public String getNombreProducto() {
        return NombreProducto;    }
    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;    }
    public int getID() {
        return ID;    }
    public void setID(int ID) {
        this.ID = ID;    }
    public double getPrecio() {
        return Precio;    }
    public void setPrecio(double Precio) {
        this.Precio = Precio;    }
    public int getCantidadRequerida() {
        return CantidadRequerida;    }
    public void setCantidadRequerida(int CantidadRequerida) {
        this.CantidadRequerida = CantidadRequerida;    }
    public String getMarca() {
        return Marca;    }
    public void setMarca(String Marca) {
        this.Marca = Marca;    }
    
    public abstract void LeerDatos();
    public abstract String PrintDatos();
    public abstract void FuncionAgregada1();
    public abstract void FuncionAgregada2();
    
    public int tieneNumeros(String texto){
        String check="0123456789";
        for(int i=0; i<texto.length(); i++){
            if (check.indexOf(texto.charAt(i),0)!=-1){
             return 1;
            }
        }
        return 0;
    }
}
