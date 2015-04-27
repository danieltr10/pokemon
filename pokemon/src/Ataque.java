
private class Ataque extends Event {
	
	private int dano;
	String descricao;
	String msgAtaque;
	

	public Ataque(int prioridade) {
		super(prioridade);
		}
	
	public int getDano() {
		return dano;
	}
	
	public void action() {
		System.out.println(msgAtaque);
		addEvent(new Ataque(prioridade));
	}
	

	public String description() {
		return descricao;
	}


	
	

}
