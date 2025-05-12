import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        ArrayList<Produto> listaProdutos = new ArrayList<>();  
        int opcao = 0; 

        while (opcao != 5) {
            System.out.println("=== Menu ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Visualizar");
            System.out.println("5 - SAIR");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
            case 1:
                System.out.println("Informe os dados do produto");
                System.out.println("Id: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("Nome: ");
                String nome = sc.nextLine();

                System.out.println("Descrição: ");
                String descricao = sc.nextLine();

                System.out.println("Preço: ");
                double preco = Double.parseDouble(sc.nextLine());

                System.out.println("Quantidade Estoque");
                int qntEstoque = Integer.parseInt(sc.nextLine());

                System.out.println("Categoria");
                String categoria = sc.nextLine();

                listaProdutos.add(new Produto(id, nome, descricao, preco, qntEstoque, categoria)); //aAdiciona os produtos na lista
                
                System.out.println("\nProdutos cadastrados:");
                for (Produto produtos : listaProdutos) { //Exibe os produtos cadastrados
                    System.out.println(produtos);
                }
                break;

            case 2:
                System.out.println("Informe o ID do item: ");
                int idBusca = Integer.parseInt(sc.nextLine());
                Produto produtoParaEditar = null;
                for(Produto produto : listaProdutos){
                    if (produto.getId() == idBusca) {
                        produtoParaEditar = produto;
                    }
                }
                if (produtoParaEditar == null) {
                    System.out.println("Produto com ID "+ idBusca + " não encontrado!");
                    return;
                }
                System.out.println("Informe os dados do produto a ser alterado");
                System.out.println("Id: ");
                int novoId = Integer.parseInt(sc.nextLine());

                System.out.println("Nome: ");
                String novoNome = sc.nextLine();

                System.out.println("Descrição: ");
                String novaDescricao = sc.nextLine();

                System.out.println("Preço: ");
                double novoPreco = Double.parseDouble(sc.nextLine());

                System.out.println("Quantidade Estoque");
                int novaQntEstoque = Integer.parseInt(sc.nextLine());

                System.out.println("Categoria");
                String novaCategoria = sc.nextLine();

                produtoParaEditar.setNome(novoNome);
                produtoParaEditar.setDescricao(novaDescricao);
                produtoParaEditar.setPreco(novoPreco);
                produtoParaEditar.setQuantidadeEstoque(novaQntEstoque);
                produtoParaEditar.setCategoria(novaCategoria);
                
                System.out.println("Produto atualizado com sucesso!");

                for (Produto produtos : listaProdutos) {
                    System.out.println(produtos);
                }
            break;
            case 3:
                System.out.println("Informe o ID do item: ");
                idBusca = Integer.parseInt(sc.nextLine());
                Produto produtoParaExcluir = null;
                for(Produto produto : listaProdutos){
                    if (produto.getId() == idBusca) {
                        produtoParaExcluir = produto;
                    }
                }
                if (produtoParaExcluir == null) {
                    System.out.println("Produto com ID "+ idBusca + " não encontrado!");
                    return;
                }
                listaProdutos.remove(produtoParaExcluir);

                System.out.println("Produto removido com sucesso!");
            break;
            case 4:
                for (Produto produtos : listaProdutos) {
                    System.out.println(produtos);
                }
            break;

            case 5:
                System.out.println("Saindo do sistema!");
            break;
        
            default:
                System.out.println("Informe uma opção válida!");
                break;
            }
        }
    }
}
