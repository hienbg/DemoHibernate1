package com.vti.rw41;

import com.vti.rw41.entity.*;
import com.vti.rw41.enumurations.AccountStatus;
import com.vti.rw41.repository.AccountRepository;
import com.vti.rw41.repository.GroupRepository;
import com.vti.rw41.utils.HibernateUtils;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* List<Group> groupList =GroupRepository.getAllGroups("Group3");
        System.out.println(groupList);*/
      //  Group group= GroupRepository.getGroupById(1);
       // GroupRepository.deleteGroup(group);
       // GroupRepository.isGroupExistsById(2);
       // GroupRepository.isGroupExistsByName("Group4");
   // testInsert();
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
       // for( int i= 0; i<=10; i++) {
            BillDetail billDetail = new BillDetail();
            billDetail.setBillId(2);
            billDetail.setProductId(2);
            billDetail.setProductPrice(99.9);
            billDetail.setQuantity(10);
            session.saveOrUpdate(billDetail);
    //Demo git
        session.getTransaction().commit();

    }

    static void testInsert() {
        /*Open a session */
        Session session = HibernateUtils.getSessionFactory().openSession();
        /*Start a transaction*/
        session.beginTransaction();
        /*Insert into MySql*/
        Account account1 = new Account();
        account1.setUserName("Nonwma");
        account1.setEmail("Nomat@wgmail.com");
        account1.setFullName("Nomawn11");
        account1.setCreateDate(LocalDate.now());
        account1.setStatus(AccountStatus.inactive);
        /*Query a statement*/
        session.saveOrUpdate(account1);
        /*Commit a transaction*/
        session.getTransaction().commit();

    }

    static void testSelectAndUpdate() {
        Account account = AccountRepository.findById(2);
        if (account != null) {
            account.setFullName("New Name");
            AccountRepository.saveOrUpdate(account);
        }
    }

    static void testSelectAndDelete() {
        Account account = AccountRepository.findById(2);
        if (account != null) {
            AccountRepository.delete(account);
        }
    }
}
