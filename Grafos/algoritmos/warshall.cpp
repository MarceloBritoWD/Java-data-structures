#include <iostream>
#include<stdio.h>
#include <list>
#include <queue>
#include <stack>
using namespace std;

class Graph{
	int size;
	list<pair<int,int> > * graph;

	public:

		Graph(int size){
			this->size = size;
			graph = new list<pair<int,int> >[size];
		}

		void add(int v1, int v2, int w){
			graph[v1].push_back(make_pair(v2, w));
		}

		list<pair<int,int> > getGraph(){
			return * graph;
		}

		int getSize(){
			return size;
		}



		int warshall(int point1, int point2){
			int mt[size][size];
			for (int i = 0; i < size; i ++){
				for (int j = 0; j < size; j++){
					mt[i][j] = 99999;
				}
			}

			list<pair< int, int> > :: iterator it;
			for(int i = 0; i < size; i ++){
			for(it = graph[i].begin(); it != graph[i].end(); it++){
				mt[i][it->first] = it->second;

			}
		}


			for (int k = 0; k < size; k++){
				for (int i = 0; i < size; i++){
					for (int j = 0; j < size; j++){
						if(mt[i][k] + mt[k][j] < mt[i][j]){
							mt[i][j] = mt[i][k] + mt[k][j];
						}
					}
				}
			}

			return mt[point1][point2];
		}

};




int main(){
	Graph g(5);
	g.add(0, 1, 4);
	g.add(1 , 0, 2);
	g.add(1, 3, 5);
	g.add(3, 4, 6);
	g.add(3, 2,2);
	g.add(2,4, 1);

	g.add(1,2,2);

	cout << g.warshall(0,4) << endl;
}
