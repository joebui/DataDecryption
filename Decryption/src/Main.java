import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte choice = -1;

        while (choice != 0) {
            menu();
            System.out.print("Your choice: ");
            choice = s.nextByte();

            if (choice == 1) {  // columnar
                s.nextLine();
                System.out.print("Enter string to decrypt (use \'n\' as NEW LINE): ");
                String word = s.nextLine();
                System.out.print("Enter key (0 for unknown): ");
                int key = s.nextInt();
                Columnar d = new Columnar(word);
                if (key == 0) {  // key is unknown
                    d.decryptWithoutKey();
                } else  {
                    d.decryptWithKey(key);
                }
            } else if (choice == 2) {  // Caesar
                s.nextLine();
                System.out.print("Enter string to decrypt (use 'n' as NEW LINE): ");
                String word = s.nextLine();
                System.out.print("Enter key (0 for unknown): ");
                byte key = s.nextByte();
                Caesar caesar = new Caesar(word);
                if (key == 0) {  // key i unknown
                    caesar.decryptWithoutKey();
                } else {
                    caesar.decryptWithKey(key);
                }
            } else if (choice == 0) {  // exit the program
                System.out.println("Exit program");
                break;
            } else if (choice == 3) {  // random substitution
                s.nextLine();
                System.out.print("Choose \'1\' for counting letter frequency or \'2\' for decrypting: ");
                byte c = s.nextByte();
                s.nextLine();
                System.out.print("Enter string to decrypt (use 'n' as NEW LINE): ");
                String m = s.nextLine();
                RandomSub rs = new RandomSub(m);

                if (c == 1) {  // counting letter's frequency
                    System.out.print("Enter letter: ");
                    String l = s.nextLine();
                    rs.countFrequency();
                } else {  // decrypting
                    boolean cont = true;

                    while (cont) {
                        System.out.print("Enter char to be replaced: ");
                        String prev = s.nextLine();
                        System.out.print("Enter new char (use lowercase letter or any other characters to avoid error " +
                                "during decryption: ");
                        String aft = s.nextLine();
                        rs.changeChar(prev.charAt(0), aft.charAt(0));

                        System.out.print("Continue? (y/n): ");
                        String x = s.next();
                        if (x.equalsIgnoreCase("y")) {
                            cont = true;
                        } else {
                            cont = false;
                        }
                        s.nextLine();
                    }
                }
            } else if (choice == 4) {  // Vernam
                s.nextLine();
                System.out.print("Enter string to decrypt (use 'n' as NEW LINE): ");
                String msg = s.nextLine();
                System.out.print("Enter key (use \'n\' as new line): ");
                String key = s.nextLine();
                for (int i = 0; i <= key.length() - msg.length(); i++) {  // try all ranges of the key
                    String k = key.substring(i, msg.length() + i);
                    System.out.println("Key: " + k);
                    Vernam v = new Vernam(k, msg);
                    v.decrypt();
                    System.out.println();
                }
            } else if (choice == 5) {  // calculate string's length
                s.nextLine();
                System.out.print("Enter string to decrypt (use 'n' as NEW LINE): ");
                String msg = s.nextLine();

                System.out.println("Length (including (space)): " + msg.length());
            }
            System.out.println();
        }
    }

    public static void menu() {
        System.out.println("--- Decryption algorithms ---");
        System.out.println("1. Columnar Transposition");
        System.out.println("2. Caesar Cipher");
        System.out.println("3. Random Substitution");
        System.out.println("4. Vernam Cipher");
        System.out.println("5. String's length");
        System.out.println("0. Exit");
    }
}
