public class Cifra {
    private static final String alfabeto = "abcdefghijklmnopqrstuvxz";

    public static boolean vogal(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static char vogalMaisProxima(Character consoante){
        char vogalMaisProxima = '\0';
        int countDireita = 0;
        int countEsquerda = 0;
        if (consoante == 'z'){
            return 'u';
        } else {
            for (int i = alfabeto.indexOf(consoante); i != 0 && i != 4 && i != 8 && i != 14 && i != 20; i++) {
                countDireita++;
            }
            for (int i = alfabeto.indexOf(consoante); i != 0 && i != 4 && i != 8 && i != 14 && i != 20; i--) {
                countEsquerda++;
            }
            if (countDireita == countEsquerda || countDireita > countEsquerda) {
                vogalMaisProxima = alfabeto.charAt(alfabeto.indexOf(consoante) - countEsquerda);
            } else {
                vogalMaisProxima = alfabeto.charAt(alfabeto.indexOf(consoante) + countDireita);
            }
        }
        return  vogalMaisProxima;
    }

    private static char proximaConsoante(Character consoante){

        if(consoante == 'z'){
            return 'z';
        } else {
            char proximaConsoante = alfabeto.charAt(alfabeto.indexOf(consoante)+1);
            if (vogal(proximaConsoante)) {
                proximaConsoante = alfabeto.charAt(alfabeto.indexOf(proximaConsoante) + 1);
            }
            return proximaConsoante;
        }
    }

    public static String criptografar(String palavra){
        char[] letras = palavra.toCharArray();
        String palavraCriptografada = "";

        for(int i = 0; i < letras.length; i++){
            if (letras[i] != '\n') {
                if (letras[i] != ' ') {
                    if (Cifra.vogal(letras[i])) {
                        palavraCriptografada += letras[i];
                    } else {
                        palavraCriptografada += letras[i];
                        palavraCriptografada += vogalMaisProxima(letras[i]);
                        palavraCriptografada += proximaConsoante(letras[i]);
                    }
                } else {
                    palavraCriptografada += " ";
                }
            } else {
                palavraCriptografada += "\n";
            }
        }
        return palavraCriptografada;
    }


    public static String descriptografar(String palavra){
        char[] letras = palavra.toCharArray();
        String palavraDescriptografada = "";

        for(int i = 0; i < letras.length; i++){
            if (letras[i] != '\n') {
                if (letras[i] != ' ') {
                    if (Cifra.vogal(letras[i])) {
                        palavraDescriptografada += letras[i];
                    } else {
                        palavraDescriptografada += letras[i];
                        i = i + 2;
                    }
                } else {
                    palavraDescriptografada += " ";
                }
            } else {
                palavraDescriptografada += "\n";
            }
        }
        return palavraDescriptografada;
    }
}
