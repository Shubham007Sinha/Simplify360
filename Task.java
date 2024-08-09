package org.nex.Test;


import java.util.*;

class Task {
    int id;
    int duration;
    int EST = 0; // Earliest Start Time
    int EFT = 0; // Earliest Finish Time
    int LST = Integer.MAX_VALUE; // Latest Start Time
    int LFT = Integer.MAX_VALUE; // Latest Finish Time
    List<Task> dependencies = new ArrayList<>();

    Task(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }
}