package com.company;

import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=' ';
            }
        }
        char player='x';
        boolean gameover=messed(board);
        Scanner umang = new Scanner(System.in);
        while(!gameover){
            printboard(board);
            System.out.println("enter the position for "+player);
            int r= umang.nextInt();
            int c=umang.nextInt();
            if(board[r][c]==' '){
                board[r][c]=player;
                if(wonit(board,player)){
                    System.out.println(player+"has won");
                    break;
                }else{
                    player= player=='x'?'0':'x';
                }
            }
            else {
                System.out.println("invalid move, please try again");
            }
            gameover=messed(board);
        }
        if(gameover==true){
            System.out.println("Game draw");
        }
        else{
            printboard(board);
        }
    }
    static void printboard(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print("|"+arr[i][j]);
            }
            System.out.println();
        }
    }
    static boolean wonit(char[][] arr,char player ){
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==player&&arr[i][1]==player&&arr[i][2]==player){
                return true;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[0][i]==player&&arr[1][i]==player&&arr[2][i]==player){
                return true;
            }
        }
        if(arr[0][0]==player&&arr[1][1]==player&&arr[2][2]==player){
            return true;
        }
        if(arr[0][arr.length-1]==player&&arr[1][arr.length-2]==player&&arr[2][arr.length-3]==player){
            return true;
        }
        return false;
    }
    static boolean messed(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
}
