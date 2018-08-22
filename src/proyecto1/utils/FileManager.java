package proyecto1.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class FileManager {
    
    
    /*private static final String baseDir = new File(".").getAbsolutePath();

    public static String writeXML(String fileName, String dirs, String fileContent) {
        String fullPath = baseDir + "/" + dirs + "/" + fileName;
        writeFile(fullPath, fileContent);
        return fullPath;
    }*/

    public static void writeFile(String filePath, String fileContent) {
        BufferedWriter writer = null;
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(fileContent);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            } // catch
        } // finally
    }

    public static void Append_To(String ruta, String txt) {
        try (FileWriter fw = new FileWriter(ruta, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            //Escribo la nueva BD en el master
            out.println(txt);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void rewrite(String ruta, String txt) {
        try (FileWriter fw = new FileWriter(ruta, false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(txt);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } // catch
    }
    
    public static void createFileIfNotExists(String filePath){
        try {
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            } // if
        } catch (Exception e) {
        } // catch
    }
    
    public static String readFile(String filePath){
        String fileText = "";
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                fileText += sCurrentLine+"\n";
            } // while
        } catch (Exception e) {
        } // catch
        
        return fileText;
    }
    
}
