package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ModeOut extends Mode {

    public ModeOut() {
    }

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
