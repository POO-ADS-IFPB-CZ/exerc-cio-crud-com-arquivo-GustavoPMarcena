package view;

import dao.ConjuntoPessoaDao;
import model.Pessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean count = true;
        ConjuntoPessoaDao cp = new ConjuntoPessoaDao();

        while(count){
            System.out.println("Opções\n1 - Adicionar Pessoa\n2 - Deletar Pessoa\n3 - Listar todos");
            int condicao = scanner.nextInt();
            switch (condicao){
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite o nome da pessoa:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email da pessoa:");
                    String email = scanner.nextLine();
                    if(cp.adicionarPessoa(new Pessoa(nome, email))){
                        System.out.println("Pessoa adicionada!");
                    }else{
                        System.out.println("Erro na inserção!");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite o email da pessoa para remoção:");
                    String emailDelecao = scanner.nextLine();
                    if(cp.removerPessoa(emailDelecao)){
                        System.out.println("Pessoa Removida!");
                    }else{
                        System.out.println("Erro na remoção!");
                    }
                    break;
                case 3:
                    System.out.println("As pessoas cadastradas são:\n");
                    cp.listarPessoas();
                    System.out.println();
                    break;
                default:
                    System.out.println("Não é uma opção válida!");
                    break;

            }

        }

    }
}