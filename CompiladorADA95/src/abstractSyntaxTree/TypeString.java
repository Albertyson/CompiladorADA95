package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class TypeString extends VariableType{

    public TypeString() {
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
