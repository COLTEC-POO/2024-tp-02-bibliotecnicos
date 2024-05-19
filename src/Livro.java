public class Livro {
    protected String Titulo;
    protected String Autor;
    protected int AnoDePublicacao;
    protected String Editora;
    private int numeroDeExemplaresTotal;
    private int numeroDeExemplaresDisponiveis;

    public Livro(String Titulo, String Autor, int AnoDePublicacao, String Editora, int numeroDeExemplaresTotal)
    {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.AnoDePublicacao = AnoDePublicacao;
        this.Editora = Editora;
        this.numeroDeExemplaresTotal = numeroDeExemplaresTotal;
        this.numeroDeExemplaresDisponiveis = numeroDeExemplaresTotal;
    }

    public String getTitulo() {
        return this.Titulo;
    }

    //public void setTitulo(String titulo) {this.Titulo = titulo;}

    public String getAutor() {
        return this.Autor;
    }

    //public void setAutor(String autor) {this.Autor = autor;}

    public int getAnoDePublicacao() {
        return this.AnoDePublicacao;
    }

    //public void setAnoDePublicacao(int anoDePublicacao) {this.AnoDePublicacao = anoDePublicacao;}

    public String getEditora() {
        return this.Editora;
    }


    //public void setEditora(String editora) {this.Editora = editora;}

    void imprimir() {

        System.out.println("Titulo: " + this.Titulo);
        System.out.println("Autor: " + this.Autor);
        System.out.println("Ano De Publicação: " + this.AnoDePublicacao);
        System.out.println("Editora: " + this.Editora);
        System.out.println("Numero de exemplares: " + this.numeroDeExemplaresTotal);
        System.out.println("Numero de exemplares disponiveis: " + this.numeroDeExemplaresDisponiveis);
    }

    public void adicionaExemplar() {

        this.numeroDeExemplaresDisponiveis++;
        this.numeroDeExemplaresTotal++;
    }

    public boolean emprestaExemplar() {

        if(this.numeroDeExemplaresDisponiveis == 0) {

            System.out.println("Esse livro nao possui exemplares disponiveis!");
            return false;
        }

        this.numeroDeExemplaresDisponiveis--;
        return true;
    }

    public void devolveExemplar() {this.numeroDeExemplaresDisponiveis++;}
}
