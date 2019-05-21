package testgroup.parts.dao;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.parts.model.Computer;
import org.hibernate.query.Query;
import java.util.List;

@Repository
public class ComputerDAOImpl implements ComputerDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List <Computer> allComputers(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Computer").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List <Computer> allallComputers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Computer").list();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List <Computer> findComputers(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Computer where name = :name");
        query.setParameter("name", name);
        return query.list();

    }
    @Override
    @SuppressWarnings("unchecked")
    public List <Computer> trueComputers(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Computer where needed=true").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List <Computer> falseComputers(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Computer where needed=false").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Computer computer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(computer);
    }

    @Override
    public void delete(Computer computer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(computer);
    }

    @Override
    public void edit(Computer computer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(computer);
    }

    @Override
    public Computer getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Computer.class, id);
    }
    @Override
    public Computer getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Computer.class, name);
    }

    @Override
    public int computersCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select min(countt) from Computer where needed=true", Number.class).getSingleResult().intValue();
    }

    @Override
    public int partsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Computer ", Number.class).getSingleResult().intValue();
    }

    @Override
    public int partsCount1() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Computer where needed =true ", Number.class).getSingleResult().intValue();
    }

    @Override
    public int partsCount2() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Computer where needed =false ", Number.class).getSingleResult().intValue();
    }

    @Override
    public boolean checkName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Computer where name = :name");
        query.setParameter("name", name);
        return query.list().isEmpty();
    }




}