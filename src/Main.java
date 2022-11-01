import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> basket = new ArrayList<>();

        while (true) {
            System.out.println("Введите номер операции или end: ");
            System.out.println("\t 1. Добавить.");
            System.out.println("\t 2. Показать.");
            System.out.println("\t 3. Удалить.");
            System.out.println("\t 4. Найти.");
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            int number = Integer.parseInt(input);
            switch (number) {
                case 1:
                    System.out.println("Какой товар хотите добавить в корзину?");
                    String addPurchase = sc.nextLine();
                    basket.add(addPurchase);
                    System.out.println("Итого в списке покупок: " + basket.size());
                    break;
                case 2:
                    printBasket(basket);
                    break;
                case 3:
                    printBasket(basket);
                    System.out.println("Какой товар хотите удалить?");
                    String deletePurchase = sc.nextLine();
                    try {
                        int del = Integer.parseInt(deletePurchase);
                        System.out.println("Покупка \"" + basket.get(del - 1) + "\" удалена");
                        basket.remove(del - 1);
                    } catch (NumberFormatException e) {
                        System.out.println("Покупка \"" + deletePurchase + "\" удалена.");
                        basket.remove(deletePurchase);
                    }
                    printBasket(basket);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска: ");
                    String search = sc.nextLine();
                    String searchLower = search.toLowerCase();
                    for (int i = 0; i < basket.size(); i++) {
                        String item = basket.get(i);
                        String itemLower = item.toLowerCase();
                        if (itemLower.contains(searchLower)) {
                            System.out.println((i + 1) + ". " + item);
                        } else {
                            System.out.println("Нет продуктов, подходящих под ваш запрос.");
                        }
                    }
                    break;
                default:
                    System.out.println("введите корректный номер операции");
            }
        }
    }

    public static void printBasket(ArrayList<String> basket) {
        for (int i = 0; i < basket.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + basket.get(i));
        }
    }
}