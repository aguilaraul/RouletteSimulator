package edu.miracosta.cs210.roulettesimulator;

public class Number {

    // Game logic data.
    private int number;
    private String color;
    private boolean odd;
    private boolean firstEighteen;
    private int section;
    private int column;

    // Graphics data.
    private int wheelAngle;

    // Empty constructor for returning results of a bet.
    public Number() {}

    // Constructor used for initialising the numbers with their data.
    public Number(int num, String col, int angle) {
        this.number = num;
        this.color = col;
        this.odd = odd(num);
        this.firstEighteen = firstEighteen(num);
        this.section = section(num);
        this.column = column(num);
        this.wheelAngle = angle;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public boolean getOdd() {
        return odd;
    }

    public boolean getfirstEighteen() {
        return firstEighteen;
    }

    public int getSection() {
        return section;
    }

    public int getColumn() {
        return column;
    }

    public int getAngle() {
        return wheelAngle;
    }

    // Constructor method to calculate whether number is odd.
    private boolean odd(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }

    // Constructor method to calculate whther number is in the firstEighteen positions.
    private boolean firstEighteen(int num) {
        for (int i = 1; i < 19; i++) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    // Constructor method to calculate which section numbers is in.
    // 1 = first twelve, 2 = second twelve and 3 = third twelve.
    private int section(int num) {
        for (int i = 1; i < 13; i++) {
            if (i == num) {
                return 1;
            }
        }
        for (int i = 13; i < 25; i++) {
            if (i == num) {
                return 2;
            }
        }
        return 3;
    }

    // Constructor method to calculate which column number is in.
    // 1 = column starting with 1, 2 = column starting with 2 3 = column starting with 3.
    private int column(int num) {
        for (int i = 1; i < 35; i+=3) {
            if (i == num) {
                return 1;
            }
        }
        for (int i = 2; i < 36; i+=3) {
            if (i == num) {
                return 2;
            }
        }
        return 3;
    }

    /******************************* Unit Testing *******************************/

    public static void main(String[] args) {
        Number test = new Number();
        // Test number is correctly assigned as odd/even.
        assert(test.odd(1) == true);
        assert(test.odd(2) == false);
        // Test number is correctly assigned in firstEighteen.
        assert(test.firstEighteen(1) == true);
        assert(test.firstEighteen(18) == true);
        assert(test.firstEighteen(19) == false);
        assert(test.firstEighteen(36) == false);
        // Test number is correctly assigned for section.
        assert(test.section(1) == 1);
        assert(test.section(12) == 1);
        assert(test.section(13) == 2);
        assert(test.section(24) == 2);
        assert(test.section(25) == 3);
        assert(test.section(36) == 3);
        // Test number is correctly assigned for column.
        assert(test.column(1) == 1);
        assert(test.column(2) == 2);
        assert(test.column(3) == 3);
        assert(test.column(16) == 1);
        assert(test.column(17) == 2);
        assert(test.column(18) == 3);
        assert(test.column(34) == 1);
        assert(test.column(35) == 2);
        assert(test.column(36) == 3);
        System.out.println("All tests passed.");
    }
}

