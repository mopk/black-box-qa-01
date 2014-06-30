/**
 * Created by Mopk
 * on 2014-06-24 10:12.
 */
package mopk;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RunnerOfCalcDiv {

    @SuppressWarnings("PointlessBooleanExpression")
    public static void main(String[] args) {
        try {
            Process process =
                    Runtime.getRuntime().exec("./external/calc_div.exe");

            BufferedWriter writerToInputOfExternalApplication =
                    new BufferedWriter(
                            new OutputStreamWriter(process.getOutputStream())
                    );
            writerToInputOfExternalApplication.write(
                    "2"
            );
            writerToInputOfExternalApplication.newLine();
            writerToInputOfExternalApplication.write(
                    "3"
            );
//            writerToInputOfExternalApplication.newLine();
            writerToInputOfExternalApplication.flush();
            writerToInputOfExternalApplication.close();

            Scanner readerOfOutputOfExternalApplication =
                    new Scanner(
                            new InputStreamReader(process.getInputStream())
                    );
            Scanner readerOfErrorsOfExternalApplication =
                    new Scanner(
                            new InputStreamReader(process.getErrorStream())
                    );

            String outputLine;
            while (readerOfOutputOfExternalApplication.hasNextLine() == true) {
                outputLine = readerOfOutputOfExternalApplication.nextLine();
                System.out.println(outputLine);
            }
            readerOfOutputOfExternalApplication.close();

            String errorLine;
            while (readerOfErrorsOfExternalApplication.hasNextLine() == true) {
                errorLine = readerOfErrorsOfExternalApplication.nextLine();
                System.out.println(errorLine);
            }
            readerOfErrorsOfExternalApplication.close();

            process.waitFor();
            System.out.println("Done.");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}