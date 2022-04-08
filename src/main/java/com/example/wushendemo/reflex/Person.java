package com.example.wushendemo.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: wushen
 * @date: 2021/7/5 下午11:10
 * @description:
 */
public class Person {

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void sayHello(){
        System.out.println("hello ward");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name +
                '}';
    }

    public static void main(String[] args) throws Exception{
//        Person person = new Person();
//        person.setName("wushen");
//        person.sayHello();//hello ward
//        System.out.println(person);//Person{name='wushen}



        Class<?> clazz=Class.forName("com.example.wushendemo.reflex.Person");
        //获取到对象
        Person person1 = (Person)clazz.newInstance();
        //获取到对象的属性
        Field field = clazz.getDeclaredField("name");
        //Field[] field=clazz.getDeclaredFields(); 获取所有属性
        field.setAccessible(true);
        field.set(person1, "wushen");
        System.out.println(field.get(person1));//wushen

        //调用person的sayHello方法
        Method sayHello = clazz.getMethod("sayHello");
        sayHello.invoke(person1);//hello ward
        System.out.println(person1);//Person{name='wushen}
    }

}

