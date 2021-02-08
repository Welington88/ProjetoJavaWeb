package br.com.upabicasreal.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String crm;
	@NotEmpty(message = "Médico deve ter um nome válido")
	private String nome;
	@NotEmpty(message = "Médico deve ter um Telefone v�lido")
	private String telefone;
	private String area;
	private Double Salario;
	public Medico (){
		super();
	}
	public Medico(String crm, String nome, String telefone, String area, Double salario) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.telefone = telefone;
		this.area = area;
		Salario = salario;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Double getSalario() {
		return Salario;
	}
	public void setSalario(Double salario) {
		Salario = salario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
