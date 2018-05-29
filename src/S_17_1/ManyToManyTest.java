package S_17_1;

import S_16_1.Hibernateutil;
import org.hibernate.Session;

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
        different();
    }


    /**子类映射到父类并区分子类类型*/
    private static void different(){
        Session session=null;
        try {
            session=Hibernateutil.getSession();
            session.beginTransaction();
            Student student=new Student();
            student.setSchool("w3c");
            student.setAge(18);
            student.setId(1);
            student.setName("小明1");
            Staffer staffer=new Staffer();
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

        }catch (Exception e){
            e.printStackTrace();
            if (session!=null){
                session.getTransaction().rollback();
            }
            System.out.println("数据保存失败!");
        }finally {
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

    /**一对一删除,级联操作,同时会删除people表和peopleIDcard表中的数据*/
    private static void delete(){
        Session session=null;
        try {
        session=Hibernateutil.getSession();
        session.beginTransaction();
        People people=session.get(People.class,2);
        session.delete(people);
        session.getTransaction().commit();
            System.out.println("数据删除成功!");

        }catch (Exception e){
            e.printStackTrace();
            if (session!=null){
                session.getTransaction().rollback();
            }
            System.out.println("数据删除失败!");
        }finally {
            Hibernateutil.closeSession();
        }
    }
}
