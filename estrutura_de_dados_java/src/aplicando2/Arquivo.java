package aplicando2;

import java.io.*;

public class Arquivo {
    public static void main(String[] args){

        try{

            InputStream is = new FileInputStream("alunos.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            Notas n1 = new Notas (br);
            n1.MediaNotas();
            n1.MaiorQueMedia();

            br.close();

        } catch (IOException ex){
            System.out.println("Erro na abertura do arquivo.");
        }
        System.out.println("fim de programa");
    }
}

