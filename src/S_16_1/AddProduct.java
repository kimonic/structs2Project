package S_16_1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * hibernate  hql增删改查
 * https://www.cnblogs.com/miller-zou/p/5710826.html
 */
@SuppressWarnings("Duplicates")
public class AddProduct {


    public static void main(String[] args) {

        query();
//        delete();
//        update();
    }



    public static void save(){
        Session session = null;
        Product product = new Product();
        product.setFactory("明日科技");
        product.setId(13);
        product.setName("土豆金服");
        product.setRemark("hehee");
        product.setPrice(100.99D);
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session!=null){
                session.getTransaction().rollback();
            }
            System.out.println("数据添加失败!");
            e.printStackTrace();

        } finally {
            Hibernateutil.closeSession();
        }
    }

    /**
     * 数据库查询操作
     */
    public static void query(){
        try {
            Session session=Hibernateutil.getSession();
//            Product product=session.get(Product.class,new Integer(13));
//            System.out.println("产品的id是:"+product.getFactory());
//            Product product1=session.get(Product.class,new Integer(13));
////            Product product=session.load(Product.class,new Integer(13));
//            System.out.println("产品的id是:"+product.getFactory());


            String hql = "from Product ";
            Query<Product> query = session.createQuery(hql, Product.class);
            List<Product> list = query.getResultList();
            for(Product o : list){
                System.out.println(o.getFactory() + "::" + o.getName());
            }

        }catch (Exception e){
            System.out.println("对象装在失败!");
            e.printStackTrace();
        }finally {
            Hibernateutil.closeSession();
        }

    }



    public static void delete(){
        try {
            Session session=Hibernateutil.getSession();
//            Product product=session.get(Product.class,new Integer(13));
//            Product product=session.load(Product.class,new Integer(13));
//            session.delete(product);
//            session.flush();

            //in 后面的括号可加可不加
            String hql = "delete from Product where id = 1";
            Transaction tx = session.beginTransaction();
//            List<Integer> list = new ArrayList<Integer>();
//            list.add(1);
//            list.add(2);
            Query<?> query = session.createQuery(hql);
            int i = query.executeUpdate();
            System.out.println(i);
            tx.commit();
            session.close();
            System.out.println("对象删除成功!");

        }catch (Exception e){
            System.out.println("对象删除失败!");
            e.printStackTrace();
        }finally {
            Hibernateutil.closeSession();
        }
    }
    public static void update(){
        try {
            Session session=Hibernateutil.getSession();
//            Product product=session.get(Product.class,new Integer(13));
//            Product product=session.load(Product.class,new Integer(13));
//            product.setName("亦筝笙");
//            product.setId(15);
//            session.update(product);
//            session.flush();

            String hql = "update Product set name = ? where id = ?";
            Transaction tx = session.beginTransaction();
            Query<?> query = session.createQuery(hql).setParameter(0, "亦筝笙").setParameter(1, 12);
            int i = query.executeUpdate();
            System.out.println(i);
            tx.commit();

            System.out.println("对象更新成功!");

        }catch (Exception e){
            System.out.println("对象更新失败!");
            e.printStackTrace();
        }finally {
            Hibernateutil.closeSession();
        }
    }


}
