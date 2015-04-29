	public class Ataque {

		private int dano;
		private String nomeAtaque;
		private int prioridade;

		public Ataque(int dano, String nomeAtaque, int prioridade) {
			this.prioridade = prioridade;
			this.dano = dano;
			this.nomeAtaque = nomeAtaque;
		}

		public int getDano() {
			return dano;
		}

		public String getNome() {
			return nomeAtaque;
		}
		
		public int getPrioridade() {
			return prioridade;
		}
	}