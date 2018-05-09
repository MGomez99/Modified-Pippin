package project;

import java.util.Map;
import java.util.TreeMap;

class InstrMap {

	public static Map<String, Integer> toCode = new TreeMap<>();
	public static Map<Integer, String> toMnemonic = new TreeMap<>();

	static {
		toCode.put("NOP", 0);
		toCode.put("LODI", 1);
		toCode.put("LOD", 2);
		toCode.put("LODN", 3);
		toCode.put("STO", 4);
		toCode.put("STON", 5);
		toCode.put("JMPR", 6);
		toCode.put("JUMP", 7);
		toCode.put("JUMPI", 8);
		toCode.put("JMPZR", 9);
		toCode.put("JMPZ", 10);
		toCode.put("JMPZI", 11);
		toCode.put("ADDI", 12);
		toCode.put("ADD", 13);
		toCode.put("ADDN", 14);
		toCode.put("SUBI", 0xF);
		toCode.put("SUB", 0x10);
		toCode.put("SUBN", 0x11);
		toCode.put("MULI", 0x12);
		toCode.put("MUL", 0x13);
		toCode.put("MULN", 0x14);
		toCode.put("DIVI", 0x15);
		toCode.put("DIV", 0x16);
		toCode.put("DIVN", 0x17);
		toCode.put("ANDI", 24);
		toCode.put("AND", 25);
		toCode.put("NOT", 26);
		toCode.put("CMPL", 0x1B);  // can use decimals instead of hex: 0x1B = 27, 0X1C = 28, etc.
		toCode.put("CMPZ", 0x1C);
		toCode.put("JUMPN", 29); // 29 = 0x1D
		toCode.put("HALT", 0x1F);


		for (String s : toCode.keySet()) {
			toMnemonic.put(toCode.get(s), s);
		}
	}
}
