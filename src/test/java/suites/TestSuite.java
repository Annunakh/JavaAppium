package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MyListsTests;
import tests.SearchTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        SearchTests.class,
        MyListsTests.class
})
public class TestSuite {
}
