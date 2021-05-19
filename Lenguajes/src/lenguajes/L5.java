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
 */
public class L5 {
    
    int cont;
    static char [] cad;
    static boolean aceptacion;
    
    public static void main(String[] args) {
        L5 automata = new L5();
        Scanner scan = new Scanner(System.in);
        String cadena;
        System.out.println("L5: El lenguaje que contiene la subpalabra bcac.\n");
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
        if(cont < cad.length){
            if(cad[cont] == 'b'){
                cont++;
                A();
            }
            else if(cad[cont] == 'a' || cad[cont] == 'c'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }

    private void A() {
        if(cont < cad.length){
            if(cad[cont] == 'c'){
                cont++;
                B();
            }
            else if(cad[cont] == 'b'){
                cont++;
                A();
            }
            else if(cad[cont] == 'a'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }

    private void B() {
        if(cont < cad.length){
            if(cad[cont] == 'a'){
                cont++;
                C();
            }
            else if(cad[cont] == 'b'){
                cont++;
                A();
            }
            else if(cad[cont] == 'c'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }

    private void C() {
        if(cont < cad.length){
            if(cad[cont] == 'c'){
                cont++;
                D();
            }
            else if(cad[cont] == 'b'){
                cont++;
                A();
            }
            else if(cad[cont] == 'a'){
                cont++;
                S();
            }
            else
                aceptacion = false;
        }
    }

    private void D() {
        aceptacion = true;
        if(cont < cad.length){
            if(cad[cont] == 'a' || cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                D();
            }
            else
                aceptacion = false;
        }
    }
}
