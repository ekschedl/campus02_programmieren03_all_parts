package P_R_O_B_E_pruefung_PR3_von_2023;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_BinaerFile_minimal {

        public static void main(String[] args) {

            try {
                FileOutputStream fos = new FileOutputStream(new File("hallo.txt"));

                byte forInsert = 0x2B; // 0x2B = 43 in Dezimal

                for (int i = 0; i < 20; i++) {
                    fos.write(forInsert);
                }

                fos.close();
                System.out.println("Fertig: 20-mal 0x2B geschrieben.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }