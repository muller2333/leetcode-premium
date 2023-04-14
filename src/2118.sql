select concat(group_concat(concat(if(factor < 0, '-', '+'), abs(factor),
                                  if(power = 0, '', if(power = 1, 'X', concat('X^', power)))) order by power desc
                           SEPARATOR ''), '=0') equation
from Terms;