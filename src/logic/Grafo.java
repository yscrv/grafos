package logic;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    int[][] matriz;
    boolean regular;
    boolean completo;
    int verticew;
    ArrayList verticesg = new ArrayList();
    ArrayList vgvisitados = new ArrayList();

    public Grafo(int n) {
        this.matriz = new int[n][n];
        for (int i = 0; i < this.matriz.length; i++) {
            verticesg.add(i);
        }
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
    
    public ArrayList getAdjacência(int v){
        ArrayList listint = new ArrayList();
        int indexv = v-1;
        for (int i = 0; i < matriz[indexv].length; i++) {
            if (matriz[indexv][i] == 1) {
                listint.add(i + 1);
            }
        }
        return listint;
    }
    
//    public String getAdjacênciaToString(ArrayList lista){
//        String list = "";
//        for (int i = 0; i < lista.size(); i++) {
//            list += lista.get(i) + "; ";
//        }
//        return list;
//    }
    
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
    
    public ArrayList buscaProfundidade(int v){
        int vertice = v -1;
        ArrayList pilha = new ArrayList();
        ArrayList visitados = new ArrayList();
        visitados.add(vertice);
        pilha.add(vertice);
        while(pilha.isEmpty() == false){
            int vtopo = pilha.size();
            while(this.verificarV(visitados, vtopo)){
                visitados.add(verticew);
                pilha.add(verticew);
            
            }pilha.remove(pilha.get(pilha.size() - 1));
        }return visitados;
    } 
    
    public boolean verificarV(ArrayList visitados, int vtopo){
        boolean exist = false;
        int cont = 1;
        ArrayList adjacentes = this.getAdjacência(vtopo);
        System.out.println(adjacentes);
            for (int i = 0; i < adjacentes.size(); i++) {
                if (visitados.contains(adjacentes.get(i)) == false) {
                    verticew = (int) adjacentes.get(i);
                    exist = true;
                    i = adjacentes.size();
                }
            }
        return exist;
    }
    
    public boolean ehconexo(){
        boolean conexo = false;
        int contador = 0;
         
        for (int i = 0; i < verticesg.size(); i++) {
            if (vgvisitados.contains(verticesg.get(i)) == false) {
                int vertice = (int) verticesg.get(i);
                buscaProfundidade(vertice);
                contador++;
            }
        }
        
        if (contador == 1) {
            conexo = true;
        }else{
            conexo = false;
        }
        return conexo;
    }
    
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
