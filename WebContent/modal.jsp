<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
        .overlay{
            height: 100%;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            background-color: rgba(45, 45, 51, 0.7);
            z-index: 10;
        }
        .modal {
          position: absolute;
          background-color: rgba(255, 255, 255, 0.8);
          top: 20px;
          left: 50%;
          padding: 10px;
          border: 2px solid black;
        }
        .close{
            cursor: pointer;
        }
        #title {
            text-align: center;
        }


    </style>

    </head>
    <body style="background-color: #eae8ed;">

        <button id="btn" value="open" >Open Modal</button>

        <div class="overlay">
          <div class="modal" id="modal">
            <!-- close trigger -->
            <div id="title">
                <span>Login</span>
                <span style="float:right; margin-right: 15px;" class="close">&times;</span>
            </div>

            <!-- modal content -->
            <div class="modal-content" style="text-align:center;">

            <p>
                Username:<input type="text" name="username" id="username" />
            </p>
            <p>
                Password:<input type="text" name="password" id="password" />
            </p>

            <p style="text-align:right; margin-right: 180px;">
                <a href="#">Forgot Password ?</a><input type="button" name="submit" id="submit" value="Login"/>
            </p>

            </div>
          </div>
        </div>

<script>
var $showmodal = $("#btn");
var $overlay = $(".overlay");
var $modal = $(".modal");
var $close = $(".close");

var login = new Object();
login.username = "Junaid";
login.password = "784692";

$(document).ready(function(e){

    $overlay.hide();

});

$showmodal.on('click',function(e){
    e.preventDefault();

    var windowheight = $(window).height();
    var windowwidth = $(window).width();
    var modalwidth = windowwidth/2;

    $overlay.show();
    $modal.css({
        'width':modalwidth,
        'margin-left':-modalwidth/2

    });
    addData(login);
});

$overlay.on('click',function(e){
    if(e.target !== this){
        return;
    }
    $overlay.hide();
});

$close.on('click',function(e){
    $overlay.hide();
});



function addData(data){
    $("#username").val(data.username);
    $("#password").val(data.password);
}






</script>
