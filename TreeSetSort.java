package Assign9_4;

import java.util.Comparator;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
	String name;
	String designation;
	double salary;
	public Employee (String name, String designation, double salary) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Employee) {
			Employee emp = (Employee) o;
			return (this.name.equals(emp.name) && this.designation.equals(emp.designation)
					&& this.salary == emp.salary);
		}
		return false;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if (o != null) {
			if (this.salary == o.salary) {
				if (this.name.equals(o.name)) {
					return this.designation.compareToIgnoreCase(o.designation);
				} else {
					return this.name.compareToIgnoreCase(o.name);
				}
			} else {
				return (this.salary < o.salary)? -1 : 1;
			}
		} 
		return 0;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + designation + ", " + salary + "]";
	}
		
}

class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.name.equals(o2.name)) {
			if (o1.designation.equals(o2.designation)) {
				return Double.compare(o1.salary, o2.salary);
			} else {
				return o1.designation.compareToIgnoreCase(o2.designation);
			}
		} else {
			return o1.name.compareToIgnoreCase(o2.name);
		}
	}
	
}

public class TreeSetSort {
	public static void main(String[] args) {
		TreeSet<Employee> ts = new TreeSet<Employee>();
		TreeSet<Employee> byName = new TreeSet<Employee>(new SortByName());
		ts.add(new Employee("Iggy", "CEO", 150000000));
		ts.add(new Employee("Kal", "Associate", 5000000));
		ts.add(new Employee("Cal", "Manager", 400000));
		ts.add(new Employee("Adam", "Senior Developer", 300000));
		ts.add(new Employee("Chris", "Junior Developer", 200000));
		
		byName.add(new Employee("Iggy", "CEO", 150000000));
		byName.add(new Employee("Kal", "Associate", 5000000));
		byName.add(new Employee("Cal", "Manager", 400000));
		byName.add(new Employee("Adam", "Senior Developer", 300000));
		byName.add(new Employee("Chris", "Junior Developer", 200000));
		
		System.out.println("Sorted by salary:");
		for (Employee employee : ts) {
			System.out.println(employee);
		}
		
		System.out.println();
		System.out.println("Sorted by name:");
		for (Employee employee : byName) {
			System.out.println(employee);
		}
		
		
	}
}