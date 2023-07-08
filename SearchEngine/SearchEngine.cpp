#include<iostream>
#include<bits/stdc++.h>
using namespace std;

struct metadata{
    string title;
    string URL;
    vector<string>keywords;
};

class web{
    metadata**index;
    web(){
        fstream indices_file;
        indices_file.open("indices.txt",ios::in);
        if(!indices_file.is_open()){
            cout<<"indices.txt not opened."<<endl;
        }
        while()
    }
};

class search : public web{

};

int main(){
    cout<<"Welcome To SE"<<endl;
    
    fstream recents;
    recents.open("RecentlySearched.txt",ios::in | ios::out);
    if(!recents.is_open()){
        cout<<"Error opening RecentlySearched.txt"<<endl;
        return 0;
    }
    string prev_search;
    int n=5;

    cout<<"Recently Searched: "<<endl;
    while(getline(recents,prev_search)&&n){
        cout<<prev_search<<endl;
        n--;
    }
    cout<<"Search here: ";
    string query;
    getline(cin,query);
    

}