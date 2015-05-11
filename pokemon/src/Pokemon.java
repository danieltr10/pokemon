import java.util.Scanner;


public class Pokemon {
	
	private String nome;
	private int HPmax;
	private int HP;
	private boolean vivo = true;
	private Ataque[] listaDeAtaques = new Ataque[4];
		
	public Pokemon (String nomePokemon, int HP) {
		nome = nomePokemon;
		this.HP = HP;
		this.HPmax = HP;
	}
	
	public void criaAtaque (int ataque, int dano, String nome, int prioridade) {
		listaDeAtaques[ataque] = new Ataque(dano, nome, prioridade);
	}
	
	public void reduzirHP(int dano) {
		if (HP - dano > 0) {
			HP -= dano;
		}
		else {
			HP = 0;
			vivo = false;
		}
	}
	
	public void curarHP(int cura) {
		if (HP + cura < HPmax) {
			HP += cura;
		}
		else {
			HP = HPmax;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getDanoAtaque(Ataque tipoAtaque) {
		return tipoAtaque.getDano();
	}
	
	public boolean pokemonEstaVivo() {
		return vivo;
	}
	
	public Ataque escolherAtaque() {
		System.out.println("Lista de ataques do seu pokemon:");
		int i = 0;
		while (i < 4 && listaDeAtaques[i] != null) {
			System.out.println(i + ") " + listaDeAtaques[i].getNome());
			i++;
		}
		
		boolean sucesso = false;
		Scanner leituraDoTeclado = new Scanner (System.in);
		int numeroAtaqueEscolhido;
		Ataque ataqueEscolhido = null;
		while (!sucesso) {
			System.out.println("Escolha o ataque que deseja usar:");
			numeroAtaqueEscolhido = leituraDoTeclado.nextInt();
			
			if (numeroAtaqueEscolhido >= 0 && numeroAtaqueEscolhido < i) {
				ataqueEscolhido = listaDeAtaques[numeroAtaqueEscolhido];
				sucesso = true;
			}
			else {
				System.out.println("Ataque inválido!!");
			}
		}
		
		leituraDoTeclado.close();
		return ataqueEscolhido;
	}
}

