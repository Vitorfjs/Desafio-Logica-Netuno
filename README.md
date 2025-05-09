# 🎮 Game Registration & Avatar Selector

Aplicativo Java que permite aos usuários se registrarem, fazer login, escolher classe e personalizar um avatar antes de iniciar a jogabilidade.

---

## 📋 Sumário

1. [Visão Geral](#visão-geral)  
2. [Funcionalidades](#funcionalidades)  
3. [Tecnologias](#tecnologias)  
4. [Estrutura do Projeto](#estrutura-do-projeto)  
5. [Pré-requisitos](#pré-requisitos)   

---

## 🕹️ Visão Geral

Este projeto simula o fluxo inicial de um jogo:  
- **Registro** de novos usuários  
- **Login** de usuários cadastrados  
- **Seleção de Classe** (ex.: Guerreiro, Mago, Arqueiro)  
- **Personalização de Avatar** (escolha de roupa, cor, acessórios)  
- **Início do Jogo** após configuração do avatar  

É uma aplicação desktop desenvolvida em Java (Eclipse/NetBeans), com foco em lógica de negócio, persistência simples em arquivo e interface gráfica Swing.

---

## ✨ Funcionalidades

- **Registro de Usuário**  
  - Cria nova conta fornecendo nome, email e senha.  
- **Autenticação**  
  - Validações de login (email + senha).  
- **Seleção de Classe**  
  - Opções: Guerreiro, Mago, Arqueiro (cada classe com atributos iniciais).  
- **Customização de Avatar**  
  - Escolha de cor de roupa, estilo de cabelo e acessórios.  
- **Fluxo de Inicialização**  
  - Após escolher avatar, exibe tela de boas‑vindas e “Iniciar Jogo”.  
- **Persistência Simples**  
  - Usuários e configurações salvos em arquivo local (JSON ou serialização).  

---

## 🛠 Tecnologias

- **Linguagem**: Java 8+  
- **IDE**: Eclipse (ou NetBeans)  
- **GUI**: Swing  
- **Persistência**:  
  - Leitura/gravação de arquivos JSON via `Jackson` _ou_ serialização Java nativa  
- **Build**: Maven (pom.xml) ou Ant  

---

## 📂 Estrutura do Projeto

| Caminho                                 | Tipo / Descrição                             |
| --------------------------------------- | -------------------------------------------- |
| `Projeto/src/Model/Cadastro.java`       | Classe responsável pelo cadastro de usuários |
| `Projeto/src/Model/Login.java`          | Classe que implementa lógica de autenticação |
| `Projeto/src/Model/Jogo.java`           | Classe que controla o fluxo do jogo          |
| `Projeto/src/Model/Inicial.java`        | Classe com lógica de inicialização do app    |
| `Projeto/src/Model/Usuario.java`        | Modelo de dados do usuário                   |
| `Projeto/src/Model/Avatar.java`         | Modelo de dados do avatar do usuário         |
| `Projeto/src/View/Main.java`            | Ponto de entrada e interface gráfica (Swing) |
| `Projeto/README.md`                     | Documentação principal do projeto            |
| `Projeto/outros arquivos e diretórios`  | Dependências, configurações e assets         |


---

## ⚙️ Pré‑requisitos

- Java JDK 8 ou superior instalado  
- Maven (se usar Maven) ou Ant  
- IDE Java (Eclipse, IntelliJ IDEA ou NetBeans)
  
