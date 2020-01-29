package code.code_151_200.code_180;

public class ConsecutiveNumbers {

    /*
    *
    * select distinct first.Num as ConsecutiveNums from
Logs as first, Logs as second, Logs as third
where
first.Id+1 = second.Id and
second.Id+1 = third.Id and
first.Num = second.Num and
first.Num = third.Num
    *
    * 通过了 但是效率低 370ms
    *
    * SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
    *
    * 两个sql效率差很多
    * 实际测试  +1 效率比-1 效率低  不懂原因
    * */
}
