import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.*;

public class MyCompressTest {
    private static MyCompress myCompress = new MyCompress();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Ignore
    public void testFiles2Zip1() {
        myCompress.Files2Zip(new File("D:\\test\\doc\\2Zip").listFiles(), new File("D:\\test\\doc\\doc0.zip"), false);
        assertEquals(true, myCompress.getResult());
    }
    @Ignore
    public void testFiles2Zip2() {
        myCompress.Files2Zip(new File("D:\\test\\doc\\2Zip_null").listFiles(), new File("D:\\test\\doc\\doc0.zip"), false);
        assertEquals(false, myCompress.getResult());
    }
    @Ignore
    public void testZip2Files1() {
        myCompress.Zip2Files(new File("D:\\test\\doc\\doc.zip"), new File("D:\\test\\doc"));
        assertEquals(true, myCompress.getResult());
    }
    @Ignore
    public void testZip2Files2() {
        myCompress.Zip2Files(new File("D:\\test\\doc\\docdoc.zip"), new File("D:\\test\\doc"));
        assertEquals(false, myCompress.getResult());
    }
}