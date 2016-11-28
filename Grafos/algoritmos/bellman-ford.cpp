int ford(int point1, int point2){
  vector< pair <int,int> > sd;
  int distance[size];
  for (int i = 0; i < size; i ++){

    sd[i].first = 999999;
    sd[i].second = -1;
  }

  sd[point1].first = 0;
  sd[point1].second = 0;
  list< pair< int, int> > :: iterator it;
  for(int i = 1; i <= size -1; ++i){
    for ( int j = 1; j <= size; ++j){
      it = graph[j].begin();
      while (it!= graph[j].end()){
        if(sd[j].first == 999999){
          ++it;
        }

        if((*it).second + sd[j].first < sd[(*it).first].first){
          sd[(*it).first].first = (*it).second + sd[j].first;
          sd[(*it).first].second = j;
        }
        ++it;
      }
    }
  }

  for (int 	j = 1; j <= size; ++j){
    it = graph[j].begin();
    while (it!= graph[j].end()){
      if((*it).second + sd[j].first < sd[(*it).first].first){
        return j;
      }
      ++ it;
    }
  }


}
