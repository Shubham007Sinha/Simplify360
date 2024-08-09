package org.nex.Test;

import java.util.*;

public class MainTask {
    public static void main(String[] args) {
        Task tSTART = new Task(0, 0); // Starting Task
        Task t1 = new Task(1, 4);
        Task t2 = new Task(2, 3);
        Task t3 = new Task(3, 2);
        Task t4 = new Task(4, 5);

        // Here, write the setting dependencies
        t1.dependencies.add(tSTART); // t1 depends on tSTART
        t2.dependencies.add(t1);   // t2 depends on t1
        t3.dependencies.add(t1);   // t3 depends on t1
        t4.dependencies.add(t2);   // t4 depends on t2  and t3
        t4.dependencies.add(t3);

        List<Task> tasks = Arrays.asList(tSTART, t1, t2, t3, t4);

        // Calculate the Earliest and Latest Times of the Task
        calculateTime(tasks, tSTART);

        
        System.out.println("Earliest time all tasks will be completed: " + t4.EFT);
        System.out.println("Latest time all tasks will be completed: " + t4.LFT);
    }

    private static void calculateTime(List<Task> tasks, Task tSTART) {
        // Step 1: Topological Sort
        List<Task> sortedTasks = topologicalSort(tasks);

        // Step 2: Calculate Earliest Start/Finish Times
        for (Task t : sortedTasks) {
            for (Task dep : t.dependencies) {
                t.EST = Math.max(t.EST, dep.EFT);
            }
            t.EFT = t.EST + t.duration;
        }

        // Step 3: Calculate Latest Start/Finish Times
        Collections.reverse(sortedTasks); // Process in reverse order
        tSTART.LFT = tSTART.EFT; // LFT of start task is the same as its EFT
        tSTART.LST = tSTART.EST;

        for (Task t : sortedTasks) {
            if (t.LFT == Integer.MAX_VALUE) {
                t.LFT = t.EFT;
            }
            t.LST = t.LFT - t.duration;
            for (Task dep : t.dependencies) {
                dep.LFT = Math.min(dep.LFT, t.LST);
            }
        }
    }

    private static List<Task> topologicalSort(List<Task> tasks) {
        List<Task> sort = new ArrayList<>();
        Set<Task> visit = new HashSet<>();
        for (Task task : tasks) {
            if (!visit.contains(task)) {
            	topologicalSort(task, visit, sort);
            }
        }
        return sort;
    }

    private static void topologicalSort(Task task, Set<Task> visited, List<Task> sorted) {
        visited.add(task);
        for (Task dep : task.dependencies) {
            if (!visited.contains(dep)) {
            	topologicalSort(dep, visited, sorted);
            }
        }
        sorted.add(task);
    }
}