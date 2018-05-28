package S_16_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("Duplicates")
public class Hibernateutil {
    private static final ThreadLocal<Session> THREAD_LOCAL=new ThreadLocal<>();
    private static SessionFactory sessionFactory=null;
    static {
        try {
            //注意导包--import org.hibernate.cfg.Configuration;
            Configuration cfg=new Configuration().configure();
            sessionFactory=cfg.buildSessionFactory();

        }catch (Exception e){
            System.err.println("创建会话工厂失败!");
            e.printStackTrace();

        }
    }

    public static Session getSession(){
        Session session=THREAD_LOCAL.get();
        if (session==null||!session.isOpen()){
            if (sessionFactory==null){
                rebuildSessionFactory();
            }
            session=(sessionFactory!=null)?sessionFactory.openSession():null;
            THREAD_LOCAL.set(session);
        }
        return session;
    }

    private static void rebuildSessionFactory() {
        try {
            //注意导包--import org.hibernate.cfg.Configuration;
            Configuration cfg=new Configuration().configure();
            sessionFactory=cfg.buildSessionFactory();

        }catch (Exception e){
            System.err.println("创建会话工厂失败!");
            e.printStackTrace();

        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void closeSession(){
        Session session=THREAD_LOCAL.get();
        THREAD_LOCAL.set(null);
        if (session!=null){
            session.close();
        }
    }


}
