
public class Controller {
	
	private EventSet es = new EventSet();
	
	public void addEvent(Event c) { es.add(c); }
	
	public void run() {
		int i = 0;
		while (i < 2) {
			Event e;
			e = es.getNext();
			e.action();
			System.out.println(e.description());
			es.removeCurrent();
			i++;
		}
	}
}

