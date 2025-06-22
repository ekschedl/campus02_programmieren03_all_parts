package _FILE____IO;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class _00___basics2____ {

    // TEXTDATEIEN LESEN & SCHREIBEN (1–10)

    public static void _01_lese_Textdatei_Zeilenweise() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _02_schreibe_textdatei_buffered_writer() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hallo Welt\nNoch eine Zeile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _03_kopiere_textdatei() {
        try (BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("target.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _04_lese_datei_utf8() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("utf8.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _05_lese_datei_mit_scanner() {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void _06_lade_datei_in_array_list() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);
    }

    public static void _07_kehre_dateiinhalt_um() {
        try {
            List<String> lines = Files.readAllLines(Path.of("text.txt"));
            Collections.reverse(lines);
            Files.write(Path.of("reversed.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _08_lese_csv_datei() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println(Arrays.toString(parts));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _09_schreibe_csv_datei() {
        try (PrintWriter writer = new PrintWriter("output.csv")) {
            writer.println("Name,Alter");
            writer.println("Max,25");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void _10_schreibe_textdatei_mit_format() {
        try (PrintWriter writer = new PrintWriter("formatted.txt")) {
            writer.printf("Name: %s, Alter: %d\n", "Max", 25);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void _11_gib_dateigroesse_aus() {
        File file = new File("example.txt");
        System.out.println("Dateigroesse: " + file.length() + " Bytes");
    }

    public static void _12_liste_verzeichnisse() {
        File dir = new File(".");
        for (File file : dir.listFiles()) {
            System.out.println(file.getName());
        }

    }

    public static void _13_filtere_nur_txt_dateien() {
        File dir = new File(".");
        File[] txtFiles = dir.listFiles((d, name) -> name.endsWith(".txt"));
        for (File f : txtFiles) {
            System.out.println(f.getName());
        }
    }

    public static void _14_erstelle_temporaere_datei() {
        try {
            File temp = File.createTempFile("tempfile", ".tmp");
            System.out.println("Temp-Datei: " + temp.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _15_loesche_datei() {
        File file = new File("delete.txt");
        if (file.delete()) {
            System.out.println("Datei geloescht");
        }
    }

    // BINÄRDATEIEN & STREAMS (16–30)

    public static void _16_fuege_dateien_zusammen() {
        try {
            List<String> allLines = new ArrayList<>();
            for (String fname : List.of("a.txt", "b.txt")) {
                allLines.addAll(Files.readAllLines(Path.of(fname)));
            }
            Files.write(Path.of("merged.txt"), allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _17_zaehle_zeichen_in_datei() {
        try {
            long count = Files.lines(Path.of("text.txt")).mapToLong(String::length).sum();
            System.out.println("Zeichen: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _18_zaehle_woerter_in_datei() {
        try {
            long count = Files.lines(Path.of("text.txt"))
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .count();
            System.out.println("Wörter: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _19_teile_grosse_datei_auf() {
        try {
            List<String> lines = Files.readAllLines(Path.of("big.txt"));
            int splitSize = 100;
            int part = 1;
            for (int i = 0; i < lines.size(); i += splitSize) {
                List<String> partLines = lines.subList(i, Math.min(i + splitSize, lines.size()));
                Files.write(Path.of("part" + part++ + ".txt"), partLines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _20_try_with_resources_schreiben() {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("trywrite.txt"))) {
            writer.write("Automatisch geschlossen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _21_kopiere_binaerdatei() {
        try (InputStream in = new FileInputStream("a.dat");
             OutputStream out = new FileOutputStream("b.dat")) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _22_lese_datei_byteweise() {
        try (InputStream in = new FileInputStream("data.bin")) {
            int b;
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _23_lese_binaer_datei_buffered() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("binary.dat"))) {
            byte[] buffer = new byte[512];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _24_schreibe_datei_buffered_stream() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.bin"))) {
            bos.write("Hallo Welt".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _25_datei_existenz_pruefen() {
        File file = new File("test.txt");
        System.out.println("Existiert: " + file.exists());
    }

    public static void _26_file_input_stream_mit_buffer() {
        try (FileInputStream fis = new FileInputStream("input.bin");
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _27_file_output_stream_mit_buffer() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.bin"))) {
            bos.write("Buffered Ausgabe".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _28_file_reader_input_stream_reader_buffered() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _29_file_writer_buffered_writer_print_writer() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {
            writer.println("Testausgabe mit mehreren Schichten");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _30_zeichencodierung_verwenden() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _31_serialisiere_ein_objekt() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(new Person("Max", 30));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _32_deserialisiere_ein_objekt() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person p = (Person) in.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void _33_serialisiere_produktliste() {
        List<Product> products = List.of(new Product("Apfel", 1.2), new Product("Banane", 0.9));
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("products.ser"))) {
            out.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _34_map_aus_key_value_datei() {
        Map<String, String> map = new HashMap<>();
        try {
            for (String line : Files.readAllLines(Path.of("keyvalues.txt"))) {
                String[] parts = line.split(":");
                if (parts.length == 2) map.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

    public static void _35_lade_properties_datei() {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
            System.out.println(props.getProperty("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _36_definiere_serializable_klasse_person() {
        Person p = new Person("Anna", 22);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _37_schreibe_object_stream_mit_try() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject("Beispieltext");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _38_lese_object_stream_mit_fehlerbehandlung() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"))) {
            Object obj = in.readObject();
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void _39_serialisiere_mit_pfad_und_ordner_check() {
        Path path = Path.of("backup/data.ser");
        try {
            Files.createDirectories(path.getParent());
            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
                out.writeObject("Daten gesichert");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Person p = new Person("Max", 30);
        System.out.println(p);

        Product prod = new Product("Apfel", 1.99);
        System.out.println(prod);
    }

    static class Person implements Serializable {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + ", " + age;
        }
    }

    static class Product implements Serializable {
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String toString() {
            return name + " kostet " + price;
        }
    }
}
