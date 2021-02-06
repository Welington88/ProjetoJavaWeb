package br.com.upabicasreal.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.upabicasreal.jpa.JPAUtil;
import br.com.upabicasreal.modelo.Usuario;

public class UsuarioDAO {
	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Usuario u where u.login = "
				+ ":pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		boolean encontrado = !query.getResultList().isEmpty();
		em.getTransaction().commit();
		em.close();
		return encontrado;
	}	
}
