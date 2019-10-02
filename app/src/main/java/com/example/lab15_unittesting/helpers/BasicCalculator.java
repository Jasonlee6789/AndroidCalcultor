package com.example.lab15_unittesting.helpers;

public class BasicCalculator {

    private double num1, num2, sum, difference, product, quotient;

    public BasicCalculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }



    public double add(){
        sum = getNum1() + getNum2();
        return sum;
    }

    public double subtract() {
        if (getNum1() > getNum2()) {
            difference = getNum1() - getNum2();
        }else {
            difference = getNum2() - getNum1();
    }
        return difference;
    }


    public double multiply(){
        product = getNum1() * getNum2();
        return product;
    }


    public double divide() {
        if (getNum1() > getNum2()) {
            quotient = getNum1() / getNum2();
        }else {
            quotient = getNum2() / getNum1();
        }
        return quotient;
    }
}
