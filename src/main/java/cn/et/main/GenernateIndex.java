package cn.et.main;

import java.util.Timer;

public class GenernateIndex {
	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new MyTimerTask(), 5,10000);
	}
}
