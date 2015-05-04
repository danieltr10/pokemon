import java.util.Scanner;


public class GameControls extends Controller {
	
	public Treinador criaTreinador() {
		ListaDePokemons pokemonsDisponiveis = new ListaDePokemons();
		
		Scanner leituraDoTeclado = new Scanner (System.in);
		System.out.println("Novo treinador, digite o seu nome:");
		String nome = leituraDoTeclado.next();
		
		System.out.println("Agora, escolha os pokemons com os quais quer batalhar.");
		pokemonsDisponiveis.mostraLista();
		
		System.out.println("Digite o numero correspondente ao pokemon desejado...");
		int[] pokemonsDesejados = new int[6];
		int i = 0;
		boolean naoMaisPokemons = false;
		
		while (i < 6) {
			
			if (!naoMaisPokemons) {
				System.out.println("Pokemon" + i + ":");
				pokemonsDesejados[i] = leituraDoTeclado.nextInt();
				
				if (pokemonsDesejados[i] == 0) {
					pokemonsDesejados[i] = pokemonsDisponiveis.getNumeroDePokemons();
					naoMaisPokemons = true;
				}
			}
			else {
				pokemonsDesejados[i] = pokemonsDisponiveis.getNumeroDePokemons();
			}
			i++;
		}
		
		leituraDoTeclado.close();
		
		return new Treinador(pokemonsDisponiveis, nome, pokemonsDesejados[0], pokemonsDesejados[1], pokemonsDesejados[2], pokemonsDesejados[3], pokemonsDesejados[4], pokemonsDesejados[5]);
	}
	
	Treinador treinador1 = criaTreinador();
	Treinador treinador2 = criaTreinador();
	
	public class Atacar extends Event {
		
		private Treinador agressor, alvo;
		private int tipoAtaque;
		
		public Atacar(int prioridade, Treinador agressor, Treinador alvo, int tipoAtaque) {
			super(prioridade);
			this.agressor = agressor;
			this.alvo = alvo;
			this.tipoAtaque = tipoAtaque;
		}
		
		public void action() {
			Pokemon pokAgressor = agressor.getPokemonAtivo();
			Pokemon pokAlvo = alvo.getPokemonAtivo();
			
			int danoAtaque = pokAgressor.getDanoAtaque(tipoAtaque);
			
			pokAlvo.reduzirHP(danoAtaque);			
		}

		public String description() {
			Pokemon pokAgressor = agressor.getPokemonAtivo();
			Pokemon pokAlvo = alvo.getPokemonAtivo();
			
			return "O jogador " + agressor.getNome() + " atacou o pokemon " + pokAlvo.getNome() + "("+ pokAlvo.getHP() + ")" + " do jogador "
					+ alvo.getNome() + " com o pokemon " + pokAgressor.getNome() + "("+ pokAgressor.getHP() + ")";
		}
	}
	
	public class usarItem extends Event {
		
		private Treinador alvo;
		private int cura = 20;
		
		public usarItem(Treinador alvo) {
			super(2); // Evento de prioridade 2
			this.alvo = alvo;
		}
		
		public void action() {
			Pokemon pokAlvo = alvo.getPokemonAtivo();
			pokAlvo.curarHP(cura);
		}

		public String description() {
			Pokemon pokAlvo = alvo.getPokemonAtivo();
			return "O jogador " + alvo.getNome() + " curou o pokemon " + pokAlvo.getNome() + "(" + pokAlvo.getHP() + ")";
		}
	}

	public class trocarPokemon extends Event {
		
		private Treinador treinador;
		private int novoPokemon;
		
		public trocarPokemon(Treinador treinador, int novoPokemon) {
			super(1); // Evento de prioridade 1
			this.treinador = treinador;
			this.novoPokemon = novoPokemon;
		}
		
		public void action() {
			treinador.escolherPokemonAtivo(novoPokemon);
		}

		public String description() {
			Pokemon pokAtivo = treinador.getPokemonAtivo();
			return "O jogador " + treinador.getNome() + " escolheu o pokemon " + pokAtivo.getNome() + "(" + pokAtivo.getHP() + ")";
		}	
	}
	
	public class Fugir extends Event {
		
		private Treinador treinador;
		String nomeTreinador;
		
		public Fugir(Treinador treinador) {
			super(0); // Evento de prioridade 0
			this.treinador = treinador;
			nomeTreinador = treinador.getNome();
		}
		
		public void action() {
			treinador = null;
			System.out.println(treinador);
		}

		public String description() {
			return "O jogador " + nomeTreinador + " fugiu da batalha";
		}
	}
	
	public class Restart extends Event {

		public Restart() {
			super(7);
		}
		
		public void action() {
			
			while () {
				System.out.println("Treinador 1, escolha sua ação:");
				//imprimir eventos possiveis
				
			}
			
			addEvent(new Atacar(3, treinador1, treinador2, 2));
			addEvent(new Atacar(3, treinador2, treinador1, 2));
		}

		public String description() {
			return "Nova batalha iniciada!";
		}
		
		public void mostrarEventos() {
			System.out.println("Eventos por ordem de prioridade");
			System.out.println("FODA-SE");
		}
	}
	
	public static void main(String[] args) {
		
		GameControls gc = new GameControls(); //cria os treinadores
		gc.addEvent(gc.new Restart()); //cria uma batalha
		gc.run(); //inicia a batalha
		
	}
}
