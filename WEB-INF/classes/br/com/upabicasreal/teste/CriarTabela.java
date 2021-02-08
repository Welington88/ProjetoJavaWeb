package br.com.upabicasreal.teste;

import br.com.upabicasreal.modelo.Atendimento;

import java.util.Calendar;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.upabicasreal.modelo.Medico;
import br.com.upabicasreal.modelo.Paciente;

public class CriarTabela {
    public static void main(String[] args) {
    @SuppressWarnings("resource")
	Scanner teclado = new Scanner(System.in);//New cria um objeto
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("upabicas");
	EntityManager manager = factory.createEntityManager();
        
        System.out.println("Central de Atendimento UPA");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cadastro do Medico");
        System.out.println("Digite o Nome do Medico");
        String nome = teclado.nextLine();
        System.out.println("Digite o CRM do Medico");
        String crm = teclado.nextLine();
        System.out.println("Digite Telefone do Medico");
        String telefone = teclado.nextLine();
        System.out.println("Digite Area do Medico");
        String area = teclado.nextLine();
        System.out.println("Digite Salario do Medico");
        Double salario = Double.parseDouble(teclado.nextLine());
        Medico medico = new Medico(crm,nome,telefone,area,salario);
	
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cadastro Paciente");
        System.out.println("Digite o Nome do Paciente");
        String nomePac = teclado.nextLine();
        System.out.println("Digite o CPF do Paciente");
        String cpf = teclado.nextLine();
        System.out.println("Digite Telefone do Paciente");
        String telPac = teclado.nextLine();
        System.out.println("Digite Sexo do Paciente");
        String sexo = teclado.nextLine();
        System.out.println("Digite Data Nascimento do Paciente");
        Paciente paciente = new Paciente(cpf,nomePac,telPac,sexo,Calendar.getInstance());
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("Atendimento");
        System.out.println("Receita");
        String receita = teclado.nextLine();
        System.out.println("Recomendacoes");
        String recomendacoes = teclado.nextLine();
        
        Atendimento atendimento = new Atendimento(Calendar.getInstance(),
                receita,recomendacoes,paciente,medico);
        
	manager.getTransaction().begin();
	
	manager.persist(medico);
        manager.persist(paciente);
	manager.persist(atendimento);
        
	manager.getTransaction().commit();
	manager.close();
	factory.close();
    }
}
