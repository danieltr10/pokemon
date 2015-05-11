import java.util.Scanner;


public class GameControls extends Controller {
	
	public Treinador criaTreinador() {
		ListaDePokemons pokemonsDisponiveis = new ListaDePokemons();
		
		Scanner leituraDoTeclado = new Scanner (System.in);
		System.out.println("Novo treinador, digite o seu nome:");
		String nome = leituraDoTeclado.next();
		
		System.out.println("Agora escolha os pokemons com os quais quer batalhar.");
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
	
	public boolean treinadorAindaPodeBatalhar(Treinador treinador) {
		return treinador.getPokemonAtivo().pokemonEstaVivo();
	}
	
	public class Atacar extends Event {
		
		private Treinador agressor, alvo;
		private Ataque tipoAtaque;
		
		public Atacar(Treinador agressor, Treinador alvo, Ataque tipoAtaque) {
			super(tipoAtaque.getPrioridade());
			this.agressor = agressor;
			this.alvo = alvo;
			this.tipoAtaque = tipoAtaque;
		}
		
		public void action() {
			if (treinadorAindaPodeBatalhar(agressor)) {
				Pokemon pokAgressor = agressor.getPokemonAtivo();
				Pokemon pokAlvo = alvo.getPokemonAtivo();
				
				int danoAtaque = pokAgressor.getDanoAtaque(tipoAtaque);
				
				pokAlvo.reduzirHP(danoAtaque);
			}
			else {
				agressor.redefinirPokemonAtivo(agressor.escolheUmPokemonVivo());
			}
		}

		public String description() { //talvez tenha q mudar a descriçao para a situaçao q o ataque ocorreu ou nao
			Pokemon pokAgressor = agressor.getPokemonAtivo();
			Pokemon pokAlvo = alvo.getPokemonAtivo();
			
			return "O jogador " + agressor.getNome() + " atacou o pokemon " + pokAlvo.getNome() + "("+ pokAlvo.getHP() + ")" + " do jogador "
					+ alvo.getNome() + " com o pokemon " + pokAgressor.getNome() + "("+ pokAgressor.getHP() + ")";
		}
	}
	
	public class usarItem extends Event { //revisar
		
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
			treinador.redefinirPokemonAtivo(novoPokemon);
		}

		public String description() {
			Pokemon pokAtivo = treinador.getPokemonAtivo();
			return "O jogador " + treinador.getNome() + " escolheu o pokemon " + pokAtivo.getNome() + "(" + pokAtivo.getHP() + ")";
		}
	}
	
	public class Fugir extends Event { //revisar
		
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
			Treinador treinador1 = criaTreinador();
			Treinador treinador2 = criaTreinador();
			
			GameControls listaDeEventos = new GameControls();
			
			System.out.println("Treinador 1, escolha o pokemon com o qual deseja começar.");
			treinador1.redefinirPokemonAtivo(treinador1.escolheUmPokemonVivo());
			
			System.out.println("Treinador 2, escolha o pokemon com o qual deseja começar.");
			treinador2.redefinirPokemonAtivo(treinador2.escolheUmPokemonVivo());
			
			Treinador treinadorVencedor = null;
			while (treinadorVencedor == null) {
				System.out.println("Treinador 1, escolha sua ação:");
				listaDeEventos.addEvent(escolherEvento(treinador1, treinador2));
				
				System.out.println("Treinador 2, escolha sua ação:");
				listaDeEventos.addEvent(escolherEvento(treinador2, treinador1));
				
				listaDeEventos.run();
				
				if (!treinadorAindaPodeBatalhar(treinador1)) {
					System.out.println(treinador1.getNome() + ", seu pokemon foi derrotado!!");
					if (!treinador1.redefinirPokemonAtivo(treinador1.escolheUmPokemonVivo())) {
						treinadorVencedor = treinador2;
					}
				}
				if (!treinadorAindaPodeBatalhar(treinador2)) {
					System.out.println(treinador2.getNome() + ", seu pokemon foi derrotado!!");
					if (!treinador2.redefinirPokemonAtivo(treinador2.escolheUmPokemonVivo())) {
						treinadorVencedor = treinador1;
					}
				}
			}
			System.out.println("O treinador " + treinadorVencedor.getNome() + " vendeu a batalha!!");
			System.out.println("Parabéns " + treinadorVencedor.getNome() + "!!!");
			System.out.println("Fim da batalha!!");
		}

		public String description() {
			return "Nova batalha iniciada!";
		}
		
		public Event escolherEvento(Treinador treinador, Treinador outroTreinador) {
			System.out.println("0) Fugir da batalha");
			System.out.println("1) Trocar de pokemon");
			System.out.println("2) Usar item de cura");
			System.out.println("3) Atacar");
			
			Scanner leituraDoTeclado = new Scanner (System.in);
			int numeroEventoEscolhido = leituraDoTeclado.nextInt();
			Event eventoEscolhido;
			
			if (numeroEventoEscolhido == 0) {
				eventoEscolhido = new Fugir(treinador);
			}
			else if (numeroEventoEscolhido == 1) {
				int novoPokemon = treinador.escolheUmPokemonVivo();
				eventoEscolhido = new trocarPokemon(treinador, novoPokemon);
			}
			else if (numeroEventoEscolhido == 2) {
				eventoEscolhido = new usarItem(treinador);
			}
			else if (numeroEventoEscolhido == 3) {
				Ataque ataque = treinador.getPokemonAtivo().escolherAtaque();
				eventoEscolhido = new Atacar(treinador, outroTreinador, ataque);
			}
			else {
				eventoEscolhido = null;
			}
			
			leituraDoTeclado.close();
			return eventoEscolhido;
		}
	}
	
	public static void main(String[] args) {
		
		GameControls gc = new GameControls();
		gc.addEvent(gc.new Restart());
		gc.run();
		
	}
}
