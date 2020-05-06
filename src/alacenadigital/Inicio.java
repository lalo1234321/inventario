
package alacenadigital;

import alacenadigital.Store.Supermercado;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Inicio extends JFrame implements ActionListener
{
    //public JFrame frame1;
    private Login log;
    private JLabel jLabel1,bienvenido;
    private JButton b1;
    public JMenuItem iniciar;
    private JMenuBar jm;
    private JMenuItem jm1;
    public AlacenaDigital obj;
    public JMenuItem salir,acerca,acerca1;
    private String path="/home/sergio/Documents/4 Semestre/Tópicos avanzados de prog/Proyecto Equipo/AlacenaDigital/guia.pdf";
    public Inicio() throws IOException 
    {
	initialize();
    }
    private void initialize() throws IOException
    {
        obj=new AlacenaDigital(null);
        log=new Login();
        bienvenido=new JLabel();
        jLabel1 = new javax.swing.JLabel();
        jm1=new JMenuItem("Submenu");
        jm=new JMenuBar();
        
        jm.setBounds(0, 5, 100, 25);
        bienvenido.setBounds(200, 600, 500, 25);
        bienvenido.setText("¡Bienvenido, selecciona la opción en la barra de menú!");
        bienvenido.setForeground(Color.black);
        jm.setBackground(new java.awt.Color(  217, 193, 147 ));
        jm1.setBackground(new java.awt.Color(  217, 193, 147 ));
        JMenu File=new JMenu("Inicio");
        JMenu File1=new JMenu("Acerca de");
        File.setBackground(new java.awt.Color(  217, 193, 147 ));
        File1.setBackground(new java.awt.Color(  217, 193, 147 ));
        //jm1.add(File1);
        jm.add(File);
        acerca=new JMenuItem("Guía de usuario");
        acerca.addActionListener(this);
        acerca.setBackground(new java.awt.Color(  217, 193, 147 ));
        File1.add(acerca);    
        acerca1=new JMenuItem("Documentación");
        acerca1.addActionListener(this);
        acerca1.setBackground(new java.awt.Color(  217, 193, 147 ));
        File1.add(acerca1);
        iniciar=new JMenuItem("Ir a aplicación");
        iniciar.setBackground(new java.awt.Color(  217, 193, 147 ));
        iniciar.addActionListener(this);
        File.add(iniciar);
        File.add(File1);
        salir=new JMenuItem("Salir");
        salir.setBackground(new java.awt.Color(  217, 193, 147 ));
        salir.addActionListener(this);
        File.add(salir);
        this.getContentPane().add(bienvenido);
        this.getContentPane().add(jm);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/taza.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
}

    @Override
    public void actionPerformed(ActionEvent arg0)
    {  
            if(arg0.getSource()==acerca)
        {
            
            this.setVisible(false);
                try
                {
                    //System.out.println("Entré");
                    PdfViewer obj=new PdfViewer();
                    //obj.getContentPane().setVisible(true);
                } catch (IOException ex)
                {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        if(arg0.getSource()==acerca1)
        {
                try
                {
                    Documentation doc=new Documentation();
                } catch (IOException ex)
                {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        if(arg0.getSource()==iniciar)
        {
            log.setVisible(true);
            //obj.frame.setVisible(true);
            this.setVisible(false);
        }
        if(arg0.getSource()==salir)
        {
            this.setVisible(false);
            System.exit(0);
        }
        
    }
    
}
