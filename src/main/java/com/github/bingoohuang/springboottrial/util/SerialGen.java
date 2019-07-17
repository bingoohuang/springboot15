package com.github.bingoohuang.springboottrial.util;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class SerialGen {
    public static void main(String[] args) {
        Set<Integer> sets = new HashSet<>();
        SecureRandom rand = new SecureRandom();

        long l = System.currentTimeMillis();
        for (int i = 0; i < 100_000; ++i) {
            int n = rand.nextInt(100_000_000);
            sets.add(n);
            System.out.println(n);
        }

        System.out.println("size:" + sets.size() +", cost:" + (System.currentTimeMillis() - l));
    }
}
