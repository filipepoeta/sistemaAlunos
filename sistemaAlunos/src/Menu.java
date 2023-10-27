import java.util.Scanner;

public class Menu {
    public static void opcoes(){
        int opcao = 10;
        while (opcao != 0){
            System.out.println("1 - CADASTRAR ALUNO ");
            System.out.println("2 - LANÇAR NOTAS DE ALUNO ");
            System.out.println("3 - LISTAR NOTAS");
            System.out.println("4 - EXCLUIR NOTAS DE ALUNOS");
            System.out.println("5 - MÉDIA GERAL DA NOTA DA TURMA");
            System.out.println("6 - MAIOR NOTA ENTRE ALUNOS");
            System.out.println("7 - MENOR NOTA ENTRE ALUNOS");
            System.out.println("0 - SAIR");

            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite aqui sua opção: ");
            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    Services.cadastrarAluno();
                    break;
                case 2:
                    Services.cadastrarNotas();
                    break;
                case 3:
                    Services.listarNotas();
                    break;
                case 4:
                    Services.excluirNotaAluno();
                    break;
                case 5:
                    Services.calcularMediaGeral();
                    break;
                case 6:
                    Services.notaMaior();
                    break;
                case 7:
                    Services.notaMenor();
                    break;
                default:
                    break;
            }
        }

    }

}
