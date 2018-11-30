package line_graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class input {
	static void getdata() throws IOException {
		//StringBuffer s=new StringBuffer("");
		
		FileReader reader=new FileReader("java.txt");
		BufferedReader br=new BufferedReader(reader);
		String str=br.readLine();
		int num=Integer.parseInt(str);
		for (int i=0;i<num;i++)
		{
			int nnum=Integer.parseInt(br.readLine());
			try
			{
			paint.lines[i].num=nnum;
			}catch(Exception e) {}
			try {
			paintsplit.lines[i].num=nnum;
			}catch(Exception e) {}
			
			for(int j=0;j<nnum;j++)
			{
				str=br.readLine();
				String[] xy=str.split(",");
			try {
				paint.lines[i].y[Integer.parseInt(xy[0])]=Integer.parseInt(xy[1]);		
			}catch(Exception e) {}
			try {
				paintsplit.lines[i].y[Integer.parseInt(xy[0])]=Integer.parseInt(xy[1]);
			}
			catch(Exception e) {}
			}
		}
		//while((str=br.readLine())!=null) {
			
		//}
		br.close();
		reader.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getdata();
	}

}
