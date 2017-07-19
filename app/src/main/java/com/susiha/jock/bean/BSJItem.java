package com.susiha.jock.bean;

import java.io.Serializable;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/17 15:40 
 * update: 2017/7/17
*/

public class BSJItem implements Serializable {


    String create_time;//		创建时间
    String love;//		点赞的数量
    String hate;//		点踩的数量
    String height;//		图片高度
    String width;//		图片宽度
    String id;//		图片id
    String image0;//		0号图，数字越大，尺寸越大
    String image1;//		1号图
    String image2;//		2号图
    String image3;//		3号图
    String text;//		段子正文
    String type;//		类型

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getHate() {
        return hate;
    }

    public void setHate(String hate) {
        this.hate = hate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage0() {
        return image0;
    }

    public void setImage0(String image0) {
        this.image0 = image0;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideotime() {
        return videotime;
    }

    public void setVideotime(String videotime) {
        this.videotime = videotime;
    }

    public String getVideo_uri() {
        return video_uri;
    }

    public void setVideo_uri(String video_uri) {
        this.video_uri = video_uri;
    }

    public String getVoicelength() {
        return voicelength;
    }

    public void setVoicelength(String voicelength) {
        this.voicelength = voicelength;
    }

    public String getVoicetime() {
        return voicetime;
    }

    public void setVoicetime(String voicetime) {
        this.voicetime = voicetime;
    }

    public String getVoiceuri() {
        return voiceuri;
    }

    public void setVoiceuri(String voiceuri) {
        this.voiceuri = voiceuri;
    }

    public String getWeixin_url() {
        return weixin_url;
    }

    public void setWeixin_url(String weixin_url) {
        this.weixin_url = weixin_url;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    String videotime;//		视频时长
    String video_uri;//		视频url
    String voicelength;//		声音文件大小
    String voicetime;//		声音时长
    String voiceuri;//		声音url
    String weixin_url;//		微信链接地址
    String profile_image;//		用户头像
}
