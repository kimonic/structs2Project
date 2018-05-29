package S_17_1;

import S_16_1.Hibernateutil;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class BookTest {
    public static void main(String[] args) {
//        save();
//        checkManyToOne();
        checkOneToMany();
    }


    /**
     * 多对一关系中保存数据
     * 必须先保存一所对应的对象,并且除主键外,所有的属性必须赋值
     * 没有值的使用set(null)
     * 然后保存多的对象
     *如果数据表未创建,则hibernate会自动创建数据表
     */
    private static void save() {
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            Factory factory = new Factory();
            factory.setName("土豆金服2");
            Book book = new Book();
            book.setFactory(factory);
            book.setName("亦筝笙2");
            book.setPrice(118.55D);
            session.beginTransaction();
            session.save(factory);
            session.save(book);
            session.getTransaction().commit();
            System.out.println("数据保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("数据保存失败!");
        } finally {
            Hibernateutil.closeSession();
        }
    }

    /**多对一关系查询*/
    private static void checkManyToOne(){
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            Book book=session.get(Book.class,5);
            System.out.println("book的名称是:"+book.getName());
            System.out.println("book的价格是:"+book.getPrice());
            System.out.println("book的id是:"+book.getId());
            System.out.println("book的生产厂家是:"+book.getFactory().getName());
            session.getTransaction().commit();
            System.out.println("数据显示成功!");
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("数据显示失败!");
        } finally {
            Hibernateutil.closeSession();
        }
    }
    /**一对多关系查询*/
    private static void checkOneToMany(){
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            Factory factory=session.get(Factory.class,3);
            System.out.println("factory的名称是:"+factory.getName());
            Set<Book>  books=factory.getBooks();
            System.out.println("set集合的长度是:"+books.size());
            for (Book book : books) {
                System.out.println("book的价格是:" + book.getPrice());
                System.out.println("book的id是:" + book.getId());
                System.out.println("book的名称是:" + book.getName());
            }

            session.getTransaction().commit();
            System.out.println("数据显示成功!");
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("数据显示失败!");
        } finally {
            Hibernateutil.closeSession();
        }
    }
}
