package line_graph;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintsplit extends JFrame{
	public paintsplit(String s) {
		super.setTitle(s);
		add(new NewPanel());
	}

	static int linenum=10;
	public static int lineNum=10;
	public static int del=10;
	public static int dis = 5;  //分开的距离
	
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
	
	static public line[] lines=new line[2000]; 	
	static public point[] lastpoint=new point[lineNum];
	
	
	static public int [] upper=new int[100];  //上面的线
	static public int [] lower=new int [100];  //下面的线
	static public point [] inter=new point [100];	//交点	
	static public int [][] interLine =new int [100][101];   //交线
	static public point [] split =new point [100];	//离点
	static public int [][] splitLine =new int [100][2];  //相离的线
	
	static Vector<Vector<Integer>> v=new Vector<Vector<Integer>>();
	static Vector<Integer> list=new Vector<Integer> ();
	
	static Vector<A> order=new Vector<A>();
	static class A{
		public A(int a,int b) {
			num=a;
			value=b;
		}
		public A(int a) {
			num=a;
			value=0;
		}
		int num;
		int value;
	}
	
	
	
	static Color[] color= {Color.red,Color.blue,Color.green,Color.yellow,Color.pink,Color.orange};
	
	static int  in(point p1,point p2,point p3,point p4)//p1,p2 upper
	{
		if ((p2.x-p1.x)*(p4.y-p3.y)==(p2.y-p1.y)*(p4.x-p3.x)) return 0;
		if ((p2.x-p1.x)*(p4.y-p3.y)<(p2.y-p1.y)*(p4.x-p3.x)) return -1;
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println("111");
		for (int i=0;i<lineNum;i++)
			lines[i]=new line(1000);
		for (int i=0;i<lineNum;i++) {
			lastpoint[i]=new point();
		}
		
		for (int i=0;i<linenum/2;i++) {
			order.add(new paintsplit.A(i,i));
		}
		Collections.sort(order,sort.t);
		System.out.println(order.get(1).value);
		
		input.getdata();
		//init
		upper[0]=Integer.MIN_VALUE;
		for (int i=1;i<linenum;i++)
			upper[i]=i-1;
		lower[linenum-1]=Integer.MAX_VALUE;
		for (int i=0;i<linenum-1;i++)
			lower[i]=i+1;
		for (int i=0;i<linenum/2;i++)
		{
			Vector<Integer> list1=new Vector<Integer> ();
			list1.add(i);
			v.add(list);
		}
		//Vector<Integer> aaa=new Vector<Integer>() ;
		for (int i=linenum/2;i<linenum;i++)
			{
			Vector<Integer> aaa=new Vector<Integer>() ;
			aaa.add(i);
			v.add(aaa);
		}
		
			paintsplit f= new paintsplit("line");
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
			for (int j=0;j<linenum;j++)//line
			if (lines[j].y[i]!=-1)
			{
				//g.drawLine(lastpoint[j].x, lastpoint[j].y,i,lines[j].y[i]);
				//in(j,i);//处理第j条线，第i个点之后的in和split
				//for each trend ,keep the uppest line the lowest line
				point thispoint=lastpoint[j];
				point lastupper=(upper[j]>=0)?lastpoint[upper[j]]:null;
				point lastlower=(lower[j]<=linenum)?lastpoint[lower[j]]:null;
				//point upperpoint=(upper[j]>=0)?new point(i,lines[upper[j]].y[i]):null;
				//point lowerpoint=(lower[j]<=linenum)?new point(i,lines[lower[j]].y[i]):null;
				
				for(int k=j+1;k<linenum;k++)
				{
					int x;
					if (((x = in(new point(i,lines[j].y[i]),thispoint,new point(i,lines[k].y[i]),lastpoint[k]))>0))
					{
						
					}
				}
				
				lastpoint[j].x=i;
				lastpoint[j].y=lines[j].y[i];
			}
			
			for (int ii=linenum/2;ii<linenum;ii++) {
				if (lines[ii].y[i]-lines[ii-1].y[i]>dis) {
				}
			}
			
			for (int i1=0;i1<v.size();i1++)//trend
			{
				int min,max;
				min=Integer.MAX_VALUE;;
				max=Integer.MIN_VALUE;
				for (Integer j1:v.get(i1))//line in trend
				{
					min=(min<lines[j1].y[i])?min:lines[j1].y[i];
					max=(max<lines[j1].y[i])?lines[j1].y[i]:max;
				}
				g.setColor(color[i1%6]);
				
				//g.drawLine(lastpoint[v.get(i1).get(0).num].x, lastpoint[v.get(0).get(0)].y,i,lines[v.get(0).get(0)].y[i]);
				
				g.drawLine(i, min	, i, max);
				g.setColor(Color.black);
			}
		}

	}
}
}
