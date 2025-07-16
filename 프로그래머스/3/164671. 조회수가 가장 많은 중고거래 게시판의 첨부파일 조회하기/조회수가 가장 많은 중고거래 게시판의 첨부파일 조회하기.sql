select
    concat('/home/grep/src/',b.board_id,'/',f.file_id,f.file_name,f.file_ext)
    as file_path
from
    USED_GOODS_BOARD as b
    inner join
    USED_GOODS_FILE as f
    on
    b.board_id = f.board_id
where
    b.views in (
        select
            max(views)
        from
            USED_GOODS_BOARD
    )
order by
    f.file_id desc;
    
