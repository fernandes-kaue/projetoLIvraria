import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Definindo o número de alunos
        final int NUM_ALUNOS = 5;

        // Criando arrays para armazenar os dados dos alunos
        String[] nomes = new String[NUM_ALUNOS];
        double[] mediaAnual = new double[NUM_ALUNOS];

        Scanner scanner = new Scanner(System.in);

        // Lendo os nomes e notas dos alunos
        for (int i = 0; i < NUM_ALUNOS; i++) {
            System.out.println("Digite o nome do aluno " + (i + 1) + ":");
            nomes[i] = scanner.nextLine();

            System.out.println("Digite a primeira nota do aluno " + nomes[i] + ":");
            double nota1 = scanner.nextDouble();

            System.out.println("Digite a segunda nota do aluno " + nomes[i] + ":");
            double nota2 = scanner.nextDouble();

            // Calculando a média anual
            mediaAnual[i] = (nota1 + nota2) / 2;

            // Consumindo o newline restante
            scanner.nextLine();
        }

        // Criando uma lista de pares (nome e média) para classificação
        Aluno[] alunos = new Aluno[NUM_ALUNOS];
        for (int i = 0; i < NUM_ALUNOS; i++) {
            alunos[i] = new Aluno(nomes[i], mediaAnual[i]);
        }

        // Ordenando os alunos pela média anual em ordem crescente
        Arrays.sort(alunos, Comparator.comparingDouble(Aluno::getMediaAnual));

        // Imprimindo a lista de alunos classificados
        System.out.println("\nClassificação dos alunos por média anual:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome() + " - Média Anual: " + aluno.getMediaAnual());
        }

        scanner.close();
    }
}

// Classe para armazenar dados de cada aluno
class Aluno {
    private final String nome;
    private double mediaAnual;

    public Aluno(String nome, double mediaAnual) {
        this.nome = nome;
        this.mediaAnual = mediaAnual;
    }

    public String getNome() {
        return nome;
    }

    public double getMediaAnual() {
        return mediaAnual;
    }
}
