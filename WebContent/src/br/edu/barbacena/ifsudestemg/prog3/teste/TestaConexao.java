package br.edu.barbacena.ifsudestemg.prog3.teste;

import br.edu.barbacena.ifsudestemg.prog3.modelo.Aluno;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Professor;
import br.edu.ifsudestemg.barbacena.prog3.dao.AlunoDAO;
import br.edu.ifsudestemg.barbacena.prog3.dao.ProfessorDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class TestaConexao {
    public static void main(String[] args) {
        String nome,endereco,email,grau;Long id;int opt;
        Scanner tecladoOptIf = new Scanner(System.in);
        Scanner tecladoOpt = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite:");
        System.out.println("1 => Digite Aluno para entrar:");
        System.out.println("2 => Digite Professor para entrar");
        opt = tecladoOptIf.nextInt(); 
        if(opt==1){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();
        alunoDAO.getConnection();
        System.out.println("Selecione a itens");
        System.out.println("1=> Inserir Aluno");
        System.out.println("2=> Alterar Aluno");
        System.out.println("3=> Remover Aluno");
        System.out.println("4=> Listar Alunos");
        int opcao = tecladoOpt.nextInt();
        switch(opcao){
            case 1:
                System.out.println("Digite Nome do Aluno");
                nome = teclado.nextLine();
                aluno.setNome(nome);
                System.out.println("Digite Email do Aluno");
                email = teclado.nextLine();
                aluno.setEmail(email);
                System.out.println("Digite Endereco do Aluno");
                endereco = teclado.nextLine();
                aluno.setEndereco(endereco);
                System.out.println("Digite Data de Nascimento");
                aluno.setDatanascimento(Calendar.getInstance());
                alunoDAO.adicionar(aluno);
                System.out.println("Dados Inseridos com Sucesso");
                break;
            case 2:
                System.out.println("Digite ID do Aluno");
                id = Long.parseLong(teclado.nextLine());
                aluno.setId(id);
                System.out.println("Digite Nome do Aluno");
                nome = teclado.nextLine();
                aluno.setNome(nome);
                System.out.println("Digite Email do Aluno");
                email = teclado.nextLine();
                aluno.setEmail(email);
                System.out.println("Digite Endereco do Aluno");
                endereco = teclado.nextLine();
                aluno.setEndereco(endereco);
                aluno.setDatanascimento(Calendar.getInstance());
                alunoDAO.altera(aluno);
                System.out.println("Dados Editados com Sucesso");
                break;
            case 3:
                System.out.println("Digite ID do Aluno");
                id = Long.parseLong(teclado.nextLine());
                aluno.setId(id);
                alunoDAO.remove(aluno);
                System.out.println("Dados Excluidos com Sucesso");
                break;
            case 4:
                alunoDAO.getContatos();
                AlunoDAO alunoConecta = new AlunoDAO();
		List<Aluno> alunosList = alunoConecta.getContatos();
		for (Aluno alunos:alunosList) {
			System.out.println("Alunos: ");
			System.out.println("Nome: " + alunos.getNome());
			System.out.println("Email: " + alunos.getEmail());
			System.out.println("Endereço: " + alunos.getEndereco());
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data de Nascimento: " +  format.format(
			alunos.getDatanascimento().getTime())+ "\n");
		}
                break;
            default:
                System.out.println("Indisponivel");
        }}else if(opt==2) {
            ProfessorDAO professorDAO = new ProfessorDAO();
            Professor professor = new Professor();
            professorDAO.getConnection();
            System.out.println("Selecione a itens");
            System.out.println("1=> Inserir Professor");
            System.out.println("2=> Alterar Professor");
            System.out.println("3=> Remover Professor");
            System.out.println("4=> Listar Professores");
            int opcao = tecladoOpt.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Digite Nome do Professor");
                    nome = teclado.nextLine();
                    professor.setNome(nome);
                    System.out.println("Digite Email do Professor");
                    email = teclado.nextLine();
                    professor.setEmail(email);
                    System.out.println("Digite Grau do Professor");
                    grau = teclado.nextLine();
                    professor.setGrau_formacao(grau);
                    professorDAO.adicionar(professor);
                    System.out.println("Dados Inseridos com Sucesso");
                    break;
                case 2:
                    System.out.println("Digite ID do Professor");
                    id = Long.parseLong(teclado.nextLine());
                    professor.setId(id);
                    System.out.println("Digite Nome do Professor");
                    nome = teclado.nextLine();
                    professor.setNome(nome);
                    System.out.println("Digite Email do Professor");
                    email = teclado.nextLine();
                    professor.setEmail(email);
                    System.out.println("Digite Grau do Professor");
                    grau = teclado.nextLine();
                    professor.setGrau_formacao(grau);
                    professorDAO.altera(professor);
                    System.out.println("Dados Editados com Sucesso");
                    break;
                case 3:
                    System.out.println("Digite ID do Professor");
                    id = Long.parseLong(teclado.nextLine());
                    professor.setId(id);
                    professorDAO.remove(professor);
                    System.out.println("Dados Excluidos com Sucesso");
                    break;
                case 4:
                    professorDAO.getContatos();
                    ProfessorDAO professorConecta = new ProfessorDAO();
                    List<Professor> professorsList = professorConecta.getContatos();
                    for (Professor professors:professorsList) {
                            System.out.println("Professores: ");
                            System.out.println("Nome: " + professors.getNome());
                            System.out.println("Email: " + professors.getEmail());
                            System.out.println("Grau: " + professors.getGrau_formacao());
                    }
                    break;
                default:
                    System.out.println("Indisponivel");
        }        
        }
    }
}
