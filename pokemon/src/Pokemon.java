
public class Pokemon {
	
	private String nome;
	private int HP;
	private Ataque[] listaDeAtaques;
	//private String tipo;
	
	public Pokemon (String nomePokemon, String tipo, int HP, String nomeAtaque1, int danoAtaque1, int prioridadeAtaque1, String nomeAtaque2, int danoAtaque2, int prioridadeAtaque2, String nomeAtaque3, int danoAtaque3, int prioridadeAtaque3, String nomeAtaque4, int danoAtaque4, int prioridadeAtaque4) {
		
		nome = nomePokemon;
		this.HP = HP;
		
		listaDeAtaques[0] = new Ataque(prioridadeAtaque1);
		listaDeAtaques[1] = new Ataque(prioridadeAtaque2);
		listaDeAtaques[2] = new Ataque(prioridadeAtaque3);
		listaDeAtaques[3] = new Ataque(prioridadeAtaque4);
		
		listaDeAtaques[0].setNomeAtaque(nomeAtaque1);
		listaDeAtaques[1].setNomeAtaque(nomeAtaque2);
		listaDeAtaques[2].setNomeAtaque(nomeAtaque3);
		listaDeAtaques[3].setNomeAtaque(nomeAtaque4);
		
		listaDeAtaques[0].setDano(danoAtaque1);
		listaDeAtaques[1].setDano(danoAtaque2);
		listaDeAtaques[2].setDano(danoAtaque3);
		listaDeAtaques[3].setDano(danoAtaque4);
		
		
	}


}

