select
    concat(Toppings.topping_name, ',', first, ',', second) pizza,
    sum + cost total_cost
from
    Toppings
    join (
        select
            if(
                Toppings.topping_name < t.topping_name,
                Toppings.topping_name,
                t.topping_name
            ) first,
            if(
                Toppings.topping_name > t.topping_name,
                Toppings.topping_name,
                t.topping_name
            ) second,
            Toppings.cost + t.cost sum
        from
            Toppings
            join Toppings t on Toppings.topping_name < t.topping_name
        order by
            Toppings.topping_name,
            t.topping_name
    ) mid on Toppings.topping_name < first
order by
    total_cost desc,
    pizza;