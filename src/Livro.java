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
    public static void main(String[] args) {
        Livro HarryPotter1 = new Livro();
        HarryPotter1.setTitulo("Harry Potter e a pedra filosofal");
        HarryPotter1.setAutor("Joeane Rowling");
        HarryPotter1.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter1.setAnoDePublicacao(1997);
        HarryPotter1.imprimir();
        System.out.println("\n");

        Livro HarryPotter2 = new Livro();
        HarryPotter2.setTitulo("Harry Potter e a câmara secreta");
        HarryPotter2.setAutor("Joeane Rowling");
        HarryPotter2.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter2.setAnoDePublicacao(1998);
        HarryPotter2.imprimir();
        System.out.println("\n");

        Livro HarryPotter3 = new Livro();
        HarryPotter3.setTitulo("Harry Potter e o prisioneiro de askabam");
        HarryPotter3.setAutor("Joeane Rowling");
        HarryPotter3.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter3.setAnoDePublicacao(1999);
        HarryPotter3.imprimir();
        System.out.println("\n");

        Livro HarryPotter4 = new Livro();
        HarryPotter4.setTitulo("Harry Potter e o calice de fogo");
        HarryPotter4.setAutor("Joeane Rowling");
        HarryPotter4.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter4.setAnoDePublicacao(2000);
        HarryPotter4.imprimir();
        System.out.println("\n");

        Livro HarryPotter5 = new Livro();
        HarryPotter5.setTitulo("Harry Potter e a ordem da fenix");
        HarryPotter5.setAutor("Joeane Rowling");
        HarryPotter5.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter5.setAnoDePublicacao(2003);
        HarryPotter5.imprimir();
        System.out.println("\n");

        Livro HarryPotter6 = new Livro();
        HarryPotter6.setTitulo("Harry Potter e Enigma do Principe");
        HarryPotter6.setAutor("Joeane Rowling");
        HarryPotter6.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter6.setAnoDePublicacao(2005);
        HarryPotter6.imprimir();
        System.out.println("\n");

        Livro HarryPotter7 = new Livro();
        HarryPotter7.setTitulo("Harry Potter e as reliquias da morte");
        HarryPotter7.setAutor("Joeane Rowling");
        HarryPotter7.setEditora("Bloomsbury Publishing Rocco Presença");
        HarryPotter7.setAnoDePublicacao(2007);
        HarryPotter7.imprimir();
        System.out.println("\n");
    }
}
