/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto1.XLSaXForm.Analizador.Analyzer;
import proyecto1.XLSaXForm.Analizador.ParseException;
import proyecto1.XLSaXForm.Traductor;
import proyecto1.XLSaXForm.Compilador;
import proyecto1.XLSaXForm.Graficador;
import proyecto1.utils.FileManager;

/**
 *
 * @author Javier Solares
 */
public class Proyecto1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  IOException {
        FileManager milenguaje=new FileManager();
      String missentencias=milenguaje.readFile(System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"entrada.dot");
      
       InputStream txtanalizar = new ByteArrayInputStream(missentencias.getBytes());
      Analyzer analyzer = new Analyzer(txtanalizar);
        //analyzer.INICIO();
        // Graficador g = new Graficador();
        //g.graficarAST(analyzer.root);
         GUI interfaz=new GUI();
         interfaz.setVisible(true);
    }
        
// TODO code application logic here
    
    
}
