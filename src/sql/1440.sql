select
    left_operand,
    operator,
    right_operand,
    if(operator = res, 'true', 'false') value
from
    (
        select
            left_operand,
            mid3.operator,
            right_operand,
            if(
                mid2.value < mid3.value,
                '<',
                if(mid2.value = mid3.value, '=', '>')
            ) res
        from
            (
                select
                    mid.left_operand,
                    operator,
                    value,
                    r
                from
                    Variables
                    right join (
                        select
                            left_operand,
                            operator,
                            ROW_NUMBER() over (
                                order by
                                    operator
                            ) r
                        from
                            Expressions
                    ) mid on left_operand = name
            ) mid2
            inner join (
                select
                    mid.right_operand,
                    operator,
                    value,
                    r
                from
                    Variables
                    right join (
                        select
                            right_operand,
                            operator,
                            ROW_NUMBER() over (
                                order by
                                    operator
                            ) r
                        from
                            Expressions
                    ) mid on right_operand = name
            ) mid3 on mid2.r = mid3.r
    ) mid4;