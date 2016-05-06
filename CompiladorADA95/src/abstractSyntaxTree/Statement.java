package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({AssignVariable.class,Expression.class,GetValue.class,PutValue.class,If.class,While.class,For.class,Loop.class,Exit.class,Case.class,Return.class})
@XmlType
public abstract class Statement {
    
    public abstract void accept(ParentPath PP);
    
    public abstract VariableType accept(TypeVisitor PP);
    
}
