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
    
    public FinalCodeGenerator(ArrayList<Cuadruplo> cuadruplos, SemanticTable semanticTable, JTextArea taFinal) {
        this.cuadruplos = cuadruplos;
        this.semanticTable = semanticTable;
        this.taFinal = taFinal;
    }
    
    public void inicio(){
        codigo += ".data\n";
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
        
        //strings literales
        ArrayList<String> mensajes = new ArrayList();
        int idx=0;
        for(int i=0;i<cuadruplos.size();i++){
            if(cuadruplos.get(i).getOperacion().equals("put")){
                String putValue = cuadruplos.get(i).getOper1();
                boolean found = false;
                for(int j=0; j < mensajes.size(); j++){
                    if(putValue.contains("\"") && mensajes.get(j).equals(putValue)){ //es mensaje
                        found = true;
                        idx = j;
                        j = mensajes.size();                        
                    }
                }
                if(!found && putValue.contains("\"")){
                    mensajes.add(putValue);
                    idx = mensajes.size() - 1;
                }
                if (putValue.matches("\".*\"")){
                    cuadruplos.get(i).setOper1("_msg" + idx);
                }
            }
        }
        for (int i = 0; i < mensajes.size(); i++) {
            codigo += "_msg" + i + ":\t .asciiz " + mensajes.get(i) + "\n";
        }
        codigo += ".text\n.globl main\n";
    }
    
    public void llenarDescriptor(){
        descriptorLista.add(new Descriptor("$t0","",""));
        descriptorLista.add(new Descriptor("$t1","",""));
        descriptorLista.add(new Descriptor("$t2","",""));
        descriptorLista.add(new Descriptor("$t3","",""));
        descriptorLista.add(new Descriptor("$t4","",""));
        descriptorLista.add(new Descriptor("$t5","",""));
        descriptorLista.add(new Descriptor("$t6","",""));
        descriptorLista.add(new Descriptor("$t7","",""));
        descriptorLista.add(new Descriptor("$s0","",""));
        descriptorLista.add(new Descriptor("$s1","",""));
        descriptorLista.add(new Descriptor("$s2","",""));
        descriptorLista.add(new Descriptor("$s3","",""));
        descriptorLista.add(new Descriptor("$a0","",""));
        descriptorLista.add(new Descriptor("$a1","",""));
        descriptorLista.add(new Descriptor("$a2","",""));
        descriptorLista.add(new Descriptor("$a3","",""));
        descriptorLista.add(new Descriptor("$v0","",""));
        descriptorLista.add(new Descriptor("$v1","",""));
        descriptorLista.add(new Descriptor("$sp","",""));
        descriptorLista.add(new Descriptor("$fp","",""));
        descriptorLista.add(new Descriptor("$ra","",""));
        descriptorLista.add(new Descriptor("$zero","",""));
    }
    
    public String buscarRegistroPorNombreIntermedio(String nombreIntermedio){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(nombreIntermedio.equals(descriptorLista.get(i).nombreIntermedio)){
                return descriptorLista.get(i).registro;
            }
        }
        return null;
    }
    
    public String buscarRegistroPorValor(String valor){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(valor.equals(descriptorLista.get(i).valor)){
                return descriptorLista.get(i).registro;
            }
        }
        return null;
    }
    
    public void setValor(String registro, String valor, String nombreIntermedio){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(registro.equals(descriptorLista.get(i).registro)){
                descriptorLista.get(i).valor = valor;
                descriptorLista.get(i).nombreIntermedio = nombreIntermedio;
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
                        if(Pattern.matches("[0-9]+", cuadruploActual.getOper1())){ //entero
                            String temp = temporalDisponible();
                            codigo += "\t" + "li " + temp + ", " + cuadruploActual.getOper1() + "\n";
                            setValor(temp, cuadruploActual.getOper1(), cuadruploActual.getOper2());
                        } else { //id
                            //es variable o retval
                            if(cuadruploActual.getOper1().equals("$RETVAL")){
                                String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){ //id
                                    codigo += "\tsw $v0, " + "_" + nombre + "\n";
                                } else { //registro
                                    //buscar registro en el arreglo de descriptor
                                    //se supone que no va a entrar aca
                                    System.out.println("ENTRÓ------ y se descontroló XD");
                                }
                            } else {
                                if(cuadruploActual.getOper1().startsWith("$")){ //temporal
                                    //to do
                                    String src = "";
                                    String dest = "";
                                    if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                        src = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                                    } else {
                                        src = temporalDisponible();
                                        setValor(src, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                                    }
                                    if(cuadruploActual.getOper2().startsWith("$")){ //destino es temporal
                                        if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2())!=null){
                                            dest = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                                        } else {
                                            dest = temporalDisponible();
                                            setValor(dest,cuadruploActual.getOper2(), cuadruploActual.getOper2());
                                        }
                                        //temporal a temporal es move
                                        codigo += "\tmove " + dest + ", " + src + "\n";
                                    } else { //destino es un id
                                        String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                                        String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                                        if(semanticTable.findID(nombre,scp) != null){
                                            //String temp = temporalDisponible();
                                            //SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                            dest = "_" + nombre;
                                            codigo += "\tsw " + src + ", " + dest + "\n";
                                            //liberar temporal
                                            liberarTemporal(src);
                                        }                                        
                                    }
                                    //liberar el temporal
                                } else { //id
                                    String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                                    String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                                    if(semanticTable.findID(nombre,scp) != null){
                                        String temp = temporalDisponible();
                                        //SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                        codigo += "\tlw " + temp + ", _" + nombre + "\n";
                                        setValor(temp, nombre, "");
                                        if(cuadruploActual.getOper2().startsWith("$")){ //destino temporal
                                            //buscar temporal u obtener temporal disponible
                                            String dest = "";
                                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                                dest = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                                            } else {
                                                dest = temporalDisponible();
                                                setValor(dest, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                                            }
                                            codigo += "\tlw " + dest + ", _" + nombre + "\n";
                                            System.out.println("-De " + nombre + " hacia " + dest);
                                        } else { //destino es id
                                            String nombreDestino = cuadruploActual.getOper2().substring(1).split(":")[0];
                                            String scpDestino = cuadruploActual.getOper2().substring(1).split(":")[1];
                                            if(semanticTable.findID(nombreDestino,scpDestino) != null){
                                                codigo += "\tsw " + temp + ", _" + nombreDestino + "\n";
                                                liberarTemporal(temp);
                                            }
                                            System.out.println("De " + temp + " hacia " + nombreDestino);
                                        }
                                    } else {
                                        System.out.println("no encontro " + cuadruploActual.getOper1().substring(1));
                                    }
                                }
                            }                        
                        }
                    break;
                }
                case "+":{
                    //oper3 = oper1 + oper2
                    //add oper3,oper1,oper2
                    String destino = "", oper1 = "", oper2 = "";
                    //pasar oper3 a registro
                    if(cuadruploActual.getOper3().startsWith("$") && !cuadruploActual.getOper3().equals("$RETVAL")){ //temporal
                        if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3()) != null){
                            destino = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3());
                        } else {
                            destino = temporalDisponible();
                            setValor(destino, cuadruploActual.getOper3(), cuadruploActual.getOper3());
                        }
                    } else { //id o retval
                        System.out.println("NUNCA ENTRA AQUI");
                        if(cuadruploActual.getOper3().equals("$RETVAL")){ //retval                            
                        } else { //id
                            //buscar id                            
                        }
                    }
                    
 
                    //pasar oper1 a registro
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//entero
                        oper1 = temporalDisponible();
                        codigo += "\tli " + oper1 + ", " + cuadruploActual.getOper1() + "\n";
                        setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                oper1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                oper1 = temporalDisponible();
                                setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper1().equals("$RETVAL")){ //retval
                                oper1 = temporalDisponible();
                                codigo += "\tmove " + oper1 + ",$v0\n";
                                setValor(oper1, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                    if(buscarRegistroPorValor(nombre)!=null){
                                        oper1 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    } else {
                                        oper1 = temporalDisponible();
                                        setValor(oper1, nombre, "");
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    
                    //pasar oper2 a registro
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//entero
                        oper2 = temporalDisponible();
                        codigo += "\tli " + oper2 + ", " + cuadruploActual.getOper2() + "\n";
                        setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                oper2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else {
                                oper2 = temporalDisponible();
                                setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper2().equals("$RETVAL")){ //retval
                                oper2 = temporalDisponible();
                                codigo += "\tmove " + oper2 + ",$v0\n";
                                setValor(oper2, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre,scp);
                                    if(buscarRegistroPorValor(nombre) != null){
                                        oper2 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    } else {
                                        oper2 = temporalDisponible();
                                        setValor(oper2, nombre, "");
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    liberarTemporal(oper1);
                    liberarTemporal(oper2);
                    codigo += "\tadd " + destino + ", " + oper1 + ", " + oper2 + "\n";
                    break;
                }
                case "-":{
                    //oper3 = oper1 + oper2
                    //add oper3,oper1,oper2
                    String destino = "", oper1 = "", oper2 = "";
                    //pasar oper3 a registro
                    if(cuadruploActual.getOper3().startsWith("$") && !cuadruploActual.getOper3().equals("$RETVAL")){ //temporal
                        if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3()) != null){
                            destino = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3());
                        } else {
                            destino = temporalDisponible();
                            setValor(destino, cuadruploActual.getOper3(), cuadruploActual.getOper3());
                        }
                    } else { //id o retval
                        System.out.println("NUNCA ENTRA AQUI");
                        if(cuadruploActual.getOper3().equals("$RETVAL")){ //retval                            
                        } else { //id
                            //buscar id                            
                        }
                    }
                    
 
                    //pasar oper1 a registro
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//entero
                        oper1 = temporalDisponible();
                        codigo += "\tli " + oper1 + ", " + cuadruploActual.getOper1() + "\n";
                        setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                oper1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                oper1 = temporalDisponible();
                                setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper1().equals("$RETVAL")){ //retval
                                oper1 = temporalDisponible();
                                codigo += "\tmove " + oper1 + ",$v0\n";
                                setValor(oper1, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                    if(buscarRegistroPorValor(nombre)!=null){
                                        oper1 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    } else {
                                        oper1 = temporalDisponible();
                                        setValor(oper1, nombre, "");
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    
                    //pasar oper2 a registro
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//entero
                        oper2 = temporalDisponible();
                        codigo += "\tli " + oper2 + ", " + cuadruploActual.getOper2() + "\n";
                        setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                oper2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else {
                                oper2 = temporalDisponible();
                                setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper2().equals("$RETVAL")){ //retval
                                oper2 = temporalDisponible();
                                codigo += "\tmove " + oper2 + ",$v0\n";
                                setValor(oper2, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre,scp);
                                    if(buscarRegistroPorValor(nombre) != null){
                                        oper2 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    } else {
                                        oper2 = temporalDisponible();
                                        setValor(oper2, nombre, "");
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    liberarTemporal(oper1);
                    liberarTemporal(oper2);
                    codigo += "\tsub " + destino + ", " + oper1 + ", " + oper2 + "\n";
                    break;
                }
                case "*":{
                    //oper3 = oper1 + oper2
                    //add oper3,oper1,oper2
                    String destino = "", oper1 = "", oper2 = "";
                    //pasar oper3 a registro
                    if(cuadruploActual.getOper3().startsWith("$") && !cuadruploActual.getOper3().equals("$RETVAL")){ //temporal
                        if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3()) != null){
                            destino = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3());
                        } else {
                            destino = temporalDisponible();
                            setValor(destino, cuadruploActual.getOper3(), cuadruploActual.getOper3());
                        }
                    } else { //id o retval
                        System.out.println("NUNCA ENTRA AQUI");
                        if(cuadruploActual.getOper3().equals("$RETVAL")){ //retval                            
                        } else { //id
                            //buscar id                            
                        }
                    }
                    
 
                    //pasar oper1 a registro
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//entero
                        oper1 = temporalDisponible();
                        codigo += "\tli " + oper1 + ", " + cuadruploActual.getOper1() + "\n";
                        setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                oper1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                oper1 = temporalDisponible();
                                setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper1().equals("$RETVAL")){ //retval
                                oper1 = temporalDisponible();
                                codigo += "\tmove " + oper1 + ",$v0\n";
                                setValor(oper1, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                    if(buscarRegistroPorValor(nombre)!=null){
                                        oper1 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    } else {
                                        oper1 = temporalDisponible();
                                        setValor(oper1, nombre, "");
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    
                    //pasar oper2 a registro
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//entero
                        oper2 = temporalDisponible();
                        codigo += "\tli " + oper2 + ", " + cuadruploActual.getOper2() + "\n";
                        setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                oper2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else {
                                oper2 = temporalDisponible();
                                setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper2().equals("$RETVAL")){ //retval
                                oper2 = temporalDisponible();
                                codigo += "\tmove " + oper2 + ",$v0\n";
                                setValor(oper2, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre,scp);
                                    if(buscarRegistroPorValor(nombre) != null){
                                        oper2 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    } else {
                                        oper2 = temporalDisponible();
                                        setValor(oper2, nombre, "");
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    liberarTemporal(oper1);
                    liberarTemporal(oper2);
                    codigo += "\tmul " + destino + ", " + oper1 + ", " + oper2 + "\n";
                    break;
                }
                case "/":{
                    //oper3 = oper1 + oper2
                    //add oper3,oper1,oper2
                    String destino = "", oper1 = "", oper2 = "";
                    //pasar oper3 a registro
                    if(cuadruploActual.getOper3().startsWith("$") && !cuadruploActual.getOper3().equals("$RETVAL")){ //temporal
                        if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3()) != null){
                            destino = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper3());
                        } else {
                            destino = temporalDisponible();
                            setValor(destino, cuadruploActual.getOper3(), cuadruploActual.getOper3());
                        }
                    } else { //id o retval
                        System.out.println("NUNCA ENTRA AQUI");
                        if(cuadruploActual.getOper3().equals("$RETVAL")){ //retval                            
                        } else { //id
                            //buscar id                            
                        }
                    }
                    
 
                    //pasar oper1 a registro
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//entero
                        oper1 = temporalDisponible();
                        codigo += "\tli " + oper1 + ", " + cuadruploActual.getOper1() + "\n";
                        setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                oper1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                oper1 = temporalDisponible();
                                setValor(oper1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper1().equals("$RETVAL")){ //retval
                                oper1 = temporalDisponible();
                                codigo += "\tmove " + oper1 + ",$v0\n";
                                setValor(oper1, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                    if(buscarRegistroPorValor(nombre)!=null){
                                        oper1 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    } else {
                                        oper1 = temporalDisponible();
                                        setValor(oper1, nombre, "");
                                        codigo += "\tlw " + oper1 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    
                    //pasar oper2 a registro
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//entero
                        oper2 = temporalDisponible();
                        codigo += "\tli " + oper2 + ", " + cuadruploActual.getOper2() + "\n";
                        setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());                        
                    } else { //id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                oper2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else {
                                oper2 = temporalDisponible();
                                setValor(oper2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                            
                        } else { //id o $RETVAL
                            if(cuadruploActual.getOper2().equals("$RETVAL")){ //retval
                                oper2 = temporalDisponible();
                                codigo += "\tmove " + oper2 + ",$v0\n";
                                setValor(oper2, "$v0", "$v0");
                            } else { //id
                                String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                                String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                                if(semanticTable.findID(nombre,scp) != null){
                                    SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre,scp);
                                    if(buscarRegistroPorValor(nombre) != null){
                                        oper2 = buscarRegistroPorValor(nombre);
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    } else {
                                        oper2 = temporalDisponible();
                                        setValor(oper2, nombre, "");
                                        codigo += "\tlw " + oper2 + ", _" + nombre + "\n";
                                    }
                                }
                            }
                        }                        
                    }
                    liberarTemporal(oper1);
                    liberarTemporal(oper2);
                    codigo += "\tdiv " + destino + ", " + oper1 + ", " + oper2 + "\n";
                    break;
                }
                case "":{ //etiqueta
                    codigo += cuadruploActual.etiqueta + ":\n";
                    break;
                }
                case "put":{
                    if(cuadruploActual.getOper1().matches("_msg[0-9]+")){ //cadena put ("hola")
                        codigo += "\tli $v0,4\n";
                        codigo += "\tla $a0," + cuadruploActual.getOper1() + "\n";
                    } else if(cuadruploActual.getOper1().matches("[0-9]+")){ //int put (89)
                        String temp = temporalDisponible();
                        codigo += "\tli " + temp + ", " + cuadruploActual.getOper1() + "\n";
                        codigo += "\tli $v0,1\n";
                        codigo += "\tmove $a0, " + temp + "\n";
                    } else { //id put (_x)
                        //buscar en tabla de símbolos
                        if(cuadruploActual.getOper1().startsWith("$")){ //temporal
                            //to do
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1())!=null){
                                String temp = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                                codigo+="\tli $v0,1\n";
                                codigo+="\tmove $a0, "+temp+"\n";
                            }
                        } else { //id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre, scp) != null){
                                SemanticVariableTableNode variable = (SemanticVariableTableNode) semanticTable.findID(nombre, scp);
                                //hacer la operación de acuerdo al tipo de la variable
                                if(variable.getType() instanceof TypeInteger){
                                    codigo += "\tlw $a0, " + "_" + nombre + "\n";
                                    codigo += "\tli $v0,1\n";
                                }
                            } else {
                                System.out.println("no encontro " + cuadruploActual.getOper1().substring(1));
                            }
                        }
                        
                    }
                    codigo += "\tsyscall\n";
                    break;
                }
                case "get":{
                    String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                    String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                    if(semanticTable.findID(nombre, scp) != null){
                        codigo+="\tli $v0, 5\n";
                        codigo+="\tsyscall\n";
                        codigo+="\tsw $v0, _" + nombre + "\n";
                    }
                    break;
                }
                case "if>":{
                    String reg1="";
                    String reg2="";
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper1()+"\n";
                        reg1=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                reg1 = temporalDisponible();
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                } else {
                                    reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper2()+"\n";
                        reg2=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                reg2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else { //nuevo temporal
                                reg2 = temporalDisponible();
                                setValor(reg2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg2 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                } else {
                                    reg2 = temporalDisponible();
                                    setValor(reg2, nombre, "");
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    //ya están los 2 registro
                    codigo+="\tbgt "+reg1+", "+reg2+", "+cuadruploActual.etiqueta+"\n";
                    liberarTemporal(reg1);
                    liberarTemporal(reg2);
                    break;
                }
                case "if>=":{
                    String reg1="";
                    String reg2="";
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper1()+"\n";
                        reg1=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                reg1 = temporalDisponible();
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                } else {
                                    reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper2()+"\n";
                        reg2=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                reg2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else { //nuevo temporal
                                reg2 = temporalDisponible();
                                setValor(reg2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg2 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                } else {
                                    reg2 = temporalDisponible();
                                    setValor(reg2, nombre, "");
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    //ya están los 2 registro
                    codigo+="\tbge "+reg1+", "+reg2+", "+cuadruploActual.etiqueta+"\n";
                    liberarTemporal(reg1);
                    liberarTemporal(reg2);
                    break;
                }
                case "if<":{
                    String reg1="";
                    String reg2="";
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper1()+"\n";
                        reg1=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                reg1 = temporalDisponible();
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                } else {
                                    reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper2()+"\n";
                        reg2=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                reg2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else { //nuevo temporal
                                reg2 = temporalDisponible();
                                setValor(reg2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg2 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                } else {
                                    reg2 = temporalDisponible();
                                    setValor(reg2, nombre, "");
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    //ya están los 2 registro
                    codigo+="\tblt "+reg1+", "+reg2+", "+cuadruploActual.etiqueta+"\n";
                    liberarTemporal(reg1);
                    liberarTemporal(reg2);
                    break;
                }
                case "if<=":{
                    String reg1="";
                    String reg2="";
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper1()+"\n";
                        reg1=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                reg1 = temporalDisponible();
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                } else {
                                    reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper2()+"\n";
                        reg2=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                reg2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else { //nuevo temporal
                                reg2 = temporalDisponible();
                                setValor(reg2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg2 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                } else {
                                    reg2 = temporalDisponible();
                                    setValor(reg2, nombre, "");
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    //ya están los 2 registro
                    codigo+="\tble "+reg1+", "+reg2+", "+cuadruploActual.etiqueta+"\n";
                    liberarTemporal(reg1);
                    liberarTemporal(reg2);
                    break;
                }
                case "if=":{
                    String reg1="";
                    String reg2="";
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper1()+"\n";
                        reg1=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                reg1 = temporalDisponible();
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                } else {
                                    reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper2()+"\n";
                        reg2=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                reg2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else { //nuevo temporal
                                reg2 = temporalDisponible();
                                setValor(reg2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg2 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                } else {
                                    reg2 = temporalDisponible();
                                    setValor(reg2, nombre, "");
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    //ya están los 2 registro
                    codigo+="\tbeq "+reg1+", "+reg2+", "+cuadruploActual.etiqueta+"\n";
                    liberarTemporal(reg1);
                    liberarTemporal(reg2);
                    break;
                }
                case "if!=":{
                    String reg1="";
                    String reg2="";
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper1()+"\n";
                        reg1=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                            } else { //nuevo temporal
                                reg1 = temporalDisponible();
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                } else {
                                    reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo += "\tlw " + reg1 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    
                    if(cuadruploActual.getOper2().matches("[0-9]+")){//integer
                        String temp = temporalDisponible();
                        codigo+="\tli "+temp+", "+cuadruploActual.getOper2()+"\n";
                        reg2=temp;
                    }else{//id o temporal
                        if(cuadruploActual.getOper2().startsWith("$") && !cuadruploActual.getOper2().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2()) != null){
                                reg2 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper2());
                            } else { //nuevo temporal
                                reg2 = temporalDisponible();
                                setValor(reg2, cuadruploActual.getOper2(), cuadruploActual.getOper2());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper2().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper2().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    reg2 = buscarRegistroPorValor(nombre);
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                } else {
                                    reg2 = temporalDisponible();
                                    setValor(reg2, nombre, "");
                                    codigo += "\tlw " + reg2 + ", _" + nombre + "\n";
                                }
                            }
                        }
                    }
                    //ya están los 2 registro
                    codigo+="\tbne "+reg1+", "+reg2+", "+cuadruploActual.etiqueta+"\n";
                    liberarTemporal(reg1);
                    liberarTemporal(reg2);
                    break;
                }
                case "goto":{
                    codigo+="\tb "+cuadruploActual.etiqueta+"\n";
                    break;
                }
                case "param":{
                    String param = parametroDisponible();
                    if(cuadruploActual.getOper1().matches("[0-9]+")){//integer                        
                        codigo+="\tli "+param+", "+cuadruploActual.getOper1()+"\n";
                        setValor(param,cuadruploActual.getOper1(),"");
                    }else{//id o temporal
                        if(cuadruploActual.getOper1().startsWith("$") && !cuadruploActual.getOper1().equals("$RETVAL")){ //temporal
                            if(buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1()) != null){
                                String reg1 = buscarRegistroPorNombreIntermedio(cuadruploActual.getOper1());
                                codigo+="move " + param + ", " + reg1+"\n";
                            } else { //nuevo temporal
                                String reg1 = temporalDisponible();
                                codigo+="move " + param + ", " + reg1+"\n";
                                setValor(reg1, cuadruploActual.getOper1(), cuadruploActual.getOper1());
                            }
                        }else{//id
                            String nombre = cuadruploActual.getOper1().substring(1).split(":")[0];
                            String scp = cuadruploActual.getOper1().substring(1).split(":")[1];
                            if(semanticTable.findID(nombre,scp) != null){
                                if(buscarRegistroPorValor(nombre)!=null){
                                    String reg1 = buscarRegistroPorValor(nombre);
                                    codigo += "\tmove " + param + ", "+ reg1 +"\n";
                                } else {
                                    String reg1 = temporalDisponible();
                                    setValor(reg1, nombre, "");
                                    codigo+="\tlw "+reg1+ ", _"+nombre+"\n";
                                    codigo += "\tmove " + param + ", " + reg1 + "\n";
                                }
                            }
                        }
                    }
                    break;
                }

            }          
        }
        codigo+="li $v0,10\nsyscall";
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
                descriptorLista.get(i).valor = "ocupado";
                return descriptorLista.get(i).registro;
            }            
        }
        return "NULL";
    }
    public String parametroDisponible(){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(descriptorLista.get(i).valor.equals("") && descriptorLista.get(i).registro.startsWith("$a")){
                descriptorLista.get(i).valor = "ocupado";
                return descriptorLista.get(i).registro;
            }            
        }
        return "-1";
    }
    
    public void liberarTemporal(String nombreTemp){
        for (int i = 0; i < descriptorLista.size(); i++) {
            if(descriptorLista.get(i).registro.equals(nombreTemp)){
                descriptorLista.get(i).valor = "";
                descriptorLista.get(i).nombreIntermedio = "";
            }
        }
    }
    
}
