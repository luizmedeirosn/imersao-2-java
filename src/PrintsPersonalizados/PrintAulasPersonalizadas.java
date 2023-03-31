package PrintsPersonalizados;

public class PrintAulasPersonalizadas {
    final static String negrito = "\u001b[1m";
    final static String reset = "\u001b[0m";

    final static String vermelho = "\u001b[31;1m";
    final static String azul = "\u001b[34;1m";
    final static String verde = "\u001b[32;1m";
    final static String amarelo = "\u001b[33;1m";
    final static String violeta = "\u001b[35;1m";

    public static void aula1() {
        System.out.println();
        System.out.println(azul + negrito + "     AAA     UU       UU LL          AAA        11111");
        System.out.println(azul + negrito + "    AA AA    UU       UU LL         AA AA      11  11");
        System.out.println(azul + negrito + "   AA   AA   UU       UU LL        AA   AA    11   11");
        System.out.println(azul + negrito + "  AAAAAAAAA  UU       UU LL       AAAAAAAAA        11");
        System.out.println(azul + negrito + " AA       AA  UUUUUUUUU  LLlllll AA       AA       11");
        System.out.println();
    }
}