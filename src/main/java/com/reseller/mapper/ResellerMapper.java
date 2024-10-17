package com.reseller.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reseller.model.AppCampaignDetails;
import com.reseller.model.AppTrafficServiceInfo;
import com.reseller.model.Operator;
import com.reseller.model.Partner;
import com.reseller.model.Promoter;
import com.reseller.model.SwitchingCampaign;
import com.reseller.model.Territory;
import com.reseller.model.User;

public interface ResellerMapper {

	@Select("select * from apptrafficserviceinfo")
	public List<AppTrafficServiceInfo> listAllAppTrafficServiceInfo();

	@Select("select * from operator")
	public List<Operator> listAllOperator();

	@Select("select * from territory")
	public List<Territory> listAllTerritory();

	@Select("select * from promoter")
	public List<Promoter> listAllPromoter();

	@Select("select * from partner")
	public List<Partner> listAllPartner();

	@Select("select * from app_campaigndetails")
	public List<AppCampaignDetails> listAllAppCampaignDetails();

	@Select("select * from apptrafficserviceinfo where id = #{id}")
	public AppTrafficServiceInfo getAppTrafficServiceInfo(int id);

	@Select("select * from operator where id = #{id}")
	public Operator getOperator(int id);

	@Select("select * from territory where id = #{id}")
	public Territory getTerritory(int id);

	@Select("select * from promoter where id = #{id}")
	public Promoter getPromoter(int id);

	@Select("select * from partner where id = #{id}")
	public Partner getPartner(int id);

	@Select("select * from app_campaigndetails where id = #{id}")
	public AppCampaignDetails getAppCampaignDetails(int id);

	@Insert("insert into apptrafficserviceinfo(servicename,addtime,edittime,optimizePerc,optimizeFlag,associationType,price,bidrate,partnerid,PromoterName,operatorid,service) values(#{servicename},#{addtime},#{edittime},#{optimizePerc},#{optimizeFlag},#{associationType},#{price},#{bidrate},#{partnerid},#{promoterName},#{operatorid},#{service});")
	public int insertAppTrafficServiceInfo(AppTrafficServiceInfo appTrafficServiceInfo);

	@Insert("insert into operator(name,addtime,edittime,territoryid,initials) values(#{name},#{addtime},#{edittime},#{territoryid},#{initials});")
	public int insertOperator(Operator operator);

	@Insert("insert into territory(name,addtime,edittime,initials) values(#{name},#{addtime},#{edittime},#{initials});")
	public int insertTerritory(Territory territory);

	@Insert("insert into promoter(name,addtime,edittime,initials) values(#{name},#{addtime},#{edittime},#{initials});")
	public int insertPromoter(Promoter promoter);

	@Insert("insert into partner(name,addtime,edittime,initials) values(#{name},#{addtime},#{edittime},#{initials});")
	public int insertPartner(Partner partner);

	@Insert("insert into app_campaigndetails(campaign_name,operatorid,shortcode,pinlength,price,validity,partnerid,territoryid,keyword,initials) values(#{campaign_name},#{operatorid},#{shortcode},#{pinlength},#{price},#{validity},#{partnerid},#{territoryid},#{keyword},#{initials});")
	public int insertAppCampaignDetails(AppCampaignDetails appCampaignDetails);

	@Update("update apptrafficserviceinfo set servicename=#{servicename}, addtime=#{addtime}, edittime=#{edittime}, optimizePerc=#{optimizePerc}, price=#{price}, bidrate=#{bidrate}, partnerid=#{partnerid}, PromoterName=#{promoterName}, operatorid=#{operatorid}, service=#{service} where id=#{id}")
	public int updateAppTrafficServiceInfo(AppTrafficServiceInfo appTrafficServiceInfo);

	@Update("update operator set name=#{name}, addtime=#{addtime}, edittime=#{edittime}, territoryid=#{territoryid}, initials=#{initials} where id=#{id}")
	public int updateOperator(Operator operator);

	@Update("update territory set name=#{name}, addtime=#{addtime}, edittime=#{edittime}, initials=#{initials} where id=#{id}")
	public int updateTerritory(Territory territory);

	@Update("update promoter set name=#{name}, edittime=#{edittime}, initials=#{initials} where id=#{id}")
	public int updatePromoter(Promoter promoter);

	@Update("update partner set name=#{name}, edittime=#{edittime}, initials=#{initials} where id=#{id}")
	public int updatePartner(Partner partner);

	@Update("update app_campaigndetails set campaign_name=#{campaign_name}, operatorid=#{operatorid}, shortcode=#{shortcode}, pinlength=#{pinlength}, price=#{price}, validity=#{validity}, partnerid=#{partnerid}, territoryid=#{territoryid}, keyword=#{keyword}, initials=#{initials} where id=#{id}")
	public int updateAppCampaignDetails(AppCampaignDetails appCampaignDetails);

	@Select("select initials from partner where id = #{id}")
	public String getPartnerById(int id);

	@Insert("insert into users(username,email,password) values(#{username},#{email},#{password});")
	public int insertUser(User user);

	@Insert("insert into authorities(username,authority) values(#{username},'ROLE_USER');")
	public int insertAuthority(String username);

	@Select("select * from operator where territoryid = #{territoryid}")
	public List<Operator> getOperatorByTerritoryId(int territoryid);

	@Select("select * from app_campaigndetails where operatorid = #{operatorid}")
	public List<AppCampaignDetails> getAppCampaignByOperatorId(int operatorid);

	@Select("select * from app_campaigndetails where operatorid = #{operatorid} and partnerid = #{partnerid} and territoryid = #{territoryid}")
	public AppCampaignDetails getCampaignDetails(@Param("operatorid") int operatorid, @Param("partnerid") int partnerid,
			@Param("territoryid") int territoryid);

	@Select("select * from switchingCampaign")
	public List<SwitchingCampaign> listAllSwitchingCampaign();

	@Select("select * from switchingCampaign where id = #{id}")
	public SwitchingCampaign getSwitchingCampaign(int id);

	@Insert("insert into switchingCampaign(switchingName,status,addtime,edittime,switchingCampId,switchingCampCap,switchingCampId_1,switchingCampCap_1,switchingCampId_2,createdBy,operatorid,switchBaseCampaignFlag,switchCampaignFlag_1) values(#{switchingName},#{status},#{addtime},#{edittime},#{switchingCampId},#{switchingCampCap},#{switchingCampId_1},#{switchingCampCap_1},#{switchingCampId_2},#{createdBy},#{operatorid},#{switchBaseCampaignFlag},#{switchCampaignFlag_1});")
	public int insertSwitchingCampaign(SwitchingCampaign switchingCampaign);

	@Update("update switchingCampaign set switchingName=#{switchingName}, edittime=#{edittime}, switchingCampId=#{switchingCampId}, switchingCampCap=#{switchingCampCap}, switchingCampId_1=#{switchingCampId_1}, switchingCampCap_1=#{switchingCampCap_1}, switchingCampId_2=#{switchingCampId_2}, operatorid=#{operatorid}, switchBaseCampaignFlag=#{switchBaseCampaignFlag}, switchCampaignFlag_1=#{switchCampaignFlag_1} where id=#{id}")
	public int updateSwitchingCampaign(SwitchingCampaign switchingCampaign);

	@Select("select * from apptrafficserviceinfo where operatorid = #{operatorid} and PromoterName = #{PromoterName}")
	public List<AppTrafficServiceInfo> getATSInfoByIds(@Param("operatorid") int operatorid,
			@Param("PromoterName") String PromoterName);
}
