import java.util.ArrayList;

/**
 * Classe aluno
 */
public class Aluno {
    private String matricula;
    private String nome;
    private ArrayList<Disciplina> disciplinas;

    /**
     * CONSTRUTOR
     * 
     * @param matricula
     * @param nome
     */
    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    /**
     * METODOS GETTERS E SETTERS
     * 
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona uma disciplina
     * 
     * @param disciplina
     */
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    /**
     * Remove disciplica
     */
    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    /**
     * Lista as disciplina
     * 
     * @return todas as disciplinas cadastradas no sistema
     */
    public ArrayList<Disciplina> listarDisciplinas() {
        return disciplinas;
    }
}
