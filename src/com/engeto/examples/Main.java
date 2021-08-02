package com.engeto.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        String numbersInText = "20,30,50,10,-9,20,100,30,-5," +
                "12,5,12,45,4,87,65,415,1,54,54,-5,54,-54,-4,-7,54,-45,23,-54"; // tento soubor čísel jsem zpracovával,
                                                             // je možné tam připisovat nebo přepisovat celá čísla.
        ArrayList<Integer> MyListOfIntegers = new ArrayList<>();
        ArrayList<Integer> MyListOfPositiveIntegers = new ArrayList<>();
        final int LIMIT = 20;

        MyListOfIntegers = readStringGiveInt(numbersInText);

        readIntsFromInputAndPrintItUntilNegative(MyListOfIntegers);
        MyListOfPositiveIntegers = storeAllInputInArrayListUntilNegative(MyListOfIntegers);
        System.out.println("New list without negative numbers:");
        printAllIntegersFromList(MyListOfPositiveIntegers);

        System.out.println(sumAllInputUntilNegative(MyListOfIntegers));
        System.out.println();

        printAllIntegersFromList(MyListOfIntegers);
        System.out.println(sumAllIntegersFromList(MyListOfIntegers));
        System.out.println();

        printIntegersUnderLimit(MyListOfIntegers, LIMIT);
        printIntegersWithReplace(MyListOfIntegers);

        printAllIntegersFromList(MyListOfIntegers);

    }

    public static ArrayList readStringGiveInt(String numbersInText) {
        String numberInText = "";
        ArrayList<Integer> listIntegers = new ArrayList<>();
        for (int i = 0; i < numbersInText.length(); i++) {
            if (numbersInText.charAt(i) != ',') numberInText += numbersInText.charAt(i);
            else {
                listIntegers.add(parseInt(numberInText));
                numberInText = "";
            }
        }
        listIntegers.add(parseInt(numberInText));
        return listIntegers;
    }

    public static void readIntsFromInputAndPrintItUntilNegative(ArrayList<Integer> myList) {
        System.out.println("Numbers from list without negative number:");
        for (int number : myList) {
            if (number > 0) System.out.println(number);
        }
        System.out.println();
    }

    public static int sumAllInputUntilNegative(ArrayList<Integer> myList) {
        System.out.println("Suma all numbers from list without negative number: ");
        int suma = 0;
        for (int number : myList) {
            if (number > 0) suma += number;
        }
        return suma;
    }

    public static ArrayList storeAllInputInArrayListUntilNegative(ArrayList<Integer> myList) {
        ArrayList<Integer> secondListWithoutNegative = new ArrayList<>();
        for (int number : myList) {
            if (number > 0) secondListWithoutNegative.add(number);
        }
        return secondListWithoutNegative;
    }

    public static void printAllIntegersFromList(ArrayList<Integer> myList) {
        System.out.println("All numbers from list");
        for (int number : myList) {
            System.out.println(number);
        }
        System.out.println();
    }

    public static Integer sumAllIntegersFromList(List<Integer> myList) {
        System.out.println("Suma all numbers from list: ");
        int suma = 0;
        for (int number : myList) suma += number;
        return suma;
    }

    public static void printIntegersUnderLimit(List<Integer> myList, int limit) {
        System.out.println("Numbers from list under Limit:");
        for (int number : myList) {
            if (number < limit) System.out.println(number);
        }
        System.out.println();
    }

    public static void printIntegersWithReplace(ArrayList<Integer> myList) {
        Scanner input = new Scanner(System.in);
        printAllIntegersFromList(myList);
        int myIndex = -1;
        System.out.print("Napiš celé číslo, které chceš vyměnit: ");

        while (myIndex==-1) {
            int numberChange = input.nextInt();
            myIndex = myList.lastIndexOf(numberChange);
            if (myIndex == -1) {
                System.out.print("Zadané číslo není v seznamu. Napiš celé číslo ze seznamu: ");
            }
        }
        System.out.print("Napiš nové číslo, které tam bude: ");
        int numberNew = input.nextInt();
        myList.set(myIndex,numberNew);
    }
}