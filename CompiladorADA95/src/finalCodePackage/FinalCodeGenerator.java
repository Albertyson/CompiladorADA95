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
import java.util.regex.Pattern;
import javax.swing.JTextArea;
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
    private ArrayList<Descriptor> descriptorLista = new ArrayList();
    JTextArea taFinal = new JTextArea();
    
    public FinalCodeGenerator(ArrayList<Cuadruplo> cuadruplos, SemanticTable semanticTable,JTextArea taFinal) {
        this.cuadruplos = cuadruplos;
        this.semanticTable = semanticTable;
        this.taFinal = taFinal;
    }
    public void inicio(){
        codigo+=".data\n";
        //recorrer variables globales
        List<SemanticVariableTableNode> variablesGlobales = semanticTable.getAllVariables("s0");
        for(int i = 0; i < variablesGlobales.size(); i++){
            String varName = variablesGlobales.get(i).getName();
            if(variablesGlobales.get(i).getType() instanceof TypeInteger || variablesGlobales.get(i).getType() instanceof TypeBoolean || variablesGlobales.get(i).getType() instanceof TypeFloat){
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
        codigo+=".text\n.globl main\n";
        
    }
    public void llenarDescriptor(){
        descriptorLista.add(new Descriptor("$t0",""));
        descriptorLista.add(new Descriptor("$t1",""));
        descriptorLista.add(new Descriptor("$t2",""));
        descriptorLista.add(new Descriptor("$t3",""));
        descriptorLista.add(new Descriptor("$t4",""));
        descriptorLista.add(new Descriptor("$t5",""));
        descriptorLista.add(new Descriptor("$t6",""));
        descriptorLista.add(new Descriptor("$t7",""));
        descriptorLista.add(new Descriptor("$t8",""));
        descriptorLista.add(new Descriptor("$t9",""));
        descriptorLista.add(new Descriptor("$s0",""));
        descriptorLista.add(new Descriptor("$s1",""));
        descriptorLista.add(new Descriptor("$s2",""));
        descriptorLista.add(new Descriptor("$s3",""));
        descriptorLista.add(new Descriptor("$a0",""));
        descriptorLista.add(new Descriptor("$a1",""));
        descriptorLista.add(new Descriptor("$a2",""));
        descriptorLista.add(new Descriptor("$a3",""));
        descriptorLista.add(new Descriptor("$v0",""));
        descriptorLista.add(new Descriptor("$v1",""));
        descriptorLista.add(new Descriptor("$sp",""));
        descriptorLista.add(new Descriptor("$fp",""));
        descriptorLista.add(new Descriptor("$ra",""));
        descriptorLista.add(new Descriptor("$zero",""));
    }
    public String buscarRegistro(String reg){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(reg.equals(descriptorLista.get(i).registro)){
                return descriptorLista.get(i).valor;
            }
        }
        return null;
    }
    public void setValor(String registro,String valor){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(registro.equals(descriptorLista.get(i).registro)){
                descriptorLista.get(i).valor = valor;
            }
        }
    }
    public void cuerpo(){       
        llenarDescriptor();
        for (int i = 0; i < cuadruplos.size(); i++) {
            Cuadruplo cuadruploActual = cuadruplos.get(i);
            switch(cuadruploActual.getOperacion()){
                case "=":{
                    //buscar si oper1 es literal o es un id
                    String temp = temporalDisponible();
                    if(temp!=null){
                        if(Pattern.matches("[0-9]+", cuadruploActual.getOper1())){
                            codigo+="\t" + "li " + temp + ", " + cuadruploActual.getOper1() + "\n";
                            setValor(temp,cuadruploActual.getOper1());
                        }else{
                            //es variable
                            if(cuadruploActual.getOper1().equals("$RETVAL")){
                                codigo+="\t" + "move " + temp + ", $v0\n";
                            }else{
                                codigo+="\t" + "lw " + temp + ", " + cuadruploActual.getOper1() + "\n";
                            }                        
                        }
                    }else{
                        //usar pila
                    }   
                    break;
                }
                case "":{//etiqueta
                    codigo+=cuadruploActual.etiqueta + ":\n";
                    break;
                }
            }          
        }
    }
    public void print(){
//        System.out.println("FINAL:");
//        System.out.println(codigo);
        this.taFinal.append(codigo);
        this.taFinal.append("\n");
    }
    
    public String temporalDisponible(){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(descriptorLista.get(i).valor.equals("") && descriptorLista.get(i).registro.startsWith("$t")){
                return descriptorLista.get(i).registro;
            }
        }
        return null;
    }
    
}
