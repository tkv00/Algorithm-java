select
    a.id,
    b.fish_name,
    a.length
from
    fish_info as a
    inner join
    fish_name_info as b
on
    a.fish_type = b.fish_type
where
    a.length = (
        select max(length)
        from fish_info as ft
        where ft.fish_type = a.fish_type
    );