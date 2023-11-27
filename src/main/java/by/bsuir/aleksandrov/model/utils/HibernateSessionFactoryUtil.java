package by.bsuir.aleksandrov.model.utils;

import by.bsuir.aleksandrov.model.entity.order.Order;
import by.bsuir.aleksandrov.model.entity.order.OrderItem;
import by.bsuir.aleksandrov.model.entity.phone.Phone;
import by.bsuir.aleksandrov.model.entity.phone.color.Color;
import by.bsuir.aleksandrov.model.entity.phone.stock.Stock;
import by.bsuir.aleksandrov.model.entity.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(Color.class);
                configuration.addAnnotatedClass(Stock.class);
            //    configuration.addAnnotatedClass(Order.class);
            //    configuration.addAnnotatedClass(OrderItem.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
