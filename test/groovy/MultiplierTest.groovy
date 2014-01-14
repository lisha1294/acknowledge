import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import GroovyMultiplier

@RunWith(Parameterized)
class MultiplierTest 
{
    def testee
    def param
    def expectedResult

    @Parameters static data() 
    {
          return (2..4).collect{ [it, it * 3] as Integer[] }
    }

    MultiplierTest(a, b) 
    {
        param = a
        expectedResult = b
    }

    @Before 
    void setUp() 
    {
        testee = new GroovyMultiplier()
    }

    @Test 
    void positivesFixed() 
    {
        assert testee.triple(1) == 3: "+ve multiplier error"
    }

    @Test 
    void positivesParameterized() 
    {
        assert testee.triple(param) == expectedResult
    }

    @Test 
    void negativesParameterized() 
    {
        println "negativeParameterised test"
        assert testee.triple(-param) == -expectedResult
    }

    public static void main(args) 
    {
        
    }

}