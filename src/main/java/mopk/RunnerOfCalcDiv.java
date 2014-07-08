/**
 * Created by Mopk
 * on 2014-06-24 10:12.
 */
package mopk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunnerOfCalcDiv {


    @SuppressWarnings("PointlessBooleanExpression")
    static public List<String> runCalcDiv(
            String dividend,
            String divisor
    ) {
        List<String> outputAndErrorLines = new ArrayList<String>();

        try {

            BufferedWriter writerToInputOfExternalApplication = null;
            Scanner readerOfOutputOfExternalApplication = null;
            Scanner readerOfErrorsOfExternalApplication = null;

            try {
                Process process =
                        Runtime.getRuntime().exec("./external/calc_div.exe");

                writerToInputOfExternalApplication =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        process.getOutputStream()
                                )
                        );
                writerToInputOfExternalApplication.write(
                        dividend
                );
                writerToInputOfExternalApplication.newLine();
                writerToInputOfExternalApplication.write(
                        divisor
                );
                //            writerToInputOfExternalApplication.newLine();
                writerToInputOfExternalApplication.flush();
                writerToInputOfExternalApplication.close(); // necessary

                readerOfOutputOfExternalApplication =
                        new Scanner(
                                new InputStreamReader(
                                        process.getInputStream()
                                )
                        );
                readerOfErrorsOfExternalApplication =
                        new Scanner(
                                new InputStreamReader(
                                        process.getErrorStream()
                                )
                        );

                String outputLine;
                while ( readerOfOutputOfExternalApplication.hasNextLine()
                             ==
                            true ) {
                    outputLine = readerOfOutputOfExternalApplication.nextLine();
                    outputAndErrorLines.add(outputLine);
                    System.out.println(outputLine);
                }
//                readerOfOutputOfExternalApplication.close();

                String errorLine;
                while ( readerOfErrorsOfExternalApplication.hasNextLine()
                             ==
                            true ) {
                    errorLine = readerOfErrorsOfExternalApplication.nextLine();
                    outputAndErrorLines.add(errorLine);
                    System.out.println(errorLine);
                }
//                readerOfErrorsOfExternalApplication.close();

                process.waitFor();
                System.out.println("Done.");

            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                if (writerToInputOfExternalApplication != null) {
                    writerToInputOfExternalApplication.close();
                }
                if (readerOfOutputOfExternalApplication != null) {
                    readerOfOutputOfExternalApplication.close();
                }
                if (readerOfErrorsOfExternalApplication != null) {
                    readerOfErrorsOfExternalApplication.close();
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return outputAndErrorLines;
    }


    static public void main(String[] args) {
        runCalcDiv("2", "3");
    }

}