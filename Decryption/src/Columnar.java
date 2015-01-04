import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Columnar {
    private final String msg;  // message
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();  // map to store factors
    private char[][] table;  // 2D array to decrypt

    public Columnar(String msg) {
        this.msg = msg;
    }

    public void decryptWithoutKey() {  /* no key */
        System.out.println("\nThese are the possible results: ");
        int length = msg.length();
        char[] charString = msg.toCharArray();  // convert string to array of chars
        getFactors(length);

        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {  // iterate through the Map
            Map.Entry entry = (Map.Entry) entries.next();
            Integer colLength = (Integer)entry.getKey();  // num of rows
            Integer key = (Integer)entry.getValue();  // num of columns
            table = new char[colLength][key];

            int stringKey = 0;
            for (int i = 0; i < key; i++) {  // put the characters in the table
                for (int y = 0; y < colLength; y++) {
                    if (charString[stringKey] == 'n') {
                        table[y][i] = '\n';  // replace "n" with "new line"
                    } else {
                        table[y][i] = charString[stringKey];
                    }
                    stringKey++;
                }
            }

            System.out.println("+ Key = " + key + ": ");  // show the key before each plaintext
            for (int i = 0; i < table.length; i++) {  // get the plain text row by row
                for (int x = 0; x < table[0].length; x++) {
                    System.out.print(table[i][x]);
                }
            }
            System.out.println("\n");
        }
    }

    public void decryptWithKey(int key) {  /* with key */
        System.out.println("\nThis is the result: ");
        int length = msg.length();
        int colLength = length / key;  // num of rows
        char[] charString = msg.toCharArray();  // convert string to array of chars
        table = new char[colLength][key];

        int stringKey = 0;
        for (int i = 0; i < key; i++) {  // put the chars in the table
            for (int y = 0; y < colLength; y++) {
                if (charString[stringKey] == 'n') {
                    table[y][i] = '\n';  // replace "n" with "new line"
                } else {
                    table[y][i] = charString[stringKey];
                }
                stringKey++;
            }
        }

        System.out.print("+ ");
        for (int i = 0; i < table.length; i++) {  // get the plaintext row by row
            for (int x = 0; x < table[0].length; x++) {
                System.out.print(table[i][x]);
            }
        }
        System.out.println();
    }

    public void getFactors(int length) {  /* get the factors based on the length of the cipher text */
        for (int i = 2; i < length; i++) {
            if (length % i == 0) {
                int colLength = length / i;
                map.put(i, colLength);
            }
        }
    }
}
