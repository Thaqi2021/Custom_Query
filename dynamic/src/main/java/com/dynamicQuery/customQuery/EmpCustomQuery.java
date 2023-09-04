package com.dynamicQuery.customQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dynamicQuery.dto.EmpShortInfo;
import com.dynamicQuery.model.Employee;

@Component
public class EmpCustomQuery {
	
	 @PersistenceContext
	 private EntityManager entityManager;
	//	 both Similar to methods 
	 
	 /* criteriaQuery.multiselect() 
	  * root.get(""),//which must be as dto constructor order
	  * 
	  * 
	  * */
	 
//	public List<EmpShortInfo> findEntitiesDynamically(Employee emp) {
//	   
//	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//	        CriteriaQuery<EmpShortInfo> query = cb.createQuery(EmpShortInfo.class);
//	        Root<Employee> root = query.from(Employee.class);
//
//	        String name = emp.getName();
//	        String exp = emp.getExpense();
//	        
//	        // Define the fields you want to project into the DTO
//	        Selection<EmpShortInfo> selection = cb.construct(
//	        	EmpShortInfo.class,
//	            root.get("id"),
//        		root.get("name"),
//              root.get("desig"),
//              root.get("date"),
//        		root.get("mobno")
//	        );
//
//	        // Constructing the WHERE clause based on the parameters
//	        Predicate predicate = cb.conjunction();
//	        if (exp != null && !exp.isEmpty()) {
//	            predicate = cb.and(predicate, cb.equal(root.get("expense"), exp));
//	        }
//	        if (name != null && !name.isEmpty()) {
//	            predicate = cb.and(predicate, cb.like(root.get("name"), "%" + name + "%"));
//	        }
//	       
//
//	        query.select(selection).where(predicate);
//	        return entityManager.createQuery(query).getResultList();
//	    
//
//	}
	
    public List<EmpShortInfo> Petinfo(Employee emp) {
    	System.out.println(emp.getName());

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmpShortInfo> criteriaQuery = criteriaBuilder.createQuery(EmpShortInfo.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        String name = emp.getName();
        String exp = emp.getExpense();
        

        /* Adding search criteria's for query using CriteriaBuilder */
        List<Predicate> searchCriterias = new ArrayList<>();


        if (name != null && !name.isEmpty()) {
            searchCriterias.add(criteriaBuilder.equal(root.get("name"), name));
        }
        if (name != null && !name.isEmpty()) {
//            searchCriterias.add(criteriaBuilder.or(root.get("name"), name));
        }

        if (exp != null && !exp.isEmpty()) {
            searchCriterias.add(criteriaBuilder.equal(root.get("expense"), exp));
        }

        criteriaQuery.multiselect(
        		root.get("id"),
        		root.get("name"),
                root.get("desig"),
                root.get("date"),
        		root.get("mobno")
                
           
        ).where(criteriaBuilder.and(searchCriterias.toArray(new Predicate[0])));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }


}
