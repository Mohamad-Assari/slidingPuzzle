package slidingPuzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Uniformcost {
	public Uniformcost() {
		algo();
	}
	int numofexpandednodes=0;
	int numofvisitednodes=0;
	int depth=0;
	Problem p = new Problem();
	
	Queue<State> f = new LinkedList<>();
//	Queue<State> e = new LinkedList<>();
	Queue<String> visitedstates = new LinkedList<>();
	
	
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
		System.out.println("number of visited  nodes are: "+visitedstates.size());
		System.out.println("number of expanded nodes are: "+numofexpandednodes);
		System.out.println("and the depth is            : "+finalpath.length());
		
	}
	
	
	
	
	public void algo() {
		f.add(p.getInitialState());

		while (true) {
//		for(int i=0;i<10000;i++) {
		if(f.size()==0) {
			System.out.println("no answer");
			return;
		}
		State temp=f.poll();
		numofexpandednodes++;
//		System.out.println("polled out   "+temp.state);
		if(p.goaltest(temp)) {
			System.out.println("answer found");
			printpath(temp);
			return;
		}else {
			visitedstates.add(temp.state);
			//f.add(actionlist temp)
			ArrayList<Action> myactionlist=p.getActionList(temp);
			//System.out.println(myactionlist.size());
			for(int k=0;k<myactionlist.size();k++) {
				if(!(visitedstates.contains(p.result(temp,myactionlist.get(k)).state))) {
					visitedstates.add(p.result(temp,myactionlist.get(k)).state);
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					f.add(p.result(temp,myactionlist.get(k)));
				}
			}
		
		}
		
		
		
		}
	}
	

}
