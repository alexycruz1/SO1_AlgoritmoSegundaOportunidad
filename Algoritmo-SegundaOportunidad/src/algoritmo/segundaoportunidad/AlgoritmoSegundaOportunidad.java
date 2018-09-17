package algoritmo.segundaoportunidad;

import java.util.ArrayList;
import java.util.Scanner;


public class AlgoritmoSegundaOportunidad {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int frames = 0, numPaginas = 0, cupoRevisado = 0, punteroExiste = -1, fallos = 0;
        boolean existe = false;
        String paginasIngresadas = "", accion = "";

        ArrayList paginas = new ArrayList();
        ArrayList bitPaginas = new ArrayList();
        ArrayList paginasAccedidas = new ArrayList();

        System.out.print("Ingrese numero de frames: ");
        frames = sc.nextInt();
        
        System.out.println("");

        System.out.print("Ingrese cantidad de paginas: ");
        numPaginas = sc.nextInt();
        
        System.out.println("");
        
        for (int i = 0; i < numPaginas; i++) {
            paginas.add((int)Math.floor(Math.random() * 20) + 1);
        }
//        System.out.print("Ingrese paginas separadas por coma (ej: 1,2,3,4): ");
//        paginasIngresadas = sc.next();

//        String[] paginasParseadas = paginasIngresadas.split(",");
//        numPaginas = paginasParseadas.length;
//
//        for(int i = 0; i < paginasParseadas.length; i++) {
//            paginas.add(Integer.parseInt(paginasParseadas[i]));
//        }
        
        paginasAccedidas.add(paginas.get(0));
        bitPaginas.add(1);
        fallos++;

        accion = "Se ingreso la pagina " + paginasAccedidas.get(0) + " con bit inicialzado en 1";
        accion += ", fallos = " + fallos;

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
                            accion = "La pagina " + paginasAccedidas.get(j) + " ya existe en la tabla de paginas, su bit cambio de 0 a 1";

                            j = paginasAccedidas.size();
                        }
                    }
                }

                if(!existe){
                    for(int j = 0; j < paginasAccedidas.size(); j++) {
                        if(((int)bitPaginas.get(j)) == 0) {
                            accion = "Se reemplazo la pagina " + paginasAccedidas.get(j) + " con bit 0 por la pagina entrante " + paginas.get(i) + " inicializada con bit 1";
                            paginasAccedidas.set(j, paginas.get(i));
                            fallos++;

                            accion += ", fallos = " + fallos;

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
                            accion = "Todas las paginas son irremplazables, se cambiaron todos los bits de 1 a 0 y se reemplazo la pagina " + paginasAccedidas.get(j) + " por la pagina entrante " + paginas.get(i);
                            paginasAccedidas.set(j, paginas.get(i));
                            fallos++;

                            accion += ", fallos = " + fallos;

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
                            accion = "La pagina " + paginasAccedidas.get(j) + " ya existe en la tabla de paginas, su bit cambio de 0 a 1";
                            bitPaginas.set(j, 1);

                            j = paginasAccedidas.size();
                        }
                    } else {
                        if(!existe) {
                            paginasAccedidas.add(paginas.get(i));
                            fallos++;

                            accion = "Se ingreso la pagina " + paginas.get(i) + " con bit inicializado en 1";
                            accion += ", fallos = " + fallos;

                            bitPaginas.add(1);

                            j = paginasAccedidas.size();
                        }
                    }
                }
            }

            if(accion != ""){
                for(int j = 0; j < frames; j++){
                    if(j < paginasAccedidas.size()){
                        System.out.print(" [ " + paginasAccedidas.get(j) + " ]" + "[ " + bitPaginas.get(j) + " ] ");
                    } else {
                        System.out.print(" [   ][   ] ");
                    }
                }
    
                System.out.println(" Accion realizada: " + accion);
                accion = "";

                System.out.println();
            } else {
                for(int j = 0; j < frames; j++){
                    if(j < paginasAccedidas.size()){
                        System.out.print(" [ " + paginasAccedidas.get(j) + " ]" + "[ " + bitPaginas.get(j) + " ] ");
                    } else {
                        System.out.print(" [   ][   ] ");
                    }
                }
    
                System.out.println(" Accion realizada: La pagina entrante " + paginas.get(i) + " ya existe en la tabla y su bit esta inicializado en 1");
                accion = "";

                System.out.println();
            }
        }

        System.out.println("El numero de fallos fue: " + fallos);
        
    }
    
}
