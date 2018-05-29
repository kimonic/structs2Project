package S_17_1;

public class People {
    private int id;
    private String name;
    private String sex;
    private int age;
    private PeopleIdCard peopleIdCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PeopleIdCard getPeopleIdCard() {
        return peopleIdCard;
    }

    public void setPeopleIdCard(PeopleIdCard peopleIdCard) {
        this.peopleIdCard = peopleIdCard;
    }
}
