package funcao;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class funcao_3 {
	private final static int TAMANHO = 20;

	public static void main(String[] args) {

		String[] nomesAlunos = new String[TAMANHO];
		int[] idades = new int[TAMANHO];
		String[] sexos = new String[TAMANHO];
		double[][] notas = new double[TAMANHO][3];
		double[] media = new double[TAMANHO];
		int count = 0;
		int op = 0;
		do {
			op = menu();
			// cadastrar
			if (op == 1)
				cadastrar(nomesAlunos, idades, sexos, notas, count++);
			if (op == 2)
				CalcularMedia(nomesAlunos, notas, count, media);
			if (op == 3)
				statusAluno(nomesAlunos, media, count);
			if (op == 4)
				porcentual(sexos, media, count);
			if (op == 5)
				MediaTurma(media, count);
			if (op == 6)
				list(sexos, count, nomesAlunos);
			if (op == 7)//A unica coisa que realmente usai chatGPT
				listarPorIdade1(nomesAlunos, idades, count);
			if (op == 8)
				sair();

		} while (op != 8);

	}

//	faça um programa que cadastre os alunos da disciplina de Algoritmos II.
//	Cada aluno tem nome, idade, sexo, e tres notas.
//
//	O programa deve ter o seguinte menu:
//	1 - Cadastrar aluno
//	2 - Calcular a média de todos os alunos
//	3 - Exibir alunos e se estão aprovados, reprovaos ou em recuperação (critérios: acima de 7 aprovado, abaixo de 3 reprovado)
//	4 - Percentual de mulheres e homens reprovados
//	5 - Média das idades da turma
//	6 - Listar alunos por sexo
//	7 - Listar alunos por idade
//
//	Validações:
//	Nome obrigatório
//	Idade - entre 17 e 99
//	sexo - M ou F
//	Notas - double entre 0 e 10
//
//	**** UTILIZAR O MÁXIMO DE PROCEDIMENTOS E FUNÇÕES
	private static int menu() {

		String m = " 1 - Cadastrar aluno\n" + " 2 - Calcular a média de todos os alunos\n"
				+ " 3 - Exibir alunos e se estão aprovados, reprovaos ou em recuperação\n "
				+ "4 - Percentual de mulheres e homens reprovados\n" + " 5 - Média das idades da turma\n"
				+ " 6 - Listar alunos por sexo\n" + " 7 - Listar alunos por idade\n" + " 8 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(m));

	}

	private static void sair() {
		String m = "O Sistema finalizado com sucesso!\n tenha um bom dia!";
		JOptionPane.showMessageDialog(null, m);
	}

	private static void cadastrar(String[] nomesAlunos, int[] idades, String[] sexos, double[][] notas, int count) {
		if (count < TAMANHO) {
			nomesAlunos[count] = JOptionPane.showInputDialog("Nome Do Aluno: ");
			sexos[count] = JOptionPane.showInputDialog("sexo:");
			idades[count] = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));
			for (int j = 0; j < 3; j++) {
				notas[count][j] = Double.parseDouble(JOptionPane.showInputDialog((j + 1) + "° nota:"));

			}
			JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");

		}
	}

	// 2 - Calcular a média de todos os alunos
	private static void CalcularMedia(String[] nomes, double[][] notas, int count, double[] media) {
		String mensagem = "";
		for (int i = 0; i < count; i++) {
			double soma = 0;

			for (int j = 0; j < 3; j++) {
				soma += notas[i][j];

			}
			media[i] = soma / 3;
			DecimalFormat df = new DecimalFormat("##.##");

			mensagem += "Nome:" + nomes[i] + " media:" + df.format(media[i]) + "\n";
		}
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private static void statusAluno(String nomes[], double media[], int count) {
		DecimalFormat df = new DecimalFormat("00.00");
		String status = "";

		int qtdd = 0;
		String mensagem = "";
		String porcetual = "";
		for (int i = 0; i < count; i++) {
			if (media[i] >= 7) {
				mensagem += "Nome:" + nomes[i] + " media:" + df.format(media[i]) + " Aprovado\n";
			} else {
				if (media[i] <= 3) {
					mensagem += "Nome:" + nomes[i] + " media:" + df.format(media[i]) + " Reprovado\n";
				} else {
					mensagem += "Nome:" + nomes[i] + " media:" + df.format(media[i]) + " Recuperação\n";

				}
			}

		}
		JOptionPane.showMessageDialog(null, mensagem);

	}

	private static void porcentual(String[] sexos, double[] media, int count) {
		int totalHomens = 0;
		int totalMulheres = 0;
		int reprovadosHomens = 0;
		int reprovadosMulheres = 0;

		for (int i = 0; i < count; i++) {
			if (sexos[i].equalsIgnoreCase("M")) {
				totalHomens++;
				if (media[i] < 7) {
					reprovadosHomens++;
				}
			} else if (sexos[i].equalsIgnoreCase("F")) {
				totalMulheres++;
				if (media[i] < 7) {
					reprovadosMulheres++;
				}
			}
		}
		DecimalFormat df = new DecimalFormat("00.00");
		double percentualHomens = (double) reprovadosHomens / totalHomens * 100;
		double percentualMulheres = (double) reprovadosMulheres / totalMulheres * 100;

		JOptionPane.showMessageDialog(null, "Percentual de homens reprovados: " + df.format(percentualHomens) + "%\n"
				+ "Percentual de mulheres reprovadas: " + df.format(percentualMulheres) + "%");
	}

	// 5 - Média das idades da turma
	private static void MediaTurma(double[] media, int count) {
		double soma = 0;
		double mediaT = 0;
		for (int i = 0; i < count; i++) {
			soma += media[i];
		}
		DecimalFormat df = new DecimalFormat("00.00");
		mediaT = soma / count;
		JOptionPane.showMessageDialog(null, "A Media a Turma:" + df.format(mediaT));

	}

//6 - Listar alunos por sexo
	private static void list(String[] sexos, int count, String[] nomes) {

		String listF = "";
		String listM = "";
		String listDesconhecido = "";
		for (int i = 0; i < count; i++) {
			if (sexos[i].equalsIgnoreCase("f")) {
				listF += "\n" + nomes[i];

			} else if (sexos[i].equalsIgnoreCase("m")) {
				listM += "\n" + nomes[i];
			} else {
				listDesconhecido += "\n" + nomes[i];

			}

		}
		JOptionPane.showMessageDialog(null,
				"LISTA FEMININA:" + listF + "\nLISTA MASCULINA:" + listM + "\nGENERO INVALIDO:" + listDesconhecido);

	}

//	7 - Listar alunos por idade; pergunta como o professor faria 

	private static void listarPorIdade1(String[] nomes, int[] idades, int count) {
		// Criando uma matriz auxiliar para ordenar os nomes e as idades juntos
		String[][] matrizAuxiliar = new String[count][2];

		// Preenchendo a matriz auxiliar com os nomes e idades
		for (int i = 0; i < count; i++) {
			matrizAuxiliar[i][0] = nomes[i];
			matrizAuxiliar[i][1] = Integer.toString(idades[i]);
		}

		// Ordenando a matriz auxiliar com base nas idades
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (Integer.parseInt(matrizAuxiliar[i][1]) > Integer.parseInt(matrizAuxiliar[j][1])) {
					String[] temp = matrizAuxiliar[i];
					matrizAuxiliar[i] = matrizAuxiliar[j];
					matrizAuxiliar[j] = temp;
				}
			}
		}

		// Construindo a mensagem final
		StringBuilder mensagem = new StringBuilder();
		for (int i = 0; i < count; i++) {
			mensagem.append("Nome: ").append(matrizAuxiliar[i][0]).append(", Idade: ").append(matrizAuxiliar[i][1])
					.append("\n");
		}

		JOptionPane.showMessageDialog(null, mensagem.toString());
	}
}
