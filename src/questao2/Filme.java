package questao2;

public class Filme {

    private String nome;
    private String descricao;
    private int ano;

    public Filme(String nome, String descricao, int ano) {
        this.nome = nome;
        this.descricao = descricao;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAno() {
        return ano;
    }


}