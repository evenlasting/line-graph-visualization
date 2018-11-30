package line_graph;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import line_graph.paintsplit.A;

public class paint extends JFrame{
	public paint(String s) {
		super.setTitle(s);
		add(new NewPanel());
	}

	static int linenum=10;
	//public static int lineNum=10;
	//public static int del=10;
	public static int dis = 50;  //分开的距离
	public static int trendsNum=0;
	private static final long serialVersionUID = 1L;

	static class line{
		public line() {
			for (int i=0;i<1001;i++)
			{
				y[i]=-1;
			}
		}
		public line(int n) {
			num=n;
			for (int i=0;i<1001;i++)
			{
				y[i]=50;
			}
		}
		
		int[] y=new int [1001];
		int num=0;	
	}
	
	static class point {
		int x=0,y=0;
		point (){};
		point (int x1,int y2)
		{
			x=x1;
			y=y2;
		}
	}
	
	static public line[] lines=new line[linenum]; 	
//	static public point[] lastpoint=new point[linenum];
	
	
//	static public int [] upper=new int[100];  //上面的线
//	static public int [] lower=new int [100];  //下面的线
//	static public point [] inter=new point [100];	//交点	
//	static public int [][] interLine =new int [100][101];   //交线
//	static public point [] split =new point [100];	//离点
//	static public int [][] splitLine =new int [100][2];  //相离的线
	
	static Vector<Trends> v=new Vector<Trends>();     //all Trends
	static Trends list=new Trends ();   //at first all lines are in one Trends
	
	static Color[] color= {Color.red,Color.blue,Color.green,Color.yellow,Color.pink,Color.orange};  //colors of the trends
	
//	static int  in(point p1,point p2,point p3,point p4)//p1,p2 upper
//	{
//		if ((p2.x-p1.x)*(p4.y-p3.y)==(p2.y-p1.y)*(p4.x-p3.x)) return 0;
//		if ((p2.x-p1.x)*(p4.y-p3.y)<(p2.y-p1.y)*(p4.x-p3.x)) return -1;
//		return 1;
//	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println("111");
		for (int i=0;i<linenum;i++)
			lines[i]=new line(1000);
//		for (int i=0;i<linenum;i++) {
//			lastpoint[i]=new point();
//		}
		
		input.getdata();
		//init
//		upper[0]=Integer.MIN_VALUE;
//		for (int i=1;i<linenum;i++)
//			upper[i]=i-1;
//		lower[linenum-1]=Integer.MAX_VALUE;
//		for (int i=0;i<linenum-1;i++)
//			lower[i]=i+1;
		
		list.setcolor(color[trendsNum++]);
		
		
		
		for (int i=0;i<linenum;i++) {
			list.add(new A(i));
		}
		v.add(list);
//		Trends aaa=new Trends() ;
//		for (int i=linenum/2;i<linenum;i++)
//			aaa.add(i);
//		v.add(aaa);
		
			paint f= new paint("line");
			f.setBackground(Color.BLACK);
			f.setSize(5000,5000);
			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}

	class NewPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	protected  void paintComponent(Graphics g) {

//		System.out.println(v);
		
		super.paintComponent(g);
		for(int i=0;i<1000;i++)//x
		{
//			for (int j=0;j<linenum;j++)//line
//			if (lines[j].y[i]!=-1)
//			{
//				//g.drawLine(lastpoint[j].x, lastpoint[j].y,i,lines[j].y[i]);
//				//in(j,i);//处理第j条线，第i个点之后的in和split
//				//for each trend ,keep the uppest line the lowest line
//				//point thispoint=lastpoint[j];
////				point lastupper=(upper[j]>=0)?lastpoint[upper[j]]:null;
////				point lastlower=(lower[j]<=linenum)?lastpoint[lower[j]]:null;
//				//point upperpoint=(upper[j]>=0)?new point(i,lines[upper[j]].y[i]):null;
//				//point lowerpoint=(lower[j]<=linenum)?new point(i,lines[lower[j]].y[i]):null;
//				
////				for(int k=j+1;k<linenum;k++)
////				{
////					int x;
////					if (((x = in(new point(i,lines[j].y[i]),thispoint,new point(i,lines[k].y[i]),lastpoint[k]))>0))
////					{
////						
////					}
////				}
//				
//				lastpoint[j].x=i;
//				lastpoint[j].y=lines[j].y[i];
//			}
			
			for (Trends i1:v) {
				for (A j1:i1) {
					j1.value=lines[j1.num].y[i];
				}
				Collections.sort(i1, sort.t);
			}
			Vector<Trends> temptrend=new Vector<Trends>();
			for (Trends i1:v) {
				//if (i1.size()==0) continue;
				A lastone=i1.firstElement();
				Vector<Integer> label=new Vector<Integer>();
				int labeli=1;             //the first one will be skipped so the value of labeli is 1 instead of 0;
				for (A j1:i1) {
					if (j1==lastone) continue;
					if (j1.value-lastone.value>dis) label.add(labeli);
					lastone=j1;
					labeli++;
				}				
				int begin=0;
				for (int labelnum:label) {
					Trends temp=new Trends();
					for (;begin<labelnum;begin++) {
						temp.add(i1.firstElement());
						i1.remove(0);
					}
					//v.add(temp);
					temp.setcolor(color[trendsNum++]);
					temptrend.add(temp);
				}
			}
			v.addAll(temptrend);
			for (Trends i1:v) {
				//if (i1.size()==0) continue;
				i1.setleft(i1.firstElement().value);
				i1.setright(i1.lastElement().value);
			}
			Collections.sort(v,sort.trends);
			
//			{
//			Vector<Integer> label=new Vector<Integer>();
//			int max=0;
//			int labeli=0;
//			for (Trends i1:v) {
//				if (i1.getright()>max) {
//					max=i1.getright();
//					label.add(labeli);
//				}
//			}
//			}
			
			
			int pnum=0;
			for (Trends ptrend:v) {
				//g.setColor(color[(pnum++)%6]);
				g.setColor(ptrend.getcolor());
				g.drawLine(i, ptrend.getleft(), i, ptrend.getright());
				g.setColor(Color.black);
			}
//			for (int i1=0;i1<v.size();i1++)//for all trends
//			{
//				int min,max;
//				min=Integer.MAX_VALUE;
//				max=Integer.MIN_VALUE;
//				for (A j1:v.get(i1)) {
//					j1.value=lines[j1.num].y[i];
//				}
//				Collections.sort(v.get(i1),sort.t);
//				
//				A lastone=v.get(i1).get(0);
//				int iii=0;
//				Vector<Integer> label=new Vector<Integer>();
//				for (A j1:v.get(i1)) {
//					if (j1==lastone) continue;
//					if (j1.value-lastone.value>dis) label.add(iii);    //对于split，打上label.
//					iii++;
//				}
//				int labeli=0;
//				for (int labelNum:label) {
//					Trends temp=new Trends();
//					for (int pop=labeli;pop<labelNum;pop++) {
//						temp.add(v.get(i1).firstElement());
//						v.get(i1).remove(0);
//						labeli++;
//					}
//					v.add(temp);
//				}
//				
//				for (A j1:v.get(i1))//line in trend
//				{
//					min=(min<lines[j1.num].y[i])?min:lines[j1.num].y[i];
//					max=(max<lines[j1.num].y[i])?lines[j1.num].y[i]:max;
//				}
//				Collections.sort(v,sort.trends);
//				g.setColor(color[i1%6]);
//				g.drawLine(i, min	, i, max);
//				g.setColor(Color.black);
//			}
//			Collections.sort(v, sort.trends);
		}

	}
}
}
