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
import proyecto1.Encuesta.Analizador.Analyzer;
import proyecto1.Encuesta.Analizador.ParseException;
import proyecto1.Encuesta.Compilador;
import proyecto1.Config.GraficadorConfig;
import proyecto1.Config.Analizador.Configuraciones;
import proyecto1.Encuesta.Graficador;

import proyecto1.utils.FileManager;

/**
 *
 * @author Javier Solares
 */
public class Proyecto1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  IOException, ParseException {
        //primer archivo
        FileManager milenguaje=new FileManager();
      String missentencias=milenguaje.readFile(System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"entrada.dot");
      
     
      
      InputStream txtanalizar = new ByteArrayInputStream(missentencias.getBytes());
      Analyzer analyzer = new Analyzer(txtanalizar);
          // analyzer.INICIO();
         Graficador g = new Graficador();
        
     //g.graficarAST(analyzer.root);
     
     //termina primer archivo
         GUI interfaz=new GUI();
         interfaz.setVisible(true);
         //tercer archivo
        FileManager milenguaje3=new FileManager();
      String missentencias3=milenguaje3.readFile(System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"configuracion.txt");
      
     
      
      InputStream txtanalizar3 = new ByteArrayInputStream(missentencias3.getBytes());
      Configuraciones config = new Configuraciones(txtanalizar3);
        try {
            config.INICIO();
      GraficadorConfig g3=new GraficadorConfig();
                    
                 g3.graficarAST(config.root);
        } catch (proyecto1.Config.Analizador.ParseException ex) {
            Logger.getLogger(Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        }


     
     //termina tercer archivo
   
         
    }
        
// TODO code application logic here
    
    
}
