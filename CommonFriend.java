package org.nex.Test2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonFriend {
    public ArrayList<String> getComonFriends(String []aliceFriendList, String []bobFriendList){
        // Create list of new common friend
        ArrayList<String> commonFriendList = new ArrayList<>();

        // Creating Set
        Set<String> set = new HashSet<>();
        for(String name : aliceFriendList){
            set.add(name);
        }

        // getting Common friend
        for (String name : bobFriendList){
            if(set.contains(name)){
                commonFriendList.add(name);
            }
        }

        return commonFriendList;
    }
}
