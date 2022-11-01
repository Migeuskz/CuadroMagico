/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuadro.magico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mikey
 */
public class CuadroMagico {
    
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;
    
    public static boolean hacerComparación(int r, int c){
        if(r == c){
            return true;
        }
        return false;
    }
    
    public static int[][] rellenarMatriz(int c, int r) throws IOException{
        int[][]array = new int[r][c];
        
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array[0].length; j++){
                System.out.println("Escribe el valor [" + i + "]" + "[" + j + "]: ");
                entrada = bufer.readLine();
                array[i][j] = Integer.parseInt(entrada);
            }
        }
        return array;
    }
    
    public static int suma(int[][]cuadro){
        int suma = 0;
        for (int i = 0; i < cuadro[0].length; i++) {
            suma = suma + cuadro[0][i];
        }
        return suma;
    }
    
    public static boolean comparacionRenglones(int[][] cuadro, int suma) {
        boolean esIgual = true;
        int sumaRenglones = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                sumaRenglones = sumaRenglones + cuadro[i][j];
            }
            if (sumaRenglones != suma) {
                esIgual = false;
                break;
            }
            sumaRenglones = 0;
        }
        return esIgual;
    }

    public static boolean comparacionColumnas(int[][] cuadro, int suma) {
        boolean esIgual = true;
        int sumaColumnas = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                sumaColumnas = sumaColumnas + cuadro[j][i];
            }
            if (sumaColumnas != suma) {
                esIgual = false;
                break;
            }
            sumaColumnas = 0;
        }
        return esIgual;
    }

    public static void comparacionColumnasI(int[][] cuadro, int suma) {
        boolean esIgual = true;
        int sumaColumnas = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                sumaColumnas = sumaColumnas + cuadro[j][i];
            }
            System.out.println(sumaColumnas);
            if (sumaColumnas != suma) {
                esIgual = false;
                System.out.println(esIgual);
                break;
            }
            sumaColumnas = 0;
        }
    }
    
    public static boolean esCuadro(int[][] cuadro) {
        int suma;
        suma = suma(cuadro);
        while (true) {
            if (!comparacionRenglones(cuadro, suma)) {
                return false;
            }
            if (!comparacionColumnas(cuadro, suma)) {
                return false;
            }
            
            return true;
        }
    }
    
    public static void imprimirMatriz(int[][] array){
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array[0].length; j++){
                System.out.printf("%3d", array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int[][] cuadro;
        int r = 0;
        int c = 0;
        cuadro = new int[r][c];
        
        System.out.println("Programa que ejcuta un Cuadro Mágico echo por una matriz ");
        System.out.println("Escribe el Numero de Renglones de la Matriz: ");
        entrada = bufer.readLine();
        r = Integer.parseInt(entrada);
        
        System.out.println("Escribe el Numero de Columnas de la Matriz: ");
        entrada = bufer.readLine();
        c = Integer.parseInt(entrada);
        
        System.out.println("=================================");
        System.out.println("Introducción de Valores de la Matriz: ");
        //entrada = bufer.readLine();
        cuadro = rellenarMatriz(r,c);
        if (esCuadro(cuadro)) {
            System.out.println("El cuadro es un cuadro mágico");
            imprimirMatriz(cuadro);
            } else {
                System.out.println("El cuadro no es un cuadro mágico");
            }
        
    }
    
}
