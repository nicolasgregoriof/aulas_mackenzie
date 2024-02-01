package aula1;

import java.util.Scanner;

public class WhileCodigo {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        
        int num, soma=0, cont=0;
        double media;

        System.out.println("Digite vários números (-1 encerra):");
        num = input.nextInt();

        while (num!=-1){
            soma += num;
            cont ++;
            num = input.nextInt();

        }

        if (cont !=0){
            media = (double) soma/cont;
            System.out.println("Soma dos números digitados: "+soma);
            System.out.println("Media dos números digitados: "+media);
        }
        else
            System.out.println("Não houve processamento");
    }
}
