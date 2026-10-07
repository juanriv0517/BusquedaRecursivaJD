/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Juan Manuel
 */
public class BusquedaRecursiva {

    private int[] vector;
    private int longitud;

    public int[] retornarVector() {
        Random rd = new Random();

        for (int i = 0; i < vector.length; i++) {
            vector[i] = rd.nextInt(20);
        }
        return vector;
    }

    public BusquedaRecursiva(int longitud) {
        this.vector = new int[longitud];
        this.longitud = longitud;
    }
            
    public void imprimirVector(int[] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("["+ i +"] ->"+vector[i]);
        }
    }
    
    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    //Busqueda Secuencial
    public static boolean secuencial(int[] vector, int indice, int valor){
        
        if (indice == vector.length){
            return false;
        }
        
        if(vector[indice] == valor){
            return true;
        }
        
        return secuencial(vector, indice + 1, valor);
    }
    
    //Busqueda por indice
    public int BuscarIndice(int[] vector, int indice, int valor){
        
        if(indice >= vector.length){
            return -1;
        }
        
        if(vector[indice] == valor){
            return indice;
        }
        
        return BuscarIndice(vector, indice + 1, valor);
    }
    
    //Busqueda Binaria
    public int buscarBinaria(int[] vector, int inicio, int fin, int valor){
        
        if (inicio > fin) {return -1;}
        
        int medio = (inicio + fin) / 2;
        if (vector[medio] == valor) {
            return medio;
        }
        if (valor < vector[medio]){
            return buscarBinaria(vector, inicio, medio-1, valor);
        }
        return buscarBinaria(vector, medio+1, fin, valor);
    }
    
    //Busqueda Binaria con Limites
    public int binariaLimites(int[] vector, int inicio, int fin, int valor) {
        if (inicio > fin) {return -1;}
        
        int medio = inicio + (fin - inicio) / 2;

        if (vector[medio] == valor) {
            return medio;
        }

        if (valor < vector[medio]) {
            return binariaLimites(vector, inicio, medio - 1, valor);
        }

        return binariaLimites(vector, medio + 1, fin, valor);
    }
    
    //todasLasOcurrencias
    public ArrayList<Integer> todasLasOcurrencias(int[] vector, int indice, int valor, ArrayList<Integer> posiciones) {

    if (indice == vector.length) {
        return posiciones;
    }

    if (vector[indice] == valor) {
        posiciones.add(indice);
    }

    return todasLasOcurrencias(vector, indice + 1, valor, posiciones);
}
    
    //  Búsqueda recursiva del mínimo
    public int buscarMinimo(int[] vector, int indice) {
        if (indice == vector.length - 1) {
            return vector[indice];
        }
        int minResto = buscarMinimo(vector, indice + 1);
        
        return Math.min(vector[indice], minResto);
    }
    //  Búsqueda recursiva del máximo
    public int buscarMaximo(int[] vector, int indice) {
        if (indice == vector.length - 1) {
            return vector[indice];
        }

        int maxResto = buscarMaximo(vector, indice + 1);
        
        return Math.max(vector[indice], maxResto);
    }
    //  Búsqueda recursiva de posición Última Posición
     public int buscarUltimaPosicion(int[] vector, int indice, int valor) {
        if (indice < 0) {
            return -1;
        }
        if (vector[indice] == valor) {
            return indice;
        }
        return buscarUltimaPosicion(vector, indice - 1, valor);
    }
     
      // 9. Búsqueda recursiva en ambos extremos - Complejidad O(n)
    public int buscarAmbosExtremos(int[] vector, int inicio, int fin, int valor) {
        if (inicio > fin) {
            return -1;
        }
        // Compara simultáneamente el extremo izquierdo
        if (vector[inicio] == valor) {
            return inicio;
        }
        // Compara simultáneamente el extremo derecho
        if (vector[fin] == valor) {
            return fin;
        }
        // Llamada recursiva acercando ambos extremos hacia el centro
        return buscarAmbosExtremos(vector, inicio + 1, fin - 1, valor);
    }
    
    public static void main(String[] args) {
        
        BusquedaRecursiva busqueda= new BusquedaRecursiva(10);
        int[] vector = busqueda.retornarVector();
        
        int valor = 11;
        
        System.out.println(" Vector Original (Desordenado)");
        busqueda.imprimirVector(vector);
        System.out.println("Valor Buscado: " + valor);
        
        
        //Busqueda Secuencial
        if(secuencial(vector, 0, valor)){
            System.out.println("Elemento encontrado");
        }else {
            System.out.println("Elemento no encontrado");
        }
        
        //Busqueda por indice
        int posicion =busqueda.BuscarIndice(vector, 0, valor);
        
        if (posicion != -1){
            System.out.println("Elemento encontrado en la posicion: "
                    +posicion);
        }else{
            System.out.println("Elemento no encontrado");
        }
        
        
        //Busqueda Binaria
        Arrays.sort(vector);
        int pBinaria = busqueda.buscarBinaria(vector, 0, vector.length - 1, valor);
        
        if(pBinaria != -1) {
            System.out.println("Binaria Estandar: Elemento encontrado en la posicion: "+ pBinaria);
        }else {
            System.out.println("Binaria Estandar: Elemento no encontrado");
        }
        
        //Busqueda Binaria con limites
        int pLimites = busqueda.binariaLimites(vector, 0, vector.length - 1, valor);
        
        if (pLimites != -1) {
            System.out.println("Binaria Limites: Elemento encontrado en la posicion: " + pLimites);
        } else {
            System.out.println("Binaria Limites: Elemento no encontrado");
        }
        
        // BÚSQUEDA DE TODAS LAS OCURRENCIAS

        System.out.println("\n Busqueda de todas las ocurrencias");
        int valorOcurrencias = 10; 
        System.out.println("Buscando todas las apariciones del valor: " + valorOcurrencias);

       
        ArrayList<Integer> resultadoOcurrencias = new ArrayList<>();
        
     
        busqueda.todasLasOcurrencias(vector, 0, valorOcurrencias, resultadoOcurrencias);

        if (!resultadoOcurrencias.isEmpty()) {
            System.out.println("El elemento se encontro en las posiciones: " + resultadoOcurrencias);
        } else {
            System.out.println("El elemento no aparece en el vector.");
        }
        
        int minimo = busqueda.buscarMinimo(vector, 0);
        int maximo = busqueda.buscarMaximo(vector, 0);
        System.out.println("El elemento MINIMO es: " + minimo);
        System.out.println("El elemento MAXIMO es: " + maximo);
        

        int ultimaPos = busqueda.buscarUltimaPosicion(vector, vector.length - 1, valor);
        System.out.println("Ultima posicion de " + valor + ": " + ultimaPos);
        
         // 9. Búsqueda en ambos extremos
        int posExtremos = busqueda.buscarAmbosExtremos(vector, 0, vector.length - 1, valor);
        System.out.println("Busqueda por extremos de " + valor + ": " + posExtremos);
    }
        
}
