package FullPokerStars;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Check {
    private static Scanner sc = new Scanner(System.in);
    Check(){}
    static boolean answer(String s) {
        Pattern p = Pattern.compile("[dDдД][aAаА]|(yes|YES)|[yY]|[lL][fF]");
        Matcher matcher = p.matcher(s);
        return matcher.find();
    }
    static void toGo() {
        Pattern p = Pattern.compile("[dDдД][aAаА]|(yes|YES)|[yY]|[lL][fF]");
        System.out.println("Продолжим?");
        String s = sc.nextLine();
        if (s.length() != 0) {
            Matcher matcher = p.matcher(s);
            if (!matcher.find()) {
                System.out.println("Уверены, что хотите завершить выполнение программы? Ответьте да, чтобы завершить, нет, чтобы продолжить");
                matcher.reset(sc.nextLine());
                if (matcher.find()) {
                    System.exit(0);
                }
            }
        }
    }
}
