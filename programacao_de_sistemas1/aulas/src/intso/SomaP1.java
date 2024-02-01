package intso;

public class SomaP1 extends Thread {

    public SomaP1 (int[] vet) {
        int n1 = 0;
        for (int i=0; i<vet.length; i++){
            n1 = n1 + vet[i];
        }
        System.out.println(n1);
    }
}
