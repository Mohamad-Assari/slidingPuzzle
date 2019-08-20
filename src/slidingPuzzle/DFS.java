package slidingPuzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	public DFS() {
//		unlimited();
		limited(8);
//		tadriji();
		
	}
	boolean answerfound=false;
	int numofexpandednodes=0;
	int numofvisitednodes=0;
	Problem p = new Problem();
	Stack<State> f = new Stack<State>();
	Queue<String> visitedstates = new LinkedList<>();
	
//________________________________________________________________	
public void tadriji() {
	for(int i=1;i<30;i++) {
//		numofexpandednodes=0;
//		numofvisitednodes=0;
		f = new Stack<State>();
		visitedstates = new LinkedList<>();
		
		limited(i);
		if(answerfound) {
		return;
		}
	}
	
	
	
}
	
	
	
	
//________________________________________________________________	
	public void limited(int limit) {
		f.add(p.getInitialState());

		while (true) {	
//		for(int i=0;i<10000;i++) {
		if(f.size()==0) {
//			System.out.println("no answer");
			return;
		}
		State temp=f.pop();
		numofexpandednodes++;
//		System.out.println("polled out   "+temp.state);
		if(p.goaltest(temp)) {
			System.out.println("answer found");
			answerfound=true;
			printpath(temp);
			return;
		}else {
//			visitedstates.add(temp.state);
			//f.add(actionlist temp)
			ArrayList<Action> myactionlist=p.getActionList(temp);
			//System.out.println(myactionlist.size());
//			for(int k=0;k<myactionlist.size();k++) {
			for(int k=myactionlist.size()-1;k>=0;k--) {	
//				if(!(visitedstates.contains(p.result(temp,myactionlist.get(k)).state)) && temp.depth<lili) {
	
				if(temp.depth<=limit) {
					
// faghat baray shomareshe visited nodes visited states zakhire mishavad				
					visitedstates.add(p.result(temp,myactionlist.get(k)).state);
					numofvisitednodes++;
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					State temporary=p.result(temp,myactionlist.get(k));
					
					temporary.depth=temporary.parent.depth+1;
					f.add(temporary);
				}
			}
		
		}
		
		}
		
	}
	
//________________________________________________________________________	
	public void unlimited() {
		f.add(p.getInitialState());

		while (true) {	
//		for(int i=0;i<10000;i++) {
		if(f.size()==0) {
			System.out.println("no answer");
			return;
		}
		State temp=f.pop();
		numofexpandednodes++;
//		System.out.println("polled out   "+temp.state);
		if(p.goaltest(temp)) {
			System.out.println("answer found");
			printpath(temp);
			return;
		}else {
//			visitedstates.add(temp.state);
			//f.add(actionlist temp)
			ArrayList<Action> myactionlist=p.getActionList(temp);
			//System.out.println(myactionlist.size());
//			for(int k=0;k<myactionlist.size();k++) {
			for(int k=myactionlist.size()-1;k>=0;k--) {	
				if(!(visitedstates.contains(p.result(temp,myactionlist.get(k)).state))) {
					visitedstates.add(p.result(temp,myactionlist.get(k)).state);
					numofvisitednodes++;
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					f.add(p.result(temp,myactionlist.get(k)));
				}
			}
		
		}
		
		}
	
	}
	
	
//__________________________________________________________________	
	public void printpath(State d) {
		String finalpathreverse="";
		while(d.parent!=null) {
			finalpathreverse=finalpathreverse+d.move;
//			System.out.println(d.move);
//			System.out.println(d.state);
			d=d.parent;
		}
		String finalpath=new StringBuilder(finalpathreverse).reverse().toString();
		System.out.println(finalpath);
		System.out.println("number of visited  nodes are: "+numofvisitednodes);
		System.out.println("number of expanded nodes are: "+numofexpandednodes);
		System.out.println("and the depth is:           : "+finalpath.length());
		
		
	}

}
