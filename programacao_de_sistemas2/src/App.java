import java.io.*;

public class App {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("times.txt");
            InputStreamReader isr = new InputStreamReader (is);
            BufferedReader br = new BufferedReader (isr);
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] info = linha.split(",");
                System.out.println(info[1] +
                ", estádio" + info[2] +
                ", fundado em" + info[0]);

            }
            br.close();
    } catch(IOException ex) {
}
    System.out.println("Erro ao ler o arquivo!");
}
}
