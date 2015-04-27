
class EventSet {
	
	private Event[] events = new Event[100];
	private int index = 0;
	private int next = 0;
	
	public void add(Event e) {
		if(index >= events.length)
			return; // (In real life, throw exception)
		events[index++] = e;
	}
	
	public Event getNext() {
		if (events[0] == null)
			return events[1];	
		else if (events[1] == null)
			return events[0];
			
		if (events[0].getPrioridade() >= events[1].getPrioridade()) {
			next = 0;
			return events[0];
		}
		else {
			next = 1;
			return events[1];
		}

	}
	
	public void removeCurrent() {
		events[next] = null;
	}
}
