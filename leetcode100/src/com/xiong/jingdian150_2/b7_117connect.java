package com.xiong.jingdian150_2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-08-28-21:08
 */
public class b7_117connect {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        zhongxu(root,map,0);
        for(ArrayList<Node> nodes : map.values()){
            for(int i = 0 ; i < nodes.size()-1 ; i++){
                Node node = nodes.get(i);
                node.next = nodes.get(i+1);
            }
        }
        return root;
    }

    public void zhongxu(Node root, HashMap<Integer,ArrayList<Node>> map,int level) {
        if (root == null) {return;}
        ArrayList<Node> list = map.getOrDefault(level,new ArrayList<Node>());
        list.add(root);
        map.put(level,list);
        zhongxu(root.left,map,level+1);
        zhongxu(root.right,map,level+1);
    }

}
