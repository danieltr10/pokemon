
class EventSet {
	
	private Event[] events = new Event[3];
	private int index = 0;
	private int next = 0;
	
	public void add(Event e) {
		if(index >= events.length)
			return; // (In real life, throw exception)
		events[index++] = e;
	}
	
	public Event getNext() {
	
		Event maiorPrioridade = null;
		
		if (events[0] == null && events[1] == null && events[2] == null) {
			return null;
		}
		
		if (events[0] != null)
			maiorPrioridade = events[0];
		else if (events[1] != null)
			maiorPrioridade = events[1];
		else if (events[2] != null)
			maiorPrioridade = events[2];
		
		int i = 0;
		
		while (i < 3) {
			if (events[i] != null)
				if (maiorPrioridade.getPrioridade() > events[i].getPrioridade()) {
					maiorPrioridade = events[i];
				}
		i++;
					
		} 
		
		if (maiorPrioridade == events[0])
			next = 0;
		else if (maiorPrioridade == events[1])
			next = 1;
		else if (maiorPrioridade == events[2])
			next = 2;
		
		return maiorPrioridade;
	}
	
	public void removeCurrent() {
		events[next] = null;
	}
}
