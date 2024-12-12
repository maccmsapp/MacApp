# App For MacCMS

* **应用名称**： 空壳影视
* **说明文档**： docs.mac-cms.com  
* **应用描述**： 为MacCms开发的影视资源播放容器App，支持Android手机、平板、电视、投影仪等设备。
* **使用帮助**： 下载安装后，打开应用，配置影视源即可看到影视资源。更多帮助请访问: [https://www.mac-cms.com/](https://www.mac-cms.com/)
* **接口类型**： 支持各种资源采集站的API接口，也可以通过自己搭建的MacCms接口将多个资源站整合到一起。电视直播IPTV为m3u格式

## 下载安装

* [下载地址: https://www.mac-cms.com/](https://www.mac-cms.com/)

## 应用截图 (以电视截图为例。手机平板等类似。)
![空壳影视首页](https://mac-cms.com/images/home.jpg)
![空壳影视列表](https://mac-cms.com/images/categories.jpg)
![空壳影视电视直播](https://mac-cms.com/images/tv_ipv4.jpg)
![空壳影视详情](https://mac-cms.com/images/episode.jpg)
![空壳影视播放](https://mac-cms.com/images/player.jpg)


## 接口配置

* [配置示例: https://github.com/maccmsapp/maccms_app_config](https://github.com/maccmsapp/maccms_app_config)
* [示例配置: https://ghp.ci/https://raw.githubusercontent.com/maccmsapp/maccms_app_config/refs/heads/main/config.json](https://ghp.ci/https://raw.githubusercontent.com/maccmsapp/maccms_app_config/refs/heads/main/config.json)

### 配置说明

### 为何需要隐私码？
  > 仅电视需要使用隐私模式，其他设备不需要。  
  > 部分用户的电视是客厅公用设备,使用的人不确定,部分影视资源不太适合显示出来。  
  > 只有当输入了隐私码后才会显示。  
  > 关机后再开机仍然需要输入隐私码，确保不尴尬。  
  > 客厅模式下观看记录同样不会显示隐私内容。

### 隐私码配置方法:
>  1. 打开电视端App，点击首页右上角的"设置"按钮。  
>  2. 点击"观看模式"，使用微信小程序扫描二维码输入发送隐私码。

![privateKey](https://mac-cms.com/images/private_mode.jpg)
![privateKey](https://mac-cms.com/images/mp.jpg)

**注意：手机和电视要处在同一WIFI局域网内。**


* 接口配置为JSON格式，具体格式如下：
  > 更多帮助说明请访问:[https://www.mac-cms.com/](https://www.mac-cms.com/)

  ```{
      "privateKey": "404",
      //向电视上发送该值，打开隐私模式，显示电视台block=true的资源和影视资源里的默认屏蔽的blockTypeIds分类。因为电视是公用设备，所以需要默认屏蔽一些不适合所有人观看的资源。
      //每次打开应用时，都需要向电视发送该值，防止忘记关闭隐私模式导致的尴尬。
      
      "tvSources": [
      //电视直播源配置，可以配置多个电视源。
          {
              "name": "IPTV 1 [IPV6]",
              "m3uUrl": "https://ghp.ci/https://raw.githubusercontent.com/vicjl/myIPTV/refs/heads/main/IPTV.m3u",
              //须为m3u8格式
              
              "block": false
              //是否屏蔽该资源，true屏蔽，false不屏蔽。
          },
          //......更多电视源配置
      ],
        
      "sources": [
      //影视源配置，可以配置多个影视源。
      
          {
              "name": "量子资源",
              "url": "https://cj.lziapi.com/api.php/provide/vod/from/lzm3u8",
              //接口地址如上，返回数据格式须为json。
              //比如资源站提供的采集接口为：https://cj.lziapi.com/api.php/provide/vod/from/lzm3u8/at/xml/
              //一般json对应的接口就是去掉at/xml/
              
              "playerName": {
                  "lzm3u8": "量子"
              },
              //支持多个。用于区分自建接口的资源来源。对应Maccms内的播放器名称。
              
              "blockTypeIds": [
                  41,
                  42,
                  43
              ],
              //屏蔽分类，不填则不屏蔽。
              //分类ID以逗号分隔
              //电视端输入privateKey后，该分类将会正常显示。
              
              "blockAdsRule": [
                  "#EXTINF:5\\.700000[\\s\\S]*?#EXTINF:3.633333,[\\r\\n]+.*"
              ],
              //屏蔽m3u8文件里的广告规则，不填则不屏蔽。
              //正则表达式，匹配到该规则的ts片断将会被删除。
              
              "desc": "资源较全"
          },
          //......更多资源站配置
      ]
  }
  ```

## 声明

* **本应用仅供学习交流使用，请勿用于商业用途。**
* **请遵守法律法规，下载安装本应用。**
* **本应用不存储及提供任何影视资源。**
* **所有信息来源公共互联网，请自行判断是否合法。**