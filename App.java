import java.util.*;

public class App {
    private Scanner entrada;
    Funcionario usuarioLogado;

    public App() {
        entrada = new Scanner(System.in);
    }

    public void executar() {
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
                    mudarUsuarioPorId();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
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

    public void mudarUsuarioPorId(int id, List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                usuarioLogado = f;
                System.out.println("Usuário atual: " + f.getNome());
                return;
            }
        }
        System.out.println("Usuário com ID não encontrado.");
    } 

    public void registrarPedido(){

    }

    public void excluirPedido(){

    }
}