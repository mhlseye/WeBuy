package com.wyd.seckill.redis;

public class SeckillUserKey extends BasePrefix{

	public static final int TOKEN_EXPIRE = 3600*24 * 2;
	private String prefix ;
	private SeckillUserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
		this.prefix = prefix;
	}
	public static SeckillUserKey token = new SeckillUserKey(TOKEN_EXPIRE, "tk");
	
	public static SeckillUserKey getById = new SeckillUserKey(0, "id");
	
	public SeckillUserKey withExpire(int seconds) {
		return new SeckillUserKey(seconds, prefix);
	}
}
