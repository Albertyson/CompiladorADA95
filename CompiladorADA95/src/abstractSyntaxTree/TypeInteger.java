package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class TypeInteger extends VariableType {

    public TypeInteger() {
    }

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
