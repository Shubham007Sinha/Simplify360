package org.nex.Test2;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        String []aliceFriendList = {"Sumit", "Ankit", "Vikash", "Deep", "Manpreet Singh", "Harmanpreet", "Abhishek",
                                     "Suresh", "Adirija", "Love Babbar", "Aman", "Sardha", "Rahul"};

        String []bobFriendList = {"Shubham", "Rajnath", "Monika", "Sirija", "Sindhu", "Raman", "Shuman", "Kajal",
                                  "Prateek", "Adirija", "Love Babbar", "Suresh"};

        // Creating object of CommonFriend class
        CommonFriend commonFriend = new CommonFriend();
        ArrayList<String> commonFriendList =  commonFriend.getComonFriends(aliceFriendList, bobFriendList);

        // Creating object of PrintFriendList class
        PrintFriendList printFriendList = new PrintFriendList();

        // printing alice friend list
        System.out.print("Friend list of Alice : ");
        printFriendList.printFriendList(aliceFriendList);
        System.out.println();

        // printing bob friend list
        System.out.print("Friend list of bob : ");
        printFriendList.printFriendList(bobFriendList);
        System.out.println();

        // printing common friend list of Alice and Bob
        System.out.print("Common friend list of Alice and Bob : ");
        printFriendList.printCommonFriendList(commonFriendList);
        System.out.println();

        // creating object of CheckConnection class
        CheckConnection checkConnection = new CheckConnection();
        int getConnection = checkConnection.getConnection("Sumit", "Adirija", aliceFriendList, bobFriendList);
        System.out.println("Connection Value : "+getConnection);

    }
}

