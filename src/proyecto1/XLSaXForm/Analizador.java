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

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Javier Solares
 */
public class Analizador {

    public Nodo root;
    ArrayList<String> Encabezado = new ArrayList<String>();
    ArrayList<String> aux_list = new ArrayList<String>();
    StringBuffer buffer = new StringBuffer();

    public void Ordenar(FileInputStream file) throws IOException {
        //Nodo father, child;
        // Crear el objeto que tendra el libro de Excel
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        //father = new Nodo(Constants.INICIO,0,0,Constants.INICIO);
        //root=father;


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

        // Recorremos todas las filas para mostrar el contenido de cada celda
        while (rowIterator.hasNext()) {
            //Nodo hijo=new Nodo("Linea",0,0,"Linea");
            //     father.childs.add(hijo);
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
                            if(celda.getBooleanCellValue() == true){
                                aux_list.add("true");
                            
                            }else{
                                aux_list.add("false");
                            }
                            
                            contadorCol++;

                            contadorCol++;
                            break;
                        default:
                            // System.out.println("false");
                            aux_list.add("false");
                            contadorCol++;

                    }

                }

            }
          if(contadorFila>0){
                  añadir(Encabezado,aux_list);
          aux_list.clear();
          }
            contadorFila++;
        }

        // cerramos el libro excel	
        workbook.close();
        for (int i = 0; i < Encabezado.size(); i++) {
            System.out.println(Encabezado.get(i));
        }
        System.out.println(buffer);
    }

    void añadir(ArrayList<String> Encabezado, ArrayList<String> aux_List) {

        for (int i = 0; i < Encabezado.size(); i++) {
            if (Encabezado.get(i).equalsIgnoreCase("Tipo")) {
                buffer.append(aux_List.get(i) + "{");
            } else if (Encabezado.get(i).equalsIgnoreCase("idpregunta")) {
                buffer.append("idpregunta=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("etiqueta")) {
                buffer.append("etiqueta=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("parametro")) {
                buffer.append("parametro=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("calcular")) {
                buffer.append("calcular=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("aplicable")) {
                buffer.append("aplicable=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("sugerencia")) {
                buffer.append("sugerencia=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("restringir")) {
                buffer.append("restringir=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("restringirmsn")) {
                buffer.append("restringirmsn=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("requerido")) {
                buffer.append("requerido=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("pordefecto")) {
                buffer.append("pordefecto=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("lectura")) {
                buffer.append("lectura=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("repeticion")) {
                buffer.append("repeticion=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("apariencia")) {
                buffer.append("apariencia=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("codigo_pre")) {
                buffer.append("codigo_pre=" + aux_List.get(i) + ";");
            } else if (Encabezado.get(i).equalsIgnoreCase("codigo_post")) {
                buffer.append("codigo_post=" + aux_List.get(i) + ";");
            }
            buffer.append("} \n");

        }
    }

}
