package io.github.novacrypto.bip39.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author DiomChen
 * className WordListFile2StringArray
 * description util for transfer word file 2 string array
 * date 2022/04/07/ 16:15:00
 */
public class WordListFile2StringArray {
    /**
     * parse
     *
     * @param path file path
     * @return {@code List<String>} word list
     */
    public static List<String> parse(String path) {
        List<String> wordList = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                wordList.add(str);
            }

            inputStream.close();
            bufferedReader.close();
        }
        catch (IOException e){
            System.out.println(e);
        }

        return wordList;
    }

    /**
     * list 2 array list
     *
     * @param arr data
     * @return {@code String[]}
     */
    public static String [] toStringArray(List<String> arr){
        return arr.toArray(new String[arr.size()]);
    }

    /**
     * export word list 2 file
     *
     * @param data     word list data
     * @param filePath file path
     * @throws IOException ioexception
     */
    public static void export(List<String> data,String filePath) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        out.write(data.toString());
        out.close();
    }

}
