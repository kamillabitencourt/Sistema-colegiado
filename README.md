# Sistema de Colegiado

## Descrição
Este projeto foi desenvolvido para a disciplina de AP2 e consiste em um sistema de colegiado que gerencia disciplinas e alunos. O sistema permite a adição e remoção de alunos em disciplinas, bem como a listagem de alunos matriculados.

## Funcionalidades
- Cadastro de disciplinas.
- Cadastro de alunos.
- Matricula de alunos em disciplinas.
- Remoção de alunos de disciplinas.
- Listagem de disciplinas e seus respectivos alunos.

## Tecnologias Utilizadas
- Java (JDK 8+)
- Swing para a interface gráfica.
- Não foi utilizado banco de dados, todas as informações são manipuladas em tempo de execução.

## Estrutura do Projeto
O projeto é composto pelas seguintes classes:

### 1. `Disciplina.java`
- Representa uma disciplina.
- Possui atributos como código, nome e lista de alunos matriculados.
- Métodos para adicionar, remover e listar alunos matriculados.

### 2. `Aluno.java`
- Representa um aluno.
- Possui atributos como matrícula, nome e lista de disciplinas em que está matriculado.
- Métodos para adicionar, remover e listar disciplinas do aluno.

### 3. `Main.java`
- Classe principal do programa.
- Cria instâncias de disciplinas e alunos.
- Adiciona disciplinas padrão ao sistema.
- Inicia a interface gráfica do sistema.

### 4. `Interface.java`
- Gerencia a interface gráfica utilizando Swing.
- Permite a interação do usuário com o sistema.

## Como Executar
1. Certifique-se de ter o Java instalado.
2. Compile os arquivos Java:
   ```sh
   javac *.java
   ```
3. Execute a classe principal:
   ```sh
   java Main
   ```


