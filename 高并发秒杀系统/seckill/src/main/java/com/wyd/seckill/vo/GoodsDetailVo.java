package com.wyd.seckill.vo;

import com.wyd.seckill.domain.SeckillUser;

public class GoodsDetailVo {
	private int SeckillStatus = 0;
	private int remainSeconds = 0;
	private GoodsVo goods ;
	private SeckillUser user;
	public int getSeckillStatus() {
		return SeckillStatus;
	}
	public void setSeckillStatus(int SeckillStatus) {
		this.SeckillStatus = SeckillStatus;
	}
	public int getRemainSeconds() {
		return remainSeconds;
	}
	public void setRemainSeconds(int remainSeconds) {
		this.remainSeconds = remainSeconds;
	}
	public GoodsVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
	public SeckillUser getUser() {
		return user;
	}
	public void setUser(SeckillUser user) {
		this.user = user;
	}
}
