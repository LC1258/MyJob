package com.lwj.codeexamination.baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                List<Integer> list = new ArrayList<>();
                List<Integer> res = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int k = in.nextInt();
                    for (int l = 0; l < k; l++) {
                        int a = in.nextInt();
                        int b = in.nextInt();
                        for (int z = a; z <= b; z++){
                            if (j == 0) {
                                list.add(z);
                            } else {
                                if (list.contains(z) && !res.contains(z)){
                                    res.add(z);
                                }
                            }
                        }
                    }
                }
                Collections.sort(res);
                System.out.println(res.size());
                for (int j = 0; j < res.size(); j++) {
                    if (j != res.size()) {
                        System.out.print(res.get(j) + " ");
                    } else {
                        System.out.print(res.get(j));
                    }
                }
            }
        }

}
