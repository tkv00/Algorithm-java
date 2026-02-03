select 
    a.apnt_no as APNT_NO,
    p.pt_name as PT_NAME,
    a.pt_no as PT_NO,
    a.mcdp_cd as MCDP_CD,
    d.dr_name AS DR_NAME,
    a.apnt_ymd AS APNT_YMD
from
    patient as p
    join appointment as a on p.pt_no = a.pt_no
    join doctor as d on d.dr_id = a.mddr_id
where
    date_format(a.apnt_ymd,'%Y-%m-%d')='2022-04-13'
    and
    a.apnt_cncl_yn = 'N'
order by
    APNT_YMD asc;