import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class LoadingResourcesInTestTest {

    @Test
    public void testLoadResourceUsingClassLoader() {
        final ClassLoader classLoader = getClass().getClassLoader();
        final String resourceName = "daily_report.csv";
        final File file = new File(classLoader.getResource(resourceName).getFile());
        final String absolutePath = file.getAbsolutePath();

        System.out.println(absolutePath);

        Assert.assertTrue(absolutePath.endsWith("/daily_report.csv"));
    }

    @Test
    public void testLoadResourceUsingPath() {
        final Path resourcePath = Paths.get("src", "test", "resources");
        final String absolutePath = resourcePath.toFile().getAbsolutePath();

        System.out.println(absolutePath);

        Assert.assertTrue(absolutePath.endsWith("src/test/resources"));
    }

    @Test
    public void testLoadResourceUsingFile() {
        final String resourcePath = "src/test/resources";
        final File file = new File(resourcePath);
        final String absolutePath = file.getAbsolutePath();

        System.out.println(absolutePath);

        Assert.assertTrue(absolutePath.endsWith("src/test/resources"));
    }

}
