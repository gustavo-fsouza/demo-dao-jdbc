package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller sellerOnList : list) {
			System.out.println(sellerOnList);
		}
		
		System.out.println("\n==== TEST 3: seller findByAll ====");
		list = sellerDao.findAll();
		
		for (Seller sellerOnList : list) {
			System.out.println(sellerOnList);
		}
		
		System.out.println("\n==== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id  = " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 6: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("==== TEST 7: department findById ====");
		Department dep = departmentDao.findById(1);
		
		System.out.println(dep);
		
		System.out.println("==== TEST 8: department findAll ====");
		List<Department> depList = departmentDao.findAll();
		
		for (Department d : depList) {
			System.out.println(d);
		}
		
		System.out.println("\n==== TEST 9: department insert ====");
		Department newDepartment = new Department(null, "House");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id  = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 10: department update ====");
		department = departmentDao.findById(6);
		department.setName("Cars");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		
		sc.close();
	}

}
