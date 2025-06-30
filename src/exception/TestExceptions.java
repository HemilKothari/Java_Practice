package exception;

public class TestExceptions {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("123");
            System.out.println(num);
            num /= 0;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number.");
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by 0.");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("Always executed.");
        }
    }
}
