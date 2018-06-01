package S_18_1.s_2_8;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
@Service
public class MyTransactionTemplate {
    private TransactionTemplate transactionTemplate;
    private DataSourceTransactionManager dataSourceTransactionManager;
//    Could not autowire. No beans of 'DataSourceTransactionManager' type found. less... (Ctrl+F1)
//    Checks autowiring problems in a bean class.
    public MyTransactionTemplate(DataSourceTransactionManager dataSourceTransactionManager) {
        this(null, dataSourceTransactionManager);
    }


    //    Could not autowire. No beans of 'DataSourceTransactionManager' type found. less... (Ctrl+F1)
//    Checks autowiring problems in a bean class.
    public MyTransactionTemplate(TransactionTemplate transactionTemplate,
                                 DataSourceTransactionManager dataSourceTransactionManager) {
        this.transactionTemplate = transactionTemplate;
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public DataSourceTransactionManager getDataSourceTransactionManager() {
        return dataSourceTransactionManager;
    }

    public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }
}
