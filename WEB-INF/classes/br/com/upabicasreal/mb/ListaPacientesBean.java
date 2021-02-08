package br.com.upabicasreal.mb;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.upabicasreal.dao.DAO;
import br.com.upabicasreal.modelo.Atendimento;
import br.com.upabicasreal.modelo.Paciente;

@SuppressWarnings("serial")
@ManagedBean
public class ListaPacientesBean implements Serializable{
	@SuppressWarnings("unused")
	private Paciente paciente = new Paciente();
	private List<Atendimento> atendimentos;
	
	public List<Atendimento> getAtendimentos(){
		System.out.println("Entrei no metodo");
		if(this.atendimentos == null){
			System.out.println("Carregando Pacientes");
			atendimentos = new DAO<Atendimento>(Atendimento.class).listaTodos();
		}
		return atendimentos;
	}
}
