package alacenadigital;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Login extends JFrame 
{
    //private JFrame frame;
    private int intentos;
    private String superUser;
    private Scanner sc;
    private JTextField tfUser;
    private JPasswordField tfPassword;
    private JLabel lbUser,lbPassword;
    private JButton b1;
    private File f,f1;
    private FileReader fr,fr1;
    private FileWriter fw,fw1;
    private BufferedWriter bw,bw1;
    private BufferedReader br,br1;
    private String[] usuarios,password;
    private AlacenaDigital obj;
    private JProgressBar pg;
    private JLabel lbProgress;
    private JFrame band;
    private JFrame bloqueo;
    private JLabel lbBloqueo;
    
    
    
    
    //Ian part
    private JButton b, c;
    private JTextField tf1;
    private JLabel lU, lP;
    private JPasswordField pas;
    private JPanel p;
    
    
    
    
    
    
    
    
    
    public Login() throws IOException
    {
        super("LOGIN");
        this.setSize(480, 300);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbProgress=new JLabel();
        pg=new  JProgressBar();
        obj=new AlacenaDigital(null);
        intentos=0;
        initComponents();
        //this.setVisible(true);
        //initialize();
    }
    public void initComponents() throws IOException
    {
        bloqueo=new JFrame();
        lbBloqueo=new JLabel();
        band=new JFrame();
        band=this;
        lU=new JLabel("Usuario:");
        lP=new JLabel("Contraseña:");
        b=new JButton("Aceptar");
        c=new JButton("Limpiar");
        tf1=new JTextField();
        pas=new JPasswordField();
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        bloqueo.getContentPane().setLayout(null);
        lU.setBounds(90, 42, 200, 25);
        tf1.setBounds(200, 42, 200, 25);
        lP.setBounds(90, 85, 200, 25);
        pas.setBounds(200, 85, 200, 25);
        b.setBounds(120, 130, 100, 30);
        c.setBounds(240, 130, 100, 30);
        lbProgress.setBounds(250,170 ,50 ,40 );
        pg.setBounds(90,210 ,350 ,40 );
        this.getContentPane().add(lU);
        this.getContentPane().add(tf1);
        this.getContentPane().add(lP);
        this.getContentPane().add(pas);
        this.getContentPane().add(b);
        this.getContentPane().add(c);
        this.getContentPane().add(lbProgress);
        this.getContentPane().add(pg);
        c.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                tf1.setText(null);
                pas.setText(null);
            }
        });
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                String user=null,pass=null;
                char[]view;
                user=tf1.getText();
                superUser=user;
                view=pas.getPassword();
                pass=String.valueOf(view);
                
                try
                {
                    extraerUsuarios();
                    
                } catch (IOException ex)
                {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(verificar(usuarios,user,pass))
                {
                    //JOptionPane.showMessageDialog(null, "Correcto");
                    Hilo h=new Hilo(lbProgress,pg,superUser,obj, (Login) band);
                    Thread t1=new Thread(h);
                    t1.start();
                    //obj.frame.setVisible(true);
                    //setVisible(false);
                }
                if(!verificar(usuarios,user,pass))
                {
                    JOptionPane.showMessageDialog(null, "Incorrecto");
                    
                }
            }
            
        });
        //lbProgress.setVisible(false);
        pg.setVisible(false);
        
    }
    public void initialize() throws IOException
    {
        //frame=new JFrame();
        //llenarArchivo();
        band=new JFrame();
        band=this;
        lbProgress=new JLabel();
        pg=new  JProgressBar();
        obj=new AlacenaDigital(null);
        b1=new JButton("Ingresar");
        tfUser=new JTextField();
        tfPassword=new JPasswordField();
        lbUser=new JLabel("Ingrese usuario");
        lbPassword=new JLabel("Ingrese la contraseña");
        this.getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,500,500);
        lbUser.setBounds(0,0,200,50);
        tfUser.setBounds(0,60,300,50);
        lbPassword.setBounds(0,120,200,50);
        tfPassword.setBounds(0,180,300,50);
        b1.setBounds(100, 240, 200, 50);
        lbProgress.setBounds(100,290,50,50);
        pg.setBounds(0, 340, 300, 50);
        lbProgress.setText(null);
        pg.setVisible(false);
        tfPassword.setVisible(true);
        tfUser.setVisible(true);
        lbPassword.setVisible(true);
        lbUser.setVisible(true);
        b1.setVisible(true);
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                String user=null,pass=null;
                char[]view;
                user=tfUser.getText();
                superUser=user;
                view=tfPassword.getPassword();
                pass=String.valueOf(view);
                
                try
                {
                    extraerUsuarios();
                    
                } catch (IOException ex)
                {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(verificar(usuarios,user,pass))
                {
                    //JOptionPane.showMessageDialog(null, "Correcto");
                    Hilo h=new Hilo(lbProgress,pg,superUser,obj, (Login) band);
                    Thread t1=new Thread(h);
                    t1.start();
                    //obj.frame.setVisible(true);
                    //setVisible(false);
                }
                if(!verificar(usuarios,user,pass))
                {
                    JOptionPane.showMessageDialog(null, "Incorrecto");
                }
            }
        });
        this.getContentPane().add(tfUser);
        this.getContentPane().add(tfPassword);
        this.getContentPane().add(lbPassword);
        this.getContentPane().add(lbUser);
        this.getContentPane().add(b1);
        this.getContentPane().add(lbProgress); 
        this.getContentPane().add(pg);
    }

    public void extraerUsuarios() throws FileNotFoundException, IOException
    {
        String cadena=null,cadena1=null;
        int contador=0,band=0;
        String path="./alfa.txt";
        String path1="./charlie.txt";
        f=new File(path);
        sc=new Scanner(f);
        fr=new FileReader(f);
        br=new BufferedReader(fr);
        f1=new File(path1);
        fr=new FileReader(f1);
        br1=new BufferedReader(fr);
        while((cadena=br.readLine())!=null)
        {
            contador++;
        }
        br.close();
        usuarios=new String[contador];
        while(sc.hasNextLine())
        {
            usuarios[band++]=sc.nextLine();
        }
        for(int i=0;i<usuarios.length;i++)
        {
            System.out.println(usuarios[i]);
        }
    }
    public void llenarArchivo() throws IOException
    {
        String path="./alfa.txt";
        f=new File(path);
        fw=new FileWriter(f);
        bw=new BufferedWriter(fw);
        bw.write("Lalo");
        bw.close();
        String path1="./charlie.txt";
        f1=new File(path1);
        fw1=new FileWriter(f1);
        bw1=new BufferedWriter(fw1);
        bw1.write("2402");
        bw1.close();
        
    }
    public boolean verificar(String[]array,String usuario, String pass)
    {
        boolean band=false;
        for(int i=0;i<array.length;i++)
        {
            if(array[i].equalsIgnoreCase(usuario)&&array[i+1].equals(pass))
            {
                band=true;
            }
            
            
        }
       
     
        return band;
        
    }
}
