import java.util.Scanner;

public class Menu {
    public static void menu(){
        Scanner src = new Scanner(System.in);
        int escolha = 0;
        String texto = "";

        System.out.println("-- Menu --");
        System.out.println("1 - Criptografar texto");
        System.out.println("2 - Descriptografar texto");
        System.out.println("0 - Sair");
        escolha = src.nextInt();
        switch (escolha){
            case 1:
                texto = novoParagrafo();
                System.out.println(Cifra.criptografar(texto));
                break;
            case 2:
                texto = novoParagrafo();
                System.out.println(Cifra.descriptografar(texto));
                break;
            case 0:
                break;
        }

        src.close();
    }

    private static String novoParagrafo(){
        Scanner src = new Scanner(System.in);
        String paragrafo = "";
        String texto = "";

        int escolha;
        do {
            System.out.println("\n1 - Inserir novo parágrafo");
            System.out.println("0 - Sair");
            escolha = src.nextInt();
            switch (escolha){
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nDigite o parágrafo: ");
                    paragrafo = scanner.nextLine().toLowerCase();
                    texto += " " + paragrafo + "\n";
                case 0:
                    break;
            }
        } while (escolha != 0);

        src.close();
        return texto;
    }

}
