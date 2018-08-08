/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.XLSaXForm;
import  java.io.File;	
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
 ArrayList<String> Encabezado=new ArrayList<String>();
   public void Ordenar(FileInputStream file) throws IOException{
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
	int contadorFila=0;
        int contadorColumna=0;
 
    /**
     *
     */
    
        
	Row row;
	
	// Recorremos todas las filas para mostrar el contenido de cada celda
	
	while (rowIterator.hasNext()){
	//Nodo hijo=new Nodo("Linea",0,0,"Linea");
   //     father.childs.add(hijo);
	    row = rowIterator.next();
	
 
	
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	
	    Iterator<Cell> cellIterator = row.cellIterator();
	
    Cell celda;

 
	
    while (cellIterator.hasNext()){
	//Nodo nieto;
		celda = cellIterator.next();
	
 if(contadorFila==0){
  if(celda.getStringCellValue().equalsIgnoreCase("tipo")){
  Encabezado.add("Tipo");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("idpregunta")){
  Encabezado.add("IDPregunta");
  }  
  else if(celda.getStringCellValue().equalsIgnoreCase("etiqueta")){
  Encabezado.add("Etiqueta");
  }
    else if(celda.getStringCellValue().equalsIgnoreCase("parametro")){
  Encabezado.add("Parametro");
  }
    else if(celda.getStringCellValue().equalsIgnoreCase("calcular")){
  Encabezado.add("Calcular");
  }
    else if(celda.getStringCellValue().equalsIgnoreCase("aplicable")){
  Encabezado.add("Aplicable");
  }
    else if(celda.getStringCellValue().equalsIgnoreCase("sugerencia")){
  Encabezado.add("Sugerencia");
  }
    else if(celda.getStringCellValue().equalsIgnoreCase("restringir")){
  Encabezado.add("Restringir");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("restringirmsn")){
  Encabezado.add("RestringirMsn");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("requeridomsn")){
  Encabezado.add("RequeridoMsn");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("pordefecto")){
  Encabezado.add("PorDefecto");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("lectura")){
  Encabezado.add("Lectura");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("repeticion")){
  Encabezado.add("Repeticion");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("apariencia")){
  Encabezado.add("Apariencia");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("codigo_pre")){
  Encabezado.add("Codigo_Pre");
  }
  else if(celda.getStringCellValue().equalsIgnoreCase("codigo_post")){
  Encabezado.add("Codigo_Post");
  }
  
 }
	
		// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
	
	switch(celda.getCellType()) {
	
	case Cell.CELL_TYPE_NUMERIC:
	
		
		       System.out.println(celda.getStringCellValue());
                  
		    
	
		    break;
	
		case Cell.CELL_TYPE_STRING:
	
		 //    System.out.println(celda.getStringCellValue());
	
		    break;
	
		case Cell.CELL_TYPE_BOOLEAN:
	
		  //   System.out.println(celda.getBooleanCellValue());
//	 nieto =new Nodo(celda.getStringCellValue());
		    break;
                default:
                  System.out.println("false");
	
		}
                
	    }
	contadorFila++;
	}
	
	// cerramos el libro excel	
	workbook.close();
	
    }

   String Tipo_Token(){
   String salida="";
   
   
       return salida;
   }
   
   
   
   
   
     
}
