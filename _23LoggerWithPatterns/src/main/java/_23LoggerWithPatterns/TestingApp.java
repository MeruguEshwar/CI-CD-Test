package _23LoggerWithPatterns;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;



public class TestingApp {

	private static Logger logger = Logger.getLogger(TestingApp.class);

	public static void main(String[] args) {

		//1.Create layout
		Layout layout = new PatternLayout(":[%m] %n");
		
		//2.create appender + link layout
		Appender app = new ConsoleAppender(layout);
		
		//3.link appender with logger
		logger.addAppender(app);
		
		//---Print msg's
		logger.info("from info");
		logger.debug("from debug");
		logger.fatal("from fatal");
		logger.error("from error");
		logger.warn("from warn");
	}

}
