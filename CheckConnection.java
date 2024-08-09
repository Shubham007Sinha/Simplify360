package org.nex.Test2;


public class CheckConnection {
    public int getConnection(String name1, String name2, String []aliceFriendList, String []bobFriendList){
        int count1=0;
        int count2=0;

        // checking the name in aliceFriendList
        for(String name : aliceFriendList){
            if(name1.equals(name) || name2.equals(name)){
                count1++;
            }
        }

        // checking the name In bobFriendList
        for(String name : bobFriendList){
            if(name1.equals(name) || name2.equals(name)){
                count2++;
            }
        }

//        System.out.println("Count 1 : "+count1);
//        System.out.println("Count 2 : "+count2);

        // Connection logic
        if(count1 == 2 || count2 == 2){
            return 1;
        }
        else if (count1 == 1 && count2 == 1){
            return 2;
        }
        return -1;
    }
}

