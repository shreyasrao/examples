package epi16;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class hanoi{
	
	private static final int NUM_PEGS = 3;
	
	public static void computeTowerHanoi(int numRings) {
		List<Deque<Integer>> pegs = new ArrayList<>();
		for(int i = 0; i<NUM_PEGS;i++) {
			pegs.add(new LinkedList<Integer>());
		}
		
		//Initialize pegs
		for(int i = numRings;i>= 1; --i) {
			pegs.get(0).addFirst(i);
		}
		computeHanoi(numRings,pegs,0,1,2);
	}

	private static void computeHanoi(int numRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
		// TODO Auto-generated method stub
		if(numRingsToMove>0) {
			computeHanoi(numRingsToMove-1,pegs,fromPeg,usePeg,toPeg);
			pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
			System.out.println("Move from peg " + fromPeg + " to peg " + toPeg);
			computeHanoi(numRingsToMove-1,pegs,usePeg,toPeg,fromPeg);
			
		}
	}
	
	public static void main(String[] args) {
		computeTowerHanoi(4);
	}
}