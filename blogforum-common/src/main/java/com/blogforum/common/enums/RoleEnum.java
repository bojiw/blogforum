package com.blogforum.common.enums;

public enum RoleEnum {
	SUPER_ADMIN("超级管理员", 1), ADVANCED_ADMIN("高级管理员", 2), BLOG_ADMIN("博客管理员", 3), ADVANCED_USER("高级用户", 4);

	private String name;
	private int index;

	private RoleEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public static int getIndex(String name) {
		for (RoleEnum roleEnum : RoleEnum.values()) {
			if (roleEnum.name == name) {
				return roleEnum.index;
			}
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
