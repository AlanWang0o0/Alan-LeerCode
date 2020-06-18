package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class T1028 {
    
    public static String s = "3";
    
    public static void main(String[] args){
        System.out.println(recoverFromPreorder(s));
    }

    public static TreeNode recoverFromPreorder(String str) {
        s = str;
        if(s == null || s.equals("") )  return null;
        int i=0;
        while(s.length()>=i+1 && s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0,i)));
        s = s.substring(i);

        root.left = recoverFromPreorder(0);
        root.right = recoverFromPreorder(0);
        return root;
    }

    public static TreeNode recoverFromPreorder(int count){
        if(s == null || s.equals("") )  return null;
        for (int i = 0; i < count+1; i++) {
            if(s.charAt(i) != '-') return null;
        }
        s = s.substring(count+1);
        int i=0;
        while(s.length()>=i+1 && s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s.substring(0,i)));
        s = s.substring(i);
        node.left = recoverFromPreorder(count+1);
        node.right = recoverFromPreorder(count+1);
        return node;

    }
}

