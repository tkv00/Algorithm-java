select
    child.id,
    child.genotype,
    parent.genotype as parent_genotype
from
    ecoli_data as child
    inner join
    ecoli_data as parent
    on parent.id=child.parent_id
where
    parent.genotype & child.genotype = parent.genotype
order by
    child.id asc;