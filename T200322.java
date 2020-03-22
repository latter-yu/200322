

class Person{
    private String name;//实例成员变量
    private int age;
    private String sex;
    private static int count;

    public Person() {
        System.out.println("I am Person init()!");
    }
    //实例代码块:优先于构造函数执行
    {
        this.name = "bit";
        this.age = 12;
        this.sex = "man";
        System.out.println("I am instance init()!");
    }
    //静态代码块
    static {
        count = 10;//只能访问静态数据成员
        System.out.println("I am static init()!");
    }
    //静态代码块不管生成多少个对象，其只会执行一次，且是最先执行的。
    //静态代码块执行完毕后, 实例代码块（构造块）执行，再然后是构造函数执行。

    //重写Object的toString方法
    //idea快捷键：alt + insert
    @Override //注解：代表重写（优先调用）
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }
}

public class T200322 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.show();
        //I am static init()!
        //I am instance init()!
        //I am Person init()!
        //name: bit age: 12 sex: man

        System.out.println(p1);//一个地址的哈希值
        // 原因：调用的是Object的toString方法
        //object: 所以类名的父类

        //重写之后结果：Person{name='bit', age=12}
        //打印类型的属性时，可直接重写 toString 方法
        //将对象转成字符串这样的操作我们称为 序列化,反之称为反序列化
    }



    /*private static int x = 100;//static:只有一份
    public static void main1(String args[]) {
        T200322 hsl = new T200322();
        hsl.x++;//只会报警告 ：101
        T200322 hs2 = new T200322();
        hs2.x++;// 102
        hsl = new T200322();
        hsl.x++;//103
        T200322.x--;//102
        System.out.println(" x=" + x);//102
    }*/
}



