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

double line2(double x) {
	return 3 * x;
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

int main() {
	srand(unsigned(time(0)));
	ofstream out("2.json");
	out.clear();
	out << "{\n";
	for (int i = 0; i < 100; i++)
	{
		out << "\"" << i << "\":[" << endl;
		for (int j = 0; j < 400; j += (int)random(5, 20))
		{
			out << "{\"x\":" << j << ",\"y\":" << line(j) + random(-1, 1)*line(j) << "}," << endl;
		}
		out<<  "{\"x\":" << 400 << ",\"y\":" << line(400) + random(-1, 1)*line(400) << "}" << endl;
		out << "]," << endl;
	}
	out << "}";
	/*
	int num = 10;
	out << num << endl;
	for (int i = 0; i < num/2; i++)
	{
		out << 1000 << endl;
		for (int j = 1; j <= 1000; j++)
		{
			out << j<<","<<int(line(j) + random(-0.005, 0.005)*line(j)) << endl;
		}
	}


	for (int i = num / 2; i < num; i++)
	{
		out << 1000 << endl;
		for (int j = 1; j <= 1000; j++)
		{
			out << j << "," << int(line2(j) + random(-0.1, 0.1)*line2(j)) << endl;
		}
	}
	*/
	out.close();
}