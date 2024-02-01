package aula6;

public class Pedido {
    int numero;
    Produto item;
    int quantidade;
    Double valor;
    
    Pedido(int numero, Produto item, int quantidade){
        this.numero = numero;
        this.item = item;
        this.quantidade = quantidade;
    }
    
    public void calculaPedido(){
        valor = quantidade * item.preco;
    }
    
    public String toString(){
        return "Número do pedido: "+ this.numero +
            "\nCódigo do Produto: "+ this.item.cod +
            "\nDescrição: "+ this.item.descricao +
            "\nPreço do Produto: "+ this.item.preco +
           "\nQuantidade: " + this.quantidade +
            "\nValor: " + this.valor;
    }
}