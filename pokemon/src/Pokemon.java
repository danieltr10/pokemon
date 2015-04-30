
public class Pokemon {
	
	private String nome;
	private int HP;
	private Ataque[] listaDeAtaques = new Ataque[4];
	//private String tipo;
	
	public Pokemon (String nomePokemon, String tipo, int HP, String nomeAtaque1, int danoAtaque1, int prioridadeAtaque1, String nomeAtaque2, int danoAtaque2, int prioridadeAtaque2, String nomeAtaque3, int danoAtaque3, int prioridadeAtaque3, String nomeAtaque4, int danoAtaque4, int prioridadeAtaque4) {
		
		nome = nomePokemon;
		this.HP = HP;
		
		listaDeAtaques[0] = new Ataque(danoAtaque1, nomeAtaque1, prioridadeAtaque1);
		listaDeAtaques[1] = new Ataque(danoAtaque2, nomeAtaque2, prioridadeAtaque2);
		listaDeAtaques[2] = new Ataque(danoAtaque3, nomeAtaque3, prioridadeAtaque3);
		listaDeAtaques[3] = new Ataque(danoAtaque4, nomeAtaque4, prioridadeAtaque4);
	
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

