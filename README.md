package br.Desafio2;

import javax.swing.JOptionPane;

public class atividade6 {
	public static void main(String[] args) {
//		- Faça um algoritmo para cadastro de nomes e telefones de pessoas (no 
//				máximo 100 pessoas) e que apresente o seguinte menu (com as respectivas 
//				funcionalidades):
//				1 – Cadastrar contato 
//				2 – Buscar contato por nome
//				3 – Buscar contato por telefone
//				4 – Sair
//				Para o cadastro (opção 1), solicitar o nome e o telefone cuidando do fato que não pode 
//				exceder 100 contatos. Para as buscas (opções 2 e 3) deve mostrar o nome e o telefone de 
//				acordo com o filtro escolhido. Caso não exista o contato buscado, deve ser apresentada 
//				uma mensagem indicando a não existência desses contato

		int limite = 100;
		int cont = 0;
		String[] contado = new String[limite];
		int[] telefone = new int[limite];
		String menuInicial = "1 - Cadastrar contato\n2 - Buscar contato por nome\n3 - Buscar contato por telefone\n4 - Sair";
		int opc = 0;
		String menuCadastrar = "Cadastrando contato \n Inseri Nome e telefone da pessoa:";
		String alertaDeLimite = "O MEMORIA CHEIA.";

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menuInicial));
			// cadastrar:
			if (opc == 1) {
				if (cont < limite) {
					contado[cont] = JOptionPane.showInputDialog("Insira O nome do" + (cont + 1) + "° contato:");
					telefone[cont] = Integer
							.parseInt(JOptionPane.showInputDialog("Insira o  Telefone do " + (cont + 1) + "°contato:"));
					cont++;
				} else {
					JOptionPane.showMessageDialog(null, alertaDeLimite);
				}

			} else if (opc == 2) {
//					2 – Buscar contato por nome
				String buscarNome = JOptionPane.showInputDialog("Digite o Nome da pessoa :");
				boolean encontrou = false;
				for (int i = 0; i < cont; i++) {
					if (contado[i].equalsIgnoreCase(buscarNome)) {
						JOptionPane.showMessageDialog(null, "Nome: " + contado[i] + "\nTelefone: " + telefone[i]);
						encontrou = true;
						break;
					}
				}
				if (!encontrou) {
					JOptionPane.showMessageDialog(null, "Nome Não encontrado.");

				}
			} else if (opc == 3) {
				int buscarNumero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do telefone:"));
				boolean encontrou = false;
				for (int i = 0; i < cont; i++) {
					if (telefone[i] == buscarNumero) {
						JOptionPane.showMessageDialog(null, "Nome: " + contado[i] + "\nTelefone: " + telefone[i]);
						encontrou = true;
						break;

					}
				}
				if (!encontrou) {
					JOptionPane.showMessageDialog(null, "Telefone Não encontrado.");
				}
			}
		} while (opc != 4);
	}

}
