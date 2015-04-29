
public class Treinador {
	
	private String nome;
	private Pokemon[] listaDePokemons = new Pokemon[6];
	private int pokemonAtivo = 0;
	
	public Treinador(String nome) {
		this.nome =  nome;
		listaDePokemons[0] = new Pokemon("Charmander","Fogo", 200, "Bola de fogo", 15, 3, "Lanca Chamas", 25, 4, "Explosao", 50, 5, "Apocalipse", 100, 6);
		listaDePokemons[1] = new Pokemon("Pikachu","Raio", 200, "Choque Leve", 15, 3, "Curto Circuito", 25, 4, "Eletrocutar", 50, 5, "Choque do Trovao", 100, 6);
		listaDePokemons[2] = new Pokemon("Teste3","Raio", 200, "Choque Leve", 15, 3, "Curto Circuito", 25, 4, "Eletrocutar", 50, 5, "Choque do Trovao", 100, 6);
		listaDePokemons[3] = new Pokemon("Teste4","Raio", 200, "Choque Leve", 15, 3, "Curto Circuito", 25, 4, "Eletrocutar", 50, 5, "Choque do Trovao", 100, 6);
		listaDePokemons[4] = new Pokemon("Teste5","Raio", 200, "Choque Leve", 15, 3, "Curto Circuito", 25, 4, "Eletrocutar", 50, 5, "Choque do Trovao", 100, 6);
		listaDePokemons[5] = new Pokemon("Teste6","Raio", 200, "Choque Leve", 15, 3, "Curto Circuito", 25, 4, "Eletrocutar", 50, 5, "Choque do Trovao", 100, 6);
		
	}
	
	public Pokemon getPokemonAtivo() {
		return listaDePokemons[pokemonAtivo];
	}
	
	public String getNome() {
		return nome;
	}
	
	public void escolherPokemonAtivo(int nPokemon) {
		pokemonAtivo = nPokemon;
	}
}
