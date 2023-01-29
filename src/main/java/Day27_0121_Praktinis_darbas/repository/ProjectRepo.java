package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Project;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilityPW.getSessionFactory;

public class ProjectRepo extends BaseRepo <Project> {
    @Override
    public List<Project> findAll() {
        session = getSessionFactory().openSession();
        return session.createQuery("FROM Project", Project.class).list();
    }

    @Override
    public void saveList(List<Project> givenList) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(project -> session.save(project));
        transaction.commit();
        session.close();
    }
}
