
public class Pokemon {
	
	private String nome;
	private int HP;
	private Ataque[] listaDeAtaques = new Ataque[4];
		
	public Pokemon (String nomePokemon, int HP) {
		nome = nomePokemon;
		this.HP = HP;
	}
	
	public void criaAtaque (int ataque, int dano, String nome, int prioridade) {
		listaDeAtaques[ataque] = new Ataque(dano, nome, prioridade);
	}
	
	public void reduzirHP(int dano) {
		HP -= dano;
	}
	
	public void curarHP(int cura) {
		HP += cura;
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
}

