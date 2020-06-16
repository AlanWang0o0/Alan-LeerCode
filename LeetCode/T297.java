package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T297 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(serialize(a));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return  serialize(root,"");
    }

    public static String serialize(TreeNode root, String str){
        if(root == null)    str += "None,";
        else{
            str += root.val+",";
            str = serialize(root.left , str);
            str = serialize(root.right , str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] s = data.split(",");
        List<String> l = new LinkedList<String>(Arrays.asList(s));
        return deserialize(l);
    }

    public static TreeNode deserialize(List<String> l){
        if(l.get(0).equals("None")){
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));  // 初始化根节点
        l.remove(0);
        root.left = deserialize(l);
        root.right = deserialize(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
/**
 * Definition for a binary tree node.

 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

