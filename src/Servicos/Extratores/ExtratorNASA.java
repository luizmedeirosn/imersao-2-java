package Servicos.Extratores;

import java.util.List;

import Entidades.DadosDaGalaxia;
import Parsers.JsonParserConteudos;

public class ExtratorNASA {
    public static List<DadosDaGalaxia> instanciarLista(String body) {
        return JsonParserConteudos.parse(body)
            .stream()
            .map(atributosDeGalaxia -> new DadosDaGalaxia(atributosDeGalaxia))
            .toList();
    }
}
