package S_18_1.s_2_7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Repository()
public class BookDAO implements BookDAOImpl {
//    &amp;useSSL=false&amp;allowPublicKeyRetrieval=true  url包含该段时出错
//    private DriverManagerDataSource dataSource=new DriverManagerDataSource(
//            "jdbc:mysql://localhost:3306/test?serverTimezone=GMT",
//            "root","dingzhixin"
//    );
    @Autowired
    private MyDataSource dataSource;


    @Override
    public void insert(Book book) {

        String name = book.getName();
        double price = book.getPrice();
        int factoryId = book.getFactoryId();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getDataSourc().getConnection();
            statement = connection.createStatement();
            statement.execute("insert  into  book (name,price,factoryid) values ('" +
                    name + "'," + price + "," + factoryId + ")");
            System.out.println("数据保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据保存失败!");
        }

    }


}
