package Aula1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConsumirImdbAPIFilmes {

    private static String newJsonStringResponse() {

        Properties prop = new Properties();
        InputStream arqConfiguracao = null;
        String URL = null;
        try {
            arqConfiguracao = new FileInputStream("./.properties/conf.properties");
            prop.load(arqConfiguracao);
            URL = prop.getProperty("link");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo .properties não foi carregado, verifique se o caminho está correto!");
        } catch (IOException e) {
            System.out.println("Arquivo .properties não foi carregado, verifique se o caminho está correto!"); 
        } catch (NullPointerException e) {
            System.out.println("prop está setado como null");
        }
        
        URI endpoint = URI.create(URL);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endpoint)
            .GET()
            .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Não consegui realizar a request!");
        } catch (InterruptedException e) {
            System.out.println("Não consegui realizar a request!");
        }
        
        return response != null ? response.body() : "";
        
        
    }

    public static List<Filme> instanciarLista() {

        String body = newJsonStringResponse();
        List< Map<String,String> > listaDeFilmesInicial = JsonParserImdbFilmes.parse(body);
        List<Filme> listaDeFilmesTratada = new ArrayList<>();
        for (Map<String, String> filmeModelMap : listaDeFilmesInicial) {
            listaDeFilmesTratada.add(new Filme(filmeModelMap));
        }
        return listaDeFilmesTratada;
    }
    
}
