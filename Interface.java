import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Interface {

    private JFrame frame;
    private JButton cadastrarDisciplinaBotao;
    private JButton cadastrarAlunoBotao;
    private JButton matricularAlunoBotao;
    private JButton listarDisciplinasBotao;
    private JButton listarAlunosBotao;
    private JButton botaoVoltar;
    private JButton botaoExcluirMatricula;
    private JButton botaoExcluirDisciplina;
    private JButton botaoExcluiAluno;
    private JPanel telaInicial;
    private JPanel painelDisciplina;
    private JPanel painelAluno;
    private JPanel painelMatricula;
    private JPanel painelListagem;

    private ArrayList<Disciplina> disciplinasCadastradas;
    private ArrayList<Aluno> alunosCadastrados;

    public Interface(ArrayList<Disciplina> disciplinas, ArrayList<Aluno> alunos) {
        disciplinasCadastradas = disciplinas;
        alunosCadastrados = alunos;

        /**
         * Configuração da tela principal
         */

        frame = new JFrame("Sistema do colegiado de Ciência da computação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        telaInicial = new JPanel(new GridLayout(4, 2));
        /**
         * Inicializa todos os botoes
         */
        cadastrarDisciplinaBotao = new JButton("Cadastrar disciplina");
        cadastrarAlunoBotao = new JButton("Cadastrar aluno");
        matricularAlunoBotao = new JButton("Matricular aluno em disciplina");
        listarDisciplinasBotao = new JButton("Listar as disciplinas");
        listarAlunosBotao = new JButton("Listar alunos por disciplina");
        botaoExcluirMatricula = new JButton("Excluir matrícula");
        botaoExcluirDisciplina = new JButton("Excluir Disciplina");
        botaoExcluiAluno = new JButton("Excluir Aluno");
        /**
         * Adiciona os botoes da tela principal
         */
        telaInicial.add(cadastrarDisciplinaBotao);
        telaInicial.add(cadastrarAlunoBotao);
        telaInicial.add(matricularAlunoBotao);
        telaInicial.add(listarDisciplinasBotao);
        telaInicial.add(listarAlunosBotao);
        telaInicial.add(botaoExcluirMatricula);
        telaInicial.add(botaoExcluirDisciplina);
        telaInicial.add(botaoExcluiAluno);

        frame.add(telaInicial);

        cadastrarDisciplinaBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirCadastroDisciplina();
            }
        });
        /**
         * Todas as ações dos botoes
         */
        cadastrarAlunoBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirCadastroAluno();
            }
        });

        matricularAlunoBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirMatriculaAluno();
            }
        });

        listarDisciplinasBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListagemDisciplinas();
            }
        });

        listarAlunosBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListagemAlunosPorDisciplina();
            }
        });
        botaoExcluirMatricula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirExcluirMatricula();
            }
        });
        botaoExcluirDisciplina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirExcluirDisciplina();
            }
        });
        botaoExcluiAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirExcluirAluno();
            }
        });

        frame.setVisible(true);
    }

    private void exibirCadastroDisciplina() {
        limparTela();
        painelDisciplina = new JPanel(new BorderLayout());
        JPanel disciplinaInputPanel = new JPanel(new GridLayout(0, 2));
        disciplinaInputPanel.setBorder(BorderFactory.createTitledBorder("Cadastro de Disciplina"));

        JTextField codigoDisciplina = new JTextField(10);
        JTextField nomeDisciplina = new JTextField(20);
        JButton cadastrarDisciplinaBotao = new JButton("Cadastrar");
        botaoVoltar = new JButton("Voltar");

        disciplinaInputPanel.add(new JLabel("Código:"));
        disciplinaInputPanel.add(codigoDisciplina);
        disciplinaInputPanel.add(new JLabel("Nome:"));
        disciplinaInputPanel.add(nomeDisciplina);
        disciplinaInputPanel.add(cadastrarDisciplinaBotao);
        disciplinaInputPanel.add(botaoVoltar);

        painelDisciplina.add(disciplinaInputPanel, BorderLayout.NORTH);

        frame.add(painelDisciplina, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        cadastrarDisciplinaBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoDisciplina.getText();
                String nome = nomeDisciplina.getText();

                boolean codigoJaExistente = disciplinasCadastradas.stream()
                        .anyMatch(d -> d.getcodigoDaMateria().equals(codigo));

                if (codigoJaExistente) {
                    JOptionPane.showMessageDialog(frame, "Código já cadastrado!!!");
                } else {
                    Disciplina novaDisciplina = new Disciplina(codigo, nome);
                    disciplinasCadastradas.add(novaDisciplina);
                    JOptionPane.showMessageDialog(frame, "Disciplina cadastrada: " + nome);
                    codigoDisciplina.setText("");
                    nomeDisciplina.setText("");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirCadastroAluno() {
        limparTela();
        painelAluno = new JPanel(new BorderLayout());
        JPanel alunoPainelEnt = new JPanel(new GridLayout(0, 2));
        alunoPainelEnt.setBorder(BorderFactory.createTitledBorder("Cadastro de Aluno"));

        JTextField codigoDisciplina = new JTextField(20);
        JTextField nomeAluno = new JTextField(20);
        JButton cadastrarAlunoBotao = new JButton("Cadastrar");
        botaoVoltar = new JButton("Voltar");

        alunoPainelEnt.add(new JLabel("Matrícula:"));
        alunoPainelEnt.add(codigoDisciplina);
        alunoPainelEnt.add(new JLabel("Nome:"));
        alunoPainelEnt.add(nomeAluno);
        alunoPainelEnt.add(cadastrarAlunoBotao);
        alunoPainelEnt.add(botaoVoltar);

        painelAluno.add(alunoPainelEnt, BorderLayout.NORTH);

        frame.add(painelAluno, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        cadastrarAlunoBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matricula = codigoDisciplina.getText();
                String nome = nomeAluno.getText();

                boolean matriculaJaExistente = alunosCadastrados.stream()
                        .anyMatch(a -> a.getMatricula().equals(matricula));

                if (matriculaJaExistente) {
                    JOptionPane.showMessageDialog(frame, "Número de matricula já consta no sistema! ");
                } else {
                    Aluno novoAluno = new Aluno(matricula, nome);
                    alunosCadastrados.add(novoAluno);
                    JOptionPane.showMessageDialog(frame, "Aluno cadastrado: " + nome);
                    codigoDisciplina.setText("");
                    nomeAluno.setText("");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirMatriculaAluno() {
        limparTela();
        painelMatricula = new JPanel(new GridLayout(0, 1));
        painelMatricula.setBorder(BorderFactory.createTitledBorder("Matrícula de Aluno"));

        String[] alunos = alunosCadastrados.stream()
                .map(Aluno::getNome)
                .toArray(String[]::new);
        JComboBox<String> alunosComboBox = new JComboBox<>(alunos);

        String[] disciplinas = disciplinasCadastradas.stream()
                .map(Disciplina::getNome)
                .toArray(String[]::new);
        JComboBox<String> disciplinasComboBox = new JComboBox<>(disciplinas);

        JButton matricularAlunoBotao = new JButton("Matricular");
        botaoVoltar = new JButton("Voltar");
        painelMatricula.add(new JLabel("Selecione o aluno: "));
        painelMatricula.add(alunosComboBox);
        painelMatricula.add(new JLabel("Selecione a disciplina: "));
        painelMatricula.add(disciplinasComboBox);
        painelMatricula.add(matricularAlunoBotao);
        painelMatricula.add(botaoVoltar);
        frame.add(painelMatricula, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        matricularAlunoBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alunoSelecionado = (String) alunosComboBox.getSelectedItem();
                String disciplinaSelecionada = (String) disciplinasComboBox.getSelectedItem();

                if (alunoSelecionado != null && disciplinaSelecionada != null) {
                    Aluno aluno = alunosCadastrados.stream()
                            .filter(a -> a.getNome().equals(alunoSelecionado))
                            .findFirst()
                            .orElse(null);

                    Disciplina disciplina = disciplinasCadastradas.stream()
                            .filter(d -> d.getNome().equals(disciplinaSelecionada))
                            .findFirst()
                            .orElse(null);

                    if (aluno != null && disciplina != null) {
                        java.util.Date dataAtual = new java.util.Date();
                        @SuppressWarnings("unused")
                        Matricula matricula = new Matricula(aluno, disciplina, dataAtual);
                        JOptionPane.showMessageDialog(frame,
                                aluno.getNome() + " foi matriculado(a) na disciplina de  " + disciplina.getNome());
                    }
                }
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirListagemDisciplinas() {
        limparTela();
        painelListagem = new JPanel(new BorderLayout());
        painelListagem.setBorder(BorderFactory
                .createTitledBorder("Lista de todas as disciplinas obrigatórias do Curso de ciência da computação "));

        JTextArea areaDeTexto = new JTextArea(15, 30);
        areaDeTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaDeTexto);

        StringBuilder sb = new StringBuilder();
        for (Disciplina disciplina : disciplinasCadastradas) {
            sb.append("Código: ").append(disciplina.getcodigoDaMateria()).append("\n")
                    .append("Nome: ").append(disciplina.getNome()).append("\n\n");
        }
        areaDeTexto.setText(sb.toString());
        botaoVoltar = new JButton("Voltar");
        painelListagem.add(scrollPane, BorderLayout.CENTER);
        painelListagem.add(botaoVoltar, BorderLayout.SOUTH);
        frame.add(painelListagem, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirListagemAlunosPorDisciplina() {
        limparTela();
        painelListagem = new JPanel(new BorderLayout());
        painelListagem.setBorder(BorderFactory.createTitledBorder("Lista de alunos por disciplina"));

        JPanel disciplinaInputPanel = new JPanel(new GridLayout(0, 2));
        JComboBox<String> disciplinasComboBox = new JComboBox<>(disciplinasCadastradas.stream()
                .map(Disciplina::getNome)
                .toArray(String[]::new));
        JButton listarAlunosBotao = new JButton("Listar alunos");
        botaoVoltar = new JButton("Voltar");

        disciplinaInputPanel.add(new JLabel("Selecione a disciplina:"));
        disciplinaInputPanel.add(disciplinasComboBox);
        disciplinaInputPanel.add(listarAlunosBotao);
        disciplinaInputPanel.add(botaoVoltar);

        JTextArea areaDeTexto = new JTextArea(20, 30);
        areaDeTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaDeTexto);

        painelListagem.add(disciplinaInputPanel, BorderLayout.NORTH);
        painelListagem.add(scrollPane, BorderLayout.CENTER);

        frame.add(painelListagem, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        listarAlunosBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String disciplinaSelecionada = (String) disciplinasComboBox.getSelectedItem();
                if (disciplinaSelecionada != null) {
                    Disciplina disciplina = disciplinasCadastradas.stream()
                            .filter(d -> d.getNome().equals(disciplinaSelecionada))
                            .findFirst()
                            .orElse(null);

                    if (disciplina != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Alunos matriculados na disciplina ").append(disciplina.getNome()).append(":\n\n");
                        for (Aluno aluno : disciplina.getAlunosMatriculados()) {
                            sb.append(aluno.getNome()).append("\n");
                        }
                        areaDeTexto.setText(sb.toString());
                    }
                }
            }
        });
        listarAlunosBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String disciplinaSelecionada = (String) disciplinasComboBox.getSelectedItem();
                if (disciplinaSelecionada != null) {
                    Disciplina disciplina = disciplinasCadastradas.stream()
                            .filter(d -> d.getNome().equals(disciplinaSelecionada))
                            .findFirst()
                            .orElse(null);

                    if (disciplina != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Alunos matriculados na disciplina ").append(disciplina.getNome()).append(":\n\n");
                        for (Aluno aluno : disciplina.getAlunosMatriculados()) {
                            sb.append(aluno.getNome()).append("\n");
                        }
                        sb.append("\nQuantidade de alunos: ").append(disciplina.quantidadeAlunosMatriculados());

                        areaDeTexto.setText(sb.toString());
                    }
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirExcluirMatricula() {
        limparTela();
        painelMatricula = new JPanel(new GridLayout(0, 1));
        painelMatricula.setBorder(BorderFactory.createTitledBorder("Excluir matrícula em disciplina"));

        String[] alunos = alunosCadastrados.stream()
                .map(Aluno::getNome)
                .toArray(String[]::new);
        JComboBox<String> alunosComboBox = new JComboBox<>(alunos);

        String[] disciplinas = disciplinasCadastradas.stream()
                .map(Disciplina::getNome)
                .toArray(String[]::new);
        JComboBox<String> disciplinasComboBox = new JComboBox<>(disciplinas);

        JButton botaoExcluirMatricula = new JButton("Excluir Matrícula em disciplina ");
        botaoVoltar = new JButton("Voltar");

        painelMatricula.add(new JLabel("Selecione o aluno:"));
        painelMatricula.add(alunosComboBox);
        painelMatricula.add(new JLabel("Selecione a disciplina:"));
        painelMatricula.add(disciplinasComboBox);
        painelMatricula.add(botaoExcluirMatricula);
        painelMatricula.add(botaoVoltar);

        frame.add(painelMatricula, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        botaoExcluirMatricula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alunoSelecionado = (String) alunosComboBox.getSelectedItem();
                String disciplinaSelecionada = (String) disciplinasComboBox.getSelectedItem();

                if (alunoSelecionado != null && disciplinaSelecionada != null) {
                    Aluno aluno = alunosCadastrados.stream()
                            .filter(a -> a.getNome().equals(alunoSelecionado))
                            .findFirst()
                            .orElse(null);

                    Disciplina disciplina = disciplinasCadastradas.stream()
                            .filter(d -> d.getNome().equals(disciplinaSelecionada))
                            .findFirst()
                            .orElse(null);

                    if (aluno != null && disciplina != null) {
                        aluno.removerDisciplina(disciplina);
                        disciplina.removerAluno(aluno);
                        JOptionPane.showMessageDialog(frame,
                                aluno.getNome() + " foi removido(a) da disciplina: " + disciplina.getNome());
                    }
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirExcluirDisciplina() {
        limparTela();
        JPanel excluirpainelDisciplina = new JPanel(new BorderLayout());
        excluirpainelDisciplina.setBorder(BorderFactory.createTitledBorder("Excluir disciplina"));

        JPanel disciplinaInputPanel = new JPanel(new GridLayout(0, 2));
        String[] disciplinas = disciplinasCadastradas.stream()
                .map(Disciplina::getNome)
                .toArray(String[]::new);
        JComboBox<String> disciplinasComboBox = new JComboBox<>(disciplinas);
        JButton botaoExcluirDisciplina = new JButton("Excluir");
        botaoVoltar = new JButton("Voltar");

        disciplinaInputPanel.add(new JLabel("Selecione a disciplina:"));
        disciplinaInputPanel.add(disciplinasComboBox);
        disciplinaInputPanel.add(botaoExcluirDisciplina);
        disciplinaInputPanel.add(botaoVoltar);

        excluirpainelDisciplina.add(disciplinaInputPanel, BorderLayout.NORTH);

        frame.add(excluirpainelDisciplina, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        botaoExcluirDisciplina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String disciplinaSelecionada = (String) disciplinasComboBox.getSelectedItem();
                if (disciplinaSelecionada != null) {
                    Disciplina disciplina = disciplinasCadastradas.stream()
                            .filter(d -> d.getNome().equals(disciplinaSelecionada))
                            .findFirst()
                            .orElse(null);

                    if (disciplina != null) {
                        disciplinasCadastradas.remove(disciplina);
                        for (Aluno aluno : alunosCadastrados) {
                            aluno.removerDisciplina(disciplina);
                        }
                        JOptionPane.showMessageDialog(frame, "Disciplina " + disciplina.getNome() + " foi removida.");
                        exibirTelaInicial();
                    }
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirExcluirAluno() {
        limparTela();
        painelAluno = new JPanel(new BorderLayout());
        JPanel alunoPainelEnt = new JPanel(new GridLayout(0, 2));
        alunoPainelEnt.setBorder(BorderFactory.createTitledBorder("Excluir aluno"));

        String[] alunos = alunosCadastrados.stream()
                .map(Aluno::getNome)
                .toArray(String[]::new);
        JComboBox<String> alunosComboBox = new JComboBox<>(alunos);

        JButton botaoExcluiAluno = new JButton("Excluir aluno");
        botaoVoltar = new JButton("Voltar");

        alunoPainelEnt.add(new JLabel("Selecione o aluno:"));
        alunoPainelEnt.add(alunosComboBox);
        alunoPainelEnt.add(botaoExcluiAluno);
        alunoPainelEnt.add(botaoVoltar);

        painelAluno.add(alunoPainelEnt, BorderLayout.NORTH);

        frame.add(painelAluno, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        botaoExcluiAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alunoSelecionado = (String) alunosComboBox.getSelectedItem();
                if (alunoSelecionado != null) {
                    Aluno aluno = alunosCadastrados.stream()
                            .filter(a -> a.getNome().equals(alunoSelecionado))
                            .findFirst()
                            .orElse(null);

                    if (aluno != null) {
                        alunosCadastrados.remove(aluno);
                        for (Disciplina disciplina : disciplinasCadastradas) {
                            disciplina.removerAluno(aluno);
                        }
                        JOptionPane.showMessageDialog(frame, "Aluno(a) " + aluno.getNome() + " foi removido.");
                        exibirTelaInicial();
                    }
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaInicial();
            }
        });
    }

    private void exibirTelaInicial() {
        limparTela();
        frame.add(telaInicial, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void limparTela() {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }
}
