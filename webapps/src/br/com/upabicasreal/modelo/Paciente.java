package br.com.upabicasreal.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.cdi.HibernateValidator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@HibernateValidator
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "CPF Invalido")
    //@NotEmpty(message = "Paciente deve ter um CPF inv�lido")
    private String cpf;
    @NotEmpty(message = "Paciente deve ter um nome valido")
    private String nome;
    @NotEmpty(message = "Paciente deve ter um Telefone valido")
    private String telefone;
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Calendar dataNasc = Calendar.getInstance();
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy="paciente")
    private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
    
    public Paciente(){
        super();
    }
    public Paciente(Long id, String cpf, String nome, String telefone, String sexo, Calendar dataNasc) {
        super();
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
    }
    
    public Paciente(String cpf, String nome, String telefone, String sexo, Calendar dataNasc) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        if(dataNasc == null){
        	dataNasc = Calendar.getInstance();
        }
    	this.dataNasc = dataNasc;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Paciente setPaciente(Paciente paciente) {
        return paciente;
    }
    
}
