package org.example;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalData implements GuideInterface{
String [] name;
Date birthDate;
String phoneNumber;
String sex;
public PersonalData() throws IOException {
        this.name = inputName();
        this.birthDate = inputDate();
        this.phoneNumber = inputPhone();
        this.sex = areYouWoman();
}
        Scanner scanner = new Scanner(System.in);

public Date inputDate ()   {
        System.out.println("Введите вашу дату рождения в формате дд.мм.гггг");
        String input  = scanner.next();
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate = null;
        try {
                f.setLenient(false);
                birthDate = f.parse(input);
        } catch (ParseException e) {
                System.out.println("Неверный формат вводимой даты");
                e.printStackTrace();
        }
        return birthDate;
}
public String[] inputName () {
        System.out.println("Введите вашу фамилию");
        String [] name = new String[2];
        name[0] = scanner.next();
        System.out.println("Введите ваше имя");
        name[1] = scanner.next();
        if (!checkName(name[0]) || !checkName(name[1])){
                throw new RuntimeException("Вы используете недопустимые символы для имени");}
        return name;}

public String inputPhone () {
        System.out.println("Введите ваш номер телефона в формате код страны код города номер телефона \nНапример +7499548548");
        String phone = scanner.next();
        if (!checkPhone(phone)){
                throw new RuntimeException("Введён неверный номер телефона");
        }
        return phone;
        }


public Boolean checkName (String name){
        String regex = "[A-Za-zА-Яа-яЁё]{2,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
}
public static Boolean checkPhone(String phone){
        String regex = "[0-9+()]{11,14}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return  matcher.matches();
}
public String areYouWoman (){
        System.out.println("Введите М, если вы мужчина или Ж, если женщина");
        String sex = scanner.next();
        if (sex.equals("Ж") || sex.equals("ж"))
                return "Ж";
        return "М";
}
@Override
public String toString () {
        return "Имя: " + Arrays.toString(name) + "\nДата рождения: "+birthDate+ "\nНомер телефона: " + phoneNumber + "\nПол: " + sex;
}
public String getSurname (){
        return this.name[0];
}
}


