package visitor;

import abstractSyntaxTree.TypeBoolean;
import abstractSyntaxTree.TypeChar;
import abstractSyntaxTree.TypeFloat;
import abstractSyntaxTree.TypeInteger;
import abstractSyntaxTree.TypeString;
import abstractSyntaxTree.VariableType;
import java.util.ArrayList;
import java.util.List;


public class SemanticTable {
    
    public static int SIZE_OF_INTEGER = 4; //BYTES
    public static int SIZE_OF_NUMBER = 8; //BYTES
    public static int SIZE_OF_BOOLEAN = 1; //BYTES
    public static int SIZE_OF_CHAR = 1; //BYTES
    public static int SIZE_OF_STRING = 4; //BYTES

    public static int sizeOf(VariableType type) {
        if (type instanceof TypeInteger) {
            return SIZE_OF_INTEGER;
        } else if (type instanceof TypeFloat) {
            return SIZE_OF_NUMBER;
        } else if (type instanceof TypeBoolean) {
            return SIZE_OF_BOOLEAN;
        } else if (type instanceof TypeChar) {
            return SIZE_OF_CHAR;
        } else if (type instanceof TypeString) {
            return SIZE_OF_STRING;
        } else {
            return -1;
        }
    }

    private List<SemanticTableNode> symbols;

    public SemanticTable() {
        this.symbols = new ArrayList();
    }

    
    public SemanticTableNode findID(String id, String currentScope) {
        for (int i = 0; i < symbols.size(); i++) {
            SemanticTableNode currentSymbolInfo = symbols.get(i);
            if (currentSymbolInfo.getName().equals(id) && currentScope.startsWith(currentSymbolInfo.getScope())) {
                return currentSymbolInfo;
            }
        }
        return null;
    }
    

    public boolean addID(SemanticTableNode value) {
        if (findID(value.getName(), value.getScope()) != null) {
            return false;
        }
        this.symbols.add(value);
        return true;
    }

    
    public List<SemanticVariableTableNode> getAllVariables(String scope) {
        List<SemanticVariableTableNode> ret = new ArrayList();
        for (int i = 0; i < symbols.size(); i++) {
            SemanticTableNode currentSymbolInfo = symbols.get(i);
            if (currentSymbolInfo instanceof SemanticVariableTableNode) {
                if (scope.startsWith(((SemanticVariableTableNode) currentSymbolInfo).getScope())) {
                    ret.add((SemanticVariableTableNode) currentSymbolInfo);
                }
            }
        }
        return ret;
    }
    
    
}
