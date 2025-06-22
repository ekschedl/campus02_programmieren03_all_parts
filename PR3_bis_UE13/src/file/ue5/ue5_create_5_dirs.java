package file.ue5;

import java.io.File;

public class ue5_create_5_dirs {
    public static void main(String[] args) {
        System.out.println("UE5 - Create 3 directories");
        //String path="C:\\Users\\b50394\\OneDrive - F" +
        //"H CAMPUS 02\\Documents\\Lehre\\Program" +
        //        "mieren3_SS2025\\Tag 1 - 01a FileIO";
        String path = "C:\\Users\\b50394\\OneDrive - FH CAMPUS 02\\Documents\\Lehre\\Programmieren3_SS2025\\Tag 1 - 01a FileIO";
        File theDir = new File(path + "\\UNTERVERZ");
        if(! theDir.exists())
        {
            theDir.mkdirs();
        }
        System.out.println("Wurde das Verz erstellt: ");

       // new File("src").delete();
       // new File("eins_b").delete();
       // new File("eins_c").delete();
    }
}
