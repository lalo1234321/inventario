package alacenadigital.Store;

import java.util.Date;
import java.util.Scanner;

public class Supermercado extends Tienda{

    
    public Supermercado(int ID, String ClasePertenencia, String NombreProducto, double Precio, int CantidadRequerida, String Marca,int limInf,String date) {
        super(ID, ClasePertenencia, NombreProducto, Precio, CantidadRequerida, Marca,limInf, date);
    }
    public Supermercado() {
    }

    
    
    @Override
    public void LeerDatos() {
        Scanner Leer = new Scanner(System.in);
        ClasePertenencia="Supermercado";
        do{
            System.out.print("Ingrese el Nombre del producto: ");
            NombreProducto=Leer.next();
            System.out.println((tieneNumeros(NombreProducto)==1)?"El nombre contiene un número, lo cual es inválido":"");
        }while(tieneNumeros(NombreProducto)==1);
        do{
            System.out.print("Ingrese el Precio del producto: ");
            Precio=Leer.nextDouble();
            System.out.println((Precio<=0.00)?"Precio no válido":"");
        }while(Precio<=0.00);
        do{
            System.out.print("Ingrese la Cantidad Requerida del producto(Para la Alacena): ");
            CantidadRequerida=Leer.nextInt();
            System.out.println((CantidadRequerida<=0)?"Cantidad no válida":"");
        }while(CantidadRequerida<=0);
        do{
            System.out.print("Ingrese la Marca del Producto: ");
            Marca=Leer.next();
            System.out.println((tieneNumeros(Marca)==1)?"La marca contiene un número":"");
        }while(tieneNumeros(Marca)==1);
        
        
        
    }

    @Override
    public String PrintDatos() {
        return (ID                +"     "
                +NombreProducto   +"     $"
                +Precio           +"     "
                +ClasePertenencia +"     "
                +CantidadRequerida+"     "
                +Marca               +"     ");
    }

    
    public void FuncionAgregada1(String Variable) {
        try{
            Variable="";
        }catch(Exception e){
            System.out.println("Opcion no valida");
        }
        
    }

    @Override
    public void FuncionAgregada2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FuncionAgregada1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
