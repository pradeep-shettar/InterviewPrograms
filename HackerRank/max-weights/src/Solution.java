import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'weightCapacity' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY weights
     *  2. INTEGER maxCapacity
     */

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        return 0;
    }


}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int weightsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> weights = IntStream.range(0, weightsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int maxCapacity = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.weightCapacity(weights, maxCapacity);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
