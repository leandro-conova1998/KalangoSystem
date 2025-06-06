package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorJPA {
      public static void cadastrarFornecedor(Fornecedor f){
        EntityManager em = Conexao.conectar();
        try{
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Fornecedor! " + e.getMessage());
        }finally{
            Conexao.desconectar();
        }
    }
    public static List<Fornecedor> findAll() {
        EntityManager em = Conexao.conectar();
        TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM fornecedor f", Fornecedor.class);
        return query.getResultList();
    }
    public static Fornecedor findByNome(String nome) {
        EntityManager em = Conexao.conectar();
        TypedQuery<Fornecedor> query = em.createQuery(
            "SELECT f FROM fornecedor f WHERE f.nome = :nome", Fornecedor.class);
        query.setParameter("nome", nome);

        // Retorna o primeiro resultado ou null se não encontrar
        return query.getResultStream().findFirst().orElse(null);
    }
    public static void removerFornecedor(int id) {
    EntityManager em = Conexao.conectar();
    try {
        em.getTransaction().begin();

        // Busca o fornecedor pelo ID
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        if (fornecedor != null) {
            // Remove o fornecedor encontrado
            em.remove(fornecedor);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
        } else {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
        }
    } catch (Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Erro ao remover Fornecedor! " + e.getMessage());
    } finally {
        Conexao.desconectar();
    }
}
}
    
