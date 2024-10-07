package repository;

import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface SkillMasterRepositoryLocal {
    Collection<SkillsMaster> getAllSkill();
    void addSkill(SkillsMaster skill);
}
