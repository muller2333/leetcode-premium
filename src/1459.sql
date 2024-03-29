select
      *
from
      (
            select
                  Points.id p1,
                  p.id p2,
                  abs(Points.x_value - p.x_value) * abs(Points.y_value - p.y_value) area
            from
                  Points
                  inner join Points p on Points.id < p.id
      ) mid
where
      area > 0
order by
      area desc,
      p1,
      p2;