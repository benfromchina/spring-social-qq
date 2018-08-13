package org.springframework.social.qq.api;

/**
 * QQ 的 OAuth2 接口返回的用户信息。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 * @see <a href="http://wiki.connect.qq.com/get_user_info">官方文档</a>
 */
public class QQUserInfo {
	
	private String openId;
	
	/**
	 * 返回码
	 */
	private Integer ret;
	
	/**
	 * 如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
	 */
	private String msg;
	
	/**
	 * {未知参数，官方文档未定义}
	 */
	private Integer is_lost;
	
	/**
	 * 用户在QQ空间的昵称。
	 */
	private String nickname;
	
	/**
	 * 性别。 如果获取不到则默认返回"男"
	 */
	private String gender;
	
	/**
	 * 省份
	 */
	private String province;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 出生年度
	 */
	private String year;
	
	/**
	 * {未知参数，官方文档未定义}
	 */
	private String constellation;
	
	/**
	 * 大小为30×30像素的QQ空间头像URL。
	 */
	private String figureurl;
	
	/**
	 * 大小为50×50像素的QQ空间头像URL。
	 */
	private String figureurl_1;
	
	/**
	 * 大小为100×100像素的QQ空间头像URL。
	 */
	private String figureurl_2;
	
	/**
	 * 大小为40×40像素的QQ头像URL。
	 */
	private String figureurl_qq_1;
	
	/**
	 * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
	 */
	private String figureurl_qq_2;
	
	/**
	 * 标识用户是否为黄钻用户（0：不是；1：是）。
	 */
	private String is_yellow_vip;
	
	/**
	 * 标识用户是否为黄钻用户（0：不是；1：是）
	 */
	private String vip;
	
	/**
	 * 黄钻等级
	 */
	private String yellow_vip_level;
	
	/**
	 * 黄钻等级
	 */
	private String level;
	
	/**
	 * 标识是否为年费黄钻用户（0：不是； 1：是）
	 */
	private String is_yellow_year_vip;
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getIs_lost() {
		return is_lost;
	}

	public void setIs_lost(Integer is_lost) {
		this.is_lost = is_lost;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getFigureurl() {
		return figureurl;
	}

	public void setFigureurl(String figureurl) {
		this.figureurl = figureurl;
	}

	public String getFigureurl_1() {
		return figureurl_1;
	}

	public void setFigureurl_1(String figureurl_1) {
		this.figureurl_1 = figureurl_1;
	}

	public String getFigureurl_2() {
		return figureurl_2;
	}

	public void setFigureurl_2(String figureurl_2) {
		this.figureurl_2 = figureurl_2;
	}

	public String getFigureurl_qq_1() {
		return figureurl_qq_1;
	}

	public void setFigureurl_qq_1(String figureurl_qq_1) {
		this.figureurl_qq_1 = figureurl_qq_1;
	}

	public String getFigureurl_qq_2() {
		return figureurl_qq_2;
	}

	public void setFigureurl_qq_2(String figureurl_qq_2) {
		this.figureurl_qq_2 = figureurl_qq_2;
	}

	public String getIs_yellow_vip() {
		return is_yellow_vip;
	}

	public void setIs_yellow_vip(String is_yellow_vip) {
		this.is_yellow_vip = is_yellow_vip;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getYellow_vip_level() {
		return yellow_vip_level;
	}

	public void setYellow_vip_level(String yellow_vip_level) {
		this.yellow_vip_level = yellow_vip_level;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIs_yellow_year_vip() {
		return is_yellow_year_vip;
	}

	public void setIs_yellow_year_vip(String is_yellow_year_vip) {
		this.is_yellow_year_vip = is_yellow_year_vip;
	}
	
}
