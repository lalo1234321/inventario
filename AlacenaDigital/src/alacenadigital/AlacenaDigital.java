package alacenadigital;

import alacenadigital.Store.Farmacia;
import alacenadigital.Store.Supermercado;
import alacenadigital.Store.Tienda;
import static java.lang.System.currentTimeMillis;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AlacenaDigital 
{
    private JFrame hola;
    private String absolutePath;
    private File[]arregloArchivo;
    private File archivo;
    private JLabel lbMenu;
    private JComboBox <String> subMenu;
    private String[] opciones1;
    private JButton b50;
    private int dav;
    private String dev;
    
    
    //Componente para la tabla
    private Component componente;
    
    //
    //private Date cal;
    public String recibirArchivo;
    public static ArrayList<Tienda> Almacen = new ArrayList<Tienda>();
    public ArrayList<Tienda> apoyo;
    public  JFrame frame;
    private static boolean mouse=false;
    public static int band = 0;
    private static JProgressBar prog;
    private static JPanel p1, p2, p3;
    private static JButton b1, b2, b3,b_Compras,b_Guardar,b_Cargar,b_Salir;
    private JList articulos, compra;
    private AlacenaDigital alfa;
    private static boolean controlador=false;
    private DefaultListModel modelo;
    private DefaultTableModel mod=new DefaultTableModel();
    private DefaultTableModel dt;
    private JScrollPane scroller;
    private static JLabel lb1, lb2, lb3, lb4, lb5, lb_Comprar_Producto, lb_Inventario,lb_Compras;
    private static JLabel lbProg;
    private String precio = null, cantidad = null,borrar="Borrar producto",eliminar="Consumir producto", crear = "Crear un producto",show="Mostrar productos", mercado = "Super mercado", farmacia = "Farmacia", buy = "Comprar producto",save="Guardar archivo en base de datos",load="Cargar datos previamente guardados",adios="Salir";
    private String crearUsuario="Crear un nuevo usuario";
    private static JScrollPane jScrollPane2;
    private static JButton b_Eliminar;
    private static  JTable jTable2;
    private int i=0,j=0;
    private static JTextField tf_Eliminar;
    private static JLabel imagen_p1,imagen_p2;
    private String[] opciones =
    {
        " ","Mostrar productos", "Crear un producto","Comprar producto","Consumir producto","Salir"
    };
    private ArrayList<String>articulos_Comprar=new ArrayList<String>();
    private static JComboBox combo_Crear;
    private JComboBox<String> combo = new JComboBox<String>(opciones);
    private JComboBox <String> combo_Comprar=new JComboBox<String>();
    private JComboBox <String> combo_Eliminar=new JComboBox<String>();
    private static JTextField tf1, tf2, tf3,tf_Compras;
    static Scanner Leer = new Scanner(System.in);
    public static int ControlID =0;
    private static AlacenaDigital obj;
    private static Inicio obj1;
    private static Object[] fila=new Object[100];
    
    public static void main(String[] args) throws IOException 
    {
        
        /*Tienda Frijoles = new Supermercado(ControlID, "SuperMercado", "Frijoles Bayos", 20, 23, "Les Frijoles",20);
        Almacen.add(Frijoles);
        ControlID++;
        Tienda Azucar = new Supermercado(ControlID, "Supermercado", "Azucar", 25, 3, "Azucareras",20);
        Almacen.add(Azucar);
        ControlID++;
        Tienda Cafe = new Supermercado(ControlID, "Supermercado", "Nescafe", 45, 1, "Nescafe",20);
        Almacen.add(Cafe);
        ControlID++;
        Tienda Vitacilina = new Farmacia(ControlID, "Farmacia", "Vitacilina", 100, 1, "Farmacias Ahorrro", 90, 3,20);
        Almacen.add(Vitacilina);
        ControlID++;
        Tienda Paracetamol = new Farmacia(ControlID, "Farmacia", "Paracetamol", 50, 2, "Farmacias Guadalajara", 60, 3,20);
        Almacen.add(Paracetamol);
        ControlID++;*/
        obj = new AlacenaDigital(null);
        obj1=new Inicio();
        
        obj1.setVisible(true);
        obj.frame.setVisible(false);
        
        while (1 < 2)
        {
            int aux = 0;

            do
            {
                try
                {
                    /*aux=Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido al Almacen Particular SA. de CV."
                        + "\n¿Que desea Hacer?"
                        + "\n1.-Imprimir Todos los objetos Disponibles"
                        + "\n2.-Consumir un producto"
                        + "\n3.-Crear nuevo Producto"
                        + "\n4.-Comprar Producto (Ya en existencia)"
                        + "\n5-Generar Archivo Excel"
                        + "\n6.-Salir","Almacenes Digitales - Menu Principal2"
                                + "",  3));*/
                } catch (Exception e)
                {
                    //System.out.println(((aux<1)||(aux>6))?"Opción no válida.":"");
                    //JOptionPane.showMessageDialog(null,(((aux<1)||(aux>6))?"Opción no válida.":""));
                }
            } while ((aux < 1) || (aux > 6));
            switch (aux)
            {
                case 1:
                    ImprimirProductos();
                    break;
                case 2:
                    ConsumirProducto();
                    break;
                case 3:
                    CrearProducto();
                    break;
                case 4:
                    ComprarProducto();
                    break;
                case 5:
                    GenerarArchivo();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("This line should never appear");
                    break;
            }
        }
    }

    public static void ImprimirProductos()
    {

        System.out.println(String.format("\n%15s %5s %30s %10s %10s %30s %20s",
                "¿Disponible?",
                "ID",
                "Item:",
                "Precio",
                "Activos",
                "Marca",
                "Clase Perteneciente"));

        for (Tienda Producto : Almacen)
        {

            if (Producto.getCantidadRequerida() <= 0)
            {
                //System.out.println(String.format("%30s %25s %10.2f %25s %10s", this.getItemName(), "|", this.getPrice(), "|", this.getQuantity()));

                System.out.print(String.format("%15s %5s %30s %10s %10s %30s %20s",
                        "No Disponible: ",
                        Producto.getID(),
                        Producto.getNombreProducto(),
                        ("$" + Producto.getPrecio()),
                        Producto.getCantidadRequerida(),
                        Producto.getMarca(),
                        Producto.getClasePertenencia()));

            } else
            {
                System.out.print(String.format("%15s %5s %30s %10s %10s %30s %20s",
                        "Disponible: ",
                        Producto.getID(),
                        Producto.getNombreProducto(),
                        ("$" + Producto.getPrecio()),
                        Producto.getCantidadRequerida(),
                        Producto.getMarca(),
                        Producto.getClasePertenencia()));

            }

            System.out.println("");

        }
        System.out.println();
    }

    public static void ConsumirProducto()
    {
        System.out.println("Seleccione el ID del producto");
        for (Tienda Producto : Almacen)
        {
            System.out.println(Producto.getID() + ".-  " + Producto.getNombreProducto());
        }
        System.out.print("Respuesta: ");
        int Scan = 1;
        do
        {
            try
            {
                Scan = Leer.nextInt();
            } catch (Exception e)
            {
                System.out.println("Opcion no valida");
            }
        } while (Scan < 1);
        System.out.println("Introdusca cantidad a Consumir");
        System.out.print("Respuesta: ");
        int consumo = 1;
        do
        {
            try
            {
                consumo = Leer.nextInt();
            } catch (Exception e)
            {
                System.out.println("Opcion no valida");
            }
        } while (Scan < 0);

        for (Tienda Producto : Almacen)
        {
            if (Producto.getID() == Scan)
            {
                if (Producto.getCantidadRequerida() <= consumo)
                {
                    Producto.setCantidadRequerida(0);
                } else
                {
                    Producto.setCantidadRequerida(Producto.getCantidadRequerida() - consumo);
                }
            }
        }
    }

    public static void CrearProducto()
    {
        int clas;
        /*do{
            System.out.println("¿Producto proveniente de...?");
            System.out.println("1.-Supermercado");
            System.out.println("2.-Farmacia");
            System.out.print("Respuesta: ");
            clas=Leer.nextInt();
            System.out.println(((clas<1)||(clas>2))?"Opción inválida.":"");
        }while ((clas<1)||(clas>2)); */

        System.out.println("Debugeando");
        lb2.setText("Elija la clase a la que pertenece");
        lb3.setText("Escriba el nombre del producto a crear");
        lb4.setText("Ingrese el precio del producto");
        lb5.setText("Ingrese la cantidad permitida a almacenar");
        p1.add(combo_Crear);
        //p1.add(imagen_p2);

        /*if(clas==1){
            Supermercado obj=new Supermercado();
            obj.setClasePertenencia("Supermercado");
            obj.setID(ControlID);
            ControlID++;
            obj.LeerDatos();
            Almacen.add(obj);
        }else{
            Farmacia obj1=new Farmacia();
            obj1.setClasePertenencia("Farmacia");
            obj1.setID(ControlID);
            ControlID++;
            obj1.LeerDatos();
            Almacen.add(obj1);
        }
         */
    }

    public static void ComprarProducto()
    {
        /**
         * System.out.println("Seleccione el ID del producto" + "\nOpciones: ");*
         */
        // JOptionPane.showMessageDialog(null,"Seleccione el ID del producto"
        //       + "\nOpciones: ");

        for (Tienda Producto : Almacen)
        {
            System.out.println(Producto.getID() + ".-  " + Producto.getNombreProducto());
        }
        int Scan = 1;
        do
        {
            try
            {
                System.out.print("Respuesta: ");
                Scan = Leer.nextInt();
            } catch (Exception e)
            {
                System.out.println("Opcion no valida");
            }
        } while (Scan < 1);
        for (Tienda Producto : Almacen)
        {
            if (Producto.getID() == Scan)
            {
                System.out.println("Introduzca cantidad a Comprar de " + Producto.getNombreProducto());
                System.out.print("Respuesta: ");
                int insumo = Leer.nextInt();
                Producto.setCantidadRequerida(Producto.getCantidadRequerida() + insumo);

                //int ans=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Generar Recibo?\n1.-Si\n2.-No ", "Recibo", 3));
                System.out.println("¿Generar Recibo?\n1.-Si\n2.-No");
                System.out.print("Respuesta: ");
                int ans = Leer.nextInt();
                switch (ans)
                {
                    case 1:
                        GeneradorArchivos Recibo = new GeneradorArchivos();
                        Recibo.Recibos(currentTimeMillis(), Producto.getNombreProducto(), ((float) Producto.getPrecio()), ((float) (Producto.getPrecio() * insumo)));
                        System.out.println("¡Recibo Generado!");
                        break;
                    case 2:
                        System.out.println("¡Recibo No Generado!");
                        break;
                    default:
                        System.out.println("This line should never appear");
                }
            }
        }

    }

    public static void GenerarArchivo()
    {
        GeneradorArchivos Formato = new GeneradorArchivos();
        Formato.Borrar();
        Formato.setItem("¿Disponible? , ID , Item:, Precio , Activos , Marca , Clase Perteneciente");
        Formato.BaseDatos();
        for (Tienda Producto : Almacen)
        {

            if (Producto.getCantidadRequerida() <= 0)
            {
                Formato.setItem("No Disponible: ," + Producto.getID() + " , " + Producto.getNombreProducto() + " , $" + Producto.getPrecio() + " , " + Producto.getCantidadRequerida() + " , " + Producto.getMarca() + " , " + Producto.getClasePertenencia());

            } else
            {
                Formato.setItem("Disponible: ," + Producto.getID() + " , " + Producto.getNombreProducto() + " , $" + Producto.getPrecio() + " , " + Producto.getCantidadRequerida() + " , " + Producto.getMarca() + " , " + Producto.getClasePertenencia());

            }
            Formato.BaseDatos();
        }

        System.out.println("¡Archivo Generado!");
    }

    public AlacenaDigital(String s)
    {
        this.recibirArchivo=s;
        initialize();
    }

    public void initialize()
    {
        
        
        //SUBMENU
        hola=new JFrame();
        dev=null;
        dav=0;
        absolutePath="./Save";
        archivo=new File(absolutePath);
        opciones1=new String[50];
        subMenu=new JComboBox<String>();
        //llenarCombo();
        
        lbMenu=new JLabel();
        b50=new JButton("Aceptar");
        lbMenu.setText("Seleccione el archivo");
        
        hola.getContentPane().setLayout(null);
        hola.setBounds(0,0,350,500);
        //hola.setBackground(Color.yellow);
        hola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hola.setVisible(false);
        lbMenu.setBounds(0, 0, 200, 50);
        subMenu.setBounds(0, 45, 200, 25);
        b50.setBounds(100, 70, 100, 30);
        hola.getContentPane().add(lbMenu);
        hola.getContentPane().add(subMenu);
        hola.getContentPane().add(b50);
        lbMenu.setVisible(true);
        subMenu.setVisible(true);
        b50.setVisible(true);
        
        //Crear objeto de tipo Alaceenadigital para poder acceder a el aarraylist creado
        //alfa=new AlacenaDigital();
        //Inicializamos componentes
        
        
        
        b_Salir=new JButton("Salir");
        dt=new DefaultTableModel();
         b_Eliminar= new JButton("Consumir");
        //combo.setOpaque(false);
        //((JTextField)combo.getEditor().getEditorComponent()).setOpaque(false);
        dt.addColumn("Nombre");
        dt.addColumn("Precio");
        dt.addColumn("Cantidad");
        dt.addColumn("Clase");
        dt.addColumn("Pedir");
        dt.addColumn("Cantidad mínima");
        dt.addColumn("Ultima modificación");
        dt.addColumn("ID");
        jTable2=new JTable(dt);
        JLabel comp1=new JLabel();
        imagen_p1=new JLabel();
        imagen_p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/proyecto3.jpg")));
        comp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/proyecto3.jpg")));
        imagen_p1.setBounds(650,0,500, 200);
        comp1.setBounds(270, 0, 500, 200);
        imagen_p2=new JLabel();
        imagen_p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/proyecto3.jpg")));
        imagen_p2.setBounds(650,200,500,200);
        tf_Eliminar=new JTextField();
        
        
        jScrollPane2=new JScrollPane(jTable2);
        //jTable2.setDefaultRenderer(Object.class, new CeldaColor());
        jTable2.getColumnModel().getColumn(4).setCellRenderer(new CeldaColor());
        
        
        
        
        
        
        
        //Botones dinámicos
        b1 = new JButton("Capturar datos");
        b1.setFont(new java.awt.Font("Abyssinica SIL", 3, 12)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/guardar76.png"))); // NOI18N
        //b1.setText("Guardar");
        b1.setContentAreaFilled(false);
        b1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/guardar76.png"))); // NOI18N
        b1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/guardar96.png"))); // NOI18N
        b1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        
        
        
        // aqui termina apartado de botoes dinámicos
        compra = new JList();
        frame = new JFrame();
        //combo=new JComboBox();
        //combo.addItem(crear);
        prog = new JProgressBar();
        lbProg = new JLabel();
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf_Compras=new JTextField();
        lb2 = new JLabel();
        lb1 = new JLabel();
        lb3 = new JLabel();
        lb4 = new JLabel();
        lb5 = new JLabel();
        lb_Comprar_Producto = new JLabel();
        lb_Inventario = new JLabel("Producto de inventario");
        lb_Compras=new JLabel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
       // p1.add(imagen_p2);
        b2 = new JButton("Soy el panel 2");
        b3 = new JButton("Soy el panel 3");
        b_Compras=new JButton("Guardar");
        
        
        b_Guardar=new JButton("Save");
        b_Guardar.setFont(new java.awt.Font("Abyssinica SIL", 3, 12)); // NOI18N
        b_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Guardarbase.png"))); // NOI18N
        b_Guardar.setText("Guardar");
        b_Guardar.setContentAreaFilled(false);
        b_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b_Cargar=new JButton("Cargar datos");
        combo_Crear = new JComboBox();
        combo_Crear.addItem(mercado);
        combo_Crear.addItem(farmacia);
        articulos = new JList();
        articulos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        articulos.setLayoutOrientation(JList.VERTICAL_WRAP);
        articulos.setVisibleRowCount(-1);
        compra.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        compra.setLayoutOrientation(JList.VERTICAL_WRAP);
        compra.setBounds(0, 30, 300, 800);
        compra.setVisibleRowCount(-1);
        articulos.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent arg0)
            {
                if (!arg0.getValueIsAdjusting())
                {
                    for (Tienda Producto : Almacen)
                    {
                        if (articulos.getSelectedValue().toString().equals(Producto.getNombreProducto()))
                        {
                            precio = String.valueOf(Producto.getPrecio());
                            cantidad = String.valueOf(Producto.getCantidadRequerida());
                            lb1.setText("Nombre: " + Producto.getNombreProducto() + "   Precio: " + precio + "     Cantidad:   " + cantidad + "   Pertenece: " + Producto.getClasePertenencia());
                        }

                    }
                }
            }
        });
        scroller = new JScrollPane(articulos);
        scroller.setPreferredSize(new Dimension(250, 80));
        modelo = new DefaultListModel();
        for (Tienda Producto : Almacen)
        {
            modelo.addElement(Producto.getNombreProducto());

        }
        articulos.setModel(modelo);

        //Diseño
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1060, 2000);
        p1.setLayout(null);
        p1.setBounds(0, 0, 1060, 400);
        //p1.setBackground(new java.awt.Color(26, 101, 190));
        frame.getContentPane().add(p1);
        combo.setBounds(0, 0, 270, 30);
        
        lb2.setBounds(0, 30, 250, 30);
        lb3.setBounds(0, 90, 300, 30);
        tf1.setBounds(0, 120, 200, 30);
        lb4.setBounds(0, 150, 250, 30);
        lb5.setBounds(0, 210, 350, 30);
        tf3.setBounds(0, 240, 200, 30);
        tf1.setVisible(false);
        tf2.setBounds(0, 180, 200, 30);
        tf2.setVisible(false);
        tf3.setVisible(false);
        b1.setBounds(250, 250, 150, 100);
        lbProg.setBounds(400, 300, 350, 30);
        prog.setBounds(400, 330, 300, 50);
        prog.setVisible(false);
        
        b_Guardar.setBounds(300,0, 150, 80);
        b_Guardar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                //System.out.println("EL MENSAJE HA SIDO "+JOptionPane.showInputDialog("Ingrese el nombre del archivo") );
                
                String path="./Save/"+JOptionPane.showInputDialog("Ingrese el nombre del archivo")+".txt";
                    File file=new File(path);
                    try
                    {
                        FileWriter fw=new FileWriter(file);
                        BufferedWriter bw=new BufferedWriter(fw);
                        for(int i=0;i<jTable2.getRowCount();i++)
                        {
                            for(int j=0;j<jTable2.getColumnCount();j++)
                            {
                                bw.write(jTable2.getValueAt(i, j).toString()+" ");
                            }
                            bw.newLine();
                        }
                        bw.close();
                        fw.close();
                    } catch (IOException e)
                    {
                        System.out.println(e);
                    }
                    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente en la base de datos");
                    b_Cargar.setVisible(false);
            }
        });
        b_Salir.setBounds(400, 180, 120, 30);
        b_Salir.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                    AlacenaDigital obj = new AlacenaDigital(null);
                    Inicio obj1 = null;
                try
                {
                    obj1 = new Inicio();
                } catch (IOException ex)
                {
                    Logger.getLogger(AlacenaDigital.class.getName()).log(Level.SEVERE, null, ex);
                }
                    obj1.setVisible(true);
                    obj.frame.getContentPane().setVisible(false);
            }
        });
        //p1.add(b_Salir);
        b_Cargar.setBounds(480,0,150,80);
        b_Cargar.setFont(new java.awt.Font("Abyssinica SIL", 3, 12)); // NOI18N
        b_Cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/cargar.png"))); // NOI18N
        b_Cargar.setText("Cargar datos");
        b_Cargar.setContentAreaFilled(false);
        b_Cargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b_Cargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        b_Cargar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                subMenu();
               /*
                String mar="Supermercado";
                String far="Farmacia";
                String nombre="";
                ControlID=1;
                double price=0;
                //int id=0;
                int cant=0;
                String clase="";
                int limInf=0;
                Date date=null;
                String path="./beta.txt";
                    File file=new File(path);
                    if(file.length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "No hay datos guardados");
                    }
                    else
                    {
                        try
                    {
                        FileReader fr=new FileReader(file);
                        BufferedReader br=new BufferedReader(fr);
                        mod=(DefaultTableModel)jTable2.getModel();
                        Object[] ey=br.lines().toArray();
                        for(int i=0;i<ey.length;i++)
                        {
                            String[]row=ey[i].toString().split(" ");
                            
                            mod.addRow(row);
                        }
                        
                    } catch (FileNotFoundException e)
                    {
                    }
                    for(int m=0;m<jTable2.getRowCount();m++)
                    {
                        if(jTable2.getValueAt(m, 3).toString().equals(mar))
                        {
                            System.out.println("Entrando");
                            Supermercado obj1=new Supermercado();
                            //obj1.setID(m+1);
                            nombre=(String)jTable2.getValueAt(m, 0);
                            price=Double.parseDouble((String)jTable2.getValueAt(m, 1));
                            cant=Integer.parseInt((String)jTable2.getValueAt(m, 2));
                            clase=(String)jTable2.getValueAt(m, 3);
                            limInf=Integer.parseInt((String)jTable2.getValueAt(m, 5));
                            //id=Integer.parseInt((String)jTable2.getValueAt(m, 7));
                            //date=(Date)jTable2.getValueAt(m, 6);
                            obj1.setNombreProducto(nombre);
                            obj1.setPrecio(price);
                            obj1.setCantidadRequerida(cant);
                            obj1.setClasePertenencia(clase);
                            obj1.setLimInf(limInf);
                            obj1.setID(ControlID);
                            System.out.println(ControlID);
                            jTable2.setValueAt(ControlID, m, 7);
                            //obj1.setDate(date);
                            //ControlID++;
                            Almacen.add(obj1);
                            
                        }
                        if(jTable2.getValueAt(m, 3).toString().equals(far))
                        {
                            //System.out.println("Entramos :)");
                            Farmacia obj1=new Farmacia();
                            //ControlID++;
                            //obj1.setID(m+1);
                            //id=Integer.parseInt((String)jTable2.getValueAt(m, 7));
                            
                            nombre=(String)jTable2.getValueAt(m, 0);
                            System.out.println((String)jTable2.getValueAt(m, 0));
                            price=Double.parseDouble((String)jTable2.getValueAt(m, 1));
                            cant=Integer.parseInt((String)jTable2.getValueAt(m, 2));
                            clase=(String)jTable2.getValueAt(m, 3);
                            limInf=Integer.parseInt((String)jTable2.getValueAt(m, 5));
                            //date=(String)jTable2.getValueAt(m, 6);
                            obj1.setNombreProducto(nombre);
                            obj1.setPrecio(price);
                            obj1.setCantidadRequerida(cant);
                            obj1.setClasePertenencia(clase);
                            obj1.setLimInf(limInf);
                            obj1.setID(ControlID);
                            jTable2.setValueAt(ControlID, m, 7);
                            //System.out.println(obj1.getID());
                            //System.out.println(limInf);
                            //obj1.setDate(date);
                            //System.out.println((String)jTable2.getValueAt(m, 7));
                            Almacen.add(obj1);
                            //System.out.println("Saliendo del problema");
                        }
                        ControlID++;
                                                
                    }
                    for (Tienda Producto : Almacen)
                    {
                        System.out.println(Producto.getNombreProducto());
                        articulos_Comprar.add(Producto.getNombreProducto());
                        combo_Comprar.addItem(Producto.getNombreProducto());
                       // combo_Eliminar.addItem(Producto.getNombreProducto());
                    }
                    JOptionPane.showMessageDialog(null, "Carga de datos exitosa");
                    b_Cargar.setVisible(false);
                    //llenar_Combo_Comprar();
                    //Update();
                    
                    }
                    
                    
                  */  
            }
        });
        p1.add(lbProg);
        p1.add(prog);
        //p1.add(b_Cargar);
        //p1.add(b_Guardar);
       // p1.add(comp1);
        b1.setVisible(false);
        JLabel lab=new JLabel();
        lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/proyecto3.jpg")));
        lab.setBounds(270,200,800,200);
       
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                Operation op=new Operation();
                Date cal=new Date();
                boolean free = false;
                String strDate=cal.toString();
                String view = (String) combo_Crear.getSelectedItem();
                String nombre=tf1.getText();
                String band = tf2.getText();
                String band1 = tf3.getText();
                double price = Double.parseDouble(band);
                int required = Integer.parseInt(band1);
                
                if (view.equals(mercado))
                {
                    try
                    {
                        op.insert("Supermercado", nombre,0, price, required, strDate, ControlID);
                        //op.conect();
                    } catch (Exception ex)
                    {
                        Logger.getLogger(AlacenaDigital.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Supermercado market = new Supermercado();
                    market.setClasePertenencia("Supermercado");
                    market.setNombreProducto(tf1.getText());
                    market.setPrecio(price);
                    market.setCantidadRequerida(0);
                    market.setLimInf(required);
                    market.setDate(strDate);
                    market.setID(ControlID);
                    System.out.println(ControlID);
                    combo_Comprar.addItem(market.getNombreProducto());
                    combo_Eliminar.addItem(market.getNombreProducto());
                    //articulos_Comprar[j]=market.getNombreProducto();
                    //combo_Comprar.addItem(articulos_Comprar[j]);
                    
                    Almacen.add(market);
                    for (Tienda Producto : Almacen)
                    {
                        if (Producto.getNombreProducto().equals(market.getNombreProducto()))
                        {
                            System.out.println(Producto.getNombreProducto());
                            fila[0]=Producto.getNombreProducto();
                            fila[1]=Producto.getPrecio();
                            fila[2]=Producto.getCantidadRequerida();
                            fila[3]=Producto.getClasePertenencia();
                            fila[5]=Producto.getLimInf();
                            fila[6]=Producto.getDate();
                            fila[7]=Producto.getID();
                            if(Producto.getCantidadRequerida()<Producto.getLimInf())
                            {
                                fila[4]="si";
                            }
                            else
                            {
                                fila[4]="no";
                            }
               
                             dt.addRow(fila); 
                        }
                        
                    }
                    HiloAgregar h1=new HiloAgregar(lbProg,prog);
                    Thread t2=new Thread(h1);
                    t2.start();
                    // JOptionPane.showMessageDialog(null,"Creación completada de producto");
                   /* TaskProgressBar taskProgressBar = new TaskProgressBar(prog, lbProg, articulos, modelo);
                    Thread t1 = new Thread(taskProgressBar);
                    t1.start();
                    free = true;

                    HiloDeAgregar hilo = new HiloDeAgregar(articulos, modelo);
                    Thread t2 = new Thread(hilo);
                    t2.start();*/
                }
                if (view.equals(farmacia))
                {
                    try
                    {
                        op.insert("Farmacia", nombre,0, price, required, strDate, ControlID);
                        //op.conect();
                    } catch (Exception ex)
                    {
                        Logger.getLogger(AlacenaDigital.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Farmacia market = new Farmacia();
                    market.setClasePertenencia("Farmacia");
                    market.setNombreProducto(tf1.getText());
                    market.setPrecio(price);
                    market.setCantidadRequerida(0);
                    market.setLimInf(required);
                    market.setDate(strDate);
                    market.setID(ControlID);
                   //ControlID++;
                    System.out.println(ControlID);
                    combo_Comprar.addItem(market.getNombreProducto());
                    combo_Eliminar.addItem(market.getNombreProducto());
                    Almacen.add(market);
                    for (Tienda Producto : Almacen)
                    {
                        if (Producto.getNombreProducto().equals(market.getNombreProducto()))
                        {
                            System.out.println(Producto.getNombreProducto());
                            fila[0]=Producto.getNombreProducto();
                            fila[1]=Producto.getPrecio();
                            fila[2]=Producto.getCantidadRequerida();
                            fila[3]=Producto.getClasePertenencia();
                            fila[5]=Producto.getLimInf();
                            fila[6]=Producto.getDate();
                            fila[7]=Producto.getID();
                            if(Producto.getCantidadRequerida()<Producto.getLimInf())
                            {
                                fila[4]="si";
                            }
                            else
                            {
                                fila[4]="no";
                            }

                             dt.addRow(fila); 
                        }

                    }
                    HiloAgregar h1=new HiloAgregar(lbProg,prog);
                    Thread t2=new Thread(h1);
                    t2.start();
                    //JOptionPane.showMessageDialog(null,"Creación completada de producto");
                    j++;
                    /*TaskProgressBar taskProgressBar = new TaskProgressBar(prog, lbProg, articulos, modelo);
                    Thread t1 = new Thread(taskProgressBar);
                    t1.start();
                    free = true;

                    HiloDeAgregar hilo = new HiloDeAgregar(articulos, modelo);
                    Thread t2 = new Thread(hilo);
                    t2.start();*/
                }
                ControlID++;
                b_Cargar.setVisible(false);
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
        });
        p1.add(b1);
       // p1.add(lab);
        p1.add(lb5);
        p1.add(tf3);
        p1.add(tf2);
        p1.add(lb4);
        p1.add(tf1);
        p1.add(lb3);
        p1.add(lb2);
        combo_Crear.setBounds(0, 60, 200, 30);
        combo.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent arg0)
            {

                //System.out.println("Hola");
                if(combo.getSelectedItem().equals(show))
                {
                    tf_Eliminar.setVisible(false);
                    combo_Eliminar.setVisible(false);
                    b_Compras.setVisible(false);
                    apagar_comp_Compras();
                    //compra.setVisible(false);
                    combo_Comprar.setVisible(false);
                    Ocultar_Crear();
                    lb_Comprar_Producto.setText("");
                    
                    //mostrar_Datos_Table();
                    p3.setVisible(true);
                    
                   
                }
                if (combo.getSelectedItem().equals(crear))
                {
                    tf_Eliminar.setVisible(false);
                     b_Eliminar.setVisible(false);
                    combo_Eliminar.setVisible(false);
                    b_Compras.setVisible(false);
                    apagar_comp_Compras();
                    lb_Comprar_Producto.setText("");
                    //p3.setVisible(false);
                    //compra.setVisible(false);
                    combo_Comprar.setVisible(false);
                    Mostrar_Crear();
                }
                if(combo.getSelectedItem().equals(adios))
                {
                    tf_Eliminar.setVisible(false);
                     b_Eliminar.setVisible(false);
                    combo_Eliminar.setVisible(false);
                    b_Compras.setVisible(false);
                    AlacenaDigital obj = new AlacenaDigital(null);
                    //Inicio obj1=new Inicio();
                    //obj1.setVisible(true);
                    
                    frame.dispose();
                    System.exit(0);
                    //frame.getDefaultCloseOperation()
                    
                }
                if (combo.getSelectedItem().equals(buy))
                {
                    tf_Eliminar.setVisible(false);
                    combo_Eliminar.setVisible(false);
                    //p3.setVisible(false);
                    Ocultar_Crear();
                    //compra.setVisible(true);
                    combo_Comprar.setVisible(true);
                    comp_Compras();
                    lb_Comprar_Producto.setText("Seleccione el produto a comprar");
                    b_Compras.setVisible(true);
                     b_Eliminar.setVisible(false);
                }
                
                if(combo.getSelectedItem().equals(eliminar))
                {
                    //tf_Compras.setVisible(false);
                    tf_Eliminar.setVisible(true);
                     b_Compras.setVisible(false);
                    lb_Compras.setText("Cantidad");
                    
                    Ocultar_Crear();
                    lb_Comprar_Producto.setText("Seleccione el producto a consumir");
                    combo_Comprar.setVisible(true);
                    //tf_Compras.setVisible(true);
                    b_Eliminar.setVisible(true);
                    //llenar_Combo_Comprar();
                    
                }
                if(combo.getSelectedItem().equals(crearUsuario))
                {
                    
                }
                

            }
        });
        p1.add(combo);
        //p1.add(imagen_p1);
        //Este se debe de quedar con borderlayout pporque sólo se insertará el Jlist
        p2.setLayout(null);
        p2.setBounds(700, 0, 350, 600);
        articulos.setBounds(0, 50, 290, 600);
        lb_Inventario.setBounds(0, 0, 250, 30);
        p2.add(articulos);
        p2.add(lb_Inventario);

        //frame.getContentPane().add(p2);
        p3.setLayout(new BorderLayout());
        p3.setBounds(0, 400, 1050, 200);
        //p3.add(lb1, BorderLayout.CENTER);
        frame.getContentPane().add(p3);
        //Para opción de comprar
        lb_Comprar_Producto.setBounds(0, 40, 250, 30);
        llenar_Combo_Comprar();
        combo_Comprar.setBounds(0, 75, 150, 30);
        combo_Comprar.setVisible(false);
        combo_Eliminar.setBounds(0, 75, 150, 30);
        combo_Eliminar.setVisible(false);
        //compra.setModel(modelo);
        lb_Compras.setBounds(0,100 ,250 ,30 );
        tf_Compras.setBounds(0,140 ,200 ,30 );
        tf_Eliminar.setBounds(0,140 ,200 ,30 );
        b_Compras.setBounds(0,190,170,30);
        b_Eliminar.setBounds(0,190,170,30);
        b_Eliminar.setVisible(false);
        tf_Eliminar.setVisible(false);
        p1.add(b_Eliminar);
        p1.add(tf_Eliminar);
        //Ya quedó corregido
        b_Compras.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                Operation op=new Operation();
                Date cal=new Date();
                String strDate=cal.toString();
                String s=(String) combo_Comprar.getSelectedItem();
                String s1=tf_Compras.getText();
                int cd=Integer.parseInt(s1);
                for (Tienda Producto : Almacen)
                {
                    if(Producto.getNombreProducto().equals(s))
                    {
                        int a=Producto.getID();
                        int b=Producto.getCantidadRequerida()+cd;
                        try
                        {
                            op.updatePrice(a,b);
                        } catch (Exception ex)
                        {
                            Logger.getLogger(AlacenaDigital.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Producto.setCantidadRequerida(Producto.getCantidadRequerida()+cd);
                        System.out.println(Producto.getID());
                        //System.out.println(Producto.getCantidadRequerida());
                        cd=Producto.getCantidadRequerida();
                        jTable2.setValueAt(b, Producto.getID()-3, 2);
                        jTable2.setValueAt(cal, Producto.getID()-3, 6);
                        if(Producto.getCantidadRequerida()<Producto.getLimInf())
                        {
                            jTable2.setValueAt("si", Producto.getID()-3, 4);
                        }
                        else
                        {
                             jTable2.setValueAt("no", Producto.getID()-3, 4);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
                tf_Compras.setText("");
                //System.out.println(Almacen.indexOf());
            }
        });
        b_Eliminar.addActionListener(new ActionListener()
                {
                    
                    @Override
                    
                    public void actionPerformed(ActionEvent arg0)
                    {
                        //System.out.println("A eliminar");
                        Operation op=new Operation();
                        Date cal=new Date();
                        String stDate=cal.toString();
                String s=(String) combo_Comprar.getSelectedItem();
                String s1=tf_Eliminar.getText();
                int cd=Integer.parseInt(s1);
                for (Tienda Producto : Almacen)
                {
                    //System.out.println(Producto.getID());
                    if(Producto.getNombreProducto().equals(s))
                    {
                        System.out.println("El Id es "+Producto.getID());
                        if(cd>Producto.getCantidadRequerida())
                        {
                            JOptionPane.showMessageDialog(null, "Imposible realizar esa operación, ha excedido el límite de consumo");
                        }
                        else
                        {
                            try
                            {
                                op.updatePrice(Producto.getID(), Producto.getCantidadRequerida()-cd);
                            } catch (Exception ex)
                            {
                                Logger.getLogger(AlacenaDigital.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        Producto.setCantidadRequerida(Producto.getCantidadRequerida()-cd);
                        System.out.println("Imprimiendo id");
                        System.out.println(Producto.getID());
                        //System.out.println(Producto.getCantidadRequerida());
                        cd=Producto.getCantidadRequerida();
                        jTable2.setValueAt(cd, Producto.getID()-3, 2);
                        jTable2.setValueAt(cal, Producto.getID()-3, 6);
                        if(Producto.getCantidadRequerida()<Producto.getLimInf())
                        {
                            jTable2.setValueAt("si", Producto.getID()-3, 4);
                        }
                        else
                        {
                             jTable2.setValueAt("no", Producto.getID()-3, 4);
                        }
                        }
                       // Producto.setID(Producto.getID()+1);
                    }
                }
                tf_Eliminar.setText(null);
                    }
                   
                });
        tf_Compras.setVisible(false);
        b_Compras.setVisible(false);
        compra.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent arg0)
            {
                String s=compra.getSelectedValue().toString();
                if (!arg0.getValueIsAdjusting())
                {
                   lb_Comprar_Producto.setText(null);
                    prender_apagar_lista_compras(false);
                    comp_Compras();
                    /*for (Tienda Producto : Almacen)
                    {
                        if (compra.getSelectedValue().toString().equals(Producto.getNombreProducto()))
                        {
                            precio = String.valueOf(Producto.getPrecio());
                            cantidad = String.valueOf(Producto.getCantidadRequerida());
                            lb1.setText("Nombre: " + Producto.getNombreProducto() + "   Precio: " + precio + "     Cantidad:   " + 0 + "   Pertenece: " + Producto.getClasePertenencia());
                        }

                    }*/
                    
                }
            }
        });
        
        p1.add(combo_Comprar);
        p1.add(combo_Eliminar);
        p1.add(lb_Comprar_Producto);
        p1.add(lb_Compras);
        p1.add(b_Compras);
        p1.add(tf_Compras);
        
        //table
        
        //dt.addRow(fila);
        mostrar_Datos_Table();
        //jScrollPane2.setVisible(false);
        p3.add(jScrollPane2,BorderLayout.CENTER);
        p3.setVisible(false);
        //jTable2.setDefaultRenderer(Object.class, new CeldaColor());
        
        
        
        
        
        //validaciones 
        tf1.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent arg0) 
        {
                Character ch = arg0.getKeyChar();
                String aux = tf1.getText()+ch;
                //if(aux.matches("^[a-z A-z]+$")){[0-9]{0,1}[0-9]{0,1}[0-9]{0,1}
                if(aux.matches("[a-z A-Z]+")){
                    tf1.setText(aux);
                }else{
                    aux.replace(ch.toString(), "");
                }
                arg0.consume();
        }
    });
        tf2.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent arg0) 
        {
                Character ch = arg0.getKeyChar();
                String aux = tf2.getText()+ch;
                //if(aux.matches("^[a-z A-z]+$")){[0-9]{0,1}[0-9]{0,1}[0-9]{0,1}
                if(aux.matches("^([0-9]{0,4})")){
                    tf2.setText(aux);
                }else{
                    aux.replace(ch.toString(), "");
                }
                arg0.consume();
        }
    });
        tf3.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent arg0) 
        {
                Character ch = arg0.getKeyChar();
                String aux = tf3.getText()+ch;
                //if(aux.matches("^[a-z A-z]+$")){[0-9]{0,1}[0-9]{0,1}[0-9]{0,1}
                if(aux.matches("^([0-9]{0,4})")){
                    tf3.setText(aux);
                }else{
                    aux.replace(ch.toString(), "");
                }
                arg0.consume();
        }
    });
        tf_Compras.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent arg0) 
        {
                Character ch = arg0.getKeyChar();
                String aux = tf_Compras.getText()+ch;
                //if(aux.matches("^[a-z A-z]+$")){[0-9]{0,1}[0-9]{0,1}[0-9]{0,1}
                if(aux.matches("^([0-9]{0,4})")){
                    tf_Compras.setText(aux);
                }else{
                    aux.replace(ch.toString(), "");
                }
                arg0.consume();
        }
    });
        tf_Eliminar.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent arg0) 
        {
                Character ch = arg0.getKeyChar();
                String aux = tf_Eliminar.getText()+ch;
                //if(aux.matches("^[a-z A-z]+$")){[0-9]{0,1}[0-9]{0,1}[0-9]{0,1}
                if(aux.matches("^([0-9]{0,4})")){
                    tf_Eliminar.setText(aux);
                }else{
                    aux.replace(ch.toString(), "");
                }
                arg0.consume();
        }
    });
        
        
        
    }
    
    public void Mostrar_Crear()
    {
        compra.setVisible(false);
        b1.setVisible(true);
        tf1.setVisible(true);
        tf2.setVisible(true);
        tf3.setVisible(true);
        combo_Crear.setVisible(true);
        //CrearProducto();
        System.out.println("Debugeando");
        lb2.setText("Elija la clase a la que pertenece");
        lb3.setText("Nombre del producto a crear");
        lb4.setText("Ingrese el precio del producto");
        lb5.setText("Ingrese la cantidad mínima permitida");
        p1.add(combo_Crear);
    }
    
    public void Ocultar_Crear()
    {
        //compra.setVisible(false);
        combo_Crear.setVisible(false);
        b1.setVisible(false);
        tf1.setVisible(false);
        tf2.setVisible(false);
        tf3.setVisible(false);
        //CrearProducto();
        System.out.println("Debugeando");
        lb2.setText(null);
        lb3.setText(null);
        lb4.setText(null);
        lb5.setText(null);
    }
    public void prender_apagar_lista_compras(boolean charlie)
    {
        compra.setVisible(charlie);
    }
    public void comp_Compras()
    {
        tf_Compras.setVisible(true);
        lb_Compras.setText("Cantidad  de producto");
        b_Compras.setVisible(true);
    }
    public void apagar_comp_Compras()
    {
        tf_Compras.setVisible(false);
        lb_Compras.setText("");
        b_Compras.setVisible(false);
    }
    public void mostrar_Datos_Table()
    {
        Operation op=new  Operation();
        try
        {
            Almacen=op.query();
        } catch (Exception ex)
        {
            Logger.getLogger(AlacenaDigital.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Tienda Producto : Almacen)
        {
               Date cal=new Date();
               fila[0]=Producto.getNombreProducto();
               fila[1]=Producto.getPrecio();
               fila[2]=Producto.getCantidadRequerida();
               fila[3]=Producto.getClasePertenencia();
               fila[5]=Producto.getLimInf();
               fila[6]=Producto.getDate();
               fila[7]=Producto.getID();
               if(Producto.getCantidadRequerida()<Producto.getLimInf())
               {
                   fila[4]="si";
               }
               else
               {
                   fila[4]="no";
               }
               ControlID=Producto.getID();
               dt.addRow(fila); 
                
        }
        ControlID++;
    }
    public void llenar_Combo_Comprar()
    {
        
        
        for (Tienda Producto : Almacen)
        {
            System.out.println(Producto.getNombreProducto());
            articulos_Comprar.add(Producto.getNombreProducto());
            combo_Comprar.addItem(Producto.getNombreProducto());
            combo_Eliminar.addItem(Producto.getNombreProducto());
        }
        
    }
    public void limpiarTabla()
    {
        for(int i=0;i<jTable2.getRowCount();i++)
        {
            for(int j=0;j<jTable2.getColumnCount();j++)
            {
                jTable2.setValueAt("", i, j);
           }
        }
    }
    public void Update()
    {
        String nombre="";
        double price=0;
        int cantidad=0;
        String clase="";
        int limInf=0;
        String date=null;
        for(int i=0;i<jTable2.getRowCount();i++)
        {
            System.out.println("hola");
            for (Tienda Producto : Almacen)
            {
                nombre=Producto.getNombreProducto();
                
                price=Producto.getPrecio();
                cantidad=Producto.getCantidadRequerida();
                clase=Producto.getClasePertenencia();
                limInf=Producto.getLimInf();
                date=Producto.getDate();
                jTable2.setValueAt(nombre,i,0);
                //System.out.println(nombre);
                jTable2.setValueAt(price,i,1);
                jTable2.setValueAt(cantidad,i,2);
                jTable2.setValueAt(clase,i,3);
                jTable2.setValueAt(limInf,i,5);
               // jTable2.setValueAt(date,i,6);
                                //jTable2.setValueAt("", i, );
            }
        }
    }
public void actualizar()
{
    String mar="Supermercado";
                String far="Farmacia";
                String nombre="";
                ControlID=1;
                double price=0;
                //int id=0;
                int cant=0;
                String clase="";
                int limInf=0;
                Date date=null;
                String path="./beta.txt";
                    File file=new File(path);
                    try
                    {
                        FileReader fr=new FileReader(file);
                        BufferedReader br=new BufferedReader(fr);
                        mod=(DefaultTableModel)jTable2.getModel();
                        Object[] ey=br.lines().toArray();
                        for(int i=0;i<ey.length;i++)
                        {
                            String[]row=ey[i].toString().split(" ");
                            
                            mod.addRow(row);
                        }
                        
                    } catch (FileNotFoundException e)
                    {
                    }
                    for(int m=0;m<jTable2.getRowCount();m++)
                    {
                        if(jTable2.getValueAt(m, 3).toString().equals(mar))
                        {
                            System.out.println("Entrando");
                            Supermercado obj1=new Supermercado();
                            //obj1.setID(m+1);
                            nombre=(String)jTable2.getValueAt(m, 0);
                            price=Double.parseDouble((String)jTable2.getValueAt(m, 1));
                            cant=Integer.parseInt((String)jTable2.getValueAt(m, 2));
                            clase=(String)jTable2.getValueAt(m, 3);
                            limInf=Integer.parseInt((String)jTable2.getValueAt(m, 5));
                            //id=Integer.parseInt((String)jTable2.getValueAt(m, 7));
                            //date=(Date)jTable2.getValueAt(m, 6);
                            obj1.setNombreProducto(nombre);
                            obj1.setPrecio(price);
                            obj1.setCantidadRequerida(cant);
                            obj1.setClasePertenencia(clase);
                            obj1.setLimInf(limInf);
                            obj1.setID(ControlID);
                            jTable2.setValueAt(ControlID, m, 7);
                            //obj1.setDate(date);
                            //ControlID++;
                            Almacen.add(obj1);
                            
                        }
                        if(jTable2.getValueAt(m, 3).toString().equals(far))
                        {
                            System.out.println("Entramos :)");
                            Farmacia obj1=new Farmacia();
                            //ControlID++;
                            //obj1.setID(m+1);
                            //id=Integer.parseInt((String)jTable2.getValueAt(m, 7));
                            
                            nombre=(String)jTable2.getValueAt(m, 0);
                            System.out.println((String)jTable2.getValueAt(m, 0));
                            price=Double.parseDouble((String)jTable2.getValueAt(m, 1));
                            cant=Integer.parseInt((String)jTable2.getValueAt(m, 2));
                            clase=(String)jTable2.getValueAt(m, 3);
                            limInf=Integer.parseInt((String)jTable2.getValueAt(m, 5));
                            //date=(String)jTable2.getValueAt(m, 6);
                            obj1.setNombreProducto(nombre);
                            obj1.setPrecio(price);
                            obj1.setCantidadRequerida(cant);
                            obj1.setClasePertenencia(clase);
                            obj1.setLimInf(limInf);
                            obj1.setID(ControlID);
                            jTable2.setValueAt(ControlID, m, 7);
                            System.out.println(obj1.getID());
                            //System.out.println(limInf);
                            //obj1.setDate(date);
                            //System.out.println((String)jTable2.getValueAt(m, 7));
                            Almacen.add(obj1);
                        }
                        ControlID++;
}
    
    
    
    
    
    
}
    public void subMenu()
    {
        hola.setVisible(true);
       /*hola=new JFrame();
        dev=null;
        dav=0;
        absolutePath="./Save";
        archivo=new File(absolutePath);
        opciones=new String[50];
        llenarCombo();
        subMenu=new JComboBox<String>(opciones1);
        lbMenu=new JLabel();
        b50=new JButton("Aceptar");
        lbMenu.setText("Seleccione el archivo");
        
        hola.getContentPane().setLayout(null);
        hola.setBounds(0,0,500,500);
        
        hola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hola.setVisible(true);
        lbMenu.setBounds(0, 0, 200, 50);
        subMenu.setBounds(0, 60, 200, 50);
        b50.setBounds(200, 110, 100, 50);
        hola.getContentPane().add(lbMenu);
        hola.getContentPane().add(subMenu);
        hola.getContentPane().add(b50);
        lbMenu.setVisible(true);
        subMenu.setVisible(true);
        b50.setVisible(true);*/
        b50.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                dev=(String) subMenu.getSelectedItem();
                hola.setVisible(false);
                System.out.println(dev);
                String mar="Supermercado";
                String far="Farmacia";
                String nombre="";
                ControlID=0;
                double price=0;
                //int id=0;
                int cant=0;
                String clase="";
                int limInf=0;
                Date date=null;
                String path="./Save/"+dev;
                    File file=new File(path);
                    if(file.length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "No hay datos guardados");
                    }
                    else
                    {
                        try
                    {
                        FileReader fr=new FileReader(file);
                        BufferedReader br=new BufferedReader(fr);
                        mod=(DefaultTableModel)jTable2.getModel();
                        Object[] ey=br.lines().toArray();
                        for(int i=0;i<ey.length;i++)
                        {
                            String[]row=ey[i].toString().split(" ");
                            
                            mod.addRow(row);
                        }
                        
                    } catch (FileNotFoundException e)
                    {
                    }
                    for(int m=0;m<jTable2.getRowCount();m++)
                    {
                        if(jTable2.getValueAt(m, 3).toString().equals(mar))
                        {
                            System.out.println("Entrando");
                            Supermercado obj1=new Supermercado();
                            //obj1.setID(m+1);
                            nombre=(String)jTable2.getValueAt(m, 0);
                            price=Double.parseDouble((String)jTable2.getValueAt(m, 1));
                            cant=Integer.parseInt((String)jTable2.getValueAt(m, 2));
                            clase=(String)jTable2.getValueAt(m, 3);
                            limInf=Integer.parseInt((String)jTable2.getValueAt(m, 5));
                            //id=Integer.parseInt((String)jTable2.getValueAt(m, 7));
                            //date=(Date)jTable2.getValueAt(m, 6);
                            obj1.setNombreProducto(nombre);
                            obj1.setPrecio(price);
                            obj1.setCantidadRequerida(cant);
                            obj1.setClasePertenencia(clase);
                            obj1.setLimInf(limInf);
                            obj1.setID(ControlID);
                            System.out.println(ControlID);
                            jTable2.setValueAt(ControlID, m, 7);
                            //obj1.setDate(date);
                            //ControlID++;
                            Almacen.add(obj1);
                            
                        }
                        if(jTable2.getValueAt(m, 3).toString().equals(far))
                        {
                            //System.out.println("Entramos :)");
                            Farmacia obj1=new Farmacia();
                            //ControlID++;
                            //obj1.setID(m+1);
                            //id=Integer.parseInt((String)jTable2.getValueAt(m, 7));
                            
                            nombre=(String)jTable2.getValueAt(m, 0);
                            System.out.println((String)jTable2.getValueAt(m, 0));
                            price=Double.parseDouble((String)jTable2.getValueAt(m, 1));
                            cant=Integer.parseInt((String)jTable2.getValueAt(m, 2));
                            clase=(String)jTable2.getValueAt(m, 3);
                            limInf=Integer.parseInt((String)jTable2.getValueAt(m, 5));
                            //date=(String)jTable2.getValueAt(m, 6);
                            obj1.setNombreProducto(nombre);
                            obj1.setPrecio(price);
                            obj1.setCantidadRequerida(cant);
                            obj1.setClasePertenencia(clase);
                            obj1.setLimInf(limInf);
                            obj1.setID(ControlID);
                            jTable2.setValueAt(ControlID, m, 7);
                            //System.out.println(obj1.getID());
                            //System.out.println(limInf);
                            //obj1.setDate(date);
                            //System.out.println((String)jTable2.getValueAt(m, 7));
                            Almacen.add(obj1);
                            //System.out.println("Saliendo del problema");
                        }
                        ControlID++;
                                                
                    }
                    for (Tienda Producto : Almacen)
                    {
                        System.out.println(Producto.getNombreProducto());
                        articulos_Comprar.add(Producto.getNombreProducto());
                        combo_Comprar.addItem(Producto.getNombreProducto());
                       // combo_Eliminar.addItem(Producto.getNombreProducto());
                    }
                    JOptionPane.showMessageDialog(null, "Carga de datos exitosa");
                    b_Cargar.setVisible(false);
                    //llenar_Combo_Comprar();
                    //Update();
                    
                    }
                
            }
        });
        
    }
    public void llenarCombo()
    {
        arregloArchivo=archivo.listFiles();
        subMenu.addItem("");
        for(File arch:arregloArchivo)
        {
            subMenu.addItem(arch.getName());
        }
    }
}