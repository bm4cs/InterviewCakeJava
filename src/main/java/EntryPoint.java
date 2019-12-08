import java.time.Month;

public class EntryPoint {
    public static void main(String[] args) {
        System.out.print("hello java 11\n");

        var month = java.time.LocalDate.now().getMonth();

        if (month == Month.DECEMBER) {
            System.out.println("merry xmas you little beauty");
        }
    }
}
