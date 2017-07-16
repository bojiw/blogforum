package com.blogforum.common.tools;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDCreateUtils {
	public static String getUUID() {
		String dateTime = DateUtils.formatDate(new Date(), "yyyyMMdd");
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		String ranEight = String.format("%08d", new Random().nextInt(99999999));
		return dateTime + uuid + ranEight;
	}

}
