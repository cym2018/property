# property
spring-Boot,spring-MVC,Hibernate,Mysql8,jackson,vue,axios

## 物业信息管理系统
![](https://github.com/cym2018/property/workflows/Java%20CI/badge.svg)


## jpa Repository 只适合最基本的数据库查询操作?
伪代码例子:
```java
class User{ 
    int id,age;String name;boolean gender;
    // 省略getter和setter函数
}
interface UserRepository extends JpaRepository{
    List findByAgeGreaterThan(int number);
}

class Test{
public static void main(String[] args){
    List list,result;
    // 代码块1:获取数据库中所有性别为'false'的记录
    User user1=new User();
    user1.setGender(false);
    result=UserRepository.findAll((Example).of(user1));
    // 代码块2:获取数据库中所有年龄大于30的记录
    result=UserRepository.findByAgeGreaterThan(30);
    // 但是查找数据库中性别为'false'且年龄大于30的记录,
    // 则需要使用代码块1或代码块2后,手动进行第二步筛选
    // 代码块3
    list=UserRepository.findByAgeGreaterThan(30);
    for (User i:list) {
        if(i.getGender()==false)
            result.add(i);
    }
    // 虽然第三种方法没有复杂太多,但我认为应该存在类似于
    // UserRepository.findByAgeGreaterThan(30).and(UserRepository.findAll((Example).of(user1)));
    // 的方法而非手动实现.
    // 很多人说jpa不适合复杂的多表联合查询,但对以上情况,并没有讨论.
}
}
```

## 代码统计:排除部分文件
```text
## 无配置
JavaScript	81.9%
Java		10.1%
HTML		5.8%
Vue			1.8%
CSS			0.4%
## vue.js -linguist-detectable
Java		52.6%
HTML		30.5%
Vue			9.5%
JavaScript	5.6%
CSS			1.8%
## *.js -linguist-detectable
Java 		55.8%
HTML		32.3%
Vue			10%
CSS			1.9%
vue.js -linguist-detectable
axios.js -linguist-detectable
app.*.js -linguist-detectable
```

## 数据库备份命令
```text
property --result-file="/root/backup/{data_source}-{timestamp}-dump.sql"
```