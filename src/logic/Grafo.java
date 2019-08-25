package logic;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    int[][] matriz;
    boolean regular;
    boolean completo;

    public Grafo(int n) {
        this.matriz = new int[n][n];
    }
    
    public void inserirLigacao(int v1, int v2){
        int indexv1 = v1 -1;
        int indexv2 = v2 -1;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == indexv1 && j == indexv2) {
                    matriz[i][j] = 1;
                    matriz[j][i] = 1;
                            
                }
            }
        }
    }
    
    public String getAdjacência(int v){
        String list = "";
        int indexv = v-1;
        for (int i = 0; i < matriz[indexv].length; i++) {
            if (matriz[indexv][i] == 1) {
                list += (i+1)+"; ";
            }
        }
        return list;
    }
    
    public boolean ehRegular(){
        regular = true;
        int[] qvertices = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1 ) {
                    qvertices[i] += 1;
                }
            }
        }
        for (int i = 0; i < qvertices.length; i++) {
            if (i != qvertices.length -1) {
                if (qvertices[i] != qvertices[i+1]) {
                    regular = false;
                }
            }
        }
        return regular;
    }
    
    public boolean ehCompleto(){
        completo = true;
        int[] qvertices = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1 ) {
                    qvertices[i] += 1;
                }
            }
        }
        for (int i = 0; i < qvertices.length; i++) {
                if (qvertices[i] != qvertices.length -1) {
                    completo = false;
                }
        }
        return completo;
    }
    
//     public void buscaProfundidade(int v){
//        ArrayList pilha = new ArrayList();
//        ArrayList visitados = new ArrayList();
//        visitados.add(v);
//        pilha.add(v);
//        while(pilha.isEmpty() == false){
//            //while(this.getAdjacência(v)){
//                
//            //}
//        } 
//        
//    } 
    
    
    public String printG(){
        String list = "";
        for (int i = 0; i < this.matriz.length; i++) {
            list += "v"+ (i+1) + "- ";
            for (int j = 0; j < this.matriz[i].length; j++) {
                list += " " + matriz[i][j];
            }
            list += "\n";
        }
        return list;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    
}
