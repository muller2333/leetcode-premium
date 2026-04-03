select
    if(p <= max_side * 2, 'Not A Triangle', rel) triangle_type
from
    (
        select
            if(A < B, if(B < C, C, B), if(A < C, C, A)) max_side,
            A + B + C p,
            if(
                A = B
                and B = C,
                'Equilateral',
                if(
                    A = B
                    or A = C
                    or B = C,
                    'Isosceles',
                    'Scalene'
                )
            ) rel
        from
            Triangles
    ) mid;