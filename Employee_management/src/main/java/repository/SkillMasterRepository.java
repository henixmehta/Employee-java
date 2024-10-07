package repository;

import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SkillMasterRepository implements SkillMasterRepositoryLocal {

     @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;

    @Override
    public Collection<SkillsMaster> getAllSkill() {
        return em.createNamedQuery("SkillsMaster.findAll").getResultList();
    }

    @Override
    public void addSkill(SkillsMaster skill) {
        em.persist(skill); // Persist the new skill
    }
}
