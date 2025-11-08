package com.xiong.jingdian150_2;

import com.xiong.utils.OutArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiong
 * @create 2025-09-17-19:33
 * [["x1","x2"],["x2","x3"],["x1","x4"],["x2","x5"]]
 * [["x2","x4"],["x1","x5"],["x1","x3"],["x5","x5"],["x5","x1"],["x3","x4"],["x4","x3"],["x6","x6"],["x0","x0"]]
 */
public class e4_399calcEquation {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        ArrayList<String> l1 = new ArrayList<>(); l1.add("x1");l1.add("x2"); equations.add(l1);
        ArrayList<String> l2 = new ArrayList<>(); l2.add("x2");l2.add("x3"); equations.add(l2);
        ArrayList<String> l3 = new ArrayList<>(); l3.add("x1");l3.add("x4"); equations.add(l3);
        ArrayList<String> l4 = new ArrayList<>(); l4.add("x2");l4.add("x5"); equations.add(l4);
        double[] values = {3.0,0.5,3.4,5.6};
        List<List<String>> queries = new ArrayList<>();
        ArrayList<String> q1 = new ArrayList<>(); q1.add("x1");q1.add("x3"); queries.add(q1);
        e4_399calcEquation e3399calcEquation = new e4_399calcEquation();
        double[] doubles = e3399calcEquation.calcEquation(equations, values, queries);
        OutArrays.outArrays(doubles);


    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Solution2 solution = new Solution2();
        for (int i = 0; i < equations.size(); i++) {
            String source = equations.get(i).get(0);
            String target = equations.get(i).get(1);
            double value = values[i];
            solution.add(source,target,value);
        }
        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String s = queries.get(i).get(0);
            String t = queries.get(i).get(1);
            String sp = solution.find(s);
            String tp = solution.find(t);
            System.out.println(s + " " + sp + " " + t + " " + tp);
            System.out.println(solution.treeMap);
            System.out.println(solution.weightMap);
            if (sp != null && sp.equals(tp)) {
                res[i] = solution.weightMap.get(s) / solution.weightMap.get(t);
            }else {
                res[i] = -1;
            }

        }
        return res;
    }
    class Solution2 {
        HashMap<String, String> treeMap ;
        HashMap<String, Double> weightMap ;
        public Solution2() {
            treeMap = new HashMap<>();
            weightMap = new HashMap<>();
        }
        public void add(String source, String target, double value) {
            if (!treeMap.containsKey(target)) {
                treeMap.put(target, target);
                weightMap.put(target, 1.0d);
            }
           if (!treeMap.containsKey(source)) {
               treeMap.put(source, find(target));
               weightMap.put(source, weightMap.get(target)*value);
           }else{
               String sourceParent = find(source);
               String targetParent = find(target);
               if(sourceParent.equals(targetParent)){return;}

               treeMap.put(sourceParent, targetParent);
               weightMap.put(sourceParent, value*weightMap.get(target)/weightMap.get(source));
           }
            System.out.println(source+"->"+target);
            System.out.println(treeMap);
        }
        public String find(String key) {
            if (!treeMap.containsKey(key)) {return null;}
            if(!key.equals(treeMap.get(key))){
                String parent = treeMap.get(key);
                Double weight = weightMap.get(key);
                treeMap.put(key, find(parent));
                weightMap.put(key,weight*weightMap.get(parent) );
            }
            return treeMap.get(key);
        }




    }


}
