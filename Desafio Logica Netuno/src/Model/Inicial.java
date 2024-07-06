package Model;

import java.util.Scanner;

public class Inicial {

    private Cadastro cadastro = new Cadastro();
    private Login login = new Login(cadastro);
    private Jogo jogo = new Jogo();
    private int esc;

    // Menu da tela inicial
    public void inicio() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------------------------- TELA INICIAL -----------------------------");
            System.out.println("[1] LOGIN");
            System.out.println("[2] CADASTRE-SE");
            System.out.println("[0] SAIR");

            esc = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (esc) {
                case 1:
                    login.login(); // Direciona para tela de login
                    jogo.clearConsole(); 
                    break;
                case 2:
                    cadastro.cadastrarUsuario(login); // Direciona para tela de cadastro
                    jogo.clearConsole();
                    break;
                case 0:
                    System.out.println("Saindo do programa..."); 
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (esc != 1 && esc != 2);
    }

    public int getEsc() {
        return esc;
    }

    public void setEsc(int esc) {
        this.esc = esc;
    }
}