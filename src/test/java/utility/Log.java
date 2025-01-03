package utility;

import org.apache.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
	
	private static Logger Log = LogManager.getLogger(Log.class);
	
	public static void startTestCase(String sTestCaseName) {
		Log.info("<font color = blue><strong>***************************************************************</strong></font><br>");
		Log.info("<font size=4 > **************************"+sTestCaseName+" **************************************</font><br>");
		Log.info("<font color = blue><strong>***************************************************************</strong></font><br>");
	}
	
	public static void endTestCase(String sTestCaseName) {
		Log.info("<font color = blue><strong>***************************************************************</strong></font><br>");
		Log.info("<font size=4 > **************************"+"-E---N---D-"+" **************************************</font><br>");
		Log.info("<font color = blue><strong>***************************************************************</strong></font><br>");
	}
	
	public static void info(String message) {
		Log.info("<font color = green><i> Pass :: "+message+" </i></font><br>");
	}
	
	public static void warn(String message) {
		Log.info("<font color = brown><i> Pass :: "+message+" </i></font><br>");
	}
	
	public static void error(String message) {
		Log.info("<font size = 3 color = red><i> Fail :: "+message+" </i></font><br>");
	}
	
	public static void fatal(String message) {
		Log.fatal(message);
	}
	
	public static void debug(String message) {
		Log.info("<font color = orange><i> Pass :: "+message+" </i></font><br>");
	}

}
