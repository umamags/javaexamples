package com.hierarchy;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateHierarchy {
	/*
	 * public Item getItemWithParent(int parentID){ Item result = null;
	 * if(this.categoryID == parentID){ result = this; } else { for(Item
	 * nextChild : children){ result = nextChild.getItemWithParent(parentID);
	 * if(result != null){ break; } } } return result; }
	 */

	public void createMap(ArrayList<Employee> list) {
		HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
		for (Employee emp : list) {
			String supervisor_empid = emp.getSupervisor_empid();
			if (map.containsKey(supervisor_empid)) {
				ArrayList emplist = map.get(supervisor_empid);
				emplist.add(emp);
			} else {
				ArrayList emplist = new ArrayList();
				emplist.add(emp);				
			}
		}
	}
	public static void main(String args[]) {
		CreateHierarchy ch = new CreateHierarchy();
		ReadExcel re = new ReadExcel();
		String filename = "C:/MyData/myjob/skills/data/out/SCB/OUT-SCB-SVF - Resource View on 10252018-Chennai.xlsx";
		ArrayList<Employee> list = re.readExcel(filename);

	}
}
