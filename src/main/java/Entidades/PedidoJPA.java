
package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class PedidoJPA {
    public static void inserir(Pedido pedido){
       EntityManager em = Conexao.conectar();

       try{
           em.getTransaction().begin();
           List<ItemPedido>itens = pedido.getItens();
           if(itens!=null){
               for (ItemPedido i: itens){
                   i.setPedido(pedido);
                   em.persist(pedido);
               }
           }
           em.getTransaction().commit();
           System.out.println("Venda registrada com sucesso!");
       }catch(Exception e){
           em.getTransaction().rollback();
           System.out.println("Erro ao registrar venda: " + e.getMessage());
       }finally{
           em.close();
       }
   }
   public static List<Pedido> listar(){
       EntityManager em = Conexao.conectar();
       List<Pedido> vendas = new ArrayList<>();
       try{
          Query query = em.createQuery("SELECT p FROM pedido p");
           vendas = query.getResultList();
       }catch (Exception e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        } finally {
            Conexao.desconectar();
        }
       return vendas;
   }
   public static void excluir(int id){
       EntityManager em = Conexao.conectar();
       try{
           Pedido p = em.find(Pedido.class, id);
           if(p !=null){
               em.getTransaction().begin();
               em.remove(p);
               em.getTransaction().commit();
           }
       }catch(Exception ex){
           em.getTransaction().rollback();
           System.out.println("Erro ao excluir venda: " +ex.getMessage());
       }finally{
           em.close();
       }
   }
}
