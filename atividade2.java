package br.Desafio2;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class atividade2 {
//	1 – Cadastrar Carro
//	2 – Verificar qual a marca e a placa do carro mais novo
//	3 – Buscar a marca e o ano por uma placa específica (o usuário irá informar a placa e o 
//	programa vai mostrar os dados caso encontre a respectiva placa).
//	4 - Sair
//	Para cadastrar o carro é necessário perguntar a marca, o ano de fabricação e a placa.
//	É possível cadastrar no máximo 20 carros.
//	Observação – Declarar o vetor com tamanho 20, mas controlar quantos carros foram 
//	cadastrados. A opção 1 do menu deve cadastrar um carro por vez.
	public static void main(String[] args) {
		int opc = 0;
		final int TAMANHO = 10;
		// modelos dos carros
		String[] marcas = new String[TAMANHO];
		// formatos das placas que possui letras e numeros
		String[] placas = new String[TAMANHO];
		// Anos dos carros
		int[] anos = new int[TAMANHO];
		int cont = 0;

		String menu = "𝟏 – 𝐂𝐚𝐝𝐚𝐬𝐭𝐫𝐚𝐫 𝐂𝐚𝐫𝐫𝐨 \n 𝟐 – 𝐕𝐞𝐫𝐢𝐟𝐢𝐜𝐚𝐫 𝐪𝐮𝐚𝐥 𝐚 𝐦𝐚𝐫𝐜𝐚 𝐞 𝐚 𝐩𝐥𝐚𝐜𝐚 𝐝𝐨 𝐜𝐚𝐫𝐫𝐨 𝐦𝐚𝐢𝐬 𝐧𝐨𝐯𝐨 \n 𝟑 – 𝐁𝐮𝐬𝐜𝐚𝐫 𝐚 𝐦𝐚𝐫𝐜𝐚 𝐞 𝐨 𝐚𝐧𝐨 𝐩𝐨𝐫 𝐮𝐦𝐚 𝐩𝐥𝐚𝐜𝐚 𝐞𝐬𝐩𝐞𝐜𝐢́𝐟𝐢𝐜𝐚. \n 𝟒 - 𝐒𝐚𝐢𝐫";

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opc) {
			case 1: {
				// cadastro
				if (cont < TAMANHO) {
					marcas[cont] = JOptionPane.showInputDialog("Modelo do carro:");
					placas[cont] = JOptionPane.showInputDialog("Qual a placa do " + marcas[cont] + " :");
					anos[cont] = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano do " + marcas[cont] + " :"));
					cont++;
					break;
				}else if(cont>=TAMANHO) {
					JOptionPane.showMessageDialog(null, "MEmoria Lotada!");
				}
			}
			case 2: {
//				Verificar qual a marca e a placa do carro mais novo
				int carMaisNovo = Integer.MAX_VALUE;
				String placaCarNovo = "";

				for (int i = 0; i < cont; i++) {
					if (anos[i]<carMaisNovo
							) {
						carMaisNovo = anos[i];
						placaCarNovo = marcas[i];

					}
				}
				JOptionPane.showMessageDialog(null, "O Carro Mais novo Registrado:\nModelo:"+placaCarNovo+"\nAnos:"+carMaisNovo);
				break;

			}
			case 3:{
//				Buscar a marca e o ano por uma placa específica 
				String buscaPlaca=JOptionPane.showInputDialog("Digite a Numeração da  Placa:");
				boolean encontrou=false;
				for(int i=0;i<cont;i++) {
					if(placas[i].equalsIgnoreCase(buscaPlaca)) {
						JOptionPane.showMessageDialog(null, "Carro está Registrado :\nModelo:"+marcas[i]+"\nPlaca:"+placas[i]+"\nAno:"+anos[i]);
						encontrou=true;
						break;
					}
				}
				if(!encontrou) {
					JOptionPane.showMessageDialog(null,"Placa não encontrada!\n Verifique que Digitou a Placa corretamente!");
				}
				
			}

			}

		} while (opc != 4);

	}

}
