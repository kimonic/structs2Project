package S_17_1;

import S_16_1.Hibernateutil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class ManyToManyTest {

    public static void main(String[] args) {
//        delete();
//        save();
//        test();
//        different();
        hqlTest();
//        unify();
    }

    /**
     * hql语句查询
     */
    private static void hqlTest() {
        List<People> list = new ArrayList<>();
        try {

            Session session = Hibernateutil.getSession();
//            String hql="from People p";
            //条件查询
//            String hql="from People p where p.sex='女'";
//            String hql="from People p where p.sex=?";
            //占位符的另一种方式
//            String hql="from People p where p.sex=:sex";
            //排序查询
//            String hql="from People p order by p.id desc ";
            //聚合函数查询--平均值
//            String hql="select avg (p.age) from People p  ";
            //聚合函数查询--最小值
//            String hql = "select min (p.age) from People p  ";
            //分组查询--输出内容需要强转成数组
//            String hql = "select p.sex,count (*)from People p group by p.sex";
            //子查询
            String hql = "from People p where p.age=(select max (age) from People )";
            Query q = session.createQuery(hql);
            //此时返回的是一个数值list,长度为1
//            System.out.println("平均年龄是:" + q.list().get(0));
//            System.out.println("最小年龄是:" + q.list().get(0));
            //为占位符赋值
//            q.setParameter(0,"男");
//            q.setParameter("sex","女");
            list = q.list();
//            for (Object o : list) {
//                Object[] oo = (Object[]) o;
//                System.out.println("******是:" + oo[0]);
//                System.out.println("******是:" + oo[1]);
//
//            }
            for (People p:list){
                System.out.println("姓名是:"+p.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Hibernateutil.closeSession();
        }
    }

    /**
     * hql联合查询
     */
    private static void unify() {
        List<Object[]> list = new ArrayList<>();
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            //此处断行时注意添加空格,否则会出错
            String hql = "select p.id,p.sex,p.name,p.age,c.idCard from People p left join p.peopleIdCard c";
            Query query = session.createQuery(hql);
            list = query.list();
            session.getTransaction().commit();
            //生成一个包含所有列值行的数组,每一列对应的类型即为数据库中保存的类型,列值对应顺序与查询时的顺序相一致
            for (Object[] objects : list) {
                StringBuilder builder = new StringBuilder();
                for (Object object : objects) {
                    builder.append("----").append(object.toString()).append("----");
                    System.out.println("--------------------------" + (object instanceof String));
                }
                System.out.println(builder.toString());


            }

        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            Hibernateutil.closeSession();
        }

    }

    /**
     * 子类映射到父类并区分子类类型
     */
    private static void different() {
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            Student student = new Student();
            student.setSchool("w3c");
            student.setAge(18);
            student.setId(1);
            student.setName("小明1");
            Staffer staffer = new Staffer();
            staffer.setName("kimonik1");
            staffer.setCompany("土豆金服1");
            staffer.setAge(28);
            //当主键分配策略为assigned时,同时保存不同子类对象时需要设置不同的id
            //否则会报异常
            staffer.setId(2);
            session.save(student);
            session.save(staffer);
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

    /**
     * 多对多直接创建保存有问题,关联查询没问题
     */
    private static void save() {
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            List<User> users = new ArrayList<>();
            List<Role> roles = new ArrayList<>();
            Set<User> setUser = new HashSet<>();
            Set<Role> setRole = new HashSet<>();
            for (int i = 1; i < 6; i++) {
                User user = new User();
                user.setName("土豆金服" + i);
                users.add(user);
                setUser.add(user);
            }
            for (int i = 1; i < 6; i++) {
                Role role = new Role();
                role.setName("操作系统" + i);
                roles.add(role);
                setRole.add(role);
            }
            roles.get(0).setUsers(setUser);
            users.get(0).setRoles(setRole);
            session.beginTransaction();
            session.save(roles.get(0));
            session.save(users.get(0));
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

    private static void test() {
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            User user = session.get(User.class, 3);
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                System.out.println("权限名称是:" + role.getName());
            }
            Role role = session.get(Role.class, 3);
            Set<User> users = role.getUsers();
            for (User user1 : users) {
                System.out.println("用户的名称是:" + user1.getName());
            }

            session.getTransaction().commit();

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

    /**
     * 一对一删除,级联操作,同时会删除people表和peopleIDcard表中的数据
     */
    private static void delete() {
        Session session = null;
        try {
            session = Hibernateutil.getSession();
            session.beginTransaction();
            People people = session.get(People.class, 2);
            session.delete(people);
            session.getTransaction().commit();
            System.out.println("数据删除成功!");

        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("数据删除失败!");
        } finally {
            Hibernateutil.closeSession();
        }
    }
}
