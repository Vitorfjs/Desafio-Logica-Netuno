package Model;

import java.util.Scanner;

public class Login {

    private Cadastro cadastro;
    private Jogo jogo = new Jogo(); // Instância de Jogo
    private Scanner scanner = new Scanner(System.in);

    public Login(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public void login() {
        int tentativas = 3; // Número máximo de tentativas de login

        while (tentativas > 0) {
            System.out.println("----------------------------- TELA DE LOGIN -----------------------------\n");

            System.out.print("E-mail: ");
            String emailLogin = scanner.nextLine();

            System.out.print("Senha: ");
            String senhaLogin = scanner.nextLine();

            boolean loginSucesso = false;

            for (Usuario usuario : cadastro.getUsuarios()) {
                if (usuario.getEmail().equals(emailLogin) && usuario.getSenha().equals(cadastro.hashSenha(senhaLogin))) {
                    loginSucesso = true;
                    break;
                }
            }

            if (loginSucesso) {
                System.out.println("Login realizado com sucesso!");
                // Direciona para a tela do jogo
                jogo.classe(); // Chama o método classe de Jogo após o login
                return; // Sai do método login após o sucesso
            } else {
                tentativas--;
                System.out.println("Email ou senha incorretos. Você tem " + tentativas + " tentativa(s) restante(s).");
            }

            if (tentativas == 0) {
                System.out.println("Número máximo de tentativas alcançado. O programa será encerrado.");
                System.exit(0); // Encerra o programa
            }
        }
    }
}
