package aplicando2;

import java.io.*;

public class Notas {
    float[] notas = new float[5];
    float media;
    BufferedReader br;

    public Notas (BufferedReader br){
        
            this.br = br;
            String linha;
            int i = 0;
        
        try{
            while((linha = this.br.readLine()) != null){
                String[] linha_temp = new String[2];
                linha_temp = linha.split(";");  
                notas[i] = Float.parseFloat(linha_temp[2]);
                i++;
            }
        }catch (IOException e){
            System.out.println("Erro na leitura do arquivo, erro:" + e);;
        }
    }

    public void MediaNotas(){
        for (int j = 0 ; j < notas.length; j++){
            media += notas[j]; 
        }
        media = media / notas.length;
        System.out.println("Media das notas = "+media);
    }

    public void MaiorQueMedia(){
        for (int j = 0 ; j < notas.length; j++){
            if (notas[j] >= media){
                System.out.println("Nota maior que a media => "+notas[j]);
            }
        }
    }

    //Este método foi só um complemento que fiz para testes
    public void NotasShow(){
        for (int j = 0 ; j <= notas.length; j++){
            System.out.println(notas[j]);
            }
    }
    
}
