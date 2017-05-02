package epi19;

import java.util.ArrayList;
import java.util.List;

public class Maze{
	
	//given a maze, determine if there is a path from start to finish, while only going thru WHITE maze square.
	//Maze represented as a matrix of Color
	//Best approach is to this of this as a graph and apply a DFS algo to set if finish is reacible from start
	
	public static enum Color {WHITE,BLACK}
	
	
	public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
		List<Coordinate> path = new ArrayList<Coordinate>();
		maze.get(s.x).set(s.y, Color.BLACK);
		path.add(s);
		if(!searchHelper(maze,s,e,path)) {
			path.remove(path.size()-1);
		}
		
		return path;
	}
	
	public static boolean searchHelper(List<List<Color>> maze, Coordinate curr, Coordinate e, List<Coordinate> path) {
		
		if(curr.equals(e)) return true;
		
		final int[][] MOVES = {{0,1},{0,-1},{1,0},{-1,0}};
		
		for(int[] s:MOVES) {
			Coordinate next = new Coordinate(curr.x+s[0],curr.y+s[1]);
			if(isFeasible(maze,next)) {
				maze.get(next.x).set(next.y, Color.BLACK);
				path.add(next);
				if(searchHelper(maze,next,e,path)) {
					return true;
				}
				path.remove(path.size()-1);
			}
		}
		
		return false;
	}
	
	public static boolean isFeasible(List<List<Color>> maze, Coordinate curr) {
		return curr.x>= 0 && curr.x<maze.size() && curr.y>=0 && curr.y<maze.get(curr.x).size() && maze.get(curr.x).get(curr.y)==Color.WHITE;
	}
	
}
		