/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.XLSaXForm;

import proyecto1.XLSaXForm.Nodo;


import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author Joaquin
 */
public class Compilador 
{     
    public void recorrido(Nodo nodoactual)
    {
        switch (nodoactual.value) {
            case "cuerpo":
                this.recorrido((nodoactual.childs.get(0)));
                break;
                
            case "sentencias":
                for(Nodo hijo: nodoactual.childs)
                {
                    this.recorrido(hijo);
                }
                break;
                
            case "operar":
                Object valor_operar = this.evaluarExpresion(nodoactual.childs.get(0));
                
                break;                
                
            case "imprimir":
                Object valor_imprimir = "Imprimir => "+this.evaluarExpresion(nodoactual.childs.get(0));
                
                break;
                
            case "desplegar":
                Object valor_desplegar = "desplegar => "+this.evaluarExpresion(nodoactual.childs.get(0));
                JOptionPane.showMessageDialog(null,valor_desplegar.toString(),"Desplegar",1);
                break;                                
                
            default:
                //throw new AssertionError();
        }
    }
    
    public Object evaluarExpresion(Nodo nodoactual)
    {
        if(nodoactual.childs.size()==2)
        {
            Object izq = this.evaluarExpresion(nodoactual.childs.get(0));
            Object der = this.evaluarExpresion(nodoactual.childs.get(1));
            
            switch (nodoactual.value) 
            {
                case "+":
                    return Integer.valueOf(izq.toString()) + Integer.valueOf(der.toString());
                case "-":
                    return Integer.valueOf(izq.toString()) - Integer.valueOf(der.toString());
                case "*":
                    return Integer.valueOf(izq.toString()) * Integer.valueOf(der.toString());
                default:
                    return 1;
            }
            
        }
        else//solo los que tienen 1 hijos
        {           
            switch (nodoactual.value) 
            {
                case "--":                    
                    Object valor = this.evaluarExpresion(nodoactual.childs.get(0));
                    Integer val_decremento = Integer.valueOf(valor.toString()) - 1;
                    return val_decremento;
                
                case "++":                    
                    Object valor2 = this.evaluarExpresion(nodoactual.childs.get(0));
                    Integer val_aumento = Integer.valueOf(valor2.toString()) + 1;
                    return val_aumento;
                    
                case "int":   
                    Object valor3 = nodoactual.childs.get(0).value;
                    Integer val_int =Integer.valueOf(valor3.toString());
                    return val_int;
                    
                case "bool":
                    if(nodoactual.childs.get(0).value.equals("true"))
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }                    
                default:
                   return 1;
            }
        }
    }
            
    
    
    
}
