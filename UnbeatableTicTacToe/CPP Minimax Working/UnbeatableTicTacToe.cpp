#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void print_board(vector<vector<char>>&board){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout<<board[i][j]<<" ";
        }
        cout<<endl<<endl;
    }
}

bool no_moves(vector<vector<char>>&board){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(board[i][j]==' ')return false;
        }
    }
    return true;
}

int terminal_state(vector<vector<char>>&board){
    if(board[0][0]==board[0][1]&&board[0][1]==board[0][2]&&board[0][2]=='X')return 1;
    if(board[1][0]==board[1][1]&&board[1][1]==board[1][2]&&board[1][2]=='X')return 1;
    if(board[2][0]==board[2][1]&&board[2][1]==board[2][2]&&board[2][2]=='X')return 1;
if(board[0][1]==board[1][1]&&board[1][1]==board[2][1]&&board[2][1]=='X')return 1;
    if(board[0][2]==board[1][2]&&board[1][2]==board[2][2]&&board[2][2]=='X')return 1;

    if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[2][2]=='X')return 1;
    if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[2][0]=='X')return 1;

    if(board[0][0]==board[0][1]&&board[0][1]==board[0][2]&&board[0][2]=='O')return -1;
    if(board[1][0]==board[1][1]&&board[1][1]==board[1][2]&&board[1][2]=='O')return -1;
    if(board[2][0]==board[2][1]&&board[2][1]==board[2][2]&&board[2][2]=='O')return -1;

    if(board[0][0]==board[1][0]&&board[1][0]==board[2][0]&&board[2][0]=='O')return -1;
    if(board[0][1]==board[1][1]&&board[1][1]==board[2][1]&&board[2][1]=='O')return -1;
    if(board[0][2]==board[1][2]&&board[1][2]==board[2][2]&&board[2][2]=='O')return -1;

    if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[2][2]=='O')return -1;
    if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[2][0]=='O')return -1;

    return 0;

}
    if(board[0][0]==board[1][0]&&board[1][0]==board[2][0]&&board[2][0]=='X')return 1;
    

int minimax(vector<vector<char>>&board,bool ai_turn){
    if(no_moves(board)){
        return terminal_state(board);
    }
    else{
        if(terminal_state(board)!=0)return terminal_state(board);
    }
    
    int best_move;
    if(ai_turn){
        best_move=INT_MIN;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' '){
                    board[i][j]='X';
                    int new_move=minimax(board,false);
                    board[i][j]=' ';
                    best_move=max(best_move,new_move);
                }
            }
        }
    }
    else{
        best_move=INT_MAX;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' '){
                    board[i][j]='O';
                    int new_move=minimax(board,true);
                    board[i][j]=' ';
                    best_move=min(best_move,new_move);
                }
            }
        }
    }
    return best_move;
}

pair<int,int> findBestMove(vector<vector<char>>&board){
    int best_move=INT_MIN,row,col;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(board[i][j]==' '){
                board[i][j]='X';
                int new_move=minimax(board,false);
                if(new_move>best_move){
                    best_move=new_move;
                    row=i;
                    col=j;
                }
                board[i][j]=' ';
            }
        }
    }
    return {row,col};
}

void func(vector<vector<char>>&board){
    pair<int,int>cell=findBestMove(board);
    int row=cell.first,col=cell.second;
    board[row][col]='X';
    print_board(board);
    if(terminal_state(board)==1){
        cout<<"AI WINS!!!!!!!"<<endl;
        return;
    }
    else if(terminal_state(board)==0&&no_moves(board)){
        cout<<"DRAW!!!"<<endl;
        return;
    }
    cout<<endl<<endl;
    int i,j;
    cin>>i>>j;
    board[i][j]='O';
    print_board(board);
    if(terminal_state(board)==1){
        cout<<"AI WINS!!!!!!!"<<endl;
        return;
    }
    else if(terminal_state(board)==0&&no_moves(board)){
        cout<<"DRAW!!!"<<endl;
        return;
    }
    func(board);
}

void ai_mode(){
    vector<vector<char>>board={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    cout<<"Do you want to play first or AI?"<<endl;
    cout<<"Press 1 if you , 0 for ai"<<endl;
    int choice;
    cin>>choice;
    if(!choice)func(board);
    else{
        int i,j;
        cin>>i>>j;
        board[i][j]='O';
        func(board);
    }
}

int main(){
    ai_mode();
}