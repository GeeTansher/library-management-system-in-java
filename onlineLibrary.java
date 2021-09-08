package com.company;

import java.util.Scanner;

class library
{
    // add return show_available issue
    public String[][] books;
    public String[][] issue;
    public String[][] returnB;

    library() {
        books = new String[100][2];
        issue = new String[100][2];
        returnB = new String[100][2];
        for(int i=0;i<100;i++)
        {
            books[i][1]="0";
            issue[i][1]="0";
            returnB[i][1]="0";
        }
        books[0][0]="cinderella";books[0][1]="10";books[1][0]="pride_and_prejudice";books[1][1]="12";books[2][0]="murakami";books[2][1]="14";books[3][0]="one_piece_manga";books[3][1]="20";
        issue[0][0]="cinderella";issue[0][1]="3";issue[1][0]="one_piece_manga";issue[1][1]="10";issue[2][0]="murakami";issue[2][1]="4";
    }
    public void available_books(){
        System.out.println("Name of books and there quantities are:\n");
        for(int i=0;i< books.length;i++)
        {
            if(books[i][0]==null){
                break;
            }
            System.out.println("Name of book "+(i+1)+":"+books[i][0]+"\nQuantity:"+books[i][1]);
        }
    }
    public void show_issued_books(){
        System.out.println("Name of issued books and there quantities are:\n");
        for(int i=0;i< issue.length;i++)
        {
            if(issue[i][0]==null){
                break;
            }
            System.out.println("Name of issued book "+(i+1)+":"+issue[i][0]+"\nQuantity:"+issue[i][1]);
        }
    }
    public void Add(String add_b,String quan_b){
        int m=0;
        for(int i=m;;i++) {
            if(books[i][0]==null) {
                books[i][0] = add_b;
                books[i][1] = quan_b;
                break;
            }
        }
        System.out.println("Added successfully...");
    }

    public void Issue(int[] h,int m) {
        for(int j=0;j<m;j++) {

            int im=h[j]-1;
            int k = Integer.parseInt(books[h[j]-1][1]);
            if((h[j]-1)>= books.length||k==0)
            {
                im=0;
            }
            if(im==0) {
                System.out.println("Sorry the book \""+books[h[j]-1][0]+"\" you want is not available.");
            }
            else {
                for (int i = 0; ; i++) {
                    if (issue[i][0] == null) {
                        issue[i][0] = books[im][0];
                        int y = Integer.parseInt(books[im][1]);
                        y--;
                        books[im][1] = Integer.toString(y);
                        y = Integer.parseInt(issue[i][1]);
                        y++;
                        issue[i][1] = Integer.toString(y);
                        break;
                    }
                }
            }

        }
        System.out.println("Issued successfully...");
    }
    public void Return(int[] h,int m){
        for(int j=0;j<m;j++) {

            int im=h[j]-1;
            int k = Integer.parseInt(books[h[j]-1][1]);
            if((h[j]-1)>= books.length||k==0)
            {
                im=0;
            }
            if(im==0) {
                System.out.println("Sorry the book \""+books[h[j]-1][0]+"\" you want to return is not of our library.");
            }
            else {
                for (int i = 0; ; i++) {
                    if (returnB[i][0] == null) {
                        returnB[i][0] = books[im][0];
                        int y = Integer.parseInt(books[im][1]);
                        y++;
                        books[im][1] = Integer.toString(y);
                        y = Integer.parseInt(returnB[i][1]);
                        y++;
                        returnB[i][1]=Integer.toString(y);
                        break;
                    }
                }
            }

        }
        System.out.println("Returned successfully...");
    }
}
public class onlineLibrary {
    public static void main(String[] args) {
        library l = new library();
        Scanner sc = new Scanner(System.in);
        boolean s=true;
        outer:
        while(s)
        {
            System.out.println("What you want to do?\n1. Show Available books\n2. Add book(s)\n3. Return book(s)\n4. Issue book(s)\n5. Show Issued books\nPress the number:");
            int ch = sc.nextInt();
            switch(ch) {
                case 1: {
                    l.available_books();
                    break;
                }
                case 2: {
                    System.out.println("How many books you wanna add:");
                    int a;
                    a= sc.nextInt();
                    String add_b;
                    String quan_b;
                    for(int i = 0; i < a; i++) {
                        System.out.format("Enter the name of book %d (type _ instead of space):\n",i+1);
                        add_b = sc.next();
                        System.out.format("Enter the quantity of book %d:\n",i+1);
                        quan_b = sc.next();
                        l.Add(add_b,quan_b);
                    }
                    break;
                }
                case 3:{
                    l.available_books();
                    System.out.println("How many books do you want to return:");
                    int m=sc.nextInt();
                    if(m!=0) {
                        System.out.println("Which book(s) you want to return");
                        int[] h = new int[m];
                        for (int i = 0; i < m; i++) {
                            h[i] = sc.nextInt();
                        }
                        l.Return(h, m);
                    }
                    else
                        System.out.println("OK...");
                    break;
                }
                case 4:{
                    l.available_books();
                    System.out.println("These are some of the books.");
                    System.out.println("How many books do you want to issue:");
                    int m=sc.nextInt();
                    if(m!=0) {
                        System.out.println("Which one(s) do you want to issue?");
                        int[] h = new int[m];
                        for (int i = 0; i < m; i++) {
                            h[i] = sc.nextInt();
                        }
                        l.Issue(h, m);
                    }
                    else
                        System.out.println("Ok...");
                    break;
                }
                case 5:
                {
                    l.show_issued_books();
                    break;
                }
                default:{
                    System.out.println("You have entered something wrong.");
                    break outer;
                }
            }
            System.out.println("Wanna exit? (if yes press 1) otherwise press any number key...");
            int ss=sc.nextInt();
            if(ss==1)
                s=false;

        }
    }
}