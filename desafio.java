package br.Desafio2;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class desafio {
	public static void main(String[] args) {
		int cont = 0;
		final int LIMITE = 4;

		String[] nomesAlunos = new String[LIMITE]; // Aumente o tamanho para acomodar até 100 alunos
		double[][] notasAlunos = new double[LIMITE][3]; // Aumente o tamanho para acomodar até 100 alunos e 3 notas cada
		double[] mediasAlunos = new double[LIMITE]; // Aumente o tamanho para acomodar até 100 alunos
		int opc = 0;
		DecimalFormat media = new DecimalFormat("#.##");
		String menu = """
				1 - Cadastrar Aluno.
				2 - Colocar Notas.
				3 - Ver Média De Alunos.
				4 - Ver Média De Sala.
				5 - Adicionar Trabalho Extra (Nota Extra).
				6 - Ver Quem passou e reprovou.
				7 - Sair.
				""";

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opc) {
			case 1: {
				// Cadastrar Aluno
				if (cont < LIMITE) {
					nomesAlunos[cont] = JOptionPane.showInputDialog("Coloque o nome do Aluno");
					cont++;

				} else {

					JOptionPane.showMessageDialog(null, "Memória Cheia!");
				}
				break;
			}
			case 2: {
				boolean encontrou = false;
				String buscarAluno = JOptionPane.showInputDialog("Qual aluno deseja adicionar notas:");
				for (int i = 0; i < cont; i++) {
					if (nomesAlunos[i].equalsIgnoreCase(buscarAluno)) {
						encontrou = true;
						double somaNotas = 0;
						for (int j = 0; j < 3; j++) {
							notasAlunos[i][j] = Double
									.parseDouble(JOptionPane.showInputDialog("Coloque a " + (j + 1) + "ª nota:"));
							somaNotas += notasAlunos[i][j];
						}
						mediasAlunos[i] = somaNotas / 3; // Calcula a média
						JOptionPane.showMessageDialog(null,
								"Aluno(a): " + nomesAlunos[i] + "\nMédia: " + media.format(+mediasAlunos[i]));
					}
				}
				if (!encontrou) {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
				}
				break;
			}
			case 3: {
				boolean encontrou = false;
				String buscarAluno = JOptionPane.showInputDialog("Qual aluno deseja ver a média:");
				for (int i = 0; i < cont; i++) {
					if (nomesAlunos[i].equalsIgnoreCase(buscarAluno)) {
						encontrou = true;
						JOptionPane.showMessageDialog(null,
								"Aluno(a): " + nomesAlunos[i] + "\nMédia: " + media.format(mediasAlunos[i]));
					}
				}
				if (!encontrou) {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
				}
				break;
			}

			case 4: {
				double somaMedia = 0;
				for (int i = 0; i < cont; i++) {
					somaMedia += mediasAlunos[i];
				}
				double mediaSala = somaMedia / cont;
				JOptionPane.showMessageDialog(null, "A média da Sala:" + media.format(mediaSala));
				break;
			}
			case 5: {
				double precisaNota = 0;
				double notaextra = 0;
				String listaQuemPrecisas[] = new String[cont];
				String listaAlunos = "";

				for (int i = 0; i < cont; i++) {
					if (mediasAlunos[i] <= 6) {
						listaAlunos += " " + nomesAlunos[i] + "\n";
						listaQuemPrecisas[i] = nomesAlunos[i];

					}

				}
				JOptionPane.showMessageDialog(null, "Lista de aluno Que precisa de Nota Extra:\n"+listaAlunos);
				String buscarAluno = JOptionPane.showInputDialog("Qual aluno que deseja adicionar Nota  extra:");
				boolean encontrou = false;
				for (int i = 0; i < cont; i++) {
					if (listaQuemPrecisas[i].equalsIgnoreCase(buscarAluno)) {
						encontrou = true;
						int qtddNota = Integer.parseInt(
								JOptionPane.showInputDialog("Quantos trabalhos O " + listaQuemPrecisas[i] + " fez:"));
						for (int j = 0; j < qtddNota; j++) {
							precisaNota = Double.parseDouble(JOptionPane.showInputDialog("coloque a " + (j + 1)
									+ "°  nota Extra:\n  Alerta  a  Nota extra vai no maximo  5 pontos por nota!  "));
							if (precisaNota <= 5) {
								notaextra += precisaNota;

							} else {
								JOptionPane.showMessageDialog(null,
										"Valor da nota Ultrapassou o limite \n repita a nota!");
								j--;
							}

						}

						mediasAlunos[i] += notaextra / qtddNota;
						
					}
					if (!encontrou) {
						JOptionPane.showMessageDialog(null, "Esse Aluno não se encontrana lista.");

					}
				}
				break;

			}
			case 6:{
				String aprovado="";
				String reprovado="";
				for(int i=0;i<cont;i++) {
					if(mediasAlunos[i]>=6) {
						aprovado+="\n |"+nomesAlunos[i];
					}else {
						reprovado+="\n |"+nomesAlunos[i];
					}
				}
				JOptionPane.showMessageDialog(null, "Lista da Turma:\n"+"Lista De Aprovado:"+aprovado+"\nLista De Reprovado:"+reprovado);
				
				break;
				
			}
			case 7:{
				JOptionPane.showMessageDialog(null, "Sistema Finalizado com sucesso!");
				break;
			}
			default:
				JOptionPane.showMessageDialog(null, "Operação Invalida!");
				break;
			}
		} while (opc != 7);
	}
}
