package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
@XmlRootElement(name="Program")
@XmlAccessorType(XmlAccessType.FIELD)
public class Program {
    public Identifier id1;
    public DeclarationPart declarations;
    public Statements statements;
    public Identifier id2;

    
    public Program(Identifier id1, DeclarationPart declarations, Statements statements, Identifier id2) {
        this.id1 = id1;
        this.declarations = declarations;
        this.statements = statements;
        this.id2 = id2;
    }
    
    public Program(Identifier id1, Identifier id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
    
    public Program(Identifier id1, DeclarationPart declarations, Identifier id2) {
        this.id1 = id1;
        this.declarations = declarations;
        this.id2 = id2;
    }

    public Program(Identifier id1, Statements statements, Identifier id2) {
        this.id1 = id1;
        this.statements = statements;
        this.id2 = id2;
    }
    
    public Identifier getId1() {
        return id1;
    }
    
    public void setId1(Identifier id1) {
        this.id1 = id1;
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
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
