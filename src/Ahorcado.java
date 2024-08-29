import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private static final List<String> WORDS = List.of(
            "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"
    );

    private  static final Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = getRandomWord();
        int intentosMaximos = 5;
        int intentos = 0;
        boolean palabraAdivinada = false;
        
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            //System.out.print(letrasAdivinadas[i]);
        }


        while(!palabraAdivinada && intentos < intentosMaximos){
                    System.out.println("Palabra a adivinar: " +  String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() +  " letras)");
            System.out.println("Introduce una letra, por favor");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }

            }

            if (!letraCorrecta){
                intentos++;
                System.out.println("Incorrecto! Te quedan  " + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Felicidades!, has adivinado la palabra secrete: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada){
            System.out.println("Que pena te has quedado sin intentos!  GAME OVER");
        }

        scanner.close();


    }

    private static String getRandomWord(){
        return WORDS.get(RANDOM.nextInt(WORDS.size()));
    }
}