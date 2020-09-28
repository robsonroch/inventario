package br.com.cbmerj.inventory.EventSynchronized;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class EventSynchronized implements EventStore{
		
	private static Map<String, Set<Event>> stored = new ConcurrentHashMap<String, Set<Event>>();
	
	ListaLincada teste = new ListaLincada();
	
	@Override
	public void insert(Event event) {		
		if (event != null) {
			Set<Event> setEvent = stored.get(event.type());
			if(setEvent != null) {
				setEvent.add(event);
			}else {
				Set<Event> newSet = new HashSet<>();
				newSet.add(event);
				stored.put(event.type(), newSet);
			}
		}			
	}

	@Override
	public void removeAll(String type) {
		stored.remove(type);		
	}

	@Override
	public EventIterator query(String type, long startTime, long endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
