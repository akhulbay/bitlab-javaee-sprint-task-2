<%@ page import="java.util.List" %>
<%@ page import="com.example.sprinttaskee2.entity.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body style="background-color: #f2f2f2">

<%@include file="vendor/navbar.jsp"%>

<div class="container">
    <div class="row mt-3">
        <div class="col-sm-8 mx-auto">
            <h2 class="text-center" style="font-weight: 700">Welcome to BITLAB SHOP</h2>
            <p class="text-center">Electronic devices with high quality and service</p>


            <div class="row row-cols-3 d-flex" style="justify-content: space-between">
                <%
                    List<Item> items = (List<Item>) request.getAttribute("items");
                    if (items != null) {
                        for (Item item : items) {

                %>
                <div class="card col mt-3" style="width: 270px">
                    <h5 class="text-center pt-3 pb-3" style="background-color: #f7f7f7"><%=item.getName()%>
                    </h5>
                    <div class="card-body text-center">
                        <h3 class="card-title" style="color:#00894f"><%=item.getPrice()%>$
                        </h3>
                        <p class="card-text" style="white-space: pre-line; font-size: 14px"><%=item.getDescription()%>
                        </p>
                        <div class="d-grid gap-2">
                            <a href="#" class="btn btn-success btn-sm">Buy Now</a>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>

        </div>


    </div>
</div>

</div>
</body>
</html>
