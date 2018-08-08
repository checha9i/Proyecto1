/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto1.XLSaXForm.Analizador;
import proyecto1.XLSaXForm.Compilador;
import proyecto1.XLSaXForm.Graficador;

/**
 *
 * @author Javier Solares
 */
public class Proyecto1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  IOException {
      FileInputStream file = new FileInputStream(new File("E:\\USAC\\2018\\Segundo Semestre\\Compi2\\Proyecto1\\Ejemplomio.xls"));
	Analizador xform =new Analizador();
        xform.Ordenar(file);
        Graficador g = new Graficador();
        //g.graficarAST(xform.root);
                
    }
        
// TODO code application logic here
    
    
}
