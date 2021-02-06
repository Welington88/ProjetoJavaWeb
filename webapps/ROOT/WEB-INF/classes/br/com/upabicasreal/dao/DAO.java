package br.com.upabicasreal.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import br.com.upabicasreal.jpa.JPAUtil;
import java.util.List;

public class DAO<T> {
	private final Class<T> classe;
	public DAO(Class<T> classe) {
		this.classe = classe;
	}
	
	public void adiciona(T t) {
		// consegue a entity manager
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		// persiste o objeto
		em.persist(t);

		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}
	
	public void remove(T t) {
		// consegue a entity manager
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		// remove o objeto
		Object o = em.merge(t);
		em.remove(o);

		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}

	public void atualiza(T t) {
		// consegue a entity manager
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		em.merge(t);

		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}
	
	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();

		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}

	public T buscaPorld(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		return (T) em.find(classe, id);
	}
}
