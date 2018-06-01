package S_18_1.s_2_8;

import S_18_1.s_2_7.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import java.sql.Connection;
import java.sql.Statement;

@Service
public class TransactionExample {
    @Autowired
    private MyDataSource dataSource;
    @Autowired
    private MyTransactionTemplate myTransactionTemplate;



    public void transcationOperation(){
        //必须设置
        myTransactionTemplate.getTransactionTemplate().setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //必须设置
        myTransactionTemplate.getDataSourceTransactionManager().setDataSource(dataSource.getDataSourc());
        myTransactionTemplate.getDataSourceTransactionManager().setRollbackOnCommitFailure(true);
        myTransactionTemplate.getTransactionTemplate().execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    Connection connection=dataSource.getDataSourc().getConnection();
                    Statement statement=connection.createStatement();
                    statement.execute("insert  into  book (name,price,factoryid) values ('spring多次11',20.99,3)");
                    myTransactionTemplate.getDataSourceTransactionManager().rollback(transactionStatus);
                    int a=9/0;
                    statement.execute("insert  into  book (name,price,factoryid) values ('spring多次10',20.88,3)");
                    System.out.println("数据保存成功!");

                } catch (Exception e) {
                    e.printStackTrace();
//                    myTransactionTemplate.getDataSourceTransactionManager().rollback(transactionStatus);
                    System.out.println("数据保存失败!");
                }
                return null;
            }
        });
    }
}
