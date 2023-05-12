# 쇼핑몰 프로젝트 1-2단계📦
- 1단계 (기본 CRUD + JSP)
- 2단계 (상품명 중복체크 Ajax)

<br/>

# 화면 구현 📺 

- 상품 목록보기
  - 상품 상세보기
- 상품 등록 페이지
- 상품 수정 페이지

<br/>

#### [상품 목록보기]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V1-V2/assets/118741874/6cbcd155-5fe9-46fa-9005-efe825e5ab23)
#### [상품 상세보기]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V1-V2/assets/118741874/ab7c57d6-1bf6-4034-afa7-0e65db61cd21)
#### [상품 등록하기]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V1-V2/assets/118741874/3e083d0f-b122-4df3-ae65-43344a34dc30)
#### [상품 수정하기]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V1-V2/assets/118741874/a632f1ed-c106-4b1e-95ae-d9e4bca16555)



<br/>
  
# 사용기술 🧪
![Springboot](https://img.shields.io/badge/-Springboot-6DB33F)
![Java](https://img.shields.io/badge/-Java-F09820)
![CSS](https://img.shields.io/badge/-CSS-1572B6)
![HTML](https://img.shields.io/badge/-HTML-E34F26)
![JS](https://img.shields.io/badge/-JavaScript-F7DF1E)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-7952B3)
![MyBatis](https://img.shields.io/badge/-MyBatis-B10000)
![H2](https://img.shields.io/badge/-H2Console-41BDF5)

<br/>

  
# 기능구현 🔧
#### ✔ 상품등록
- 상품명 Ajax 중복체크

```javascript
<script>

            // 중복체크 여부 = false - 아직 체크 안했으니까
            let sameCheck = false;

            // 상품명 중복체크
            $('#CheckproductName').on('click', function () {

                // 이렇게 데이터를 변수로 만들면 보기가 편하다
                let data = { name: $('#name').val() }

                $.ajax({
                    url: '/productSave/checkName/',
                    type: 'post',
                    data: data,
                    contentType: "application/x-www-form-urlencoded; charset=utf-8"

                }).done((res) => {
                    alert("등록 가능한 상품입니다")
                    // 콘솔창 확인용
                    console.log(res);
                    // 등록 가능하니까 체크 여부를 true로 변경
                    sameCheck = true;

                }).fail((err) => {
                    alert("이미 등록한 상품입니다")
                    // 콘솔창 확인용
                    console.log(err);
                    // 등록 불가이기 때문에 중복체크를 안한 것으로 설정 (아래에 이벤트 처리를 위해)
                    sameCheck = false;
                });
            });

            // 상품명을 입력하는 input 태그에 값이 변경될 때마다 sameCheck 를 false로 설정하는 이벤트
            // => false가 됐으니 상품명을 다른 걸로 바뀌면 꼭 중복체크를 다시 해야되게 만든다.
            $('#name').on('input', function (e) {
                sameCheck = false;
                console.log(sameCheck);
            });
        
            // 동일 상품명 등록하지 못하게 처리하는 이벤트 (최종 상품 등록 버튼)
            // form이 submit 될 때 실행되는 이벤트
            $('form').on('submit', function(e) {
                // == 주의
                if (sameCheck == false) {
                    alert("상품명 중복확인을 해 주세요.");
                    // e.preventDefault(); = 브라우저가 이벤트를 처리하는 동작을 중단시키는 메서드
                    // submit 이벤트를 중단시키기 위해 사용됨
                     e.preventDefault();
                     console.log(sameCheck);
                }else if (sameCheck == true) {
                    alert("상품이 등록되었습니다.");
                    console.log(sameCheck);
                }
            });
        </script>
```
   <br/>

# 테이블 생성 📁
```sql
create table product(
    id int primary KEY auto_increment,
    name varchar(20) NOT null UNIQUE,
    price INT NOT null,
    qty INT NOT null,
    created_at TIMESTAMP NOT null
);
```
# 더미 데이터 📰
```sql
INSERT INTO product(name, price, qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(name, price, qty, created_at) VALUES('딸기', 2000, 100, NOW());
```

