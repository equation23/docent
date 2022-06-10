<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Travel Docent</title>

    <!-- Custom fonts for this template-->
    <link href="http://106.241.252.54:8088/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://106.241.252.54:8088/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="../../../resources/css/select.css" rel="stylesheet">


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href='/tr/main'>
            <div class="sidebar-brand-icon">
                <i class="fa-solid fa-person-walking-luggage"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Travel Docent</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href='/tr/notice'>
                <i class="fa-regular fa-bell"></i>
                <span>공지사항</span></a>
        </li>


        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href='/tr/list'>
                <i class="fa-solid fa-cubes"></i>
                <span>유적/유물 데이터</span></a>
        </li>
        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href='/tr/bot'>
                <i class="fa-solid fa-robot"></i>
                <span>챗봇</span></a>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href='/tr/statistics'>
                <i class="fas fa-fw fa-chart-area"></i>
                <span>통계</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href='/tr/member'>
                <i class="fas fa-fw fa-table"></i>
                <span>사용자 정보</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <%--                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."--%>
                        <%--                               aria-label="Search" aria-describedby="basic-addon2">--%>
                        <%--                        <div class="input-group-append">--%>
                        <%--                            <button class="btn btn-primary" type="button">--%>
                        <%--                                <i class="fas fa-search fa-sm"></i>--%>
                        <%--                            </button>--%>
                        <%--                        </div>--%>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <%--                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->--%>
                    <%--                    <li class="nav-item dropdown no-arrow d-sm-none">--%>
                    <%--                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"--%>
                    <%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--                            <i class="fas fa-search fa-fw"></i>--%>
                    <%--                        </a>--%>
                    <%--                        <!-- Dropdown - Messages -->--%>
                    <%--                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"--%>
                    <%--                             aria-labelledby="searchDropdown">--%>
                    <%--                            <form class="form-inline mr-auto w-100 navbar-search">--%>
                    <%--                                <div class="input-group">--%>
                    <%--                                    <input type="text" class="form-control bg-light border-0 small"--%>
                    <%--                                           placeholder="Search for..." aria-label="Search"--%>
                    <%--                                           aria-describedby="basic-addon2">--%>
                    <%--                                    <div class="input-group-append">--%>
                    <%--                                        <button class="btn btn-primary" type="button">--%>
                    <%--                                            <i class="fas fa-search fa-sm"></i>--%>
                    <%--                                        </button>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                            </form>--%>
                    <%--                        </div>--%>
                    <%--                    </li>--%>

                    <%--                    <!-- Nav Item - Alerts -->--%>
                    <%--                    <li class="nav-item dropdown no-arrow mx-1">--%>
                    <%--                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"--%>
                    <%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--                            <i class="fas fa-bell fa-fw"></i>--%>
                    <%--                            <!-- Counter - Alerts -->--%>
                    <%--                            <span class="badge badge-danger badge-counter">3+</span>--%>
                    <%--                        </a>--%>
                    <%--                        <!-- Dropdown - Alerts -->--%>
                    <%--                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"--%>
                    <%--                             aria-labelledby="alertsDropdown">--%>
                    <%--                            <h6 class="dropdown-header">--%>
                    <%--                                Alerts Center--%>
                    <%--                            </h6>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="mr-3">--%>
                    <%--                                    <div class="icon-circle bg-primary">--%>
                    <%--                                        <i class="fas fa-file-alt text-white"></i>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <div>--%>
                    <%--                                    <div class="small text-gray-500">December 12, 2019</div>--%>
                    <%--                                    <span class="font-weight-bold">A new monthly report is ready to download!</span>--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="mr-3">--%>
                    <%--                                    <div class="icon-circle bg-success">--%>
                    <%--                                        <i class="fas fa-donate text-white"></i>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <div>--%>
                    <%--                                    <div class="small text-gray-500">December 7, 2019</div>--%>
                    <%--                                    $290.29 has been deposited into your account!--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="mr-3">--%>
                    <%--                                    <div class="icon-circle bg-warning">--%>
                    <%--                                        <i class="fas fa-exclamation-triangle text-white"></i>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <div>--%>
                    <%--                                    <div class="small text-gray-500">December 2, 2019</div>--%>
                    <%--                                    Spending Alert: We've noticed unusually high spending for your account.--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>--%>
                    <%--                        </div>--%>
                    <%--                    </li>--%>

                    <%--                    <!-- Nav Item - Messages -->--%>
                    <%--                    <li class="nav-item dropdown no-arrow mx-1">--%>
                    <%--                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"--%>
                    <%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--                            <i class="fas fa-envelope fa-fw"></i>--%>
                    <%--                            <!-- Counter - Messages -->--%>
                    <%--                            <span class="badge badge-danger badge-counter">7</span>--%>
                    <%--                        </a>--%>
                    <%--                        <!-- Dropdown - Messages -->--%>
                    <%--                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"--%>
                    <%--                             aria-labelledby="messagesDropdown">--%>
                    <%--                            <h6 class="dropdown-header">--%>
                    <%--                                Message Center--%>
                    <%--                            </h6>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="dropdown-list-image mr-3">--%>
                    <%--                                    <img class="rounded-circle" src="http://106.241.252.54:8088/img/undraw_profile_1.svg"--%>
                    <%--                                         alt="...">--%>
                    <%--                                    <div class="status-indicator bg-success"></div>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="font-weight-bold">--%>
                    <%--                                    <div class="text-truncate">Hi there! I am wondering if you can help me with a--%>
                    <%--                                        problem I've been having.</div>--%>
                    <%--                                    <div class="small text-gray-500">Emily Fowler · 58m</div>--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="dropdown-list-image mr-3">--%>
                    <%--                                    <img class="rounded-circle" src="http://106.241.252.54:8088/img/undraw_profile_2.svg"--%>
                    <%--                                         alt="...">--%>
                    <%--                                    <div class="status-indicator"></div>--%>
                    <%--                                </div>--%>
                    <%--                                <div>--%>
                    <%--                                    <div class="text-truncate">I have the photos that you ordered last month, how--%>
                    <%--                                        would you like them sent to you?</div>--%>
                    <%--                                    <div class="small text-gray-500">Jae Chun · 1d</div>--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="dropdown-list-image mr-3">--%>
                    <%--                                    <img class="rounded-circle" src="http://106.241.252.54:8088/img/undraw_profile_3.svg"--%>
                    <%--                                         alt="...">--%>
                    <%--                                    <div class="status-indicator bg-warning"></div>--%>
                    <%--                                </div>--%>
                    <%--                                <div>--%>
                    <%--                                    <div class="text-truncate">Last month's report looks great, I am very happy with--%>
                    <%--                                        the progress so far, keep up the good work!</div>--%>
                    <%--                                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item d-flex align-items-center" href="#">--%>
                    <%--                                <div class="dropdown-list-image mr-3">--%>
                    <%--                                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"--%>
                    <%--                                         alt="...">--%>
                    <%--                                    <div class="status-indicator bg-success"></div>--%>
                    <%--                                </div>--%>
                    <%--                                <div>--%>
                    <%--                                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone--%>
                    <%--                                        told me that people say this to all dogs, even if they aren't good...</div>--%>
                    <%--                                    <div class="small text-gray-500">Chicken the Dog · 2w</div>--%>
                    <%--                                </div>--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>--%>
                    <%--                        </div>--%>
                    <%--                    </li>--%>

                    <%--                    <div class="topbar-divider d-none d-sm-block"></div>--%>

                    <%--                    <!-- Nav Item - User Information -->--%>
                    <%--                    <li class="nav-item dropdown no-arrow">--%>
                    <%--                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"--%>
                    <%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>--%>
                    <%--                            <img class="img-profile rounded-circle"--%>
                    <%--                                 src="http://106.241.252.54:8088/img/undraw_profile.svg">--%>
                    <%--                        </a>--%>
                    <%--                        <!-- Dropdown - User Information -->--%>
                    <%--                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"--%>
                    <%--                             aria-labelledby="userDropdown">--%>
                    <%--                            <a class="dropdown-item" href="#">--%>
                    <%--                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>--%>
                    <%--                                Profile--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item" href="#">--%>
                    <%--                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>--%>
                    <%--                                Settings--%>
                    <%--                            </a>--%>
                    <%--                            <a class="dropdown-item" href="#">--%>
                    <%--                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>--%>
                    <%--                                Activity Log--%>
                    <%--                            </a>--%>
                    <%--                            <div class="dropdown-divider"></div>--%>
                    <%--                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">--%>
                    <%--                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>--%>
                    <%--                                Logout--%>
                    <%--                            </a>--%>
                    <%--                        </div>--%>
                    <%--                    </li>--%>

                    <%--                </ul>--%>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">메인</h1>


                <p style="margin-top:-12px">
                    <b>Chrome 브라우저는 https 환경에서만 geolocation을 지원합니다.</b> 참고해주세요.
                </p>
                <div id="map" style="width:100%;height:350px;"></div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    (function(d, m){
        var kommunicateSettings =
            {"appId":"202167a7f56e0db29364f2264282ebb0","popupWidget":true,"automaticChatOpenOnNavigation":true};
        var s = document.createElement("script"); s.type = "text/javascript"; s.async = true;
        s.src = "https://widget.kommunicate.io/v2/kommunicate.app";
        var h = document.getElementsByTagName("head")[0]; h.appendChild(s);
        window.kommunicate = m; m._globals = kommunicateSettings;
    })(document, window.kommunicate || {});
    /* NOTE : Use web server to view HTML files as real-time update will not work if you directly open the HTML file in the browser. */
</script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=06c294e1f66b2f5ab1e7bc5a46cd0311&libraries=services"></script>
<script>

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


    if (navigator.geolocation) {

        // GeoLocation을 이용해서 접속 위치를 얻어옵니다
        navigator.geolocation.getCurrentPosition(function(position) {

            var lat = position.coords.latitude, // 위도
                lon = position.coords.longitude; // 경도

            var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                message = '<div style="padding:5px;">현재 위치입니다</div>'; // 인포윈도우에 표시될 내용입니다

            // 마커와 인포윈도우를 표시합니다
            displayMarker(locPosition, message);

        });

    } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

        var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
            message = 'geolocation을 사용할수 없어요..'

        displayMarker(locPosition, message);
    }

    // 지도에 마커와 인포윈도우를 표시하는 함수입니다
    function displayMarker(locPosition, message) {

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: locPosition
        });

        var iwContent = message, // 인포윈도우에 표시할 내용
            iwRemoveable = true;

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
            content : iwContent,
            removable : iwRemoveable
        });

        // 인포윈도우를 마커위에 표시합니다
        infowindow.open(map, marker);

        // 지도 중심좌표를 접속위치로 변경합니다
        map.setCenter(locPosition);
    }
    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();
    // 주소로 좌표를 검색합니다
<c:forEach items="${dtoList}" var="board">
    geocoder.addressSearch('${board.location}', function(result, status) {

        // 정상적으로 검색이 완료됐으면
        if (status === kakao.maps.services.Status.OK) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">${board.title}</div>'
            });
            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
            kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            // map.setCenter(coords);
        }
    });
    </c:forEach>

    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
    function makeOverListener(map, marker, infowindow) {
        return function() {
            infowindow.open(map, marker);
        };
    }

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다
    function makeOutListener(infowindow) {
        return function() {
            infowindow.close();
        };
    }
</script>
</body>
</html>
<%--fontawsome--%>
<script src="https://kit.fontawesome.com/e4c9df973b.js" crossorigin="anonymous"></script>
<!-- Bootstrap core JavaScript-->
<script src="http://106.241.252.54:8088/vendor/jquery/jquery.min.js"></script>
<script src="http://106.241.252.54:8088/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="http://106.241.252.54:8088/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="http://106.241.252.54:8088/js/sb-admin-2.min.js"></script>

</body>

</html>