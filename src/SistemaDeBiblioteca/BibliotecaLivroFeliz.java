package SistemaDeBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class BibliotecaLivroFeliz {
    private CadLeitor cadLeitor;
    private CadFuncionario cadFuncionario;
    private CadItemAcervo cadItemAcervo;
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Reserva> reservasAtivas;

    public BibliotecaLivroFeliz() {
        this.cadLeitor = new CadLeitor();
        this.cadFuncionario = new CadFuncionario();
        this.cadItemAcervo = new CadItemAcervo();
        this.emprestimosAtivos = new ArrayList<>();
        this.reservasAtivas = new ArrayList<>();

        cadFuncionario.cadastrarFuncionario(new Funcionario("Integral", 2500, 1, "000.000.000-00", "Admin", "4002-8922", "admin@livrofeliz.com", "admin123"));
        cadLeitor.cadastrarLeitor(new Leitor(101, "111.111.111-11", "João da Silva", "8888-8888", "joao@email.com", "leitor123"));
    }

    private Leitor loginLeitor(Scanner sc) {
        System.out.println("\n--- Login do Leitor ---");
        System.out.print("Digite seu ID de leitor: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        Leitor leitor = cadLeitor.consultarLeitorPorId(id);
        if (leitor != null && leitor.getSenha().equals(senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo(a), " + leitor.getNome());
            return leitor;
        } else {
            System.out.println("ID ou senha inválidos, tente novamente!.");
            return null;
        }
    }


    private Funcionario loginFuncionario(Scanner sc) {
        System.out.println("\n--- Login do Funcionário ---");
        System.out.print("Digite seu ID de funcionário: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite a sua senha: ");
        String senha = sc.nextLine();

        Funcionario func = cadFuncionario.consultarFuncionarioPorId(id);
        if (func != null && func.getSenha().equals(senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo(a), " + func.getNome() + ".");
            return func;
        } else {
            System.out.println("ID ou senha inválidos, tente novamente!.");
            return null;
        }
    }

    public void gerenciarLeitores(Scanner sc) {
        System.out.println("\nMenu para gerenciar os leitores da Biblioteca Livro Feliz:");
        System.out.println("1. Cadastrar um Leitor");
        System.out.println("2. Consultar um Leitor");
        System.out.println("3. Excluir um Leitor");
        System.out.print("Escolha uma opção acima: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o ID do leitor: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Digite o CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Digite o Nome: ");
                String nome = sc.nextLine();
                System.out.print("Digite o Telefone: ");
                String tel = sc.nextLine();
                System.out.print("Digite o Email: ");
                String email = sc.nextLine();
                System.out.print("Digite a Senha: ");
                String senha = sc.nextLine();
                Leitor novoLeitor = new Leitor(id, cpf, nome, tel, email, senha);

                if (cadLeitor.cadastrarLeitor(novoLeitor)) {
                    System.out.println("Leitor cadastrado com sucesso!");
                } else {
                    System.out.println("Erro: Leitor com este ID já existe.");
                }
                break;

            case 2:
                System.out.print("digite o ID do leitor para a consulta: ");
                int idConsulta = sc.nextInt();
                sc.nextLine();
                Leitor l = cadLeitor.consultarLeitorPorId(idConsulta);
                if (l != null) {
                    System.out.println("ID: " + l.getId() + ", Nome: " + l.getNome() + ", Status: " + l.getStatus());
                    consultarHistoricoLeitor(l);
                } else {
                    System.out.println("Leitor não encontrado.");
                }
                break;

            case 3:
                System.out.print("Digite o ID do leitor que deseja excluir: ");
                int idExcluir = sc.nextInt();
                sc.nextLine();
                if (cadLeitor.excluirLeitor(idExcluir)) {
                    System.out.println("O leitor foi excluido do sistema com sucesso.");
                } else {
                    System.out.println("Oops! Erro ao excluir o leitor: Leitor não encontrado no sistema :( ");
                }
                break;
            default:
                System.out.println("Você digitou uma opção inválida! Tente novamente :) ");
        }
    }

    public void gerenciarItemAcervo(Scanner sc) {
        System.out.println("\nGerenciar o Acervo Biblioteca Livro Feliz: adicione ou remova itens:");
        System.out.print("Digite o codigo do livro: ");
        String codigo = sc.nextLine();
        ItemAcervo item = cadItemAcervo.consultarItemAcervoPorCodigo(codigo);
        if (item == null) {
            System.out.print("Título do livro: ");
            String titulo = sc.nextLine();

            System.out.print("Autor do livro: ");
            String autor = sc.nextLine();

            System.out.print("Isbn do livro: ");
            String isbn = sc.nextLine();

            System.out.print("Editora: ");
            String editora = sc.nextLine();

            System.out.print("Edição do livro: ");
            int edicao = sc.nextInt();

            Livro novoLivro = new Livro();

            novoLivro.setTitulo(titulo);
            novoLivro.setAutor(autor);
            novoLivro.setIsbn(isbn);
            novoLivro.setEditora(editora);
            novoLivro.setEdicao(edicao);

            ItemAcervo novoItem = new ItemAcervo(novoLivro, codigo);
            cadItemAcervo.cadastrarItemAcervo(novoItem);
            System.out.println("Item '" + titulo + "' cadastrado com sucesso com o código " + codigo);

        } else {
            System.out.print("Este livro já está no acervo. Deseja removê-lo? (s/n): ");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                if (isItemEmprestado(codigo)) {
                    System.out.println("Não é possível remover do acervo livros que estão emprestados!!");
                } else {
                    cadItemAcervo.excluirItemAcervo(codigo);
                    System.out.println("O livro foi removido do acervo da Biblioteca Livro Feliz!");
                }
            }
        }
    }

    public void gerenciarFuncionarios(Scanner sc) {
        System.out.println("\n--- Menu para gerenciar os funcionários da Biblioteca Livro Feliz ---");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Consultar Funcionário");
        System.out.println("3. Excluir Funcionário");
        System.out.print("Escolha uma opção acima: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o ID do novo funcionário: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Digite o nome do novo funcionario: ");
                String nome = sc.nextLine();
                System.out.print("Digite o turno do novo funcionario: ");
                String turno = sc.nextLine();
                System.out.print("Digite o cpf do novo funcionario: ");
                String cpf = sc.nextLine();
                System.out.print("Digite uma senha para o acesso do funcionario: ");
                String senha = sc.nextLine();

                Funcionario novoFunc = new Funcionario();
                novoFunc.setId(id);
                novoFunc.setNome(nome);
                novoFunc.setTurno(turno);
                novoFunc.setCpf(cpf);
                novoFunc.setSenha(senha);
                if (cadFuncionario.cadastrarFuncionario(novoFunc)) {
                    System.out.println("Funcionário cadastrado com sucesso!");
                } else {
                    System.out.println("Erro: Funcionário com este ID já existe.");
                }
                break;
            case 2:
                System.out.print("Digite o ID do funcionário para consulta: ");
                int idConsulta = sc.nextInt();
                sc.nextLine();
                Funcionario f = cadFuncionario.consultarFuncionarioPorId(idConsulta);
                if (f != null) {
                    System.out.println("ID: " + f.getId() + ", Nome: " + f.getNome() + ", Turno: " + f.getTurno() + ", Cpf: " + f.getCpf() + ", senha: " + f.getSenha());
                } else {
                    System.out.println("Funcionário não encontrado.");
                }
                break;
            case 3:
                System.out.print("Digite o ID do funcionário para excluir: ");
                int idExcluir = sc.nextInt();
                sc.nextLine();
                if (cadFuncionario.excluirFuncionario(idExcluir)) {
                    System.out.println("Funcionário excluído com sucesso.");
                } else {
                    System.out.println("Erro ao excluir. Funcionário não encontrado.");
                }
                break;
            default:
                System.out.println("Você digitou uma opção inválida! Tente novamente :)");
        }
    }

    private boolean isItemEmprestado(String codigoItem) {
        for (Emprestimo e : emprestimosAtivos) {
            if (e.getItemAcervo().getCodigo().equals(codigoItem) && e.isEmprestado()) {
                return true;
            }
        }
        return false;
    }


    public Emprestimo realizarEmprestimo(Scanner sc, Leitor leitor) {
        if (!leitor.podeEmprestar()) {
            System.out.println("Impossibilitado de realizar empréstimos, favor verificar multas pendentes!");
            return null;
        }

        System.out.print("Digite o codigo do item do acervo: ");
        String codigoItem = sc.nextLine();
        ItemAcervo item = cadItemAcervo.consultarItemAcervoPorCodigo(codigoItem);
        if (item == null) {
            System.out.println("Item não encontrado no acervo.");
            return null;
        }
        if (isItemEmprestado(codigoItem)) {
            System.out.println("Este livro já está emprestado! Deseja fazer uma reserva? (s/n)");
            if (sc.nextLine().equalsIgnoreCase("s")) {
                realizarReserva(sc, leitor, item);
            }
            return null;
        }

        Emprestimo novoEmprestimo = new Emprestimo(item, leitor);
        emprestimosAtivos.add(novoEmprestimo);
        leitor.adicionarEmprestimo(novoEmprestimo);
        System.out.println("Emprestimo do livro '" + item.getLivro().getTitulo() + "' realizado para " + leitor.getNome());
        System.out.println("Data para devolução: " + novoEmprestimo.getDataDevolucaoPrevista());
        return novoEmprestimo;
    }

    public Emprestimo realizarDevolucao(Scanner sc, Leitor leitor) {
        System.out.print("Digite o código do item para devolução: ");
        String codigoItem = sc.nextLine();

        Emprestimo emprestimoParaDevolver = null;
        for (Emprestimo emp : emprestimosAtivos) {
            if (emp.getLeitor().getId() == leitor.getId() && emp.getItemAcervo().getCodigo().equals(codigoItem) && emp.isEmprestado()) {
                emprestimoParaDevolver = emp;
                break;
            }
        }

        if (emprestimoParaDevolver == null) {
            System.out.println("Nenhum empréstimo ativo encontrado para este item em seu nome.");
            return null;
        }

        Multa multa = emprestimoParaDevolver.calcularMulta();
        if (multa != null) {
            leitor.adicionarMulta(multa);
            System.out.println("Devolução feita com atraso! Multa gerada de R$" + multa.getValor() + " para o leitor " + leitor.getNome());
        }
        emprestimoParaDevolver.devolver();
        emprestimosAtivos.remove(emprestimoParaDevolver);
        System.out.println("Livro '" + codigoItem + "' devolvido com sucesso.");
        return emprestimoParaDevolver;
    }

    public Reserva realizarReserva(Scanner sc, Leitor leitor, ItemAcervo item) {
        for (Reserva r : reservasAtivas) {
            if (r.getItemAcervo().getCodigo().equals(item.getCodigo())) {
                System.out.println("Este item já possui uma reserva ativa.");
                return null;
            }
        }

        Reserva novaReserva = new Reserva(item, leitor);
        reservasAtivas.add(novaReserva);
        System.out.println("Reserva do livro '" + item.getLivro().getTitulo() + "' realizada com sucesso para " + leitor.getNome() + ".");
        System.out.println("Você será notificado quando o livro for devolvido.");
        return novaReserva;
    }

    public void pagarMulta(Scanner sc, Leitor leitor) {
        ArrayList<Multa> multasPendentes = new ArrayList<>();
        for (Multa m : leitor.getMultas()) {
            if (!m.getStatus()) {
                multasPendentes.add(m);
            }
        }

        if (multasPendentes.isEmpty()) {
            System.out.println("O leitor está em dias e não possui multas pendentes.");
            return;
        }

        System.out.println("Multa(s) pendente(s):");
        for (int i = 0; i < multasPendentes.size(); i++) {
            System.out.println((i + 1) + ". Valor: R$" + multasPendentes.get(i).getValor() + ", Data: " + multasPendentes.get(i).getData());
        }

        System.out.print("Digite o número da multa que deseja pagar (ou 0 para cancelar): ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao > 0 && opcao <= multasPendentes.size()) {
            multasPendentes.get(opcao - 1).pagar();
        }
    }

    public void consultarHistoricoLeitor(Leitor leitor) {
        System.out.println("\n--- Histórico de: " + leitor.getNome() + " ---");

        System.out.println("\n** Empréstimos **");

        if (leitor.getEmprestimos().isEmpty()) {
            System.out.println("Nenhum empréstimo no seu histórico.");
        } else {
            for (Emprestimo emp : leitor.getEmprestimos()) {
                String status = emp.isEmprestado() ? "Emprestado" : "Devolvido em " + emp.getDataDevolucaoReal();
                System.out.println("Livro: " + emp.getItemAcervo().getLivro().getTitulo() +
                        " | Data Empréstimo: " + emp.getDataEmprestimo() +
                        " | Status: " + status);
            }
        }

        System.out.println("\n** Multas **");
        if (leitor.getMultas().isEmpty()) {
            System.out.println("Nenhuma multa foi registrada para este leitor.");
        } else {
            for (Multa m : leitor.getMultas()) {
                System.out.println("Data: " + m.getData() + ", Valor: R$" + m.getValor() + ", Status: " + m.getStatus());
            }
        }
    }

    private void menuLeitor(Scanner sc, Leitor leitor) {
        int opcao;
        do {
            System.out.println("\n==== PORTAL DO LEITOR: " + leitor.getNome() + " ====");
            System.out.println("1. Realizar Empréstimo");
            System.out.println("2. Realizar Devolução");
            System.out.println("3. Consultar Meu Histórico (Empréstimos e Multas)");
            System.out.println("4. Pagar Multa");
            System.out.println("5. Reservar Livro");
            System.out.println("0. Deslogar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    realizarEmprestimo(sc, leitor);
                    break;
                case 2:
                    realizarDevolucao(sc, leitor);
                    break;
                case 3:
                    consultarHistoricoLeitor(leitor);
                    break;
                case 4:
                    pagarMulta(sc, leitor);
                    break;
                case 5:

                    System.out.println("--- Realizar Reserva ---");
                    System.out.print("Digite o codigo do livro que deseja reservar: ");
                    String codigoDesejado = sc.nextLine();

                    ItemAcervo item = cadItemAcervo.consultarItemAcervoPorCodigo(codigoDesejado);

                    if (item != null) {
                        realizarReserva(sc, leitor, item);
                    } else {
                        System.out.println("Item com o código '" + codigoDesejado + "' não encontrado no acervo. Tente novamente.");
                    }
                    break;
                case 0:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Você digitou uma opção inválida! Tente novamente :)");
            }
        } while (opcao != 0);
    }


    private void menuFuncionario(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n==== MENU DO FUNCIONÁRIO ====");
            System.out.println("1. Gerenciar Leitores");
            System.out.println("2. Gerenciar Itens do Acervo (adicionar ou remover)");
            System.out.println("3. Gerenciar Funcionários");
            System.out.println("0. Voltar ao Menu Principal (Deslogar)");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarLeitores(sc);
                    break;
                case 2:
                    gerenciarItemAcervo(sc);
                    break;
                case 3:
                    gerenciarFuncionarios(sc);
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Você digitou uma opção inválida! Tente novamente :)");
            }
        } while (opcao != 0);
    }


    public static void main(String[] args) {
        BibliotecaLivroFeliz biblioteca = new BibliotecaLivroFeliz();
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n==== BEM-VINDO À BIBLIOTECA LIVRO FELIZ ====");
            System.out.println("1. Acessar como Leitor");
            System.out.println("2. Acessar como Funcionário");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha seu tipo de acesso: ");


            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next();
                System.out.print("Escolha seu tipo de acesso: ");
            }
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Leitor leitorLogado = biblioteca.loginLeitor(sc);
                    if (leitorLogado != null) {
                        biblioteca.menuLeitor(sc, leitorLogado);
                    }
                    break;
                case 2:
                    Funcionario funcLogado = biblioteca.loginFuncionario(sc);
                    if (funcLogado != null) {
                        biblioteca.menuFuncionario(sc);
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}