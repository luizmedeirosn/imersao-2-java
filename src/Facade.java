import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import Entidades.DadosDaGalaxia;
import Entidades.EnumDeChaves;
import Entidades.Filme;
import Servicos.ClientesHttp.ClienteHttpAPIDeConteudos;
import Servicos.Extratores.ExtratorIMDB;
import Servicos.Extratores.ExtratorNASA;
import Servicos.Geradores.FabricaDeStickers;

public class Facade {
    public static void main(String[] args) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().destroy();
        
        ClienteHttpAPIDeConteudos clienteIMDB = new ClienteHttpAPIDeConteudos(EnumDeChaves.IMBD);
        ClienteHttpAPIDeConteudos clienteNASA = new ClienteHttpAPIDeConteudos(EnumDeChaves.NASA);

        String bodyIMDB = clienteIMDB.getResponseBodyString();
        String bodyNASA = clienteNASA.getResponseBodyString();

        List<Filme> listaDeFilmes = ExtratorIMDB.instanciarLista(bodyIMDB);
        List<DadosDaGalaxia> listaDeDadosDaGalaxia = ExtratorNASA.instanciarLista(bodyNASA);

        
        listaDeFilmes
            .forEach (
                filme -> {
                    try {
                        FabricaDeStickers
                            .criarSticker( new URI( filme.getLinkDaImagem()).toURL().openStream(), filme );
                    } catch (MalformedURLException e) {
                        System.out.println("Não consegui ler a URL!");
                    } catch (IOException e) {
                        System.out.println("Não consegui ler a URL!");
                    } catch (URISyntaxException e) {
                        System.out.println("Não consegui ler a URL!");
                    }
                }
            );
        
            listaDeDadosDaGalaxia            
                .forEach (
                    DadosDaGalaxia -> {
                        try {
                            FabricaDeStickers
                                .criarSticker( new URI( DadosDaGalaxia.getLinkDaImagem()).toURL().openStream(), DadosDaGalaxia );
                        } catch (MalformedURLException e) {
                            System.out.println("Não consegui ler a URL!");
                        } catch (IOException e) {
                            System.out.println("Não consegui ler a URL!");
                        } catch (URISyntaxException e) {
                            System.out.println("Não consegui ler a URL!");
                        }
                    }
            );
    }
}