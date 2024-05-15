public static class Bilbioteca
{
    static int tamanhoVetorLivros = 10;
    static int indiceVetorLivros = 0;
    static livros[] = new Livro[];
    //usuario[] = new usuario[y];
    static String nome;

    /*static void main(String[] argv)
    {

    }*/

    static void cadastrarLivro()
    {
        if(indiceVetorLivros == tamanhoVetorLivros - 1) this.aumentaVetorLivros();

        System.out.println("CADASTRAR NOVO LIVRO:");
        System.out.printf("NOME DO LIVRO: ");
        //scan
        System.out.printf(" LIVRO: ");
    }

    private void aumentaVetorLivros()
    {
        Livro[] novoVetor = new Livro[this.tamanhoVetorLivros * 2];

        for(int i = 0; i < tamanhoVetorLivros; i++)
        {
            novoVetor[i] = this.livros[i];
        }

        livros = novoVetor;

        this.tamanhoVetorLivros *= 2;
    }
}