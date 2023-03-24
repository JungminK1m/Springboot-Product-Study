<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="layout/header.jsp" %>
        <div class="container">
            <form action="/product/save" method="post">
                <div class="mb-3 mt-3">
                    상품명 : <input id="name" name="name" type="text" placeholder="상품명을 적어주세요">
                    <button id="CheckproductName" type="button">중복확인</button>
                    <div id="Checkresult"></div>

                </div>
                <div class="mb-3 mt-3">
                    상품가격 : <input id="price" name="price" type="text" placeholder="상품 가격을 적어주세요">
                </div>
                <div class="mb-3 mt-3">
                    상품수량 : <input id="qty" name="qty" type="text" placeholder="상품 수량을 적어주세요">
                </div>
                <button type="submit" class="btn btn-primary">상품등록완료</button>

            </form>
        </div>

        <script>
            $('#CheckproductName').on('click', function () {
                $.ajax({
                    url: '/productSave/checkName/',
                    type: 'post',
                    data: { name: $('input[name=name]').val() },

                }).done((res) => {
                    console.log(res);

                }).fail((err) => {
                    alert("이미 등록한 상품입니다")
                    console.log(err);
                });
            });
        </script>
        <%@ include file="layout/footer.jsp" %>