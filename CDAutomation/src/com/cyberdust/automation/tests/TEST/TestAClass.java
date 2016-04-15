package com.cyberdust.automation.tests.TEST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestAClass {

	public static void main(String[] args) throws Exception {
        TestAClass myTest = new TestAClass();

        myTest.test2();
	}

    public void test2() {
        for (int i = 1; i < 4; i++) {
            System.out.println(i);
        }
    }
    public void test() {
        //List<String> selectedList = new ArrayList<>();
        Random random = new Random();
        String currentPick;
        //String myList [] = {"A", "B", "C", "D"};
        List<String> myList = new ArrayList<>();

        myList.add("A");
        myList.add("B");
        myList.add("C");

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for (int i = 0; i < 30; i++) {
            currentPick = myList.get(random.nextInt(3));

            if (currentPick.equals("A") && aCount < 3) {
                aCount += 1;
            } else if (aCount > 1) {
                aCount -= 1;
            }

            if (currentPick.equals("B") && bCount < 3) {
                bCount += 1;
            } else if (bCount > 1) {
                bCount -= 1;
            }

            if (currentPick.equals("C") && cCount < 3) {
                cCount += 1;
            } else if (cCount > 1) {
                cCount -= 1;
            }

            if (currentPick.equals("A") && (aCount < bCount) && (aCount < cCount)) {
                System.out.println("A");
            } else if (aCount == bCount) {

            }
        }

        //System.out.println(selectedList);
        System.out.println("A: "+aCount);
        System.out.println("B: "+bCount);
        System.out.println("C: "+cCount);
    }
}
