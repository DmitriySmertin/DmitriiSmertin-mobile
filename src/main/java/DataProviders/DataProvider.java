package DataProviders;

public class DataProvider {


    @org.testng.annotations.DataProvider
    public Object[][] webData() {
        return new Object[][]{
                {"https://www.google.ru/", "Epam"}
        };
    }
}
