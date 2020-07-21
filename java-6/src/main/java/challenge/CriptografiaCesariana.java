package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        // deve retornar erro quando o texto é vazio ou nulo
        if(texto.length() == 0) {
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }
        String output = "", input = texto.toLowerCase();
        for(int i = 0; i < input.length(); i++) {
            output += (input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) == ' ') ? input.charAt(i) : (char) (input.charAt(i) + 3);
        }
        return output;
    }

    @Override
    public String descriptografar(String texto) {
        // deve retornar erro quando o texto é vazio ou nulo
        if(texto.length() == 0) {
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }
        String output = "", input = texto.toLowerCase();
        for(int i = 0; i < input.length(); i++) {
            output += (input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) == ' ') ? input.charAt(i) : (char) (input.charAt(i) - 3);
        }
        return output;
    }
}
