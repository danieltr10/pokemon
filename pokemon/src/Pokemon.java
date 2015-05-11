
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
	
	public int getDanoAtaque(int tipoAtaque) {
		return listaDeAtaques[tipoAtaque].getDano();
	}
	
	public boolean pokemonEstaVivo() {
		return vivo;
	}
}

