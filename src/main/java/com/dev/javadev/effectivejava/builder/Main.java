package com.dev.javadev.effectivejava.builder;


class Main{
    public void foo(){
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(1, 1).fat(1).build();
    }
}