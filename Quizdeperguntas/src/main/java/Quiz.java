import DAO.QuestaoDAO;
import DAO.ResultadoDAO;
import Modelo.Questao;
import Modelo.Resultado;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int menu = 0;

        do {
            System.out.println("***** SEJA BEM VINDO AO MEU QUIZ *****");
            System.out.println("MENU:");
            System.out.println(" 1- Jogar novamente ");
            System.out.println(" 2- Ver placar ");
            System.out.println(" 0- Sair");
            System.out.println("**************************************");
            menu = validarmenu();
            if (menu == 1) {
                System.out.println("Digite seu nome:  ");
                Resultado resultado = new Resultado();
                resultado.setJogador(entrada.nextLine());

                QuestaoDAO questao = new QuestaoDAO();
                List<Questao> questionario = questao.questionario();
                questionario.forEach(q -> {
                    System.out.println(q.getPergunta());
                    System.out.println("Digite (V) para verdadeiro ou (F) para falso: ");
                    String resposta = entrada.nextLine();
                    boolean respfinal = validarresposta();

                    if (respfinal == q.isResposta()) {
                        resultado.setAcertos(resultado.getAcertos() + 1);
                        System.out.println("Parabéns, você acertou!");
                    } else {
                        resultado.setErros(resultado.getErros() + 1);
                        System.out.println("Você errou :( ");
                    }

                });
                ResultadoDAO resultadodao = new ResultadoDAO();
                resultadodao.addresposta(resultado);


            } else if (menu == 2) {
                System.out.println("");
                ResultadoDAO resultado = new ResultadoDAO();
                List<Resultado> result = resultado.questionario();
                if (result.equals(null)) {
                } else {
                    result.forEach(q -> {
                        System.out.println(q);
                    });
                }
            }
        } while (menu != 0);
    }

    public static boolean validarresposta() {
        Scanner scannerr = new Scanner(System.in);
        String texto;
        do {
            System.out.println("Digite (V) para verdadeiro e (F) para falso:  ");
            texto = scannerr.nextLine().toUpperCase(Locale.ROOT);
            if ("V".equals(texto)) {
                return true;
            } else if ("F".equals(texto)) {
                return false;
            }

        } while (texto != "V");
        return false;

    }

    public static int validarmenu() {
        Scanner scannerr = new Scanner(System.in);
        int texto;
        do {
            try {
                texto = Integer.parseInt(scannerr.nextLine());
                return texto;
            }catch (Exception e) {
                System.out.println("Digite um número: ");
                texto = 3;
            }

        }while ( texto >2);
        return texto;
    }
}















