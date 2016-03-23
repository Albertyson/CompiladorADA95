package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author JosuéNoel
 */


public class WhenOptions {
    
    private ArrayList<WhenOption> options;
    
    public WhenOptions() {
        options = new ArrayList();
    }
    
    public void add(WhenOption e) {
        options.add(e);
    }
    
    public int size() {
        return options.size();
    }
    
    public WhenOption getAt(int pos) {
        return options.get(pos);
    }

    public ArrayList<WhenOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<WhenOption> options) {
        this.options = options;
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
