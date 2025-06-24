public class First50AlternatePrime {
    public static void main(String[] args) {
        int num = 2;
        int count = 0;
        // level 1 loop
        while (count < 100) {
            int i = 2;
            // level 2 loop
            while (i < num) {
                if (num % i == 0)
                    break;

                i++;
            }
            if (i == num) {
                count++;
                if (count % 2 != 0)
                    System.out.println(num + " is prime, Count: " + count/2);
            }

            num++;
        }
    }
}
