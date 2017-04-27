package epi14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class calendar{
	
	public static class Event{
		public int start, finish;
		public Event(int s, int f) {
			this.start = s;
			this.finish = f;
		}
	}
	
	public static int findMaxEvents(List<Event> A) {
		//assume A is sorted wrt to start times
		int eventId = 0;
		List<ArrayDeque<Event>> calendar = new ArrayList<ArrayDeque<Event>>();
		ArrayDeque<Event> a = new ArrayDeque<Event>();
		a.add(A.get(eventId++));
		calendar.add(a);
		while(eventId<A.size()) {
			boolean addNew = true;
			Event currEvent = A.get(eventId);
			System.out.println("Start time is " + currEvent.start);
			for(ArrayDeque<Event> line:calendar) {
				
				if(line.peekLast().finish<=currEvent.start) {
					System.out.println("event end " + line.peekLast().finish);
					line.addLast(currEvent);
					addNew = false;
					break;
				}
			}
			if(addNew) {
				System.out.println("new Line");
				ArrayDeque<Event> temp = new ArrayDeque<Event>();
				temp.add(currEvent);
				calendar.add(new ArrayDeque<Event>(temp));
				temp.remove();
			}
			eventId++;
			
		}
		return calendar.size();
	}
	
	public static void main(String[] args) {
//		int a = 2;
//		System.out.println(a++);
		List<Event> A = new ArrayList<Event>();
		A.add(new Event(1,5));
		A.add(new Event(2,7));
		A.add(new Event(4,5));
		A.add(new Event(6,10));
		A.add(new Event(8,9));
		A.add(new Event(9,17));
		A.add(new Event(11,13));
		A.add(new Event(12,15));
		A.add(new Event(14,15));
		System.out.println(findMaxEvents(A));
		
		
	}
}