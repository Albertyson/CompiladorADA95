package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author Albertyson
 */
public class FunctionDeclaration {
    
    private Identifier id;
    private ParameterDeclarations parameterDeclarations;
    private VariableType returnType;
    private DeclarationPart declarations;
    private Statements statements;

    public FunctionDeclaration(Identifier id, ParameterDeclarations parameterDeclarations, VariableType returnType, DeclarationPart declarations, Statements statements) {
        this.id = id;
        this.parameterDeclarations = parameterDeclarations;
        this.returnType = returnType;
        this.declarations = declarations;
        this.statements = statements;
    }
    
    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public ParameterDeclarations getParameterDeclarations() {
        return parameterDeclarations;
    }

    public void setParameterDeclarations(ParameterDeclarations parameterDeclarations) {
        this.parameterDeclarations = parameterDeclarations;
    }

    public VariableType getReturnType() {
        return returnType;
    }

    public void setReturnType(VariableType returnType) {
        this.returnType = returnType;
    }

    public DeclarationPart getDeclarations() {
        return declarations;
    }

    public void setDeclarations(DeclarationPart declarations) {
        this.declarations = declarations;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }
    
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
