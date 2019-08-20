package slidingPuzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {
	public AStar() {
		algo();
	}
	int numofexpandednodes=0;
	int numofvisitednodes=0;
	int depth=0;
	Problem p = new Problem();
	
	PriorityQueue<State> pQueue ;
//	Queue<State> f = new LinkedList<>();
//	Queue<State> e = new LinkedList<>();
	Queue<String> visitedstates = new LinkedList<>();

	public void algo() {
		
		 Comparator<State> heuristicComparator = new Comparator<State>() {
	            @Override
	            public int compare(State s1, State s2) {
	                return s1.depth+s1.hx-s2.depth-s2.hx;
	            }
	        };
		
		
		pQueue = new PriorityQueue<State>(heuristicComparator); 

		
		
		 	State temp1State=p.getInitialState();
		 	temp1State.hx=totalmanhatan(temp1State.state);
			pQueue.add(temp1State);

			while (true) {
//			for(int i=0;i<10000;i++) {
			if(pQueue.size()==0) {
				System.out.println("no answer");
				return;
			}
			State temp=pQueue.poll();
			numofexpandednodes++;
//			System.out.println("polled out   "+temp.state);
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
//						System.out.println(p.result(temp,myactionlist.get(k)).state);
						State temporary=p.result(temp,myactionlist.get(k));
						temporary.hx=totalmanhatan(temporary.state);
						
						temporary.depth=temporary.parent.depth+1;
						pQueue.add(temporary);
					}
				}
			
			}
			
			
			
			}
		
		
		
		
		
		
		

		
		
	}
	
//____________________________________________________________________________
	
	
	public int totalmanhatan(String mytable) {
		int totalmanhatan=0;
		for(int i=1;i<9;i++) {
			Integer I=i;
			String temporary=I.toString();
			char temp=temporary.charAt(0);
			int index=mytable.indexOf(temp);
			
			totalmanhatan+=singleManhatan(index,i);
		}
		
		return totalmanhatan;
	}
	
	public int singleManhatan(int index, int mynumber) {
		int indexX=index%3;
		int indexY=index/3;

		int mynumberX=(mynumber-1)%3;
		int mynumberY=(mynumber-1)/3;
		
		int totalmanhatan=Math.abs(indexX-mynumberX)+Math.abs(indexY-mynumberY);
		
		return totalmanhatan;
	}







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










}
