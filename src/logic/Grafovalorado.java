package logic;

import java.util.ArrayList;
import static javafx.scene.input.KeyCode.R;

public class Grafovalorado extends Grafo{
    boolean orientado = false;
    int[] vetorSort;
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
        int[][] matrizDijkstra = new int[this.verticesg.size()][3];
        matrizDijkstra[vertice][0] = 1;
        matrizDijkstra[vertice][1] = 0;
        matrizDijkstra[vertice][2] = -1;
        for (int i = 0; i < matriz.length; i++) {
            if (i != vertice) {
                matrizDijkstra[i][0] = 0; //se pertence ao conjunto S terá valor 1, se não, terá valor 0
                matrizDijkstra[i][1] = Integer.MAX_VALUE - 1;
                System.out.println(matrizDijkstra[i][1]);                
//matrizDijkstra[i][2] é o caminho;
            }
        }
        
        
        int vmenordist = vertice;
        
        while(verificarConjunto_S(matrizDijkstra) == true){
            //ArrayList<Integer> listaAdjacentes_vertice = this.getAdjacência(vertice);
            int menordist = Integer.MAX_VALUE;
            matrizDijkstra[vmenordist][0] = 1;
            int[] temp = getAdjacênciaVetor(vmenordist); // vetor para comparar o peso com o indice
            sortListaAdjacencia(vmenordist);
            
            for (int i = 0; i < vetorSort.length; i++) {
                if (vetorSort[i] != 0) {
                    int x = vetorSort[i];
                    int index = 0;
                    for (int j = 0; j < temp.length; j++) {
                        if (x == temp[j]) {
                            index = j;
                        }
                    }
                    if (matrizDijkstra[index][0] != 1) {
                        if (matrizDijkstra[index][1] > matrizDijkstra[vmenordist][1] + matriz[vmenordist][index]) {
                            matrizDijkstra[index][1] = matrizDijkstra[vmenordist][1] + matriz[vmenordist][index];
                            matrizDijkstra[index][2] = vmenordist;
                        }
                    }
                }
            }
            for (int i = 0; i < matrizDijkstra.length; i++) {
                if (matrizDijkstra[i][0] == 0) {
                    if (matrizDijkstra[i][1] < menordist) {
                        menordist = matrizDijkstra[i][1];
                        vmenordist = i;
                    }
                }
            }
            
        }
        
        for (int i = 0; i < matrizDijkstra.length; i++) {
            for (int j = 0; j < matrizDijkstra[i].length; j++) {
                System.out.print(matrizDijkstra[i][j] + ", ");
            }
            System.out.println("");
        }
        
    }
    
    public boolean verificarConjunto_S(int [][] matrizDijkstra){
        boolean exist = false;
        for (int i = 0; i < matrizDijkstra.length; i++) {
            if(matrizDijkstra[i][0] == 0){
                exist = true;
            }
        }
        return exist;
    }
    
//    public void attMatrizDijkstra(int v, int[][] matrizDijkstra){
//        int vertice = v -1;
//        matrizDijkstra[vertice][1] = 1;
//        ArrayList adjacentes = this.getAdjacência(v);
//            for (int i = 0; i < adjacentes.size(); i++) {
//                if (matrizDijkstra[i][1] == 0 && matrizDijkstra[i][2] > matriz[vertice][vertice] + matriz[vertice][i]) {
//                    matrizDijkstra[i][2] = matrizDijkstra[vertice][vertice] + matriz[vertice][i];
//                    matrizDijkstra[i][3] = vertice;
//                }
//            }
//    }

    public int[] sortListaAdjacencia(int vertice){
        vetorSort = getAdjacênciaVetor(vertice);
       
        mergeSort(vetorSort, 0, vetorSort.length - 1);
        //voltar os valores com os vertices
        
        return vetorSort;
        
    }
    

    public void merge(int arr[], int l, int m, int r) 
{ 
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 
  
    /* create temp arrays */
    int[] L = new int[n1];
    int[] R = new int[n2];
  
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
  
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = l; // Initial index of merged subarray 
    while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            arr[k] = L[i]; 
            i++; 
        } 
        else
        { 
            arr[k] = R[j]; 
            j++; 
        } 
        k++; 
    } 
  
    /* Copy the remaining elements of L[], if there 
       are any */
    while (i < n1) 
    { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 
  
    /* Copy the remaining elements of R[], if there 
       are any */
    while (j < n2) 
    { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 
  
/* l is for left index and r is right index of the 
   sub-array of arr to be sorted */
public void mergeSort(int arr[], int l, int r) 
{ 
    if (l < r) 
    { 
        // Same as (l+r)/2, but avoids overflow for 
        // large l and h 
        int m = l+(r-l)/2; 
  
        // Sort first and second halves 
        mergeSort(arr, l, m); 
        mergeSort(arr, m+1, r); 
  
        merge(arr, l, m, r); 
    } 
} 
    
    
}

    