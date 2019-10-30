package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping()
public class NumberGeneration {


    private static int i = 1;
    private static String random = " ";
    private static int index = 0;
    private static int index1 = 0;
    private static int index2 = 0;
    static final char dm = (char) 34;
    static int f = 0;
    private static final int REGION = 116;
    private static final String STRANA = "RUS";

    static String next = "";

    private String[] Nomer = {"А", "Е", "Т", "М"};
    private String[] Nomer1 = {"О", "Р", "Н", "В"};
    private String[] Nomer2 = {"У", "К", "Х", "С",};

    private int length1 = Nomer.length;
    private int length2 = Nomer1.length;
    private int length3 = Nomer2.length;

    private Random rm = new Random();

    @GetMapping("/next/getRandom")

    public String getRandom() {

        int rand1 = (int) (Math.random() * length1);
        int rand2 = (int) (Math.random() * length2);
        int rand3 = (int) (Math.random() * length3);

        int num = rm.nextInt(999);

        if (num <= 9) {
            random = "Ответ: " + Nomer[rand1] + "00" + num + Nomer[rand2] + Nomer[rand3] + " " + REGION + " " + STRANA + " ";
        } else if (num > 9 && num < 100) {
            random = "Ответ: " + Nomer[rand1] + "0" + num + Nomer[rand2] + Nomer[rand3] + " " + REGION + " " + STRANA + " ";
        } else
            random = "Ответ: " + Nomer[rand1] + num + Nomer[rand2] + Nomer[rand3] + " " + REGION + " " + STRANA + " ";

        return random;

    }


    @GetMapping("/next/getNext")
    public static String getNext() {
        List<String> list = new ArrayList<>();
        list.add("А");
        list.add("Е");
        list.add("Т");
        list.add("М");
        list.add("О");
        list.add("Р");
        list.add("У");
        list.add("К");
        list.add("Х");
        list.add("В");
        list.add("Н");

        Collections.sort(list);

        if (i < 10) {

            next = "Ответ: " + dm + list.get(index) + "00" + i++ + list.get(index1) + list.get(index2) + " " + REGION + " " + STRANA;

        } else if (i > 9 && i < 100) {

            next = "Ответ: " + dm + list.get(index) + "0" + i++ + list.get(index1) + list.get(index2) + " " + REGION + " " + STRANA;

        } else if (i >= 100) {
            i = 0;
            next = "Ответ: " + dm + list.get(index) + "00" + i++ + list.get(index1) + list.get(index2++) + " " + REGION + " " + STRANA;
        } else {
            next = "Ответ: " + dm + list.get(index) + i++ + list.get(index1) + list.get(index2) + " " + REGION + " " + STRANA;

        }

        return next + dm;
    }

}
