package br.Desafio2;

import javax.swing.JOptionPane;

public class vetores1 {
	public static void main(String[] args) {
		String menu = "Pressione C - cadastrar \n Pressione S - Sair";
		String Genero = "Pressione  - H - Homen \n Pressione  - M -  ";
		double maiorAltura = 0;
		String maiorAluno = "";
		double menorAltura = Double.MAX_VALUE;
		String menorAluno = "";
		String mulherAcimaDamedia = "";

		String opc = JOptionPane.showInputDialog(menu);
		if (opc.equalsIgnoreCase("c")) {
			int turma = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade De  aluno na turma:"));
			String[] nome = new String[turma];
			String[] sexo = new String[turma];
			double[] altura = new double[turma];
			for (int i = 0; i < turma; i++) {
				nome[i] = JOptionPane.showInputDialog("Digite o Nome do " + (1 + i) + "° aluno");
				sexo[i] = JOptionPane.showInputDialog("Digite o sexo do " + (1 + i) + "° aluno");
				altura[i] = Double
						.parseDouble(JOptionPane.showInputDialog("Digite a altura do " + (1 + i) + "° aluno"));

				if (altura[i] > maiorAltura) {
					maiorAltura = altura[i];
					maiorAluno = nome[i];

				}

				if (altura[i] <= 1.69) {
					menorAltura = altura[i];
					menorAluno += nome[i] + "|";

				}
				if (altura[i] > 1.61 && sexo[i].equalsIgnoreCase("m")) {
					mulherAcimaDamedia += nome[i] + "|";

				}

			}
			String menufinal="Mulheres com altura acima da média: " + mulherAcimaDamedia + "\n" +
                    "A pessoa mais alta da turma: " +maiorAluno+" com " +maiorAltura + " cm \n" +
                    "A pessoa mais baixa da turma: " + menorAluno;
			
			JOptionPane.showConfirmDialog(null, menufinal);

		}
	}

}
