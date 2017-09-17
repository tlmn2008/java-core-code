package kenny.algorithm.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeTest {

    public static void main(String[] args){
        try {

            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("javac -version");
            int exitVal = process.waitFor();

            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error  = new BufferedReader(new InputStreamReader(process.getErrorStream()));


            System.out.println("Process exitValue: " + exitVal);
            System.out.println("Process output: " + getMessage(output));
            System.out.println("Process error : " + getMessage(error));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static String getMessage(BufferedReader buffer) {
        try {
            String message = "";
            String temp;
            while ((temp = buffer.readLine()) != null) {
                message += temp + "\n";
            }
            return message.trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
