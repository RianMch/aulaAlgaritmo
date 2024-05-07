


import javax.swing.JOptionPane;

public class principal {
	public static void main(String[] args) {
		Cadastro meucadastro=new Cadastro();
		String cadastros[]=new String[1];
		
		do {
			meucadastro.menu1();
			if(meucadastro.opc==1) {meucadastro.cadastro();
				
			}
			
		}while(meucadastro.opc!=2);
		
		
		
	
				
	}

}
