package game;

import java.util.Random;
import java.util.Scanner;
public class TicTacToi {
    Scanner scanner;
    char[][] table;
    Random random;
    public TicTacToi(){
        scanner = new Scanner(System.in);
        random = new Random();
        table = new char[5][5];
    }
    public void playGame(){
        System.out.println("The game is started");
        initTable();
        printTable();
        while(true) {
            turnHuman();
            if(checkWin('x')){
                printTable();
                System.out.println("YOU WON");
                break;
            }
            if(isTableFull()){
                System.out.println("DRAW");
                break;
            }
            turnAi();
            printTable();
            if(checkWin('o')){
                printTable();
                System.out.println("AI WON");
                break;
            }
        }
    }

    public void initTable() {
        //TicTacToi t = new TicTacToi();
       // t.playGame();
        for(int x=0 ;x<table.length; x++){
            for(int y=0; y<table[x].length; y++){
                table[x][y]='.';
            }
        }
    }
    public void printTable() {
        for(int x=0 ;x<table.length; x++){
            for(int y=0; y<table[x].length; y++){
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }
    public void turnHuman() {
        int x,y;
        do{
            System.out.println("Enter x and y from {0..4}");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }while (!isCellValid(x,y));

        table[x][y]='x';
    }
    public boolean isCellValid(int x,int y){
        if(x<0 || x>4 || y<0 || y>4){
            return false;
        }
        return table[x][y]=='.';
    }
    public boolean checkWin(char symbol){
        int dig1=0,dig2=0,hor=0,ver=0,dig_m=0,dig_b=0,dig3=0,dig4=0;
        for(int i=0; i<table.length; i++){
            if(dig2==4  || hor==4 || ver==4 || dig_b==4 || dig_m==4 || dig3==4 || dig4==4){
                return true;
            }
            dig2=0;
            hor=0;
            ver=0;
            dig_m=0;
            dig_b=0;
            dig3=0;
            dig4=0;
            for(int j=0; j<table[i].length; j++){
                if(i==j && table[i][j]==symbol){
                    dig1++;
                }
                if(table[table.length-j-1][j]==symbol){
                    dig2++;
                }
                if(table[i][j]==symbol){
                    hor++;
                }
                if(table[j][i]==symbol){
                    ver++;
                }
                if(table.length-j-2>=0) {
                    if (table[j][table.length - j - 2] == symbol) {
                        dig_m++;
                    }
                }
                if(j+1<table.length) {
                    if (table[j + 1][table.length - j - 1] == symbol) {
                        dig_b++;
                    }
                }
                if(j+1<table.length){
                    if(table[j][j+1]==symbol){
                        dig3++;
                    }
                    if(table[j+1][j]==symbol){
                        dig4++;
                    }
                }
            }
            if(dig1==4){return true;}
            /*if(dig1==4 || dig2==40  || hor==4 || ver==4 || dig_b==4 || dig_m==4 || dig3==4 || dig4==4){
                return true;
            }*/
        }
        return false;
    }
    public boolean isTableFull(){
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[i].length; j++){
                if(table[i][j]=='.'){
                    return false;
                }
            }
        }
        return true;
    }
    public void turnAi(){
        int x,y;
        do{
            x = random.nextInt(0,4);
            y = random.nextInt(0,4);

        }while (!isCellValid(x,y));
        table[x][y]='o';
    }
}