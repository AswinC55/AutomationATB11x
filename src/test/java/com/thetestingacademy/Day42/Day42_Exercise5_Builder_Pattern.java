package com.thetestingacademy.Day42;

public class Day42_Exercise5_Builder_Pattern {

    public Day42_Exercise5_Builder_Pattern step1(){
        System.out.println("Step1");
        return this;
    }

    public Day42_Exercise5_Builder_Pattern step2(){
        System.out.println("Step2");
        return this;
    }

    public Day42_Exercise5_Builder_Pattern step3(String param1){
        System.out.println("Step3");
        return this;
    }

    public static void main(String[] args) {
        Day42_Exercise5_Builder_Pattern bp = new Day42_Exercise5_Builder_Pattern();
        bp.step1().step2().step3("Siva");
    }
}
