package com.youmeek.java.main;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * 旧的 API 中 java.util.Date 和 java.util.Calendar 线程不安全，通用性差，以后基本都可以换掉了
 */
public class DateTimeTest {


	/**
	 * LocalDate 类表示一个具体的日期（yyyy-MM-dd），但不包含具体时间，也不包含时区信息
	 */
	@Test
	public void test132() {
		//
		LocalDate localDateObject = LocalDate.of(2017, 1, 4);     // 初始化一个日期：2017-01-04
		int year = localDateObject.getYear();                     // 年份：2017
		Month month = localDateObject.getMonth();                 // 第几月-英文：JANUARY
		int monthValue = localDateObject.getMonthValue();        // 第几份：1
		int dayOfMonth = localDateObject.getDayOfMonth();         // 月份中的第几天：4
		DayOfWeek dayOfWeek = localDateObject.getDayOfWeek();     // 一周的第几天：WEDNESDAY
		int lengthOfYear = localDateObject.lengthOfYear();             // 这一年一共有多少天：365
		int lengthOfMonth = localDateObject.lengthOfMonth();             // 月份的天数：31
		boolean leapYear = localDateObject.isLeapYear();          // 是否为闰年：false
		long toEpochDay = localDateObject.toEpochDay();          // 距离 1970-01-01 00:00:00 年过去了多少天
		System.out.println("--------------------------------year=" + year);
		System.out.println("--------------------------------month=" + month);
		System.out.println("--------------------------------monthValue（from 1 to 12）=" + monthValue);
		System.out.println("--------------------------------dayOfMonth=" + dayOfMonth);
		System.out.println("--------------------------------dayOfWeek.toString()=" + dayOfWeek.toString());
		System.out.println("--------------------------------dayOfWeek.getValue()<from 1 (Monday) to 7 (Sunday)>=" + dayOfWeek.getValue());
		System.out.println("--------------------------------lengthOfYear=" + lengthOfYear);
		System.out.println("--------------------------------lengthOfMonth=" + lengthOfMonth);
		System.out.println("--------------------------------leapYear=" + leapYear);
		System.out.println("--------------------------------toEpochDay=" + toEpochDay);
	}

	/**
	 * LocalDate 类表示一个具体的日期（yyyy-MM-dd），但不包含具体时间，也不包含时区信息
	 */
	@Test
	public void test1312() {
		LocalDate localDateObject = LocalDate.now();//获取当前日期
		int year = localDateObject.getYear();
		Month month = localDateObject.getMonth();
		int monthValue = localDateObject.getMonthValue();
		int dayOfMonth = localDateObject.getDayOfMonth();
		DayOfWeek dayOfWeek = localDateObject.getDayOfWeek();
		int lengthOfYear = localDateObject.lengthOfYear();
		int lengthOfMonth = localDateObject.lengthOfMonth();
		boolean leapYear = localDateObject.isLeapYear();
		long toEpochDay = localDateObject.toEpochDay();
		System.out.println("--------------------------------year=" + year);
		System.out.println("--------------------------------month=" + month);
		System.out.println("--------------------------------monthValue（from 1 to 12）=" + monthValue);
		System.out.println("--------------------------------dayOfMonth=" + dayOfMonth);
		System.out.println("--------------------------------dayOfWeek.toString()=" + dayOfWeek.toString());
		System.out.println("--------------------------------dayOfWeek.getValue()<from 1 (Monday) to 7 (Sunday)>=" + dayOfWeek.getValue());
		System.out.println("--------------------------------lengthOfYear=" + lengthOfYear);
		System.out.println("--------------------------------lengthOfMonth=" + lengthOfMonth);
		System.out.println("--------------------------------leapYear=" + leapYear);
		System.out.println("--------------------------------toEpochDay=" + toEpochDay);
	}

	/**
	 * LocalTime 只包含具体时间（HH:mm:ss）
	 */
	@Test
	public void test131112() {
		LocalTime localTime = LocalTime.of(17, 23, 52); // 初始化一个时间：17:23:52
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		System.out.println("--------------------------------hour（from 0 to 23）=" + hour);
		System.out.println("--------------------------------minute（from 0 to 59）=" + minute);
		System.out.println("--------------------------------second（from 0 to 59）=" + second);
	}

	/**
	 * LocalDateTime 是 LocalDate 和 LocalTime 的结合体（yyyy-MM-dd HH:mm:ss）
	 * localDate 和 LocalTime 常用的方法它都有
	 */
	@Test
	public void test1312112() {
		// 直接声明
		LocalDateTime localDateTimeObject = LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52);

		// LocalDate + LocalTime 结合声明
		LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 4);
		LocalTime localTime = LocalTime.of(17, 23, 52);
		LocalDateTime localDateTimeObject2 = localDate.atTime(localTime);


		// LocalDateTime 也可以转换成 LocalDate + LocalTime
		LocalDate date = localDateTimeObject.toLocalDate();
		LocalTime time = localDateTimeObject.toLocalTime();

	}

	/**
	 * Instant 用于表示一个时间戳，它与我们常使用的 System.currentTimeMillis()有些类似，不过 Instant 可以精确到纳秒（Nano-Second），System.currentTimeMillis() 方法只精确到毫秒（Milli-Second）
	 */
	@Test
	public void test13121112() {
		Instant now = Instant.now();
		long currentTimeMillis = System.currentTimeMillis();
		long epochSecond = now.getEpochSecond();
		long toEpochMilli = now.toEpochMilli();

		System.out.println("--------------------------------currentTimeMillis=" + currentTimeMillis);
		System.out.println("--------------------------------epochSecond=" + epochSecond);// 1524581378 = 从 1970-01-01 00:00:00 开始到现在过的秒数
		System.out.println("--------------------------------toEpochMilli=" + toEpochMilli);// 1524581378418 = 从 1970-01-01 00:00:00 开始到现在过的毫秒数
	}

	/**
	 * 通过时间戳生成时间
	 */
	@Test
	public void test131121112() {
		Instant now1 = Instant.ofEpochSecond(1524581378L);
		Instant now2 = Instant.ofEpochMilli(1524581378418L);

		System.out.println("--------------------------------now1=" + now1);//2018-04-24T14:49:38Z
		System.out.println("--------------------------------now2=" + now2);//2018-04-24T14:49:38.418Z
	}

	/**
	 * Duration 的内部实现与 Instant 类似，也是包含两部分：seconds 表示秒，nanos 表示纳秒。两者的区别是 Instant 用于表示一个时间戳（或者说是一个时间点），而 Duration 表示一个时间段，所以 Duration 类中不包含 now() 静态方法
	 */
	@Test
	public void test1311121112() {
		LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
		LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
		Duration duration = Duration.between(from, to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

		long days = duration.toDays();              // 这段时间的总天数
		long hours = duration.toHours();            // 这段时间的小时数
		long minutes = duration.toMinutes();        // 这段时间的分钟数
		long seconds = duration.getSeconds();       // 这段时间的秒数
		long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
		long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数

		System.out.println("--------------------------------days=" + days);
		System.out.println("--------------------------------hours=" + hours);
		System.out.println("--------------------------------minutes=" + minutes);
		System.out.println("--------------------------------seconds=" + seconds);
		System.out.println("--------------------------------milliSeconds=" + milliSeconds);
		System.out.println("--------------------------------nanoSeconds=" + nanoSeconds);
	}

	/**
	 * Duration 的内部实现与 Instant 类似，也是包含两部分：seconds 表示秒，nanos 表示纳秒。两者的区别是 Instant 用于表示一个时间戳（或者说是一个时间点），而 Duration 表示一个时间段，所以 Duration 类中不包含 now() 静态方法
	 */
	@Test
	public void test13111211112() {
		LocalDate localDateObject = LocalDate.now();
		LocalDate date1 = localDateObject.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));      // 返回下一个距离当前时间最近的星期日（如果今天就是星期天，则返回的是当天）（要跟 next 区分开）
		LocalDate date2 = localDateObject.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY));   // 返回本月最后一个星期六
		LocalDate date3 = localDateObject.with(TemporalAdjusters.lastDayOfMonth());   // 返回本月最后一天日期
		LocalDate date4 = localDateObject.with(TemporalAdjusters.firstInMonth(DayOfWeek.SATURDAY));   // 返回本月最初一个星期六
		LocalDate date5 = localDateObject.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));   // 返回下一个的星期日
		LocalDate date6 = localDateObject.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));   // 返回上一个的星期日
		LocalDate date7 = localDateObject.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));   // 返回上一一个距离当前时间最近的星期日（如果今天就是星期天，则返回的是当天）（要跟 previous 区分开）

		System.out.println("--------------------------------date1=" + date1);
		System.out.println("--------------------------------date2=" + date2);
		System.out.println("--------------------------------date3=" + date3);
		System.out.println("--------------------------------date4=" + date4);
		System.out.println("--------------------------------date5=" + date5);
		System.out.println("--------------------------------date6=" + date6);
		System.out.println("--------------------------------date7=" + date7);
	}

	/**
	 * 计算下一个工作日的日期（排除周六日）
	 * 如果上面表格中列出的方法不能满足你的需求，你还可以创建自定义的 TemporalAdjuster 接口的实现，TemporalAdjuster 也是一个函数式接口
	 */
	@Test
	public void test131112111112() {
		LocalDate localDateObject = LocalDate.now();
		LocalDate date1 = localDateObject.with(temporal -> {
			// 当前日期
			DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

			// 正常情况下，每次增加一天
			int dayToAdd = 1;

			// 如果是星期五，增加三天
			if (dayOfWeek == DayOfWeek.FRIDAY) {
				dayToAdd = 3;
			}

			// 如果是星期六，增加两天
			if (dayOfWeek == DayOfWeek.SATURDAY) {
				dayToAdd = 2;
			}

			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});

		System.out.println("--------------------------------date1=" + date1);
	}

	/**
	 * 格式化日期（LocalDateTime 到 String ; String 到 LocalDateTime）
	 */
	@Test
	public void test1311112111112() {
		LocalDateTime dateTime = LocalDateTime.now();
		String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
		String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
		String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA));


		String strDate = "2018-04-24";
		LocalDate dateResult = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String strDateTime = "2018-04-24 23:24:04";
		LocalDateTime dateTimeResult = LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("--------------------------------strDate1=" + strDate1);
		System.out.println("--------------------------------strDate2=" + strDate2);
		System.out.println("--------------------------------strDate3=" + strDate3);
		System.out.println("--------------------------------strDate4=" + strDate4);
		System.out.println("--------------------------------strDate5=" + strDate5);
		System.out.println("--------------------------------dateResult=" + dateResult);
		System.out.println("--------------------------------dateTimeResult=" + dateTimeResult);
	}


}

