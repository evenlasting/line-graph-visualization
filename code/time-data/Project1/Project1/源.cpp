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
				return 1500 - 4*x;
}

int main() {
	srand(unsigned(time(0)));
	ofstream out("1.json");
	out.clear();
	out << "{\n";
	for (int i = 0; i < 1000; i++)
	{
		out << "\"line" << i << "\":[" << endl;
		for (int j = 0; j < 400; j += (int)random(5, 20))
		{
			out << "{\"x\":" << j << ",\"y\":" << line(j) + (0.3, 0.4)*line(j) << "}," << endl;
		}
		out<<  "{\"x\":" << 400 << ",\"y\":" << line(400) + (0.3, 0.4)*line(400) << "}" << endl;
		out << "]," << endl;
	}
	out << "}";
	out.close();
}