/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediateCode;

import abstractSyntaxTree.*;

/**
 *
 * @author Albertyson
 */
public interface IntermediateGenerable {

    public String visit(Add h);
    
    public String visit(And h);

    public String visit(AssignVariableSimple h);

    public String visit(AssignVariableWithDeclaration h);

    public String visit(IntegerNumber h);

    public String visit(CaseNotOthers h);

    public String visit(CaseOthers h);

    public String visit(Division h);

    public String visit(Equal h);

    public String visit(Exit h);

    public String visit(False h);

    public String visit(FloatNumber h);

    public String visit(For h);

    public String visit(FunctionCall h);

    public String visit(GetValue h);

    public String visit(Greater h);

    public String visit(GreaterOrEqual h);

    public String visit(Identifier h);

    public String visit(IfSimple h);

    public String visit(IfWithElsIF h);

    public String visit(IfWithElsIfAndElse h);

    public String visit(IfWithElse h);

    public String visit(Less h);

    public String visit(LessOrEqual h);

    public String visit(Loop h);

    public String visit(Minus h);

    public String visit(Module h);

    public String visit(Multiplication h);

    public String visit(Negative h);

    public String visit(Not h);

    public String visit(NotEqual h);

    public String visit(Or h);

    public String visit(Pow h);

    public String visit(PutValue h);

    public String visit(Return h);

    public String visit(StringLiteral h);

    public String visit(True h);

    public String visit(While h);
    
    public String visit(FunctionDeclaration h);

    public String visit(ProcedureDeclaration h);

    public String visit(VariableDeclaration h);

    public String visit(ModeIn h);

    public String visit(ModeInOut h);

    public String visit(ModeOut h);

    public String visit(TypeChar h);

    public String visit(TypeBoolean h);

    public String visit(TypeError h);

    public String visit(TypeFloat h);

    public String visit(TypeInteger h);

    public String visit(TypeNull h);

    public String visit(TypeString h);

    public String visit(DeclarationPart h);

    public String visit(ElsIf h);

    public String visit(ElsIfList h);

    public String visit(FunctionParameters h);

    public String visit(Parameter h);

    public String visit(ParameterDeclarations h);

    public String visit(Program h);

    public String visit(Range h);

    public String visit(Statements h);

    public String visit(WhenOptions h);

    public String visit(WhenOption h);

    public String visit(WhenList h);

    public String visit(WhenElement h);

    public String visit(VariableIDs h);

}
