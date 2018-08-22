/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1.Encuesta.Compilador;

/**
 *
 * @author Javier Solares
 */
public class CrearArchivo {
    
   public void CrearFile(String entrada,String nombre) {

        System.out.print("Archivo de Excel Correcto\n");
        //Creo una carpeta en /home/usuario/SalidasDot, en donde va estar todo
        File folder = new File(System.getProperty("user.home") + File.separator + "SalidasDot");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        //Rutas para el .dot y la imagen .png
        String ruta_entrada = System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + nombre+".txt";

        creararchivo(ruta_entrada, entrada.toString());

    }

//Este metodo es generico
    //Porque crea un archivo plano en base a la ruta y el contenido que se le pase
    public synchronized void creararchivo(String pfichero, String pcontenido) {
        FileWriter archivo = null;

        try {
            archivo = new FileWriter(pfichero);
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

        File a = new File(pfichero);
        if (!a.exists()) {
            return;
        }

        try (PrintWriter printwriter = new PrintWriter(archivo)) {
            printwriter.print(pcontenido);
            printwriter.close();
        }
    }
}
