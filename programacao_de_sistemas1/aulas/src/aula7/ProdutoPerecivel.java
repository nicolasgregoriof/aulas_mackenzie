package aula7;

public class ProdutoPerecivel extends Produto {
    protected int validade;
    
    ProdutoPerecivel(String nome, int quantidade, double preco, int validade){
        super(nome,quantidade,preco);
        this.validade = validade;
    }
    
    @Override
    public void retiraEstoque(int qtdeRetira) {
        if (validade<2)
            if (super.quantidade>0)
                super.quantidade -= super.quantidade;
            else
                super.quantidade = super.quantidade;
        else
            super.retiraEstoque(qtdeRetira);
        }
    
    @Override
    public void entraEstoque(int qtdeEntrada){
        if(super.quantidade == 0)
            super.quantidade += qtdeEntrada;
        else
            super.quantidade = super.quantidade;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nValidade: "+validade;
    }
}