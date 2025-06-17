package ue_6;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ue_6 {

        public class Main {
            public static void main(String[] args) throws IOException {
                System.out.println("UE6");
                String path = "Users" + File.separator +
                        "kaaatkina" + File.separator +
                        "CAMPUS02_2025" + File.separator +
                        "Programmieren_3" + File.separator +
                        "dir_for_ue_05" + File.separator +
                        "1_eins" + File.separator +
                        "2_zwei" + File.separator +
                        "3_drei" + File.separator +
                        "4_vier" + File.separator +
                        "5_five";

                //1) erstelle 10 files FERTIG
                createFiles(path);

                //2) benenne diese 10 Files um


                //2a) alle 10 files auflisten
                renameFiles(path);
            }

            public static void createFiles(String path) throws IOException {
                for (int i = 0; i < 10; i++) { // 10x ausführen
                    File file= new File(path + File.separator + "file" + i + ".txt");
                    boolean success = file.createNewFile();
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
}