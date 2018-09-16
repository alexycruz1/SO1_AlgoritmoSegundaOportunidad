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
        int frames = 0, numPaginas = 0, cupoRevisado = 0, punteroExiste = -1, fallos = 0;
        boolean existe = false;
        String paginasIngresadas = "";

        ArrayList paginas = new ArrayList();
        ArrayList bitPaginas = new ArrayList();
        ArrayList paginasAccedidas = new ArrayList();

        System.out.print("Ingrese numero de frames: ");
        frames = sc.nextInt();
        
        System.out.println("");

        System.out.print("Ingrese paginas separadas por coma (ej: 1,2,3,4): ");
        paginasIngresadas = sc.next();

        String[] paginasParseadas = paginasIngresadas.split(",");
        numPaginas = paginasParseadas.length;

        for(int i = 0; i < paginasParseadas.length; i++) {
            paginas.add(Integer.parseInt(paginasParseadas[i]));
        }
        
        paginasAccedidas.add(paginas.get(0));
        bitPaginas.add(1);
        fallos++;

        System.out.println("");

        //Algoritmo de segunda oportunidad
        for(int i = 0; i < numPaginas; i++) {
            cupoRevisado = 0;
            existe = false;
            if(paginasAccedidas.size() == frames){

                for(int j = 0; j < paginasAccedidas.size(); j++) {
                    if(((int)paginasAccedidas.get(j) == ((int)paginas.get(i)))){
                        existe = true;
                        if(((int)bitPaginas.get(j)) == 0) {
                            bitPaginas.set(j, 1);

                            j = paginasAccedidas.size();
                        }
                    }
                }

                if(!existe){
                    for(int j = 0; j < paginasAccedidas.size(); j++) {
                        if(((int)bitPaginas.get(j)) == 0) {
                            paginasAccedidas.set(j, paginas.get(i));
                            fallos++;

                            bitPaginas.set(j, 1);
    
                            j = paginasAccedidas.size(); 
                        } else {
                            cupoRevisado++;
                        }
                    }
                }

                if(cupoRevisado == frames) {
                    for(int j = 0; j < paginasAccedidas.size(); j++) {
                        bitPaginas.set(j, 0);
                    }

                    for(int j = 0; j < paginasAccedidas.size(); j++) {
                        if(((int)bitPaginas.get(j)) == 0) {
                            paginasAccedidas.set(j, paginas.get(i));
                            fallos++;

                            bitPaginas.set(j, 1);
                            
                            j = paginasAccedidas.size(); 
                        } else {
                            cupoRevisado++;
                        }
                    }
                }
            } else {
                for(int j = 0; j < paginasAccedidas.size(); j++) {
                    if(((int)paginasAccedidas.get(j) == ((int)paginas.get(i)))){
                        existe = true;
                        if(((int)bitPaginas.get(j)) == 0) {
                            bitPaginas.set(j, 1);

                            j = paginasAccedidas.size();
                        }
                    } else {
                        if(!existe) {
                            paginasAccedidas.add(paginas.get(i));
                            fallos++;

                            bitPaginas.add(1);

                            j = paginasAccedidas.size();
                        }
                    }
                }
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

        System.out.println("El numero de fallos fue: " + fallos);
        
    }
    
}
