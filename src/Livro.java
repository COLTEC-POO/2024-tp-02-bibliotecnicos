public class Livro {
    protected String Titulo;
    protected String Autor;
    protected int AnoDePublicacao;
    protected String Editora;

    public String getTitulo() {
        return this.Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public String getAutor() {
        return this.Autor;
    }

    public void setAutor(String autor) {
        this.Autor = autor;
    }

    public int getAnoDePublicacao() {
        return this.AnoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.AnoDePublicacao = anoDePublicacao;
    }

    public String getEditora() {
        return this.Editora;
    }

    public void setEditora(String editora) {
        this.Editora = editora;
    }
    void imprimir(){
        System.out.println("Titulo: "+this.getTitulo());
        System.out.println("Autor: "+this.getAutor());
        System.out.println("Ano De Publicação: "+this.getAnoDePublicacao());
        System.out.println("Editora: "+this.getEditora());

    }
}
