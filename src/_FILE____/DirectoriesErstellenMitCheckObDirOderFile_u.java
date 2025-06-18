package _FILE____;


import java.io.File;

public class DirectoriesErstellenMitCheckObDirOderFile_u {
    //    Tip: use mkdirs()
//    Write a method, which creates multiple directories. Example: "C:\\campus02\\test\\demo4" (Campus, Test, Demo4 will be created)
//            - It should also be checked, if the given directory has been created -> print it to the console:
//            -> IF Yes: Directory C:\campus02\test\demo4 created?: true
//            -> IF No: Directory C:\campus02\test\demo4 created?: false
//
//    Question: What is the difference between mkdirs() and mkdir() ?
//    Question: What does mkdirs() return?
//    Question: What does mkdir() return?
    public static void main(String[] args) {
        File dir = new File("C:\\campus02\\test");
        String directory = new String("C:\\campus02\\test");
        createDirectory(directory);
    }

    public static void createDirectory(String directory) {

        File dir = new File(directory);

        //shortform!!!

        System.out.println("Directory " + dir.getPath() +" : "+dir.mkdirs());
        //longform!!
//        if (dir.mkdirs()) {
//            System.out.println("Directory " + dir.getPath() + ": True");
//        }else{
//            System.out.println("Directory C:\\campus02\\test\\demo4 created?: false");
//        }

    }


}




