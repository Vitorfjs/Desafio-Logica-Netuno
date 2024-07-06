package Model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
	
	private Scanner scanner = new Scanner(System.in);
    private int classe = 0;
    private String ferramentaBatalha = "";
    private Avatar avatarAtual;
    private List<Avatar> avatares = new ArrayList<>(); // Salva toda a customização do avatar em uma lista

    // Método de escolha da classe de jogo
    public void classe() {

        System.out.println("----------------------------- ESCOLHA A CLASSE PARA JOGAR -----------------------------\n");
        System.out.println("[1] Paladino [Vida: 85, Mana: 35, Velocidade de Ataque: 1.25]");
        System.out.println("[2] Atirador [Vida: 70, Mana: 50, Velocidade de Ataque: 1.50]");
        System.out.println("[3] Guerreiro [Vida: 90, Mana: 30, Velocidade de Ataque: 1.20]");
        System.out.println("[4] Bárbaro [Vida: 95, Mana: 20, Velocidade de Ataque: 1.15]");
        System.out.println("[5] Arqueiro [Vida: 75, Mana: 45, Velocidade de Ataque: 1.30]");
        classe = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (classe) {
            case 1:
                System.out.println("Paladino selecionado");
                System.out.println("Escolha sua ferramenta de batalha:");
                String[] ferramentasPaladino = {"Lança", "Escudo"};
                ferramentaBatalha = selecionarOpcao(ferramentasPaladino);
                break;
            case 2:
                System.out.println("Atirador selecionado");
                System.out.println("Escolha sua arma:");
                String[] armasAtirador = {"Pistola", "Rifle"};
                ferramentaBatalha = selecionarOpcao(armasAtirador);
                break;
            case 3:
                System.out.println("Guerreiro selecionado");
                System.out.println("Escolha sua ferramenta de batalha:");
                String[] ferramentasGuerreiro = {"Espada", "Escudo"};
                ferramentaBatalha = selecionarOpcao(ferramentasGuerreiro);
                break;
            case 4:
                System.out.println("Bárbaro selecionado");
                System.out.println("Escolha sua ferramenta de batalha:");
                String[] ferramentasBarbaro = {"Machado", "Marreta"};
                ferramentaBatalha = selecionarOpcao(ferramentasBarbaro);
                break;
            case 5:
                System.out.println("Arqueiro selecionado");
                System.out.println("Escolha seu arco:");
                String[] arcosArqueiro = {"Arco Longo", "Arco Curto"};
                ferramentaBatalha = selecionarOpcao(arcosArqueiro);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
		
        // Delay de 2 segundos após fim da interação no método
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		// Limpa a tela
		clearConsole();
		cadastrarAvatar(); // Chamada do próximo método
		
	}
	
    // Método de cadastro das customizações do avatar
	public Avatar cadastrarAvatar() {
		Avatar avatar = new Avatar();
		
		System.out.println("----------------------------- CADASTRO DO AVATAR -----------------------------\n");
		
		System.out.println("Selecione a cor de cabelo:");
        String[] coresCabelo = {"Preto", "Castanho", "Loiro", "Ruivo", "Branco"};
        avatar.setCorCabelo(selecionarOpcao(coresCabelo));

        System.out.println("Selecione o estilo de cabelo:");
        String[] estilosCabelo = {"Curto", "Médio", "Longo", "Cacheado", "Liso"};
        avatar.setEstiloCabelo(selecionarOpcao(estilosCabelo));

        System.out.println("Selecione a cor de pele:");
        String[] coresPele = {"Branca", "Negra", "Parda", "Amarela"};
        avatar.setCorPele(selecionarOpcao(coresPele));

        System.out.println("Selecione a cor dos olhos:");
        String[] coresOlhos = {"Castanhos", "Azuis", "Verdes", "Pretos"};
        avatar.setCorOlhos(selecionarOpcao(coresOlhos));

        System.out.print("Altura (em cm): ");
        avatar.setAltura(scanner.nextLine());

        System.out.print("Peso (em kg): ");
        avatar.setPeso(scanner.nextLine());

        System.out.println("Selecione o tipo de corpo:");
        String[] tiposCorpo = {"Magro", "Atlético", "Normal", "Forte"};
        avatar.setTipoCorpo(selecionarOpcao(tiposCorpo));

        System.out.println("Selecione o tipo de roupa:");
        String[] tiposRoupa = {"Esportiva", "Casual", "Formal", "Tradicional"};
        avatar.setRoupa(selecionarOpcao(tiposRoupa));
        
        avatarAtual = avatar; // Armazena o avatar atual para exibição posterior
        
        // Chamada do método para selecionar a montaria
        selecionarMontaria();
        
        avatares.add(avatar);
        System.out.println("Avatar cadastrado com sucesso!");
		
        // Delay de 2 segundos após fim da interação no método
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
        // Limpa a tela 
		clearConsole();
        
		// Encerra o método
		return avatar;
	}
	
	// Método de seleção da montaria
	public void selecionarMontaria() {
	    System.out.println("Selecione a montaria:");
	    String[] montarias = {
	        "Panda [Velocidade: 2m/s, Tempo para descanso: 10 minutos]",
	        "Cavalo [Velocidade: 5m/s, Tempo para descanso: 5 minutos]",
	        "Dragão [Velocidade: 8m/s, Tempo para descanso: 15 minutos]",
	        "Lobo [Velocidade: 4m/s, Tempo para descanso: 7 minutos]",
	        "Unicórnio [Velocidade: 6m/s, Tempo para descanso: 8 minutos]"
	    };

	    for (int i = 0; i < montarias.length; i++) {
	        System.out.println("[" + (i + 1) + "] " + montarias[i]);
	    }

	    int escolha = scanner.nextInt();
	    scanner.nextLine(); // Limpa o buffer

	    while (escolha < 1 || escolha > montarias.length) {
	        System.out.println("Opção inválida. Tente novamente.");
	        escolha = scanner.nextInt();
	        scanner.nextLine(); // Limpa o buffer
	    }

	    avatarAtual.setMontaria(montarias[escolha - 1]);
	    System.out.println("Montaria selecionada com sucesso!");

	    // Delay de 2 segundos após fim da interação no método
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    clearConsole(); // Limpa  tela
	    exibirInformacoes(); // Chama o próximo método
	    System.exit(0);
	}
	
	// Método para selecionar uma opção de um array de strings
    private String selecionarOpcao(String[] opcoes) {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println("[" + (i + 1) + "] " + opcoes[i]);
        }
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        while (escolha < 1 || escolha > opcoes.length) {
            System.out.println("Opção inválida. Tente novamente.");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
        }
        return opcoes[escolha - 1];
    }
    
    // Método que exibe a classe e a ferramenta escolhidas
    public void exibirInformacoes() {
        if (avatarAtual != null) {
            System.out.println("----------------------------- INFORMAÇÕES DO JOGADOR -----------------------------");
            System.out.println("Classe escolhida: " + getNomeClasse());
            exibirAtributosClasse(); // Exibe os atributos da classe escolhida
            System.out.println("Ferramenta de batalha: " + ferramentaBatalha);
            exibirInformacoesAvatar(); // Chama o próximo método
        } else {
            System.out.println("Nenhum avatar cadastrado ainda.");
        }
        
    }
    
    private String getNomeClasse() {
        switch (classe) {
            case 1: return "Paladino";
            case 2: return "Atirador";
            case 3: return "Guerreiro";
            case 4: return "Bárbaro";
            case 5: return "Arqueiro";
            default: return "Classe inválida";
        }
    }
    
    // Método que exibe as customizações escolhidas pelo jogador
    private void exibirInformacoesAvatar() {
        System.out.println("Avatar: ");
        System.out.println("  Cor de cabelo: " + avatarAtual.getCorCabelo());
        System.out.println("  Estilo de cabelo: " + avatarAtual.getEstiloCabelo());
        System.out.println("  Cor de pele: " + avatarAtual.getCorPele());
        System.out.println("  Cor dos olhos: " + avatarAtual.getCorOlhos());
        System.out.println("  Altura: " + avatarAtual.getAltura() + " cm");
        System.out.println("  Peso: " + avatarAtual.getPeso() + " kg");
        System.out.println("  Tipo de corpo: " + avatarAtual.getTipoCorpo());
        System.out.println("  Roupa: " + avatarAtual.getRoupa());
        System.out.println("  Montaria: " + avatarAtual.getMontaria());
    }
    
    // Método que exibe os atributos da classe dependendo da escolha do jogador
    private void exibirAtributosClasse() {
        switch (classe) {
            case 1:
                System.out.println("Atributos: Vida: 85, Mana: 35, Velocidade de Ataque: 1.25");
                break;
            case 2:
                System.out.println("Atributos: Vida: 70, Mana: 50, Velocidade de Ataque: 1.50");
                break;
            case 3:
                System.out.println("Atributos: Vida: 90, Mana: 30, Velocidade de Ataque: 1.20");
                break;
            case 4:
                System.out.println("Atributos: Vida: 95, Mana: 20, Velocidade de Ataque: 1.15");
                break;
            case 5:
                System.out.println("Atributos: Vida: 75, Mana: 45, Velocidade de Ataque: 1.30");
                break;
        }
    }
    
    // Método que exibe os atributos da montaria de acordo com a escolha do jogador
    private void exibirAtributosMontaria() {
        switch (avatarAtual.getMontaria()) {
            case "Panda":
                System.out.println("Atributos da Montaria: Velocidade: 2m/s, Tempo para descanso: 10 minutos");
                break;
            case "Cavalo":
                System.out.println("Atributos da Montaria: Velocidade: 5m/s, Tempo para descanso: 5 minutos");
                break;
            case "Dragão":
                System.out.println("Atributos da Montaria: Velocidade: 8m/s, Tempo para descanso: 15 minutos");
                break;
            case "Lobo":
                System.out.println("Atributos da Montaria: Velocidade: 4m/s, Tempo para descanso: 7 minutos");
                break;
            case "Unicórnio":
                System.out.println("Atributos da Montaria: Velocidade: 6m/s, Tempo para descanso: 8 minutos");
                break;
        }
    }
    
    // Salva os avatares criados em uma lista
    public List<Avatar> getAvatares() {
        return avatares;
    }
	
    // Pula 100 linhas afim de "limpar" a tela
	public void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
	
}
