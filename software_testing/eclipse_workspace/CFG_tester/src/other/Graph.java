package other;
import java.util.*;
public class Graph {
	public Map<Integer, Set<ArrayList<Integer>>> paths = null;
	public Set<ArrayList<Integer>> cycles = null;
	private Integer pathLen = null;
	private boolean explored = false;
	
	public Integer subpath(ArrayList<Integer> subpath, ArrayList<Integer> path){
		int count = 0;
		int first = subpath.get(0);
		int len = subpath.size();
		int firstIndex = path.indexOf(first);
		if(firstIndex==-1) return -1;
//		System.out.println("Pre a");
		List<Integer> chopped = path.subList(firstIndex, path.size());
//		System.out.println(chopped);
		for(Integer a:chopped){
//			System.out.println("Pre a");
			if(count==len) break;
			if(a==subpath.get(count)){
//				System.out.println("a");
				count++;
			}
			else{return -1;}
		}
		if(count==len) return firstIndex;
		return -1;
	}
	
	public void reduce(){
		
		for(int i=1;i<pathLen;i++){
			Set<ArrayList<Integer>> smallpaths = paths.get(i);
//			System.out.println(smallpaths);
			Set<ArrayList<Integer>> toremove = new HashSet<ArrayList<Integer>>();
			Set<ArrayList<Integer>> bigpaths = new HashSet<ArrayList<Integer>>();
			
			//add all path bigger than current path length
			for(int j=i+1;j<=pathLen;j++){
				bigpaths.addAll(paths.get(j));
			}
			bigpaths.addAll(cycles);
			
			for(ArrayList<Integer> path:smallpaths){
				
				for(ArrayList<Integer> bigpath:bigpaths){
//					System.out.println(path);
					int sub = subpath(path,bigpath);
					if(sub!=-1){
						toremove.add(path);
						break;
					}
				}
			}
			
			smallpaths.removeAll(toremove);
			paths.put(i, smallpaths);
			
		}
		
	}
	
	public Integer pathOk(ArrayList<Integer> path){
		Integer result = null;
		Set<Integer> visited = new HashSet<Integer>();
//		boolean cycle = false;
		for(Integer node:path){
			boolean check = visited.add(node);
			if(check){
				//do nothing ... keep doing
			}else{
				int o = path.indexOf(node);
				if(0==o){
					//forms a cycle, add to cycles
					result = 1;
					return result;
				}
				else{
					//this forms a cycle with something other than the first
					//cannot add this to any category and must be removed from consideration
					result= -1;
					return result;
				}
			}
		}
		result = 0;
		return result;
		
	}
	
	public void genPaths(){
		if(explored) return;
		if(cycles==null) cycles = new HashSet<ArrayList<Integer>>();
		
		boolean newAdd = false;
		
		if(paths==null){
			paths = new TreeMap<Integer, Set<ArrayList<Integer>>>();
			Set<ArrayList<Integer>> newpaths = new HashSet<ArrayList<Integer>>();
			for(Integer node: nodes){
				ArrayList<Integer> newpath = new ArrayList<Integer>();
				newpath.add(node);
				newpaths.add(newpath);
				if(!newAdd) newAdd = true;
			}
			paths.put(1, newpaths);
			pathLen = 1;
		}
		else{
			Set<ArrayList<Integer>> currentpaths = paths.get(pathLen);
			Set<ArrayList<Integer>> newpaths = new HashSet<ArrayList<Integer>>();
			
			for(ArrayList<Integer> path:currentpaths){

				//this make sure that we only extend the largest paths
				Integer lastNode = path.get(path.size()-1);
				Set<Integer> nodeEdges = edges.get(lastNode);
				if(nodeEdges==null) nodeEdges = new TreeSet<Integer>();
				for(Integer Edge: nodeEdges){
					//construct newpath with all elements from path and then add the new edge
					ArrayList<Integer> newpath = new ArrayList<Integer>(path);
					newpath.add(Edge);
					
					int check = pathOk(newpath);
					if(check==0){
						//add it and keep going
						newpaths.add(newpath);
						if(!newAdd) newAdd = true;
					}
					else if(check == 1){
						//path is a cycle...move it to cycles category
						System.out.println("cycle " + newpath);
						cycles.add(newpath);
//						newpaths.add(newpath);
					}
					else if(check == -1){
						//cannot consider this path, so we do not add to anything
					}
					else{
						System.out.println("Something is wrong here");
					}
					
				}
			}
			if(newAdd){
				pathLen++;
				paths.put(pathLen, newpaths);
			}
		}
		if(newAdd) genPaths();
		else explored = true;
		
	}
	
	
	public Integer maxPathLength(Integer node){
		Set<ArrayList<Integer>> currentpaths = paths.get(node);
		int max = 0;
		for(ArrayList<Integer> path: currentpaths){
			if(path.size() > max) max = path.size();
		}
		return max;
	}
	
	public void genPaths333(){
		if(paths!= null) return;
		paths = new TreeMap<Integer, Set<ArrayList<Integer>>>();
		
		for(Integer node: nodes){
			Set<ArrayList<Integer>> currentpaths = paths.get(node);
			if(currentpaths==null) {
				//this implies we are adding all new paths of length 1 and the original node;
				currentpaths = new HashSet<ArrayList<Integer>>();
				Set<ArrayList<Integer>> newpaths = new HashSet<ArrayList<Integer>>();
				
				//add original node
				ArrayList<Integer> pathZero = new ArrayList<Integer>();
				pathZero.add(node);
				newpaths.add(pathZero);
				
				Set<Integer> nodeEdges = edges.get(node);
				if(nodeEdges==null) nodeEdges = new TreeSet<Integer>();
				for(Integer Edge: nodeEdges){
					//add all nodes to make paths of length 1
					ArrayList<Integer> newpath = new ArrayList<Integer>();
					newpath.add(node);
					newpath.add(Edge);
					newpaths.add(newpath);
				}
				currentpaths.addAll(newpaths);
			}
			else{
				Integer len = maxPathLength(node);
				Set<ArrayList<Integer>> newpaths = new HashSet<ArrayList<Integer>>();
				for(ArrayList<Integer> path:currentpaths){
					if(path.size()==len){
						//this make sure that we only extend the largest paths
						Integer lastNode = path.get(path.size());
						Set<Integer> nodeEdges = edges.get(lastNode);
						if(nodeEdges==null) nodeEdges = new TreeSet<Integer>();
						for(Integer Edge: nodeEdges){
							//construct newpath with all elements from path and then add the new edge
							ArrayList<Integer> newpath = new ArrayList<Integer>(path);
							newpath.add(Edge);
							newpaths.add(newpath);
						}
					}
				}
				currentpaths.addAll(newpaths);
			}
			paths.put(node, currentpaths);
			//so right now we have 
			
		}
		//right now we have only executed the for loop once for each node, we need to make so that as long as each node
		//path can be extended, we keep calling the for loop to grab all the paths
		
	}
	
	
	
	
	
	/*public Map<Integer, Map<Integer,List<ArrayList<Integer>>>> paths = null;
    
	public void addPath(Integer length, Integer startNode, ArrayList<Integer> path){
		if(paths==null) paths = new HashMap<Integer, Map<Integer, List<ArrayList<Integer>>>>();
		Map<Integer,List<ArrayList<Integer>>> lengthPaths = paths.get(length);
		
		if (lengthPaths==null) lengthPaths = new HashMap<Integer, List<ArrayList<Integer>>>();
		List<ArrayList<Integer>> nodePaths = lengthPaths.get(startNode);
		
		if(nodePaths==null) nodePaths = new ArrayList<ArrayList<Integer>>();
		
		nodePaths.add(path);
		lengthPaths.put(startNode, nodePaths);
		paths.put(length, lengthPaths);
	}
	
	public List<ArrayList<Integer>> getPaths(Integer length, Integer startNode, ArrayList<Integer> path){
		if(paths==null) paths = new HashMap<Integer, Map<Integer, List<ArrayList<Integer>>>>();
		
		Map<Integer,List<ArrayList<Integer>>> lengthPaths = paths.get(length);
		if (lengthPaths==null) return null;
		List<ArrayList<Integer>> nodePaths = lengthPaths.get(startNode);
		if(nodePaths==null) return null;
		return nodePaths;
	}
	*/
	
	public Set<Integer> nodes; // set of nodes in the graph
    public Map<Integer, TreeSet<Integer>> edges;
//    private Map<Integer, TreeSet<Integer>> onehop = null;
//    private Map<Integer, TreeSet<Integer>> reach = null;
    // map between a node and a set of nodes that are connected to it by outgoing edges
    // class invariant: fields "nodes" and "edges" are non-null;
    //                  "this" graph has no node that is not in "nodes"
    public Graph() {
        nodes = new TreeSet<Integer>();
        edges = new TreeMap<Integer, TreeSet<Integer>>();
    }
    
    public String toString() {
        return "nodes: " + nodes + "\n" + "edges: " + edges;
    }
    
    public void addNode(int n) {
        // postcondition: adds the node "n" to this graph
        nodes.add(n);
    }
    
    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        // your code goes here
        
    	if(!nodes.contains(from)) addNode(from);
    	if(!nodes.contains(to)) addNode(to);
    	
    	TreeSet<Integer> fromEdges = edges.get(from);
    	
    	if(fromEdges == null){
//    		System.out.println("FAAK");
    		fromEdges = new TreeSet<Integer>();
    	}
    	
    	fromEdges.add(to);
    	edges.put(from, fromEdges);
    	
    }
}