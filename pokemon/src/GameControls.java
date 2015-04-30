
public class GameControls extends Controller {
	
	Treinador jogador1 = new Treinador("Ash");
	Treinador jogador2 = new Treinador("Jessie");
	
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
