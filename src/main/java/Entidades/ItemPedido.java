package Entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity(name = "itempedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private double preco_unico;
    private int quantidade;
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    public ItemPedido() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecoUnico() {
        return preco_unico;
    }

    public void setPrecoUnico(double precoUnico) {
        this.preco_unico = precoUnico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
