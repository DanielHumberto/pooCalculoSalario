package exec;
import java.util.ArrayList;
import java.util.Scanner;
import model.Funcionario;
import model.Professor;
import model.STA;
import model.Terceirizado;
public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String help = "\t============= help =====================\n"+
				  "\tAddProf nome Classe: Cadastra um Professor pelo nome\n"+
				  "\tAddSTA nome nivel: Cadastra um STA pelo nome\n"+
				  "\tAddTer nome HorasTrabalhadas Insalubre: Cadastra um Terceirizado pelo nome\n"+
				  "\trm nome: remove Funcionário\n"+
				  "\tAddDiaria nome: Adiciona uma diária para um funcionário\n"+
				  "\tsetBonus quantidade: Modifica a quantidade de bônus para todos os Funcionários\n"+
				  "\tshow nome: Mostra Funcionário\n"+
				  "\tSair: Sai do programa\n"+
				  "\t========================================\n";
		char classe;
		int nivel;
		int horasTrabalhadas;
		boolean insalubre;
		String nome;
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		while(true){
			System.out.print("Digite um comando"+
						"(help para ver os comandos): ");
			String comando = in.nextLine();
			if(comando.equals("help")){
				System.out.println(help);
			} else if(comando.equals("Sair")){
				
				System.out.println("\tAté a próxima :)");
				break;
			} else {
				String c[] = comando.split(" ");
				switch(c[0]){
				case "AddProf":
					nome = c[1];
					classe = c[2].charAt(0);
					funcionarios.add(new Professor(nome, classe));
					break;
				case "AddSTA":
					nome = c[1];
					nivel = Integer.parseInt(c[2]);
					funcionarios.add(new STA(nome, nivel));									
					break;
				case "AddTer":
					nome = c[1];
					horasTrabalhadas = Integer.parseInt(c[2]);
					if(c[3].equals("sim")) {
						insalubre = true;
					}else {
						insalubre = false;
					}
					funcionarios.add(new Terceirizado(nome, horasTrabalhadas, insalubre));	
					break;
				case "rm":
					nome = c[1];
					int i = 0;
					for(Funcionario f : funcionarios) {
						if(f.getNome().equals(nome)) {
							funcionarios.remove(i);
							System.out.println("Removido com sucesso!");
							break;
						}
						i++;
					}			
					break;
				case "AddDiaria":
					
					break;
				case "setBonus":
					
					break;
				case "show":
					//funcionarios.get(i).getNome()					
					break;
				default:
					System.out.println("\tComando inválido.");					
				}
			}
		}
	}		
}