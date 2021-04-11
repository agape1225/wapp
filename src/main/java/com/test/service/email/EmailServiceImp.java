package com.test.service.email;

import com.test.dao.LectureDao;
import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import java.io.File;

@Service
public class EmailServiceImp implements EmailService {


    @Autowired
    ServletContext servletContext;

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    LectureDao lectureDao;

    @Override
    public void sendMail(UserDto userInfo, String lecNo, String likesTime) {

        final String subject = "[CLASS 101] 찜하기 알림";
        final String from = "CLASS101";

        try {
            final MimeMessagePreparator preparator = new MimeMessagePreparator() {

                LectureDto lecInfo = lectureDao.readBasicDataByLecNo(lecNo);

                @Override public void prepare(MimeMessage mimeMessage) throws Exception {
                    final MimeMessageHelper helper =
                            new MimeMessageHelper(mimeMessage, true, "UTF-8");

                    String userNmae = userInfo.getUserName();
                    String lectureName = lecInfo.getLecName();

                    String text = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                            "  <head>\n" +
                            "    <title>WE MISS YOU!</title>\n" +
                            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0 \" />\n" +
                            "    <meta name=\"format-detection\" content=\"telephone=no\" />\n" +
                            "    <!--[if !mso]><!-->\n" +
                            "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700\" rel=\"stylesheet\" />\n" +
                            "    <!--<![endif]-->\n" +
                            "    <style type=\"text/css\">\n" +
                            "      body {\n" +
                            "      -webkit-text-size-adjust: 100% !important;\n" +
                            "      -ms-text-size-adjust: 100% !important;\n" +
                            "      -webkit-font-smoothing: antialiased !important;\n" +
                            "      }\n" +
                            "      img {\n" +
                            "      border: 0 !important;\n" +
                            "      outline: none !important;\n" +
                            "      }\n" +
                            "      p {\n" +
                            "      Margin: 0px !important;\n" +
                            "      Padding: 0px !important;\n" +
                            "      }\n" +
                            "      table {\n" +
                            "      border-collapse: collapse;\n" +
                            "      mso-table-lspace: 0px;\n" +
                            "      mso-table-rspace: 0px;\n" +
                            "      }\n" +
                            "      td, a, span {\n" +
                            "      border-collapse: collapse;\n" +
                            "      mso-line-height-rule: exactly;\n" +
                            "      }\n" +
                            "      .ExternalClass * {\n" +
                            "      line-height: 100%;\n" +
                            "      }\n" +
                            "      span.MsoHyperlink {\n" +
                            "      mso-style-priority:99;\n" +
                            "      color:inherit;}\n" +
                            "      span.MsoHyperlinkFollowed {\n" +
                            "      mso-style-priority:99;\n" +
                            "      color:inherit;}\n" +
                            "      </style>\n" +
                            "      <style media=\"only screen and (min-width:481px) and (max-width:599px)\" type=\"text/css\">\n" +
                            "      @media only screen and (min-width:481px) and (max-width:599px) {\n" +
                            "      table[class=em_main_table] {\n" +
                            "      width: 100% !important;\n" +
                            "      }\n" +
                            "      table[class=em_wrapper] {\n" +
                            "      width: 100% !important;\n" +
                            "      }\n" +
                            "      td[class=em_hide], br[class=em_hide] {\n" +
                            "      display: none !important;\n" +
                            "      }\n" +
                            "      img[class=em_full_img] {\n" +
                            "      width: 100% !important;\n" +
                            "      height: auto !important;\n" +
                            "      }\n" +
                            "      td[class=em_align_cent] {\n" +
                            "      text-align: center !important;\n" +
                            "      }\n" +
                            "      td[class=em_aside]{\n" +
                            "      padding-left:10px !important;\n" +
                            "      padding-right:10px !important;\n" +
                            "      }\n" +
                            "      td[class=em_height]{\n" +
                            "      height: 20px !important;\n" +
                            "      }\n" +
                            "      td[class=em_font]{\n" +
                            "      font-size:14px !important;\n" +
                            "      }\n" +
                            "      td[class=em_align_cent1] {\n" +
                            "      text-align: center !important;\n" +
                            "      padding-bottom: 10px !important;\n" +
                            "      }\n" +
                            "      }\n" +
                            "      </style>\n" +
                            "      <style media=\"only screen and (max-width:480px)\" type=\"text/css\">\n" +
                            "      @media only screen and (max-width:480px) {\n" +
                            "      table[class=em_main_table] {\n" +
                            "      width: 100% !important;\n" +
                            "      }\n" +
                            "      table[class=em_wrapper] {\n" +
                            "      width: 100% !important;\n" +
                            "      }\n" +
                            "      td[class=em_hide], br[class=em_hide], span[class=em_hide] {\n" +
                            "      display: none !important;\n" +
                            "      }\n" +
                            "      img[class=em_full_img] {\n" +
                            "      width: 100% !important;\n" +
                            "      height: auto !important;\n" +
                            "      }\n" +
                            "      td[class=em_align_cent] {\n" +
                            "      text-align: center !important;\n" +
                            "      }\n" +
                            "      td[class=em_height]{\n" +
                            "      height: 20px !important;\n" +
                            "      }\n" +
                            "      td[class=em_aside]{\n" +
                            "      padding-left:10px !important;\n" +
                            "      padding-right:10px !important;\n" +
                            "      }\n" +
                            "      td[class=em_font]{\n" +
                            "      font-size:14px !important;\n" +
                            "      line-height:28px !important;\n" +
                            "      }\n" +
                            "      span[class=em_br]{\n" +
                            "      display:block !important;\n" +
                            "      }\n" +
                            "      td[class=em_font1]{\n" +
                            "      font-size:32px !important;\n" +
                            "      line-height:35px !important;\n" +
                            "      }\n" +
                            "      td[class=em_align_cent1] {\n" +
                            "      text-align: center !important;\n" +
                            "      padding-bottom: 10px !important;\n" +
                            "      }\n" +
                            "      }\n" +
                            "    </style>\n" +
                            "  </head>\n" +
                            "  <body style=\"margin:0px; padding:0px;\" bgcolor=\"#ffffff\">\n" +
                            "    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\n" +
                            "     <!-- === PRE HEADER SECTION=== -->\n" +
                            "      <tr>\n" +
                            "        <td align=\"center\" valign=\"top\"  bgcolor=\"#30373b\">\n" +
                            "          <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" class=\"em_main_table\" style=\"table-layout:fixed;\">\n" +
                            "            <tr>\n" +
                            "              <td style=\"line-height:0px; font-size:0px;\" width=\"600\" class=\"em_hide\" bgcolor=\"#30373b\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/spacer.gif\" height=\"1\"  width=\"600\" style=\"max-height:1px; min-height:1px; display:block; width:600px; min-width:600px;\" border=\"0\" alt=\"\" /></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td valign=\"top\">\n" +
                            "                <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" class=\"em_wrapper\">\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"10\" class=\"em_height\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td valign=\"top\">\n" +
                            "                      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                        <tr>\n" +
                            "                          <td valign=\"top\">\n" +
                            "                          </td>\n" +
                            "                        </tr>\n" +
                            "                      </table>\n" +
                            "                    </td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"10\" class=\"em_height\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                </table>\n" +
                            "              </td>\n" +
                            "            </tr>\n" +
                            "          </table>\n" +
                            "        </td>\n" +
                            "      </tr>\n" +
                            "      <!-- === //PRE HEADER SECTION=== -->\n" +
                            "      <!-- === BOSY === -->\n" +
                            "      <tr>\n" +
                            "        <td align=\"center\" valign=\"top\"  bgcolor=\"#ffffff\">\n" +
                            "          <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" class=\"em_main_table\" style=\"table-layout:fixed;\">\n" +
                            "            <!-- === LOGO SECTION === -->\n" +
                            "            <tr>\n" +
                            "              <td height=\"40\" class=\"em_height\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td align=\"center\"><a href=\"#\" target=\"_blank\" style=\"text-decoration:none;\">" +
                            "               <img src='cid:Logoimg' width=\"400\" height=\"60\" style=\"display:block;font-family: Arial, sans-serif; font-size:15px; line-height:18px; color:#30373b;  font-weight:bold;\" border=\"0\" alt=\"LoGo Here\" />" +
                            "               </a></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"30\" class=\"em_height\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <!-- === //LOGO SECTION === -->\n" +
                            "            <!-- === NEVIGATION SECTION === -->\n" +
                            "            <tr>\n" +
                            "              <td height=\"1\" bgcolor=\"#fed69c\" style=\"font-size:0px; line-height:0px;\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/spacer.gif\" width=\"1\" height=\"1\" /></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"14\" style=\"font-size:1px; line-height:1px;\" >&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:25px; line-height:18px; color:#30373b; text-transform:uppercase; font-weight:bold;\" class=\"em_font\">\n" +
                            "                <!-- <a href=\"#\" target=\"_blank\" style=\"text-decoration:none; color:#30373b;\">home</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"#\" target=\"_blank\" style=\"text-decoration:none; color:#30373b;\">new product</a><span class=\"em_hide\"> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span><span class=\"em_br\"></span><a href=\"#\" target=\"_blank\" style=\"text-decoration:none; color:#30373b;\">catalogue</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"#\" target=\"_blank\" style=\"text-decoration:none; color:#30373b;\">contact us</a>\n" +
                            "                target=\"_blank\" style=\"text-decoration:none; color:#30373b;\" -->\n" +
                            "                <p target=\"_blank\" style=\"text-decoration:none; color:#30373b;\">" + userNmae +
                            "                 님 저희 사이트를 이용해주셔서 감사합니다.</p>\n" +
                            "              </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"14\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"1\" bgcolor=\"#fed69c\" style=\"font-size:0px; line-height:0px;\"><img src=\"https://www.sendwithus.com/assets/img/emailmonks/images/spacer.gif\" width=\"1\" height=\"1\" /></td>\n" +
                            "            </tr>\n" +
                            "            <!-- === //NEVIGATION SECTION === -->\n" +
                            "            <!-- === IMG WITH TITLE TEXT MD CONTENT WITH COUPEN CODE SECTION === -->\n" +
                            "            <tr>\n" +
                            "              <td valign=\"top\" class=\"em_aside\">\n" +
                            "                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"35\" class=\"em_height\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:25px; font-weight:bold; line-height:80px; color:#30373b;\">찜한 강의</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"17\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td align=\"center\" class=\"em_font1\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:50px; font-weight:bold; line-height:100px; color:#30373b; text-transform:uppercase;\">" + lectureName +
                            "</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"20\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:18px; line-height:20px; color:#30373b;\">찜한 날짜: " + likesTime +
                            "</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"20\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"12\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"38\" class=\"em_height\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td align=\"center\">\n" +
                            "                      <img src='cid:lectureImg' style=\"display:block;font-family:'FISHfingers', Tahoma, Geneva, sans-serif; font-size:40px; line-height:42px; color:#feae39; text-transform:uppercase; letter-spacing:5px;\" border=\"0\" alt=\"\" class=\"em_full_img\" />\n" +
                            "                    </td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"34\" class=\"em_height\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:15px; line-height:22px; color:#999999;\">저희 Class101을 이용해주셔서 정말 감사합니다.<br class=\"em_hide\" />\n" +
                            "                      Class101에서 더 좋은 강의를 만나보세요!<br class=\"em_hide\"/>\n" +
                            "                    </td>\n" +
                            "                  </tr>\n" +
                            "                  <tr>\n" +
                            "                    <td height=\"31\" class=\"em_height\">&nbsp;</td>\n" +
                            "                  </tr>\n" +
                            "                </table>\n" +
                            "              </td>\n" +
                            "            </tr>\n" +
                            "            <!-- === //IMG WITH TITLE TEXT MD CONTENT WITH COUPEN CODE SECTION === -->\n" +
                            "          </table>\n" +
                            "        </td>\n" +
                            "      </tr>\n" +
                            "      <!-- === //BOSY === -->\n" +
                            "      <!-- === FOOTER SECTION === -->\n" +
                            "      <tr>\n" +
                            "        <td align=\"center\" valign=\"top\"  bgcolor=\"#30373b\" class=\"em_aside\">\n" +
                            "          <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" class=\"em_main_table\" style=\"table-layout:fixed;\">\n" +
                            "            <tr>\n" +
                            "              <td height=\"35\" class=\"em_height\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"22\" class=\"em_height\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"10\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:12px; line-height:18px; color:#848789;text-transform:uppercase;\">\n" +
                            "                &copy;2&zwnj;016 company name. All Rights Reserved.\n" +
                            "              </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"10\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td align=\"center\" style=\"font-family:'Open Sans', Arial, sans-serif; font-size:12px; line-height:18px; color:#848789;text-transform:uppercase;\">\n" +
                            "                If you do not wish to receive any further emails from us, please  <span style=\"text-decoration:underline;\"><a href=\"#\" target=\"_blank\" style=\"text-decoration:underline; color:#848789;\">unsubscribe</a></span>\n" +
                            "              </td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "              <td height=\"35\" class=\"em_height\">&nbsp;</td>\n" +
                            "            </tr>\n" +
                            "          </table>\n" +
                            "        </td>\n" +
                            "      </tr>\n" +
                            "      <!-- === //FOOTER SECTION === -->\n" +
                            "    </table>\n" +
                            "    <div style=\"display:none; white-space:nowrap; font:20px courier; color:#ffffff; background-color:#ffffff;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</div>\n" +
                            "  </body>\n" +
                            "</html>\n";

                    helper.setFrom(from);
                    helper.setTo(userInfo.getUserEmail());
                    helper.setSubject(subject);

                    helper.setText(text,true);
                    String root_path = servletContext.getRealPath("/");
                    String path = root_path + lecInfo.getLecImg();;

                    System.out.println(path);

                    helper.addInline("Logoimg",
                            new File(root_path+"/resources/img/logo_final.png"));
                    helper.addInline("lectureImg",new File(path));

                }
            };

            mailSender.send(preparator);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
