/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.segundaoportunidad;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexycruz1
 */
public class AlgoritmoSegundaOportunidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int frames = 0, numPaginas = 0, cupoRevisado = 0;

        ArrayList paginas = new ArrayList();
        ArrayList bitPaginas = new ArrayList();
        ArrayList paginasAccedidas = new ArrayList();

        System.out.print("Ingrese numero de frames: ");
        frames = sc.nextInt();
        
        System.out.println("");
        
        System.out.print("Ingrese numero de paginas: ");
        numPaginas = sc.nextInt();
        
        System.out.println("");
        
        for (int i = 0; i < numPaginas; i++) {
            System.out.print("Ingrese pagina #" + (i + 1) + ": ");
            paginas.add(sc.nextInt());
        }

        System.out.println("");

        for(int i = 0; i < numPaginas; i++) {
            cupoRevisado = 0;
            if(paginasAccedidas.size() == 5){
                for(int j = 0; j < paginasAccedidas.size(); j++) {
                    if(((int)bitPaginas.get(j)) == 0) {
                        paginasAccedidas.set(j, paginas.get(i));
                        bitPaginas.set(j, 1);
                        j = paginasAccedidas.size(); 
                    } else {
                        cupoRevisado++;
                    }
                }

                if(cupoRevisado == 5) {
                    for(int j = 0; j < paginasAccedidas.size(); j++) {
                        bitPaginas.set(j, 0);
                    }

                    for(int j = 0; j < paginasAccedidas.size(); j++) {
                        if(((int)bitPaginas.get(j)) == 0) {
                            paginasAccedidas.set(j, paginas.get(i));
                            bitPaginas.set(j, 1);
                            j = paginasAccedidas.size(); 
                        } else {
                            cupoRevisado++;
                        }
                    }
                }
            } else {
                paginasAccedidas.add(paginas.get(i));
                bitPaginas.add(1);
            }

            for(int j = 0; j < frames; j++){
                if(j < paginasAccedidas.size()){
                    System.out.print(" [ " + paginasAccedidas.get(j) + " ]" + "[ " + bitPaginas.get(j) + " ] ");
                } else {
                    System.out.print(" [   ][   ] ");
                }
            }

            System.out.println();
        }
        
    }
    
}
