#include <cstdlib>
#include <iostream>
#include <stack>
#include <vector>
#include <queue>
#include <algorithm>
#include "stdafx.h"

using namespace std;

class Point {
	int x, length;
	vector < int > road;
public:
	Point(int a) { x = a; length = 0; }
	void NewPoint(int a) { road.push_back(a);  length++; }//dodaje drogę wg.ogległości
};


int main(int argc, char *argv[])
{

	std::stack < int > punkty_rozstaju;
	std::stack < int > temp;
	std::queue < int > kolejnosc;
	std::stack < int > nrb;
	vector < int > zwiedzone;

	int gdziebylem[8];
	for (int i = 0; i<8; i++) { gdziebylem[i] = 0; }
	int rd[8][8];
	Point * mac[8];
	int nw;
	for (int i = 0; i<8; i++) { for (int j = 0; j<8; j++) { rd[i][j] = 0; } }

	rd[0][1] = 1;//DEKLARACJA DŁUGOCI DRÓG MIĘDZY PUNKTAMI
	rd[1][2] = 1;
	rd[1][5] = 1;
	rd[2][3] = 1;
	rd[2][6] = 1;
	rd[4][5] = 1;
	rd[5][6] = 1;
	rd[6][7] = 1;//DEKLARACJA DŁUGOCI DRÓG MIĘDZY PUNKTAMI

	int Start, End;
	cout << "Podaj punkt startu:";
	cin >> Start;

	cout << "Podaj punkt końcowy:";
	cin >> End;
	
	if(End<Start){swap(Start,End);}

	nw = Start;
	int sumpkt=0;

	while (nw != End) {
		for (int i = 0; i<8; i++) {
			if (rd[nw][i] != 0) { sumpkt++; temp.push(i); }
		}
		if (sumpkt = 0) { nw = punkty_rozstaju.top(); punkty_rozstaju.pop(); }
		if (sumpkt = 1) { nw = temp.top(); nrb.push(nw); temp.pop(); sumpkt = 0; }
		if (sumpkt > 1) { nw = temp.top(); nrb.push(nw); temp.pop(); sumpkt = 0;
			while (temp.size()>1) { punkty_rozstaju.push(temp.top()); temp.pop(); }
		}
		cout << nw << " ";
	}
	cout << nw;
	cout << "jest sciezka";

	system("PAUSE");,
	return 0;
}
