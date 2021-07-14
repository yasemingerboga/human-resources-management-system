package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SkillForCV;


public interface SkillForCVDao extends JpaRepository <SkillForCV, Integer> {

}
