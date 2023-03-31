;public class Main {
    public static void main(String[] args) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().destroy();

    }
}

// FabricaDeStickers gerador = new FabricaDeStickers();
// List<Filme> filmes = ConsumirImdbAPIFilmes.instanciarLista();

// for (Filme filme : filmes) {
// gerador.criarSticker( new URL( filme.getPoster()).openStream(), filme);
// System.out.println(filme.getTitulo());
// System.out.println(filme.getNota());
// System.out.println(filme.getPoster());
// }

// PrintAulaPersonalizada.aula1();

// List<Filme> filmes = ConsumirImdbAPIFilmes.instanciarLista();
// for (Filme f : filmes) {
// System.out.println(f.toString());