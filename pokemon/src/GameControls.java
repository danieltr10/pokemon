import java.util.Scanner;


public class GameControls extends Controller {
	
	public Treinador criaTreinador() {
		ListaDePokemons pokemonsDisponiveis = new ListaDePokemons();
		
		Scanner leituraDoTeclado = new Scanner (System.in);
		System.out.println("Primeiro treinador, digite o seu nome:");
		String nome = leituraDoTeclado.next();
		
		pokemonsDisponiveis.mostraLista();
		System.out.println("Digite o numero de um pokemon que deseja ou digite um numero que não esteja na lista para não escolher nenhum.");
		System.out.println("Pokemon0:");
		int pokemon0 = leituraDoTeclado.nextInt();
		System.out.println("Pokemon1:");
		int pokemon1 = leituraDoTeclado.nextInt();
		System.out.println("Pokemon2:");
		int pokemon2 = leituraDoTeclado.nextInt();
		System.out.println("Pokemon3:");
		int pokemon3 = leituraDoTeclado.nextInt();
		System.out.println("Pokemon4:");
		int pokemon4 = leituraDoTeclado.nextInt();
		System.out.println("Pokemon5:");
		int pokemon5 = leituraDoTeclado.nextInt();
		
		leituraDoTeclado.close();
		
		return new Treinador(pokemonsDisponiveis, nome, pokemon0, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5);
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
			
			addEvent(new Atacar(3, jogador1, jogador2, 2));
			addEvent(new Atacar(3, jogador2, jogador1, 2));

		}

		public String description() {
			return "Nova rodada iniciada!";
		}
		
	}
	
	public static void main(String[] args) {
		
		GameControls gc = new GameControls();
		gc.addEvent(gc.new Restart());
		gc.run();
		
	}


}
