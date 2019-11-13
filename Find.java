package jiu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Find {
	public static void find() {
		Scanner sc=new Scanner(System.in);
	
		System.out.println("请输入要查找的学号：");
		String num=sc.nextLine();
		Iterator it=Main.list.iterator();
		while(it.hasNext()) {
			Object obj=it.next();
			Student stu1=(Student)obj;
			if(num.equals(stu1.getStudentNum())) {
				System.out.println("您要查找学生信息如下：");
				System.out.println(stu1.toString());
					break;
			}
	}
 }
}
