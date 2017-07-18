package org.cb.practice.controllers;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {
	
	 public void setAsText(String studentName) throws IllegalArgumentException {
		 
		 if(studentName.contains("Mr.")||studentName.contains("Ms.")) {
			 setValue(studentName);
		 }
		 else 
		 {
			 studentName = "Mr. "+studentName;
			 setValue(studentName);
			 
		 } 
	 }

}
