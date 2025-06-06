package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {
    private static String PERSISTENCE_UNIT = "kalangosystem";
    private static EntityManager gerente;
    private static EntityManagerFactory fabrica;
    
    public static EntityManager conectar(){
        if(fabrica == null || !fabrica.isOpen()){
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            System.out.println("Conexao realziada!");
        }if(gerente == null || !gerente.isOpen()){
            gerente = fabrica.createEntityManager();
        }
        return gerente;
    }
    public static void desconectar(){
        if(gerente == null && gerente.isOpen()){
            gerente.close();
            fabrica.close();
        }
    }
}
