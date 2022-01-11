package cn.binarywang.wx.miniapp.bean;

import me.chanjar.weixin.common.api.WxConsts;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Test
public class WxMaMessageTest {

  public void testFromXml() {
    String xml = "<xml>\n" +
      "   <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
      "   <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
      "   <CreateTime>1482048670</CreateTime>\n" +
      "   <MsgType><![CDATA[text]]></MsgType>\n" +
      "   <Content><![CDATA[this is a test]]></Content>\n" +
      "   <MsgId>1234567890123456</MsgId>\n" +
      "   <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
      "   <MediaId><![CDATA[media_id]]></MediaId>\n" +
      "   <Title><![CDATA[Title]]></Title>\n" +
      "   <AppId><![CDATA[AppId]]></AppId>\n" +
      "   <PagePath><![CDATA[PagePath]]></PagePath>\n" +
      "   <ThumbUrl><![CDATA[ThumbUrl]]></ThumbUrl>\n" +
      "   <ThumbMediaId><![CDATA[ThumbMediaId]]></ThumbMediaId>\n" +
      "   <Event><![CDATA[user_enter_tempsession]]></Event>\n" +
      "   <SessionFrom><![CDATA[sessionFrom]]></SessionFrom>\n" +
      "</xml>";
    WxMaMessage wxMessage = WxMaMessage.fromXml(xml);
    assertEquals(wxMessage.getToUser(), "toUser");
    assertEquals(wxMessage.getFromUser(), "fromUser");
    assertEquals(wxMessage.getCreateTime(),new Integer(1482048670));
    assertEquals(wxMessage.getMsgType(), WxConsts.XmlMsgType.TEXT);
    assertEquals(wxMessage.getContent(), "this is a test");
    assertEquals(wxMessage.getMsgId(), new Long(1234567890123456L));
    assertEquals(wxMessage.getPicUrl(), "this is a url");
    assertEquals(wxMessage.getMediaId(), "media_id");
    assertEquals(wxMessage.getTitle(), "Title");
    assertEquals(wxMessage.getPagePath(), "PagePath");
    assertEquals(wxMessage.getThumbUrl(), "ThumbUrl");
    assertEquals(wxMessage.getThumbMediaId(), "ThumbMediaId");
    assertEquals(wxMessage.getAppId(), "AppId");
    assertEquals(wxMessage.getEvent(), "user_enter_tempsession");
    assertEquals(wxMessage.getSessionFrom(), "sessionFrom");
  }

  public void testSubscribeMsgPopupEvent() {
    // xml 格式
    String xml = "<xml>" +
      "<ToUserName><![CDATA[gh_123456789abc]]></ToUserName>\n" +
      "<FromUserName><![CDATA[otFpruAK8D-E6EfStSYonYSBZ8_4]]></FromUserName>\n" +
      "<CreateTime>1610969440</CreateTime>\n" +
      "<MsgType><![CDATA[event]]></MsgType>\n" +
      "<Event><![CDATA[subscribe_msg_popup_event]]></Event>\n" +
      "<SubscribeMsgPopupEvent>\n" +
      " <List>\n" +
      "   <TemplateId><![CDATA[VRR0UEO9VJOLs0MHlU0OilqX6MVFDwH3_3gz3Oc0NIc]]></TemplateId>\n" +
      "   <SubscribeStatusString><![CDATA[accept]]></SubscribeStatusString>\n" +
      "   <PopupScene>0</PopupScene>\n" +
      " </List>\n" +
      "</SubscribeMsgPopupEvent>" +
      "</xml>";

    WxMaMessage wxMessage = WxMaMessage.fromXml(xml);
    checkSubscribeMsgPopupEvent(wxMessage);

    // 订阅单个模板  json格式 (对象）
    String json = "{\n" +
      "  \"ToUserName\": \"gh_123456789abc\",\n" +
      "  \"FromUserName\": \"otFpruAK8D-E6EfStSYonYSBZ8_4\",\n" +
      "  \"CreateTime\": \"1610969440\",\n" +
      "  \"MsgType\": \"event\",\n" +
      "  \"Event\": \"subscribe_msg_popup_event\",\n" +
      "  \"List\": {\n" +
      "        \"TemplateId\": \"VRR0UEO9VJOLs0MHlU0OilqX6MVFDwH3_3gz3Oc0NIc\",\n" +
      "        \"SubscribeStatusString\": \"accept\",\n" +
      "        \"PopupScene\": \"0\"\n" +
      "    }\n" +
      " }";
    wxMessage = WxMaMessage.fromJson(json);
    checkSubscribeMsgPopupEvent(wxMessage);
    // 订阅多条模板的  json格式（数组）
    json = "{\n" +
      "  \"ToUserName\": \"gh_123456789abc\",\n" +
      "  \"FromUserName\": \"otFpruAK8D-E6EfStSYonYSBZ8_4\",\n" +
      "  \"CreateTime\": \"1610969440\",\n" +
      "  \"MsgType\": \"event\",\n" +
      "  \"Event\": \"subscribe_msg_popup_event\",\n" +
      "  \"List\": [{\n" +
      "        \"TemplateId\": \"VRR0UEO9VJOLs0MHlU0OilqX6MVFDwH3_3gz3Oc0NIc\",\n" +
      "        \"SubscribeStatusString\": \"accept\",\n" +
      "        \"PopupScene\": \"0\"\n" +
      "    }]\n" +
      " }";
    wxMessage = WxMaMessage.fromJson(json);
    checkSubscribeMsgPopupEvent(wxMessage);
  }

  private void checkSubscribeMsgPopupEvent(WxMaMessage wxMessage) {
    assertEquals(wxMessage.getToUser(), "gh_123456789abc");
    assertEquals(wxMessage.getFromUser(), "otFpruAK8D-E6EfStSYonYSBZ8_4");
    assertEquals(wxMessage.getCreateTime(),new Integer(1610969440));
    assertEquals(wxMessage.getMsgType(), WxConsts.XmlMsgType.EVENT);
    assertEquals(wxMessage.getEvent(), "subscribe_msg_popup_event");
    assertEquals(wxMessage.getSubscribeMsgPopupEvent().getList().size(), 1);
    WxMaSubscribeMsgEvent.PopupEvent event = wxMessage.getSubscribeMsgPopupEvent().getList().get(0);
    assertEquals(event.getTemplateId(), "VRR0UEO9VJOLs0MHlU0OilqX6MVFDwH3_3gz3Oc0NIc");
    assertEquals(event.getSubscribeStatusString(),"accept");
    assertEquals(event.getPopupScene(), "0");
  }

  public void testSubscribeMsgChangeEvent() {
    // xml 格式
    String xml = "<xml>\n" +
      "    <ToUserName><![CDATA[gh_123456789abc]]></ToUserName>\n" +
      "    <FromUserName><![CDATA[o7esq5OI1Uej6Xixw1lA2H7XDVbc]]></FromUserName>\n" +
      "    <CreateTime>1610968440</CreateTime>\n" +
      "    <MsgType><![CDATA[event]]></MsgType>\n" +
      "    <Event><![CDATA[subscribe_msg_change_event]]></Event>\n" +
      "    <SubscribeMsgChangeEvent>\n" +
      "        <List>" +
      "             <TemplateId><![CDATA[BEwX0BOT3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8]]></TemplateId>\n" +
      "            <SubscribeStatusString><![CDATA[reject]]></SubscribeStatusString>\n" +
      "        </List>\n" +
      "    </SubscribeMsgChangeEvent>\n" +
      "</xml>";

    WxMaMessage wxMessage = WxMaMessage.fromXml(xml);
    checkSubscribeMsgChangeEvent(wxMessage);

    // json格式 (对象）
    String json = "{\n" +
      "      \"ToUserName\": \"gh_123456789abc\",\n" +
      "      \"FromUserName\": \"o7esq5OI1Uej6Xixw1lA2H7XDVbc\",\n" +
      "      \"CreateTime\": \"1610968440\",\n" +
      "      \"MsgType\": \"event\",\n" +
      "      \"Event\": \"subscribe_msg_change_event\",\n" +
      "      \"List\": {\n" +
      "                \"TemplateId\":\"BEwX0BOT3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8\",\n" +
      "                \"SubscribeStatusString\": \"reject\"\n" +
      "      }\n" +
      "}\n";
    wxMessage = WxMaMessage.fromJson(json);
    checkSubscribeMsgChangeEvent(wxMessage);
    // json格式（数组）
    json = "{\n" +
      "      \"ToUserName\": \"gh_123456789abc\",\n" +
      "      \"FromUserName\": \"o7esq5OI1Uej6Xixw1lA2H7XDVbc\",\n" +
      "      \"CreateTime\": \"1610968440\",\n" +
      "      \"MsgType\": \"event\",\n" +
      "      \"Event\": \"subscribe_msg_change_event\",\n" +
      "      \"List\": [  {\n" +
      "                \"TemplateId\":\"BEwX0BOT3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8\",\n" +
      "                \"SubscribeStatusString\": \"reject\"\n" +
      "      }]" +
      "}";
    wxMessage = WxMaMessage.fromJson(json);
    checkSubscribeMsgChangeEvent(wxMessage);
  }

  private void checkSubscribeMsgChangeEvent(WxMaMessage wxMessage) {
    assertEquals(wxMessage.getToUser(), "gh_123456789abc");
    assertEquals(wxMessage.getFromUser(), "o7esq5OI1Uej6Xixw1lA2H7XDVbc");
    assertEquals(wxMessage.getCreateTime(),new Integer(1610968440));
    assertEquals(wxMessage.getMsgType(), WxConsts.XmlMsgType.EVENT);
    assertEquals(wxMessage.getEvent(), "subscribe_msg_change_event");
    assertEquals(wxMessage.getSubscribeMsgChangeEvent().getList().size(), 1);
    WxMaSubscribeMsgEvent.ChangeEvent event = wxMessage.getSubscribeMsgChangeEvent().getList().get(0);
    assertEquals(event.getTemplateId(), "BEwX0BOT3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8");
    assertEquals(event.getSubscribeStatusString(),"reject");
  }

  public void testSubscribeMsgSentEvent() {
    // xml 格式
    String xml = "<xml>\n" +
      "    <ToUserName><![CDATA[gh_123456789abc]]></ToUserName>\n" +
      "    <FromUserName><![CDATA[o7esq5PHRGBQYmeNyfG064wEFVpQ]]></FromUserName>\n" +
      "    <CreateTime>1620963428</CreateTime>\n" +
      "    <MsgType><![CDATA[event]]></MsgType>\n" +
      "    <Event><![CDATA[subscribe_msg_sent_event]]></Event>\n" +
      "    <SubscribeMsgSentEvent>\n" +
      "        <List>" +
      "             <TemplateId><![CDATA[BEwX0BO-T3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8]]></TemplateId>\n" +
      "            <MsgID>1864323726461255680</MsgID>\n" +
      "            <ErrorCode>0</ErrorCode>\n" +
      "            <ErrorStatus><![CDATA[success]]></ErrorStatus>\n" +
      "        </List>\n" +
      "    </SubscribeMsgSentEvent>\n" +
      "</xml>";

    WxMaMessage wxMessage = WxMaMessage.fromXml(xml);
    checkSubscribeMsgSentEvent(wxMessage);

    // json格式 (对象）
    String json = "{\n" +
      "    \"ToUserName\": \"gh_123456789abc\",\n" +
      "    \"FromUserName\": \"o7esq5PHRGBQYmeNyfG064wEFVpQ\",\n" +
      "    \"CreateTime\": \"1620963428\",\n" +
      "    \"MsgType\": \"event\",\n" +
      "    \"Event\": \"subscribe_msg_sent_event\",\n" +
      "    \"List\": {\n" +
      "        \"TemplateId\": \"BEwX0BO-T3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8\",\n" +
      "        \"MsgID\": \"1864323726461255680\",\n" +
      "        \"ErrorCode\": \"0\",\n" +
      "        \"ErrorStatus\": \"success\"\n" +
      "      }\n" +
      "}";
    wxMessage = WxMaMessage.fromJson(json);
    checkSubscribeMsgSentEvent(wxMessage);
  }
  private void checkSubscribeMsgSentEvent(WxMaMessage wxMessage) {
    assertEquals(wxMessage.getToUser(), "gh_123456789abc");
    assertEquals(wxMessage.getFromUser(), "o7esq5PHRGBQYmeNyfG064wEFVpQ");
    assertEquals(wxMessage.getCreateTime(),new Integer(1620963428));
    assertEquals(wxMessage.getMsgType(), WxConsts.XmlMsgType.EVENT);
    assertEquals(wxMessage.getEvent(), "subscribe_msg_sent_event");
    assertNotNull(wxMessage.getSubscribeMsgSentEvent());
    WxMaSubscribeMsgEvent.SentEvent event = wxMessage.getSubscribeMsgSentEvent().getList();
    assertEquals(event.getTemplateId(), "BEwX0BO-T3MqK3Uc5oTU3CGBqzjpndk2jzUf7VfExd8");
    assertEquals(event.getMsgId(),"1864323726461255680");
    assertEquals(event.getErrorCode(),"0");
    assertEquals(event.getErrorStatus(),"success");
  }

}
