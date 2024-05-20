import java.util.Date;

public class Morador {

    protected String Nome;
    protected String CPF;
    protected Date DataNascimento;
    protected int ID;
    protected int tam;
    protected Livro[] LivrosAlugados;

    //métodos

    String getNome() {
        return this.Nome;
    }

    String getCPF() {
        return this.CPF;
    }

    Date getDataNascimento() {
        return this.DataNascimento;
    }

    int getID() {
        return this.ID;
    }

    boolean devolverLivro(Livro livro) {

        for(int i = 0; i < tam; i++) {

            if(LivrosAlugados[i] == livro) {

                LivrosAlugados[i] = null;
                return true;
            }
        }

        return false;
    }

    boolean pegarLivro(Livro livro) {

        for(int i = 0; i < tam; i++) {

           if(LivrosAlugados[i]==livro) {

               System.out.println("Esse usuario ja pegou emprestado um exemplar dess livro!");
               return false;
           }
        }

        for(int i = 0; i<tam; i++) {
            if(LivrosAlugados[i]==null){
                LivrosAlugados[i]=livro;
                return true;
            }
        }

        System.out.println("Esse usuario atingiu o limite de livros que pode pegar emprestado!");
        return false;
    }

    void imprimirLivros(){
        for(int i=0; i<tam; i++){
            if(LivrosAlugados[i]!=null){
                LivrosAlugados[i].imprimir();
            }
        }
    }

    //construtora

    public Morador(String Nome, String CPF, Date DataNascimento){
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        tam = 2;
        LivrosAlugados = new Livro[tam];
    }

    public  Morador() {

    }
}
