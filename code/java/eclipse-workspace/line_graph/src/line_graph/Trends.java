package line_graph;

import java.awt.Color;
import java.util.Vector;

import line_graph.paintsplit.A;

public class Trends extends Vector<A>{

	private	int left,right;
	private Color  color;
	private boolean del=false;
	
	void setdel(boolean b) {
		del=b;
	}
	
	boolean getdel() {
		return del;
	}
	
	void setcolor(Color col) {
		color=col;
	}
	
	Color getcolor() {
		return color;
	}
	
	int getleft() {
		return left;
	}
	
	int getright() {
		return right;
	}
	
	void setleft(int le) {
		left=le;
	}
	
	void setright(int ri) {
		right=ri;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
