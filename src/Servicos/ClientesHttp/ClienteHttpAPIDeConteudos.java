package Servicos.ClientesHttp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Properties;

import Entidades.EnumDeChaves;


public class ClienteHttpAPIDeConteudos {
    private HttpResponse<String> response;

    public ClienteHttpAPIDeConteudos(EnumDeChaves chave) {

        Properties prop = new Properties();
        InputStream arquivoDeConfiguracao = null;
        String URL = null;

        try {
            arquivoDeConfiguracao = new FileInputStream("./.properties/conf.properties");
            prop.load(arquivoDeConfiguracao);
            if (chave == EnumDeChaves.IMBD){
                URL = prop.getProperty("linkIMDB");
            } else if (chave == EnumDeChaves.NASA) {
                URL = prop.getProperty("linkNASA");
            }
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

        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Não consegui realizar a request!");
        } catch (InterruptedException e) {
            System.out.println("Não consegui realizar a request!");
        }
    }

    public String getResponseBodyString() {
        return response != null ? response.body() : "";
    }
    
}
