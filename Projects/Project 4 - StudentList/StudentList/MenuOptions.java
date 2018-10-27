public enum MenuOptions {
    BYPASS(0), NEWSTUDENT(1), DELETESTUDENT(2), STUDENTLIST(3);

    private int numVal;

    MenuOptions(int numVal) {
        this.numVal = numVal;
    }

    public int get() {
        return numVal;
    }
}