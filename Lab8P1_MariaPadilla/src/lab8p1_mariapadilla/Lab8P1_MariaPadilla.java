
package lab8p1_mariapadilla;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Set;

public class Lab8P1_MariaPadilla {
    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();
    static Game b = new Game();
    public static void main(String[] args) {
        System.out.println(" 1. Game of life ");
        System.out.println(" 2. Salir ");
        System.out.println(" Ingrese una opcion: ");
        int opcion=leer.nextInt();
     
        while (opcion>0 && opcion<2){
        switch (opcion){
            case 1:
                System.out.println(" cuantas rondas:  ");
                int rondad=leer.nextInt();
                 int size = 10;
                 int[][] matriz = new int[size][size];
                 ArrayList<String>coordenadas=new ArrayList();
                 matriz=generar(size);
                 b.setActual(matriz);
                 b.setCoordenadas(coordenadas);
                 b.setMatriz1(matriz);
                 b.setRondas(rondad);
                
                 //imprimir(matriz);
                 
                 System.out.println();
                 
                 b.NextGen(matriz);
                 
                 b.jugar(rondad);
                 
               
                break;
        
        }
        System.out.println("");
        System.out.println(" 1. Game of life ");
        System.out.println(" 2. Salir ");
        System.out.println(" Ingrese una opcion: ");
        opcion=leer.nextInt();
        
        }
        
      
    }// fin del main
     public static int[][] generar(int size) {
        int temporal[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i==0 || i==9 || j==0 || j==9){
                    temporal[i][j]=0;
                } else {
                    temporal[i][j]=ran.nextInt(2);
                }
            
            }

        }
        //b.set
        b.actual=new int[10][10];
    
        return temporal;
    }
    public static  void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" [ " + matriz[i][j] + " ] ");
            }
            System.out.println("");

        }

    }
    
}
