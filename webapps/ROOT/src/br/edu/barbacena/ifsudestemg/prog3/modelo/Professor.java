package br.edu.barbacena.ifsudestemg.prog3.modelo;
public class Professor {
	Long id;String nome, email, grau_formacao;
    
    public Professor(){
        
    }
    public Professor(Long id, String nome, String email, String grau_formacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.grau_formacao = grau_formacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrau_formacao() {
        return grau_formacao;
    }

    public void setGrau_formacao(String grau_formacao) {
        this.grau_formacao = grau_formacao;
    }
        
    
}
