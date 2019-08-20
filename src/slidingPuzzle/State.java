package slidingPuzzle;

public class State{
	State parent=null;
	char move='x';
	String state="012345678";
	int depth=1;
	int hx=100;
	
	public State(String d) {
		state=d;
	}
	public State() {
	}
	public State(String d,State father,char m) {
		state=d;
		parent=father;
		move=m;
	}

	
	public boolean isEqual(State sth) {
		if(sth.state==this.state)
		return true;
		else
			return false;
	}
}
