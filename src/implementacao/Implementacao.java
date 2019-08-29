package implementacao;

import java.util.Scanner;
import logic.Grafo;

public class Implementacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe a quantidade de vértices: ");
        int qvertice = sc.nextInt();
        
        Grafo g = new Grafo(qvertice);
        
        System.out.println("Deseja adicionar adjacência? (s/n)   ");
        String x = sc.next();
        while ("s".equals(x)){
            System.out.println("Informe o primeiro vértice (1/2/3/4): ");
            int v1 = sc.nextInt();
            System.out.println("Informe o segundo vértice (1/2/3/4): ");
            int v2 = sc.nextInt();
            g.inserirLigacao(v1, v2);
            System.out.println("Deseja adicionar adjacência? (sim/nao) ");
            x = sc.next();
        }
        System.out.println(g.printG());
        System.out.println("Informe o vertice para verificar adjacências: ");
        int v = sc.nextInt();
        System.out.println("Adjacentes ao vértice " + v + ": ");
        System.out.println(g.getAdjacênciaToString(g.getAdjacência(v)));
        System.out.println(g.ehRegular());
        System.out.println(g.ehCompleto());
        
        
        
        
    }
    
}
