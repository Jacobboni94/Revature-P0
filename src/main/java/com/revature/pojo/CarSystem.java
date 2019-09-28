package com.revature.pojo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.revature.util.LoggerUtil;

public class CarSystem extends Menu {

	public CarSystem() {
		super();
	}

	public void readInput() {
		Scanner in = new Scanner(System.in);
		while (true) {
			String string = in.next();
			if (string.equals("1")) {
				login();
				break;
			} else if (string.equals("2")) {
				register();
				break;
			} else {
				LoggerUtil.warn("Please type either 1 or 2");
			}
		}
		in.close();
	}

	private void login() {
		//readFromFile();
	}

	private void readFromFile() {
		String filename = "D:\\Revature\\repos\\Revature-P0\\src\\main\\resources\\userData.dat";
		Scanner sc = new Scanner(filename);
	}

	private void register() {
		//WriteToDataFile();
	}

	private void WriteToDataFile() {
		String filename = "D:\\Revature\\repos\\Revature-P0\\src\\main\\resources\\userData.dat";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			formNewLine();
		} catch (IOException e) {
			LoggerUtil.error("i/o error");
			e.printStackTrace();
		}
	}

	private String formNewLine() {
		// TODO Auto-generated method stub

		return "";
	}
}
