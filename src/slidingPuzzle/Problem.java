package slidingPuzzle;

import java.util.ArrayList;

public class Problem {
	
//1	
	public State getInitialState() {
		return new State("123704865");
		

		
	}
	
//2

	public ArrayList<Action> getActionList(State temp) {
		ArrayList<Action> a=new ArrayList<Action>();
		
		if(temp.state.charAt(6)!='0' && temp.state.charAt(7)!='0' && temp.state.charAt(8)!='0') {
			a.add(new Action('d'));
		}
		if(temp.state.charAt(2)!='0' && temp.state.charAt(5)!='0' && temp.state.charAt(8)!='0') {
			a.add(new Action('r'));
		}
		if(temp.state.charAt(0)!='0' && temp.state.charAt(3)!='0' && temp.state.charAt(6)!='0') {
			a.add(new Action('l'));
		}
		if(temp.state.charAt(0)!='0' && temp.state.charAt(1)!='0' && temp.state.charAt(2)!='0') {
			a.add(new Action('u'));
		}
		return a;
	}
	
//3
	public State result(State a, Action b) {
		if(b.action=='r') {
			String temp= a.state;
			int index=temp.indexOf('0');
			char swap=temp.charAt(index+1);
			 temp=temp.replace('0','x');
			 temp=temp.replace(temp.charAt(index+1),'0');
			 temp=temp.replace('x',swap);
			 
			return new State(temp,a,'r');
		}
		
		else if(b.action=='d') {
			String temp= a.state;
			int index=temp.indexOf('0');
			char swap=temp.charAt(index+3);
			 temp=temp.replace('0','x');
			 temp=temp.replace(temp.charAt(index+3),'0');
			 temp=temp.replace('x',swap);
			 
			return new State(temp,a,'d');
		}
		
		
		else if(b.action=='l') {
			String temp= a.state;
			int index=temp.indexOf('0');
			char swap=temp.charAt(index-1);
			 temp=temp.replace('0','x');
			 temp=temp.replace(temp.charAt(index-1),'0');
			 temp=temp.replace('x',swap);
			 
			return new State(temp,a,'l');
		}
		
		
		else {
			// now action is u
			String temp= a.state;
			int index=temp.indexOf('0');
			char swap=temp.charAt(index-3);
			 temp=temp.replace('0','x');
			 temp=temp.replace(temp.charAt(index-3),'0');
			 temp=temp.replace('x',swap);
			 
			return new State(temp,a,'u');
		}
	}
	
	
//4
		public boolean goaltest(State a) {
			if(a.state.equals("123456780")) {
				return true;
			}
			else
			return false;
		}
	
	
	
	
}
