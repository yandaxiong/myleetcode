package com.xiong.jingdian150_2;

import com.xiong.utils.OutArrays;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiong
 * @create 2025-11-11-17:06
 */
public class e6_210findOrder {

    public static void main(String[] args) {
        e6_210findOrder e6210findOrder = new e6_210findOrder();
        int numCourses = 5;
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        OutArrays.outArrays(e6210findOrder.findOrder(numCourses, prerequisites));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> outList = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            outList.add(new ArrayList<Integer>());
        }
        int[] dependNum = new int[numCourses];
        for (int[] info : prerequisites) {
            outList.get(info[1]).add(info[0]);
            dependNum[info[0]]++;
        }
        System.out.println(outList);
        OutArrays.outArrays(dependNum);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i){
            if(dependNum[i] == 0){
                queue.offer(i);
            }
        }
        System.out.println(queue);
        int visited = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()){
            Integer u = queue.poll();
            result[visited] = u;
            visited++;
            List<Integer> integers = outList.get(u);
            for (Integer v : integers) {
                dependNum[v]--;
                if(dependNum[v] == 0){
                    queue.offer(v);
                }
            }
        }

        return   visited == numCourses ? result:new int[0];

    }

}
