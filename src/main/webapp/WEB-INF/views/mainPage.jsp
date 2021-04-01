<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            margin: 50px 180px;
        }

        #notice_btn {
            border-top-left-radius: 30px;
            border-top-right-radius: 30px;
            border-bottom-left-radius: 30px;
            border-bottom-right-radius: 30px;
            padding: 5px 30px;
            border: 0;
        }

        #cart_btn {
            padding: 20px 30px;
            border: 0;
        }

        .icon_section_img {
            width: 55px;
            height: 55px;
        }

        .icon_section_width {
            float: left;
            width: 16.6%;
        }

        .banner {
            vertical-align: middle;
            float: left;
            position: relative;
            top: 50%;
            left: 2%;
            transform: translateY(-50%);
        }

        .price {
            position: absolute; 
            top:calc(50% - 3px); 
            right: 0px; 
            height: 5px; 
            vertical-align: middle; 
            border-style: none; 
            box-sizing: border-box;
        }
    </style>
    <script language="JavaScript">
        <!--
        function clock() {
            var time = new Date()

            var hour = time.getHours()
            var minute = time.getMinutes()
            var second = time.getSeconds()
            var store = " "

            store += ((hour > 12) ? (hour - 12) : hour)
            store += ((minute < 10) ? ":0" : ":") + minute
            store += ((second < 10) ? ":0" : ":") + second
            store += (hour >= 12) ? " P.M" : " A.M"

            document.time.clock.value = store
            setTimeout("clock()", 1000)
        }
        //-->
    </script>
</head>

<body onload="clock()">

    <div>
        <section> <!--여긴 왜 가운데 정렬이 안 될까. 왜 말을 안 들을까 애들이.... 죽고싶나아아아아앙아ㅏㅏ아아아제발-->
            <div class="icon_section_width">
                <div>
                    <img class=icon_section_img
                        src="https://class101.net/images/promotions/101-world/guide/im-101-world-free-klass.png"
                        alt="오늘의 0원">
                </div>
                <div>오늘의 0원</div>
            </div>

            <div class="icon_section_width">
                <div>
                    <img class=icon_section_img
                        src="https://class101.net/images/promotions/101-world/guide/im-101-world-24hours.png"
                        alt="단 24시간">
                </div>
                <div>단 24시간</div>
            </div>
            <div class="icon_section_width">
                <div>
                    <img class=icon_section_img
                        src="https://class101.net/images/promotions/101-world/guide/im-101-world-65percent.png"
                        alt="최대 65%">
                </div>
                <div>최대 65%</div>
            </div>
            <div class="icon_section_width">
                <div>
                    <img class=icon_section_img
                        src="https://class101.net/images/promotions/101-world/guide/im-101-world-free-kit.png"
                        alt="준비물 무료">
                </div>
                <div>준비물 무료</div>
            </div>
            <div class="icon_section_width">
                <div>
                    <img class=icon_section_img
                        src="https://class101.net/images/promotions/101-world/guide/im-101-world-big.png" alt="BIG 이용권">
                </div>
                <div>BIG 이용권</div>
            </div>
            <div class="icon_section_width">
                <div>
                    <img class=icon_section_img
                        src="https://class101.net/images/promotions/101-world/guide/im-101-world-kids.png" alt="키즈존 할인">
                </div>
                <div>키즈존 할인</div>
            </div>

            <!--<div style="height: 100px;"></div>-->
        </section>
    </div>


    <div style="clear: both; height: 50px;"></div>
    <div style="background-color:#58ACFA; color:white; height: 100px;">
        <span class="banner">오늘의 0원 클래스와 찰떡! 24시간 최저가 진행중 > </span>
    </div>

    <div>
        <div style="float: left; margin: 50px auto;">
            <form name="time">
                
                <h2 font-weight="bold">오늘의 0원 종료까지</h2>
                <input name="clock" size="12" value="" style="border:0">
            </form>
            <h5 style="color: gray;">매일 오후 2시! 다른 클래스와 함께 구매 시 오늘만 무료</h5>
        </div>
        <div style="float: right; margin: 100px auto;">
            <button style="float: right;" id="notice_btn">매일 달라지는 혜택 받기&nbsp;&nbsp;
                <img width="15" height="15" src="https://static.thenounproject.com/png/632304-200.png" alt="notice">
            </button>
        </div>
    </div>

    <article style="clear: both;">
        <div style="display: flex;">
            <div style="float:left; width: 53%;">
                <img src="https://cdn.class101.net/images/759352d1-a1cc-40f9-a0a6-b349af2727b2/640xauto" ,
                     alt="illustration">
            </div>
            <div style="background-color: rgb(250, 250, 250); float:left; padding: 30px 40px; width: 47%;">
                <div> <!--왜 말을 안 듣지 정렬이 안 됨 왜지?-->
                    <!--나중에 테이블로 다시 만들기-->
                    <h5>보람</h5>
                    <h2>연필과 종이로 만들어내는 동화 일러스트</h2>
                </div>

                <!--여기서부터-->
                <div style="overflow: hidden; position: relative; font-size: 16px; line-height: 24px; display: flex;">
                    279,000원
                    <img class="price" src="https://class101.net/images/reward-adventure/arrow.png"/>
                </div>
                <div>
                    <span style="color: blue;">오늘만 0원
                    </span>
                </div>
                <button id="cart_btn" style="width: 100%; background-color: blue; color: white;">
                <img style="-webkit-filter: opacity(.5) drop-shadow(0 0 0 white);
                        filter:opacity(.5) drop-shadow(0 0 0 white)" width="15" height="15" src="https://static.thenounproject.com/png/1363637-200.png"/>&nbsp;&nbsp;지금 마법 카트에 담기</button>
                        <!--여기까지가 하단 정렬이 되어야 한다고-->
            </div>
        </div>
    </article>
    </section>
</body>

</html>