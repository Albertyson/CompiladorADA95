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
public class FunctionCall extends Expression {
    
    public Identifier id;
    public FunctionParameters fp;
    
    public FunctionCall() {}

    public FunctionCall(Identifier id, FunctionParameters fp) {
        this.id = id;
        this.fp = fp;
    }
    
    public FunctionCall(Identifier id) {
        this.id = id;
    }
    
    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public FunctionParameters getFp() {
        return fp;
    }

    public void setFp(FunctionParameters fp) {
        this.fp = fp;
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
