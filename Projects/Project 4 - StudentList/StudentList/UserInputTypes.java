public enum UserInputTypes {
    LFM("LFM"),FML("FML"),FL("FL"),ERROR("ERROR");
    private String format;

    UserInputTypes(String format) {
        this.format= format;
    }

    public String get() {
        return format;
    }
}
