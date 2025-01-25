select
    distinct N,
    if(P is null, 'Root', if(child is null, 'Leaf', 'Inner')) Type
from
    (
        select
            Tree.N,
            Tree.P,
            t.N child
        from
            Tree
            left join Tree t on Tree.N = t.P
    ) mid
order by
    N;