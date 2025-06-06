package Entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false,length = 100)
    private String nome;
    private String endereco;
    private String cnpj;
    

    public Fornecedor() {
    }

    public Fornecedor(String nome, String endereco, String cnpj) {
       
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
