package logic;

import java.util.ArrayList;

public class Grafovalorado extends Grafo{
    boolean orientado = false;

    public Grafovalorado(int n) {
        super(n);
    }
    
    public void inserirLigacao(int v1, int v2, int peso){
        int indexv1 = v1 -1;
        int indexv2 = v2 -1;
        if (orientado == false) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (i == indexv1 && j == indexv2) {
                        matriz[i][j] = peso;
                        matriz[j][i] = peso;

                    }
                }
            }
        } 
        else if (orientado == true) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (i == indexv1 && j == indexv2) {
                        matriz[i][j] = peso;
                    }
                }
            }
        }
    }
    
    public void dijkstraGrafo(int v){
        int vertice = v - 1;
        int[][] matrizDijkstra = new int[this.verticesg.size()][4];
        for (int i = 0; i < matriz.length; i++) {
            matrizDijkstra[i][0] = i;
            matrizDijkstra[i][1] = 0;
            matrizDijkstra[i][2] = Integer.MAX_VALUE;
        }
        int menordist = Integer.MAX_VALUE;
        int vmenordist = 0;
        while(verificarConjuntoS(matrizDijkstra) == true){
            for (int i = 0; i < matrizDijkstra.length; i++) {
                if (matrizDijkstra[i][1] == 0){
                    if (matrizDijkstra[i][2] < menordist) {
                        menordist = matrizDijkstra[i][2];
                        vmenordist = i;
                    }
                }
            }
            attMatrizDijkstra(vmenordist, matrizDijkstra);
        }
        
    }
    
    public boolean verificarConjuntoS(int [][] matrizDijkstra){
        boolean exist = false;
        for (int i = 0; i < matrizDijkstra.length; i++) {
            if(matrizDijkstra[i][1] == 0){
                exist = true;
            }
        }
        return exist;
    }
    
    public void attMatrizDijkstra(int v, int[][] matrizDijkstra){
        int vertice = v -1;
        matrizDijkstra[vertice][1] = 1;
        ArrayList adjacentes = this.getAdjacência(v);
            for (int i = 0; i < adjacentes.size(); i++) {
                if (matrizDijkstra[i][1] == 0 && matrizDijkstra[i][2] > matriz[vertice][vertice] + matriz[vertice][i]) {
                    matrizDijkstra[i][2] = matrizDijkstra[vertice][vertice] + matriz[vertice][i];
                    matrizDijkstra[i][3] = vertice;
                }
            }
    }

}