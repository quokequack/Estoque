import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private String nomeProduto;
    private int quantidade;
    private int estoqueMinimo;

    public Estoque(String nomeProduto, int quantidade, int estoqueMinimo) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    // Getters e Setters

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    // CRUD methods

    public static void main(String[] args) {
        List<Estoque> estoqueList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {
            exibirMenu();
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(estoqueList, input);
                    break;
                case 2:
                    exibirProdutos(estoqueList);
                    break;
                case 3:
                    atualizarProduto(estoqueList, input);
                    break;
                case 4:
                    excluirProduto(estoqueList, input);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("========= Menu =========");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Exibir produtos");
        System.out.println("3. Atualizar produto");
        System.out.println("4. Excluir produto");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarProduto(List<Estoque> estoqueList, Scanner input) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = input.next();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = input.nextInt();

        System.out.print("Digite o estoque mínimo do produto: ");
        int estoqueMinimo = input.nextInt();

        Estoque produto = new Estoque(nomeProduto, quantidade, estoqueMinimo);
        estoqueList.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    private static void exibirProdutos(List<Estoque> estoqueList) {
        System.out.println("========= Produtos em Estoque =========");
        for (Estoque produto : estoqueList) {
            System.out.println("Nome: " + produto.getNomeProduto());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Estoque Mínimo: " + produto.getEstoqueMinimo());
            System.out.println("-----------------------------");
        }
    }

    private static void atualizarProduto(List<Estoque> estoqueList, Scanner input) {
        System.out.print("Digite o nome do produto que deseja atualizar: ");
        String nomeProduto = input.next();

        boolean produtoEncontrado = false;

        for (Estoque produto : estoqueList) {
            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                System.out.print("Digite a nova quantidade do produto: ");
                int novaQuantidade = input.nextInt();
                produto.setQuantidade(novaQuantidade);

                System.out.print("Digite o novo estoque mínimo do produto: ");
                int novoEstoqueMinimo = input.nextInt();
                produto.setEstoqueMinimo(novoEstoqueMinimo);

                System.out.println("Produto atualizado com sucesso!");
                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void excluirProduto(List<Estoque> estoqueList, Scanner input) {
        System.out.print("Digite o nome do produto que deseja excluir: ");
        String nomeProduto = input.next();

        boolean produtoRemovido = false;

        for (Estoque produto : estoqueList) {
            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                estoqueList.remove(produto);
                System.out.println("Produto removido com sucesso!");
                produtoRemovido = true;
                break;
            }
        }

        if (!produtoRemovido) {
            System.out.println("Produto não encontrado.");
        }
    }
}
