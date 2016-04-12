package pset4;
import org.apache.bcel.Repository;
import java.util.*;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;

public class GraphGenerator {
    public CFG createCFG(String className) throws ClassNotFoundException {
        CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();
        for (Method m: cg.getMethods()) {
//        	System.out.println(m.getName());
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            for (InstructionHandle ih: handles) {
                int position = ih.getPosition();
//                System.out.println("method is " + m);
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();
                // your code goes here
                
                System.out.println(position + " "+ inst.getName() + " " + inst.getClass().getName());// ih.getClass().getName());
                InstructionHandle nextInst = ih.getNext();
                if((inst instanceof IRETURN) || (inst instanceof RETURN)){
                	cfg.addEdge(position, -1, m, jc);
                } else{
                	if(inst instanceof GOTO){
                		//for unconditional branches; i.e. conditionals without explicit return
                		int go = ((GOTO) inst).getTarget().getPosition();
                		cfg.addEdge(position, go, m, jc);
                	}
                	else{
                		if(ih instanceof BranchHandle){
                        	BranchHandle branch = (BranchHandle) ih;
                        	InstructionHandle branchInst = branch.getTarget();
                        	int branchPos = branchInst.getPosition();
                        	//code to handle true branch
                        	cfg.addEdge(position, branchPos, m, jc);
                        	
                        	System.out.println("BRRAAAANCH to: " + branchInst.getPosition());
                        	
                        	//code to handle false branch
                        	System.out.println("     to " + nextInst.getPosition());
                        	int nextPosition = nextInst.getPosition();
                        	cfg.addEdge(position, nextPosition, m, jc);
                        }else{
                        	System.out.println("     to " + nextInst.getPosition());
                        	int nextPosition = nextInst.getPosition();
                        	cfg.addEdge(position, nextPosition, m, jc);
                        }
                    	
                	}
                }
                
            }
        }
        return cfg;
    }
    
    public Method getMethodFromName(String name, Method[] methods){
    	Method matched = null;
    	for(Method m: methods){
    		if(m.getName() == name){
    			System.out.println("matched " + name + " to " + m);
    			matched = m;
    			break;
    		}
    	}
    	return matched;
    }
    
    public CFG createCFGWithMethodInvocation(String className) throws ClassNotFoundException {
        // your code goes here
    	CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();
        for (Method m: cg.getMethods()) {
        	System.out.println("method is " + m.getName());
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            for (InstructionHandle ih: handles) {
                int position = ih.getPosition();
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();
                // your code goes here
                
                System.out.println(position + " "+ inst.getName() + " " + inst.getClass().getName());// ih.getClass().getName());
                InstructionHandle nextInst = ih.getNext();
                if((inst instanceof IRETURN) || (inst instanceof RETURN)){
                	cfg.addEdge(position, -1, m, jc);
                } else{
                	if(inst instanceof GOTO){
                		//for unconditional branches; i.e. conditionals without explicit return
//                		int go = ((GOTO) inst).getTarget().getPosition();
//                		cfg.addEdge(position, go, m, jc);
                	}
                	else{
                		if(ih instanceof BranchHandle){
                        	BranchHandle branch = (BranchHandle) ih;
                        	InstructionHandle branchInst = branch.getTarget();
                        	int branchPos = branchInst.getPosition();
                        	//cover node to true branch
                        	cfg.addEdge(position, branchPos, m, jc);

                        	System.out.println("BRRAAAANCH to: " + branchInst.getPosition());
                        	
                        	//cover node results from false branch
                        	System.out.println("     to " + nextInst.getPosition());
                        	int nextPosition = nextInst.getPosition();
                        	cfg.addEdge(position, nextPosition, m, jc);
                        }
                		else if(inst instanceof INVOKESTATIC){
                			INVOKESTATIC callee = (INVOKESTATIC) inst;
                			String callMethodName = callee.getMethodName(cpg);
                			System.out.println("CAAAAAAALL to: " + callee.getIndex() + " " + callMethodName + " ");// + " from " + m);
                			Method calleeMethod = this.getMethodFromName(callMethodName, cg.getMethods());
                			if(calleeMethod!=null){
                				cfg.addEdge(position, m, jc, 0, calleeMethod, jc); //double check assignment of position
                			}
                			
                			//NOTE: STILL DON"T KNOW HOW TO HANDLE RETURNS PROPERLY
                			int nextPosition = nextInst.getPosition();
                        	cfg.addEdge(-1, calleeMethod, jc, nextPosition, m, jc);
                			//cfg.addEdge(position, nextPosition, m, jc);
                		}
                		else{
                			System.out.println("     to " + nextInst.getPosition());
                        	int nextPosition = nextInst.getPosition();
                        	cfg.addEdge(position, nextPosition, m, jc);
                		}
                    	
                	}
                }
                
            }
        }
        return cfg;
    }
    
    public static void main(String[] a) throws ClassNotFoundException {
        GraphGenerator gg = new GraphGenerator();
//        gg.createCFG("pset4.C"); // example invocation of createCFG
        //System.out.println(gg.createCFG("pset4.C"));
        System.out.println(gg.createCFGWithMethodInvocation("pset4.D")); // example invocation of createCFGWithMethodInovcation
    }
}

