package pl.kodolamacz.solid;

// S O L I D
public class SingleResponsibility {



}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // to już jest za dużo
    // tu raczej powinna być jakaś klasa wczytująca
    // np PersonFactory, PersonFileReader
    static Person readFromFile(String path){
        return new Person("",0);
    }
}