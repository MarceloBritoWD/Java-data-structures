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


		int dijkstra(int point1,int point2){

			priority_queue < pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > queue;

			int distance[size], visited[size] ;

			for(int i = 0; i < size; i++)
			{
				distance[i] = 9999999;
				visited[i] = false;
			}

			distance[point1] = 0;

			queue.push(make_pair(distance[point1], point1));

			while(!queue.empty()){
				pair<int, int> p = queue.top();

				int u = p.second;

				queue.pop();

				if(visited[u] == false){
					visited[u] == true;

					list<pair<int, int> >::iterator it;
					for(it = graph[u].begin(); it != graph[u].end(); it++){
						int v = it->first;
						int cost = it->second;

						if(distance[v] > (distance[u] + cost)){
							distance[v] = distance[u] + cost;
							queue.push(make_pair(distance[v], v));
						}
					}
				}

			}
			return distance[point2];
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

	cout << g.dijkstra(0,4) << endl;
}
