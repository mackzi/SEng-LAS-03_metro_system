public enum Configuration {
    instance;

    public String fileSeparator = System.getProperty("file.separator");

    public String dataPath = "data" + fileSeparator;
}
