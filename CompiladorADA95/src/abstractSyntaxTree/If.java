package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */
@XmlSeeAlso({IfSimple.class,IfWithElse.class,IfWithElsIF.class,IfWithElsIfAndElse.class})
@XmlType
public abstract class If extends Statement {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
