package com.lwj.codeexamination.qianxin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" +");//一个或多个空格(tab)
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].equals("undo")) {
                String resDel = res.remove(res.size() - 1);
                tmp.add(resDel);
            }
            else if(strs[i].equals("redo")) {
                String tmpDel = tmp.remove(tmp.size() - 1);
                res.add(tmpDel);
            }
            else res.add(strs[i]);
        }
        for (int i = 0; i < res.size(); i++) {
            if(i == res.size()-1) System.out.println(res.get(i));
            else System.out.print(res.get(i) + " ");
        }
    }
}
