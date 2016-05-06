package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class For extends Statement {
    
    public Identifier id;
    public Range range;
    public Statements statements;

    public For() {}

    public For(Identifier id, Range range, Statements statements) {
        this.id = id;
        this.range = range;
        this.statements = statements;
    }

    public For(Identifier id, Range range) {
        this.id = id;
        this.range = range;
    }
    
    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
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
