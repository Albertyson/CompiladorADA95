
package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author Albertyson
 */

public class ProcedureDeclaration {
    
    private Identifier id;
    private ParameterDeclarations parameterDeclarations;
    private DeclarationPart declarations;
    private Statements statements;

    public ProcedureDeclaration(Identifier id, ParameterDeclarations parameterDeclarations, DeclarationPart declarations, Statements statements) {
        this.id = id;
        this.parameterDeclarations = parameterDeclarations;
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