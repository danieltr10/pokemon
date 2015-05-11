import java.util.Scanner;


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
	
	public boolean redefinirPokemonAtivo(int nPokemon) {
		
		boolean sucesso = true;
		
		if (nPokemon >= 0 && nPokemon < 6) {
			pokemonAtivo = nPokemon;
		}
		else {
			sucesso = false;
		}
		
		return sucesso;
	}
	
	public int escolheUmPokemonVivo () {
		
		int[] pokemonsVivos = new int[6];
		int posicao_listaDePokemons = 0, posicao_pokemonsVivos = 0;
		
		while (posicao_listaDePokemons < 6) {
			if (listaDePokemons[posicao_listaDePokemons] != null && listaDePokemons[posicao_listaDePokemons].pokemonEstaVivo()) {
				pokemonsVivos[posicao_pokemonsVivos] = posicao_listaDePokemons;
				posicao_pokemonsVivos++;
				System.out.println(posicao_pokemonsVivos + ") " + listaDePokemons[posicao_listaDePokemons].getNome());
			}
			posicao_listaDePokemons++;
		}
		
		System.out.println("Digite o numero do novo pokemon ativo:");
		Scanner leituraDoTeclado = new Scanner (System.in);
		int pokemonEscolhido = leituraDoTeclado.nextInt();
		
		if (pokemonEscolhido >= 0 && pokemonEscolhido <= posicao_pokemonsVivos) {
			pokemonEscolhido = pokemonsVivos[pokemonEscolhido];
		}
		else {
			pokemonEscolhido = 6;
		}
		 leituraDoTeclado.close();
		 return pokemonEscolhido;
	}
}