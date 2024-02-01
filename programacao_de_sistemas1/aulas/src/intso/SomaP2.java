package intso;

public class SomaP2 extends Thread {
    
    public SomaP2 (int[] vet){
        int n2 = 0;
        for (int i=0; i<vet.length; i++){
            n2 = n2 + vet[i];
        }
        System.out.println(n2);
    }
}
