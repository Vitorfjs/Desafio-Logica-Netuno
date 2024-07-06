package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {

    private List<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Criação do cadastro do usuário
    public void cadastrarUsuario(Login login) {
        do {
            System.out.println("----------------------------- TELA DE CADASTRO -----------------------------\n");

            System.out.print("Nome completo: ");
            String nome = scanner.nextLine();

            System.out.print("\nData de nascimento(dd/mm/aaaa): ");
            String dt_nascimento = scanner.nextLine();

            System.out.print("\nE-mail: ");
            String email = scanner.nextLine();

            System.out.print("\nSenha: ");
            String senha = scanner.nextLine();

            System.out.print("\nConfirmação de senha: ");
            String senhaConfirm = scanner.nextLine();

            while (!senhaConfirm.equals(senha)) {
                System.out.println("As senhas são diferentes. Tente novamente.");
                System.out.print("Confirmação de senha: ");
                senhaConfirm = scanner.nextLine();
            }

            // Transformando a senha para um tipo hash
            String senhaHash = hashSenha(senha);

            usuarios.add(new Usuario(nome, dt_nascimento, email, senhaHash));

            System.out.println("Usuário cadastrado com sucesso!");

            System.out.println("\nDeseja cadastrar outro usuário? (s/n): ");
            String continuar = scanner.nextLine();

            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        } while (true);

        login.login(); // Chama o método de login após o cadastro ser bem sucedido
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    // Método que trasnforma a senha em hash
    String hashSenha(String senha) {
    	 try {
             MessageDigest md = MessageDigest.getInstance("SHA-256");
             byte[] hashBytes = md.digest(senha.getBytes());
             StringBuilder sb = new StringBuilder();
             for (byte b : hashBytes) {
                 sb.append(String.format("%02x", b));
             }
             return sb.toString();
         } catch (NoSuchAlgorithmException e) {
             throw new RuntimeException(e);
         }
    }
}