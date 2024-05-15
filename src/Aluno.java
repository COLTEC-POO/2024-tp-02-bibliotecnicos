public class Aluno {
    String Escola;


    Aluno(String Nome, String CPF, Date DataNascimento, String Escola){
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.Escola = Escola;
        tam = 5;
        LivrosAlugados = new Livro[tam];
    }

}
