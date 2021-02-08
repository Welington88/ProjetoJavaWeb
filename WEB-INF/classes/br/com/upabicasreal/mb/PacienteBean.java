package br.com.upabicasreal.mb;
import br.com.upabicasreal.dao.DAO;
import br.com.upabicasreal.modelo.Atendimento;
import br.com.upabicasreal.modelo.Medico;
import br.com.upabicasreal.modelo.Paciente;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PacienteBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Paciente paciente = new Paciente();
    private Medico medico = new Medico();
    private Long idMedico,idPaciente;
    private Atendimento atendimento = new Atendimento();
    private List<Paciente> pacientes;
    
    public Paciente getPaciente() { // retorna o paciente
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Paciente> getPacientes(){
    	if(pacientes == null){
    		System.out.println("Carregando médicos...");
    		pacientes = new DAO<Paciente>(Paciente.class).listaTodos();
    	}
    	return pacientes;
    }
     public void grava() {
        DAO<Paciente> dao = new DAO<>(Paciente.class);
        System.out.println("Entrei no Metodo Gravar Paciente " + paciente.getNome());
        if(paciente.getId() == null){
        	dao.adiciona(paciente);
        }else{
        	dao.atualiza(paciente);
        }
        this.paciente = new Paciente();
        this.pacientes = dao.listaTodos();
    }
    public void guardaAtendimento() {
         DAO<Medico> dao = new DAO<>(Medico.class);
         DAO<Paciente> daoPac = new DAO<>(Paciente.class);
         medico = dao.buscaPorld(idMedico);
         paciente = daoPac.buscaPorld(idPaciente);
         System.out.println(medico.getNome());
         atendimento.setMedico(medico);
         System.out.println("Nome do Médico =>" + medico.getNome());
         atendimento.setPaciente(paciente);
         System.out.println("Nome do Paciente =>" + paciente.getNome());
         System.out.println("Receita =>" + atendimento.getReceita());
         System.out.println("Recomendações =>" + atendimento.getRecomendacoes());
         
         paciente.getAtendimentos().add(atendimento);
         atendimento.setPaciente(paciente);
         //Lógica adicional para setar os atributos do atendimento
         //this.atendimento = new Atendimento();
         this.atendimento = new Atendimento(Calendar.getInstance(),atendimento.getReceita(), 
        		 atendimento.getRecomendacoes(),paciente,medico);
     }
    public void adiciona(){
    	System.out.println("Entrei no Metodo Adiciona Paciente");
    	DAO<Atendimento> dao = new DAO<>(Atendimento.class);
    	dao.adiciona(atendimento);
    	this.paciente = new Paciente();
    	this.atendimento = new Atendimento();
    }
    public void guardaAtendimento(Paciente paciente,Medico medico) {
        DAO<Medico> dao = new DAO<>(Medico.class);
        DAO<Paciente> daoPac = new DAO<>(Paciente.class);
        medico = dao.buscaPorld(idMedico);
        paciente = daoPac.buscaPorld(idPaciente);
        System.out.println(medico.getNome());
        atendimento.setMedico(medico);
        System.out.println("Nome do Médico =>" + medico.getNome());
        atendimento.setPaciente(paciente);
        System.out.println("Nome do Paciente =>" +paciente.getNome());
        
        System.out.println("Receita =>" + atendimento.getReceita());
        System.out.println("Recomendações =>" + atendimento.getRecomendacoes());
        paciente.getAtendimentos().add(atendimento);
        //Lógica adicional para setar os atributos do atendimento
        atendimento = new Atendimento();
    }
    public void cancela(){
    	this.paciente = new Paciente();
    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }
    
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public Paciente buscaPaciente(Long id){
		Paciente paciente = new Paciente();
		DAO<Paciente> dao = new DAO<Paciente>(Paciente.class);
		paciente = dao.buscaPorld(id);
		return paciente;
	}
	public void remove(Paciente paciente) {
		System.out.println(paciente.getCpf());
		System.out.println("Entrei no Metodo Remover...");
		DAO<Paciente> dao = new DAO<>(Paciente.class);
		dao.remove(paciente);
		this.pacientes = dao.listaTodos();
	}
}
