package com.real.world.kafka.config;

import java.util.Collection;
import java.util.HashSet;

class StaticBindingTest{

    public Collection sort(Collection collection){

        System.out.println("inside collection sort method ");
        return collection;
    }
    public Collection sort(HashSet hashSet){
        System.out.println("inside hashset sort method");
        return hashSet;
    }

    public static void main(String[] args) {

        Collection c=new HashSet();
        StaticBindingTest s=new StaticBindingTest();
        s.sort(c);
    }

}



 class BaseClass{

     public static void print(){
         System.out.println("base class static method");
     }
     public  void add(){
         System.out.println("base class instance method");
     }

}

class ChildClass extends BaseClass{

    public static void print(){
        System.out.println("child class instance method");
    }
    public  void add(){
        System.out.println("child class static method");
    }

}


public class TestClass{

     public static void main(String[] args) {
         System.out.println("Welcome");

         BaseClass base=new ChildClass();
         base.add();;
         base.print();


         Collection collection=new HashSet();



    }


}



