public class Morador {

    protected String Nome;
    protected String CPF;
    protected Date DataNascimento;
    protected int ID;
    protected int tam;
    protected Livro[] LivrosAlugados;

    //métodos

    String getNome(){
        return this.Nome;
    }

    String getCPF(){
        return this.CPF;
    }

    Date getDataNascimento(){
        return this.DataNascimento;
    }

    int getID(){
        return this.ID;
    }

    int setID(int ID){
        this.ID = ID;
    }


    boolean devolverLivro(Livro livro){
        for(int i=0; i<tam; i++){
            if(LivrosAlugados[i]==livro){
                LivrosAlugados[i]=null;
                return true;
            }
        }
        return false;
    }

    boolean pegarLivro(Livro livro){
        for(int i=0; i<tamanhoVetorLivros; i++){
            if(Biblioteca.livros[i]==livro) break;
            else return false;
        }

        for(int i=0; i<tam; i++){
           if(LivrosAlugados[i]==livro){
               return false;
           }
        }

        for(int i=0; i<tam; i++){
            if(LivrosAlugados[i]==null){
                LivrosAlugados[i]=livro;
                return true;
            }
        }
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

    Morador(String Nome, String CPF, Date DataNascimento){
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        tam = 2;
        LivrosAlugados = new Livro[tam];
    }
}
