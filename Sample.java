package com.kh.display.model.vo;

/*
 *  디스플레이 객체
 *  	- 속성(멤버 변수)
 *  		- 크기(가로, 세로, 인치), 무게, 해상도, 밝기, 색조, 명암, 디스플레이 종류(LCD, LED, OLED 등...) 등
 *  	- 기능(메서드)
 *  		- 전원on/off, 해상도 변경(1920x1080, 1680x1050, 1600x900 등), 밝기 조정, 색조 조정, 명암 조절
 */

class Display {
	private double width;
	private double height;
	private int inch;
	private double weight;
	public String 해상도;
	public int 밝기;
	public int 색조;
	public int 명암;
	private String displayType;
	
	private Display() {
		this.inch = 27;
		this.해상도 = "1929x1080";
	}
	
	public Display(double width, double height, double weight, String displayType) {
		this();
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.displayType = displayType;
	}
	
	public Display(double width, double height, int inch, double weight, String 해상도, String displayType) {
		this(width, height, weight, displayType);
		this.inch = inch;
		this.해상도 = 해상도;
		
	}
	
	public String getDisplayType() {
		return this.displayType;
	}
	
	public void setDisplayType(String type) {
		System.out.println("택배로 제품을 보내주시면 변경해 드리겠습니다.");
		if(type.equals("LCD")) {
			System.out.println("3일 소요 됩니다.");
		} else if(type.equals("LED")) {
			System.out.println("5일 소요 됩니다.");
		} else if(type.equals("OLED")) {
			System.out.println("7일 소요 됩니다.");
			this.displayType = type;
		} else {
			System.out.println("해당 디스플레이로는 변경할 수 없습니다.");
		}	
	}
}

public class Sample {

	public static void main(String[] args) {
		Display dp = new Display(32.5, 24.0, 32, 3.7, "4k", "OLED");
		System.out.println("displayType : " + dp.getDisplayType());
		dp.setDisplayType("TFT");
		System.out.println("displayType : " + dp.getDisplayType());
//		System.out.println("해상도 : " + dp.해상도);		System.out.println("width : " + dp.width);
//		System.out.println("inch : " + dp.inch);		System.out.println("height : " + dp.height);
//		System.out.println("weight : " + dp.weight);	System.out.println("displayType : " + dp.displayType);
		System.out.println("밝기 : " + dp.밝기);			System.out.println("명암 : " + dp.명암);
		System.out.println("색조 : " + dp.색조);
	}

}
