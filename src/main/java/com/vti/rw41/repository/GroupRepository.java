package com.vti.rw41.repository;

import com.vti.rw41.entity.Group;
import com.vti.rw41.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public class GroupRepository {
    public static void createGroups() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Group group = new Group();
        group.setGroupName("Group3");
        group.setCreateDate(LocalDate.now());
        session.saveOrUpdate(group);
        session.getTransaction().commit();

    }

    public static List<Group> getAllGroups(String groupName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Group> query = session.createQuery("FROM Group WHERE group_name= :name", Group.class);
        query.setParameter("name", groupName);
        return query.getResultList();
    }

    public static Group getGroupById(Integer Id) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        return session.find(Group.class, Id);
    }

    public static Group getGroupByName(String groupName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Group> query = session.createQuery("FROM Group WHERE group_name= :name", Group.class);
        query.setParameter("name", groupName);
        try{
            return query.getSingleResult();
        }catch (NoResultException exception){
            return null;
        }

    }

    public static Group saveOrUpdateGroup(Group group) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(group);
        session.getTransaction().commit();
        return group;
    }

    public static Group deleteGroup(Group group) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(group);
        session.getTransaction().commit();

        return group;
    }

    public static Boolean isGroupExistsById(Integer id) {
        Group group = getGroupById(id);
        if (group != null) {
            System.out.println("Group has Id = " + id + " is Exists");
            return true;
        } else {
            System.out.println("Group has Id = " + id + " is not Exists");
            return false;
        }
    }

    public static Boolean isGroupExistsByName(String name) {
        Group group = getGroupByName(name);
        if (group != null) {
            System.out.println("Group has groupName = " + name + " is Exists");
            return true;
        } else {
            System.out.println("Group has groupName = " + name + " is not Exists");
            return false;
        }
    }
}
