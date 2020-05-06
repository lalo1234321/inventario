package alacenadigital.Store;

import java.util.Date;
import java.util.Scanner;

public class Farmacia extends Tienda{
    private int DiasUtiles;
    private int CantidadPermitida;

    public Farmacia(int ID, String ClasePertenencia, String NombreProducto, double Precio, int CantidadRequerida, String Marca,int DiasUtiles, int CantidadPermitida,int limInf,String date) {
        super(ID, ClasePertenencia, NombreProducto, Precio, CantidadRequerida, Marca,limInf,date);
        this.DiasUtiles = DiasUtiles;
        this.CantidadPermitida = CantidadPermitida;
    }
    public Farmacia() {
    }
    

    @Override
    public void LeerDatos() {
        ClasePertenencia="Farmacia";
        Scanner Leer = new Scanner(System.in);
         System.out.print("Ingrese el Nombre del producto: ");
        NombreProducto=Leer.next();
        do{
            System.out.print("Ingrese el Precio del producto: ");
            Precio=Leer.nextDouble();
            System.out.println((Precio<=0.00)?"Precio inválido.":"");
        }while(Precio<=0.00);
        do{
            System.out.print("Ingrese la Cantidad Requerida del producto(Para la Alacena): ");
            CantidadRequerida=Leer.nextInt();
            System.out.println((CantidadRequerida<=0)?"Cantidad no válida.":"");
        }while(CantidadRequerida<=0);
        //checar string
        do{
            System.out.print("Ingrese la Marca del Producto: ");
            Marca=Leer.next();
            System.out.println((tieneNumeros(Marca)==1)?"La marca del producto contiene números":"");
        }while(tieneNumeros(Marca)==1);
        do{
            System.out.print("Ingrese los Dias utiles del producto: ");
            DiasUtiles=Leer.nextInt();
            System.out.println((DiasUtiles<=0)?"Días no válidos.":"");
        }while(DiasUtiles<=0);
        do{
            System.out.print("Ingrese la cantidad permitida a almacenar: ");
            CantidadPermitida=Leer.nextInt();
            System.out.println((CantidadPermitida<=0)?"Cantidad imposible":"");
        }while(CantidadPermitida<=0);
        
    }

    @Override
    public String PrintDatos() {
        return (ID                +"     "
                +NombreProducto   +"     $"
                +Precio           +"     "
                +ClasePertenencia +"     "
                +CantidadRequerida+"     "
                +Marca            +"     "
                +DiasUtiles       +"     "
                +CantidadPermitida+"     ");
    }

    @Override
    public void FuncionAgregada1() {
        System.out.println();
    }
                                                        //Sin Funciones Extras
    @Override
    public void FuncionAgregada2() {
        System.out.println();
    }
    
}
