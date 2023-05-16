package com.ojas.otrial.controller;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Eshwar_Controller {

//	@GetMapping("/encode/{date}")
//	public Map<String, String> dispaly(@PathVariable int date) {
//		Map<String, String> map = new HashMap<String, String>();
//
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
//		LocalDateTime now = LocalDateTime.now();
//
//		String example1 = dtf.format(now);
//		StringBuilder sb = new StringBuilder(example1);
//		sb.insert(4, date);
//
//		map.put("output", sb.toString());
//
//		System.out.println(sb);
//		return map;
//	}
//
//	@GetMapping("/encode/{num}")
//	public Map<String, String> Encode(@PathVariable String num) {
//		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
//		Date date = new Date();String strDate = formatter.format(date);
//		String s1 = strDate.substring(0, 4);
//		String s2 = strDate.substring(4, 8);
//		String append = strDate.join(num, s1, s2);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("result", append);return map;
//	}

//	@GetMapping("/decode/{num}")
//	public Map<String, String> dispaly(@PathVariable String num) {
//		String original = num.substring(4, num.length() - 4);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("result", original);
//
//		return map;
//	}

//	@GetMapping("/encode/{name}/{number}")
//	public Map<String, String> Encode(@PathVariable String name,@PathVariable int number) {
//		Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
//		dictionary.put('a', 20);
//		dictionary.put('b', 21);
//		dictionary.put('c', 22);
//		dictionary.put('d', 23);
//		dictionary.put('e', 24);
//		dictionary.put('f', 25);
//		dictionary.put('g', 26);
//		dictionary.put('h', 27);
//		dictionary.put('i', 28);
//		dictionary.put('j', 29);
//		dictionary.put('k', 30);
//		dictionary.put('l', 31);
//		dictionary.put('m', 32);
//		dictionary.put('n', 33);
//		dictionary.put('o', 34);
//		dictionary.put('p', 35);
//		dictionary.put('q', 36);
//		dictionary.put('r', 37);
//		dictionary.put('s', 38);
//		dictionary.put('t', 39);
//		dictionary.put('u', 40);
//		dictionary.put('v', 41);
//		dictionary.put('w', 42);
//		dictionary.put('x', 43);
//		dictionary.put('y', 44);
//		dictionary.put('z', 45);
//		dictionary.put('A', 46);
//		dictionary.put('B', 47);
//		dictionary.put('C', 48);
//		dictionary.put('D', 49);
//		dictionary.put('E', 50);
//		dictionary.put('F', 51);
//		dictionary.put('G', 52);
//		dictionary.put('H', 53);
//		dictionary.put('I', 54);
//		dictionary.put('J', 55);
//		dictionary.put('K', 56);
//		dictionary.put('L', 57);
//		dictionary.put('M', 58);
//		dictionary.put('N', 59);
//		dictionary.put('O', 60);
//		dictionary.put('P', 61);
//		dictionary.put('Q', 62);
//		dictionary.put('R', 63);
//		dictionary.put('S', 64);
//		dictionary.put('T', 65);
//		dictionary.put('U', 66);
//		dictionary.put('V', 67);
//		dictionary.put('W', 68);
//		dictionary.put('X', 69);
//		dictionary.put('Y', 70);
//		dictionary.put('Z', 71);
//		Map<String, String> map = new HashMap<>();
//		String numbers = "";
//		char[] ch = name.toCharArray();
//		for (int i = 0; i < ch.length; i++) {
//			System.out.print(ch[i]);
//			Object value = dictionary.get(ch[i]);
//			String num = value.toString();
//			numbers = numbers + num;
//			System.out.println(numbers);
//			}
//		System.out.println(numbers);
//		map.put("result", numbers.substring(0, numbers.length() / 2) + number+ numbers.substring(numbers.length() / 2, numbers.length()));
//		return map;
//		}

//	@GetMapping("/linkgen/welcome")
//	public String test() {
//		JSONObject obj = new JSONObject();
//		obj.put("msg", "welcomeuser");
//		JSONObject data = new JSONObject();
//		for (int i = 1; i <= 3; i++) {
//			data.put("m" + i, "http://192.168.3.225:9999/api/linkgen/welcome/" + encode(i));
//		}
//
//		obj.put("menu", data);
//		String jsonString = obj.toString();
//		return jsonString;
//	}

//	private String encode(int i) {
//		Random rand = new Random();
//
//		int rand_int1 = rand.nextInt(10000);
//		String s = String.valueOf(rand_int1);
//		
//		int rand_int2 = rand.nextInt(10000);
//		String s1 = String.valueOf(rand_int2);
//
//		String res = s.concat(""+i);
//		String res1 = res.concat(s1);
//
//		return res1;
//	}

//	@GetMapping("/linkgen/welcome/{number}")
//	public String result(@PathVariable String number) {
//		
//		String res = number.substring(4,5);
//		return res;
//	}

	@GetMapping("/linkgenv2/encode/{number}")
	public String result(@PathVariable int number) {
		int x = 8, i;
		String str = "4l6l",add="";
		String s = "";
		for (i = 0; i <= 10; i++) {
			if (i == 0) {
				add = str + i;
				//System.out.print(add);
				continue;
			}

			int res = (x * i);
			s += res;

			if (i==9) {
				String fin = add+"845";
				System.out.print(fin);
				continue;
			}
		}
		System.out.print(s);
		return s;
	}
}
