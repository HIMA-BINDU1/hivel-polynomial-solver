import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);

        String json = sb.toString();

        
        int n = extractInt(json, "\"n\"");
        int k = extractInt(json, "\"k\"");

        
        Map<Integer, String[]> roots = new HashMap<>();

        
        for (int i = 1; i <= n; i++) {

            String key = "\"" + i + "\"";

            int pos = json.indexOf(key);
            if (pos == -1) continue;

            int start = json.indexOf("{", pos);
            int end = json.indexOf("}", start);

            if (start == -1 || end == -1) continue;

            String section = json.substring(start, end + 1);

            String base = extractString(section, "\"base\"");
            String value = extractString(section, "\"value\"");

            roots.put(i, new String[]{base, value});
        }

        // Only first k points
        int[] x = new int[k];
        BigInteger[] y = new BigInteger[k];

        for (int i = 1; i <= k; i++) {

            String[] arr = roots.get(i);

            int base = Integer.parseInt(arr[0]);
            String val = arr[1];

            x[i - 1] = i;
            y[i - 1] = new BigInteger(val, base);
        }

        
        BigInteger C = lagrangeAtZero(x, y, k);

        System.out.println(C.toString());
    }

    
    private static int extractInt(String text, String key) {

        int idx = text.indexOf(key);
        if (idx == -1) return 0;

        idx = text.indexOf(":", idx) + 1;

        
        while (idx < text.length() && !Character.isDigit(text.charAt(idx)))
            idx++;

        int end = idx;
        while (end < text.length() && Character.isDigit(text.charAt(end)))
            end++;

        return Integer.parseInt(text.substring(idx, end));
    }

 
    private static String extractString(String text, String key) {

        int idx = text.indexOf(key);
        if (idx == -1) return "";

        idx = text.indexOf(":", idx) + 1;

        idx = text.indexOf("\"", idx) + 1;
        int end = text.indexOf("\"", idx);

        return text.substring(idx, end);
    }


    
    private static BigInteger lagrangeAtZero(int[] x, BigInteger[] y, int k) {

        BigInteger total = BigInteger.ZERO;

        for (int i = 0; i < k; i++) {

            BigInteger num = BigInteger.ONE;
            BigInteger den = BigInteger.ONE;

            for (int j = 0; j < k; j++) {
                if (i == j) continue;

                num = num.multiply(BigInteger.valueOf(-x[j]));
                den = den.multiply(BigInteger.valueOf(x[i] - x[j]));
            }

            BigInteger term = y[i].multiply(num).divide(den);
            total = total.add(term);
        }

        return total;
    }
}
