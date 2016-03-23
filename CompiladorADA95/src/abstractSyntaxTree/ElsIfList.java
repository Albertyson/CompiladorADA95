package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author JosuéNoel
 */
public class ElsIfList {
    
    private ArrayList<ElsIf> list;
    
    public ElsIfList() {
        list = new ArrayList();
    }
    
    public void add(ElsIf e) {
        list.add(e);
    }
    
    public int size() {
        return list.size();
    }
    
    public ElsIf getAt(int pos) {
        return list.get(pos);
    }

    public ArrayList<ElsIf> getList() {
        return list;
    }

    public void setList(ArrayList<ElsIf> list) {
        this.list = list;
    }

    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
