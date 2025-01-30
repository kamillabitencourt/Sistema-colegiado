import java.util.ArrayList;

/**
 * Classe disciplina
 */
public class Disciplina {

    private String codigoDaMateria;
    private String nome;
    private ArrayList<Aluno> alunosMatriculados;

    /**
     * CONSTRUTOR
     * 
     * @param codigoDaMateria
     * @param nome
     */
    public Disciplina(String codigoDaMateria, String nome) {
        this.codigoDaMateria = codigoDaMateria;
        this.nome = nome;
        this.alunosMatriculados = new ArrayList<>();
    }

    /**
     * MÉTODOS GETTERS E SETTERS
     * 
     * @return
     */
    public String getcodigoDaMateria() {
        return codigoDaMateria;
    }

    public void setcodigoDaMateria(String codigoDaMateria) {
        this.codigoDaMateria = codigoDaMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona alunos a materia
     * 
     * @param aluno
     */
    public void adicionarAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
        }
    }

    /**
     * remove aluno da disciplina desejada
     */
    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    /**
     * lista de alunos matriculados na disciplina
     */
    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    /**
     * Quantidade de alunos matriculados na disciplina.
     */
    public int quantidadeAlunosMatriculados() {
        return alunosMatriculados.size();
    }
}
