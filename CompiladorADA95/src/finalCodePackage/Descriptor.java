package finalCodePackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albertyson
 */
public class Descriptor {
//    public enum Registros {
//        $v0,$v1,
//        $t0,$t1,$t2,$t3,$st4,$t5,$t6,$st7,$t8,$t9,
//        $a0,$a1,$a2,$a3,
//        $s0,$s1,$s2,$s3,$s4,$s5,$s6,$s7,
//        $sp,$fp,$ra,$zero
//    }
    String registro;
    String valor;

    public Descriptor() {
    }
    
    public Descriptor(String registro, String valor) {
        this.registro = registro;
        this.valor = valor;
    }
    
}
