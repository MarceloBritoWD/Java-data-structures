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



		void BFS(int initial){
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

	g.BFS(0);
}
