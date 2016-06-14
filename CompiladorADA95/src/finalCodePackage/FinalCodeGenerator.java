/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalCodePackage;

import abstractSyntaxTree.*;
import intermediateCode.Cuadruplo;
import java.util.ArrayList;
import java.util.List;
import visitor.SemanticTable;
import visitor.SemanticVariableTableNode;

/**
 *
 * @author Albertyson
 */
public class FinalCodeGenerator {
    private ArrayList<Cuadruplo> cuadruplos;
    private SemanticTable semanticTable;
    private String codigo = "";
    private Mensaje msg = new Mensaje();
    public FinalCodeGenerator(ArrayList<Cuadruplo> cuadruplos, SemanticTable semanticTable) {
        this.cuadruplos = cuadruplos;
        this.semanticTable = semanticTable;
    }
    public void inicio(){
        codigo+=".data\n";
        //recorrer variables globales
        List<SemanticVariableTableNode> variablesGlobales = semanticTable.getAllVariables("s0");
        for(int i = 0; i < variablesGlobales.size(); i++){
            String varName = variablesGlobales.get(i).getName();
            if(variablesGlobales.get(i).getType() instanceof TypeInteger){
                codigo+="_"+varName+":\t .word 0\n";
            }            
        }
        ArrayList<String> mensajes = new ArrayList();
        int idx=0;
        for(int i=0;i<cuadruplos.size();i++){
            if(cuadruplos.get(i).getOperacion().equals("put")){
                String putValue = cuadruplos.get(i).getOper1();
                boolean found = false;
                for(int j=0; j < mensajes.size(); j++){
                    if(putValue.contains("\"") && mensajes.get(j).equals(putValue)){//es mensaje
                        found = true;
                        idx = j;
                        j = mensajes.size();                        
                    }
                }
                if(!found && putValue.contains("\"")){
                    mensajes.add(putValue);
                    idx = mensajes.size()-1;
                }
                if (putValue.contains("\"")){
                    cuadruplos.get(i).setOper1("_msg"+idx);
                }
            }
        }
        for (int i = 0; i < mensajes.size(); i++) {
            codigo+="_msg"+i+":\t .asciiz " + mensajes.get(i)+"\n";
        }
        
    }
    public void print(){
        System.out.println("FINAL:");
        System.out.println(codigo);
    }
    
}
