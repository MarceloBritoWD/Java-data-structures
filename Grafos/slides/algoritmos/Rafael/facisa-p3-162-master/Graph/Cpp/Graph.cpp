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

			// for (int i = 0; i < size; i ++){
			// 	for (int j = 0; j < size; j++){
			// 		cout << mt[i][j] << " ";
			// 	}
			// 	cout << endl;
			// }
			for (int k = 0; k < size; k++){
				for (int i = 0; i < size; i++){
					for (int j = 0; j < size; j++){
						if(mt[i][k] + mt[k][j] < mt[i][j]){
							mt[i][j] = mt[i][k] + mt[k][j];
						}
					}
				}
			}
			// for (int i = 0; i < size; i ++){
			// 	for (int j = 0; j < size; j++){
			// 		cout << mt[i][j] << " ";
			// 	}
			// 	cout << endl;
			// }
	// 		for (int i = 0; i < size; i++){
	// 		 for (int j = 0; j < size; j++){
	// 				 if (mt[i][j] == 99999)
	// 						 printf("%7s", "INF");
	// 				 else
	// 						 printf ("%7d", mt[i][j]);
	// 		 }
	// 		 printf("\n");
	//  }

			return mt[point1][point2];
		}

		// list<int>* BSF(int initial){
		void DSF(int initial){
			list<int> l;
			bool visited[size];
			stack<int> s;

			for (int i = 0; i < size; i ++){
				visited[i] = false;
			}

			while (true){

				if(!visited[initial]){
					l.push_back(initial);
					visited[initial] = true;
					s.push(initial);
				}

				bool found = false;
				// for(it = graph[u].begin(); it != graph[u].end(); it++){
				// 	int v = it->first;
				// 	int cost = it->second;
				list<pair<int,int> > :: iterator it;
				int d = 0;
				for (it = graph[initial].begin(); it!= graph[initial].end(); it++){
					d = it->first;

					if(!visited[d]){
						l.push_back(d);
						found = true;
						break;
					}
				}

				if (found){
					initial = d;
				}else{
					s.pop();
					if(s.empty()){
						break;
					}else{
						initial = s.top();
					}
				}

			}

			list<int> :: iterator  it;
			for (it = l.begin(); it != l.end(); it++){
				cout << *it << " ";
			}
			cout << endl;
		}

		void BSF(int initial){
			bool visited[size];
			list<int> l;
			queue<int> q;

			for (int i = 0; i < size; i++){
				visited[i] = false;
			}

			l.push_back(initial);
			visited[initial] = true;

			while(true){
				// for(it = graph[u].begin(); it != graph[u].end(); it++){
				// 	int v = it->first;
				// 	int cost = it->second;
				list<pair< int, int> > :: iterator it;
				for(it = graph[initial].begin(); it != graph[initial].end(); it++){
					int d = it->first;
					if(!visited[d]){
						l.push_back(d);
						visited[d] = true;
						q.push(d);
					}
				}
				if(!q.empty()){
					initial = q.front();
					q.pop();
				}else{
					break;
				}
			}
			list<int> :: iterator  it;
			for (it = l.begin(); it != l.end(); it++){
				cout << *it << " ";
			}
			cout << endl;
			// list<int>* pointer = &l;
			// return pointer;
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
	//g.add(0,4,12);
	g.add(1,2,2);
	cout << g.dijkstra(0,4) << endl;
	//list<int> l;
	// l.push_back(1);
	// l.push_back(2);
	// l.push_back(3);
	//
	// cout << l.front() << endl;
	//list<int>* lf;
	//lf = g.BSF(0);
	g.BSF(0);
	g.DSF(0);
	cout << g.warshall(0,4) << endl;
	// list<int> l;
	// l =  *lf;
	// cout<<l.front()<<endl;
}
