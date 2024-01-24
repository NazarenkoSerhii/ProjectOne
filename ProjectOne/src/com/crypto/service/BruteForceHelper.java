package com.crypto.service;

import java.util.HashMap;
import java.util.Map;

public class BruteForceHelper {
    private String addBruteForce(int key) {
        return "*";
    }

    private Map<String, Integer> brutteForeceSymbols() {
        Map<String, Integer> map = new HashMap<>();

        map.put("*", 1);
        map.put("&", 3);

        return map;
    }
}
