public class Bilbioteca
{
    public static int tamanhoVetorLivros = 10;
    public static int indiceVetorLivros = 0;
    public static Livro livros[] = new Livro[tamanhoVetorLivros];
    //usuario[] = new usuario[y];
    static String nome;

    /*static void main(String[] argv)
    {

    }*/

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
    public void cadastrarLivro()
    {
        if(indiceVetorLivros == tamanhoVetorLivros - 1) this.aumentaVetorLivros();

        System.out.println("CADASTRAR NOVO LIVRO:");
        System.out.printf("NOME DO LIVRO: ");
        //scan
        System.out.printf(" LIVRO: ");
    }
}