package Aula2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Aula1.Filme;

public class FabricaDeStickers {

    public void criarSticker(InputStream inputStream, Filme filme) {

        String nomeDoArquivo = filme.getTitulo()
                .replaceAll(":", "-")
                .replaceAll(" ", "-")
                .replaceAll("--", "-"); // windows não reconhece o ":" especiais para nomes de arquivos.

        BufferedImage imagemOriginal = null;
        try {
            imagemOriginal = ImageIO.read(inputStream);
        } catch (IOException e) {
            System.out.println("Não consegui ler o arquivo, verifique o caminho!");

        }

        String msg = null;
        BufferedImage minhaReacao = null;
        try {
            if (Double.parseDouble(filme.getNota()) > 8){
                msg = "MUITO MASSA";
                minhaReacao = ImageIO.read( new FileInputStream("./.reacoes/muito-bom.png") );
             } else if (Double.parseDouble(filme.getNota()) > 7) {
                 msg = "DA PRA DALE";
                 minhaReacao = ImageIO.read( new FileInputStream("./.reacoes/bom.png") );
             } else {
                 msg = "ASSISTIVEL";
                 minhaReacao = ImageIO.read( new FileInputStream("./.reacoes/assistivel.png") );
             }
        } catch (IOException e) {
            System.out.println("Não encontrei os arquivos de reações!");
        }
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + (int) (altura * 0.1);
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        ImageIcon icone = new ImageIcon(minhaReacao);
        icone.setImage(icone.getImage().getScaledInstance( (int)(novaImagem.getWidth() * 0.3),
                    (int)(novaImagem.getHeight() * 0.2),
                    novaAltura) );
        
        Graphics2D graphics2D = (Graphics2D) novaImagem.getGraphics();
        graphics2D.drawImage(imagemOriginal, 0, 0, null);
        
        graphics2D.drawImage(
                    icone.getImage(),
                    0,
                    imagemOriginal.getHeight()/2 - (int)(novaImagem.getHeight()*0.2/2),
                     null);

        Font fonte = new Font("Impact", Font.BOLD, (int) (altura * 0.08)); // tamanho da fonte de acordo com a altura da imagem.
        FontMetrics fontMetrics = graphics2D.getFontMetrics(fonte);
        Rectangle2D tamanhoDaMensagemNaFigura = fontMetrics.getStringBounds(msg, graphics2D);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.setFont(fonte);
        int eixoXdoTexto = novaImagem.getWidth() / 2 - (int) tamanhoDaMensagemNaFigura.getCenterX();
        int eixoYdoTexto = (int) (novaImagem.getHeight());
        graphics2D.drawString(msg,
                eixoXdoTexto,
                eixoYdoTexto);
        
        try {
            ImageIO.write(novaImagem, "png", new File("./.stickers/" + nomeDoArquivo + ".png"));
        } catch (Exception e) {
            System.out.println("O diretório para salvar a imagem não existe!\nCriei um novo...");
            try {
                new File("./.stickers/").mkdir(); // Gera a exceção FileNotFoundExeception, mas cria o diretorio.
                ImageIO.write(novaImagem, "png", new File(("./.stickers/" + nomeDoArquivo  + ".png")));
            } catch (IOException caminhoIncorreto) {
                System.out.println("Verifique o caminho do arquivo novamente!");
            }
        }
    }
}
