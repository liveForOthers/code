package code.code_151_200.code_181;

public class EmployeesEarningMoreThanTheirManagers {

    /*
    * 1 内连接比 左连接要快很多
    * 2 过滤条件放在where 中 比放在on中要快很多
    *
    * select e.Name as Employee from Employee m join Employee e on e.ManagerId = m.Id where e.Salary>m.Salary
    * */
}
