/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import abstractSyntaxTree.*;


/**
 *
 * @author JosuéNoel
 */
public class SemanticAnalysis implements TypeVisitor {
    
    private String scope;
    private VariableType currentFunctionReturnType;
    private SemanticTable semanticTable;
    private int currentDirection;
    private boolean hasErrors;
    
    
    public SemanticAnalysis(SemanticTable symbolsTable){
        this.semanticTable = symbolsTable;
        hasErrors = false;
    }
    
    public void errorComplain(String message, int line, int col) {
        System.err.println(message + "\nError at line: " + (line + 1) + ", col: " + (col + 1) + ".\n\n");
        this.hasErrors = true;
    }
    
    public boolean hasErrors() {
        return this.hasErrors;
    }
    
    

    @Override
    public VariableType path(IntegerNumber h) {
        return new TypeInteger();
    }

    @Override
    public VariableType path(FloatNumber h) {
        return new TypeFloat();
    }

    @Override
    public VariableType path(True h) {
        return new TypeBoolean();
    }

    @Override
    public VariableType path(False h) {
        return new TypeBoolean();
    }

    @Override
    public VariableType path(StringLiteral h) {
        return new TypeString();
    }

    @Override
    public VariableType path(Identifier h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Add h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Minus h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Division h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Multiplication h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Pow h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Negative h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Module h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Equal h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(NotEqual h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Greater h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Less h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(GreaterOrEqual h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(LessOrEqual h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(And h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Or h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Not h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(FunctionCall h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(FunctionParameters h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(VariableIDs h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeInteger h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeBoolean h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeFloat h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeString h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(GetValue h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(PutValue h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(While h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Statements h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Range h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(For h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Exit h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Loop h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Return h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(WhenOption h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(WhenOptions h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(CaseOthers h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(CaseNotOthers h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(VariableDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Parameter h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ModeIn h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ModeInOut h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ModeOut h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ParameterDeclarations h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ProcedureDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(FunctionDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(DeclarationPart h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Program h) {
        if (!h.id1.equals(h.id2)){
            errorComplain("El identificador de inicio y cierre no coinciden.", 0, 0);
            return new TypeError();
        }
        String currentScope = Scope.genNewScope();
        this.scope = new String(currentScope);
        if (!semanticTable.addID(new SemanticFunctionTableNode(new TypeNull(), h.id1.id, this.scope))){
            errorComplain("El identificador: " + h.id1.id + " ya está siendo utilizado.", 0, 0);
            return new TypeError();
        }
        
        for (int i = 0; i < h.declarations.size(); i++){
            h.declarations.getAt(i).accept(this);
        }
        this.scope = currentScope;
        
        for (int i = 0; i < h.statements.size(); i++){
            h.statements.getAt(i).accept(this);
        }
        this.scope = currentScope;
        
        return new TypeNull();
    }

    @Override
    public VariableType path(AssignVariableSimple h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(AssignVariableWithDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(IfSimple h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(IfWithElse h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ElsIf h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(ElsIfList h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(IfWithElsIF h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(IfWithElsIfAndElse h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(WhenElement h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(WhenList h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeError h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeNull h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeChar h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(Declaration h) {
        if (h instanceof  FunctionDeclaration){
            return ((FunctionDeclaration) h).accept(this);
        } else if (h instanceof  VariableDeclaration){
            return ((VariableDeclaration) h).accept(this);
        } else if (h instanceof  ProcedureDeclaration){
            return ((ProcedureDeclaration) h).accept(this);
        } else {
            errorComplain("Error en declaracion.", 0, 0);
            return new TypeError();
        }
    }

    @Override
    public VariableType path(Statement h) {
        if (h instanceof  AssignVariable){
            return ((AssignVariable) h).accept(this);
        } else if (h instanceof  Expression){
            return ((Expression) h).accept(this);
        } else if (h instanceof  GetValue){
            return ((GetValue) h).accept(this);
        } else if (h instanceof  PutValue){
            return ((PutValue) h).accept(this);
        } else if (h instanceof  If){
            return ((If) h).accept(this);
        } else if (h instanceof  While){
            return ((While) h).accept(this);
        } else if (h instanceof  For){
            return ((For) h).accept(this);
        } else if (h instanceof  Exit){
            return ((Exit) h).accept(this);
        } else if (h instanceof  Loop){
            return ((Loop) h).accept(this);
        } else if (h instanceof  Case){
            return ((Case) h).accept(this);
        } else if (h instanceof  Return){
            return ((Return) h).accept(this);
        } else {
            errorComplain("Error en Statement.", 0, 0);
            return new TypeError();
        }
    }
    
}
