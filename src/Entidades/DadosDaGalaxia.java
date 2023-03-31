package Entidades;

import java.util.Map;

public class DadosDaGalaxia {
    private final String titulo;
    private final String linkDaImagem;

    public DadosDaGalaxia(String titulo, String linkDaImagem) {
        this.titulo = titulo;
        this.linkDaImagem = linkDaImagem;
    }

    public DadosDaGalaxia(Map<String, String> galaxia) {
        this.titulo = galaxia.get("title");
        this.linkDaImagem = galaxia.get("url");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLinkDaImagem() {
        return linkDaImagem;
    }
}
