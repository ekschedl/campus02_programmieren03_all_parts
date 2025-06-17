package _FILE____;

import java.io.File;
import java.io.IOException;

//Goal: Create 10 Files + Rename all files (only files) of the given directory (not for subdirectories)
//
//        1. Write a method, which creates 10 files, in a given directory (= Method Parameter) and with a random file name/number (Tip: concatenate for final filepath)
//2. Write a method, which renames all files (only files and not directories!) within a given folder (= Method Parameter)
//        2.1 for example: test.txt to 1_test.txt
//2.1.1 for the new file name - concatenate a string with .getParent(), separator + pre_id + getName()
//2.1.2 use renameTo() method
//2.1.3 Check if the rename was a success (via if) and print the according message to the console
//3. Write a method, which deletes all files within this directory. (Comment out this or other methods to test it..)
//
//Tip: Random Number:
//        ThreadLocalRandom.current().nextInt()
//
//
public class _06___create_dirs_and_files_FixName_rename {
            public static void main(String[] args) throws IOException {
                System.out.println("UE6");
                String path = File.separator + "Users" + File.separator +
                        "kaaatkina" + File.separator +
                        "CAMPUS02_2025" + File.separator +
                        "Programmieren_3" + File.separator +
                        "dir_for_ue_05" + File.separator +
                        "1_eins" + File.separator +
                        "2_zwei" + File.separator +
                        "3_drei" + File.separator +
                        "4_vier" + File.separator +
                        "5_five";


                //0) // Ordner anlegen, wenn nicht vorhanden
                File ordner = new File(path);
                if (!ordner.exists()) {
                    boolean erstellt = ordner.mkdirs();
                    System.out.println("Ordner erstellt? " + erstellt);
                }
                //1) erstelle 10 files FERTIG
                createFiles(path);

                // 2) benenne diese 10 Files um
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
