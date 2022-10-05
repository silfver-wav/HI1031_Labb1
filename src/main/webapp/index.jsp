<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Web Shop</title>
        <link rel="stylesheet" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <header>
            <!--Nav-->
            <div class="nav container">
                <a href="#" class="logo">Ecommerce</a>
                <!-- Cart-Icon -->
                <i class='bx bx-shopping-bag' id="cart-icon"></i>
                <% let cartIcon = document.querySelector("#cart-icon"); %>
                <!--Cart-->
                <div class="cart">
                    <h2 class="cart-title">Your Cart</h2>
                    <!--Content-->
                    <div class="cart-content">

                        <div class="cart-box">
                            <div class="detail-box">
                                <div class="cart-product-title">Apple</div>
                                <div class="cart-price">$25</div>
                                <input type="number" value="1" class="cart-quantity">
                            </div>
                            <!--Remove Cart-->
                            <i class='bx bxs-trash-alt cart-remove' ></i>
                        </div>
                    </div>
                    <!--Total-->
                    <div class="total">
                        <div class="total-title">Total</div>
                        <div class="total-price">$0</div>
                    </div>
                    <!--Buy Button-->
                    <button type="button" class="btn-buy">Buy</button>
                    <!--Cart Close-->
                    <i class="bx bx-x" id="close-cart"></i>
                </div>
            </div>
        </header>
        <!--Shop -->
        <section class="shop container">
            <h2 class="section-title"> Shop Products</h2>
            <divGif>
                <iframe src="https://giphy.com/embed/bRJRe4SUFyp2w" alt="" class="giphy"></iframe>
            </divGif>

            <!--Content-->
            <div class="product-box">
                <h2 class="product-title"> apple </h2>
                <p class="description">Red apples from southern Sweden</p>
                <span class="price">$25</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
        </section>


        <h1><%= "Web Shop" %>

        </h1>



        <br/>
            <a href="hello-servlet">Web Cart</a>
    </body>
</html>