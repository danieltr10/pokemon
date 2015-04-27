
public class Pokemon {
	
	private String nome;
	private int HP;
	private Ataque[] listaDeAtaques = new Ataque[3];
	private String tipo;
	
	public Pokemon (String nomePokemon, String tipo, int HP, String nomeAtaque1, int prioridadeAtaque1, String nomeAtaque2, int prioridadeAtaque2, String nomeAtaque3, int prioridadeAtaque3, String nomeAtaque4, int prioridadeAtaque4) {
		
		nome = nomePokemon;
		this.HP = HP;
		listaDeAtaques[0].nomeAtaque = nomeAtaque1;
		
	}
	


}

