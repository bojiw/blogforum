package com.blogforum.common.tools;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDCreateUtils {
	public static String getUUID() {
		StringBuffer uuid = new StringBuffer();
		uuid.append(DateUtils.formatDate(new Date(), "yyyyMMdd"))
							.append(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase())
							.append(String.format("%08d", new Random().nextInt(99999999)));
		return uuid.toString();
	}

}
