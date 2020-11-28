import org.apache.commons.compress.archivers.ArchiveEntry;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    public void File_getName_test() {
        /* 创建 Mock 对象 */
        File file = mock(File.class);

        /* 设置预期 */
        doReturn("test1.txt").doReturn("test3.txt").doReturn("test5.txt").when(file).getName();

        Assert.assertEquals("Exception", "test1.txt", file.getName());
        Assert.assertEquals("Exception", "test3.txt", file.getName());
        Assert.assertEquals("Exception", "test5.txt", file.getName());

        /* 对 Mock 对象设置无效 */
        System.out.println(file.length());
//        file = new File("D:\\test\\doc\\2Zip\\test2.txt");
//        System.out.println(file.length());

        verify(file, times(3)).getName();

        /* 验证返回结果 */
        String ret = (String)file.getName();
        Assert.assertEquals(ret, "test5.txt");
    }

    @Test
    public void ArchiveEntry_getName_test() {
        /* 创建 Mock 对象 */
        ArchiveEntry archiveEntry = mock(ArchiveEntry.class);

        /*   设置 预期 */
        doReturn("doc.zip").when(archiveEntry).getName();

        assertEquals("Exception", "doc.zip", archiveEntry.getName());

        System.out.println(archiveEntry.getName());
        System.out.println(archiveEntry.getSize());

        verify(archiveEntry, times(2)).getName();

        /* 验证返回结果 */
        String ret = (String)archiveEntry.getName();
        assertEquals(ret, "doc.zip");
    }
}