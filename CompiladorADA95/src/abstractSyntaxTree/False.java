package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class False extends LiteralExpression {

    public False() {
    }

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
