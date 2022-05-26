<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>로그인 페이지</title>

    <!-- Custom fonts for this template-->
    <link href="http://106.241.252.54:8088/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://106.241.252.54:8088/css/sb-admin-2.min.css" rel="stylesheet">


</head>

<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block"></div>
                        <div class="col-lg-6">

                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">여행자님 환영합니다!</h1>
                                </div>

                                <form class="loginForm" action="/login" method="post">

                                    <div class="form-group">
                                        <input class="form-control form-control-user" aria-describedby="emailHelp"
                                               placeholder="아이디를 입력하세요" name="username">
                                    </div>

                                    <div class="form-group">
                                        <input class="form-control form-control-user"
                                               placeholder="비밀번호를 입력하세요" name="password">
                                    </div>

                                    <div class="form-group">

                                    </div>

                                    <button class="btn btn-primary btn-user btn-block loginBtn">
                                        로그인
                                    </button>

                                    <%--                                    <div class="background show">--%>
                                    <%--                                        <div class="window">--%>
                                    <%--                                            <div class="popup">--%>
                                    <%--                                                <button class="closeBtn">팝업닫기</button>--%>
                                    <%--                                            </div>--%>
                                    <%--                                            <div>--%>
                                    <%--                                                <div></div>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>

                                </form>

                                <hr>

                                <div class="text-center">
                                    <a class="small findBtn" href='/board/find'>비밀번호 찾기</a>
                                </div>

                                <div class="text-center">
                                    <a class="small regBtn" href='/board/register'>회원가입</a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>

</div>


<!-- Bootstrap core JavaScript -->
<script src="http://106.241.252.54:8088/vendor/jquery/jquery.min.js"></script>
<script src="http://106.241.252.54:8088/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript -->
<script src="http://106.241.252.54:8088/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages -->
<script src="http://106.241.252.54:8088/js/sb-admin-2.min.js"></script>



</body>
</html>