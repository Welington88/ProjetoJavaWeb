package br.com.upabicasreal.teste;

import java.util.Calendar;
import java.util.Scanner;
import br.com.upabicasreal.mb.MedicoBean;
import br.com.upabicasreal.mb.PacienteBean;
import br.com.upabicasreal.modelo.Atendimento;
import br.com.upabicasreal.modelo.Medico;
import br.com.upabicasreal.modelo.Paciente;

public class TestAtendimento {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);//New cria um objeto
			
			Medico medico = new Medico();
	        System.out.println("Central de Atendimento UPA");
	        System.out.println("-------------------------------------------------------------");
	        System.out.println("Id do Medico");
	        Long id = Long.parseLong(teclado.nextLine());
	        medico.setId(id);
	        MedicoBean medicoBean = new MedicoBean();
	        medico = medicoBean.buscaMedico(id);
	        System.out.println(medico.getNome());
	        System.out.println("-------------------------------------------------------------");
	        System.out.println("Digite Id do Paciente");
	        Long Id = Long.parseLong(teclado.nextLine());
	        Paciente paciente = new Paciente();
	        paciente.setId(Id);
	        PacienteBean pacienteBean = new PacienteBean();
	        paciente =  pacienteBean.buscaPaciente(Id);
	        System.out.println(paciente.getNome());
	        System.out.println("-------------------------------------------------------------");
	        System.out.println("Atendimento");
	        System.out.println("Receita");
	        String receita = teclado.nextLine();
	        System.out.println("Recomendacoes");
	        String recomendacoes  = teclado.nextLine();
	        
	        @SuppressWarnings("unused")
			Atendimento atendimento = new Atendimento(Calendar.getInstance(),
	                receita,recomendacoes,paciente,medico);
	        
	        pacienteBean.guardaAtendimento(paciente,medico);
    }
}
