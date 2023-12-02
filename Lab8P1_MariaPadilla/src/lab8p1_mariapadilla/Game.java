
package lab8p1_mariapadilla;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Game {
    Scanner leer = new Scanner(System.in);
    static Random ran=new Random();
    int[][] actual = new int[10][10];
    int rondas;
    int matriz1[][]=new int[10][10];
    ArrayList<String>coordenadas=new ArrayList<>();
    

    public int[][] getMatriz1() {
        return matriz1;
    }

    public void setMatriz1(int[][] matriz1) {
        this.matriz1 = matriz1;
    }

    public ArrayList<String> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }
    

    public int[][] getActual() {
        return actual;
    }

    public void setActual(int[][] actual) {
        this.actual = actual;
    }
   
   
    public void  NextGen (int [][]matriz){
        for (int i = 0; i < actual.length; i++) {
            
            for (int j = 0; j < actual[i].length; j++) {
                int c= contarVecinos(actual, i, j);
                
                if(c == -1)
                {
                    matriz[i][j] = 0;
                }
                if (actual[i][j]==1 && c<2){
                    matriz[i][j]=0; 
                     
                }
                if (actual[i][j]==1 && c>3){
                     matriz[i][j]=0;
                    
                }
                if ( actual[i][j]==0 && c==3){
                     matriz[i][j]=1;
                     
                
                }
                if (actual[i][j]==1 && c==2){
                     matriz[i][j]=1;
                
                }
                
            }
        }
        this.setActual(matriz);
        actualizarCoordenadas();
    }
    public  void print ( ArrayList<String> coordenadas ){
        for (int i = 0; i < coordenadas.size(); i++) {
            String valor=coordenadas.get(i);
            String pos = "" + valor.charAt(0);
            int posx=Integer.parseInt(pos);
            pos = "" + valor.charAt(2);
            int posy=Integer.parseInt(pos);
            actual[posx][posy]=1;
        }
        
        for (int i = 0; i < actual.length; i++) {
            
            for (int j = 0; j < actual[i].length; j++) {
                
                System.out.print("[ "+ actual[i][j]+ " ]");
                
            }
            System.out.println(" ");
            
        }
        
    }
    public  void jugar(int rondas){
      print(coordenadas);
      System.out.println("");
        for (int i = 0; i < rondas; i++) {
            System.out.println("");
            System.out.println(" Ronda "+ (i+1));
            NextGen(matriz1);
            System.out.println(" Coordenadas: ");
            System.out.println("");
            System.out.println(coordenadas);
            print(coordenadas);
        
            
        }
    
    }
    public int contarVecinos(int [][]matriz, int i, int j){
        int c=0;
        if (j==0 ||j==9 ||i==0||i==9) {
                    c = -1;
                }else{
                    if (matriz[i-1][j-1]==1){
                     c++;
                    }
                        
                    if (matriz[i-1][j]==0){
                    c++;
                    }
                       
                    if (matriz[i-1][j+1]==1){
                    c++;
                    }
                   
                    if (matriz[i][j+1]==1){
                    c++;
                    }
                    
                    if (matriz[i+1][j+1]==1){
                    c++;
                    }
                   
                    if ( matriz[i][j-1]==1){
                    c++;
                    }
                   
                    if (matriz[i+1][j]==1){
                    c++;
                    }
                   
                    if (matriz[i+1][j-1]==1){
                        c++;
                    }
                    
                    
                }
        return c;
        
    }
    
    public void actualizarCoordenadas(){
        for (int i = 0; i < coordenadas.size(); i++) {
            coordenadas.remove(0);
        }
        
        for(int i = 0; i < actual.length; i++){
            for (int j = 0; j < actual[i].length; j++) {
                if(actual[i][j] == 1){
                    String coordinate = i + ":" + j;
                    coordenadas.add(coordinate);
                }
            }
        }
    }
}
