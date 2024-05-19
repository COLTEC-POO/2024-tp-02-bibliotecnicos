import java.util.Date;
public class Professor extends Morador{
    String Formacao;

    Professor(String Nome, String CPF, Date DataNascimento, String Formacao){
        this.Nome = Nome;
        this.CPF = CPF;
        this.DataNascimento = DataNascimento;
        this.Formacao = Formacao;
        tam = 10;
        LivrosAlugados = new Livro[tam];
    }
}
