import java.util.Date;
import java.util.Scanner;

public class Biblioteca {

    static int tamanhoVetorLivros = 10;
    static int indiceVetorLivros = 0;
    static Livro[] livros = new Livro[tamanhoVetorLivros];

    static int tamanhoVetorMoradores = 10;
    static int indiceVetorMoradores = 0;
    static Morador[] moradores = new Morador[tamanhoVetorMoradores];

    static int tamanhoVetorAlunos = 10;
    static int indiceVetorAlunos = 0;
    static Aluno[] alunos = new Aluno[tamanhoVetorAlunos];

    static int tamanhoVetorProfessores = 10;
    static int indiceVetorProfessores = 0;
    static Professor[] professores = new Professor[tamanhoVetorProfessores];

    static String nome = "Bibliotecnicos";

    public static void main(String[] argv) {

        Scanner s = new Scanner(System.in);

        System.out.println("Ola!");
        System.out.println("Seja bem vindo aos sistema de gerenciamento da biblioteca: " +Biblioteca.nome);
        System.out.println(" ");

        for(;;) {

            System.out.println("Digite:");
            System.out.println("1 - Cadastrar um novo usuario");
            System.out.println("2 - Cadastrar um livro");
            System.out.println("3 - Emprestar um livro para um usuario");
            System.out.println("4 - Devolver um livro emprestado a um usuario");
            System.out.println("5 - Mostrar livros disponiveis para o empresitmo");
            System.out.println("6 - Mostar os livro que um usuario pegou emprestado");
            System.out.println("0 - Sair");

            int v = s.nextInt();
            Livro l;
            String cpf;
            int i, indice;

            String trash = s.nextLine();

            switch(v) {

                case 1:

                    Biblioteca.cadastrarUsuario(s);
                    s = new Scanner(System.in);
                    break;
                case 2:

                    l = Biblioteca.escanearLivro(s);
                    Biblioteca.cadastrarLivro(l);
                    break;
                case 3:

                    cpf = Biblioteca.escanearCpf(s);
                    indice = encontraUsuarioPorCpf(cpf);

                    if(indice == -1) System.out.println("Nao existe nenhum usuario cadastrado com esse cpf");
                    else {

                        l = escanearLivro(s);

                        i = indice/10;
                        i *= 10;
                        i = indice - i;
                        indice /= 10;

                        if(i == 1) Biblioteca.realizarEmprestimo(alunos[indice], l);
                        else if(i == 2) Biblioteca.realizarEmprestimo(professores[indice], l);
                        else Biblioteca.realizarEmprestimo(moradores[indice], l);
                    }
                    break;
                case 4:

                    cpf = Biblioteca.escanearCpf(s);
                    indice = encontraUsuarioPorCpf(cpf);

                    if(indice == -1) System.out.println("Nao existe nenhum usuario cadastrado com esse cpf");
                    else {

                        l = escanearLivro(s);

                        i = indice/10;
                        i *= 10;
                        i = indice - i;
                        indice /= 10;

                        if(i == 1) Biblioteca.realizarDevolucao(alunos[indice], encontraLivro(l));
                        else if(i == 2) Biblioteca.realizarDevolucao(professores[indice], encontraLivro(l));
                        else Biblioteca.realizarDevolucao(moradores[indice], encontraLivro(l));
                    }
                    break;
                case  5:

                    Biblioteca.exibirLivrosDisponiveis();
                    break;
                case 6:

                    cpf = Biblioteca.escanearCpf(s);
                    indice = encontraUsuarioPorCpf(cpf);

                    if(indice == -1) System.out.println("Nao existe nenhum usuario cadastrado com esse cpf");
                    else {

                        i = indice/10;
                        i *= 10;
                        i = indice - i;
                        indice /= 10;

                        if(i == 1) Biblioteca.alunos[indice].imprimirLivros();
                        else if(i == 2) Biblioteca.professores[indice].imprimirLivros();
                        else Biblioteca.moradores[indice].imprimirLivros();
                    }
                    break;
                case 0:
                    System.out.println("Encerrando sessao...");
                    System.out.println("Sessao encerrada! Ate mais");
                    return;
                default:

                    System.out.println("Comando invalido!");
            }
        }
    }

    public static void cadastrarLivro(Livro l) {

        int i = Biblioteca.encontraLivro((l));

        if(i == -1) {

            l.adicionaExemplar();
            Biblioteca.livros[Biblioteca.indiceVetorLivros] = l;
            Biblioteca.indiceVetorLivros++;
            return;
        }

        if(Biblioteca.indiceVetorLivros == Biblioteca.tamanhoVetorLivros)
            Biblioteca.aumentaVetorLivros();

        Biblioteca.livros[i].adicionaExemplar();
    }

    public static Livro escanearLivro(Scanner s) {

        System.out.println("Digite ... do livro:");

        System.out.print("Titulo: ");
        String titulo = s.nextLine();

        System.out.print("Autor: ");
        String autor = s.nextLine();

        System.out.print("Ano de lancamento: ");
        int ano = s.nextInt();

        String trash = s.nextLine();

        System.out.print("Editora: ");
        String editora = s.nextLine();

        return new Livro(titulo, autor, ano, editora, 0);
    }

    public static String escanearCpf(Scanner s) {

        System.out.print("Digite o cpf: ");
        return s.nextLine();
    }

    public static int encontraUsuarioPorCpf(String cpf) {

        int i;

        for(i = 0; i <= indiceVetorAlunos; i++)
        {
            if(cpf.equals(alunos[i].getCPF())) {

                return i*10 + 1;
            }
        }

        for(i = 0; i <= indiceVetorProfessores; i++)
        {
            if(cpf.equals(professores[i].getCPF())) {

                return i*10 + 2;
            }
        }

        for(i = 0; i <= indiceVetorMoradores; i++)
        {
            if(cpf.equals(moradores[i].getCPF())) {

                return i*10 + 3;
            }
        }

        return -1;
    }

    public static void cadastrarUsuario(Scanner s) {

        System.out.print("Digite o ... do usuario: ");

        System.out.print("Nome: ");
        String nome = s.nextLine();

        String cpf;
        String aux;
        for(;;) {

            System.out.print("CPF : ");
            cpf = s.nextLine();

            if(cpf.length() != 14 || cpf.charAt(3) != '.' ||
            cpf.charAt(7) != '.' || cpf.charAt(11) != '-') continue;

            break;
        }

        Date d;
        System.out.println("Data de nascimento: ");

        System.out.print("Ano: ");
        int ano = s.nextInt();

        int mes;
        for(;;) {

            System.out.print("Mes: ");
            mes = s.nextInt();

            if(mes < 1 || mes > 12) continue;

            break;
        }

        int dia;
        for(;;) {

            System.out.print("Dia: ");
            dia = s.nextInt();

            if(dia < 1 || dia > 31) continue;

            break;
        }

        d = new Date(ano, mes, dia);

        String trash = s.nextLine();

        System.out.print("Instuicao de estudo (deixe em branco se o usuario nao for um aluno): ");
        String instituicao = s.nextLine();

        System.out.print("Formacao academica (deixe em branco se o usuario nao for um professor): ");
        String formacao = s.nextLine();

        if(!instituicao.isEmpty()) {

            Aluno a = new Aluno(nome, cpf, d, instituicao);

            if(indiceVetorAlunos == tamanhoVetorAlunos)
                aumentaVetorAlunos();

            alunos[indiceVetorAlunos] = a;
            indiceVetorAlunos++;
            return;
        }

        if(!formacao.isEmpty()) {

            Professor p = new Professor(nome, cpf, d, formacao);

            if(indiceVetorProfessores == tamanhoVetorProfessores)
                aumentaVetorProfessores();

            professores[indiceVetorProfessores] = p;
            indiceVetorProfessores++;
            return;
        }

        Morador m = new Morador(nome, cpf, d);

        if(indiceVetorMoradores == tamanhoVetorMoradores)
            aumentaVetorMoradores();

        moradores[indiceVetorMoradores] = m;
        indiceVetorMoradores++;
    }

    public static void realizarEmprestimo(Morador m, Livro l) {

        int i = encontraLivro(l);

        if(i == -1) {
            System.out.println("Nao ha exemplares desse livro na biblioteca!");
            return;
        }

        if(Biblioteca.livros[i].emprestaExemplar(m))
            System.out.println("Emprestimo realizado com sucesso!");
        else
            System.out.println("Falha ao realizar o emprestimo!");
    }

    public static void realizarDevolucao(Morador m, int i) {

        if(i == -1) {
            System.out.println("Esse livro nao foi emprestado ao usuario!");
            return;
        }

        if(Biblioteca.livros[i].devolveExemplar(m))
            System.out.println("Devolucao realizada com sucesso!");
        else
            System.out.println("O usuario nao realizou o emprestimo do livro!");
    }

    public static void exibirLivrosDisponiveis() {

        for(int i = 0; i < Biblioteca.indiceVetorLivros; i++) {

            if(Biblioteca.livros[i].getNumeroDeExemplaresDisponiveis() != 0) Biblioteca.livros[i].imprimir();
        }
    }

    private static int encontraLivro(Livro l) {

        String titulo = l.getTitulo();
        String autor = l.getAutor();
        int data = l.getAnoDePublicacao();
        String editora = l.getEditora();

        Livro al;

        for(int i = 0; i < Biblioteca.indiceVetorLivros; i++) {

            al = Biblioteca.livros[i];

            if (titulo.equals(al.getTitulo()) && autor.equals(al.getAutor()) &&
                    data == al.getAnoDePublicacao() && editora.equals(al.getEditora()))
                return i;
        }

        return -1;
    }

    private static void aumentaVetorLivros() {

        Livro[] novoVetor = new Livro[Biblioteca.tamanhoVetorLivros * 2];

        if (tamanhoVetorLivros >= 0) System.arraycopy(Biblioteca.livros, 0, novoVetor, 0, tamanhoVetorLivros);

        Biblioteca.livros = novoVetor;

        Biblioteca.tamanhoVetorLivros *= 2;
    }

    private static void aumentaVetorAlunos() {

        Aluno[] novoVetor = new Aluno[tamanhoVetorAlunos * 2];

        if (tamanhoVetorAlunos >= 0) System.arraycopy(alunos, 0, novoVetor, 0, tamanhoVetorAlunos);

        alunos = novoVetor;

        tamanhoVetorAlunos *= 2;
    }

    private static void aumentaVetorProfessores() {

        Professor[] novoVetor = new Professor[tamanhoVetorProfessores * 2];

        if (tamanhoVetorProfessores >= 0) System.arraycopy(professores, 0, novoVetor, 0, tamanhoVetorProfessores);

        professores = novoVetor;

        tamanhoVetorProfessores *= 2;
    }

    private static void aumentaVetorMoradores() {

        Morador[] novoVetor = new Morador[tamanhoVetorMoradores * 2];

        if (tamanhoVetorMoradores >= 0) System.arraycopy(moradores, 0, novoVetor, 0, tamanhoVetorMoradores);

        moradores = novoVetor;

        tamanhoVetorMoradores *= 2;
    }
}