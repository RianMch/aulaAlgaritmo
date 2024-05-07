
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cadastro extends principal {
    private String[] nome = new String[100];
    private int[] anoDeLancamento = new int[100];
    private boolean[] incluidoNoPlano = new boolean[100];
    private double[] avaliacao = new double[100];
    private int[] totalDeAvaliacoes = new int[100];
    private int[] duracaoEmhora = new int[100];
    private String[] empresa = new String[100];
    private List<String[]> consolesList = new ArrayList<>();
    private int count = 0;
    public static int opc;
    private static String menu;

    public static int menu1() {
        menu = "1 - Cadastro";
        return opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public String getNome(int count) {
        return nome[count];
    }

    public static void invalido() {
        JOptionPane.showMessageDialog(null, "Cadastro inválido");
    }

    private static void memoriaCheia() {
        JOptionPane.showMessageDialog(null, "Cadastro cheio");
    }

    public void cadastro() {
        if (count < 100) {
            nome[count] = JOptionPane.showInputDialog("Cadastre o nome do Jogo:");
            if (nome[count] != null && !nome[count].isEmpty()) {
                empresa[count] = JOptionPane.showInputDialog("Empresa do Jogo:");
                if (empresa[count] != null && !empresa[count].isEmpty()) {
                    int qtddParaConsole = Integer.parseInt(JOptionPane.showInputDialog("Quantas plataformas o jogo vai ter:"));
                    if (qtddParaConsole > 0) {
                        String[] consolesParaJogo = new String[qtddParaConsole];
                        for (int i = 0; i < qtddParaConsole; i++) {
                            consolesParaJogo[i] = JOptionPane.showInputDialog("Qual a " + (i + 1) + "ª plataforma:");
                        }
                        consolesList.add(consolesParaJogo);
                        anoDeLancamento[count] = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento:"));
                        if (anoDeLancamento[count] != 0) {
                            duracaoEmhora[count] = Integer.parseInt(JOptionPane.showInputDialog("Duração em horas:"));
                            if (duracaoEmhora[count] != 0) {
                                int plano = JOptionPane.showOptionDialog(null, "Deseja colocar no plano de jogo?",
                                        "Plano de Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                        null, null, null);
                                incluidoNoPlano[count] = (plano == JOptionPane.YES_OPTION);
                                count++;
                                cadastroConcluido(nome, anoDeLancamento, incluidoNoPlano, count, duracaoEmhora, consolesParaJogo, empresa);
                            } else {
                                invalido();
                                count--;
                            }
                        } else {
                            invalido();
                            count--;
                        }
                    } else {
                        invalido();
                        count--;
                    }
                } else {
                    invalido();
                    count--;
                }
            } else {
                invalido();
                count--;
            }
        } else {
            memoriaCheia();
        }
    }

    private static void cadastroConcluido(String[] nome, int[] anoDeLancamento, boolean[] incluidoNoPlano, int count,
                                          int[] duracaoEmhora, String[] console, String[] empresa) {
        menu = "Cadastro concluído!" +
                "\nNome: " + nome[count - 1] +
                "\nEmpresa: " + empresa[count - 1] +
                "\nAno de Lançamento: " + anoDeLancamento[count - 1] +
                "\nDuração em Horas: " + duracaoEmhora[count - 1] +
                "\nPlataformas:";
        for (String plataforma : console) {
            menu += "\n- " + plataforma;
        }
        menu += "\nPlano de Jogo: " + (incluidoNoPlano[count - 1] ? "Sim" : "Não");
        JOptionPane.showMessageDialog(null, menu);
    }
}

