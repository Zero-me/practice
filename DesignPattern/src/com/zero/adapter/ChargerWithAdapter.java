package com.zero.adapter;

public class ChargerWithAdapter implements Targetable{
	
	private Charger charge;
	
	@Override
	public void charging4Android() {
		charge.Charging4Android();
	}

	@Override
	public void charging4IOS() {
		 System.out.println("我正在充苹果手机的电");
	}
	
	
	public ChargerWithAdapter(Charger charge) {
		this.charge = charge;
	}
	
	
}
