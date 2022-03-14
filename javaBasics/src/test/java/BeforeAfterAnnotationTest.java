import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@Slf4j
public class BeforeAfterAnnotationTest {

    private List<String> list;

    @Before
    public void init() {
        log.info("startup");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));
    }

    @After
    public void teardown() {
        log.info("teardown");
        list.clear();
    }

    @Test
    public void whenCheckingListSize_thenSizeEqualsToInit() {
        log.info("executing test");
        assertEquals(2, list.size());

        list.add("another test");
    }

    @Test
    public void whenCheckingListSizeAgain_thenSizeEqualsToInit() {
        log.info("executing another test");
        assertEquals(2, list.size());

        list.add("yet another test");
    }
}