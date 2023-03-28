import java.util.List;

import Aula1.ConsumirImdbAPIFilmes;
import Aula1.Filme;
import Aula1.PrintAulaPersonalizada;

public class Main {
    public static void main(String[] args) throws Exception {
        
        System.out.println();
        PrintAulaPersonalizada.aula1();

        List<Filme> filmes = ConsumirImdbAPIFilmes.instanciarLista();
        for (Filme f : filmes) {
            System.out.println(f.toString());  
        }
    }
}