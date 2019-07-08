package com.testcases;

import com.genlib.General;

public class TC_002 {
public static void main(String[] args) {
	
	General g=new General();
	g.openbrowser();
	g.openApplication();
	//g.login();
	g.addEmp();
	//g.logout();
	g.closeBrowser();
}
}
