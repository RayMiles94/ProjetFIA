package fst.lfi.lfi3;
import java.util.ArrayList;
import java.util.List;

enum Position {RIGHT, LEFT}

public class State {

	private int cannibalLeft;
	private int missionaryLeft;
	private int cannibalRight;
	private int missionaryRight;
	private Position boat;

	private State parentState;

	public State(int cannibalLeft, int missionaryLeft, Position boat,
			int cannibalRight, int missionaryRight) {
		this.cannibalLeft = cannibalLeft;
		this.missionaryLeft = missionaryLeft;
		this.boat = boat;
		this.cannibalRight = cannibalRight;
		this.missionaryRight = missionaryRight;
	}

	public boolean isGoal() {
		return cannibalLeft == 0 && missionaryLeft == 0;
	}

	public boolean isValid() {
		if (missionaryLeft >= 0 && missionaryRight >= 0 && cannibalLeft >= 0 && cannibalRight >= 0
	               && (missionaryLeft == 0 || missionaryLeft >= cannibalLeft)
	               && (missionaryRight == 0 || missionaryRight >= cannibalRight)) {
			return true;
		}
		return false;
	}

	public List<State> generateSuccessors() {
		List<State> successors = new ArrayList<State>();
		if (boat == Position.LEFT) {
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 2, Position.RIGHT,
					cannibalRight, missionaryRight + 2)); // Two missionaries cross left to right.
			testAndAdd(successors, new State(cannibalLeft - 2, missionaryLeft, Position.RIGHT,
					cannibalRight + 2, missionaryRight)); // Two cannibals cross left to right.
			testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft - 1, Position.RIGHT,
					cannibalRight + 1, missionaryRight + 1)); // One missionary and one cannibal cross left to right.
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 1, Position.RIGHT,
					cannibalRight, missionaryRight + 1)); // One missionary crosses left to right.
			testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft, Position.RIGHT,
					cannibalRight + 1, missionaryRight)); // One cannibal crosses left to right.
		} else {
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft + 2, Position.LEFT,
					cannibalRight, missionaryRight - 2)); // Two missionaries cross right to left.
			testAndAdd(successors, new State(cannibalLeft + 2, missionaryLeft, Position.LEFT,
					cannibalRight - 2, missionaryRight)); // Two cannibals cross right to left.
			testAndAdd(successors, new State(cannibalLeft + 1, missionaryLeft + 1, Position.LEFT,
					cannibalRight - 1, missionaryRight - 1)); // One missionary and one cannibal cross right to left.
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft + 1, Position.LEFT,
					cannibalRight, missionaryRight - 1)); // One missionary crosses right to left.
			testAndAdd(successors, new State(cannibalLeft + 1, missionaryLeft, Position.LEFT,
					cannibalRight - 1, missionaryRight)); // One cannibal crosses right to left.
		}
		return successors;
	}

	private void testAndAdd(List<State> successors, State newState) {
		if (newState.isValid()) {
			newState.setParentState(this);
			successors.add(newState);
		}
	}

	public int getCannibalLeft() {
		return cannibalLeft;
	}

	public void setCannibalLeft(int cannibalLeft) {
		this.cannibalLeft = cannibalLeft;
	}

	public int getMissionaryLeft() {
		return missionaryLeft;
	}

	public void setMissionaryLeft(int missionaryLeft) {
		this.missionaryLeft = missionaryLeft;
	}

	public int getCannibalRight() {
		return cannibalRight;
	}

	public void setCannibalRight(int cannibalRight) {
		this.cannibalRight = cannibalRight;
	}

	public int getMissionaryRight() {
		return missionaryRight;
	}

	public void setMissionaryRight(int missionaryRight) {
		this.missionaryRight = missionaryRight;
	}

	public void goToLeft() {
		boat = Position.LEFT;
	}

	public void goToRight() {
		boat = Position.RIGHT;
	}

	public boolean isOnLeft() {
		return boat == Position.LEFT;
	}

	public boolean isOnRigth() {
		return boat == Position.RIGHT;
	}

	public State getParentState() {
		return parentState;
	}

	public void setParentState(State parentState) {
		this.parentState = parentState;
	}

	@Override
	public String toString() {
		if (boat == Position.LEFT) {
			return "(" + cannibalLeft + "," + missionaryLeft + ",L,"
        			+ cannibalRight + "," + missionaryRight + ")";
		} else {
			return "(" + cannibalLeft + "," + missionaryLeft + ",R,"
        			+ cannibalRight + "," + missionaryRight + ")";
		}
     }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof State)) {
			return false;
		}
		State s = (State) obj;
        return (s.cannibalLeft == cannibalLeft && s.missionaryLeft == missionaryLeft
        		&& s.boat == boat && s.cannibalRight == cannibalRight
        		&& s.missionaryRight == missionaryRight);
	}
}

/* String label;
int number_M_gauche,number_C_gauche;
int number_M_droite,number_C_droite;
boolean b;
int f,h,g;

public State() {
	
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public int getNumber_M_gauche() {
	return number_M_gauche;
}
public void setNumber_M_gauche(int number_M_gauche) {
	this.number_M_gauche = number_M_gauche;
}
public int getNumber_C_gauche() {
	return number_C_gauche;
}
public void setNumber_C_gauche(int number_C_gauche) {
	this.number_C_gauche = number_C_gauche;
}
public int getNumber_M_droite() {
	return number_M_droite;
}
public void setNumber_M_droite(int number_M_droite) {
	this.number_M_droite = number_M_droite;
}
public int getNumber_C_droite() {
	return number_C_droite;
}
public void setNumber_C_droite(int number_C_droite) {
	this.number_C_droite = number_C_droite;
}
public boolean isB() {
	return b;
}
public void setB(boolean b) {
	this.b = b;
}
public int getF() {
	return f;
}
public void setF(int f) {
	this.f = f;
}
public int getH() {
	return h;
}
public void setH(int h) {
	this.h = h;
}
public int getG() {
	return g;
}
public void setG(int g) {
	this.g = g;
}



public State(String name, int mis_gauch,int can_gauch,boolean b,int mis_droite,int can_droite) {
	this.label = name;
	this.number_M_gauche=mis_gauch;
	this.number_C_gauche=can_gauch;
	this.number_M_droite=mis_droite;
	this.number_C_droite=can_droite;
}

public boolean isempty() {
	
return false;
}*/
