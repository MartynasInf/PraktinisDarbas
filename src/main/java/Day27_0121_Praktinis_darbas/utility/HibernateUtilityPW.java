package Day27_0121_Praktinis_darbas.utility;

import Day26_0114.TeamWork.entity.Book;
import Day26_0114.TeamWork.entity.Student;
import Day26_0114.TeamWork.entity.Teacher;
import Day27_0121_Praktinis_darbas.entity.Address;
import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Employee;
import Day27_0121_Praktinis_darbas.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtilityPW {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/praktinis_darbas?serverTimezone=UTC");
//                properties.put(Environment.DRIVER, "org.h2.Driver");
//                properties.put(Environment.URL, "jdbc:h2:file:C:/temp/test;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
//                properties.put(Environment.USER, "sa");
//                properties.put(Environment.PASS, "");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                properties.put(Environment.SHOW_SQL, "true");
//                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(properties);

                //We need to specify classes we will map to database tables here
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Project.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Employee.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}