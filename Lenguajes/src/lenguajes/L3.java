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
public class L3 {
    
    int cont;
    static char [] cad;
    static boolean aceptacion;
    
    public static void main(String[] args) {
        L3 automata = new L3();
        Scanner scan = new Scanner(System.in);
        String cadena;
        System.out.println("L3: Todas las cadenas con no mas de tres a's.\n");
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
        aceptacion = true;
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
        aceptacion = true;
        if(cont < cad.length){
            if(cad[cont] == 'a'){
                cont++;
                B();
            }
            else if(cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                A();
            }
            else
                aceptacion = false;
        }
    }

    private void B() {
        aceptacion = true;
        if(cont < cad.length){
            if(cad[cont] == 'a'){
                cont++;
                C();
            }
            else if(cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                B();
            }
            else
                aceptacion = false;
        }
    }

    private void C() {
        aceptacion = true;
        if(cont < cad.length){
            if(cad[cont] == 'a'){
                cont++;
                D();
            }
            else if(cad[cont] == 'b' || cad[cont] == 'c'){
                cont++;
                C();
            }
            else
                aceptacion = false;
        }
    }

    private void D() {
        aceptacion = false;
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
