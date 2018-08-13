/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.XLSaXForm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Javier Solares
 */
public class Traductor {

    public Nodo root;
    ArrayList<String> Encabezado = new ArrayList<String>();
    ArrayList<String> aux_list = new ArrayList<String>();
    StringBuffer buffer = new StringBuffer();

    public void Ordenar(FileInputStream file) throws IOException {
        //Nodo padre, hijo;
        // Crear el objeto que tendra el libro de Excel
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        //padre = new Nodo(Constants.INICIO,0,0,Constants.INICIO);
        //root=padre;


        /*
	
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
	
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
	
	 * que nos permite recorrer cada una de las filas que contiene.
	
         */
        HSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        /**
         *
         */
        int contadorCol = 0;
        int contadorFila = 0;
        int contadorAux = 0;
        Row row;
        boolean error = false;
        int conterror = 0;
        // Recorremos todas las filas para mostrar el contenido de cada celda
        while (rowIterator.hasNext()) {
            //Nodo hijo=new Nodo("Linea",0,0,"Linea");
            //     padre.hijos.add(hijo);
            row = rowIterator.next();

            // Obtenemos el iterator que permite recorres todas las celdas de una fila
            Iterator<Cell> cellIterator = row.cellIterator();

            Cell celda;

            contadorCol = 0;

            while (cellIterator.hasNext()) {
                //Nodo nieto;
                celda = cellIterator.next();

                if (contadorFila == 0) {
                    Encabezado.add(celda.getStringCellValue());
                } else {

                    // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                    switch (celda.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:

                            System.out.println(celda.getStringCellValue());
                            contadorCol++;
                            break;

                        case Cell.CELL_TYPE_STRING:
                            aux_list.add(celda.getStringCellValue());
                            contadorCol++;
                            break;

                        case Cell.CELL_TYPE_BOOLEAN:
                            if (celda.getBooleanCellValue() == true) {
                                aux_list.add("true");

                            } else {
                                aux_list.add("false");
                            }

                            contadorCol++;

                            break;
                        default:
                            // System.out.println("false");
                            aux_list.add("Viene-Vacio");
                            contadorCol++;

                    }

                }

            }
            if (contadorFila > 0) {
                error = ordenar_Ingresar(Encabezado, aux_list);
                if (error == true) {
                    conterror++;
                }
                aux_list.clear();
            }
            contadorFila++;
        }

        // cerramos el libro excel	
        workbook.close();

        if (conterror == 0) {
            CrearFile(buffer.toString());
        } else {
            conterror = 0;
            error = false;
            System.out.println("ERROR");
        }
    }
    public int estado = 0, estadociclo = 0;

    boolean ordenar_Ingresar(ArrayList<String> Encabezado, ArrayList<String> aux_List) {
        ArrayList<String> auxEncabezado = new ArrayList<String>();
        ArrayList<String> auxOrdenado = new ArrayList<String>();
        for (int i = 0; i < Encabezado.size(); i++) {
            if (Encabezado.get(i).equalsIgnoreCase("Tipo")) {
                auxEncabezado.add(Encabezado.get(i));
                auxOrdenado.add(aux_List.get(i));
            }
        }
        for (int i = 0; i < Encabezado.size(); i++) {
            if (!Encabezado.get(i).equalsIgnoreCase("Tipo")) {
                auxEncabezado.add(Encabezado.get(i));
                auxOrdenado.add(aux_List.get(i));
            }
        }
        return añadir(auxEncabezado, auxOrdenado);
    }

    boolean añadir(ArrayList<String> Encabezado, ArrayList<String> aux_List) {

        for (int i = 0; i < Encabezado.size(); i++) {
            if (Encabezado.get(i).equalsIgnoreCase("Tipo")) {

                if (aux_List.get(i).equalsIgnoreCase("Viene-Vacio")) {

                    return true;

                }
                if (aux_List.get(i).equalsIgnoreCase("Iniciar Agrupacion")) {
                    String cad = aux_List.get(i).toString();

                    buffer.append(cad + "{\n");
                    estado++;

                } else if (aux_List.get(i).equalsIgnoreCase("finalizar Agrupacion")) {

                    estado++;
                    buffer.append("Finalizar Agrupacion{}\n");
                    break;
                } else if (aux_List.get(i).equalsIgnoreCase("Iniciar ciclo")) {
                    String cad = aux_List.get(i).toString();

                    buffer.append(cad + "{\n");
                    estadociclo++;

                } else if (aux_List.get(i).equalsIgnoreCase("finalizar ciclo")) {
                    estadociclo++;

                    buffer.append("Finalizar Ciclo{}\n");
                    break;
                } else {
                    String cad = aux_List.get(i).toString();

                    buffer.append(cad + "{\n");
                }

            } else if (Encabezado.get(i).equalsIgnoreCase("idpregunta")) {

                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("idpregunta:" + aux_List.get(i) + ":\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("etiqueta")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("etiqueta~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("parametro")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("parametro~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("calcular")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("calcular~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("aplicable ")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("aplicable~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("sugerencia")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("sugerencia~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("restringir")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("restringir~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("restringirmsn")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("restringirmsn~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("requerido")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("requerido~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("pordefecto")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("pordefecto~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("lectura")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("lectura~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("repeticion")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("repeticion~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("apariencia")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("apariencia~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("codigo_pre")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("codigo_pre~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            } else if (Encabezado.get(i).equalsIgnoreCase("codigo_post")) {
                if (!aux_List.get(i).equals("Viene-Vacio")) {
                    buffer.append("codigo_post~~#~~" + aux_List.get(i) + "~~#~~\n");
                }
            }

        }

        if (estado < 2) {

            buffer.append("} \n");
        } else if (estadociclo < 2) {

            buffer.append("} \n");
        } else {
            estado = 0;
            estadociclo--;
            estadociclo--;
        }
        return false;
    }

    void CrearFile(String entrada) {

        System.out.print("Correcto");
        //Creo una carpeta en /home/usuario/SalidasDot, en donde va estar todo
        File folder = new File(System.getProperty("user.home") + File.separator + "SalidasDot");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        //Rutas para el .dot y la imagen .png
        String ruta_entrada = System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + "entrada.txt";

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
