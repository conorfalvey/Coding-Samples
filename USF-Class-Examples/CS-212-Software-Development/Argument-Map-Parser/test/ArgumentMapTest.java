import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


//test edit
@RunWith(Enclosed.class)
public class ArgumentMapTest {

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public static class FlagTest {

		@Test
		public void testFlag01() {
			String test = "-a";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testFlag02() {
			String test = "-1";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testFlag03() {
			String test = "-hello";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testFlag04() {
			String test = "--world";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testValue01() {
			String test = "a";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testValue02() {
			String test = "1";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testValue03() {
			String test = "a-b-c";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testValue04() {
			String test = "hello";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testValue05() {
			String test = "hello world";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid01() {
			String test = "";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid02() {
			String test = " ";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid03() {
			String test = "\t";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid04() {
			String test = "-";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid05() {
			String test = "- ";
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid06() {
			String test = null;
			boolean actual = ArgumentMap.isFlag(test);
			Assert.assertFalse(actual);
		}
	}

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public static class ValueTest {

		@Test
		public void testFlag01() {
			String test = "-a";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testFlag02() {
			String test = "-1";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testFlag03() {
			String test = "-hello";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testFlag04() {
			String test = "--world";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testValue01() {
			String test = "a";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testValue02() {
			String test = "1";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testValue03() {
			String test = "a-b-c";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testValue04() {
			String test = "hello";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testValue05() {
			String test = "hello world";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertTrue(actual);
		}

		@Test
		public void testInvalid01() {
			String test = "";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid02() {
			String test = " ";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid03() {
			String test = "\t";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid04() {
			String test = "-";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid05() {
			String test = "- ";
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}

		@Test
		public void testInvalid06() {
			String test = null;
			boolean actual = ArgumentMap.isValue(test);
			Assert.assertFalse(actual);
		}
	}

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public static class CountTest {

		@Test
		public void test01() {
			String[] args = { "-loquat" };
			int expected = 1;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test02() {
			String[] args = { "-grape", "raisin" };
			int expected = 1;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test03() {
			String[] args = { "-tomato", "-potato" };
			int expected = 2;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test04() {
			String[] args = { "rhubarb" };
			int expected = 0;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test05() {
			String[] args = { "constant", "change" };
			int expected = 0;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test06() {
			String[] args = { "pine", "-apple" };
			int expected = 1;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test07() {
			String[] args = { "-aubergine", "eggplant", "-courgette", "zucchini" };
			int expected = 2;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test08() {
			String[] args = { "-tangerine", "satsuma", "-tangerine", "clementine", "-tangerine", "mandarin" };
			int expected = 1;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void test09() {
			String[] args = {};
			int expected = 0;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}

		// it is okay to throw a null pointer exception here
		@Test(expected = java.lang.NullPointerException.class)
		public void test10() {
			String[] args = null;
			int expected = 0;
			int actual = new ArgumentMap(args).numFlags();
			Assert.assertEquals(expected, actual);
		}
	}

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public static class ParseTest {
		private ArgumentMap map;
		private String debug;

		@Before
		public void setup() {
			String[] args = { "-a", "42", "-b", "bat", "cat", "-d", "-e", "elk", "-e", "-f" };

			map = new ArgumentMap();
			map.parse(args);

			debug = "\n" + map.toString() + "\n";
		}

		@After
		public void teardown() {
			map = null;
		}

		@Test
		public void testNumFlags() {
			int expected = 5;
			int actual = map.numFlags();

			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testHasFlag() {
			Assert.assertTrue(debug, map.hasFlag("-d"));
		}

		@Test
		public void testHasLastFlag() {
			Assert.assertTrue(debug, map.hasFlag("-f"));
		}

		@Test
		public void testHasntFlag() {
			Assert.assertFalse(debug, map.hasFlag("-g"));
		}

		@Test
		public void testHasValue() {
			Assert.assertTrue(debug, map.hasValue("-a"));
		}

		@Test
		public void testHasFlagNoValue() {
			Assert.assertFalse(debug, map.hasValue("-d"));
		}

		@Test
		public void testNoFlagNoValue() {
			Assert.assertFalse(debug, map.hasValue("-g"));
		}

		@Test
		public void testGetValueExists() {
			String expected = "bat";
			String actual = map.getString("-b");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetValueNull() {
			String expected = null;
			String actual = map.getString("-d");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetValueNoFlag() {
			String expected = null;
			String actual = map.getString("-g");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetValueRepeatedFlag() {
			String expected = null;
			String actual = map.getString("-e");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetDefaultExists() {
			String expected = "bat";
			String actual = map.getString("-b", "bee");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetDefaultNull() {
			String expected = "dog";
			String actual = map.getString("-d", "dog");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetDefaultMissing() {
			String expected = "goat";
			String actual = map.getString("-g", "goat");
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetIntOkay() {
			int expected = 42;
			int actual = map.getInteger("-a", 42);
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetIntNotOkay() {
			int expected = 42;
			int actual = map.getInteger("-b", 42);
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetIntNull() {
			int expected = 42;
			int actual = map.getInteger("-f", 42);
			Assert.assertEquals(debug, expected, actual);
		}

		@Test
		public void testGetIntMissing() {
			int expected = 42;
			int actual = map.getInteger("-g", 42);
			Assert.assertEquals(debug, expected, actual);
		}
	}

}
