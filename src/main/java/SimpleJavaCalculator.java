/**
 * hello.
 */
public class SimpleJavaCalculator {

    /**
     * main.
     * @param args
     */
    public static void main(final String[] args) {
        try {
            UI uiCal = new UI();
            uiCal.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
