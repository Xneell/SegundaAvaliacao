
package questao1;
import java.math.BigDecimal;
import java.util.Scanner;

/* Crie uma entidade produto, com os seguintes atributos:
• id
• nome
• descrição
• quantidade
• preço
Sua aplicação deve oferecer no método main 3 opções no console usando a classe
Scanner:
A primeira opção deve cadastrar produtos e ao selecionar ela deve cadastrar
automaticamente 3 produtos na base.
A segunda opção deve atualizar o primeiro produto cadastrado na opção 1.
A terceira opção deve excluir o segundo produto cadastrado.
Obs.: Tudo deve ser feito de forma automática apenas selecionando as opções ao
selecionar uma ação, deve ser mantida as opções apenas sinalizando no console que
ação foi realizada. Para finalizar a aplicação deve ser selecionado a opção 0.*/

import questao1.jdbc.JdbcProdutoDAO;

public class Main {


    public static void main(String[] args) {

        menu();
        
        try (Scanner input = new Scanner(System.in)) {
            int opcao = 20;
            while (opcao > 0) {
                System.out.print("Opcão:");
                opcao = input.nextInt();

                switch (opcao) {
                    case 1 -> addproduto();
                    case 2 -> atualizandoPrimeiroProduto();
                    case 3 -> excluindoSegundoProduto();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro!");
        }
    }

    private static void addproduto() {
        Produto produto1 = new Produto("Mousepad", "Mousepad colorido",
                10, new BigDecimal("55"));

        Produto produto2 = new Produto("Teclado ", "Teclado mecanico com led",
                15, new BigDecimal("150,99"));

        Produto produto3 = new Produto("Monitor", "Monitor de 24 polegadas full hd",
                8, new BigDecimal("790,99"));

        JdbcProdutoDAO produtoDAO = new JdbcProdutoDAO();

        if (produtoDAO.buscarProduto(3)) {
            throw new RuntimeException();
        }
        produtoDAO.addproduto(produto1);
        
        produtoDAO.addproduto(produto2);
        
        produtoDAO.addproduto(produto3);
        
        System.out.println("Produtos adicionados");

    }

    private static void atualizandoPrimeiroProduto() {
        JdbcProdutoDAO produtoDAO = new JdbcProdutoDAO();

        if (!produtoDAO.buscarProduto(1)) {
            throw new RuntimeException();
        }
        produtoDAO.atualizandoProduto();
    }
    private static void excluindoSegundoProduto() {

        JdbcProdutoDAO produtoDAO = new JdbcProdutoDAO();

        if (!produtoDAO.buscarProduto(2)) {
            throw new RuntimeException();
        }
        produtoDAO.excluindoProduto();
    }
    private static void menu() {
        System.out.println("O que voce deseja? :");
        System.out.println("1 - Cadastrar Produtos");
        System.out.println("2 - Atualizar Produto");
        System.out.println("3 - Excluir Segundo Produto Cadastrado");
        System.out.println("0 - Deseja sair");
    }
    
}


