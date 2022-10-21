public class Point {
    int value = 0;

    public void increase() {
        this.value += 1;
    }

    public int getValue() {
        return value;
    }
    public String getLiteral() {
        switch (value) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";

        }
        return "";
    }
}
