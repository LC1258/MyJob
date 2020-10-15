package com.lwj.codeexamination.sisanjiujiu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("192.168.1.1");
        list.add("192.168.1.2");
        list.add("192.168.1.3");
        list.add("192.168.1.4");
        list.add("192.168.1.1");
        list.add("192.168.1.2");
        list.add("192.168.1.5");
        list.add("192.168.1.1");
        list.add("192.168.1.4");
        list.add("192.168.1.1");
        int k = 3;
        List<String> res = getList(list, k);
        System.out.println(res);
    }

    private static List<String> getList(List<String> list, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        Set<String> set = map.keySet();
        String[][] temp = new String[set.size()][2];
        Iterator<String> iterator = set.iterator();
        int j = 0;
        while(iterator.hasNext()) {
            String ip = iterator.next();
            temp[j][0] = ip;
            temp[j][1] = map.get(ip) + "";
            j++;
        }
        Arrays.sort(temp, (a, b) -> (b[1].compareTo(a[1])));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(temp[i][0] + "," + temp[i][1]);
        }
        return result;
    }
}
