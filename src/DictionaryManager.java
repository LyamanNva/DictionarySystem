import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryManager {
    private Map<String, Dictionary> dictionaries;
    private Scanner scanner;

    public DictionaryManager() {
        dictionaries = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void adminLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("password")) {
            adminMenu();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("1. Create Dictionary");
            System.out.println("2. Add Word");
            System.out.println("3. Remove Word");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createDictionary();
                    break;
                case 2:
                    addWord();
                    break;
                case 3:
                    removeWord();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createDictionary() {
        System.out.print("Enter dictionary name: ");
        String name = scanner.nextLine();
        dictionaries.put(name, new Dictionary(name));
        System.out.println("Dictionary created.");
    }

    private void addWord() {
        System.out.print("Enter dictionary name: ");
        String name = scanner.nextLine();
        Dictionary dict = dictionaries.get(name);
        if (dict != null) {
            System.out.print("Enter word: ");
            String word = scanner.nextLine();
            System.out.print("Enter translation: ");
            String translation = scanner.nextLine();
            dict.addWord(word, translation);
            System.out.println("Word added.");
        } else {
            System.out.println("Dictionary not found.");
        }
    }

    private void removeWord() {
        System.out.print("Enter dictionary name: ");
        String name = scanner.nextLine();
        Dictionary dict = dictionaries.get(name);
        if (dict != null) {
            System.out.print("Enter word: ");
            String word = scanner.nextLine();
            dict.removeWord(word);
            System.out.println("Word removed.");
        } else {
            System.out.println("Dictionary not found.");
        }
    }

    private void userLogin() {
        System.out.println("Available dictionaries:");
        for (String dictName : dictionaries.keySet()) {
            System.out.println("- " + dictName);
        }

        System.out.print("Enter dictionary name to use: ");
        String name = scanner.nextLine();
        Dictionary dict = dictionaries.get(name);
        if (dict != null) {
            userMenu(dict);
        } else {
            System.out.println("Dictionary not found.");
        }
    }

    private void userMenu(Dictionary dict) {
        while (true) {
            System.out.println("1. Search Word");
            System.out.println("2. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchWord(dict);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void searchWord(Dictionary dict) {
        System.out.print("Enter word to search: ");
        String word = scanner.nextLine();
        String translation = dict.translate(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("Word not found.");
        }
    }
}

