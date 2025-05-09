import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int value = 0;
        Produto produtos[] = new Produto[value];  
        int opcao = 0; 

        while (opcao != 4) {
            System.out.println("=== Menu ===");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Editar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - SAIR");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
            case 1:
            value = value + 1;
            for(int i = value;i <= value; i++ ){
                System.out.println("Informe os dados do produto");
                System.out.println("Id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Nome: ");
                String nome = sc.nextLine();

                System.out.println("Descrição: ");
                String descricao = sc.nextLine();

                System.out.println("Preço: ");
                double preco = sc.nextDouble();
                sc.nextLine();

                System.out.println("Quantidade Estoque");
                int qntEstoque = sc.nextInt();
                sc.nextLine();

                System.out.println("Categoria");
                String categoria = sc.nextLine();

                produtos[value] = new Produto(id, nome, descricao, preco, qntEstoque, categoria);

                System.out.println("Produtos: ");
                System.out.println(produtos[value].toString());
            }
                break;
        
            default:
                System.out.println("Informe uma opção válida!");
                break;
        }
        }
    }
}
