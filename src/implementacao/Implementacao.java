package implementacao;

import java.util.Arrays;
import java.util.Scanner;
import logic.Grafo;
import logic.Grafovalorado;

public class Implementacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //System.out.println("Informe a quantidade de vértices: ");
        //int qvertice = sc.nextInt();
        
        Grafovalorado g = new Grafovalorado(5);
        
        g.inserirLigacao(1, 2, 7);
        g.inserirLigacao(1, 3, 3);
        g.inserirLigacao(3, 2, 6);
        g.inserirLigacao(1, 5, 1);
        g.inserirLigacao(2, 5, 5);
        g.inserirLigacao(3, 4, 4);
//        System.out.println("Deseja adicionar adjacência? (s/n)   ");
//        String x = sc.next();
//        while ("s".equals(x)){
//            System.out.println("Informe o primeiro vértice (1/2/3/4): ");
//            int v1 = sc.nextInt();
//            System.out.println("Informe o segundo vértice (1/2/3/4): ");
//            int v2 = sc.nextInt();
//            g.inserirLigacao(v1, v2);
//            System.out.println("Deseja adicionar adjacência? (sim/nao) ");
//            x = sc.next();
//        }
//        System.out.println(g.printG());
//        System.out.println("Informe o vertice para verificar adjacências: ");
//        int v = sc.nextInt();
//        System.out.println("Adjacentes ao vértice " + v + ": ");
//        System.out.println(g.getAdjacência(v));
//        System.out.println("é regular: " + g.ehRegular());
//        System.out.println("é completo" + g.ehCompleto());
//        System.out.println(g.buscaProfundidade(v));
//        System.out.println("é conexo: " + g.ehconexo());
          g.dijkstraGrafo(3);
          
          
         
        
        
        
    }
    
}
