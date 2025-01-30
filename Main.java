import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        /**
         * TODAS AS MATERIAS OBRIGATÓRIAS FORAM ADICIONADAS NO SISTEMA
         */
        // PRIMEIRO SEMESTRE
        disciplinas.add(new Disciplina("DCET0723", "Algoritmos de programação 1"));
        disciplinas.add(new Disciplina("DCET0724", "Geometria analítica e vetorial"));
        disciplinas.add(new Disciplina("DELL0715", "Leitura e escrita de textos acadêmicos"));
        disciplinas.add(new Disciplina("DCET0725", "Matemática discreta"));
        disciplinas.add(new Disciplina("DCET0726", "Estatística e probabilidade para computação"));
        disciplinas.add(new Disciplina("DCET0221", "Cálculo diferencial e integral 1"));
        disciplinas.add(new Disciplina("DELL0716", "Inglês aplicado a computação 1"));

        // SEGUNDO SEMESTRE
        disciplinas.add(new Disciplina("DCET0731", "Lógica para computação"));
        disciplinas.add(new Disciplina("DCET0729", "Teoria dos grafos"));
        disciplinas.add(new Disciplina("DCET0727", "Algoritmo de programação 2 "));
        disciplinas.add(new Disciplina("DCET0732", "Física para computação 1 "));
        disciplinas.add(new Disciplina("DCET0730", "Fundamentos de sistema de informação"));
        disciplinas.add(new Disciplina("DCET0728", "Álgebra linear"));
        disciplinas.add(new Disciplina("DCET0222", "Cálculo diferencial e integral 2 "));

        // TERCEIRO SEMESTRE
        disciplinas.add(new Disciplina("DCET0733", "Algoritmo e estrutura de dados"));
        disciplinas.add(new Disciplina("DCET0740", "Linguagens formais e automatos "));
        disciplinas.add(new Disciplina("DCET0734", "Programaçõa concorrente"));
        disciplinas.add(new Disciplina("DCET0223", "Cálculo diferencial e integral 3 "));
        disciplinas.add(new Disciplina("DCET0737", " Circuitos digitais"));
        disciplinas.add(new Disciplina("DCET0736", "Interação humano-computador"));
        disciplinas.add(new Disciplina("DCET0738", "Física para computação 2"));

        // QUARTO SEMESTRE
        disciplinas.add(new Disciplina("DCET0742", "Engenharia de software"));
        disciplinas.add(new Disciplina("DCET0735", "Teoria da computação"));
        disciplinas.add(new Disciplina("DCET0739", "Programação Declarativa"));
        disciplinas.add(new Disciplina("DCET0743", "Arquitetura de computadores 1"));
        disciplinas.add(new Disciplina("DCET0741", "Redes de compuradores 1"));
        disciplinas.add(new Disciplina("DCET0744", "Banco de dados 1"));

        // QUINTO SEMESTRE
        disciplinas.add(new Disciplina("DCET0746", "Sistemas inteligentes"));
        disciplinas.add(new Disciplina("DCET0751", "Banco de dados 2 "));
        disciplinas.add(new Disciplina("DCET0748", "Analise e modelagem de sistemas"));
        disciplinas.add(new Disciplina("DCET0745", "PAradigmas de linguagem de programção"));
        disciplinas.add(new Disciplina("DCET0747", "Redes de compuradores 2"));
        disciplinas.add(new Disciplina("DCET0750", "Sistema operacional"));
        disciplinas.add(new Disciplina("DCET0749", "Arquitetura de computadores 2 "));

        // SEXTO SEMESTRE
        disciplinas.add(new Disciplina("DCET0753", "Analise de algoritmos"));
        disciplinas.add(new Disciplina("DCET0754", "Empreendedorismo"));
        disciplinas.add(new Disciplina("DCET0755", "Sistemas distribuidos"));
        disciplinas.add(new Disciplina("DFCH0796", "Métodos e tecnicas de pesquisa"));
        disciplinas.add(new Disciplina("DCET0752", "Compiladores"));

        // SETIMO SEMESTRE
        disciplinas.add(new Disciplina("DCET0756", "Trabalho supervisionado"));
        disciplinas.add(new Disciplina("DCSA0758", "Lesgilação e etica em computação"));
        disciplinas.add(new Disciplina("DCET0757", "Computação gráfica"));

        /**
         * CRIEI ALUNOS ALEATORIOS PARA COMPOR O CORPO DE ALUNOS, NAO COLOQUEI ELES EM
         * NENHUMA MATERIA
         * MAS NO SISTEMA É POSSIVEL ADICIONAR NOVOS ALUNOS OU MATRICULAR ELES NAS
         * MATERIAS
         */
        alunos.add(new Aluno("201911881", "Kamilla Bitencourt"));
        alunos.add(new Aluno("201911882", "Gabriela Santos "));
        alunos.add(new Aluno("201911883", "Luiz ALberto "));
        alunos.add(new Aluno("201911884", "Camila Fernandes"));
        alunos.add(new Aluno("201911885", "Helena Dias"));
        alunos.add(new Aluno("201911887", "Deliomar Rodrigues"));
        alunos.add(new Aluno("201911889", "Karine Victorelli"));
        alunos.add(new Aluno("201911886", "Wiliam Jesus"));
        alunos.add(new Aluno("201911890", "Leticia Da hora"));
        alunos.add(new Aluno("201911891", "Bruno Gabriel"));
        alunos.add(new Aluno("201911892", "Geovana Oliveira"));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface(disciplinas, alunos);
            }
        });
    }

}