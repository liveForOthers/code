package code.code_151_200.code_183;

public class CustomersWhoNeverOrder {


    /*
    * select c.Name as Customers from Customers c where c.Id not in(select distinct CustomerId from Orders)
    *
    * 效率太差
    *
    * select Name as Customers from Customers where Id not in (select CustomerId from Orders)
    *
    * 效率好很多  表别名消耗大？
    * 表别名消耗主要在编译时消耗比较大，尽可能不使用表别名
    * */
}
