select min(shortest) shortest
from (select round(sqrt((Point2D.x - p.x) * (Point2D.x - p.x) + (Point2D.y - p.y) * (Point2D.y - p.y)), 2) shortest
      from Point2D,
           Point2D p) mid
where shortest > 0;