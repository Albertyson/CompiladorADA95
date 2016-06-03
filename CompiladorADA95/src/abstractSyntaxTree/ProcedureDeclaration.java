
package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class ProcedureDeclaration extends Declaration {
    
    public Identifier id1;
    public ParameterDeclarations parameterDeclarations;
    public DeclarationPart declarations;
    public Statements statements;
    public Identifier id2;
    public int line, column;


    public ProcedureDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, DeclarationPart declarations, Statements statements, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.declarations = declarations;
        this.statements = statements;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }

    public ProcedureDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, Statements statements, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.statements = statements;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }

    public ProcedureDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, DeclarationPart declarations, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.declarations = declarations;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }

    public ProcedureDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }
    
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    @Override
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }

    
}