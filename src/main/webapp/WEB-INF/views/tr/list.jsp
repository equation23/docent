
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
            <a class="nav-link" href='https://dialogflow.cloud.google.com/#/agent/newagent-nsfe/intents'>
                <i class="fa-solid fa-robot"></i>
                <span>챗봇</span></a>
        </li>

        <!-- Nav Item - Charts -->
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href='/tr/statistics'>--%>
<%--                <i class="fas fa-fw fa-chart-area"></i>--%>
<%--                <span>통계</span></a>--%>
<%--        </li>--%>

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
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">


                    <div class="input-group searchDiv">
                        <div class="select">
                        <select class="type">
                            <option value="t" ${listDTO.type =="t"?"selected":""}>이름</option>
                            <option value="c" ${listDTO.type =="c"?"selected":""}>지역</option>
                            <option value="w" ${listDTO.type =="w"?"selected":""}>설명</option>
                        </select>
                        </div>
                        <input type="text" class="form-control bg-light border-0 small searchKey" name="keyword" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2" value="${listDTO.keyword}">
                        <div class="input-group-append">
                            <button class="btn btn-primary searchBtn" type="submit">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>

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
<%--                <h1 class="h3 mb-4 text-gray-800">목록</h1>--%>
                <ul class="dtoList">
                    <c:forEach items="${dtoList}" var="board">
                        <div class="card pictures" style="width: 18rem;">
                            <c:if test="${board.image != null}">
                            <img src='/view?fileName=${board.image}'  class="card-img-top card" style="width:200px; height: 200px;margin:auto; border: 0" >
                            </c:if>
                            <c:if test="${board.image == null}">
                                <img src='/defaultImage?fileName=no_image.jpg'  class="card-img-top card" style="width:200px; height: 200px;margin:auto; border: 0" >
                            </c:if>
                            <div class="card-body">
                                <p style="text-align:center" class="card-text">${board.classify}</p>
                                <h5 style="text-align:center" class="card-title">${board.title}</h5>
                                <a href='/tr/read/${board.bno}' class="btn btn-primary dtoLink">정보 보기</a>
                            </div>

                        </div>
                    </c:forEach>
                </ul>


                <ul class="pagination">
                    <c:if test="${pageMaker.prev}">
                    <li class="page-item">
                        <a class="page-link" href="${pageMaker.start-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                        </c:if>
                    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
                        <li class="page-item <c:out value="${pageMaker.page == num ? 'active' :'' }"/> ">
                            <a class="page-link" href="${num}">${num}</a></li>
                </c:forEach>
                        <c:if test="${pageMaker.next}">
                    <li class="page-item">
                        <a class="page-link" href="${pageMaker.end + 1 }" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                        </c:if>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
        <style>
            .dtoList {
                display: flex;
                flex-wrap: wrap;
            }
        </style>
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
<form class="actionForm" action="/tr/list" method="get">
    <input type="hidden" name="page" value="${listDTO.page}">
    <input type="hidden" name="size" value="${listDTO.size}">
    <input type="hidden" name="type" value="${listDTO.type == null?'':listDTO.type}">
    <input type="hidden" name="keyword" value="${listDTO.keyword == null? '':listDTO.keyword}">
</form>
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
<script>

    const linkDiv = document.querySelector(".pagination")
    const actionForm = document.querySelector(".actionForm")


    document.querySelector(".dtoList").addEventListener("click",(e)=> {

        e.preventDefault()
        e.stopPropagation()

        const target = e.target
        if(target.getAttribute("class").indexOf('dtoLink') < 0){
            return
        }
        const url = target.getAttribute("href")
        //alert(url)
        actionForm.setAttribute("action", url)
        actionForm.submit()

    }, false)
    linkDiv.addEventListener("click", (e) => {
        e.stopPropagation()
        e.preventDefault()

        const target = e.target

        if(target.getAttribute("class") !== 'page-link'){
            return
        }

        const pageNum = target.getAttribute("href")
        actionForm.querySelector("input[name='page']").value = pageNum
        actionForm.setAttribute("action","/tr/list")
        actionForm.submit()

    },false)


    document.querySelector(".searchBtn").addEventListener("click",(e)=> {
        e.preventDefault()
        e.stopPropagation()
        const type = document.querySelector('.searchDiv .type').value
        const keyword = document.querySelector(".searchDiv input[name='keyword']").value

        actionForm.setAttribute("action","/tr/list")
        actionForm.querySelector("input[name='page']").value = 1
        actionForm.querySelector("input[name='type']").value = type
        actionForm.querySelector("input[name='keyword']").value = keyword
        actionForm.submit()
    },false)

</script>
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