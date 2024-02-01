
/*Agora que você já sabe utilizar construtores, na classe Motocicleta, inclua três métodos construtores:

1 - Recebe como parâmetro o número do chassi e o número da placa e armazena os valores recebidos nos devidos atributos.

2 - Recebe o modelo e a marca e armazena os valores recebidos nos devidos atributos.

3- Construtor default: não recebe parâmetros e não tem código de implementação.*/

package aula4;

public class Motocicleta {
    String modelo;
    String marca;
    int nroChassi;
    String nroPlaca;
    String cor;
    int nroCilindradas;

    Motocicleta (int nroChassi, String nroPlaca){
        this.nroChassi = nroChassi;
        this.nroPlaca = nroPlaca;
    }

    Motocicleta (String modelo, String marca){
        this.modelo = modelo;
        this.marca = marca;
    }
    
    Motocicleta (){
    }
    
   public void mostraDados(){
       System.out.println("Modelo : " + modelo);
       System.out.println("Marca : " + marca);
       System.out.println("Número do chassi : " + nroChassi);
       System.out.println("Número da placa : " + nroPlaca);
       System.out.println("Cor : " + cor);
       System.out.println("Número de Cilindradas : " + nroCilindradas);
   }
}