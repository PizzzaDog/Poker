package FullPokerStars;

import java.util.Scanner;

/* created by PizzaDog 05.06.2019
* update 1.1.0 Beta 08.10.2019:
* Добавлена проверка комбинаций кроме Royal Flush, Straight Flush, Straight
* Игра разделена на раздачи
*
* update 1.0.1 pre-alpha:
* Компьютер раздает карты из 1 колоды максимум на 10 игроков (по классике Texas Holdem)
* Последовательность игры:
* - задать количество игроков
* - дать игрокам имена
* - 1 раздача: по 2 карты игрокам
* - 2 раздача: флоп + показать карты игроков
* - 3 раздача: терн + показать карты игроков
* - 4 раздача: ривер + показать карты игроков
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Здравствуйте! Хотите поиграть в покер?");
        String s = sc.nextLine();
        if (Check.answer(s)) {
            System.out.println("Отлично! ");
            System.out.println("Введите количество игроков: ");
            Hand.setNumPlayers(sc.nextInt());
            Hand.setNamePlayers();
            Game.runFullGame();
        }
        else System.out.println("Ну и идите отсюда");
    }
}
