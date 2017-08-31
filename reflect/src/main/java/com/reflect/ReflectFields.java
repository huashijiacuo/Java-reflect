package com.reflect;

import java.lang.reflect.Field;
import java.util.logging.FileHandler;

/**
 * Created by shun on 2017/8/31.
 */
public class ReflectFields extends Base implements ReflectInterface {
    public String publicField = "publicField";
    private String privateField = "privateField";

    public static void main(String[] args) {
        ReflectFields reflectFields = new ReflectFields();
        Class<?> refClass = reflectFields.getClass();
        Field[] fields = refClass.getFields();
        System.out.println("********getFields()***********");
        for (Field field : fields) {
            System.out.println(field);
           /* if (field.getName().equals("interfaceField")) {
                int modifiers = field.getModifiers();
                ModifierDemo.printModifier(modifiers);
            }*/
        }

        Field [] fieldsDecl = refClass.getDeclaredFields();
        System.out.println("**********getDeclaredFields()**********");
        for (Field field : fieldsDecl) {
            System.out.println(field.getName());
        }
    }

    @Override
    public void getReflectName() {
        Class<?> myClass = this.getClass();
        String className = myClass.getName();
        System.out.println(className);
    }
}
