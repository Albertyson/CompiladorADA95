/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author Albertyson
 */
public class DeclarationPart {
    private ArrayList<ProcedureDeclaration> procedureDeclarations;    
    private ArrayList<FunctionDeclaration> functionDeclarations;
    private ArrayList<VariableDeclaration> variableDeclarations;

    public DeclarationPart() {
        procedureDeclarations = new ArrayList();
        functionDeclarations = new ArrayList();
        variableDeclarations = new ArrayList();
    }
    public void addFunction(FunctionDeclaration f){
        functionDeclarations.add(f);
    }
    public void addProcedure(ProcedureDeclaration p){
        procedureDeclarations.add(p);
    }
    public void addVariable(VariableDeclaration v){
        variableDeclarations.add(v);
    }
    public int functionsSize(){
        return functionDeclarations.size();
    }
    public int proceduresSize(){
        return procedureDeclarations.size();
    }
    public int variablesSize(){
        return variableDeclarations.size();
    }
    public FunctionDeclaration getFunctionDeclarationAt(int idx){
        return functionDeclarations.get(idx);
    }
    public ProcedureDeclaration getProcedureDeclarationAt(int idx){
        return procedureDeclarations.get(idx);
    }
    public VariableDeclaration getVariableDeclarationAt(int idx){
        return variableDeclarations.get(idx);
    }
    public void callPath(ParentPath PP) {
        PP.path(this);
    }

    public ArrayList<ProcedureDeclaration> getProcedureDeclarations() {
        return procedureDeclarations;
    }

    public void setProcedureDeclarations(ArrayList<ProcedureDeclaration> procedureDeclarations) {
        this.procedureDeclarations = procedureDeclarations;
    }

    public ArrayList<FunctionDeclaration> getFunctionDeclarations() {
        return functionDeclarations;
    }

    public void setFunctionDeclarations(ArrayList<FunctionDeclaration> functionDeclarations) {
        this.functionDeclarations = functionDeclarations;
    }

    public ArrayList<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public void setVariableDeclarations(ArrayList<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }
    
}
