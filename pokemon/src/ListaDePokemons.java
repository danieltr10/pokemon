
public class ListaDePokemons {
	
	private int numeroDePokemons = 12;
	private Pokemon[] listaDePokemons = new Pokemon[numeroDePokemons];
	
	public ListaDePokemons() {
	listaDePokemons[0] = new Pokemon("Pikachu", 200);
	listaDePokemons[0].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[0].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[0].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[0].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[1] = new Pokemon("Pikachu2", 200);
	listaDePokemons[1].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[1].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[1].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[1].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[2] = new Pokemon("Pikachu3", 200);
	listaDePokemons[2].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[2].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[2].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[2].criaAtaque(3, 100, "Choque do Trovão", 6);

	listaDePokemons[3] = new Pokemon("Pikachu4", 200);
	listaDePokemons[3].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[3].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[3].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[3].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[4] = new Pokemon("Pikachu5", 200);
	listaDePokemons[4].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[4].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[4].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[4].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[5] = new Pokemon("Pikachu6", 200);
	listaDePokemons[5].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[5].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[5].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[5].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[6] = new Pokemon("Pikachu7", 200);
	listaDePokemons[6].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[6].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[6].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[6].criaAtaque(3, 100, "Choque do Trovão", 6);

	listaDePokemons[7] = new Pokemon("Pikachu8", 200);
	listaDePokemons[7].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[7].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[7].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[7].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[8] = new Pokemon("Pikachu9", 200);
	listaDePokemons[8].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[8].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[8].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[8].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[9] = new Pokemon("Pikachu10", 200);
	listaDePokemons[9].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[9].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[9].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[9].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[10] = new Pokemon("Pikachu11", 200);
	listaDePokemons[10].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[10].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[10].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[10].criaAtaque(3, 100, "Choque do Trovão", 6);
	
	listaDePokemons[11] = new Pokemon("Pikachu12", 200);
	listaDePokemons[11].criaAtaque(0, 15, "Choque Leve", 3);
	listaDePokemons[11].criaAtaque(1, 25, "Curto Circuito", 4);
	listaDePokemons[11].criaAtaque(2, 50, "Eletrocutar", 5);
	listaDePokemons[11].criaAtaque(3, 100, "Choque do Trovão", 6);
	}
	
	public void mostraLista() {
		System.out.println("Lista de Pokemons:");
		
		System.out.println("0) Não quero mais pokemons!");
		int i = 0;
		while (i < numeroDePokemons) {
			System.out.println((i + 1) + ") " + listaDePokemons[i].getNome());
			i++;
		}
	}
	
	public int getNumeroDePokemons() {
		return numeroDePokemons;
	}
	
	public Pokemon getPokemon(int pokemon) {
		if (pokemon >= 0 && pokemon < numeroDePokemons) {
			return listaDePokemons[pokemon];
		}
		else {
			return null;
		}
	}
}
