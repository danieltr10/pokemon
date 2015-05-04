
public class Treinador {
	
	private String nome;
	private Pokemon[] listaDePokemons = new Pokemon[6];
	private int pokemonAtivo = 0;
	
	public Treinador(ListaDePokemons pokemonsDisponiveis, String nome, int pokemon0, int pokemon1, int pokemon2, int pokemon3, int pokemon4, int pokemon5) {
		this.nome =  nome;
		
		listaDePokemons[0] = pokemonsDisponiveis.getPokemon(pokemon0);
		listaDePokemons[1] = pokemonsDisponiveis.getPokemon(pokemon1);
		listaDePokemons[2] = pokemonsDisponiveis.getPokemon(pokemon2);
		listaDePokemons[3] = pokemonsDisponiveis.getPokemon(pokemon3);
		listaDePokemons[4] = pokemonsDisponiveis.getPokemon(pokemon4);
		listaDePokemons[5] = pokemonsDisponiveis.getPokemon(pokemon5);
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