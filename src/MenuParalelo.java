import java.util.Scanner;

public class MenuParalelo {
    public static void menu() throws InterruptedException {
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
                texto = cifrarParagrafo(1);
                System.out.println(texto);
                break;
            case 2:
                texto = cifrarParagrafo(2);
                System.out.println(texto);
                break;
            case 0:
                break;
        }

        src.close();
    }

    private static String cifrarParagrafo(int opcaoCifra) throws InterruptedException {
        Scanner src = new Scanner(System.in);
        String paragrafo = "";
        String texto = "";
        CifraRunnable cifraRunnable = new CifraRunnable();

        int escolha;
        do {
            System.out.println("\n1 - Inserir novo parágrafo");
            System.out.println("0 - Sair");
            escolha = src.nextInt();
            Thread thread = new Thread(cifraRunnable);

            switch (escolha) {
                case 1:
                    System.out.println("\nDigite o parágrafo: ");
                    src.nextLine();
                    paragrafo = src.nextLine().toLowerCase();
                    synchronized (cifraRunnable) {
                        while (cifraRunnable.isProcessing()) {
                            System.out.println("Aguardando criptografia do parágrafo anterior...");
                            cifraRunnable.wait();
                        }

                        cifraRunnable.setOpCifra(opcaoCifra);
                        cifraRunnable.setParagrafo(paragrafo);
                        texto += " " + cifraRunnable.getTexto() + "\n";
                        thread.start();

                    }

                    break;
                case 0:
                    synchronized (cifraRunnable) {
                        while (cifraRunnable.isProcessing()) {
                            System.out.println("Aguardando criptografia do parágrafo anterior...");
                            cifraRunnable.wait();
                        }
                    }
                    texto += " " + cifraRunnable.getTexto() + "\n";
                    break;
            }
        } while (escolha != 0);

        src.close();
        return texto;
    }
}
