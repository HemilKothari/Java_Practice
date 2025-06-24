public class First50Prime {
    public static void main(String[] args) {
        int num = 2;
        int count = 0;
        // level 1 loop
        while (count < 50) {
            int i = 2;
            // level 2 loop
            while (i < num) {
                if (num % i == 0)
                    break;

                i++;
            }
            if (i == num) {
                System.out.println(num + " is prime, Count: " + ++count);
            }

            num++;
        }
    }
}
