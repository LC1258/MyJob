package com.lwj.summary;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int x = 1, y = 1, z = 6;
        y += z-- / ++x;
        System.out.println(y);
        System.out.println(y);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] begin = new int[n];
        int[] end = new int[n];
//        in.nextLine();
        for (int i = 0; i < n; i++) {
           /* String str = in.nextLine();
            String[] strs = str.split(" ");
            begin[i] = Integer.parseInt(strs[0]);
            end[i] = Integer.parseInt(strs[1]);*/
            begin[i] = in.nextInt();
            end[i] = in.nextInt();
        }
        in.close();
        Study[] study = new Study[n];
        for (int i = 0; i < study.length; i++) {
            study[i] = new Study(begin[i], end[i]);
        }
        Arrays.sort(study);
        System.out.println(getCount(study));
    }

    private static int getCount(Study[] study) {
        int count = 0;
        int i = 0;
        int temp = -1;
        while(i < study.length) {
            if(study[i].begin > temp) {
                temp = study[i].end;
                count++;
                i++;
            } else {
                i++;
            }
        }
        return count;
    }

    private static class Study implements Comparable<Study> {
        int begin;
        int end;
        public Study(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Study study) {
            if(this.end > study.end) {
                return 1;
            } else if (this.end == study.end) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
