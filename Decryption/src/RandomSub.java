public class RandomSub {
    private String msg;  // message
    private char[] charString;
    private char[] alphabet = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z',' ', '.',',',':',';','(',')','-','!','?', '$','\'','\"','n',
            '0','1','2','3','4','5','6','7','8','9'};  // this is the alphabet given by the lecturer

    public RandomSub(String m) {
        msg = m;
        charString = msg.toCharArray();
    }

    public void changeChar(char prev, char aft) {  /* replace a character with another character */
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < charString.length; i++) {
            if (charString[i] == prev) {  // the character is match with the one to be replaced
                charString[i] = aft;  // replace the previous letter with the new one
                b.append(charString[i]);
            } else {
                b.append(charString[i]);
            }
        }

        msg = b.toString();
        System.out.println("+ " + msg);
    }

    public void countFrequency() {  /* count the frequency of each character */
        for (int i = 0; i < alphabet.length; i++) {
            byte counter = 0;

            /* search through each character in the string
             * and compare with each character in the alphabet
             */
            for (char a : charString) {
                if (a == alphabet[i]) {
                    counter++;  // increase by 1 if the letter's found
                }
            }

            System.out.println(alphabet[i] + ": " + counter + " times");
        }
    }
}
