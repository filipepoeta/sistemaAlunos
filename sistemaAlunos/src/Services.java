import java.util.*;

public class Services {

    public static void cadastrarAluno(){
        Scanner entrada  = new Scanner(System.in);
        System.out.print("Digite a matricula do aluno: ");
        int matricula = entrada.nextInt();
        System.out.print("Digite o primeiro do nome do aluno: ");
        String firstName = entrada.next();
        System.out.print("Digite o sobrenome do aluno: ");
        String lastName = entrada.next();
        Aluno alumno = new Aluno(matricula,firstName,lastName);
        Repository.repositoryList(alumno);
    }

    public static void cadastrarNotas(){
        Scanner entrada  = new Scanner(System.in);
        System.out.print("Qual a matricula do aluno que irá receber a nota? ");
        int id = entrada.nextInt();

        Aluno alumno = Repository.alunos.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        System.out.print("Quantas notas irá lançar? ");
        int quantidadeNotas = entrada.nextInt();

        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Digite a nota "+(i+1)+": ");
            alumno.getNotas().add(entrada.nextDouble());
        }
        System.out.println("Notas cadastradas");
    }

    public static void calcularMediaGeral(){
        Double total = 0.0;
        int quantidadeNotas = 0;
        for(Aluno aluno : Repository.alunos){
            total += aluno.getNotas().stream().reduce(0.0,Double::sum);
            quantidadeNotas += aluno.getNotas().size();
        }
        Double media = total / quantidadeNotas;
        System.out.println("Média geral de notas da turma: "+media);
    }

    public static void excluirNotaAluno(){
        Scanner entrada  = new Scanner(System.in);
        System.out.print("Qual a matricula do aluno para excluir nota? ");
        int id = entrada.nextInt();
        Aluno alumno = Repository.alunos.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        alumno.getNotas().clear();
    }

    public static void listarNotas(){
        for (Aluno aluno : Repository.alunos) {
            System.out.println("Aluno: "+aluno.getFirstName());
            System.out.println("Notas: "+aluno.getNotas());
            System.out.println("====================================");
        }

    }

    public static void notaMaior(){
        Double notaMax = 0.0;
        String nomeAluno = "";
       for (Aluno aluno : Repository.alunos)
       {
           for (int i = 0; i < aluno.getNotas().size() ; i++) {
            if(aluno.getNotas().get(i) > notaMax){
                notaMax = aluno.getNotas().get(i);
                nomeAluno = aluno.getFirstName();

            }
           }
       }
        System.out.println("ALUNO DESTAQUE COM MAIOR NOTA");
        System.out.print("Aluno: "+nomeAluno);
        System.out.println(" NOTA: "+notaMax);
    }

    public static void notaMenor(){
        Double notaMin = 20.00;
        String nomeAluno = "";
        for (Aluno aluno : Repository.alunos)
        {
            for (int i = 0; i < aluno.getNotas().size() ; i++) {
                if(aluno.getNotas().get(i) < notaMin){
                    notaMin = aluno.getNotas().get(i);
                    nomeAluno = aluno.getFirstName();

                }
            }
        }
        System.out.println("ALUNO COM MENOR NOTA");
        System.out.print("Aluno: "+nomeAluno);
        System.out.println(" NOTA: "+notaMin);
    }


}
