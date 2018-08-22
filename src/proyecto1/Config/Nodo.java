/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.Config;

import proyecto1.Config.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/*
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
