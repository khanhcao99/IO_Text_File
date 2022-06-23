package Read_File_Example;

import java.io.*;

public class ReadFileExample {
    public static void main(String[] args) {
        File file = new File("readfile.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter.write("1\n");
            bufferedWriter.write("2\n");
            bufferedWriter.write("3\n");
            bufferedWriter.write("22\n");
            bufferedWriter.write("5\n");
            bufferedWriter.write("4\n");
            bufferedWriter.write("33\n");
            bufferedWriter.write("7\n");
        } catch (IOException e) {
            System.err.println("Không tạo được file");
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            if (!file.exists()){
                file.createNewFile();
            }

            String index = "";
            int sum = 0;
            int max = 0;
            while ((index = bufferedReader.readLine()) != null ){
                System.out.println(index);
                if (Integer.parseInt(index) > max){
                    max = Integer.parseInt(index);
                }
                sum += Integer.parseInt(index);
            }
            System.out.println("Tổng các số trong file là= " + sum);
            System.out.println("Số lớn nhất trong file là= " + max);

        }catch (IOException e1){
            System.out.println("File bị lỗi");
        }
    }
}
