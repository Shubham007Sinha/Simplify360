package org.nex.Test2;


import java.util.ArrayList;

public class PrintFriendList {
    // print friend list of alice and bob
    public void printFriendList(String []friendList){
        for (String name : friendList){
            System.out.print(name+" ");
        }
    }

    // print common friend of alice and bob
    public void printCommonFriendList(ArrayList<String> commonFriendList){
        for(String name : commonFriendList){
            System.out.print(name+" ");
        }
    }
}
