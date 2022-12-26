package br.com.felipe.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");// a string e o nome do <persistence-unit>
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}
