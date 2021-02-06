package br.com.upabicasreal.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.upabicasreal.dao.DAO;
import br.com.upabicasreal.modelo.Medico;

@ManagedBean
@ViewScoped
public class MedicoBean {
	private Medico medico = new Medico();
	private List<Medico> medicos;
	
	public Medico getMedico() { 
		return this.medico; 
	} 

	public List<Medico> getMedicos() { 
		if (medicos == null) { 
		System.out.println("Carregando m�dicos..."); 
		medicos = new DAO<Medico>(Medico.class).listaTodos(); 
		} 
		return medicos; 
	} 
	/*public void grava() { // antigo  metodo
		System.out.println("Entrei no Metodo Gravar Antigo...");
		DAO<Medico> dao = new DAO<Medico>(Medico.class); 
		dao.adiciona(medico); 
		this.medico = new Medico();
	}*/
	public void grava() {
	  DAO<Medico> dao = new DAO<Medico>(Medico.class);
	  System.out.println(medico.getCrm());
	  System.out.println("Entrei no Metodo Gravar Novo....");
	  if (medico.getCrm() == null) {
		  dao.adiciona(medico);
	  } else {
		  dao.atualiza(medico);
	  }
	  this.medico = new Medico();
	  this.medicos = dao.listaTodos();
	}
	
	public void remove(Medico medico) {
		System.out.println(medico.getCrm());
		System.out.println("Entrei no Metodo Remover...");
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		dao.remove(medico);
		this.medicos = dao.listaTodos();
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public void cancela() {
		this.medico = new Medico();
	}
	public double getTotal(){
		double total = 0;
		for (Medico medico : medicos) {
			total+=medico.getSalario();
		}
		return total;
	}
	public Medico buscaMedico(Long id){
		Medico medico = new Medico();
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		medico = dao.buscaPorld(id);
		return medico;
	}
}
