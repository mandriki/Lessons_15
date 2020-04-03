package taskFlow;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
     public static void main(String[] args) throws IOException {
         /**Дадан файл с многострочным тестом. Прочитать и вывести этот файл в консоль построчно.*/
         System.out.println("Все слова с файла");
         String a = "";
         try (BufferedReader line = new BufferedReader(new FileReader("C://1//text.txt"))) {
             while ((a = line.readLine()) != null) {
                 System.out.println(a);
             }
         }
         /** Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.*/
         System.out.println("\n Все слова на глассные");
         try (BufferedReader line = new BufferedReader(new FileReader("C://1//text.txt"))) {
             while ((a = line.readLine()) != null) {
                 String[] words = a.split("[\\s,.:!?]+");
                 Pattern pattern = Pattern.compile("^[aeyi]");
                 for (String word : words) {
                     Matcher matcher = pattern.matcher(word.toLowerCase());
                     if (matcher.find()) {
                         System.out.println(word);
                     }
                 }
             }
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
         /**Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква одного
          * слова совпадает с первой буквой следующего слова*/
         System.out.println("\n Последняя буква одного слова совпадает с первой буквой второго");
         try (BufferedReader line = new BufferedReader(new FileReader("C://1//text.txt"))) {
             while ((a = line.readLine()) != null) {
                 String[] words = a.split("[\\s,.:!?]+");
                 for (int i = 0; i < words.length - 1; i++) {
                     if (!words[i].isEmpty() && !words[i + 1].isEmpty()) {
                         if (words[i].charAt(words[i].length() - 1) == words[i + 1].charAt(0)) {
                             System.out.println(words[i] + " " + words[i + 1]);
                         }
                     }
                 }
             }
         }catch(IOException e){
                 e.printStackTrace();
         }
        /** Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.*/
         System.out.println("\n Наибольшее число цифр в стороке, идущих подряд");
         try (BufferedReader line = new BufferedReader(new FileReader("C://1//text.txt"))) {
            while (line.ready()) {
                int length = 0;
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(line.readLine());
                while (matcher.find()) {
                    if (matcher.group().length() > length) {
                        length = matcher.group().length();
                        a = matcher.group();
                    }
                }
                if(a != null) {System.out.println(a);}
            }
         } catch (IOException e) {
             e.printStackTrace();
         }
         /**5. Записать в двоичный файл 20 случайных чисел типа int со значением больше 255.
          *  Прочитать записанный файл, распечатать числа и их среднее арифметическое.*/

         System.out.println("Запись - чтение числа ");
         try (DataOutputStream line = new DataOutputStream(new FileOutputStream("C://1//text.txt"))) {
             for (int i = 0; i < 20; i++) {
                 int d = (int) (250 + (Math.random() *1000));
                 line.write(d);
             }
             line.flush();
         } catch (IOException e) {
             e.printStackTrace();
         }
         try (DataInputStream line = new DataInputStream(new FileInputStream("C://1//text.txt"))) {
                 int sum = 0, i = 0;
                 System.out.println("\nПрочитали числа:");
                 while (line.available() > 0) {
                     int text = line.read();
                     System.out.print(text + " ");
                     sum += text;
                     i++;
                 }
                 System.out.println("\nCреднее значение - " + sum / i);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         /**  6 Вывести список файлов и каталогов выбранного каталога на диске с учетом вложенности директориев.
          *  Для этого использовать рекурсию (пример рекурсии тут и тут).*/

         File file = new File("C:" + File.separator + "1");
         listCatalog(file);

         /** 7. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке
          символы каждой строки.*/


         try (BufferedReader line = new BufferedReader(new FileReader("C:" + File.separator
                  + "1" + File.separator + "text.java"));
              BufferedWriter writer = new BufferedWriter(new FileWriter("C:" + File.separator
                      + "1" + File.separator +  "text1.java"))) {
             while ((a = line.readLine()) != null) {
                 StringBuilder b = new StringBuilder(a);
                 writer.write(String.valueOf(b.reverse()) + "\n");
             }

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void listCatalog(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File s : files) {
                System.out.println(s);
             }
        }
     }
}


/**Занятие 15. Потоки ввода-вывода. Часть 1. Задачи
        1. Задан файл с многострочным тестом. Прочитать и вывести этот файл в консоль построчно.
        2. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.
        3. Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква одного слова совпадает с первой буквой следующего слова
        4. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.
        5. Записать в двоичный файл 20 случайных чисел типа int со значением больше 255. Прочитать записанный файл, распечатать числа и их среднее арифметическое.
        6 Вывести список файлов и каталогов выбранного каталога на диске с учетом вложенности директориев. Для этого использовать рекурсию (пример рекурсии тут и тут).
        7. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке символы каждой строки.

*/