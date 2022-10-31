package questao1;

public interface ProdutoDAO {

    void addproduto(Produto produto);

    void excluindoProduto();

    Boolean buscarProduto(int id);

    void atualizandoProduto();
}