public static class Biblioteca {

    static int tamanhoVetorLivros = 10;
    static int indiceVetorLivros = 0;
    static Livro[] livros = new Livro[tamanhoVetorLivros];

    //usuario[] = new usuario[y];
    static String nome;

    public static void main(String[] argv)
    {

    }

    public static void cadastrarLivro(Livro l) {

        int i = Biblioteca.encontraLivro((l));

        if(i == -1)
        {
            if(Biblioteca.indiceVetorLivros == Biblioteca.tamanhoVetorLivros - 1)
                Biblioteca.aumentaVetorLivros();

            l.adicionaExemplar();
            Biblioteca.livros[Biblioteca.indiceVetorLivros] = l;
            return;
        }

        Biblioteca.livros[i].adicionaExemplar();
    }

    public static  void cadastrarUsuario() {


    }

    public static void realizarEmprestimo(Livro l) {

        int i = encontraLivro(l);

        if(i == -1) {
            System.out.println("Nao ha exemplares desse livro na biblioteca!");
            return;
        }

        Biblioteca.livros[i].emprestaExemplar();
    }

    public static void realizarDevolucao(int i) {
        Biblioteca.livros[i].devolveExemplar();
    }

    public static void imprimirLivros() {

        for(int i = 0; i < Biblioteca.tamanhoVetorLivros; i++) {

            Biblioteca.livros[i].imprimir();
        }
    }

    private static int encontraLivro(Livro l) {

        String titulo = l.getTitulo();
        String autor = l.getAutor();
        int data = l.getAnoDePublicacao();
        String editora = l.getEditora();

        Livro al;

        for(int i = 0; i < Biblioteca.tamanhoVetorLivros; i++) {

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
}