package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
@XmlSeeAlso({ModeIn.class,ModeOut.class,ModeInOut.class})
@XmlType
public abstract class Mode {
    
    public abstract void accept(ParentPath PP);
    
    public abstract VariableType accept(TypeVisitor PP);
    
}
