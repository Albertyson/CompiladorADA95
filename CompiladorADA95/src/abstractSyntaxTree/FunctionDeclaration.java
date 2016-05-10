package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
public class FunctionDeclaration extends Declaration {
    
    public Identifier id1;
    public ParameterDeclarations parameterDeclarations;
    public VariableType returnType;
    public DeclarationPart declarations;
    public Statements statements;
    public Identifier id2;


    public FunctionDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, VariableType returnType, DeclarationPart declarations, Statements statements, Identifier id2) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.returnType = returnType;
        this.declarations = declarations;
        this.statements = statements;
        this.id2 = id2;
    }

    public FunctionDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, VariableType returnType, Statements statements, Identifier id2) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.returnType = returnType;
        this.statements = statements;
        this.id2 = id2;
    }

    public FunctionDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, VariableType returnType, DeclarationPart declarations, Identifier id2) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.returnType = returnType;
        this.declarations = declarations;
        this.id2 = id2;
    }

    public FunctionDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, VariableType returnType, Identifier id2) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.returnType = returnType;
        this.id2 = id2;
    }
    
        
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
