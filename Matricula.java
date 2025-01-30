import java.util.Date;

/**
 * Classe matricula
 */
public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private Date data;

    /**
     * CONSTRUTOR
     * 
     * @param aluno
     * @param disciplina
     * @param data
     */
    public Matricula(Aluno aluno, Disciplina disciplina, Date data) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.data = data;

        aluno.adicionarDisciplina(disciplina);
        disciplina.adicionarAluno(aluno);
    }

    /**
     * METODOS GETTERS E SETTERS
     * 
     * @return
     */
    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Date getData() {
        return data;
    }

    /**
     * Remove o aluno da disciplina
     */
    public void removerMatricula() {
        aluno.removerDisciplina(disciplina);
        disciplina.removerAluno(aluno);
    }
}
