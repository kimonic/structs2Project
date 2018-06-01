package S_18_1.s_2_7;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MyDataSource {
    private DriverManagerDataSource dataSourc;

    public MyDataSource(DriverManagerDataSource dataSourc) {
        this.dataSourc = dataSourc;
    }

    public DriverManagerDataSource getDataSourc() {
        return dataSourc;
    }

    public void setDataSourc(DriverManagerDataSource dataSourc) {
        this.dataSourc = dataSourc;
    }
}
