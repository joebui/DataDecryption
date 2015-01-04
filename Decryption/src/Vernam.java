public class Vernam {
    private String msg;
    private String key;
    private char[] alphabet = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z',' ', '.',',',':',';','(',')','-','!','?', '$','\'','\"','n',
            '0','1','2','3','4','5','6','7','8','9'};  // this is the alphabet given by the lecturer

    public Vernam(String k, String m) {
        key = k;
        msg = m;
    }

    public int[] changeMsgToNum() {  /* convert each character in ciphertext to number based on the alphabet */
        char[] charString = msg.toCharArray();
        int[] value = new int[charString.length];

        for (int i = 0; i < charString.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (charString[i] == alphabet[j]) {
                    value[i] = j;
                    break;
                }
            }
        }
        return value;
    }

    public int[] changeKeyToNum() {  /* convert each character in key to number based on the alphabet */
        char[] charString = key.toCharArray();
        int[] value = new int[charString.length];

        for (int i = 0; i < charString.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (charString[i] == alphabet[j]) {
                    value[i] = j;
                    break;
                }
            }
        }
        return value;
    }

    public void decrypt() {
        int[] message = changeMsgToNum();
        int[] key = changeKeyToNum();
        int[] msg_key = new int[message.length];

        for (int i = 0; i < msg_key.length; i++) {
            msg_key[i] = message[i] - key[i];  // message - key
            if (msg_key[i] >= 0) {
                msg_key[i] = msg_key[i] % 50;  // (message - key) mod 50
            } else {
                msg_key[i] = 50 + msg_key[i];  // (message - key) + 50
            }
        }

        System.out.print("---> ");
        for (int i = 0; i < msg_key.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (msg_key[i] == j) {  // convert the number back to the alphabet
                    System.out.print(alphabet[j]);
                    break;
                }
            }
        }
        System.out.println();
    }
}
