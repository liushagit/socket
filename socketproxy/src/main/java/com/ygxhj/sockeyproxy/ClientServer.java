package com.ygxhj.sockeyproxy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ygxhj.sockeyproxy.client.Client;

public class ClientServer {

	
	public static void main(String[] args) {
		final Client[] c = new Client[10];
		for (int i = 0; i < 100; i++) {
			try {
				Client client = new Client();
				c[i] = client;
				client.send();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("start=========");
//				Client client = new Client();
//				client.send();
				for (int i = 0; i < c.length; i++) {
					try {
						c[i].send();
					} catch (Exception e) {
					}
				}
			}
		}, 0, 1, TimeUnit.SECONDS);
	}
}
