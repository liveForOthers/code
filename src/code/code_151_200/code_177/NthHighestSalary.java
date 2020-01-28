package code.code_151_200.code_177;

public class NthHighestSalary {


    /*
    *         SELECT IFNULL(
            (
               SELECT DISTINCT Salary
                FROM Employee
                ORDER BY Salary DESC
                LIMIT P, 1
            ), NULL
        ) AS SecondHighestSalary
    * */
}
