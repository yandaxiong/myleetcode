package com.xiong.jingdian150_2;

import java.util.HashMap;

/**
 * @author xiong
 * @create 2025-09-03-20:44
 */
public class b14_236lowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNodeL1 = new TreeNode(2);
        treeNode.left = treeNodeL1;
        b14_236lowestCommonAncestor b14236lowestCommonAncestor = new b14_236lowestCommonAncestor();
        b14236lowestCommonAncestor.lowestCommonAncestor(treeNode,treeNode,treeNodeL1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        zhongxu(root, map);
        Integer rootNum = map.get(root);
        Integer pNum = map.get(p);
        Integer qNum = map.get(q);
        while ( root!=p && root!=q && ((pNum>rootNum && qNum >rootNum) ||  (pNum<rootNum && qNum <rootNum) )    ){
            if (pNum > rootNum){
                root = root.right;
            }else{
                root = root.left;
            }
            rootNum = map.get(root);
        }
        return root;
    }
    private void zhongxu(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null){return;}
        zhongxu(root.left, map);
        map.put(root, map.size()+1);
        zhongxu(root.right, map);
    }
}
