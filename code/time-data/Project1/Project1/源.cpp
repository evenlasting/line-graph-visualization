#include<iostream>
#include<cstdio>
#include<fstream>
#include<ctime>
#include<cstdlib>
using namespace std;

double random(double start, double end)
{
	return start + (end - start)*rand() / (RAND_MAX + 1.0);
}




double line(double x) {
	if (x < 100) {
		return(x);
	}
	else 
		if (x < 200) {
			return 200 - x;
		}
		else
			if (x < 300) {
				return 3*x - 600;
			}
			else
				return 5*x-1200;
}

double line2(double x) {
	if (x < 100) {
		return 100 - x;
	}
	else
		if (x < 200) {
			return x - 100;
		}
		else
			if (x < 300) {
				return 800 - 2 * x;
			}
			else
				return 5*(x - 400);
}

int main() {
	srand(unsigned(time(0)));
	//ofstream out("2.json");
	ofstream out("java.txt");
	out.clear();
	/*out << "{\n";
	for (int i = 0; i < 100; i++)
	{
		out << "\"" << i << "\":[" << endl;
		for (int j = 0; j < 400; j += (int)random(5, 20))
		{
			out << "{\"x\":" << j << ",\"y\":" << line(j) + random(-0.2, 0.5)*line(j) << "}," << endl;
		}
		out<<  "{\"x\":" << 400 << ",\"y\":" << line(400) + random(-0.2, 0.5)*line(400) << "}" << endl;
		out << "]," << endl;
	}
	for (int i = 100; i < 200; i++)
	{
		out << "\"" << i << "\":[" << endl;
		for (int j = 0; j < 400; j += (int)random(5, 20))
		{
			out << "{\"x\":" << j << ",\"y\":" << line2(j) + random(-0.2, 1)*line2(j) << "}," << endl;
		}
		out << "{\"x\":" << 400 << ",\"y\":" << line2(400) + random(-0.2, 1)*line2(400) << "}" << endl;
		out << "]," << endl;
	}
	out << "}";*/
	
	int num = 200;
	out << num << endl;
	for (int i = 0; i < num/2; i++)
	{
		out << 400 << endl;
		for (int j = 1; j <= 400; j++)
		{
			out << j<<","<<3*(int(line(j) + random(-0.2, 0.5)*line(j))) << endl;
		}
	}


	for (int i = num / 2; i < num; i++)
	{
		out << 400 << endl;
		for (int j = 1; j <= 400; j++)
		{
			out << j << "," << 3*(int(line2(j) + random(-0.2, 0.5)*line2(j))) << endl;
		}
	}
	
	out.close();
}