/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.Encuesta;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *    <ID_PREGUNTA> {padre=new Nodo("ID PREGUNTA",0,0,"ID PREGUNTA");}  t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~",""); hijo=new Nodo(Constants.IDPREGUNTA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
  
    |<APLICABLE> {padre=new Nodo("APLICABLE",0,0,"APLICABLE");}  t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~",""); hijo=new Nodo(Constants.APLICABLE, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
       |<ETIQUETA> {padre=new Nodo("ETIQUETA",0,0,"ETIQUETA");}  t=<VALOR_C>
     {String aux=t.image.replace("#",""); aux=aux.replace("~",""); hijo=new Nodo(Constants.ETIQUETA, t.beginLine, t.beginColumn, aux.replace("\"","\\\"")); padre.hijos.add(hijo); return padre;}
    |<PARAMETRO> {padre=new Nodo("PARAMETRO",0,0,"PARAMETRO");}  t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~",""); hijo=new Nodo(Constants.PARAMETRO, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
    |<CALCULAR> {padre=new Nodo("CALCULAR",0,0,"CALCULAR");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.CALCULAR, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
    |<SUGERENCIA>{padre=new Nodo("SUGERENCIA",0,0,"SUGERENCIA");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<REQUERIDO>{padre=new Nodo("REQUERIDO",0,0,"REQUERIDO");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<PORDEFECTO>{padre=new Nodo("PORDEFECTO",0,0,"PORDEFECTO");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<REQUERIDOMSN>{padre=new Nodo("REQUERIDOMSN",0,0,"REQUERIDOMSN");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<CODIGO_POST>{padre=new Nodo("CODIGO_POST",0,0,"CODIGO_POST");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<CODIGO_PRE>{padre=new Nodo("CODIGO_PRE",0,0,"CODIGO_PRE");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<RESTRINGIR>{padre=new Nodo("RESTRINGIR",0,0,"RESTRINGIR");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<RESTRINGIRMSN>{padre=new Nodo("RESTRINGIRMSN",0,0,"RESTRINGIRMSN");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<LECTURA>{padre=new Nodo("LECTURA",0,0,"LECTURA");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<APARIENCIA>{padre=new Nodo("APARIENCIA",0,0,"APARIENCIA");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<REPETICION>{padre=new Nodo("REPETICION",0,0,"REPETICION");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}
     |<MULTIMEDIA>{padre=new Nodo("MULTIMEDIA",0,0,"MULTIMEDIA");} t=<VALOR_C>  
     {String aux=t.image.replace("#",""); aux=aux.replace("~","");  hijo=new Nodo(Constants.SUGERENCIA, t.beginLine, t.beginColumn, aux.replace("\"","\\\""));
     padre.hijos.add(hijo); return padre;}

 * @author Javier Solares
 */
public class Nodo {
      public String title, value;
    public int col, row, id=0;
    public List<Nodo> hijos;
    
    // Constructor para Linea con información detallada
    public Nodo(String title, int row, int col, String value){
        this.title = title;
        this.col = col;
        this.row = row;
        this.value = value;
        this.hijos = new ArrayList<>();
        this.id =0;
    }
    
    // Constructor para nodos simples
    public Nodo(String title){
        this.title = title;
        this.value = "";
        this.col = this.row = 0;
        this.hijos = new ArrayList<>();
        this.id = 0;
    }
    
}
