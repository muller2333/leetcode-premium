select
      mid2.platform,
      mid2.experiment_name,
      ifnull(cnt, 0) num_experiments
from
      (
            select
                  count(experiment_id) cnt,
                  platform,
                  experiment_name
            from
                  Experiments
            group by
                  platform,
                  experiment_name
      ) mid
      right join (
            select
                  'IOS' platform,
                  'Programming' experiment_name
            union
            select
                  'IOS' platform,
                  'Sports' experiment_name
            union
            select
                  'IOS' platform,
                  'Reading' experiment_name
            union
            select
                  'Android' platform,
                  'Programming' experiment_name
            union
            select
                  'Android' platform,
                  'Sports' experiment_name
            union
            select
                  'Android' platform,
                  'Reading' experiment_name
            union
            select
                  'Web' platform,
                  'Programming' experiment_name
            union
            select
                  'Web' platform,
                  'Sports' experiment_name
            union
            select
                  'Web' platform,
                  'Reading' experiment_name
      ) mid2 on mid.platform = mid2.platform
      and mid.experiment_name = mid2.experiment_name;