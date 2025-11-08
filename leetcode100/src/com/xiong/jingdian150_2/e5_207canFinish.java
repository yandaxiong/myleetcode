package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author xiong
 * @create 2025-09-18-16:36
 */
public class e5_207canFinish {
    public static void main(String[] args) {
        e5_207canFinish e5207canFinish = new e5_207canFinish();
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(e5207canFinish.canFinish(numCourses, prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return false;
        HashMap<Integer, Boolean> resultMap = new HashMap<>();
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        int length = prerequisites.length;
        for (int i = 0; i < length; i++) {
            int i1 = prerequisites[i][0];
            int i2 = prerequisites[i][1];
            resultMap.put(i1, true);
            resultMap.put(i2, true);
            if (!nodeMap.containsKey(i2)){
                Node node = new Node(i2);
                nodeMap.put(i2, node);
            }
            Node nodei2 = nodeMap.get(i2);
            if(nodeMap.containsKey(i1)){
                Node node = nodeMap.get(i1);
                List<Node> neighbors = node.neighbors;
                if(!neighbors.contains(nodei2)){
                    neighbors.add(nodei2);
                }
            }else{
                Node node = new Node(i1);
                node.neighbors.add(nodei2);
                nodeMap.put(i1, node);
            }
        }
        System.out.println(nodeMap);

        for (Node node : nodeMap.values()) {
            HashSet<Node> calNodes = new HashSet<>();
            if(!calNodes.contains(node)){
                dfsNode(node, resultMap,calNodes);
                System.out.println(node.val+"---"+resultMap);
            }
        }
        System.out.println(resultMap);
        int resultIndex = 0;
        for (Boolean b : resultMap.values()) {
            if(b) resultIndex++;
        }
        return resultIndex>=numCourses;
    }
    public void dfsNode(Node root, HashMap<Integer, Boolean> resultMap,HashSet<Node> calNodes ) {
        calNodes.add(root);
        List<Node> neighbors = root.neighbors;
        for (Node node : neighbors) {
            if (calNodes.contains(node)) {
                resultMap.put(node.val,false);
            }else {
                dfsNode(node, resultMap, calNodes);
                if (resultMap.get(node)!=null && !resultMap.get(node)) {
                    resultMap.put(node.val, false);
                }
            }
        }

    }


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", neighbors=" + neighbors.size() +
                    '}';
        }
    }
}
