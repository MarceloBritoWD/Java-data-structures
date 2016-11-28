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


		void DFS(int initial){
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

	g.DFS(0);
}
