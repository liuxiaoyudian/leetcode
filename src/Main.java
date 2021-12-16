import java.util.*;

public class Main {

    /**
     * input1: string[] {"AA00:10", "AA01:AA00,AB00", "AB00:15"}
     * Output: The Excel sheet can be evaluated.
     * <p>
     * input2: string[] {"AA00:10", "AB00:AA00,AA01", "AA01:20,AB00"}
     * Output: The Excel sheet cannot be evaluated.
     * <p>
     * string[] {"AA00:10", "AB00:AA00,AA01", "AA01:20,AA00"}
     * <p>
     * string[] {"AA00:AB00", "AB00:AA00,AA01", "AA01:20,AA00"}
     * <p>
     * <p>
     * string[] {"AA00:AB00", "AB00:AA01", "AA01:20,AA00"}
     */
    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();

        String input1 = "\"AA00:10\", \"AA01:AA00,AB00\", \"AB00:15\"";
        String input2 = "\"AA00:10\", \"AB00:AA00,AA01\", \"AA01:20,AB00\"";
        String input3 = "\"AA00:10\", \"AB00:AA00,AA01\", \"AA01:20,AA00\"";
        String input4 = "\"AA00:AB00\", \"AB00:AA00,AA01\", \"AA01:20,AA00\"";
        String input5 = "\"AA00:AB00\", \"AB00:AA01\", \"AA01:20,AA00\"";
        String input = input5 + ",";
        String[] array = input.split(" ");

        for (int i = 0; i < array.length; i++) {
//        for (String s : array) {
            String s = array[i];
            s = s.substring(1, s.length() - 2);
            String[] split = s.split(":");
            String key = split[0];
            String value = split[1];
            if (i == array.length - 1) {
                value += input.charAt(input.length() - 1);
            }
            List<String> list = new ArrayList<>();
            for (String values : value.split(",")) {
                if (isCell(values)) {
                    list.add(values);
                }
            }
            if (list.size() != 0) {
                map.put(key, list);
            }
        }

        System.out.println(map);

        boolean flag = true;
        Set<String> keys = map.keySet();
        for (String key : keys) {
            List<String> list = map.get(key);
            for (String s : list) {
                List<String> l = map.get(s);
                if (l != null) {
                    for (String cell : l) {
                        if (cell.equals(key)) {
//                            flag = false;
                            System.out.println("The Excel sheet cannot be evaluated.");
                            return;
                        }
                    }
                }
            }
        }
        if (flag) {
            System.out.println("The Excel sheet can be evaluated.");
        }

    }

    public static boolean isCell(String s) {
        if ('A' <= s.charAt(0) && s.charAt(0) <= 'Z') {
            return true;
        }
        return false;
    }

}
