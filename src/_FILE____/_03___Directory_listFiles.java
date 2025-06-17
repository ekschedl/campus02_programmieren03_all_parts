package _FILE____;

import java.io.File;

public class _03___Directory_listFiles {

    public static void main(String[] args) {
        /*
        Write a program, which lists all files of a subdirectory  */

        File dir = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3");
        listOfFiles(dir.getAbsolutePath());
    }

    public static void listOfFiles(String path) {

        File root = new File(path);
        File[] list = root.listFiles();


        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }
}



// Aufgabe
/*Write a program, which lists all files / directories of the given directory (without sub directories)
And make a different output for Files and Directories, for example:

Dir:C:\$Recycle.Bin

File:C:\3DEXP_Mkt_SW_6.29.743.exe

Dir:C:\Android

Dir:C:\BrAutomation

Dir:C:\Dokumente und Einstellungen

File:C:\DumpStack.log.tmp

Dir:C:\EAGLE-7.2.0

Dir:C:\EPLAN

File:C:\hiberfil.sys

Dir:C:\Intel

Dir:C:\Keil_v5

Dir:C:\marketplace_latest

Dir:C:\Microsoft

File:C:\mplabxdrvrinstall.20211006

Dir:C:\nxp

Dir:C:\OneDriveTemp

File:C:\pagefile.sys

Dir:C:\PerfLogs

Dir:C:\Program Files

Dir:C:\Program Files (x86)

Dir:C:\ProgramData

Dir:C:\Programme

Dir:C:\Recovery

Dir:C:\SMSTSLog

Dir:C:\SOLIDWORKS Data

Dir:C:\SQLite

Dir:C:\ST

File:C:\swapfile.sys

Dir:C:\System Volume Information

Dir:C:\temp

Dir:C:\Users

Dir:C:\WinAVR-20100110

Dir:C:\Windows

Dir:C:\xampp*/
