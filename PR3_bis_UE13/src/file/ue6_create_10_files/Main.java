package file.ue6_create_10_files;

import java.io.File;
import java.io.IOException;

import static file.ue1.Main.readFileInformation;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE6");
        String path = "C:" + File.separator +
                "Users" + File.separator + "b50394" + File.separator +
                "IdeaProjects" + File.separator + "PR3_local" + File.separator + "test";

        //1) erstelle 10 files FERTIG
        createFiles(path);

        //2) benenne diese 10 Files um
        //2a) alle 10 files auflisten
        renameFiles(path);
    }

    public static void createFiles(String path) throws IOException {
        for (int i = 0; i < 10; i++) { // 10x ausführen
            File file1 = new File(path + File.separator + "file" + i + ".txt");
            boolean success = file1.createNewFile();
        }
    }

    public static void renameFiles(String path) {
        File folder = new File(path); // path ist der selbe wie oben
        File[] listOfFiles = folder.listFiles();
        for (File oldFile : listOfFiles) {
            if (oldFile.isFile()) {
                String newFileName = "1_" + oldFile.getName();
                System.out.print("-File: " + oldFile.getName() +
                        " -> " + newFileName + ": ");
                File newFile = new File(oldFile.getParent()
                        + File.separator + newFileName);
                if (oldFile.renameTo(newFile)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}

