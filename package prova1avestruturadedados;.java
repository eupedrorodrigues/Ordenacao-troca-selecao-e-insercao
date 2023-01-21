package prova1avestruturadedados;
import java.util.Random;
import java.util.Scanner;
/**
 * O Projeto foi realizado pela equipe:
 * Aluno: Pedro Ricardo Da Silva Rodrigues - 01565486;
 * 
 * 
 * Turma: 2MD
 * Disciplina: Estrutura de Dados
 * Professor: José Mário Souza
 */
public class Prova1AVEstruturaDeDados {
    private static Object vet;
    public static void main(String[] args) {
        int vet[] = new int[20];
        int vetAux[] = new int[vet.length];
        Random aleatorio = new Random();
        for(int i=0; i<vet.length;i++){
            vet[i] = aleatorio.nextInt(100);
        }
        System.out.println("\n### Lista Desordenada ###\n");
        for(int val:vet){
            System.out.print(val+"-");
        }
        System.out.println("");
        Scanner leia = new Scanner(System.in); 
        int opc = 0;
        while (opc != 4){
            System.out.println("");
            System.out.println("# Vamos Ordenar? #");
            System.out.println("1 - Por Troca");
            System.out.println("2 - Por Seleção");
            System.out.println("3 - Por Inserção");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = leia.nextInt();
            switch (opc) {
                case 1:
                    vetAux = vet.clone();
                    ordenarPorTroca(vetAux);
                    break;
                case 2:
                    vetAux = vet.clone();
                    ordenarPorSelecao(vetAux);
                    break;
                case 3:
                    vetAux = vet.clone();
                    ordenarPorInsercao(vetAux);
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            } 
        }
    }
    //BUBBLE SORT
    private static void ordenarPorTroca(int vetAux[]) {
        int tro = 0; //Variável para contar a quantidade de Trocas desse método
        int com = 0; //Variável para contar a quantidade de Comparações desse método
        System.out.println("\n### Ordenação por Troca ###\n");
        //criar aqui a lógica da Ordenação por Troca
        int aux;
        for(int i = 0; i < vetAux.length; i++){
            for(int e = i + 1; e < vetAux.length; e++){
                com++;
                if (vetAux[i] > vetAux[e]){
                    tro++;                
                    aux = vetAux[e];
                    vetAux[e] = vetAux[i];
                    vetAux[i] = aux;
                }
            }
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }
    //SELECTION SORT 
    private static void ordenarPorSelecao(int vetAux[]) {
        int tro = 0; //Variável para contar a quantidade de Trocas desse método
        int com = 0; //Variável para contar a quantidade de Comparações desse método
        System.out.println("\n### Ordenação por Seleção ###\n");
        //criar aqui a lógica da Ordenação por Seleção     
        int menor, aux;
        for (int i=0; i < vetAux.length;i++){
            menor = i;
            for (int v = i+1; v < vetAux.length; v++){
                com++;
                if (vetAux[v] < vetAux[menor]){
                    menor = v;     
            }
          }
            com++;
            if (menor != i){
            aux = vetAux[menor];
            vetAux[menor] = vetAux[i];
            vetAux[i] = aux;
            tro++;
        }
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }
    
    //INSERTION SORT
        private static void ordenarPorInsercao(int vetAux[]) {
        int tro = 0; //Variável para contar a quantidade de Trocas desse método
        int com = 0; //Variável para contar a quantidade de Comparações desse método
        System.out.println("\n### Ordenação por Inserção ###\n");
        //criar aqui a lógica da Ordenação por Inserção
        int aux; // armazena
        int p;
        for (int i = 1; i < vetAux.length; i++) {  
            aux = vetAux[i];
            p = i - 1; 
            com++;
            while (p >= 0 && aux < vetAux[p]) { 
                vetAux[p + 1] = vetAux[p];        // deslocamento para a direita 
                p--;
                if ( p < 0 ){
                    continue;
                }
                com++;
        }
            if(vetAux[p + 1] != aux){    
               vetAux[p + 1] = aux;       // insere o elemento na parte ordenada 
               tro++;
            }
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }
    
    private static void listarVetorOrdenado(int vetAux[]) {
        System.out.println("\n### Lista Ordenada ###\n");
        for(int val:vetAux){
            System.out.print(val+"-");
        }
        System.out.println("");
    }

    private static void listarComplexiade(int tro, int com) {
        System.out.println("### Complexidade ###");
        System.out.println("Comparações: "+com);
        System.out.println("Trocas: "+tro);
    }
}