package net.maexchen.json2hashmap;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * Author: Maximilian Voss (info@maexchen.net)
 * Test class for net.maexchen.json2hashmap.Json2Hashmap
 */
public class Json2HashmapTest {

	/*
		{
			"object": {
				"int":1234,
				"string":"1234"
			}
		 }
	 */
	private static final String JSONSTRING_TEST_A = "{\"object\":{\"int\":1234,\"string\":\"1234\"}}";

	/*
		{
			"object1": {
				"int":1234
			},
			"object2": {
				"int":5678
			},
			"object3": {
				"int":9012
			},
			"object4": {
				"string":"abcdef",
				"string2":"ghijkl",
				"string3":"mnopqr",
				"string4":"stuvwx"
			},
			"string":"abcdefg"
		}
	 */
	private static final String JSONSTRING_TEST_B = "{\"object1\":{\"int\":1234},\"object2\":{\"int\":5678},\"object3\":{\"int\":9012},\"object4\":{\"string\":\"abcdef\",\"string2\":\"ghijkl\",\"string3\":\"mnopqr\",\"string4\":\"stuvwx\"},\"string\":\"abcdefg\"}";

	/*
		{
			"integer":2000000,
			"object1": {
				"array":["element0","element1","element2"],
				"booleanFalse":false,
				"booleanTrue":true,
				"stringNotNull":"abcdefg",
				"stringNull":null
			},
			"string":"abcdefg"
		}
	 */
	private static final String JSONSTRING_TEST_C = "{\"integer\":2000000,\"object1\":{\"array\":[\"element0\",\"element1\",\"element2\"],\"booleanFalse\":false,\"booleanTrue\":true,\"stringNotNull\":\"abcdefg\",\"stringNull\":null},\"string\":\"abcdefg\"}";


	/*
		{
			"object": {
				"integer":243826,
				"object": {
					"array":[
						{
							"integer":565656
						},
						{
							"booleanFalse":false,
							"booleanTrue":true,
							"integer":1234123,
							"string":"abcdefg"
						},
						1231
					]
				}
			},
			"string":"efgasdf"
		}
	 */
	private static final String JSONSTRING_TEST_D = "{\"object\":{\"integer\":243826,\"object\":{\"array\":[{\"integer\":565656},{\"booleanFalse\":false,\"booleanTrue\":true,\"integer\":1234123,\"string\":\"abcdefg\"},1231]}},\"string\":\"efgasdf\"}";


	private static Map<String, Object> MAP_TEST_A = new HashMap<String, Object>();
	private static JSONObject JSONOBJECT_TEST_A;
	private static Map<String, Object> MAP_TEST_B = new HashMap<String, Object>();
	private static JSONObject JSONOBJECT_TEST_B;
	private static Map<String, Object> MAP_TEST_C = new HashMap<String, Object>();
	private static JSONObject JSONOBJECT_TEST_C;
	private static Map<String, Object> MAP_TEST_D = new HashMap<String, Object>();
	private static JSONObject JSONOBJECT_TEST_D;

	static {
		MAP_TEST_A.put("object.int", 1234);
		MAP_TEST_A.put("object.string", "1234");
	}

	static {
		MAP_TEST_B.put("object1.int", 1234);
		MAP_TEST_B.put("object2.int", 5678);
		MAP_TEST_B.put("object3.int", 9012);
		MAP_TEST_B.put("object4.string", "abcdef");
		MAP_TEST_B.put("object4.string2", "ghijkl");
		MAP_TEST_B.put("object4.string3", "mnopqr");
		MAP_TEST_B.put("object4.string4", "stuvwx");
		MAP_TEST_B.put("string", "abcdefg");
	}

	static {
		MAP_TEST_C.put("object1.stringNull", null);
		MAP_TEST_C.put("object1.stringNotNull", "abcdefg");
		MAP_TEST_C.put("object1.array[0]", null);
		MAP_TEST_C.put("object1.array[2]", "element2");
		MAP_TEST_C.put("object1.booleanTrue", true);
		MAP_TEST_C.put("object1.booleanFalse", false);
		MAP_TEST_C.put("string", "abcdefg");
		MAP_TEST_C.put("integer", 2000000);
		MAP_TEST_C.put("object1.array[1]", "element1");
		MAP_TEST_C.put("object1.array[0]", "element0");
	}

	static {
		MAP_TEST_D.put("object.object.array[1].string",
				"abcdefg");
		MAP_TEST_D.put("object.integer", 243826);
		MAP_TEST_D
				.put("object.object.array[1].booleanTrue", true);
		MAP_TEST_D
				.put("object.object.array[1].booleanFalse", false);
		MAP_TEST_D
				.put("object.object.array[1].integer", 1234123);
		MAP_TEST_D
				.put("object.object.array[0].integer", 565656);
		MAP_TEST_D
				.put("string", "efgasdf");
		MAP_TEST_D
				.put("object.object.array[2]", 1231);
	}

	@Before
	public void setup() throws JSONException {
		JSONOBJECT_TEST_A = new JSONObject(JSONSTRING_TEST_A);
		JSONOBJECT_TEST_B = new JSONObject(JSONSTRING_TEST_B);
		JSONOBJECT_TEST_C = new JSONObject(JSONSTRING_TEST_C);
		JSONOBJECT_TEST_D = new JSONObject(JSONSTRING_TEST_D);
	}

	@Test
	public void TestATest() throws JSONException {
		assertEquals(JSONSTRING_TEST_A, Json2Hashmap.map2json(MAP_TEST_A).toString());
		assertEquals(MAP_TEST_A, Json2Hashmap.json2map(JSONSTRING_TEST_A));
		assertEquals(MAP_TEST_A, Json2Hashmap.json2map(JSONOBJECT_TEST_A));
	}

	@Test
	public void TestBTest() throws JSONException {
		assertEquals(JSONSTRING_TEST_B, Json2Hashmap.map2json(MAP_TEST_B).toString());
		assertEquals(MAP_TEST_B, Json2Hashmap.json2map(JSONSTRING_TEST_B));
		assertEquals(MAP_TEST_B, Json2Hashmap.json2map(JSONOBJECT_TEST_B));
	}

	@Test
	public void TestCTest() throws JSONException {
		assertEquals(JSONSTRING_TEST_C, Json2Hashmap.map2json(MAP_TEST_C).toString());
		assertEquals(MAP_TEST_C, Json2Hashmap.json2map(JSONSTRING_TEST_C));
		assertEquals(MAP_TEST_C, Json2Hashmap.json2map(JSONOBJECT_TEST_C));
	}

	@Test
	public void TestDTest() throws JSONException {
		assertEquals(JSONSTRING_TEST_D, Json2Hashmap.map2json(MAP_TEST_D).toString());
		assertEquals(MAP_TEST_D, Json2Hashmap.json2map(JSONSTRING_TEST_D));
		assertEquals(MAP_TEST_D, Json2Hashmap.json2map(JSONOBJECT_TEST_D));
	}
}
