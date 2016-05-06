/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import abstractSyntaxTree.Add;
import abstractSyntaxTree.And;
import abstractSyntaxTree.AssignVariableSimple;
import abstractSyntaxTree.AssignVariableWithDeclaration;
import abstractSyntaxTree.CaseNotOthers;
import abstractSyntaxTree.CaseOthers;
import abstractSyntaxTree.DeclarationPart;
import abstractSyntaxTree.Division;
import abstractSyntaxTree.ElsIf;
import abstractSyntaxTree.ElsIfList;
import abstractSyntaxTree.Equal;
import abstractSyntaxTree.Exit;
import abstractSyntaxTree.False;
import abstractSyntaxTree.FloatNumber;
import abstractSyntaxTree.For;
import abstractSyntaxTree.FunctionCall;
import abstractSyntaxTree.FunctionDeclaration;
import abstractSyntaxTree.FunctionParameters;
import abstractSyntaxTree.GetValue;
import abstractSyntaxTree.Greater;
import abstractSyntaxTree.GreaterOrEqual;
import abstractSyntaxTree.Identifier;
import abstractSyntaxTree.IfSimple;
import abstractSyntaxTree.IfWithElsIF;
import abstractSyntaxTree.IfWithElsIfAndElse;
import abstractSyntaxTree.IfWithElse;
import abstractSyntaxTree.IntegerNumber;
import abstractSyntaxTree.Less;
import abstractSyntaxTree.LessOrEqual;
import abstractSyntaxTree.Loop;
import abstractSyntaxTree.Minus;
import abstractSyntaxTree.ModeIn;
import abstractSyntaxTree.ModeInOut;
import abstractSyntaxTree.ModeOut;
import abstractSyntaxTree.Module;
import abstractSyntaxTree.Multiplication;
import abstractSyntaxTree.Negative;
import abstractSyntaxTree.Not;
import abstractSyntaxTree.NotEqual;
import abstractSyntaxTree.Or;
import abstractSyntaxTree.Parameter;
import abstractSyntaxTree.ParameterDeclarations;
import abstractSyntaxTree.Pow;
import abstractSyntaxTree.ProcedureDeclaration;
import abstractSyntaxTree.Program;
import abstractSyntaxTree.PutValue;
import abstractSyntaxTree.Range;
import abstractSyntaxTree.Return;
import abstractSyntaxTree.Statements;
import abstractSyntaxTree.StringLiteral;
import abstractSyntaxTree.True;
import abstractSyntaxTree.TypeBoolean;
import abstractSyntaxTree.TypeError;
import abstractSyntaxTree.TypeFloat;
import abstractSyntaxTree.TypeInteger;
import abstractSyntaxTree.TypeNull;
import abstractSyntaxTree.TypeString;
import abstractSyntaxTree.VariableDeclaration;
import abstractSyntaxTree.VariableIDs;
import abstractSyntaxTree.VariableType;
import abstractSyntaxTree.WhenElement;
import abstractSyntaxTree.WhenList;
import abstractSyntaxTree.WhenOption;
import abstractSyntaxTree.WhenOptions;
import abstractSyntaxTree.While;

/**
 *
 * @author JosuéNoel
 */
public class SemanticAnalysis implements TypeVisitor {

    @Override
    public VariableType path(IntegerNumber h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(FloatNumber h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(True h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(False h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(StringLiteral h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public VariableType path(WhenElement aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(WhenList aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeError aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VariableType path(TypeNull aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
