import java.util.Scanner;
import static sun.util.locale.LocaleUtils.isEmpty;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0, size = 0, counter = 0, searchCounter = 0;
        String nameSearch, contactForRemoval;

        System.out.println("Перед началом работы программы определите максимально допустимое для хранения количество контактов");
        size = scanner.nextInt();
        scanner.nextLine();
        String[] names = new String [size];
        String[] phoneNumbers = new String [size];
        String[] searchResults = new String [size];

        while(true) {
            System.out.println("Система Учёта Контактов");
            System.out.println("1. Добавление нового контакта");
            System.out.println("2. Просмотр всех контактов");
            System.out.println("3. Поиск контакта по имени");
            System.out.println("4. Удаление контакта");
            System.out.println("5. Выход из программы");

            option = scanner.nextInt();
            scanner.nextLine();
            switch(option) {
                case 1:
                    if (counter < names.length) {
                        System.out.println("Введите имя нового контакта:");
                        System.out.print("Имя: ");
                        while ((names[counter] = scanner.nextLine().trim()).isEmpty()) {
                            System.out.println("Строка пуста. Введите имя нового контакта:");
                        }
                        System.out.println("Введите номер телефона нового контакта:");
                        System.out.print("Телефон: ");
                        phoneNumbers[counter] = scanner.nextLine();
                        counter += 1;
                    }
                    else {
                        System.out.println("Нет места для новых контактов. Вы можете удалить существующие контакты для добавления новых.");
                    }
                    System.out.println("---");
                    break;
                case 2:
                    if (counter == 0){
                        System.out.println("Список контактов пуст.");
                        System.out.println("---");
                        break;
                    }
                    System.out.println("Список контактов");
                    System.out.println("Имя - Номер телефона");
                    for (int i = 0; i < counter; i++){
                        System.out.println((i+1) + ". " + names[i] + " - " + phoneNumbers[i]);
                    }
                    System.out.println("---");
                    break;
                case 3:

                    if (counter == 0){
                        System.out.println("Список контактов пуст.");
                        System.out.println("---");
                        break;
                    }
                    System.out.print("Имя для поиска: ");
                    nameSearch = scanner.nextLine();
                    for (int i = 0; i < names.length; i++){
                        if (nameSearch.equals(names[i])){
                            searchCounter += 1;
                            searchResults[searchCounter - 1] = phoneNumbers[i];
                        }
                    }
                    if (searchCounter == 0){
                        System.out.println("Контакт с именем " + nameSearch + " не найден.");
                    }
                    else if (searchCounter == 1){
                        System.out.println("Телефон " + nameSearch + ": " + searchResults[0]);
                    }
                    else {
                        System.out.println("Номера телефонов контактов с именем " + nameSearch + ":");
                        for (int i = 0; i < searchCounter; i++) {
                            System.out.println(searchResults[i]);
                        }
                    }
                    searchCounter = 0;
                    System.out.println("---");
                    break;
                case 4:
                    if (counter == 0){
                        System.out.println("Список контактов пуст.");
                        System.out.println("---");
                        break;
                    }
                    System.out.print("Имя для удаления: ");
                    contactForRemoval = scanner.nextLine();
                    for (int i = 0; i < names.length; i++){
                        if (contactForRemoval.equals(names[i])){
                            searchCounter += 1;
                            if (i < names.length - 1) {
                                for (int j = i; j < names.length - 1; j++) {
                                    names[j] = names[j + 1];
                                    phoneNumbers[j] = phoneNumbers[j + 1];
                                }
                            }
                            names[names.length - 1] = null;
                            phoneNumbers[names.length - 1] = null;
                            counter -= 1;
                            System.out.println("Контакт с именем " + contactForRemoval + " удалён.");
                        }
                    }
                    if (searchCounter == 0){
                        System.out.println("Контакт с именем " + contactForRemoval + " не найден.");
                    }
                    searchCounter = 0;
                    System.out.println("---");
                    break;
                case 5:
                    System.out.println("Работа программы завершена");
                    System.out.println("---");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого пункта нет в Меню");
                    break;
            }
        }
    }
}
