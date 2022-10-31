package questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import questao2.jdbc.JdbcFilmeDAO;

public class Main {
    public static void main(String[] args) {
        List<Filme> filmes = new ArrayList<>();

        int quantidade;
        int paginas;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Filtrar quantos filmes? ");
            quantidade = input.nextInt();

            System.out.print("Qual pagina deseja ver? ");
            paginas = input.nextInt();

            excluirFilmes();
            adicionandoFilmes(filmes);
            listarFilmes(quantidade, paginas);

        } catch (Exception e) {
            throw new RuntimeException("Entrada inválida!");
        }
    }

    private static void adicionandoFilmes(List<Filme> filmes) {

        Filme filme1 = new Filme("O Senhor dos Anéis: A Sociedade do Anel", "Primeiro filme do senhor dos aneis.", 2001);
        Filme filme2 = new Filme("O Senhor dos Anéis: As Duas Torres (2002)", "Segundo filme do senhor dos aneis. ", 2002);
        Filme filme3 = new Filme("O Senhor dos Anéis: O Retorno do Rei", "Terceiro filme do senhor dos aneis. ", 2003);
        Filme filme4 = new Filme("O Hobbit: Uma Jornada Inesperada", "Primeiro filme do Hobbit", 2012);
        Filme filme5 = new Filme("O Hobbit: A Desolação de Smaug (2013)", "Segundo filme do Hobbit. ", 2010); 
        Filme filme6 = new Filme("As Crônicas de Nárnia: O Leão, a Feiticeira e o Guarda-Roupa", "Primeiro filme do universo Nárnia. ", 2005);
        Filme filme7 = new Filme("As Crônicas de Nárnia: Príncipe Caspian", "Segundo filme do universo Nárnia. ", 2008);
        Filme filme8 = new Filme("As Crônicas de Nárnia: A Viagem do Peregrino da Alvorada", "Terceiro filme do universo Nárnia. ", 2010);
        Filme filme9 = new Filme("Shrek", "Primeiro longa do universo Shrek. ", 2001);
        Filme filme10 = new Filme("Shrek 2", "Segundo longa do universo Shrek. ", 2004);
        Filme filme11 = new Filme("Shrek 3", "Terceiro longa do universo Shrek. ", 2007);
        Filme filme12 = new Filme("Shrek Para Sempre", "Quarto longa do universo Shrek. ", 2010); 
        Filme filme13 = new Filme("Harry Potter e a Pedra Filosofal", "Primeiro filme da saga Harry Potter. ", 2001);
        Filme filme14 = new Filme("Harry Potter ea Câmara Secreta", "Segundo filme da saga Harry Potter. ", 2002);
        Filme filme15 = new Filme("Harry Potter e o prisioneiro de azkaban", "Terceiro filme da saga Harry Potter.", 2004);
        Filme filme16 = new Filme("Harry Potter e o Cálice de Fogo", "Quarto filme da saga Harry Potter. ", 2005);
        Filme filme17 = new Filme("Harry Potter e a Ordem da Fênix", "Quinto filme da saga Harry Potter. ", 2007);
        Filme filme18 = new Filme("Harry Potter e o Príncipe Mestiço", "Sexto filme da saga Harry Potter. ", 2009);
        Filme filme19 = new Filme("Harry Potter e as Relíquias da Morte: Parte 1", "Setimo filme da saga Harry Potter. ", 2010);
        Filme filme20 = new Filme("Harry Potter e as Relíquias da Morte II", "Oitavo filme da saga Harry Potter. ", 2011);

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);
        filmes.add(filme5);
        filmes.add(filme6);
        filmes.add(filme7);
        filmes.add(filme8);
        filmes.add(filme9);
        filmes.add(filme10);
        filmes.add(filme11);
        filmes.add(filme12);
        filmes.add(filme13);
        filmes.add(filme14);
        filmes.add(filme15);
        filmes.add(filme16);
        filmes.add(filme17);
        filmes.add(filme18);
        filmes.add(filme19);
        filmes.add(filme20);

        JdbcFilmeDAO jdbcFilmeDAO = new JdbcFilmeDAO();
        jdbcFilmeDAO.adicionarFilmes(filmes);
    }

    private static void listarFilmes(int quantidade, int paginas) {
        JdbcFilmeDAO jdbcFilmeDAO = new JdbcFilmeDAO();
        List<Filme> filmes = jdbcFilmeDAO.listarFilmes(quantidade, paginas);

        for(Filme filme : filmes){
            System.out.println("Nome: " + filme.getNome());
            System.out.println("Descrição: " + filme.getDescricao());
            System.out.println("Ano: " + filme.getAno());
        }
    }

    private static void excluirFilmes() {
        JdbcFilmeDAO jdbcFilmeDAO = new JdbcFilmeDAO();
        jdbcFilmeDAO.excluirFilmes();
    }
}