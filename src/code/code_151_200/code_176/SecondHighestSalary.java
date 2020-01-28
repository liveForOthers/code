package code.code_151_200.code_176;

public class SecondHighestSalary {


    /*
    * sql题目  找出员工表中 第二高的薪水(重复的算一个)
    * 1 去重
    * 2 不存在的话返回null需要使用IFNULL 函数
    * select IFNULL((select DISTINCT Salary from Employee order by Salary desc limit 1,1),NULL) as SecondHighestSalary;
    *
    * */
}
