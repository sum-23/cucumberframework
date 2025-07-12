package utils;

import java.util.Date;

public class Utility {

	public final static int IMPLICIT_WAIT = 10;
	public final static int PAGE_LOAD_TIME = 20;

	public String getEmailTimeStamp() {

		Date date = new Date();
		return date.toString().replace(":", "_").replace(" ", "_") + "@gmail.com";
	}

}
