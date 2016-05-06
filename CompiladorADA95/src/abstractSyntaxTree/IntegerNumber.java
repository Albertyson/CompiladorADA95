package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

@XmlAccessorType(XmlAccessType.FIELD)
public class IntegerNumber extends LiteralExpression{
    
    public Integer number;
    
    public IntegerNumber() {}

    public IntegerNumber(Integer number) {
        this.number = number;
    }
    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
