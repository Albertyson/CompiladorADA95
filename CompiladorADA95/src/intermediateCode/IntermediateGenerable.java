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

    public Cuadruplo visit(Add aThis);
    
    public Cuadruplo visit(And aThis);

    public Cuadruplo visit(AssignVariableSimple aThis);

    public Cuadruplo visit(AssignVariableWithDeclaration aThis);

    public Cuadruplo visit(IntegerNumber aThis);

    public Cuadruplo visit(CaseNotOthers aThis);

    public Cuadruplo visit(CaseOthers aThis);

    public Cuadruplo visit(Division aThis);

    public Cuadruplo visit(Equal aThis);

    public Cuadruplo visit(Exit aThis);

    public Cuadruplo visit(False aThis);

    public Cuadruplo visit(FloatNumber aThis);

    public Cuadruplo visit(For aThis);

    public Cuadruplo visit(FunctionCall aThis);

    public Cuadruplo visit(GetValue aThis);

    public Cuadruplo visit(Greater aThis);

    public Cuadruplo visit(GreaterOrEqual aThis);

    public Cuadruplo visit(Identifier aThis);

    public Cuadruplo visit(IfSimple aThis);

    public Cuadruplo visit(IfWithElsIF aThis);

    public Cuadruplo visit(IfWithElsIfAndElse aThis);

    public Cuadruplo visit(IfWithElse aThis);

    public Cuadruplo visit(Less aThis);

    public Cuadruplo visit(LessOrEqual aThis);

    public Cuadruplo visit(Loop aThis);

    public Cuadruplo visit(Minus aThis);

    public Cuadruplo visit(Module aThis);

    public Cuadruplo visit(Multiplication aThis);

    public Cuadruplo visit(Negative aThis);

    public Cuadruplo visit(Not aThis);

    public Cuadruplo visit(NotEqual aThis);

    public Cuadruplo visit(Or aThis);

    public Cuadruplo visit(Pow aThis);

    public Cuadruplo visit(PutValue aThis);

    public Cuadruplo visit(Return aThis);

    public Cuadruplo visit(StringLiteral aThis);

    public Cuadruplo visit(True aThis);

    public Cuadruplo visit(While aThis);

}
