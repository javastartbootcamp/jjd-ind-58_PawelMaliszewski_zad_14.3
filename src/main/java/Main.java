import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        Map<String, Country> countryMap = new HashMap<>();
        try (var fileReader = new BufferedReader(new FileReader("countries.csv"))
        ) {
            String text = "";
            while ((text = fileReader.readLine()) != null) {
                String[] split = text.split(";");
                countryMap.put(split[0], new Country(split[0], split[1], Integer.parseInt(split[2])));
            }
            System.out.println("Podaj kod kraju");
            String code = scanner.nextLine().toUpperCase();
            if (countryMap.get(code) == null) {
                System.out.println("Kod kraju " + code + " nie został znaleziony.");
            } else {
                System.out.println(countryMap.get(code));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku countries.csv.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // usupełnij metodę
    }
}
