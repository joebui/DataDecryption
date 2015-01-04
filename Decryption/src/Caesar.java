
public class Caesar {
    private final String msg;  // message
    private char[] alphabet = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
        'Q','R','S','T','U','V','W','X','Y','Z',' ', '.',',',':',';','(',')','-','!','?', '$','\'','\"','n',
        '0','1','2','3','4','5','6','7','8','9'}; // the alphabet given by the lecturer

    public Caesar(String m) {
        msg = m;
    }

    public void decryptWithoutKey() {  /* without key */
        char[] charString = msg.toCharArray();
        char[] newString;

        System.out.println("\nThese are the possible results: ");
        for (int i = 1; i < alphabet.length; i++) {  // search through all possible plaintexts
            newString = new char[charString.length];

            System.out.println("+ Key = " + i + ": ");
            for (int j = 0; j < charString.length; j++) {  // search through each character in the message
                for (int k = 0; k < alphabet.length; k++) {  // search through the alphabet
                    if (charString[j] == alphabet[k]) {
                        if (k - i < 0) {  // the index is < 0
                            newString[j] = alphabet[49 + (k - i) + 1]; // back to '9' and continue shifting to the left
                        } else {
                            newString[j] = alphabet[k - i];  // shift the letter by i to the left
                        }

                        if (newString[j] == 'n') {  // covert to \n if the char is n
                            newString[j] = '\n';
                        }
                        System.out.print(newString[j]);
                        break;
                    }
                }
            }
            System.out.println("\n");
        }
    }

    public void decryptWithKey(byte key) {  /* with key */
        char[] charString = msg.toCharArray();
        char[] newString;

        newString = new char[charString.length];
        System.out.println("\nThis is the result: ");
        System.out.print("+ ");
        for (int j = 0; j < charString.length; j++) {  // search through each character in the message
            for (int k = 0; k < alphabet.length; k++) {  // search through the alphabet
                if (charString[j] == alphabet[k]) {
                    if (k - key < 0) {  // the index is < 0
                        newString[j] = alphabet[49 + (k - key) + 1];  // go back to '9' and continue shifting to the left
                    } else {
                        newString[j] = alphabet[k - key];  // shift the letter by 'the value of key' to the left
                    }

                    if (newString[j] == 'n') {  // covert to \n if the char is n
                        newString[j] = '\n';
                    }
                    System.out.print(newString[j]);
                    break;
                }
            }
        }
        System.out.println();
    }
}
