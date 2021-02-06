package br.edu.barbacena.ifsudestemg.prog3.modelo;

import java.util.Calendar;

public class Aluno {
	Long id;String nome,email,endereco; Calendar datanascimento;
    public Aluno(){
    }
    public Aluno(Long id, String nome, String email, String endereco, Calendar datanascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.datanascimento = datanascimento;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Calendar getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Calendar datanascimento) {
        this.datanascimento = datanascimento;
    }
    
    
}
