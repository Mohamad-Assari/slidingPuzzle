package slidingPuzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Bilateral {
	public Bilateral() {
		algo();
	}
	String finalanswer="";
	boolean answerfound=false;
	int numofexpandednodes=0;
	int numofvisitednodes=0;
	Problem p = new Problem();
	Stack<State> f1 = new Stack<State>();
	Stack<State> f2 = new Stack<State>();
	Queue<String> visitedstates1 = new LinkedList<>();
	Queue<String> visitedstates2 = new LinkedList<>();
	
	Stack<State> f = new Stack<State>();
	Queue<String> visitedstates = new LinkedList<>();

	public void algo() {

		for(int i=1;i<=4;i++) {
			f1 = new Stack<State>();
			f2 = new Stack<State>();
			visitedstates1 = new LinkedList<>();
			visitedstates2 = new LinkedList<>();
			
			limited1(i);
			limited2(i);
			if(answerfound) {
			return;
			}
		}
	}
	public void limited1(int limit) {
		f1.add(p.getInitialState());

		while (true) {	
//		for(int i=0;i<10000;i++) {
		if(f1.size()==0) {
//			System.out.println("no answer");
			return;
		}
		State temp=f1.pop();
		numofexpandednodes++;
//		System.out.println("polled out   "+temp.state);
//		if(p.goaltest(temp)) {
			if(visitedstates2.contains(temp.state)) {
//			System.out.println("answer found from start");
			answerfound=true;
//			System.out.println(temp.state);
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
					visitedstates1.add(p.result(temp,myactionlist.get(k)).state);
					numofvisitednodes++;
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					State temporary=p.result(temp,myactionlist.get(k));
					
					temporary.depth=temporary.parent.depth+1;
					f1.add(temporary);
				}
			}
		
		}
		
		}
		
	}
//_____________________________________________________________________
	
	
	public void limited2(int limit) {
		f2.add(new State("123456780"));

		while (true) {	
//		for(int i=0;i<10000;i++) {
		if(f2.size()==0) {
//			System.out.println("no answer");
			return;
		}
		State temp=f2.pop();
		numofexpandednodes++;
//		System.out.println("polled out   "+temp.state);
//		if(p.goaltest(temp)) {
			if(visitedstates1.contains(temp.state)) {
//			System.out.println("answer found from end but i don't print it");
			answerfound=true;
//			printpath(temp);
//			System.out.println(temp.state);
			
			whatisfrombegining(temp,limit);
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
					visitedstates2.add(p.result(temp,myactionlist.get(k)).state);
					numofvisitednodes++;
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					State temporary=p.result(temp,myactionlist.get(k));
					
					temporary.depth=temporary.parent.depth+1;
					f2.add(temporary);
				}
			}
		
		}
		
		}
		
	}
//____________________________________________________________________
	public void whatisfrombegining(State semigoal,int limit){
		f.add(p.getInitialState());

		while (true) {	
//		for(int i=0;i<10000;i++) {
		if(f.size()==0) {
//			System.out.println("no answer");
			return;
		}
		State temp=f.pop();
//		System.out.println("polled out   "+temp.state);
		if(temp.state.equals(semigoal.state)) {
//			System.out.println("answer found alsooooo from beining but i dont show it");
//			printpath(temp);
//			System.out.println("seperate");
			printultimatepath(temp, semigoal);
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
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					State temporary=p.result(temp,myactionlist.get(k));
					
					temporary.depth=temporary.parent.depth+1;
					f.add(temporary);
				}
			}
		
		}
		
		}
		
		
	}
	
	
//_____________________________________________________________________	
	
	public void whatisfromEnd(State semigoal,int limit){
		f.add(new State("123456780"));

		while (true) {	
//		for(int i=0;i<10000;i++) {
		if(f.size()==0) {
//			System.out.println("no answer");
			return;
		}
		State temp=f.pop();
//		System.out.println("polled out   "+temp.state);
		if(temp.state.equals(semigoal.state)) {
//			System.out.println("answer found alsooooo from beining but i dont show it");
//			printpath(temp);
			printultimatepath(semigoal, temp);
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
//					System.out.println(p.result(temp,myactionlist.get(k)).state);
					State temporary=p.result(temp,myactionlist.get(k));
					
					temporary.depth=temporary.parent.depth+1;
					f.add(temporary);
				}
			}
		
		}
		
		}
		
		
	}
//________________________________________________________________
	public void printultimatepath(State fromBegining, State fromEnd) {
		String finalpath="";
		while(fromEnd.parent!=null) {
			finalpath=finalpath+fromEnd.move;
//			System.out.println(d.move);
//			System.out.println(d.state);
			fromEnd=fromEnd.parent;
		}
		
		finalpath=finalpath.replace('l', 'x');
		finalpath=finalpath.replace('r', 'y');
		finalpath=finalpath.replace('x', 'r');
		finalpath=finalpath.replace('y', 'l');
		
		finalpath=finalpath.replace('u', 'x');
		finalpath=finalpath.replace('d', 'y');
		finalpath=finalpath.replace('x', 'd');
		finalpath=finalpath.replace('y', 'u');
		

		String finalpathreverse="";
		while(fromBegining.parent!=null) {
			finalpathreverse=finalpathreverse+fromBegining.move;
//			System.out.println(d.move);
//			System.out.println(d.state);
			fromBegining=fromBegining.parent;
		}
		String finalpath2=new StringBuilder(finalpathreverse).reverse().toString();
		finalpath2=finalpath2+finalpath;
		
		System.out.println("number of visited  nodes are: "+numofvisitednodes);
		System.out.println("number of expanded nodes are: "+numofexpandednodes);
		System.out.println("and the sequence of actinos : "+finalpath2);
		System.out.println("and the depth is:           : "+finalpath2.length());
		
		
		
	}

}
