import java.util.*;

public class App {
    private Scanner entrada;
    private Funcionario usuarioLogado;
     private ArrayList<Pedido> pedidos = new ArrayList<>();
    private int proximoIdPedido = 1;

    public App() {
        entrada = new Scanner(System.in);
    }

    public void executar() {
        Mock mock = new Mock();
        int opcao;
        do {
            System.out.println("SISTEMA DE PEDIDOS -- TRABALHO 1 GCS");
            menu();
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    List<Funcionario> funcionarios = mock.carregarFuncionarios(null);
                    mudarUsuarioPorId(funcionarios);
                    break;
                case 2:
                    registrarPedido();
                    break;
                case 3:
                    excluirPedido();
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //
                    break;
                default:
                    System.out.println("Opcao invalida. Redigite, por favor.");
            }
        } while (opcao != 0);
    }

    private void menu() {
        System.out.println("Opcoes: ");
        System.out.println("[0] Sair");
        System.out.println("[1] Mudar de usuario por ID");
        System.out.println("[2] Registrar um novo pedido de aquisicao");
        System.out.println("[3] Excluir pedido de aquisicao");
        System.out.println("[4] ");
        System.out.println("[5] ");
        System.out.println("[6] ");
    }

    public void mudarUsuarioPorId(List<Funcionario> funcionarios) {
        System.out.println("Digite o ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                usuarioLogado = f;
                System.out.println("Usuário atual: " + f.getNome());
                return;
            }
        }
        System.out.println("Usuário com ID não encontrado.");
    } 

    public void registrarPedido() {
        if (usuarioLogado == null) {
            System.out.println("Não há usuário logado.");
            return;
        }
        List<ItemPedido> itensDoPedido = new ArrayList<>();
        System.out.print("Quantos itens deseja adicionar ao pedido? ");
        int quantidadeItens = entrada.nextInt();
        entrada.nextLine();
        for (int i = 1; i <= quantidadeItens; i++) {
            System.out.println("Item " + i + ": ");
            System.out.print("Descrição do item/produto: ");
            String descricaoItem = entrada.nextLine();
            System.out.print("Valor unitário: ");
            double valorUnitario = entrada.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = entrada.nextInt();
            entrada.nextLine();

            itensDoPedido.add(new ItemPedido(descricaoItem, valorUnitario, quantidade));
        }

        Pedido pedidoCriado = new Pedido(proximoIdPedido, usuarioLogado, itensDoPedido);
        pedidos.add(pedidoCriado);
        
        System.out.println("Pedido gerado com sucesso!");
        proximoIdPedido++;
    }

    public void excluirPedido() {
        if (usuarioLogado == null) {
            System.out.println("Não há usuário logado.");
            return;
        }

        System.out.print("Digite o ID do pedido que quer excluir: ");
        int idProcurado = entrada.nextInt();
        entrada.nextLine();

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idProcurado) {
                if (pedido.getSolicitante().getId() == usuarioLogado.getId()) {
                    pedidos.remove(pedido);
                    System.out.println("Pedido excluído com sucesso.");
                    return; 
                } else {
                    System.out.println("Apenas o funcionário que criou o pedido pode excluir.");
                    return;
                }
            }
        }
        System.out.println("ID do pedido não encontrado.");
    }
}