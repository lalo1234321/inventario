
package alacenadigital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
public class SubMenu extends JFrame
{
    private JFrame hola;
    private String absolutePath;
    private File[]arregloArchivo;
    private File archivo;
    private JLabel lb1;
    private JComboBox <String> subMenu;
    private String[] opciones;
    private JButton b1;
    private int i;
    private String s;
    public String t;
    private AlacenaDigital obj;
    public SubMenu(AlacenaDigital obj)
    {
        this.obj=obj;
        initialize();
        
    }
    public void initialize()
    {   //Inicializar 
        hola=new JFrame();
        s=null;
        i=0;
        absolutePath="./Save";
        archivo=new File(absolutePath);
        opciones=new String[50];
        llenarCombo();
        subMenu=new JComboBox<String>(opciones);
        lb1=new JLabel();
        b1=new JButton("Aceptar");
        lb1.setText("Seleccione el archivo");
        this.getContentPane().setLayout(null);
        hola.getContentPane().setLayout(null);
        setBounds(0,0,500,500);
        hola.setBounds(300,500,200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hola.setVisible(true);
        lb1.setBounds(0, 0, 200, 50);
        subMenu.setBounds(0, 60, 200, 50);
        b1.setBounds(200, 110, 100, 50);
        this.getContentPane().add(lb1);
        this.getContentPane().add(subMenu);
        this.getContentPane().add(b1);
        lb1.setVisible(true);
        subMenu.setVisible(true);
        b1.setVisible(true);
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                obj.recibirArchivo=retornarNombre();
                apagar();
            }
        });
        
    }
    
    public void imprimir()
    {
        arregloArchivo=archivo.listFiles();
        for(File arch:arregloArchivo)
        {
            System.out.println(arch.getName());

        }
        
    }
    public void llenarCombo()
    {
        arregloArchivo=archivo.listFiles();
        for(File arch:arregloArchivo)
        {
            opciones[i]=arch.getName();
            i++;
        }
    }
    public String retornarNombre()
    {
        String s=(String) subMenu.getSelectedItem();
        return s;
    }
    public String getS()
    {
        return s;
    }
    public void apagar()
    {
        this.setVisible(false);
    }
}
