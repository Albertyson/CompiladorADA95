package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
@XmlAccessorType(XmlAccessType.FIELD)
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

    public Identifier getId2() {
        return id2;
    }

    public void setId2(Identifier id2) {
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
