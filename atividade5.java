package br.Desafio2;

import javax.swing.JOptionPane;

public class atividade5 {
	public static void main(String[] args) {
//		Criar um programa java que leia o preço e o estoque de N mercadorias 
//		Utilizar menu - máximo 50 mercadorias). Ao final o algoritmo deverá imprimir:
//		- Quantas mercadorias tem menos que 10 unidades no estoque
//		- Quantas mercadorias custam mais de 100 reais e tem estoque com mais de 10 unidades
//		- Qual o preço da mercadoria que tem o menor estoque
//		- Qual o estoque da mercadoria com maior preço
//		- O percentual das mercadorias que estão com o estoque zerado.
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de mercadoria"));
		double[] preco = new double[n];
		int[] estoque = new int[n];
		for (int i = 0; i < n; i++) {
			preco[i] = Double.parseDouble(JOptionPane.showInputDialog("Insira o Preço " + (i + 1) + " Produto"));
			estoque[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o estoque " + (i + 1) + " Produto"));
		}
		int estoqueMenosDez = 0, precoAcimaCem = 0, estoqueZerado = 0;
		double menorPreco = Double.MAX_VALUE;
		double maiorPreco = Double.MAX_VALUE;
		int maiorEstoque = Integer.MIN_VALUE;
		int indexMenorPreco = 0, indexMaiorPreco = 0;
		for(int i =0;i<n;i++) {
			//Comparando os estoques
			if(estoque[i]<10)estoqueMenosDez++;
			if(preco[i]>100&&estoque[i]>10)precoAcimaCem++;
			if(estoque[i]==0)estoqueZerado++;
			//comparando os preço
			if(preco[i]<menorPreco) {
				menorPreco=preco[i];
				indexMenorPreco=i;
			}
			if(preco[i]>maiorPreco) {
				maiorPreco=preco[i];
				indexMaiorPreco=i;
			}
//			
		}
//		- Quantas mercadorias tem menos que 10 unidades no estoque
//			- Quantas mercadorias custam mais de 100 reais e tem estoque com mais de 10 unidades
//			- Qual o preço da mercadoria que tem o menor estoque
			JOptionPane.showMessageDialog(null,"A quantidade de Mercadoria com estoque abaixo de 10 unidade:"+estoqueMenosDez
												+"\n A quantidade de Mercadoria com estoque alto e custa acima de 100$:"+precoAcimaCem
												+"\n A preço da mercadoria que tem o menor estoque:"+indexMenorPreco +"  que custa:"+menorPreco
												+"\n  A preço da mercadoria que tem o maior estoque:"+indexMaiorPreco + " que custa:"+maiorPreco
												+"\n O percentual das mercadorias que estão com o estoque zerado: "+((double)estoqueZerado/n)*100+"%");
			
	}

}
