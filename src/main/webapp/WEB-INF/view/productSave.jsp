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
                <button id="submit" type="submit" class="btn btn-primary">상품등록완료</button>

            </form>
        </div>

        <script>
        // 상품명 중복체크
            $('#CheckproductName').on('click', function () {
                $.ajax({
                    url: '/productSave/checkName/',
                    type: 'post',
                    data: {  name: $('#name').val() },

                }).done((res) => {
                    alert("등록 가능한 상품입니다")
                    console.log(res);

                }).fail((err) => {
                    alert("이미 등록한 상품입니다")
                    console.log(err);
                });
            });
        
        // 동일 상품명 등록하지 못하게 처리하는 이벤트
        $('form').on('submit', function(e) {
            e.preventDefault(); // 기본 제출 이벤트를 중단

            $.ajax({
                url: '/productSave/checkName/',
                type: 'post',
                data: {
                name: $('#name').val()
                }
            }).done(function(res) {
                // 서버에서 반환된 결과가 성공일 경우 상품을 등록
                $('form')[0].submit();
            }).fail(function(err) {
                // 서버에서 반환된 결과가 실패일 경우 등록하지 않음
                alert('이미 등록한 상품입니다');
            });
        });
        </script>
        <%@ include file="layout/footer.jsp" %>