select
  employee_id,
  name,
  mid2.salary,
  team_id
from
  (
    select
      mid.salary,
      @rownum := @rownum + 1 team_id
    from
      (
        select
          salary
        from
          Employees
        group by
          salary
        having
          count(name) >= 2
        order by
          salary
      ) mid,
      (
        select
          @rownum := 0
      ) rownum
  ) mid2
  left join Employees on Employees.salary = mid2.salary
order by
  team_id,
  employee_id;