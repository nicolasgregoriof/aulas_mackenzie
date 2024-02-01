/*Após a aula, você deverá fazer e entregar um programa em Java, 
criando duas threads para somar os elementos de um vetor de inteiros de 100 posições.*/

package intso;
public class Threads {
    public static void main(String[] args) {
        
        int [] vet = {45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,
                      45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,
                      45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,
                      45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,
                      45,32,21,10,50,45,32,21,10,50,45,32,21,10,50,45,32,21,10,50};
        
        SomaP1 sp1 = new SomaP1(vet);
        sp1.start();

        SomaP2 sp2 = new SomaP2(vet);
        sp2.start();
    
        }
}
