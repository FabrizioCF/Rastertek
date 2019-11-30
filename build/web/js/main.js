/* 
 * To change this license header, choose License Headers in 
 * Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("ul.list-group li").next("ul").hide();

    $("ul.list-group li").click(function () {
        $(this).next("ul").slideToggle();
    });

    $(".Raster-sidebar-subtema li").click(function () {
        $('.Raster-sidebar-subtema').children().removeClass("subTema-actual");
        $(this).addClass("subTema-actual");
    });

    $("#confirmPass").on('keyup', function () {
        if ($("#Pass").val() === $(this).val()) {
            $(this).removeClass("notMatch");
            $(this).addClass("match");
        } else {
            $(this).removeClass("match");
            $(this).addClass("notMatch");
        }
    });

    $("#signupForm").submit(function () {
        if ($("#confirmPass").hasClass("notMatch")) {
            return false;
        } else {
            return true;
        }
    });

    $("#imagenTutorial").change(function (e) {
        var fileName = e.target.files[0].name;
        $("#id_imagenTutorial").text(fileName);
    });
    
    $(".Raster-sidebar-subtema li.Raster-sidebar-tema").click(function () {
        $("#tema_header").html($(this).text());
    });

    /*$(".ver-todos").click(function () {
        $(this).siblings(".temas-hidden").slideToggle();
    });*/


    /*
     $("#0101").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0101").show();
     
     });
     $("#0102").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0102").show();
     });
     $("#0103").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0103").show();
     });
     $("#0104").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0104").show();
     });
     $("#0105").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0105").show();
     });
     $("#0106").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0106").show();
     });
     $("#0107").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0107").show();
     });
     $("#0108").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0108").show();
     });
     $("#0109").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0109").show();
     });
     $("#0110").click(function () {
     $("div.container.Raster-content").hide();
     $("#Tut0110").show();
     });
     */

});