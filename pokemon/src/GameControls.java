
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
					+ alvo.getNome() + " com o pokemon " + pokAgressor.getNome() + "("+ pokAlvo.getHP() + ")";

		}
		
	}

	public class Restart extends Event {

		public Restart(int prioridade) {
			super(prioridade);
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
		gc.addEvent(gc.new Restart(7));
		gc.run();
		
	}


}
