package alacenadigital;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class GeneradorArchivos {
    private String Shop;
    private String Item="";
    //Getter y Setter
    
    public void setShop(String Shop) {
        this.Shop = Shop;
    }
    public String getItem() {
        return Item;
    }
    public void setItem(String Item) {
        this.Item = Item;
    }    
    
    public GeneradorArchivos() {
    } //Constructor Vacio
        File BaseDatos;
        FileWriter Ingresar;
        PrintWriter Linea;
        
        public void BaseDatos(){
        BaseDatos =new File ("Datos.csv");
        try{
            
        if (!BaseDatos.exists()){
            
                //crea el archivo
                BaseDatos.createNewFile();
                
                //crea una instancia para crear el archivo
                Ingresar =new FileWriter(BaseDatos,true);
                Linea =new PrintWriter(Ingresar);
                //ingreao de datos en el archivo
                
                
                Linea.println(Item);
                Linea.println();
                //cerramos archivo
                Ingresar.close();
            
            
        }else{
            
                //ingresar los datos de las variables
                
                Ingresar=new FileWriter(BaseDatos,true);
                Linea=new PrintWriter(Ingresar);
                
                
                Linea.print(Item);
                Linea.println();
                //cerramos archivo
                Ingresar.close();
            
        }
        }catch(HeadlessException | IOException e){
            
                System.out.println("Error en: "+e);
            }
    }
        public void Borrar(){
            BaseDatos =new File ("Archivo.txt");
            if (!BaseDatos.exists()){
                }else{
                BaseDatos.delete();
            }
        }
        public void Recibos(long Fecha, String Nombre, float Precio, float Total){
            File Recibo=new File ("Recibo"+Fecha+".txt");
            try{

                if (!Recibo.exists()){

                    //crea el archivo
                    Recibo.createNewFile();

                    //crea una instancia para crear el archivo
                    Ingresar =new FileWriter(Recibo,true);
                    Linea =new PrintWriter(Ingresar);
                    //ingreao de datos en el archivo
                    Linea.println();
                    Linea.println("-----Tienda Particular de Dudosa Procedencia-----");
                    Linea.println("************************************************");
                    Linea.println();
                    Linea.println("Su compra fue: "+Nombre);
                    Linea.println("Precio: "+Precio);
                    Linea.println("Cantidad Comprada: "+ (Total/Precio));
                    Linea.println("Total: "+Total);
                    Linea.println();
                    Linea.println("---- ¡Vuelva Pronto! ----"   );
                    Ingresar.close();
                }else{

                    //ingresar los datos de las variables

                    Ingresar=new FileWriter(Recibo,true);
                    Linea=new PrintWriter(Ingresar);


                    Linea.print(Shop);
                    Linea.println();
                    //cerramos archivo
                    Ingresar.close();
                }
            }catch(Exception e){
                
            }
    }        
}
