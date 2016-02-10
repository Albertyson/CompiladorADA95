/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java_cup.runtime.*;

/**
 *
 * @author Alberto
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //String flexFilePath = "./src/mainPackage/lexer.flex";
        //generarLexer(flexFilePath);
        Reader r = new BufferedReader(new FileReader("./src/mainPackage/archivo.adb"));
        lexer x = new lexer(r);
        while (true) {
            int a=x.yylex();
            if (a==0) {
                return;
            }
            //System.out.println(a);
        }
    }
     public static void generarLexer(String path){
        File f = new File(path);
        jflex.Main.generate(f);
    }
}
