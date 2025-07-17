select
    a.apnt_no,
    p.pt_name,
    p.pt_no,
    a.mcdp_cd,
    d.dr_name,
    a.apnt_ymd
from
    patient as p
    inner join
    appointment as a
    on p.pt_no = a.pt_no
    inner join
    doctor as d
    on d.dr_id = a.mddr_id
where
    date_format(a.apnt_ymd,'%Y-%m-%d') = '2022-04-13'
    and
    d.mcdp_cd like 'CS'
    and
    a.apnt_cncl_yn = 'N'
order by
    a.apnt_ymd asc;