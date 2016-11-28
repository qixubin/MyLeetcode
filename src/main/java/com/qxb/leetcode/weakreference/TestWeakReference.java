package com.qxb.leetcode.weakreference;

/**
 * Created by qixubin on 2016/5/18.
 */
import java.lang.ref.WeakReference;

/**
 * @author wison
 */
public class TestWeakReference {


    public static void main(String[] args) {

        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        int i=0;

        while(true){
            System.out.println("here is the strong reference 'car' "+car);//use the strong reference in the while loop
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }

}