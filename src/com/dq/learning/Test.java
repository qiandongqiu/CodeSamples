package com.dq.learning;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {

	private LocalDateTime lastRunTime;

	/**
	 * 执行任务的主体入口。
	 */
	public void execute() {
		String frequency = "三天一次";
		if (frequency == null) {
			System.out.println("frequency is not found in database!");
		} else {
//			System.out.println(" qky found frequency   " + frequency);
//			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			LocalDateTime now = LocalDateTime.now();
			if (lastRunTime == null) {
				// do what ever task you need to run
//				System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

				lastRunTime = now;
			} else {
//				System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//				System.out.println(now);

				Duration duration = Duration.between(now, lastRunTime);
				// double diff = Math.abs(duration.toMinutes());
				long diff = Math.abs(duration.toMillis());
				System.out.println(diff);
				if (frequency.equals("仅发一次") && diff < 1000) {
					System.out.println("ffffffffffffffffffffffff");

					System.out.println("仅发一次qqqqqqqq");
					lastRunTime = now;
				}
				if (frequency.equals("一天一次") && (diff >= 2000)) {
					System.out.println("一天一次");
					lastRunTime = now;
				} else if (frequency.equals("三天一次") && diff >= 3000) {
					System.out.println("三天一次");
					lastRunTime = now;
				} else if (frequency.equals("一月一次") && diff >= 5000) {
					System.out.println("一月一次");
					lastRunTime = now;
				}
			}
		}
	}

	public static void main(String[] args) {
		Test ins = new Test();
		int count=0;
		while (count<=5) {
			ins.execute();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {

			}
			ins.execute();
			count++;
		}

	}

}
