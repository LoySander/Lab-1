package com.content2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        int i = 0;
        boolean cal, sort;  // случаи для спец параметров, начинающихся с дефиса
        cal = sort = false;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Сыр")) {
                breakfast[i] = new Cheese();
            } else if (parts[0].equals("Яблоко")) {
                breakfast[i] = new Apple(parts[1]);
            } else if (parts[0].equals("Яйцо")) {
                breakfast[i] = new Eggs(parts[1]);
            } else if (parts[0].startsWith("-") && parts[1].equals("sort")) {
                sort = true;

            } else if (parts[0].startsWith("-") && parts[1].equals("calories")) {
                cal = true;
            } else {
                System.out.println("Cannot find class " + parts[0] + ".\nContinue...\n");
            }
            i++;
        }




        if(sort == true){
            Arrays.sort(breakfast, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1 == null) {
                        return 1;
                    }
                    else if (o2 == null) {
                        return -1;
                    }
                    else if (o1 instanceof Eggs && o2 instanceof Eggs) {
                        return -(((Eggs) o1).getNumber().compareTo(((Eggs) o2).getNumber()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Apple) {
                        return -(((Apple) o1).getSize().compareTo(((Apple) o2).getSize()));
                    }
                    else{
                        return 0;
                    }

                }
            });
        }
        for(int j =0; j<breakfast.length; j++) {
            if(breakfast[j]!=null)
                breakfast[j].consume();
            else break;
        }
        int counter = 0;
        Eggs check = new Eggs("one");
        Eggs check2 = new Eggs("two");
        Eggs check3 = new Eggs("three");
        for (int k = 0; k < breakfast.length; k++) {
            if (breakfast[k] != null) {
                if (breakfast[k].equals(check)) {
                    counter++;
                }
                if(breakfast[k].equals(check2)){
                    counter=counter +2;
                }
                if(breakfast[k].equals(check3)){
                    counter=counter +3;
                }
                ;
            }
        }
        System.out.println("Количество одинарных яиц " + "'" +check + "'" + ": " + counter);
        counter = 0;
        for (int j = 0; j < breakfast.length;j++){

            if (breakfast[j] != null){
                if (breakfast[j].equals(check)){
                    counter++;
                }
            }
        }
        System.out.println("Количество продуктов заданного типа " + "'" +check.getName() + "'" + ": " + counter);
        int calories = 0;
        if (cal == true){

            for (int j = 0; j < breakfast.length;j++){

                if (breakfast[j] != null){
                    calories += breakfast[j].calculateCalories();
                }
                else{
                    break;
                }
            }
            System.out.println("Каллории " + calories + '\n');
        }

    }
}


