package Model;

public class Usuario {
	
	private String nome;
    private String dt_nascimento;
    private String email;
    private String senha;

    public Usuario(String nome, String dt_nascimento, String email, String senha) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
