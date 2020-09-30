package com.content2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Food[] breakfast= new Food[20];
        int i = 0;
        boolean cal, sort;  // случаи для спец параметров, начинающихся с дефиса
        cal = sort = false;
        for(String arg: args) {
            String[] parts = arg.split("/");
            if(parts[0].equals("Cheese")){
                breakfast[i] = new Cheese();
            }
            else if(parts[0].equals("Apple")){
                breakfast[i] = new Apple(parts[1]);
            }
            else if(parts[0].equals("Eggs")) {
                breakfast[i] = new Eggs(parts[1]);
            }
            else { switch (parts[0]) {
                case "-sort":
                    sort = true;
                    break;
                case "-calories":
                    cal = true;
                    break;
                default:
                    System.out.println("Cannot find class " + parts[0] + ".\nContinue...\n");
                    i--;
            }
            }

            i++;
        }
        System.out.println("Hello Java!");

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
        for (int k = 0; k < breakfast.length; k++) {
            if (breakfast[k] != null) {
                if (breakfast[k].equals(check)) {
                    counter++;
                }
                ;
            }
        }
        System.out.println("Количество одинарных яиц " + "'" +check + "'" + ": " + counter);
        counter = 0;
        for (int j = 0; j < breakfast.length;j++){

            if (breakfast[j] != null){
                if (breakfast[j].equals_type(check)){
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


