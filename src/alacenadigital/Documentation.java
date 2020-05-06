
package alacenadigital;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PagePanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Documentation extends JFrame
{
     PagePanel panelpdf;
    File file;
    PDFFile pdffile;
    int indice;
    private Inicio obj;
    private JPanel panel;
    public Documentation() throws IOException 
    {
        super("Visor PDF");
        indice = 1;
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setLayout(new GridLayout(2, 1, 8, 16));
        //this.setSize(300, 200);
        //this.setResizable(false);
        //this.setBounds(600, 400, 600, 400);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() throws IOException {
        obj=new Inicio();
        panelpdf = new PagePanel();
        panel = new JPanel();
        try {
            file = new File("./AlacenaDigital.pdf");
            FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            pdffile = new PDFFile(buf);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        }
        JButton bsiguiente = new JButton("Siguiente");

        bsiguiente.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                indice++;
                if (indice <= pdffile.getNumPages()) {
                    panelpdf.showPage(pdffile.getPage(indice));
                } else 
                {
                    indice = pdffile.getNumPages();
                    JOptionPane.showMessageDialog(null, "Límite de página", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,"Regresando al menu");
                    dispose();
                    obj.setVisible(true);
                }
            }
        });
        JButton banterior = new JButton("Anterior");

        banterior.addActionListener((ActionEvent e) ->
        {
            indice--;
            if (indice > 0) {
                panelpdf.showPage(pdffile.getPage(indice));
            } else {
                indice = 1;
                JOptionPane.showMessageDialog(null, "Límite de página", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        panel.add(banterior);
        panel.add(bsiguiente);
        this.add(panelpdf);
        this.add(panel, BorderLayout.SOUTH);
        this.setVisible(true);
        //panelpdf.showPage(pdffile.getPage(indice));
    }

}
