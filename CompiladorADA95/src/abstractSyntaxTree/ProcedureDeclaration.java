
package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Albertyson
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureDeclaration extends Declaration {
    
    private Identifier id1;
    private ParameterDeclarations parameterDeclarations;
    private DeclarationPart declarations;
    private Statements statements;
    private Identifier id2;

    public ProcedureDeclaration() {
    }

    public ProcedureDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, DeclarationPart declarations, Statements statements, Identifier id2) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.declarations = declarations;
        this.statements = statements;
        this.id2 = id2;
    }

    public ProcedureDeclaration(Identifier id1, ParameterDeclarations parameterDeclarations, Statements statements, Identifier id2) {
        this.id1 = id1;
        this.parameterDeclarations = parameterDeclarations;
        this.statements = statements;
        this.id2 = id2;
    }
    

    public Identifier getId1() {
        return id1;
    }

    public void setId1(Identifier id1) {
        this.id1 = id1;
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

    public Identifier getId2() {
        return id2;
    }

    public void setId2(Identifier id2) {
        this.id2 = id2;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}