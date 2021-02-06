package br.com.upabicasreal.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Calendar data;
    @NotEmpty(message = "Atendimento Campo Receita preenchido")
    private String receita;
    @NotEmpty(message = "Atendimento Campo Recomendacões preenchido")
    private String recomendacoes;
    @OneToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;
    @OneToOne
    @JoinColumn(name="medico_id")
    private Medico medico;
    
    public Atendimento(){
            super();
    }
    public Atendimento(Long id, Calendar data, String receita, String recomendacoes) {
        super();
        this.id = id;
        this.data = data;
        this.receita = receita;
        this.recomendacoes = recomendacoes;
    }
    public Atendimento(Calendar data, String receita, String recomendacoes) {
        super();
        this.data = data;
        this.receita = receita;
        this.recomendacoes = recomendacoes;
    }
    public Atendimento(Long id, Calendar data, String receita, String recomendacoes, Paciente paciente, Medico medico) {
        super();
        this.id = id;
        this.data = data;
        this.receita = receita;
        this.recomendacoes = recomendacoes;
        this.paciente = paciente;
        this.medico = medico;
    }
    
    public Atendimento(Calendar data, String receita, String recomendacoes, Paciente paciente, Medico medico) {
        super();
        this.data = data;
        this.receita = receita;
        this.recomendacoes = recomendacoes;
        this.paciente = paciente;
        this.medico = medico;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}