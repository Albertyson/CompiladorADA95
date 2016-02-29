package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java_cup.runtime.*;

public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //String flexFilePath = "./src/mainPackage/lexer.flex";
        //generarLexer(flexFilePath);

        /*Reader r = new BufferedReader(new FileReader("./src/mainPackage/archivo.adb"));
         lexer x = new lexer(r);
         while (x.yylex() == 1) {}*/
        try {
            Parser p = new Parser(new lexer(new FileReader("./src/mainPackage/aritmetico.txt")));
            Object result = p.parse().value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generarLexer(String path) {
        File f = new File(path);
        jflex.Main.generate(f);
    }

}
