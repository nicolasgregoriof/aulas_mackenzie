package aplicandoa3;

public class Motocicleta{
    String modelo;
    String marca;
    int nroChassi;
    String nroPlaca;
    String cor;
    int nroCilindradas;

    public String licenciar(){
        int tamanho = nroPlaca.length();
        String valor = nroPlaca.substring(tamanho-1);
        String mesLic = "";

        switch (valor){
            case "1":
                mesLic = "abril";
                break;
            case "2":
                mesLic = "maio";
                break;
            case "3":
                mesLic = "junho";
                break;
            case "4":
                mesLic = "julho";
                break;
            case "5":
                mesLic = "agosto";
                break;
            case "6":
                mesLic = "agosto";
                break;
            case "7":
                mesLic = "setembro";
                break;
            case "8":
                mesLic = "outubro";
                break;
            case "9":
                mesLic = "novembro";
                break;
            case "0":
                mesLic = "dezembro";
                break;
        }
        return mesLic;
    }

    public boolean checaChassi(int nro){
        if (nro == nroChassi)
            return true;
        else
            return false;
        
    }
}

