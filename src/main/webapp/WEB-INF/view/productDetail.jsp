<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="layout/header.jsp" %>

        <div>
            <div style="margin: 20px;">
                <table border="1" style="width: 200px; height: 200px; text-align: center;">
                    <tr style="border: 1px solid">
                        <th style="background-color: rgb(185, 185, 185)">상품명</th>
                        <th>${product.name}</th>
                    </tr>
                    <tr style="border: 1px solid">
                        <th style="background-color: rgb(185, 185, 185)">상품명</th>
                        <td>${product.price}원</td>
                    </tr>
                    <tr style="border: 1px solid">
                        <th style="background-color: rgb(185, 185, 185)">상품명</th>
                        <td>${product.qty}개</td>
                    </tr>
                </table>
                <div style="margin-top: 20px;">
                    <button type="button">수정하기</button> <br>
                    <button type="button">삭제하기</button>
                </div>
            </div>
        </div>