package com.content2;


public class Eggs extends Food {
        private String number;
    private Double calories = null;
        public Eggs (String number) {
            super("Яйцо");
            this.number = number;
        }

        public Double calculateCalories()
        {
            if(number.equals("одно"))
            {
                calories = 100.0;
            }
            else if(number.equals("два"))
            {
                calories = 200.0;
            }
            else if(number.equals("три"))
            {
                calories = 300.0;
            }
            else return 0.0;
            return calories;
        }
        public void consume(){
            System.out.println(this+ " съедено");
        }
        public String getNumber() {
            return number;
        }
        public void setNumber(String number) {
            this.number = number;
        }
        public boolean equals(Object arg0) {
            if(super.equals(arg0)) {
                if(!(arg0 instanceof Eggs)) return false;
                return number.equals(((Eggs)arg0).number);
            } else
                return false;
        }
        public String toString() {
            return super.toString() + " номера '"+ number.toUpperCase() + "'";
        }

    }

