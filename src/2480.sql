select
      metal,
      nonmetal
from
      (
            select
                  symbol metal
            from
                  Elements
            where
                  type = 'Metal'
      ) mid,
      (
            select
                  symbol nonmetal
            from
                  Elements
            where
                  type = 'Nonmetal'
      ) mid2;