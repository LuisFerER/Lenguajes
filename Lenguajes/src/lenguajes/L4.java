/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajes;

import java.util.Scanner;

/**
 *
 * @author luisf
 *
 *Encuentre gramaticas con Σ = {a, b, c} que generen los siguientes lenguajes:
 */

public class L4 {
    
    int cont;
    static char [] cad;
    static boolean aceptacion;
    
    public static void main(String[] args) {
        L4 automata = new L4();
        Scanner scan = new Scanner(System.in);
        String cadena;
        System.out.println("L4: El lenguaje que contiene todas las cadenas que terminan con aa.\n");
        System.out.print("Introduce una cadena: ");
        cadena = scan.nextLine();
        if(cadena.length() != 0){
            cad = cadena.toCharArray();
            automata.inicial();
            if(aceptacion)
                System.out.println("\nCadena ACEPTADA");
            else
                System.out.println("\nCadena NO ACEPTADA");
        }
    }

    private void inicial() {
        cont = 0;
        aceptacion = false;
        S();
    }

    private void S() {
        aceptacion = false;
        if(cont < cad.length){
            if(cad[cont] == 'a'){
                cont++;
                A();
            }
            else if(cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }

    private void A() {
        if(cont < cad.length){
            if(cad[cont] == 'a'){
                cont++;
                B();
            }
            else if(cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }

    private void B() {
        aceptacion = true;
        if(cont < cad.length){
            if(cad[cont] == 'a' || cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }
}
