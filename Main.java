/*
Alunos; Andrey Ranielly, Giullia Vieira, Hannah Sales, Matheus Oliveira, Matheus Vinicius

Trabalho Final

Observações:
• Utilizar a IDE de sua preferencia para o desenvolvimento dos progrmas. A entrega
do programa deve ser por meio de um arquivo ZIP contendo o projeto;
• Aplicar boas práticas de programação: declaração de variáveis no início do programa,
nomes de variáves que ajudem a compreensão do programa e inclusão de comentários
e modularização (subprogramas).

Escreva um programa para gerenciar as médias das notas de 20 estudantes. O
programa deve ler o número de identificação, as 3 notas obtidas por um estudante nas 3
verificações de aprendizagem e a média dos exercícios que fazem parte da avaliação.
Em seguida, calcular a média de aproveitamento, usando a fórmula seguinte:
MA = (nota1 + 2 ∙ nota2 + 3 ∙ nota3 + ME)/7.


A atribuição dos conceitos obedece a tabela abaixo:
Média de aproveitamento Conceito
Maior ou igual 9,0 e menor ou igual a 10,0      A
Maior ou igual a 7,5 e menor que 9,0            B
Maior ou igual a 6,0 e menor que 7,5            C
Maior ou igual a 4,0 e menor que 6,0            D
Menor que 4,0                                   E


Apos a leitura dos dados, o programa deve, por meio de um menu, executar as
seguintes etapas:
a) Cadastrar as médias dos 20 estudantes.
b) Apresentar o número de estudantes que tiveram o aproveitamento com conceitos
A e B.
c) Apresentar o número de estudantes que tiveram o aproveitamento com conceitos
C e D.
d) Apresentar o número de estudantes que tiveram o aproveitamento com conceito
abaixo de D.
e) Apresentar o número de estudantes que tiveram o aproveitamento com conceito
acima de B.
f) Sair do programa.
OBSERVAÇÕES:
1. Toda entrada e saída (exibição) de dados deve ser feita pelo programa principal
(método main).
2. O programa principal (método main) deverá ter um menu e um loop que permita ao
usuário executar cada etapa (itens a, b, c, ..., f) quantas vezes desejar e só deverá
terminar sua execução se o usuário solicitar.
3. O programa deverá forçar a digitação de notas no intervalo fechado de 0,0 (zero)
a 10,0 (dez).
4. O programador é livre para definir outros procedimentos ou funções, caso julgue
necessário.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int totalEstudantes = 20; //para que sejam cadastradas as notas dos 20 estudantes.
        double[] medias = new double[totalEstudantes];
        
        int opcao = 0;
        do { //para receber e cadastrar o input das notas dos estudantes.
            double mediaAproveitamento = 0.0;
            
            for (int i = 0; i < medias.length; i++) {
                System.out.println("Aluno #" + i);

                System.out.print("Digite o número de identificação: ");
                int id = sc.nextInt();

                double n1, n2, n3, mediaExercicio;
                do {
                    System.out.print("Digite a primeira nota (0 a 10): ");
                    n1 = sc.nextDouble();
                    if (n1 < 0.0 || n1 > 10.0) { //para obrigar o input das notas a ser um valor entre 0 e 10.
                        System.out.println("A nota deve estar entre 0 e 10.");
                    }
                } while (n1 < 0.0 || n1 > 10.0);
                
                do {
                    System.out.print("Digite a segunda nota (0 a 10): ");
                    n2 = sc.nextDouble();
                    if (n2 < 0.0 || n2 > 10.0) {
                        System.out.println("A nota deve estar entre 0 e 10.");
                    }
                } while (n2 < 0.0 || n2 > 10.0);
                
                do {
                    System.out.print("Digite a terceira nota (0 a 10): ");
                    n3 = sc.nextDouble();
                    if (n3 < 0.0 || n3 > 10.0) {
                        System.out.println("A nota deve estar entre 0 e 10.");
                    }
                } while (n3 < 0.0 || n3 > 10.0);

                do {
                    System.out.print("Digite a média dos exercícios (0 a 10): ");
                    mediaExercicio = sc.nextDouble();
                    if (mediaExercicio < 0.0 || mediaExercicio > 10.0) {
                        System.out.println("A média dos exercícios deve estar entre 0 e 10.");
                    }
                } while (mediaExercicio < 0.0 || mediaExercicio > 10.0);

                System.out.println();
                mediaAproveitamento = (n1 + 2 * n2 + 3 * n3 + mediaExercicio) / 7.0;
                medias[i] = mediaAproveitamento;
            }
            
            
            
            do {
                menu(); //chama o menu para você escolher entre as opções, e chama as variáveis que gravaram o número de estudantes com cada conceito
                opcao = sc.nextInt();

                switch (opcao) {
                    case 2:
                        int totalAeB = contarAeB(medias);
                        System.out.println("Número de estudantes com aproveitamente A e B: " + totalAeB);
                        break;

                    case 3:
                        int totalCeD = contarCeD(medias);
                        System.out.println("Número de estudantes com aproveitamente C e D: " + totalCeD);
                        break;

                    case 4:
                        int totalAbaixoD = contarAbaixoD(medias);
                        System.out.println("Número de estudantes com aproveitamente abaixo de D: " + totalAbaixoD);
                        break;
                        
                    case 5:
                        int totalAcimaB = contarAcimaB(medias);
                        System.out.println("Número de estudantes com aproveitamente Acima de B: " + totalAcimaB);
                        break;
                }
            } while (opcao > 1);
        } while (opcao == 1);

        sc.close();
    }

    public static void menu() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("Digite 1 para cadastrar novas médias dos estudantes.");
        System.out.println("Digite 2 para ver o número de estudantes com conceitos A e B.");
        System.out.println("Digite 3 para ver o número de estudantes com conceitos C e D.");
        System.out.println("Digite 4 para ver o número de estudantes com conceitos abaixo de D.");
        System.out.println("Digite 5 para ver o número de estudantes com conceitos acima de B.");
        System.out.println("Digite 0 para sair.");
        System.out.print("Escolha uma opção: \n");
    }

    public static int contarAeB(double[] medias) {
        int contadorAeB = 0;
        
        for (double media : medias) { //classificador da média nos conceitos. Adiciona um número a variável contadorAeB toda vez que um estudante obtiver conceto A ou B. 
            if (media >= 7.5 && media <= 10.0) {
                contadorAeB++;
            }
        }
        
        return contadorAeB;
    }

    public static int contarCeD(double[] medias) {
        int contadorCeD = 0;

        for (double media : medias) {
            if (media >= 4.0 && media < 7.5) {
                contadorCeD++;
            }
        }
        
        return contadorCeD;
    }
    
    public static int contarAbaixoD(double[] medias) {
        int contadorAbaixoD = 0;

        for (double media : medias) {
            if (media < 4.0) {
                contadorAbaixoD++;
            }
        }

        return contadorAbaixoD;
    }

    public static int contarAcimaB(double[] medias) {
        int contadorAcimaB = 0;

        for (double media : medias) {
            if (media >= 9.0 && media <= 10.0) {
                contadorAcimaB++;
            }
        }
        return contadorAcimaB;
    }
}
