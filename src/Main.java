import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // readFileInformation("/Users/kaaatkina/CAMPUS02_2025/FUCHS/Programmieren3/test.txt");
        listFilesAndDirectoriesWithSubFolders("/Users/kaaatkina/CAMPUS02_2025/Projekt_1");



    }

    public static void readFileInformation(String fileString) {
        File f = new File(fileString);

        // Does this file exist?
        System.out.println("Does the file exist? \t" + f.exists());

        // Name of the File
        System.out.println("Name of the file? \t\t" + f.getName());

        // Parent Directory of the File
        System.out.println("Parent Directory \t\t" + f.getParent());

        // Absolute Path to this File
        System.out.println("Absolute Path \t\t\t" + f.getAbsolutePath());

        // Is this a directory
        System.out.println("Is this a directory? \t" + f.isDirectory());

        //Is this a file
        System.out.println("Is this a file? \t\t" + f.isFile());

        //Is this file readable
        System.out.println("Is this file readable? \t" + f.canRead());

        //Is this file writeable
        System.out.println("Is this file writeable? " + f.canWrite());

        // File Size
        System.out.println("File Size: \t\t\t\t" + f.length() + " bytes");

    }

    public static void listFilesAndDirectoriesWithSubFolders(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                // rekursiver Aufruf
                System.out.println("Directory: " + f.getAbsolutePath());
                listFilesAndDirectoriesWithSubFolders(f.getAbsolutePath());
            } else {
                System.out.println("File: " + f.getAbsolutePath());
            }
        }

    }}



//System.lineSeparator();