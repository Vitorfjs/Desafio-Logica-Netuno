package View;

import Model.Cadastro;
import Model.Inicial;
import Model.Login;

public class Main {

    public static void main(String[] args) {
        // Instanciar a classe Inicial
        Inicial inicial = new Inicial();

        // Criar instâncias de Login e Cadastro
        Cadastro cadastro = new Cadastro();
        Login login = new Login(cadastro);

        // Chamada o método inicio() da classe Inicial
        inicial.inicio();
    }

}