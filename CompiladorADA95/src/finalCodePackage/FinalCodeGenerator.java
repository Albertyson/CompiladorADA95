/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalCodePackage;

import abstractSyntaxTree.*;
import intermediateCode.Cuadruplo;
import java.util.ArrayList;
import java.util.HashMap;
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
    private ArrayList<Double> listaFloats;
    
    private class RegistroTemporal {

        public String registro;
        public Type tipo;

        public RegistroTemporal(String registro, Type tipo) {
            this.registro = registro;
            this.tipo = tipo;
        }
    }
    private HashMap<String,RegistroTemporal> temporalesUsados = new HashMap();
    
    public FinalCodeGenerator(ArrayList<Cuadruplo> cuadruplos, SemanticTable semanticTable,JTextArea taFinal,ArrayList<Double> listaFloats) {
        this.cuadruplos = cuadruplos;
        this.semanticTable = semanticTable;
        this.taFinal = taFinal;
        this.listaFloats = listaFloats;
    }
    public void inicio(){
        codigo+=".data\n";
        //recorrer variables globales
        List<SemanticVariableTableNode> variablesGlobales = semanticTable.getAllVariables("s0");
        for(int i = 0; i < variablesGlobales.size(); i++){
            String varName = variablesGlobales.get(i).getName();
            if(variablesGlobales.get(i).getType() instanceof TypeInteger || variablesGlobales.get(i).getType() instanceof TypeBoolean ){
                codigo+="_"+varName+":\t .word 0\n";
            }else if(variablesGlobales.get(i).getType() instanceof TypeFloat){
                codigo+="_"+varName+":\t .double 0.0\n";
            }
        }
        //variables especiales para impresiones literales
        codigo+= "enteroLiteral:\t .word 0\n";
        //floats literales
        for (int i = 0; i < listaFloats.size(); i++) {
            codigo+="floatLiteral"+i + ":\t .double " + listaFloats.get(i) + "\n";
        }
        //strings literales
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
                if (putValue.matches("\".*\"")){
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
        descriptorLista.add(new Descriptor("$f0",""));
        descriptorLista.add(new Descriptor("$f1",""));
        descriptorLista.add(new Descriptor("$f2",""));
        descriptorLista.add(new Descriptor("$f3",""));
        descriptorLista.add(new Descriptor("$f4",""));
        descriptorLista.add(new Descriptor("$f5",""));
        descriptorLista.add(new Descriptor("$f6",""));
        descriptorLista.add(new Descriptor("$f7",""));
        descriptorLista.add(new Descriptor("$f8",""));
        descriptorLista.add(new Descriptor("$f9",""));
        descriptorLista.add(new Descriptor("$f10",""));
        descriptorLista.add(new Descriptor("$f11",""));
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
                    String temp = temporalDisponible(false);
                    if(temp!=null){
                        if(Pattern.matches("[0-9]+", cuadruploActual.getOper1())){//entero
                            codigo+="\t" + "li " + temp + ", " + cuadruploActual.getOper1() + "\n";
                            setValor(temp,cuadruploActual.getOper1());
                        }else if(Pattern.matches("[0-9]+\\.[0-9]+", cuadruploActual.getOper1())){//float
                            //liberar el temporal buscado anteriormente $tn
                            liberarTemporal(temp);
                            //buscar un temporal float
                            temp = temporalDisponible(true);
                            codigo+="\t" + "l.d " + temp + ", " + cuadruploActual.getOper1() + "\n";
                            setValor(temp,cuadruploActual.getOper1());
                        }else{//id
                            //es variable
                            if(cuadruploActual.getOper1().equals("$RETVAL")){
                                codigo+="\t" + "move " + temp + ", $v0\n";
                                setValor(temp,"$v0");
                            }else{
                                codigo+="\t" + "lw " + temp + ", " + cuadruploActual.getOper1() + "\n";
                                setValor(temp,cuadruploActual.getOper1());
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
                case "put":{
                    if(cuadruploActual.getOper1().matches("_msg[0-9]+")){//cadena put ("hola")
                        codigo+="\tli $v0,4\n";
                        codigo+="\tla $a0,"+cuadruploActual.getOper1()+"\n";
                    }else if(cuadruploActual.getOper1().matches("[0-9]+\\.[0-9]+")){//float put (9.12)                        
                        //montar en un registro $f el float literal                      
                        codigo+="\tli $v0,2\n";
                        codigo+="\tl.d $f12, floatLiteral"+listaFloats.indexOf(Double.parseDouble(cuadruploActual.getOper1()))+"\n";

                    }else if(cuadruploActual.getOper1().matches("[0-9]+")){//int put (89)
                        String temp = temporalDisponible(false);
                        codigo+="\tli " + temp + ", " + cuadruploActual.getOper1()+"\n";
                        codigo+="\tsw " + temp + ", enteroLiteral\n";
                        codigo+="\tli $v0,1\n";
                        codigo+="\tlw $a0, enteroLiteral\n";
                    }else{ //id put (_x)
                        //buscar en tabla de símbolos
                        if(cuadruploActual.getOper1().startsWith("$")){//temporal
                            //to do
                            
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp)!=null){
                                SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre,scp);
                                //hacer la operación de acuerdo al tipo de la variable
                                if(variable.getType() instanceof TypeInteger){
                                    codigo+="\tlw $a0, " + "_" + nombre + "\n";
                                    codigo+="\tli $v0,1\n";
                                }
                            }else{
                                System.out.println("no encontro " + cuadruploActual.getOper1().substring(1));
                            }
                        }
                        
                    }
                    codigo+="\tsyscall\n";
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
    
    public String temporalDisponible(Boolean esFloat){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(!esFloat ){
                if(descriptorLista.get(i).valor.equals("") && descriptorLista.get(i).registro.startsWith("$t")){
                    descriptorLista.get(i).valor="";
                    return descriptorLista.get(i).registro;
                }
            }else{
                if(descriptorLista.get(i).valor.equals("") && descriptorLista.get(i).registro.matches("\\$f[0-9]+")){
                    descriptorLista.get(i).valor="";
                    return descriptorLista.get(i).registro;
                }
            }            
        }
        return null;
    }
    public void liberarTemporal(String nombreTemp){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(descriptorLista.get(i).registro.equals(nombreTemp)){
                descriptorLista.get(i).valor="";
            }
        }
    }
    
}
