import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// Classe principal que simula um processo seletivo de candidatos
public class ProcessoSeletivo {

    public static void main(String[] args) {
        String[] candidatos = {"João", "Gabriel", "Isabella", "Pedro", "Kennedy"};

        // Para cada candidato, tentamos entrar em contato
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    // Método que simula tentativas de contato com um candidato
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        // Tentamos contato até o candidato atender ou até 3 tentativas
        do {
            atendeu = atender(); // Simula se o candidato atendeu ou não
            continuarTentando = !atendeu;

            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        } while (continuarTentando && tentativasRealizadas < 3);

        // Exibe o resultado final após as tentativas
        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " +
                               tentativasRealizadas + "ª TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +
                               ". NÚMERO MÁXIMO DE TENTATIVAS REALIZADAS.");
        }
    }

    // Método auxiliar que simula aleatoriamente se o candidato atendeu
    static boolean atender() {
        return new Random().nextInt(3) == 1; // 1 chance em 3 de atender
    }

    // Método que imprime a lista de candidatos
    static void imprimirSelecionados() {
        String[] candidatos = {"João", "Gabriel", "Isabella", "Pedro", "Kennedy"};

        System.out.println("Imprimindo a lista de candidatos com seus índices:");

        // Laço tradicional com índice
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número " + (indice + 1) + " é " + candidatos[indice]);
        }

        System.out.println("\nForma abreviada de iteração com for-each:");

        // Laço for-each
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    // Método que seleciona até 5 candidatos com base no salário pretendido
    static void selecaoCandidatos() {
        String[] candidatos = {
            "João", "Gabriel", "Isabella", "Pedro", "Kennedy",
            "Raquel", "Milena", "Jackson", "Vitor"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        // Enquanto não selecionar 5 candidatos e houver candidatos na lista
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato +
                               " solicitou o valor de salário: R$ " + String.format("%.2f", salarioPretendido));

            // Se o salário pretendido estiver dentro do orçamento
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }
    }

    // Gera aleatoriamente um salário pretendido entre R$1800 e R$2200
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Analisa se o salário pretendido está dentro do orçamento e toma decisões
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
        } else {
            System.out.println("AGUARDAR DEMAIS CANDIDATOS");
        }
    }
}
