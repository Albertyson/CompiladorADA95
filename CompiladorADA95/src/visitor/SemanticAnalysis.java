package visitor;

import abstractSyntaxTree.*;
import java.util.ArrayList;
import java.util.Stack;


public class SemanticAnalysis implements TypeVisitor {
    
    private String scope;
    private VariableType currentFunctionReturnType;
    private Stack functionReturnStack = new Stack();
    private Stack insideLoop = new Stack();
    private SemanticTable semanticTable;
    private int currentDirection;
    private boolean hasErrors;
    
      
    public SemanticAnalysis(SemanticTable symbolsTable){
        this.semanticTable = symbolsTable;
        hasErrors = false;
    }
    
    
    public void errorComplain(String message, int line, int col) {
         System.err.println("Error: (linea: " + (line - 1) + ", columna: " + (col - 1) + ") : " + message + ".\n\n");
//        System.err.println(message + ".\n\n");
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
        SemanticTableNode s = semanticTable.findID(h.id, this.scope);
        h.scope = this.scope;
        if(s == null){
            errorComplain("El identificador " + h.id + " no esta definido en este ambito",h.line,h.column);
            return new TypeError();
        }
        if(s instanceof SemanticVariableTableNode){
            return ((SemanticVariableTableNode)s).getType();
        }else{
            return new TypeError();
        }
    }

    
    @Override
    public VariableType path(Add h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat && typeExp2 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger && typeExp2 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("Ambas expresiones deben ser float o ambas deben ser integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Minus h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat && typeExp2 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger && typeExp2 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("Ambas expresiones deben ser float o ambas deben ser integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Division h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat && typeExp2 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger && typeExp2 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("Ambas expresiones deben ser float o ambas deben ser integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Multiplication h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat && typeExp2 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger && typeExp2 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("Ambas expresiones deben ser float o ambas deben ser integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Pow h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat && typeExp2 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger && typeExp2 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("Ambas expresiones deben ser float o ambas deben ser integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Negative h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("La expresion no es tipo float o integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Module h) {
        //verificar los tipos de ambas expresiones
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeFloat && typeExp2 instanceof TypeFloat){
            return new TypeFloat();
        }
        if(typeExp1 instanceof TypeInteger && typeExp2 instanceof TypeInteger){
            return new TypeInteger();
        }
        errorComplain("Ambas expresiones deben ser float o ambas deben ser integer",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Equal h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1.equals(typeExp2)){
            return new TypeBoolean();
        }
        errorComplain("No se pueden comparar los tipos",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(NotEqual h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1.equals(typeExp2)){
            return new TypeBoolean();
        }
        errorComplain("No se pueden comparar los tipos",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Greater h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1.equals(typeExp2)){
            return new TypeBoolean();
        }
        errorComplain("No se pueden comparar los tipos",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Less h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1.equals(typeExp2)){
            return new TypeBoolean();
        }
        errorComplain("No se pueden comparar los tipos",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(GreaterOrEqual h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1.equals(typeExp2)){
            return new TypeBoolean();
        }
        errorComplain("No se pueden comparar los tipos",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(LessOrEqual h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1.equals(typeExp2)){
            return new TypeBoolean();
        }
        errorComplain("No se pueden comparar los tipos",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(And h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeBoolean && typeExp2 instanceof TypeBoolean){
            return new TypeBoolean();
        }
        errorComplain("Se esperaban expresiones de tipo Boolean",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Or h) {
        VariableType typeExp1 = h.exp1.accept(this);
        VariableType typeExp2 = h.exp2.accept(this);
        if(typeExp1 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp2 instanceof TypeError){
            return new TypeError();
        }
        if(typeExp1 instanceof TypeBoolean && typeExp2 instanceof TypeBoolean){
            return new TypeBoolean();
        }
        errorComplain("Se esperaban expresiones de tipo Boolean",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(Not h) {
        VariableType typeExp = h.exp.accept(this);
        if(typeExp instanceof TypeError){
            return new TypeError();
        }
        if(typeExp instanceof TypeBoolean){
            return new TypeBoolean();
        }
        errorComplain("Se esperaba una expresion de tipo Boolean",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(FunctionCall h) {
        //buscarla en la tabla de simbolos
        SemanticTableNode funcion = semanticTable.findID(h.id.id, this.scope);
        if(!(funcion instanceof SemanticFunctionTableNode) || funcion==null){
            errorComplain("La funcion " + h.id.id + " no esta definida en este ambito",h.line,h.column);
            return new TypeError(); 
        }
        ArrayList<SemanticVariableTableNode> args = ((SemanticFunctionTableNode)funcion).getParams();
        FunctionParameters params = h.fp;
        if(params == null){
            //si no se envian parametros y la funcion los debe recibir
            if(args.size()>0){
                errorComplain("La cantidad de parametros que debe recibir la funcion no es la que corresponde", h.line,h.column);
                return new TypeError();
            }
        }else{
            //verificar la cantidad de parametros
            if(args.size()== params.size()){
                for (int i = 0; i < args.size(); i++) {
                    //verificar los tipos de los parametros
                    if(!args.get(i).getType().equals(params.getAt(i).accept(this))){
                        errorComplain("Los tipos de los parametros no son los que corresponden", h.line,h.column);
                        return new TypeError();
                    }
                }
            }else{
                errorComplain("La cantidad de parametros que debe recibir la funcion no es la que corresponde", h.line,h.column);
                return new TypeError();
            }
        }
        //llamar al accept de los parametros de la funcion
        if(h.fp != null){
            h.fp.accept(this);
        }        
        return ((SemanticFunctionTableNode)funcion).getReturnType();
    }

    
    @Override
    public VariableType path(FunctionParameters h) {
        //verificar los parametros
        for (int i = 0; i < h.size(); i++) {
            VariableType paramType = h.getAt(i).accept(this);
            if(paramType instanceof TypeError){
                errorComplain("No se esperaba el tipo del parametro "+i,0,0);
                return new TypeError();
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(VariableIDs h) {
        throw new UnsupportedOperationException("Not supported yet."); // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(TypeInteger h) {
        return new TypeNull();
    }

    
    @Override
    public VariableType path(TypeBoolean h) {
        return new TypeNull();
    }

    
    @Override
    public VariableType path(TypeFloat h) {
        return new TypeNull();
    }

    
    @Override
    public VariableType path(TypeString h) {
        return new TypeNull();
    }

    
    @Override
    public VariableType path(GetValue h) {
        if(!(h.id instanceof Identifier)){
            errorComplain("Se esperaba un identificador",h.line,h.column);
            return new TypeError();
        }
        VariableType vType = h.id.accept(this);
        if(vType instanceof TypeError){
            errorComplain("Tipo Erroneo para el identificador: "+h.id.id,h.line,h.column);
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(PutValue h) {
        VariableType expType = h.exp.accept(this);
        if((expType instanceof TypeError)){
            errorComplain("Se experaba una expresion ",h.line,h.column);
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(While h) {
        VariableType expType = h.exp.accept(this);        
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se esperaba una expresion de tipo boolean",h.line,h.column);
            return new TypeError();
        }
        insideLoop.push(true);
        VariableType stmntsType = h.est.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        insideLoop.pop();
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Statements h) {
        for (int i = 0; i < h.size(); i++) {
            VariableType stmntType = h.getAt(i).accept(this);
            if(stmntType instanceof TypeError){
                return new TypeError();
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Range h) {
        VariableType exp1Type = h.exp1.accept(this);
        if(exp1Type instanceof TypeError){
            errorComplain("Error en el limite inferior del rango",h.line,h.column);
            return new TypeError();
        }
        VariableType exp2Type = h.exp2.accept(this);
        if(exp2Type instanceof TypeError){
            errorComplain("Error en el limite superior del rango",h.line,h.column);
            return new TypeError();
        }
        //validar que son enteros
        if(!(exp1Type instanceof TypeInteger && exp2Type instanceof TypeInteger)){
            errorComplain("Ambos limites del rango deben ser de tipo Integer",h.line,h.column);
            return new TypeError();
        }
        //validar que el limite inferior sea menor que el superior
        int inferior = 0;
        int superior = 0;
        boolean infIdentifier = false;
        boolean supIdentifier = false;
        //busca exp1
        if(h.exp1 instanceof Identifier){
            SemanticTableNode x = semanticTable.findID(((Identifier)h.exp1).id,this.scope);
            if(((SemanticVariableTableNode)x).getType() instanceof TypeInteger){
                infIdentifier = true;
            }
        }else if(h.exp1 instanceof IntegerNumber){
            inferior = ((IntegerNumber)h.exp1).number;
        }else{
            errorComplain("Se esperaba una expresion de tipo Integer para el limite inferior del Range",h.line,h.column);
            return new TypeError();
        }
        //busca exp2
        if(h.exp2 instanceof Identifier){
            SemanticTableNode x = semanticTable.findID(((Identifier)h.exp2).id,this.scope);
            if(((SemanticVariableTableNode)x).getType() instanceof TypeInteger){
                supIdentifier = true;
            }
        }else if(h.exp2 instanceof IntegerNumber){
            superior = ((IntegerNumber)h.exp2).number;
        }else{
            errorComplain("Se esperaba una expresion de tipo Integer para el limite superior del Range",h.line,h.column);
            return new TypeError();
        }
        if(supIdentifier || infIdentifier){
            return new TypeNull();
        }
        if(inferior >= superior){
            errorComplain("El limite inferior debe ser menor al superior",h.line,h.column);
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(For h) {
        //validar el iterador
        VariableType iteratorType = h.id.accept(this);
        if(iteratorType instanceof TypeError){            
            return new TypeError();
        }
        VariableType rangeType = h.range.accept(this);
        if(rangeType instanceof TypeError){
            errorComplain("Error en el rango",h.line,h.column);
            return new TypeError();
        }
        insideLoop.push(true);
        VariableType stmntsType = h.statements.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        insideLoop.pop();
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Exit h) {
        if(insideLoop.empty()){
            errorComplain("Uso inadecuado de Exit",h.line,h.column);
            return new TypeError();
        }
        VariableType expType = h.exp.accept(this);
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se esperaba una expresion de tipo Boolean",h.line,h.column);
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Loop h) {
        insideLoop.push(true);
        VariableType stmntsType = h.s.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        insideLoop.pop();
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Return h) {
        //verificar si estoy dentro de una funcion
        if(functionReturnStack.empty()){
            errorComplain("Solo se puede usar return dentro del cuerpo de una funcion", h.line,h.column);
            return new TypeError();
        }
        VariableType expType = h.exp.accept(this);
        if(!expType.equals(currentFunctionReturnType)){
            errorComplain("El retorno de la funcion debe ser del tipo " + currentFunctionReturnType.getClass().getSimpleName(),h.line,h.column);
        }
        //se asigna null porque el retorno ya fue usado
//        currentFunctionReturnType = null;
        return new TypeNull();
    }

    
    @Override
    public VariableType path(WhenOption h) {
        if(h.exp!=null){
            return h.exp.accept(this);
        }else if(h.range !=null){
            return h.range.accept(this);
        }
        errorComplain("La condicion when no tiene una expresion o rango",h.line,h.column);
        return new TypeError();
    }

    
    @Override
    public VariableType path(WhenOptions h) {
        for (int i = 0; i < h.size(); i++) {
            VariableType woType = h.getAt(i).accept(this);
            if(woType instanceof TypeError){
                return new TypeError();
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(CaseOthers h) {
        //validar el tipo de la expresion
        VariableType expType = h.exp.accept(this);
        if(expType instanceof TypeError){
            errorComplain("Expresion erronea para case",h.line,h.column);
            return new TypeError();
        }
        //validar lista de when
        VariableType wlType = h.whenList.accept(this);
        if(wlType instanceof TypeError){
            return new TypeError();
        }
        //verificar si las expresiones de los when son del mismo tipo del case
        for (int i = 0; i < h.whenList.size(); i++) {
            WhenOptions whenOptions = h.whenList.getAt(i).getWhenOptions();
            for(int j=0;j< whenOptions.size(); j++){
                VariableType whenExpType = whenOptions.getAt(j).exp.accept(this);
                if(!whenExpType.equals(expType)){
                    errorComplain("El tipo de la expresion en el when no es compatible con el tipo del case",h.line,h.column);
                }
            }
        }
        //validar statements de others
        VariableType soType = h.statementsOthers.accept(this);
        if(soType instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(CaseNotOthers h) {
        //validar el tipo de la expresion
        VariableType expType = h.exp.accept(this);
        if(expType instanceof TypeError){
            errorComplain("Expresion erronea para case",h.line,h.column);
            return new TypeError();
        }
        //validar lista de when
        VariableType wlType = h.whenList.accept(this);
        if(wlType instanceof TypeError){
            return new TypeError();
        }
        //verificar si las expresiones de los when son del mismo tipo del case
        for (int i = 0; i < h.whenList.size(); i++) {
            WhenOptions whenOptions = h.whenList.getAt(i).getWhenOptions();
            for(int j=0;j< whenOptions.size(); j++){
                VariableType whenExpType = whenOptions.getAt(j).exp.accept(this);
                if(!whenExpType.equals(expType)){
                    errorComplain("El tipo de la expresion en el when no es compatible con el tipo del case",h.line,h.column);
                }
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(VariableDeclaration h) {
        VariableType type;
        int size=4;
        if (h.type instanceof TypeBoolean){
            type = new TypeBoolean();
            size=((TypeBoolean)type).SIZE;
        } else if (h.type instanceof TypeChar) {
            type = new TypeChar();
            size=((TypeChar)type).SIZE;
        } else if (h.type instanceof TypeFloat) {
            type = new TypeFloat();
            size=((TypeFloat)type).SIZE;
        } else if (h.type instanceof TypeInteger) {
            type = new TypeInteger();
            size=((TypeInteger)type).SIZE;
        } else if (h.type instanceof TypeString) {
            type = new TypeString();
        } else {
            return new TypeError();
        }
        
        for(int i = 0; i < h.variables.size(); i++){
            int dir = semanticTable.getAllLocalVariables(this.scope).size()*size;
            if (!semanticTable.addID(new SemanticVariableTableNode(type, h.variables.getAt(i).id, this.scope, 5, dir))){
                errorComplain("El identificador: " + h.variables.getAt(i).id + " ya esta siendo utilizado.", h.line,h.column);
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Parameter h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(ModeIn h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(ModeInOut h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(ModeOut h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(ParameterDeclarations h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }


    @Override
    public VariableType path(ProcedureDeclaration h) {
        boolean hasErrors = false;
        if (!h.id1.id.equals(h.id2.id)) {
            errorComplain("No se encontro el final de la funcion " + h.id1.id, h.line,h.column);
            hasErrors = true;
        }

        String tmpScope = new String(this.scope);
        String currentScope = new String(this.scope + "." + Scope.genNewScope());
        this.scope = new String(currentScope);
        
        
        SemanticFunctionTableNode f = new SemanticFunctionTableNode(new TypeNull(), h.id1.id, "" + tmpScope);
        f.myScope = new String(currentScope);
        for (int i = 0; i < h.parameterDeclarations.size(); i++) {
            Parameter param = h.parameterDeclarations.getAt(i);
            int varType;
            if (param.mode instanceof ModeIn) {
                varType = 1;
            } else if (param.mode instanceof ModeOut) {
                varType = 2;
            } else if (param.mode instanceof ModeInOut) {
                varType = 3;
            } else {
                varType = 4;
            }
            for (int j = 0; j < param.vars.size(); j++) {
                if (!semanticTable.addID(new SemanticVariableTableNode(param.type, param.vars.getAt(j).id, this.scope, varType, 0))) {
                    errorComplain("El identificador: " + param.vars.getAt(j).id + " ya esta siendo utilizado.", h.line,h.column);
                    hasErrors = true;
                } else {
                    SemanticVariableTableNode variable = new SemanticVariableTableNode(param.type, param.vars.getAt(j).id, this.scope, varType, 0);
                    f.addParam(variable);
                }
            }
        }
        if (!semanticTable.addID(f)) {
            errorComplain("El identificador: " + h.id1.id + " ya esta siendo utilizado.", h.line,h.column);
            return new TypeError();
        }
        if(h.declarations != null){
            h.declarations.accept(this);
        }        
        this.scope = currentScope;
        if(h.statements !=null){
            h.statements.accept(this);
        }
        this.scope = tmpScope;

        if (hasErrors) {
            return new TypeError();
        } else {
            return new TypeNull();
        }
    }


    @Override
    public VariableType path(FunctionDeclaration h) {
        boolean hasErrors = false;
        if (!h.id1.id.equals(h.id2.id)){
            errorComplain("No se encontro el final de la funcion " + h.id1.id, h.line,h.column);
            hasErrors = true;
        }
        
        String tmpScope = new String(this.scope);
        String currentScope = new String(this.scope + "." + Scope.genNewScope());
        this.scope = new String(currentScope);
        
        SemanticFunctionTableNode f = new SemanticFunctionTableNode(h.returnType, h.id1.id, "" + tmpScope);
        f.myScope = new String(currentScope);
        for (int i = 0; i < h.parameterDeclarations.size(); i++){
            Parameter param = h.parameterDeclarations.getAt(i);
            int varType;
            if (param.mode instanceof ModeIn){
                varType = 1;
            } else if(param.mode instanceof ModeOut){
                varType = 2;
            } else if(param.mode instanceof ModeInOut){
                varType = 3;
            } else {
                varType = 4;
            }
            for (int j = 0; j < param.vars.size(); j++){
                if (!semanticTable.addID(new SemanticVariableTableNode(param.type, param.vars.getAt(j).id, this.scope, varType, 0))) {
                    errorComplain("El identificador: " + param.vars.getAt(j).id + " ya esta siendo utilizado.", h.line,h.column);
                    hasErrors = true;
                } else {
                    SemanticVariableTableNode variable = new SemanticVariableTableNode(param.type, param.vars.getAt(j).id, this.scope, varType, 0);
                    f.addParam(variable);
                }
            }
        }        
        
        if (!semanticTable.addID(f)){
            errorComplain("El identificador: " + h.id1.id + " ya esta siendo utilizado.", h.line,h.column);
            return new TypeError();
        }
        currentFunctionReturnType = h.returnType;
        functionReturnStack.push(currentFunctionReturnType);
        if(h.declarations != null){
            h.declarations.accept(this);
        }        
        this.scope = currentScope;
        h.statements.accept(this);
        boolean hasReturn = false;
        for (int i = 0; i < h.statements.size(); i++) {
            if(h.statements.getAt(i) instanceof Return){
                hasReturn = true;
            }
        }
        functionReturnStack.pop();
        if(!hasReturn){
            errorComplain("La funcion no tiene return",h.line,h.column);
            return new TypeError();
        }
        this.scope = tmpScope;
        if (hasErrors){
            return new TypeError();
        } else {
            return new TypeNull();
        }
    }

    
    @Override
    public VariableType path(DeclarationPart h) {
        for(int i = 0; i < h.size(); i++){
            if (h.getAt(i) instanceof VariableDeclaration){
                ((VariableDeclaration) h.getAt(i)).accept(this);
            } else if (h.getAt(i) instanceof FunctionDeclaration){
                ((FunctionDeclaration) h.getAt(i)).accept(this);
            } else if (h.getAt(i) instanceof ProcedureDeclaration){
                ((ProcedureDeclaration) h.getAt(i)).accept(this);
            } else {
                return new TypeError();
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(Program h) {
        
        //      OJO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
        if (!h.id1.equals(h.id2)){
            errorComplain("El identificador de inicio y cierre no coinciden.", h.line,h.column);
            return new TypeError();
        }
        String currentScope = Scope.genNewScope();
        this.scope = new String(currentScope);
        if (!semanticTable.addID(new SemanticFunctionTableNode(new TypeNull(), h.id1.id, this.scope))){
            errorComplain("El identificador: " + h.id1.id + " ya esta siendo utilizado.", h.line,h.column);
            return new TypeError();
        }
        if(h.declarations!=null){
            for (int i = 0; i < h.declarations.size(); i++){
                if(h.declarations.getAt(i)!=null){
                    h.declarations.getAt(i).accept(this);
                }                
            }
            this.scope = currentScope;
        }
        if(h.statements!=null){
            for (int i = 0; i < h.statements.size(); i++){
                h.statements.getAt(i).accept(this);
            }
            this.scope = currentScope;
        }
        
        return new TypeNull();
    }

    
    @Override
    public VariableType path(AssignVariableSimple h) {
        //verificar que el identificador existe en la tabla de simbolos en el scope actual
        if(semanticTable.findID(h.id.id, this.scope) == null){
            errorComplain("El identificador " + h.id.id + " no esta definido en el ambito actual",h.line,h.column);
            return new TypeError();
        }
        //validar que el tipo del id sea el mismo que la expresion
        VariableType idType = h.id.accept(this);
        if(idType instanceof TypeError){
            return new TypeError();
        }
        VariableType expType = h.exp.accept(this);
        if(expType.getClass().getName().equals(idType.getClass().getName())){
            return expType;
        }else{
            errorComplain("El tipo del identificador " + h.id.id + " no es compatible con el tipo de la expresion",h.line,h.column);
            return new TypeError();
        }
    }

    
    @Override
    public VariableType path(AssignVariableWithDeclaration h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(IfSimple h) {
        VariableType expType = h.exp.accept(this);
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se experaba una expresion de tipo Boolean1",h.line,h.column);
            return new TypeError();
        }
        //validar statements
        VariableType stmntsType = h.statements.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(IfWithElse h) {
        VariableType expType = h.exp.accept(this);
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se experaba una expresion de tipo Boolean2",h.line,h.column);
            return new TypeError();
        }
        //validar statements
        VariableType s1Type = h.s1.accept(this);
        VariableType s2Type = h.s2.accept(this);
        if(s1Type instanceof TypeError || s2Type instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(ElsIf h) {
        VariableType expType = h.exp.accept(this);
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se experaba una expresion de tipo Boolean3",h.line,h.column);
            return new TypeError();
        }
        //validar statements
        VariableType stmntsType = h.stms.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(ElsIfList h) {
        for (int i = 0; i < h.size(); i++) {
            VariableType elsifType = h.getAt(i).accept(this);
            if(elsifType instanceof TypeError){
                return new TypeError();
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(IfWithElsIF h) {
        VariableType expType = h.expression.accept(this);
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se experaba una expresion de tipo Boolean4",h.line,h.column);
            return new TypeError();
        }
        //validar statements
        VariableType stmntsType = h.statements.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        VariableType elsifListType = h.elsIfList.accept(this);
        if(elsifListType instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(IfWithElsIfAndElse h) {
        VariableType expType = h.expression.accept(this);
        if(!(expType instanceof TypeBoolean)){
            errorComplain("Se experaba una expresion de tipo Boolean",h.line,h.column);
            return new TypeError();
        }
        //validar statements
        VariableType stmntsType = h.statements.accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        VariableType elsifListType = h.elsIfList.accept(this);
        if(elsifListType instanceof TypeError){
            return new TypeError();
        }
        VariableType elseStatementsType = h.elseStatements.accept(this);
        if(elseStatementsType instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(WhenElement h) {
        VariableType woType = h.getWhenOptions().accept(this);
        if(woType instanceof TypeError){
            return new TypeError();
        }
        VariableType stmntsType = h.getStatements().accept(this);
        if(stmntsType instanceof TypeError){
            return new TypeError();
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(WhenList h) {
        //validar cada when element
        for (int i = 0; i < h.size(); i++) {
            VariableType weType = h.getAt(i).accept(this);
            if(weType instanceof TypeError){
                return new TypeError();
            }
        }
        return new TypeNull();
    }

    
    @Override
    public VariableType path(TypeError h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }

    
    @Override
    public VariableType path(TypeNull h) {
        throw new UnsupportedOperationException("Not supported yet.");  // NUNCA SE MANDA A LLAMAR
    }
    

    @Override
    public VariableType path(TypeChar h) {
        throw new UnsupportedOperationException("Not supported yet."); // NUNCA SE MANDA A LLAMAR
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
            errorComplain("Error en declaracion.", 0,0);
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
            errorComplain("Error en Statement.", 0,0);
            return new TypeError();
        }
    }
    
}
