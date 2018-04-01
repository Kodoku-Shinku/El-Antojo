package MSystem.IS.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ ServicioAdministracionTest.class })
public class AllTests {
	public static Test suite(){
		TestSuite suite = new TestSuite("test para probar MSystem.IS.Servicios");
		
		suite.addTestSuite(ServicioAdministracionTest.class);
		
		return suite;
		
	}

}
