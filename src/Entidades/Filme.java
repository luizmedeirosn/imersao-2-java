package Entidades;

import java.util.Map;

public class Filme {
    private final String titulo;
    private final String linkDaImagem;
    private final String nota;
    
    public Filme(String titulo, String linkDaImagem, String nota) {
        this.titulo = titulo;
        this.linkDaImagem = linkDaImagem;
        this.nota = nota;
    }

    public Filme(Map<String, String> filme) {
        this.titulo = filme.get("title");
        this.linkDaImagem = filme.get("image");
        this.nota =filme.get("imDbRating");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLinkDaImagem() {
        return linkDaImagem;
    }

    public String getNota() {
        return nota;
    }


    final static String negrito = "\u001b[1m";
    final static String reset = "\u001b[0m";

    final static String vermelho = "\u001b[31;1m";
    final static String azul = "\u001b[34;1m";
    final static String verde = "\u001b[32;1m";
    final static String amarelo = "\u001b[33;1m";
    final static String violeta = "\u001b[35;1m";
    final static String branco = "\u001b[37;1m";

    final static String fundoAzul = "\u001b[44;1m";
    final static String fundoVermelho = "\u001b[41;1m";
    final static String fundoAmarelo = "\u001b[43;1m";
    final static String fundoVerde = "\u001b[42m";
    
    final static String caneta = "🖊️";
    final static String alerta = "⚠️";
    final static String coracaoAlura = "💙";
    final static String estrela = "⭐";
    final static String pino = "📍";
    
    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append( String.format(caneta + amarelo + negrito + "  Título " + branco + "%s%s%n", getTitulo(), reset) );
        saida.append( String.format(alerta + amarelo + negrito + "  Poster " + branco + "%s%s%n", getLinkDaImagem(), reset) );
        saida.append( String.format(coracaoAlura + "  " + fundoVermelho + "Classificação %s%s%s%n", getNota(), reset, pino) );
        for (int i = 0 ; i < (int) Double.parseDouble(getNota()) ; i++) {
            saida.append(estrela);
        }
        saida.append("\n");

        return saida.toString();
    }
}
