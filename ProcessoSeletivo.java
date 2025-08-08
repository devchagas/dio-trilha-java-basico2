package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        List<String> selecionados = selecaoCandidatos();
        imprimirSelecionados(selecionados);
        ligarParaSelecionados(selecionados);
    }

    static List<String> selecaoCandidatos() {
        String[] candidatos = {
                "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO",
                "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"
        };

        List<String> selecionados = new ArrayList<>();
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        System.out.println("Iniciando seleção de candidatos...\n");

        while (selecionados.size() < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("Candidato %s solicitou R$ %.2f\n", candidato, salarioPretendido);

            if (salarioPretendido <= salarioBase) {
                System.out.printf("-> %s foi selecionado para a vaga!\n\n", candidato);
                selecionados.add(candidato);
            } else {
                System.out.println("-> Valor acima do salário base. Candidato descartado.\n");
            }

            candidatosAtual++;
        }

        return selecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirSelecionados(List<String> selecionados) {
        System.out.println("\n========== LISTA DE CANDIDATOS SELECIONADOS ==========");
        for (int i = 0; i < selecionados.size(); i++) {
            System.out.println((i + 1) + " - " + selecionados.get(i));
        }
    }

    static void ligarParaSelecionados(List<String> selecionados) {
        System.out.println("\n========== FAZENDO LIGAÇÕES ==========");

        for (String candidato : selecionados) {
            boolean atendeu = false;
            int tentativas = 1;

            while (!atendeu && tentativas <= 3) {
                atendeu = atender();
                System.out.printf("Ligando para %s (tentativa %d)...\n", candidato, tentativas);
                tentativas++;
            }

            if (atendeu) {
                System.out.printf("✅ Contato com %s realizado com sucesso!\n", candidato);
            } else {
                System.out.printf("❌ Não conseguimos contato com %s após 3 tentativas.\n", candidato);
            }

            System.out.println();
        }
    }

    static boolean atender() {
        // Retorna true 1/3 das vezes (aproximadamente)
        return ThreadLocalRandom.current().nextInt(3) == 1;
    }
}
