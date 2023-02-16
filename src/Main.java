import java.util.Scanner;
class drobi {
    private int numerator; //создание переменной, в которой будет числитель
    private int denominator; //создание переменной, в которой будет знаменатель

    public void set(int a, int b) { //задаёт числитель и знаменатель в наши дроби
        if (b != 0){ //обработка ошибки (0 в знаменателе)
            numerator = a;
            denominator = b;
        }
        else{
            System.out.println("0 в знаменателе");
        }
        if(b < 0){ //обработка ошибки (отрицательный знаменатель), переносим минус в числитель
            numerator = -a;
            denominator = -b;
        }
    }

    public void print(){
        System.out.println(numerator+"/"+denominator);
    }

    public static drobi slozh(drobi a, drobi b) {
        drobi summary = new drobi();
        //приводим к общему знаменателю
        summary.numerator = a.numerator * b.denominator + b.numerator * a.denominator; //Вычисление числителя
        summary.denominator = a.denominator * b.denominator; //Вычисление знаменателя
        int maxd;
        // сокращение дроби
        if(Math.abs(summary.numerator) > summary.denominator){
            maxd = summary.denominator;
        }
        else{
            maxd = Math.abs(summary.numerator);
        }
        for(int i = maxd; i >= 2; i--){ //поиск наибольшего общего делителя и деление на него
            if(Math.abs(summary.numerator) % i == 0 && summary.denominator % i == 0){
                summary.numerator /= i;
                summary.denominator /= i;
            }
        }
        return summary;
    }

    public static drobi vichit(drobi a, drobi b) {
        drobi vich = new drobi();
        vich.numerator = a.numerator * b.denominator - b.numerator * a.denominator;
        vich.denominator = a.denominator * b.denominator;
        int maxd;
        if(Math.abs(vich.numerator) > vich.denominator){
            maxd = vich.denominator;
        }
        else{
            maxd = Math.abs(vich.numerator);
        }
        for(int i = maxd; i >= 2; i--){
            if(Math.abs(vich.numerator) % i == 0 && vich.denominator % i == 0){
                vich.numerator /= i;
                vich.denominator /= i;
            }
        }
        return vich;
    }

    public static drobi umnozh(drobi a, drobi b) {
        drobi umn = new drobi();
        umn.numerator = a.numerator * b.numerator;
        umn.denominator = a.denominator * b.denominator;
        int maxd;
        if(Math.abs(umn.numerator) > umn.denominator){
            maxd = umn.denominator;
        }
        else{
            maxd = Math.abs(umn.numerator);
        }
        for(int i = maxd; i >= 2; i--){
            if(Math.abs(umn.numerator) % i == 0 && umn.denominator % i == 0){
                umn.numerator /= i;
                umn.denominator /= i;
            }
        }
        return umn;
    }

    public static drobi delenie(drobi a, drobi b) {
        drobi del = new drobi();
        //переварачиваем вторую дробь и умножаем
        del.numerator = a.numerator * b.denominator;
        del.denominator = a.denominator * b.numerator;
        int maxd;
        if(Math.abs(del.numerator) > del.denominator){
            maxd = del.denominator;
        }
        else{
            maxd = Math.abs(del.numerator);
        }
        for(int i = maxd; i >= 2; i--){
            if(Math.abs(del.numerator) % i == 0 && del.denominator % i == 0){
                del.numerator /= i;
                del.denominator /= i;
            }
        }
        return del;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        drobi a1 = new drobi(); //создание новой дроби со своими характеристиками
        drobi a2 = new drobi();
        a1.set(1,1); //первый аргумент - числитель, второй - знаменатель
        a2.set(1,1);
        System.out.println("Нажмите '1' для задания числителя и знаменателя дробей");
        System.out.println("Нажмите '2' для суммирования дробей");
        System.out.println("Нажмите '3' для вычитания дробей");
        System.out.println("Нажмите '4' для умножения дробей");
        System.out.println("Нажмите '5' для деления дробей");
        int kod = 1;
        while (kod != 0) {
            kod = sc.nextInt(); //пользователь вводит задачу
            switch (kod) {
                case 1:
                    System.out.println("Введите числитель и знаменатель первой дроби");
                    a1.set(sc.nextInt(), sc.nextInt());
                    System.out.println("Введите числитель и знаменатель второй дроби");
                    a2.set(sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    drobi sum = new drobi(); // создание дроби, чтобы туда занести сумму
                    sum = a2.slozh(a1, a2); //вызов функции сложения из класса
                    sum.print();
                    break;
                case 3:
                    drobi vich = new drobi();
                    vich = a2.vichit(a1, a2);
                    vich.print();
                    break;
                case 4:
                    drobi umn = new drobi();
                    umn = a2.umnozh(a1, a2);
                    umn.print();
                    break;
                case 5:
                    drobi del = new drobi();
                    del = a2.delenie(a1, a2);
                    del.print();
                    break;
            }
        }
    }
}