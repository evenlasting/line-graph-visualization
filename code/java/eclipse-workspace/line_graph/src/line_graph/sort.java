package line_graph;

import java.util.Comparator;

import line_graph.paintsplit.A;
import line_graph.Trends;

public class sort {

	
	static class compareTrends implements Comparator<Trends>{
		public int compare(Trends le,Trends ri) {
			if (le.getleft()>ri.getleft())
				return 1;
			if (le.getleft()==ri.getleft()) return 0;
			return -1;
		}
	}
	
	static class compareline implements Comparator<A> {
		public int compare(A left, A right) {
			if (left.value>right.value)
				return 1;
			if (left.value==right.value) 
				return 0;
			return -1;
		}
	}
	
	static Comparator<A> t=new compareline();
	static Comparator<Trends> trends=new compareTrends();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
