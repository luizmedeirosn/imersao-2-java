package Servicos.Extratores;

import java.util.List;
import Entidades.Filme;
import Parsers.JsonParserConteudos;

public class ExtratorIMDB {
    public static List<Filme> instanciarLista(String body) {

        return JsonParserConteudos.parse(body)
            .stream()
            .map(atibutosDoFilme -> new Filme(atibutosDoFilme))
            .toList(); 
    }
}
